package net.mcreator.puzzle_code.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.puzzle_code.world.inventory.AdvancedTimeBlockGUIMenu;
import net.mcreator.puzzle_code.procedures.ReturnTimeProcedure;
import net.mcreator.puzzle_code.network.AdvancedTimeBlockGUIButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class AdvancedTimeBlockGUIScreen extends AbstractContainerScreen<AdvancedTimeBlockGUIMenu> {
	private final static HashMap<String, Object> guistate = AdvancedTimeBlockGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox timeField;
	Button button_apply;
	Button button_edit;

	public AdvancedTimeBlockGUIScreen(AdvancedTimeBlockGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 154;
		this.imageHeight = 86;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/screens/advanced_time_block_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		timeField.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("puzzle_code:textures/screens/puzzle_code_logo.png"), this.leftPos + 130, this.topPos + -2, 0, 0, -1, -1, -1, -1);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (timeField.isFocused())
			return timeField.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		timeField.tick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.advanced_time_block_gui.label_time_settings"), 4, 57, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.advanced_time_block_gui.label_time_bnbtnumbertime"), 4, 70, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnTimeProcedure.execute(world, x, y, z), 35, 57, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		timeField = new EditBox(this.font, this.leftPos + 5, this.topPos + 8, 142, 18, Component.translatable("gui.puzzle_code.advanced_time_block_gui.timeField"));
		timeField.setMaxLength(32767);
		guistate.put("text:timeField", timeField);
		this.addWidget(this.timeField);
		button_apply = Button.builder(Component.translatable("gui.puzzle_code.advanced_time_block_gui.button_apply"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new AdvancedTimeBlockGUIButtonMessage(0, x, y, z));
				AdvancedTimeBlockGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 4, this.topPos + 30, 67, 20).build();
		guistate.put("button:button_apply", button_apply);
		this.addRenderableWidget(button_apply);
		button_edit = Button.builder(Component.translatable("gui.puzzle_code.advanced_time_block_gui.button_edit"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new AdvancedTimeBlockGUIButtonMessage(1, x, y, z));
				AdvancedTimeBlockGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 80, this.topPos + 30, 67, 20).build();
		guistate.put("button:button_edit", button_edit);
		this.addRenderableWidget(button_edit);
	}
}
