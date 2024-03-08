package net.mcreator.puzzle_code.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.puzzle_code.world.inventory.CreativeSettingsGUICreativeItemsMenu;
import net.mcreator.puzzle_code.network.CreativeSettingsGUICreativeItemsButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class CreativeSettingsGUICreativeItemsScreen extends AbstractContainerScreen<CreativeSettingsGUICreativeItemsMenu> {
	private final static HashMap<String, Object> guistate = CreativeSettingsGUICreativeItemsMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_command_block;
	Button button_barrier;
	Button button_command_block_minecart;
	Button button_back;
	Button button_debug_stick;
	Button button_structure_void;
	Button button_structure_block;

	public CreativeSettingsGUICreativeItemsScreen(CreativeSettingsGUICreativeItemsMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/screens/creative_settings_gui_creative_items.png");

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
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.creative_settings_gui_creative_items.label_creative_blocks"), 6, 7, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.creative_settings_gui_creative_items.label_more_comming_soon"), 6, 147, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_command_block = Button.builder(Component.translatable("gui.puzzle_code.creative_settings_gui_creative_items.button_command_block"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CreativeSettingsGUICreativeItemsButtonMessage(0, x, y, z));
				CreativeSettingsGUICreativeItemsButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 21, 99, 20).build();
		guistate.put("button:button_command_block", button_command_block);
		this.addRenderableWidget(button_command_block);
		button_barrier = Button.builder(Component.translatable("gui.puzzle_code.creative_settings_gui_creative_items.button_barrier"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CreativeSettingsGUICreativeItemsButtonMessage(1, x, y, z));
				CreativeSettingsGUICreativeItemsButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 105, this.topPos + 21, 63, 20).build();
		guistate.put("button:button_barrier", button_barrier);
		this.addRenderableWidget(button_barrier);
		button_command_block_minecart = Button.builder(Component.translatable("gui.puzzle_code.creative_settings_gui_creative_items.button_command_block_minecart"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CreativeSettingsGUICreativeItemsButtonMessage(2, x, y, z));
				CreativeSettingsGUICreativeItemsButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 43, 162, 20).build();
		guistate.put("button:button_command_block_minecart", button_command_block_minecart);
		this.addRenderableWidget(button_command_block_minecart);
		button_back = Button.builder(Component.translatable("gui.puzzle_code.creative_settings_gui_creative_items.button_back"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CreativeSettingsGUICreativeItemsButtonMessage(3, x, y, z));
				CreativeSettingsGUICreativeItemsButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 123, this.topPos + 138, 46, 20).build();
		guistate.put("button:button_back", button_back);
		this.addRenderableWidget(button_back);
		button_debug_stick = Button.builder(Component.translatable("gui.puzzle_code.creative_settings_gui_creative_items.button_debug_stick"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CreativeSettingsGUICreativeItemsButtonMessage(4, x, y, z));
				CreativeSettingsGUICreativeItemsButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 66, 81, 20).build();
		guistate.put("button:button_debug_stick", button_debug_stick);
		this.addRenderableWidget(button_debug_stick);
		button_structure_void = Button.builder(Component.translatable("gui.puzzle_code.creative_settings_gui_creative_items.button_structure_void"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CreativeSettingsGUICreativeItemsButtonMessage(5, x, y, z));
				CreativeSettingsGUICreativeItemsButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}).bounds(this.leftPos + 87, this.topPos + 66, 81, 20).build();
		guistate.put("button:button_structure_void", button_structure_void);
		this.addRenderableWidget(button_structure_void);
		button_structure_block = Button.builder(Component.translatable("gui.puzzle_code.creative_settings_gui_creative_items.button_structure_block"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CreativeSettingsGUICreativeItemsButtonMessage(6, x, y, z));
				CreativeSettingsGUICreativeItemsButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 88, 103, 20).build();
		guistate.put("button:button_structure_block", button_structure_block);
		this.addRenderableWidget(button_structure_block);
	}
}
