package net.mcreator.puzzle_code.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.puzzle_code.world.inventory.CreativeSettingsGUIGamerulesMenu;
import net.mcreator.puzzle_code.procedures.CreativeSettingsGUIGamerulesKeepInventoryProcedure;
import net.mcreator.puzzle_code.procedures.CreativeSettingsGUIGamerulesDoWeatherCycleProcedure;
import net.mcreator.puzzle_code.procedures.CreativeSettingsGUIGamerulesDoMobSpawiningProcedure;
import net.mcreator.puzzle_code.procedures.CreativeSettingsGUIGamerulesDoDaylightCyclesProcedure;
import net.mcreator.puzzle_code.network.CreativeSettingsGUIGamerulesButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class CreativeSettingsGUIGamerulesScreen extends AbstractContainerScreen<CreativeSettingsGUIGamerulesMenu> {
	private final static HashMap<String, Object> guistate = CreativeSettingsGUIGamerulesMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_dodaylightcycle;
	Button button_keepinventory;
	Button button_domobspawning;
	Button button_doweatercycle;
	Button button_back;

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
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
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
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		if (CreativeSettingsGUIGamerulesDoDaylightCyclesProcedure.execute(world))
			guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.creative_settings_gui_gamerules.label_true"), 114, 12, -12829636, false);
		if (CreativeSettingsGUIGamerulesKeepInventoryProcedure.execute(world))
			guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.creative_settings_gui_gamerules.label_true1"), 114, 34, -12829636, false);
		if (CreativeSettingsGUIGamerulesDoMobSpawiningProcedure.execute(world))
			guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.creative_settings_gui_gamerules.label_true2"), 114, 57, -12829636, false);
		if (CreativeSettingsGUIGamerulesDoWeatherCycleProcedure.execute(world))
			guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.creative_settings_gui_gamerules.label_true3"), 114, 79, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_dodaylightcycle = Button.builder(Component.translatable("gui.puzzle_code.creative_settings_gui_gamerules.button_dodaylightcycle"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CreativeSettingsGUIGamerulesButtonMessage(0, x, y, z));
				CreativeSettingsGUIGamerulesButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 7, 104, 20).build();
		guistate.put("button:button_dodaylightcycle", button_dodaylightcycle);
		this.addRenderableWidget(button_dodaylightcycle);
		button_keepinventory = Button.builder(Component.translatable("gui.puzzle_code.creative_settings_gui_gamerules.button_keepinventory"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CreativeSettingsGUIGamerulesButtonMessage(1, x, y, z));
				CreativeSettingsGUIGamerulesButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 30, 104, 20).build();
		guistate.put("button:button_keepinventory", button_keepinventory);
		this.addRenderableWidget(button_keepinventory);
		button_domobspawning = Button.builder(Component.translatable("gui.puzzle_code.creative_settings_gui_gamerules.button_domobspawning"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CreativeSettingsGUIGamerulesButtonMessage(2, x, y, z));
				CreativeSettingsGUIGamerulesButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 52, 104, 20).build();
		guistate.put("button:button_domobspawning", button_domobspawning);
		this.addRenderableWidget(button_domobspawning);
		button_doweatercycle = Button.builder(Component.translatable("gui.puzzle_code.creative_settings_gui_gamerules.button_doweatercycle"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CreativeSettingsGUIGamerulesButtonMessage(3, x, y, z));
				CreativeSettingsGUIGamerulesButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 75, 104, 20).build();
		guistate.put("button:button_doweatercycle", button_doweatercycle);
		this.addRenderableWidget(button_doweatercycle);
		button_back = Button.builder(Component.translatable("gui.puzzle_code.creative_settings_gui_gamerules.button_back"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CreativeSettingsGUIGamerulesButtonMessage(4, x, y, z));
				CreativeSettingsGUIGamerulesButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + 123, this.topPos + 138, 46, 20).build();
		guistate.put("button:button_back", button_back);
		this.addRenderableWidget(button_back);
	}
}
