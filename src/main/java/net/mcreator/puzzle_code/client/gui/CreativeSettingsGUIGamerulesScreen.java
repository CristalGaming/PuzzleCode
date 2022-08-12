
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

import net.mcreator.puzzle_code.world.inventory.CreativeSettingsGUIGamerulesMenu;
import net.mcreator.puzzle_code.procedures.CreativeSettingsGUIGamerulesKeepInventoryProcedure;
import net.mcreator.puzzle_code.procedures.CreativeSettingsGUIGamerulesDoWeatherCycleProcedure;
import net.mcreator.puzzle_code.procedures.CreativeSettingsGUIGamerulesDoMobSpawiningProcedure;
import net.mcreator.puzzle_code.procedures.CreativeSettingsGUIGamerulesDoDaylightCyclesProcedure;
import net.mcreator.puzzle_code.network.CreativeSettingsGUIGamerulesButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class CreativeSettingsGUIGamerulesScreen extends AbstractContainerScreen<CreativeSettingsGUIGamerulesMenu> {
	private final static HashMap<String, Object> guistate = CreativeSettingsGUIGamerulesMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public CreativeSettingsGUIGamerulesScreen(CreativeSettingsGUIGamerulesMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/screens/creative_settings_gui_gamerules.png");

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
		if (CreativeSettingsGUIGamerulesDoDaylightCyclesProcedure.execute(world))
			this.font.draw(poseStack, "true", 114, 12, -12829636);
		if (CreativeSettingsGUIGamerulesKeepInventoryProcedure.execute(world))
			this.font.draw(poseStack, "true", 114, 34, -12829636);
		if (CreativeSettingsGUIGamerulesDoMobSpawiningProcedure.execute(world))
			this.font.draw(poseStack, "true", 114, 57, -12829636);
		if (CreativeSettingsGUIGamerulesDoWeatherCycleProcedure.execute(world))
			this.font.draw(poseStack, "true", 114, 79, -12829636);
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
		this.addRenderableWidget(new Button(this.leftPos + 6, this.topPos + 7, 104, 20, new TextComponent("doDaylightCycle"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CreativeSettingsGUIGamerulesButtonMessage(0, x, y, z));
				CreativeSettingsGUIGamerulesButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 6, this.topPos + 30, 104, 20, new TextComponent("KeepInventory"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CreativeSettingsGUIGamerulesButtonMessage(1, x, y, z));
				CreativeSettingsGUIGamerulesButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 6, this.topPos + 52, 104, 20, new TextComponent("doMobSpawning"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CreativeSettingsGUIGamerulesButtonMessage(2, x, y, z));
				CreativeSettingsGUIGamerulesButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 6, this.topPos + 75, 104, 20, new TextComponent("DoWeaterCycle"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CreativeSettingsGUIGamerulesButtonMessage(3, x, y, z));
				CreativeSettingsGUIGamerulesButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 123, this.topPos + 138, 46, 20, new TextComponent("Back"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CreativeSettingsGUIGamerulesButtonMessage(4, x, y, z));
				CreativeSettingsGUIGamerulesButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}));
	}
}
