package net.mcreator.puzzle_code.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.puzzle_code.world.inventory.CreativeSettingsGUIMenu;
import net.mcreator.puzzle_code.procedures.BlocksAffectsYouTextCreativeItemProcedure;
import net.mcreator.puzzle_code.network.CreativeSettingsGUIButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class CreativeSettingsGUIScreen extends AbstractContainerScreen<CreativeSettingsGUIMenu> {
	private final static HashMap<String, Object> guistate = CreativeSettingsGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_blocks_affects_you;
	Button button_place_a_fake_block;
	Button button_time_set_day;
	Button button_clean_effects;
	Button button_reset_hp;
	Button button_reset_hunger;
	Button button_time_set_night;
	Button button_creative;
	Button button_survival;
	Button button_spectator;
	Button button_spawnpoint;
	Button button_creative_items;
	Button button_game_rules;

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
		if (BlocksAffectsYouTextCreativeItemProcedure.execute(world))
			guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.creative_settings_gui.label_on"), 128, 102, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_blocks_affects_you = Button.builder(Component.translatable("gui.puzzle_code.creative_settings_gui.button_blocks_affects_you"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CreativeSettingsGUIButtonMessage(0, x, y, z));
				CreativeSettingsGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 97, 120, 20).build();
		guistate.put("button:button_blocks_affects_you", button_blocks_affects_you);
		this.addRenderableWidget(button_blocks_affects_you);
		button_place_a_fake_block = Button.builder(Component.translatable("gui.puzzle_code.creative_settings_gui.button_place_a_fake_block"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CreativeSettingsGUIButtonMessage(1, x, y, z));
				CreativeSettingsGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 75, 120, 20).build();
		guistate.put("button:button_place_a_fake_block", button_place_a_fake_block);
		this.addRenderableWidget(button_place_a_fake_block);
		button_time_set_day = Button.builder(Component.translatable("gui.puzzle_code.creative_settings_gui.button_time_set_day"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CreativeSettingsGUIButtonMessage(2, x, y, z));
				CreativeSettingsGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 141, this.topPos + 52, 121, 20).build();
		guistate.put("button:button_time_set_day", button_time_set_day);
		this.addRenderableWidget(button_time_set_day);
		button_clean_effects = Button.builder(Component.translatable("gui.puzzle_code.creative_settings_gui.button_clean_effects"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CreativeSettingsGUIButtonMessage(3, x, y, z));
				CreativeSettingsGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 177, this.topPos + 30, 86, 20).build();
		guistate.put("button:button_clean_effects", button_clean_effects);
		this.addRenderableWidget(button_clean_effects);
		button_reset_hp = Button.builder(Component.translatable("gui.puzzle_code.creative_settings_gui.button_reset_hp"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CreativeSettingsGUIButtonMessage(4, x, y, z));
				CreativeSettingsGUIButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 30, 63, 20).build();
		guistate.put("button:button_reset_hp", button_reset_hp);
		this.addRenderableWidget(button_reset_hp);
		button_reset_hunger = Button.builder(Component.translatable("gui.puzzle_code.creative_settings_gui.button_reset_hunger"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CreativeSettingsGUIButtonMessage(5, x, y, z));
				CreativeSettingsGUIButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}).bounds(this.leftPos + 74, this.topPos + 30, 99, 20).build();
		guistate.put("button:button_reset_hunger", button_reset_hunger);
		this.addRenderableWidget(button_reset_hunger);
		button_time_set_night = Button.builder(Component.translatable("gui.puzzle_code.creative_settings_gui.button_time_set_night"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CreativeSettingsGUIButtonMessage(6, x, y, z));
				CreativeSettingsGUIButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 52, 131, 20).build();
		guistate.put("button:button_time_set_night", button_time_set_night);
		this.addRenderableWidget(button_time_set_night);
		button_creative = Button.builder(Component.translatable("gui.puzzle_code.creative_settings_gui.button_creative"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CreativeSettingsGUIButtonMessage(7, x, y, z));
				CreativeSettingsGUIButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 7, 59, 20).build();
		guistate.put("button:button_creative", button_creative);
		this.addRenderableWidget(button_creative);
		button_survival = Button.builder(Component.translatable("gui.puzzle_code.creative_settings_gui.button_survival"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CreativeSettingsGUIButtonMessage(8, x, y, z));
				CreativeSettingsGUIButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		}).bounds(this.leftPos + 69, this.topPos + 7, 63, 20).build();
		guistate.put("button:button_survival", button_survival);
		this.addRenderableWidget(button_survival);
		button_spectator = Button.builder(Component.translatable("gui.puzzle_code.creative_settings_gui.button_spectator"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CreativeSettingsGUIButtonMessage(9, x, y, z));
				CreativeSettingsGUIButtonMessage.handleButtonAction(entity, 9, x, y, z);
			}
		}).bounds(this.leftPos + 137, this.topPos + 7, 72, 20).build();
		guistate.put("button:button_spectator", button_spectator);
		this.addRenderableWidget(button_spectator);
		button_spawnpoint = Button.builder(Component.translatable("gui.puzzle_code.creative_settings_gui.button_spawnpoint"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CreativeSettingsGUIButtonMessage(10, x, y, z));
				CreativeSettingsGUIButtonMessage.handleButtonAction(entity, 10, x, y, z);
			}
		}).bounds(this.leftPos + 191, this.topPos + 97, 72, 20).build();
		guistate.put("button:button_spawnpoint", button_spawnpoint);
		this.addRenderableWidget(button_spawnpoint);
		button_creative_items = Button.builder(Component.translatable("gui.puzzle_code.creative_settings_gui.button_creative_items"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CreativeSettingsGUIButtonMessage(11, x, y, z));
				CreativeSettingsGUIButtonMessage.handleButtonAction(entity, 11, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 138, 117, 20).build();
		guistate.put("button:button_creative_items", button_creative_items);
		this.addRenderableWidget(button_creative_items);
		button_game_rules = Button.builder(Component.translatable("gui.puzzle_code.creative_settings_gui.button_game_rules"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CreativeSettingsGUIButtonMessage(12, x, y, z));
				CreativeSettingsGUIButtonMessage.handleButtonAction(entity, 12, x, y, z);
			}
		}).bounds(this.leftPos + 177, this.topPos + 138, 87, 20).build();
		guistate.put("button:button_game_rules", button_game_rules);
		this.addRenderableWidget(button_game_rules);
	}
}
