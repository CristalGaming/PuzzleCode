
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

import net.mcreator.puzzle_code.world.inventory.FillerItemCodeBlockGUI1Menu;
import net.mcreator.puzzle_code.network.FillerItemCodeBlockGUI1ButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class FillerItemCodeBlockGUI1Screen extends AbstractContainerScreen<FillerItemCodeBlockGUI1Menu> {
	private final static HashMap<String, Object> guistate = FillerItemCodeBlockGUI1Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox xPosField;
	EditBox yPosField;
	EditBox zPosField;

	public FillerItemCodeBlockGUI1Screen(FillerItemCodeBlockGUI1Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 174;
		this.imageHeight = 152;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/filler_item_code_block_gui_1.png");

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
		this.font.draw(poseStack, "X1 " + ((int) new Object() {
			public double getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getTileData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "xPos")) + "", 5, 32, -12829636);
		this.font.draw(poseStack, "Y1 " + ((int) new Object() {
			public double getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getTileData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "yPos")) + "", 5, 68, -12829636);
		this.font.draw(poseStack, "Z1: " + ((int) new Object() {
			public double getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getTileData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "zPos")) + "", 5, 104, -12829636);
		this.font.draw(poseStack, "[1]", 5, 126, -12829636);
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
		xPosField = new EditBox(this.font, this.leftPos + 5, this.topPos + 9, 162, 20, new TextComponent("X position")) {
			{
				setSuggestion("X position");
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion("X position");
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion("X position");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:xPosField", xPosField);
		xPosField.setMaxLength(32767);
		this.addWidget(this.xPosField);
		this.addRenderableWidget(new Button(this.leftPos + 172, this.topPos + 9, 40, 20, new TextComponent("Apply"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new FillerItemCodeBlockGUI1ButtonMessage(0, x, y, z));
				FillerItemCodeBlockGUI1ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		yPosField = new EditBox(this.font, this.leftPos + 5, this.topPos + 45, 162, 20, new TextComponent("y position")) {
			{
				setSuggestion("y position");
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion("y position");
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion("y position");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:yPosField", yPosField);
		yPosField.setMaxLength(32767);
		this.addWidget(this.yPosField);
		zPosField = new EditBox(this.font, this.leftPos + 5, this.topPos + 81, 162, 20, new TextComponent("z position")) {
			{
				setSuggestion("z position");
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion("z position");
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion("z position");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:zPosField", zPosField);
		zPosField.setMaxLength(32767);
		this.addWidget(this.zPosField);
		this.addRenderableWidget(new Button(this.leftPos + 172, this.topPos + 45, 40, 20, new TextComponent("Apply"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new FillerItemCodeBlockGUI1ButtonMessage(1, x, y, z));
				FillerItemCodeBlockGUI1ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 172, this.topPos + 81, 40, 20, new TextComponent("Apply"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new FillerItemCodeBlockGUI1ButtonMessage(2, x, y, z));
				FillerItemCodeBlockGUI1ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 23, this.topPos + 122, 14, 20, new TextComponent("2"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new FillerItemCodeBlockGUI1ButtonMessage(3, x, y, z));
				FillerItemCodeBlockGUI1ButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + -43, this.topPos + 9, 45, 20, new TextComponent("Edit"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new FillerItemCodeBlockGUI1ButtonMessage(4, x, y, z));
				FillerItemCodeBlockGUI1ButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + -43, this.topPos + 45, 45, 20, new TextComponent("Edit"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new FillerItemCodeBlockGUI1ButtonMessage(5, x, y, z));
				FillerItemCodeBlockGUI1ButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + -43, this.topPos + 81, 45, 20, new TextComponent("Edit"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new FillerItemCodeBlockGUI1ButtonMessage(6, x, y, z));
				FillerItemCodeBlockGUI1ButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 41, this.topPos + 122, 14, 20, new TextComponent("3"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new FillerItemCodeBlockGUI1ButtonMessage(7, x, y, z));
				FillerItemCodeBlockGUI1ButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}));
	}
}
