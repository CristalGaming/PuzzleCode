
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

import net.mcreator.puzzle_code.world.inventory.EffectBlocksGuiMenu;
import net.mcreator.puzzle_code.network.EffectBlocksGuiButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class EffectBlocksGuiScreen extends AbstractContainerScreen<EffectBlocksGuiMenu> {
	private final static HashMap<String, Object> guistate = EffectBlocksGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox powerEffectField;
	EditBox durationEffectField;
	EditBox rangeField;

	public EffectBlocksGuiScreen(EffectBlocksGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 184;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/effect_blocks_gui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		powerEffectField.render(ms, mouseX, mouseY, partialTicks);
		durationEffectField.render(ms, mouseX, mouseY, partialTicks);
		rangeField.render(ms, mouseX, mouseY, partialTicks);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		RenderSystem.setShaderTexture(0, new ResourceLocation("puzzle_code:textures/puzzle_code_logo.png"));
		this.blit(ms, this.leftPos + 150, this.topPos + 8, 0, 0, 16, 16, 16, 16);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (powerEffectField.isFocused())
			return powerEffectField.keyPressed(key, b, c);
		if (durationEffectField.isFocused())
			return durationEffectField.keyPressed(key, b, c);
		if (rangeField.isFocused())
			return rangeField.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		powerEffectField.tick();
		durationEffectField.tick();
		rangeField.tick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, "Effect Settings", 6, 8, -12829636);
		this.font.draw(poseStack, "Power: " + ((int) new Object() {
			public double getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getTileData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "powerEffect")) + "", 6, 53, -12829636);
		this.font.draw(poseStack, "Duration: " + ((int) new Object() {
			public double getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getTileData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "durationEffect")) + " ticks", 6, 94, -12829636);
		this.font.draw(poseStack, "[1]", 6, 161, -12829636);
		this.font.draw(poseStack, "Redstone Range: " + ((int) new Object() {
			public double getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getTileData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "range")) + "", 6, 139, -12829636);
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
		powerEffectField = new EditBox(this.font, this.leftPos + 6, this.topPos + 26, 108, 20, new TextComponent("Power")) {
			{
				setSuggestion("Power");
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion("Power");
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion("Power");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:powerEffectField", powerEffectField);
		powerEffectField.setMaxLength(32767);
		this.addWidget(this.powerEffectField);
		this.addRenderableWidget(new Button(this.leftPos + 119, this.topPos + 26, 51, 20, new TextComponent("Apply"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new EffectBlocksGuiButtonMessage(0, x, y, z));
				EffectBlocksGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		durationEffectField = new EditBox(this.font, this.leftPos + 6, this.topPos + 67, 108, 20, new TextComponent("Duration")) {
			{
				setSuggestion("Duration");
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion("Duration");
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion("Duration");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:durationEffectField", durationEffectField);
		durationEffectField.setMaxLength(32767);
		this.addWidget(this.durationEffectField);
		this.addRenderableWidget(new Button(this.leftPos + 119, this.topPos + 67, 51, 20, new TextComponent("Apply"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new EffectBlocksGuiButtonMessage(1, x, y, z));
				EffectBlocksGuiButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 24, this.topPos + 157, 13, 20, new TextComponent("2"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new EffectBlocksGuiButtonMessage(2, x, y, z));
				EffectBlocksGuiButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		rangeField = new EditBox(this.font, this.leftPos + 6, this.topPos + 112, 108, 20, new TextComponent("range")) {
			{
				setSuggestion("range");
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion("range");
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion("range");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:rangeField", rangeField);
		rangeField.setMaxLength(32767);
		this.addWidget(this.rangeField);
		this.addRenderableWidget(new Button(this.leftPos + 119, this.topPos + 112, 51, 20, new TextComponent("Apply"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new EffectBlocksGuiButtonMessage(3, x, y, z));
				EffectBlocksGuiButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}));
	}
}
