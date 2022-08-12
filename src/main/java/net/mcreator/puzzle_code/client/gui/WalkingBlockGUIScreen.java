
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
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.puzzle_code.world.inventory.WalkingBlockGUIMenu;
import net.mcreator.puzzle_code.network.WalkingBlockGUIButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class WalkingBlockGUIScreen extends AbstractContainerScreen<WalkingBlockGUIMenu> {
	private final static HashMap<String, Object> guistate = WalkingBlockGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox waitingOffField;
	EditBox waitingOnField;

	public WalkingBlockGUIScreen(WalkingBlockGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 177;
		this.imageHeight = 140;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/screens/walking_block_gui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		waitingOffField.render(ms, mouseX, mouseY, partialTicks);
		waitingOnField.render(ms, mouseX, mouseY, partialTicks);
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
		if (waitingOffField.isFocused())
			return waitingOffField.keyPressed(key, b, c);
		if (waitingOnField.isFocused())
			return waitingOnField.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		waitingOffField.tick();
		waitingOnField.tick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, "Waiting to switch off: " + (new Object() {
			public double getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getTileData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "waitingOff")) + " ticks", 7, 57, -12829636);
		this.font.draw(poseStack, "Waiting to switch on: " + (new Object() {
			public double getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getTileData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "waitingOn")) + " ticks", 7, 120, -12829636);
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
		this.addRenderableWidget(new Button(this.leftPos + 7, this.topPos + 30, 77, 20, new TextComponent("Apply"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new WalkingBlockGUIButtonMessage(0, x, y, z));
				WalkingBlockGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 7, this.topPos + 93, 77, 20, new TextComponent("Apply"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new WalkingBlockGUIButtonMessage(1, x, y, z));
				WalkingBlockGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		waitingOffField = new EditBox(this.font, this.leftPos + 7, this.topPos + 8, 162, 20, new TextComponent(""));
		guistate.put("text:waitingOffField", waitingOffField);
		waitingOffField.setMaxLength(32767);
		this.addWidget(this.waitingOffField);
		waitingOnField = new EditBox(this.font, this.leftPos + 7, this.topPos + 71, 162, 20, new TextComponent(""));
		guistate.put("text:waitingOnField", waitingOnField);
		waitingOnField.setMaxLength(32767);
		this.addWidget(this.waitingOnField);
		this.addRenderableWidget(new Button(this.leftPos + 93, this.topPos + 93, 76, 20, new TextComponent("Edit"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new WalkingBlockGUIButtonMessage(2, x, y, z));
				WalkingBlockGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 93, this.topPos + 30, 77, 20, new TextComponent("Edit"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new WalkingBlockGUIButtonMessage(3, x, y, z));
				WalkingBlockGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}));
	}
}
