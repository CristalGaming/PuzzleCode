
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

import net.mcreator.puzzle_code.world.inventory.ImitatorLogicCodeBlockGUIMenu;
import net.mcreator.puzzle_code.network.ImitatorLogicCodeBlockGUIButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class ImitatorLogicCodeBlockGUIScreen extends AbstractContainerScreen<ImitatorLogicCodeBlockGUIMenu> {
	private final static HashMap<String, Object> guistate = ImitatorLogicCodeBlockGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox xPosField;
	EditBox yPosField;
	EditBox zPosField;

	public ImitatorLogicCodeBlockGUIScreen(ImitatorLogicCodeBlockGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 174;
		this.imageHeight = 147;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/imitator_logic_code_block_gui.png");

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
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "xPos")) + "", 5, 29, -12829636);
		this.font.draw(poseStack, "Y Position: " + (new Object() {
			public double getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getTileData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "yPos")) + "", 5, 65, -12829636);
		this.font.draw(poseStack, "Z Position: " + (new Object() {
			public double getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getTileData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "zPos")) + "", 5, 101, -12829636);
		this.font.draw(poseStack, "Logic: " + (new Object() {
			public boolean getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "logicCodeBlock")) + "", 5, 123, -12829636);
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
		xPosField = new EditBox(this.font, this.leftPos + 5, this.topPos + 6, 162, 20, new TextComponent(""));
		guistate.put("text:xPosField", xPosField);
		xPosField.setMaxLength(32767);
		this.addWidget(this.xPosField);
		this.addRenderableWidget(new Button(this.leftPos + 172, this.topPos + 6, 45, 20, new TextComponent("Apply"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new ImitatorLogicCodeBlockGUIButtonMessage(0, x, y, z));
				ImitatorLogicCodeBlockGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		yPosField = new EditBox(this.font, this.leftPos + 5, this.topPos + 42, 162, 20, new TextComponent(""));
		guistate.put("text:yPosField", yPosField);
		yPosField.setMaxLength(32767);
		this.addWidget(this.yPosField);
		zPosField = new EditBox(this.font, this.leftPos + 5, this.topPos + 78, 162, 20, new TextComponent(""));
		guistate.put("text:zPosField", zPosField);
		zPosField.setMaxLength(32767);
		this.addWidget(this.zPosField);
		this.addRenderableWidget(new Button(this.leftPos + 172, this.topPos + 42, 45, 20, new TextComponent("Apply"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new ImitatorLogicCodeBlockGUIButtonMessage(1, x, y, z));
				ImitatorLogicCodeBlockGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 172, this.topPos + 78, 45, 20, new TextComponent("Apply"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new ImitatorLogicCodeBlockGUIButtonMessage(2, x, y, z));
				ImitatorLogicCodeBlockGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + -43, this.topPos + 6, 45, 20, new TextComponent("Edit"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new ImitatorLogicCodeBlockGUIButtonMessage(3, x, y, z));
				ImitatorLogicCodeBlockGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + -43, this.topPos + 42, 45, 20, new TextComponent("Edit"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new ImitatorLogicCodeBlockGUIButtonMessage(4, x, y, z));
				ImitatorLogicCodeBlockGUIButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + -43, this.topPos + 78, 45, 20, new TextComponent("Edit"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new ImitatorLogicCodeBlockGUIButtonMessage(5, x, y, z));
				ImitatorLogicCodeBlockGUIButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}));
	}
}
