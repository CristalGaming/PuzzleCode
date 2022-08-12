
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

import net.mcreator.puzzle_code.world.inventory.CreativeSettingsGUIMenu;
import net.mcreator.puzzle_code.procedures.BlocksAffectsYouTextCreativeItemProcedure;
import net.mcreator.puzzle_code.network.CreativeSettingsGUIButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class CreativeSettingsGUIScreen extends AbstractContainerScreen<CreativeSettingsGUIMenu> {
	private final static HashMap<String, Object> guistate = CreativeSettingsGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public CreativeSettingsGUIScreen(CreativeSettingsGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 269;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/screens/creative_settings_gui.png");

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
		if (BlocksAffectsYouTextCreativeItemProcedure.execute(world))
			this.font.draw(poseStack, "ON", 128, 102, -12829636);
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
		this.addRenderableWidget(new Button(this.leftPos + 6, this.topPos + 97, 120, 20, new TextComponent("Blocks Affects You?"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CreativeSettingsGUIButtonMessage(0, x, y, z));
				CreativeSettingsGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 6, this.topPos + 75, 120, 20, new TextComponent("Place a fake block"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CreativeSettingsGUIButtonMessage(1, x, y, z));
				CreativeSettingsGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 141, this.topPos + 52, 121, 20, new TextComponent("Time Set Day"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CreativeSettingsGUIButtonMessage(2, x, y, z));
				CreativeSettingsGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 177, this.topPos + 30, 86, 20, new TextComponent("Clean effects"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CreativeSettingsGUIButtonMessage(3, x, y, z));
				CreativeSettingsGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 6, this.topPos + 30, 63, 20, new TextComponent("Reset HP"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CreativeSettingsGUIButtonMessage(4, x, y, z));
				CreativeSettingsGUIButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 74, this.topPos + 30, 99, 20, new TextComponent("Reset Hunger"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CreativeSettingsGUIButtonMessage(5, x, y, z));
				CreativeSettingsGUIButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 6, this.topPos + 52, 131, 20, new TextComponent("Time Set Night"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CreativeSettingsGUIButtonMessage(6, x, y, z));
				CreativeSettingsGUIButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 6, this.topPos + 7, 59, 20, new TextComponent("Creative"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CreativeSettingsGUIButtonMessage(7, x, y, z));
				CreativeSettingsGUIButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 69, this.topPos + 7, 63, 20, new TextComponent("Survival"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CreativeSettingsGUIButtonMessage(8, x, y, z));
				CreativeSettingsGUIButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 137, this.topPos + 7, 72, 20, new TextComponent("Spectator"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CreativeSettingsGUIButtonMessage(9, x, y, z));
				CreativeSettingsGUIButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 191, this.topPos + 97, 72, 20, new TextComponent("Spawnpoint"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CreativeSettingsGUIButtonMessage(10, x, y, z));
				CreativeSettingsGUIButtonMessage.handleButtonAction(entity, 10, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 6, this.topPos + 138, 117, 20, new TextComponent("Creative Items"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CreativeSettingsGUIButtonMessage(11, x, y, z));
				CreativeSettingsGUIButtonMessage.handleButtonAction(entity, 11, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 177, this.topPos + 138, 87, 20, new TextComponent("Game Rules"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CreativeSettingsGUIButtonMessage(12, x, y, z));
				CreativeSettingsGUIButtonMessage.handleButtonAction(entity, 12, x, y, z);
			}
		}));
	}
}
