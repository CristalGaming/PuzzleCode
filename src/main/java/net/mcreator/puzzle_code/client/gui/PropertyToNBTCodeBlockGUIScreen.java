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

import net.mcreator.puzzle_code.world.inventory.PropertyToNBTCodeBlockGUIMenu;
import net.mcreator.puzzle_code.procedures.ReturnSetNBTProcedure;
import net.mcreator.puzzle_code.procedures.ReturnGetPropertyProcedure;
import net.mcreator.puzzle_code.network.PropertyToNBTCodeBlockGUIButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class PropertyToNBTCodeBlockGUIScreen extends AbstractContainerScreen<PropertyToNBTCodeBlockGUIMenu> {
	private final static HashMap<String, Object> guistate = PropertyToNBTCodeBlockGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox getPropertyField;
	EditBox setNBTField;
	ImageButton imagebutton_enter_button;
	ImageButton imagebutton_edit_button;
	ImageButton imagebutton_enter_button1;
	ImageButton imagebutton_edit_button1;

	public PropertyToNBTCodeBlockGUIScreen(PropertyToNBTCodeBlockGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 174;
		this.imageHeight = 110;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/screens/property_to_nbt_code_block_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		getPropertyField.render(guiGraphics, mouseX, mouseY, partialTicks);
		setNBTField.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (getPropertyField.isFocused())
			return getPropertyField.keyPressed(key, b, c);
		if (setNBTField.isFocused())
			return setNBTField.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		getPropertyField.tick();
		setNBTField.tick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.property_to_nbt_code_block_gui.label_from_property_bnbttextgetpro"), 5, 29, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.property_to_nbt_code_block_gui.label_to_nbt_bnbttextsetnbt"), 5, 78, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnGetPropertyProcedure.execute(world, x, y, z), 82, 29, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnSetNBTProcedure.execute(world, x, y, z), 46, 78, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.property_to_nbt_code_block_gui.label_nbt_getproperty"), 5, 42, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.property_to_nbt_code_block_gui.label_nbt_setnbt"), 5, 92, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		getPropertyField = new EditBox(this.font, this.leftPos + 6, this.topPos + 7, 111, 18, Component.translatable("gui.puzzle_code.property_to_nbt_code_block_gui.getPropertyField")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.puzzle_code.property_to_nbt_code_block_gui.getPropertyField").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.puzzle_code.property_to_nbt_code_block_gui.getPropertyField").getString());
				else
					setSuggestion(null);
			}
		};
		getPropertyField.setSuggestion(Component.translatable("gui.puzzle_code.property_to_nbt_code_block_gui.getPropertyField").getString());
		getPropertyField.setMaxLength(32767);
		guistate.put("text:getPropertyField", getPropertyField);
		this.addWidget(this.getPropertyField);
		setNBTField = new EditBox(this.font, this.leftPos + 6, this.topPos + 57, 111, 18, Component.translatable("gui.puzzle_code.property_to_nbt_code_block_gui.setNBTField")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.puzzle_code.property_to_nbt_code_block_gui.setNBTField").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.puzzle_code.property_to_nbt_code_block_gui.setNBTField").getString());
				else
					setSuggestion(null);
			}
		};
		setNBTField.setSuggestion(Component.translatable("gui.puzzle_code.property_to_nbt_code_block_gui.setNBTField").getString());
		setNBTField.setMaxLength(32767);
		guistate.put("text:setNBTField", setNBTField);
		this.addWidget(this.setNBTField);
		imagebutton_enter_button = new ImageButton(this.leftPos + 145, this.topPos + 6, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_enter_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new PropertyToNBTCodeBlockGUIButtonMessage(0, x, y, z));
				PropertyToNBTCodeBlockGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_enter_button", imagebutton_enter_button);
		this.addRenderableWidget(imagebutton_enter_button);
		imagebutton_edit_button = new ImageButton(this.leftPos + 122, this.topPos + 6, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_edit_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new PropertyToNBTCodeBlockGUIButtonMessage(1, x, y, z));
				PropertyToNBTCodeBlockGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_edit_button", imagebutton_edit_button);
		this.addRenderableWidget(imagebutton_edit_button);
		imagebutton_enter_button1 = new ImageButton(this.leftPos + 145, this.topPos + 56, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_enter_button1.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new PropertyToNBTCodeBlockGUIButtonMessage(2, x, y, z));
				PropertyToNBTCodeBlockGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_enter_button1", imagebutton_enter_button1);
		this.addRenderableWidget(imagebutton_enter_button1);
		imagebutton_edit_button1 = new ImageButton(this.leftPos + 122, this.topPos + 56, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_edit_button1.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new PropertyToNBTCodeBlockGUIButtonMessage(3, x, y, z));
				PropertyToNBTCodeBlockGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_edit_button1", imagebutton_edit_button1);
		this.addRenderableWidget(imagebutton_edit_button1);
	}
}
