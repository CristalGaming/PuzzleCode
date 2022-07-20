
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

import net.mcreator.puzzle_code.world.inventory.FillerGui2Menu;
import net.mcreator.puzzle_code.network.FillerGui2ButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class FillerGui2Screen extends AbstractContainerScreen<FillerGui2Menu> {
	private final static HashMap<String, Object> guistate = FillerGui2Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox xPos2Field;
	EditBox yPos2Field;
	EditBox zPos2Field;

	public FillerGui2Screen(FillerGui2Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 174;
		this.imageHeight = 152;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/filler_gui_2.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		xPos2Field.render(ms, mouseX, mouseY, partialTicks);
		yPos2Field.render(ms, mouseX, mouseY, partialTicks);
		zPos2Field.render(ms, mouseX, mouseY, partialTicks);
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
		if (xPos2Field.isFocused())
			return xPos2Field.keyPressed(key, b, c);
		if (yPos2Field.isFocused())
			return yPos2Field.keyPressed(key, b, c);
		if (zPos2Field.isFocused())
			return zPos2Field.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		xPos2Field.tick();
		yPos2Field.tick();
		zPos2Field.tick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, "X2 " + ((int) new Object() {
			public double getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getTileData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "xPos2")) + "", 5, 32, -12829636);
		this.font.draw(poseStack, "Y2 " + ((int) new Object() {
			public double getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getTileData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "yPos2")) + "", 5, 68, -12829636);
		this.font.draw(poseStack, "Z2: " + ((int) new Object() {
			public double getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getTileData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "zPos2")) + "", 5, 104, -12829636);
		this.font.draw(poseStack, "[2]", 23, 126, -12829636);
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
		xPos2Field = new EditBox(this.font, this.leftPos + 5, this.topPos + 9, 162, 20, new TextComponent("X position")) {
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
		guistate.put("text:xPos2Field", xPos2Field);
		xPos2Field.setMaxLength(32767);
		this.addWidget(this.xPos2Field);
		this.addRenderableWidget(new Button(this.leftPos + 172, this.topPos + 9, 40, 20, new TextComponent("Apply"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new FillerGui2ButtonMessage(0, x, y, z));
				FillerGui2ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		yPos2Field = new EditBox(this.font, this.leftPos + 5, this.topPos + 45, 162, 20, new TextComponent("y position")) {
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
		guistate.put("text:yPos2Field", yPos2Field);
		yPos2Field.setMaxLength(32767);
		this.addWidget(this.yPos2Field);
		zPos2Field = new EditBox(this.font, this.leftPos + 5, this.topPos + 81, 162, 20, new TextComponent("z position")) {
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
		guistate.put("text:zPos2Field", zPos2Field);
		zPos2Field.setMaxLength(32767);
		this.addWidget(this.zPos2Field);
		this.addRenderableWidget(new Button(this.leftPos + 172, this.topPos + 45, 40, 20, new TextComponent("Apply"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new FillerGui2ButtonMessage(1, x, y, z));
				FillerGui2ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 172, this.topPos + 81, 40, 20, new TextComponent("Apply"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new FillerGui2ButtonMessage(2, x, y, z));
				FillerGui2ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 5, this.topPos + 122, 14, 20, new TextComponent("1"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new FillerGui2ButtonMessage(3, x, y, z));
				FillerGui2ButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + -43, this.topPos + 9, 45, 20, new TextComponent("Edit"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new FillerGui2ButtonMessage(4, x, y, z));
				FillerGui2ButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + -43, this.topPos + 45, 45, 20, new TextComponent("Edit"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new FillerGui2ButtonMessage(5, x, y, z));
				FillerGui2ButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + -43, this.topPos + 81, 45, 20, new TextComponent("Edit"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new FillerGui2ButtonMessage(6, x, y, z));
				FillerGui2ButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}));
	}
}
