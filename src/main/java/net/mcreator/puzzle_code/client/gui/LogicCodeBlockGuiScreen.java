
package net.mcreator.puzzle_code.client.gui;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.puzzle_code.world.inventory.LogicCodeBlockGuiMenu;
import net.mcreator.puzzle_code.network.LogicCodeBlockGuiButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class LogicCodeBlockGuiScreen extends AbstractContainerScreen<LogicCodeBlockGuiMenu> {
	private final static HashMap<String, Object> guistate = LogicCodeBlockGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public LogicCodeBlockGuiScreen(LogicCodeBlockGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 47;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/screens/logic_code_block_gui.png");

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
		this.font.draw(poseStack, "Logic: " + (new Object() {
			public boolean getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "logicCodeBlock")) + "", 6, 28, -12829636);
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
		this.addRenderableWidget(new Button(this.leftPos + 87, this.topPos + 6, 41, 20, new TextComponent("True"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new LogicCodeBlockGuiButtonMessage(0, x, y, z));
				LogicCodeBlockGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 128, this.topPos + 6, 40, 20, new TextComponent("False"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new LogicCodeBlockGuiButtonMessage(1, x, y, z));
				LogicCodeBlockGuiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 6, this.topPos + 6, 81, 20, new TextComponent("Switch"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new LogicCodeBlockGuiButtonMessage(2, x, y, z));
				LogicCodeBlockGuiButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));
	}
}
