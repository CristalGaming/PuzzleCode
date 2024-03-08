package net.mcreator.puzzle_code.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.puzzle_code.world.inventory.InventoryReplacerGUI2Menu;
import net.mcreator.puzzle_code.network.InventoryReplacerGUI2ButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class InventoryReplacerGUI2Screen extends AbstractContainerScreen<InventoryReplacerGUI2Menu> {
	private final static HashMap<String, Object> guistate = InventoryReplacerGUI2Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_1;
	Button button_3;
	Button button_4;
	Button button_2;

	public InventoryReplacerGUI2Screen(InventoryReplacerGUI2Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/screens/inventory_replacer_gui_2.png");

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
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_1 = Button.builder(Component.translatable("gui.puzzle_code.inventory_replacer_gui_2.button_1"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new InventoryReplacerGUI2ButtonMessage(0, x, y, z));
				InventoryReplacerGUI2ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 51, this.topPos + 62, 18, 20).build();
		guistate.put("button:button_1", button_1);
		this.addRenderableWidget(button_1);
		button_3 = Button.builder(Component.translatable("gui.puzzle_code.inventory_replacer_gui_2.button_3"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new InventoryReplacerGUI2ButtonMessage(1, x, y, z));
				InventoryReplacerGUI2ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 87, this.topPos + 62, 18, 20).build();
		guistate.put("button:button_3", button_3);
		this.addRenderableWidget(button_3);
		button_4 = Button.builder(Component.translatable("gui.puzzle_code.inventory_replacer_gui_2.button_4"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new InventoryReplacerGUI2ButtonMessage(2, x, y, z));
				InventoryReplacerGUI2ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 105, this.topPos + 62, 18, 20).build();
		guistate.put("button:button_4", button_4);
		this.addRenderableWidget(button_4);
		button_2 = Button.builder(Component.translatable("gui.puzzle_code.inventory_replacer_gui_2.button_2"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new InventoryReplacerGUI2ButtonMessage(3, x, y, z));
				InventoryReplacerGUI2ButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 69, this.topPos + 62, 18, 20).build();
		guistate.put("button:button_2", button_2);
		this.addRenderableWidget(button_2);
	}
}
