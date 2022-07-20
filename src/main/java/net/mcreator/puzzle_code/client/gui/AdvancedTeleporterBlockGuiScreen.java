
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

import net.mcreator.puzzle_code.world.inventory.AdvancedTeleporterBlockGuiMenu;
import net.mcreator.puzzle_code.network.AdvancedTeleporterBlockGuiButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class AdvancedTeleporterBlockGuiScreen extends AbstractContainerScreen<AdvancedTeleporterBlockGuiMenu> {
	private final static HashMap<String, Object> guistate = AdvancedTeleporterBlockGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox xPosField;
	EditBox yPosField;
	EditBox zPosField;

	public AdvancedTeleporterBlockGuiScreen(AdvancedTeleporterBlockGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 132;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/advanced_teleporter_block_gui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		xPosField.render(ms, mouseX, mouseY, partialTicks);
		yPosField.render(ms, mouseX, mouseY, partialTicks);
		zPosField.render(ms, mouseX, mouseY, partialTicks);
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
		if (xPosField.isFocused())
			return xPosField.keyPressed(key, b, c);
		if (yPosField.isFocused())
			return yPosField.keyPressed(key, b, c);
		if (zPosField.isFocused())
			return zPosField.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		xPosField.tick();
		yPosField.tick();
		zPosField.tick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, "X Position: " + (new Object() {
			public double getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getTileData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "xPos")) + "", 6, 31, -12829636);
		this.font.draw(poseStack, "Y Position: " + (new Object() {
			public double getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getTileData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "yPos")) + "", 6, 71, -12829636);
		this.font.draw(poseStack, "Z Position: " + (new Object() {
			public double getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getTileData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "zPos")) + "", 6, 112, -12829636);
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
		xPosField = new EditBox(this.font, this.leftPos + 6, this.topPos + 8, 162, 20, new TextComponent(""));
		guistate.put("text:xPosField", xPosField);
		xPosField.setMaxLength(32767);
		this.addWidget(this.xPosField);
		this.addRenderableWidget(new Button(this.leftPos + 173, this.topPos + 8, 45, 20, new TextComponent("Apply"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new AdvancedTeleporterBlockGuiButtonMessage(0, x, y, z));
				AdvancedTeleporterBlockGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		yPosField = new EditBox(this.font, this.leftPos + 6, this.topPos + 49, 162, 20, new TextComponent(""));
		guistate.put("text:yPosField", yPosField);
		yPosField.setMaxLength(32767);
		this.addWidget(this.yPosField);
		zPosField = new EditBox(this.font, this.leftPos + 6, this.topPos + 89, 162, 20, new TextComponent(""));
		guistate.put("text:zPosField", zPosField);
		zPosField.setMaxLength(32767);
		this.addWidget(this.zPosField);
		this.addRenderableWidget(new Button(this.leftPos + 173, this.topPos + 49, 45, 20, new TextComponent("Apply"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new AdvancedTeleporterBlockGuiButtonMessage(1, x, y, z));
				AdvancedTeleporterBlockGuiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 173, this.topPos + 89, 45, 20, new TextComponent("Apply"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new AdvancedTeleporterBlockGuiButtonMessage(2, x, y, z));
				AdvancedTeleporterBlockGuiButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));
	}
}
