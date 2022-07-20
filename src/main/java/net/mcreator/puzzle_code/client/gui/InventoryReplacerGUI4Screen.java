
package net.mcreator.puzzle_code.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.puzzle_code.world.inventory.InventoryReplacerGUI4Menu;
import net.mcreator.puzzle_code.procedures.DisplayReplaceInventoryProcedure;
import net.mcreator.puzzle_code.procedures.DisplayReplaceHotbarProcedure;
import net.mcreator.puzzle_code.procedures.DisplayReplaceArmorProcedure;
import net.mcreator.puzzle_code.network.InventoryReplacerGUI4ButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class InventoryReplacerGUI4Screen extends AbstractContainerScreen<InventoryReplacerGUI4Menu> {
	private final static HashMap<String, Object> guistate = InventoryReplacerGUI4Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public InventoryReplacerGUI4Screen(InventoryReplacerGUI4Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/inventory_replacer_gui_4.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
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
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, "[4]", 51, 142, -12829636);
		if (DisplayReplaceHotbarProcedure.execute(world, x, y, z))
			this.font.draw(poseStack, "true", 6, 30, -12829636);
		if (DisplayReplaceInventoryProcedure.execute(world, x, y, z))
			this.font.draw(poseStack, "true", 6, 70, -12829636);
		if (DisplayReplaceArmorProcedure.execute(world, x, y, z))
			this.font.draw(poseStack, "true", 6, 106, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		this.addRenderableWidget(new Button(this.leftPos + 6, this.topPos + 7, 153, 20, new TextComponent("Replace Hotbar Slots"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new InventoryReplacerGUI4ButtonMessage(0, x, y, z));
				InventoryReplacerGUI4ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 6, this.topPos + 43, 153, 20, new TextComponent("Replace Slots Inventory GUI"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new InventoryReplacerGUI4ButtonMessage(1, x, y, z));
				InventoryReplacerGUI4ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 6, this.topPos + 84, 153, 20, new TextComponent("Replace Armor Slots"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new InventoryReplacerGUI4ButtonMessage(2, x, y, z));
				InventoryReplacerGUI4ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 6, this.topPos + 138, 14, 20, new TextComponent("1"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new InventoryReplacerGUI4ButtonMessage(3, x, y, z));
				InventoryReplacerGUI4ButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 20, this.topPos + 138, 13, 20, new TextComponent("2"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new InventoryReplacerGUI4ButtonMessage(4, x, y, z));
				InventoryReplacerGUI4ButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 33, this.topPos + 138, 14, 20, new TextComponent("3"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new InventoryReplacerGUI4ButtonMessage(5, x, y, z));
				InventoryReplacerGUI4ButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}));
	}
}
