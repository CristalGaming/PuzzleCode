
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

import net.mcreator.puzzle_code.world.inventory.InEffectBlockGUI3Menu;
import net.mcreator.puzzle_code.network.InEffectBlockGUI3ButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class InEffectBlockGUI3Screen extends AbstractContainerScreen<InEffectBlockGUI3Menu> {
	private final static HashMap<String, Object> guistate = InEffectBlockGUI3Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public InEffectBlockGUI3Screen(InEffectBlockGUI3Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 174;
		this.imageHeight = 141;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/screens/in_effect_block_gui_3.png");

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
		this.font.draw(poseStack, "Does redstone react? ", 5, 3, -12829636);
		this.font.draw(poseStack, "" + (new Object() {
			public boolean getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "redstoneReact")) + "", 5, 39, -12829636);
		this.font.draw(poseStack, "[3]", 41, 116, -12829636);
		this.font.draw(poseStack, "Does react continuously?", 5, 57, -12829636);
		this.font.draw(poseStack, "" + (new Object() {
			public boolean getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "redstoneContinuously")) + "", 5, 93, -12829636);
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
		this.addRenderableWidget(new Button(this.leftPos + 5, this.topPos + 17, 77, 20, new TextComponent("True"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new InEffectBlockGUI3ButtonMessage(0, x, y, z));
				InEffectBlockGUI3ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 91, this.topPos + 17, 76, 20, new TextComponent("False"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new InEffectBlockGUI3ButtonMessage(1, x, y, z));
				InEffectBlockGUI3ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 5, this.topPos + 111, 14, 20, new TextComponent("1"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new InEffectBlockGUI3ButtonMessage(2, x, y, z));
				InEffectBlockGUI3ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 23, this.topPos + 111, 14, 20, new TextComponent("2"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new InEffectBlockGUI3ButtonMessage(3, x, y, z));
				InEffectBlockGUI3ButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 59, this.topPos + 111, 14, 20, new TextComponent("4"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new InEffectBlockGUI3ButtonMessage(4, x, y, z));
				InEffectBlockGUI3ButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 77, this.topPos + 111, 14, 20, new TextComponent("5"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new InEffectBlockGUI3ButtonMessage(5, x, y, z));
				InEffectBlockGUI3ButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 5, this.topPos + 71, 77, 20, new TextComponent("True"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new InEffectBlockGUI3ButtonMessage(6, x, y, z));
				InEffectBlockGUI3ButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 91, this.topPos + 71, 76, 20, new TextComponent("False"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new InEffectBlockGUI3ButtonMessage(7, x, y, z));
				InEffectBlockGUI3ButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}));
	}
}
