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

import net.mcreator.puzzle_code.world.inventory.PositionGUIMenu;
import net.mcreator.puzzle_code.procedures.ReturnCurrentSelectedAxisProcedure;
import net.mcreator.puzzle_code.procedures.ReturnCurrentNBTProcedure;
import net.mcreator.puzzle_code.procedures.ReturnCurrentAxisValueProcedure;
import net.mcreator.puzzle_code.network.PositionGUIButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class PositionGUIScreen extends AbstractContainerScreen<PositionGUIMenu> {
	private final static HashMap<String, Object> guistate = PositionGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox positionField;
	Button button_x;
	Button button_y;
	Button button_z;
	Button button_back;
	ImageButton imagebutton_enter_button;
	ImageButton imagebutton_edit_button;

	public PositionGUIScreen(PositionGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 100;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/screens/position_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		positionField.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (positionField.isFocused())
			return positionField.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		positionField.tick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font,

				ReturnCurrentSelectedAxisProcedure.execute(world, x, y, z), 146, 60, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.position_gui.label_nbt"), 6, 28, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.position_gui.label_nbt_currentselectedaxis"), 6, 60, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnCurrentNBTProcedure.execute(world, x, y, z), 33, 28, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnCurrentAxisValueProcedure.execute(world, x, y, z), 6, 42, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		positionField = new EditBox(this.font, this.leftPos + 7, this.topPos + 7, 111, 18, Component.translatable("gui.puzzle_code.position_gui.positionField"));
		positionField.setMaxLength(32767);
		guistate.put("text:positionField", positionField);
		this.addWidget(this.positionField);
		button_x = Button.builder(Component.translatable("gui.puzzle_code.position_gui.button_x"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new PositionGUIButtonMessage(0, x, y, z));
				PositionGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 105, this.topPos + 73, 18, 20).build();
		guistate.put("button:button_x", button_x);
		this.addRenderableWidget(button_x);
		button_y = Button.builder(Component.translatable("gui.puzzle_code.position_gui.button_y"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new PositionGUIButtonMessage(1, x, y, z));
				PositionGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 128, this.topPos + 73, 18, 20).build();
		guistate.put("button:button_y", button_y);
		this.addRenderableWidget(button_y);
		button_z = Button.builder(Component.translatable("gui.puzzle_code.position_gui.button_z"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new PositionGUIButtonMessage(2, x, y, z));
				PositionGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 150, this.topPos + 73, 18, 20).build();
		guistate.put("button:button_z", button_z);
		this.addRenderableWidget(button_z);
		button_back = Button.builder(Component.translatable("gui.puzzle_code.position_gui.button_back"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new PositionGUIButtonMessage(3, x, y, z));
				PositionGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 73, 95, 20).build();
		guistate.put("button:button_back", button_back);
		this.addRenderableWidget(button_back);
		imagebutton_enter_button = new ImageButton(this.leftPos + 146, this.topPos + 6, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_enter_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new PositionGUIButtonMessage(4, x, y, z));
				PositionGUIButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:imagebutton_enter_button", imagebutton_enter_button);
		this.addRenderableWidget(imagebutton_enter_button);
		imagebutton_edit_button = new ImageButton(this.leftPos + 123, this.topPos + 6, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_edit_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new PositionGUIButtonMessage(5, x, y, z));
				PositionGUIButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:imagebutton_edit_button", imagebutton_edit_button);
		this.addRenderableWidget(imagebutton_edit_button);
	}
}
