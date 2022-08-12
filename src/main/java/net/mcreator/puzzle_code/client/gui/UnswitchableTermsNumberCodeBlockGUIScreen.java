
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

import net.mcreator.puzzle_code.world.inventory.UnswitchableTermsNumberCodeBlockGUIMenu;
import net.mcreator.puzzle_code.network.UnswitchableTermsNumberCodeBlockGUIButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class UnswitchableTermsNumberCodeBlockGUIScreen extends AbstractContainerScreen<UnswitchableTermsNumberCodeBlockGUIMenu> {
	private final static HashMap<String, Object> guistate = UnswitchableTermsNumberCodeBlockGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public UnswitchableTermsNumberCodeBlockGUIScreen(UnswitchableTermsNumberCodeBlockGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 174;
		this.imageHeight = 133;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/screens/unswitchable_terms_number_code_block_gui.png");

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
		this.font.draw(poseStack, "" + (new Object() {
			public String getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getTileData().getString(tag);
				return "";
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "term1")) + "", 5, 26, -12829636);
		this.font.draw(poseStack, "Is Disabled: " + (new Object() {
			public boolean getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "isDisabled")) + "", 5, 112, -12829636);
		this.font.draw(poseStack, "Term 1", 5, 8, -12829636);
		this.font.draw(poseStack, "" + (new Object() {
			public String getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getTileData().getString(tag);
				return "";
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "term2")) + "", 5, 71, -12829636);
		this.font.draw(poseStack, "Term 2", 5, 53, -12829636);
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
		this.addRenderableWidget(new Button(this.leftPos + 41, this.topPos + 4, 36, 20, new TextComponent("Left"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new UnswitchableTermsNumberCodeBlockGUIButtonMessage(0, x, y, z));
				UnswitchableTermsNumberCodeBlockGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 77, this.topPos + 4, 36, 20, new TextComponent("Back"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new UnswitchableTermsNumberCodeBlockGUIButtonMessage(1, x, y, z));
				UnswitchableTermsNumberCodeBlockGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 113, this.topPos + 4, 36, 20, new TextComponent("Right"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new UnswitchableTermsNumberCodeBlockGUIButtonMessage(2, x, y, z));
				UnswitchableTermsNumberCodeBlockGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 5, this.topPos + 85, 162, 20, new TextComponent("Switch"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new UnswitchableTermsNumberCodeBlockGUIButtonMessage(3, x, y, z));
				UnswitchableTermsNumberCodeBlockGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 41, this.topPos + 49, 36, 20, new TextComponent("Left"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new UnswitchableTermsNumberCodeBlockGUIButtonMessage(4, x, y, z));
				UnswitchableTermsNumberCodeBlockGUIButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 77, this.topPos + 49, 36, 20, new TextComponent("Back"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new UnswitchableTermsNumberCodeBlockGUIButtonMessage(5, x, y, z));
				UnswitchableTermsNumberCodeBlockGUIButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 113, this.topPos + 49, 36, 20, new TextComponent("Right"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new UnswitchableTermsNumberCodeBlockGUIButtonMessage(6, x, y, z));
				UnswitchableTermsNumberCodeBlockGUIButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}));
	}
}
