package net.mcreator.puzzle_code.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.puzzle_code.world.inventory.NeutralCodeBlockGUIMenu;
import net.mcreator.puzzle_code.procedures.ReturnNBTValueProcedure;
import net.mcreator.puzzle_code.procedures.ReturnNBTTypeProcedure;
import net.mcreator.puzzle_code.procedures.ReturnNBTNameProcedure;
import net.mcreator.puzzle_code.network.NeutralCodeBlockGUIButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class NeutralCodeBlockGUIScreen extends AbstractContainerScreen<NeutralCodeBlockGUIMenu> {
	private final static HashMap<String, Object> guistate = NeutralCodeBlockGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox NBTNameField;
	EditBox NBTValueField;
	Button button_number;
	Button button_logic;
	Button button_text;
	ImageButton imagebutton_edit_button;
	ImageButton imagebutton_enter_button;
	ImageButton imagebutton_edit_button1;
	ImageButton imagebutton_enter_button1;

	public NeutralCodeBlockGUIScreen(NeutralCodeBlockGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/screens/neutral_code_block_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		NBTNameField.render(guiGraphics, mouseX, mouseY, partialTicks);
		NBTValueField.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (NBTNameField.isFocused())
			return NBTNameField.keyPressed(key, b, c);
		if (NBTValueField.isFocused())
			return NBTValueField.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		NBTNameField.tick();
		NBTValueField.tick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.neutral_code_block_gui.label_selected_nbt"), 6, 30, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.neutral_code_block_gui.label_nbt"), 6, 43, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.neutral_code_block_gui.label_nbt_type"), 6, 84, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.neutral_code_block_gui.label_nbt_nbttype"), 6, 97, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.neutral_code_block_gui.label_value"), 6, 138, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnNBTNameProcedure.execute(world, x, y, z), 78, 30, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnNBTTypeProcedure.execute(world, x, y, z), 60, 84, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnNBTValueProcedure.execute(world, x, y, z), 42, 138, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.neutral_code_block_gui.label_nbt_nbtvalue"), 6, 151, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		NBTNameField = new EditBox(this.font, this.leftPos + 7, this.topPos + 8, 111, 18, Component.translatable("gui.puzzle_code.neutral_code_block_gui.NBTNameField"));
		NBTNameField.setMaxLength(32767);
		guistate.put("text:NBTNameField", NBTNameField);
		this.addWidget(this.NBTNameField);
		NBTValueField = new EditBox(this.font, this.leftPos + 7, this.topPos + 116, 111, 18, Component.translatable("gui.puzzle_code.neutral_code_block_gui.NBTValueField"));
		NBTValueField.setMaxLength(32767);
		guistate.put("text:NBTValueField", NBTValueField);
		this.addWidget(this.NBTValueField);
		button_number = Button.builder(Component.translatable("gui.puzzle_code.neutral_code_block_gui.button_number"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new NeutralCodeBlockGUIButtonMessage(0, x, y, z));
				NeutralCodeBlockGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 61, 54, 20).build();
		guistate.put("button:button_number", button_number);
		this.addRenderableWidget(button_number);
		button_logic = Button.builder(Component.translatable("gui.puzzle_code.neutral_code_block_gui.button_logic"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new NeutralCodeBlockGUIButtonMessage(1, x, y, z));
				NeutralCodeBlockGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 65, this.topPos + 61, 54, 20).build();
		guistate.put("button:button_logic", button_logic);
		this.addRenderableWidget(button_logic);
		button_text = Button.builder(Component.translatable("gui.puzzle_code.neutral_code_block_gui.button_text"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new NeutralCodeBlockGUIButtonMessage(2, x, y, z));
				NeutralCodeBlockGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 123, this.topPos + 61, 45, 20).build();
		guistate.put("button:button_text", button_text);
		this.addRenderableWidget(button_text);
		imagebutton_edit_button = new ImageButton(this.leftPos + 123, this.topPos + 7, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_edit_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new NeutralCodeBlockGUIButtonMessage(3, x, y, z));
				NeutralCodeBlockGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_edit_button", imagebutton_edit_button);
		this.addRenderableWidget(imagebutton_edit_button);
		imagebutton_enter_button = new ImageButton(this.leftPos + 146, this.topPos + 7, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_enter_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new NeutralCodeBlockGUIButtonMessage(4, x, y, z));
				NeutralCodeBlockGUIButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:imagebutton_enter_button", imagebutton_enter_button);
		this.addRenderableWidget(imagebutton_enter_button);
		imagebutton_edit_button1 = new ImageButton(this.leftPos + 123, this.topPos + 115, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_edit_button1.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new NeutralCodeBlockGUIButtonMessage(5, x, y, z));
				NeutralCodeBlockGUIButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:imagebutton_edit_button1", imagebutton_edit_button1);
		this.addRenderableWidget(imagebutton_edit_button1);
		imagebutton_enter_button1 = new ImageButton(this.leftPos + 146, this.topPos + 115, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_enter_button1.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new NeutralCodeBlockGUIButtonMessage(6, x, y, z));
				NeutralCodeBlockGUIButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		});
		guistate.put("button:imagebutton_enter_button1", imagebutton_enter_button1);
		this.addRenderableWidget(imagebutton_enter_button1);
	}
}
