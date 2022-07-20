
package net.mcreator.puzzle_code.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.puzzle_code.world.inventory.PositionSetGUIMenu;
import net.mcreator.puzzle_code.network.PuzzleCodeModVariables;
import net.mcreator.puzzle_code.network.PositionSetGUIButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class PositionSetGUIScreen extends AbstractContainerScreen<PositionSetGUIMenu> {
	private final static HashMap<String, Object> guistate = PositionSetGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public PositionSetGUIScreen(PositionSetGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 114;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/position_set_gui.png");

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
		this.font.draw(poseStack, "X: " + ((entity.getCapability(PuzzleCodeModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new PuzzleCodeModVariables.PlayerVariables())).positionSetXPos2) + "", 6, 35, -12829636);
		this.font.draw(poseStack, "Y: " + ((entity.getCapability(PuzzleCodeModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new PuzzleCodeModVariables.PlayerVariables())).positionSetYPos2) + "", 6, 49, -12829636);
		this.font.draw(poseStack, "Z: " + ((entity.getCapability(PuzzleCodeModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new PuzzleCodeModVariables.PlayerVariables())).positionSetZPos2) + "", 6, 62, -12829636);
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
		this.addRenderableWidget(new Button(this.leftPos + 6, this.topPos + 8, 45, 20, new TextComponent("Copy"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new PositionSetGUIButtonMessage(0, x, y, z));
				PositionSetGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 60, this.topPos + 8, 45, 20, new TextComponent("Paste"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new PositionSetGUIButtonMessage(1, x, y, z));
				PositionSetGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 114, this.topPos + 8, 45, 20, new TextComponent("Paste2"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new PositionSetGUIButtonMessage(2, x, y, z));
				PositionSetGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));
	}
}
