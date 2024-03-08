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

import net.mcreator.puzzle_code.world.inventory.AreaCodeBlockGUIMenu;
import net.mcreator.puzzle_code.procedures.ReturnSecondPositionProcedure;
import net.mcreator.puzzle_code.procedures.ReturnPositionProcedure;
import net.mcreator.puzzle_code.procedures.ReturnCurrentSelectedAxisProcedure;
import net.mcreator.puzzle_code.procedures.ReturnCurrentNBTAreaProcedure;
import net.mcreator.puzzle_code.procedures.ReturnCurrentCoordinateProcedure;
import net.mcreator.puzzle_code.procedures.ReturnCurrentAxisValueAreaProcedure;
import net.mcreator.puzzle_code.network.AreaCodeBlockGUIButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class AreaCodeBlockGUIScreen extends AbstractContainerScreen<AreaCodeBlockGUIMenu> {
	private final static HashMap<String, Object> guistate = AreaCodeBlockGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox positionField;
	Button button_x;
	Button button_y;
	Button button_z;
	Button button_1;
	Button button_2;
	ImageButton imagebutton_enter_button;
	ImageButton imagebutton_edit_button;
	ImageButton imagebutton_swap_button;

	public AreaCodeBlockGUIScreen(AreaCodeBlockGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 141;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/screens/area_code_block_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		positionField.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
		if (mouseX > leftPos + 146 && mouseX < leftPos + 166 && mouseY > topPos + 111 && mouseY < topPos + 131)
			guiGraphics.renderTooltip(font, Component.translatable("gui.puzzle_code.area_code_block_gui.tooltip_flips_the_current_selected_axis"), mouseX, mouseY);
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

				ReturnCurrentSelectedAxisProcedure.execute(world, x, y, z), 146, 57, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.area_code_block_gui.label_nbt"), 6, 30, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.area_code_block_gui.label_nbt_currentselectedaxis"), 6, 57, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnCurrentNBTAreaProcedure.execute(world, x, y, z), 33, 30, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnCurrentAxisValueAreaProcedure.execute(world, x, y, z), 6, 44, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.area_code_block_gui.label_nbt_currentposition"), 6, 71, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnCurrentCoordinateProcedure.execute(world, x, y, z), 132, 71, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnPositionProcedure.execute(world, x, y, z), 6, 84, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnSecondPositionProcedure.execute(world, x, y, z), 6, 98, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		positionField = new EditBox(this.font, this.leftPos + 7, this.topPos + 9, 111, 18, Component.translatable("gui.puzzle_code.area_code_block_gui.positionField"));
		positionField.setMaxLength(32767);
		guistate.put("text:positionField", positionField);
		this.addWidget(this.positionField);
		button_x = Button.builder(Component.translatable("gui.puzzle_code.area_code_block_gui.button_x"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new AreaCodeBlockGUIButtonMessage(0, x, y, z));
				AreaCodeBlockGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 111, 18, 20).build();
		guistate.put("button:button_x", button_x);
		this.addRenderableWidget(button_x);
		button_y = Button.builder(Component.translatable("gui.puzzle_code.area_code_block_gui.button_y"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new AreaCodeBlockGUIButtonMessage(1, x, y, z));
				AreaCodeBlockGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 29, this.topPos + 111, 18, 20).build();
		guistate.put("button:button_y", button_y);
		this.addRenderableWidget(button_y);
		button_z = Button.builder(Component.translatable("gui.puzzle_code.area_code_block_gui.button_z"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new AreaCodeBlockGUIButtonMessage(2, x, y, z));
				AreaCodeBlockGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 51, this.topPos + 111, 18, 20).build();
		guistate.put("button:button_z", button_z);
		this.addRenderableWidget(button_z);
		button_1 = Button.builder(Component.translatable("gui.puzzle_code.area_code_block_gui.button_1"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new AreaCodeBlockGUIButtonMessage(3, x, y, z));
				AreaCodeBlockGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 74, this.topPos + 111, 31, 20).build();
		guistate.put("button:button_1", button_1);
		this.addRenderableWidget(button_1);
		button_2 = Button.builder(Component.translatable("gui.puzzle_code.area_code_block_gui.button_2"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new AreaCodeBlockGUIButtonMessage(4, x, y, z));
				AreaCodeBlockGUIButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + 110, this.topPos + 111, 31, 20).build();
		guistate.put("button:button_2", button_2);
		this.addRenderableWidget(button_2);
		imagebutton_enter_button = new ImageButton(this.leftPos + 146, this.topPos + 8, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_enter_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new AreaCodeBlockGUIButtonMessage(5, x, y, z));
				AreaCodeBlockGUIButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:imagebutton_enter_button", imagebutton_enter_button);
		this.addRenderableWidget(imagebutton_enter_button);
		imagebutton_edit_button = new ImageButton(this.leftPos + 123, this.topPos + 8, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_edit_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new AreaCodeBlockGUIButtonMessage(6, x, y, z));
				AreaCodeBlockGUIButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		});
		guistate.put("button:imagebutton_edit_button", imagebutton_edit_button);
		this.addRenderableWidget(imagebutton_edit_button);
		imagebutton_swap_button = new ImageButton(this.leftPos + 146, this.topPos + 111, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_swap_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new AreaCodeBlockGUIButtonMessage(7, x, y, z));
				AreaCodeBlockGUIButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		});
		guistate.put("button:imagebutton_swap_button", imagebutton_swap_button);
		this.addRenderableWidget(imagebutton_swap_button);
	}
}
