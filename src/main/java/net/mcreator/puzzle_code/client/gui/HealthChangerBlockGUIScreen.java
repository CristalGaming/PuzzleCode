
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

import net.mcreator.puzzle_code.world.inventory.HealthChangerBlockGUIMenu;
import net.mcreator.puzzle_code.network.HealthChangerBlockGUIButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class HealthChangerBlockGUIScreen extends AbstractContainerScreen<HealthChangerBlockGUIMenu> {
	private final static HashMap<String, Object> guistate = HealthChangerBlockGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox rangeField;
	EditBox healthLevelField;

	public HealthChangerBlockGUIScreen(HealthChangerBlockGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 140;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/screens/health_changer_block_gui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		rangeField.render(ms, mouseX, mouseY, partialTicks);
		healthLevelField.render(ms, mouseX, mouseY, partialTicks);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		RenderSystem.setShaderTexture(0, new ResourceLocation("puzzle_code:textures/screens/puzzle_code_logo.png"));
		this.blit(ms, this.leftPos + 150, this.topPos + 21, 0, 0, -1, -1, -1, -1);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (rangeField.isFocused())
			return rangeField.keyPressed(key, b, c);
		if (healthLevelField.isFocused())
			return healthLevelField.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		rangeField.tick();
		healthLevelField.tick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, "Health: " + (new Object() {
			public double getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getTileData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "healthLevel")) + " HP", 6, 57, -12829636);
		this.font.draw(poseStack, "Range: " + (new Object() {
			public double getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getTileData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "range")) + "", 6, 120, -12829636);
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
		this.addRenderableWidget(new Button(this.leftPos + 6, this.topPos + 93, 77, 20, new TextComponent("Apply"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new HealthChangerBlockGUIButtonMessage(0, x, y, z));
				HealthChangerBlockGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		rangeField = new EditBox(this.font, this.leftPos + 6, this.topPos + 71, 162, 20, new TextComponent("Range")) {
			{
				setSuggestion("Range");
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion("Range");
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion("Range");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:rangeField", rangeField);
		rangeField.setMaxLength(32767);
		this.addWidget(this.rangeField);
		healthLevelField = new EditBox(this.font, this.leftPos + 6, this.topPos + 8, 162, 20, new TextComponent(""));
		guistate.put("text:healthLevelField", healthLevelField);
		healthLevelField.setMaxLength(32767);
		this.addWidget(this.healthLevelField);
		this.addRenderableWidget(new Button(this.leftPos + 6, this.topPos + 30, 162, 20, new TextComponent("Apply"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new HealthChangerBlockGUIButtonMessage(1, x, y, z));
				HealthChangerBlockGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 92, this.topPos + 93, 77, 20, new TextComponent("Edit"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new HealthChangerBlockGUIButtonMessage(2, x, y, z));
				HealthChangerBlockGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));
	}
}
