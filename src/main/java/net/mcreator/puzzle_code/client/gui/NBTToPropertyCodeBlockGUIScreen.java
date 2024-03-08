package net.mcreator.puzzle_code.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.puzzle_code.world.inventory.NBTToPropertyCodeBlockGUIMenu;
import net.mcreator.puzzle_code.procedures.ReturnSetPropertyProcedure;
import net.mcreator.puzzle_code.procedures.ReturnGetNBTProcedure;
import net.mcreator.puzzle_code.network.NBTToPropertyCodeBlockGUIButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class NBTToPropertyCodeBlockGUIScreen extends AbstractContainerScreen<NBTToPropertyCodeBlockGUIMenu> {
	private final static HashMap<String, Object> guistate = NBTToPropertyCodeBlockGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox getNBTField;
	EditBox setPropertyField;
	ImageButton imagebutton_enter_button;
	ImageButton imagebutton_edit_button;
	ImageButton imagebutton_edit_button1;
	ImageButton imagebutton_enter_button1;

	public NBTToPropertyCodeBlockGUIScreen(NBTToPropertyCodeBlockGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 174;
		this.imageHeight = 110;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/screens/nbt_to_property_code_block_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		getNBTField.render(guiGraphics, mouseX, mouseY, partialTicks);
		setPropertyField.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("puzzle_code:textures/screens/puzzle_jump_logo.png"), this.leftPos + 149, this.topPos + 6, 0, 0, -1, -1, -1, -1);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (getNBTField.isFocused())
			return getNBTField.keyPressed(key, b, c);
		if (setPropertyField.isFocused())
			return setPropertyField.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		getNBTField.tick();
		setPropertyField.tick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.nbt_to_property_code_block_gui.label_from_nbt_bnbttextgetnbt"), 5, 42, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.nbt_to_property_code_block_gui.label_to_property_bnbttextsetprope"), 5, 92, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnGetNBTProcedure.execute(world, x, y, z), 59, 42, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnSetPropertyProcedure.execute(world, x, y, z), 73, 92, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.nbt_to_property_code_block_gui.label_nbt_getnbt"), 5, 29, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.nbt_to_property_code_block_gui.label_nbt_setproperty"), 5, 78, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		getNBTField = new EditBox(this.font, this.leftPos + 6, this.topPos + 7, 111, 18, Component.translatable("gui.puzzle_code.nbt_to_property_code_block_gui.getNBTField"));
		getNBTField.setMaxLength(32767);
		guistate.put("text:getNBTField", getNBTField);
		this.addWidget(this.getNBTField);
		setPropertyField = new EditBox(this.font, this.leftPos + 6, this.topPos + 57, 111, 18, Component.translatable("gui.puzzle_code.nbt_to_property_code_block_gui.setPropertyField"));
		setPropertyField.setMaxLength(32767);
		guistate.put("text:setPropertyField", setPropertyField);
		this.addWidget(this.setPropertyField);
		imagebutton_enter_button = new ImageButton(this.leftPos + 145, this.topPos + 6, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_enter_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new NBTToPropertyCodeBlockGUIButtonMessage(0, x, y, z));
				NBTToPropertyCodeBlockGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_enter_button", imagebutton_enter_button);
		this.addRenderableWidget(imagebutton_enter_button);
		imagebutton_edit_button = new ImageButton(this.leftPos + 122, this.topPos + 6, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_edit_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new NBTToPropertyCodeBlockGUIButtonMessage(1, x, y, z));
				NBTToPropertyCodeBlockGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_edit_button", imagebutton_edit_button);
		this.addRenderableWidget(imagebutton_edit_button);
		imagebutton_edit_button1 = new ImageButton(this.leftPos + 122, this.topPos + 56, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_edit_button1.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new NBTToPropertyCodeBlockGUIButtonMessage(2, x, y, z));
				NBTToPropertyCodeBlockGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_edit_button1", imagebutton_edit_button1);
		this.addRenderableWidget(imagebutton_edit_button1);
		imagebutton_enter_button1 = new ImageButton(this.leftPos + 145, this.topPos + 56, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_enter_button1.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new NBTToPropertyCodeBlockGUIButtonMessage(3, x, y, z));
				NBTToPropertyCodeBlockGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_enter_button1", imagebutton_enter_button1);
		this.addRenderableWidget(imagebutton_enter_button1);
	}
}
