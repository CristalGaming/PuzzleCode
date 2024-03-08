package net.mcreator.puzzle_code.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.puzzle_code.world.inventory.PositionSetGUIMenu;
import net.mcreator.puzzle_code.procedures.VarReturnPositionSetZPos2Procedure;
import net.mcreator.puzzle_code.procedures.VarReturnPositionSetYPos2Procedure;
import net.mcreator.puzzle_code.procedures.VarReturnPositionSetXPos2Procedure;
import net.mcreator.puzzle_code.network.PositionSetGUIButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class PositionSetGUIScreen extends AbstractContainerScreen<PositionSetGUIMenu> {
	private final static HashMap<String, Object> guistate = PositionSetGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_copy;
	Button button_paste;
	Button button_paste2;

	public PositionSetGUIScreen(PositionSetGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 88;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/screens/position_set_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.position_set_gui.label_x_varpositionsetxpos2"), 6, 45, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.position_set_gui.label_y_varpositionsetypos2"), 6, 58, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.position_set_gui.label_z_varpositionsetzpos2"), 6, 72, -12829636, false);
		guiGraphics.drawString(this.font,

				VarReturnPositionSetXPos2Procedure.execute(entity), 69, 45, -12829636, false);
		guiGraphics.drawString(this.font,

				VarReturnPositionSetYPos2Procedure.execute(entity), 69, 58, -12829636, false);
		guiGraphics.drawString(this.font,

				VarReturnPositionSetZPos2Procedure.execute(entity), 69, 72, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.position_set_gui.label_block_position"), 6, 31, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_copy = Button.builder(Component.translatable("gui.puzzle_code.position_set_gui.button_copy"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new PositionSetGUIButtonMessage(0, x, y, z));
				PositionSetGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 4, 63, 20).build();
		guistate.put("button:button_copy", button_copy);
		this.addRenderableWidget(button_copy);
		button_paste = Button.builder(Component.translatable("gui.puzzle_code.position_set_gui.button_paste"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new PositionSetGUIButtonMessage(1, x, y, z));
				PositionSetGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 74, this.topPos + 4, 45, 20).build();
		guistate.put("button:button_paste", button_paste);
		this.addRenderableWidget(button_paste);
		button_paste2 = Button.builder(Component.translatable("gui.puzzle_code.position_set_gui.button_paste2"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new PositionSetGUIButtonMessage(2, x, y, z));
				PositionSetGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 123, this.topPos + 4, 45, 20).build();
		guistate.put("button:button_paste2", button_paste2);
		this.addRenderableWidget(button_paste2);
	}
}
