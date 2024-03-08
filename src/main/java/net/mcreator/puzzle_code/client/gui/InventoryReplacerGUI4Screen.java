package net.mcreator.puzzle_code.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.puzzle_code.world.inventory.InventoryReplacerGUI4Menu;
import net.mcreator.puzzle_code.procedures.ReplaceInventoryDisplayOffProcedure;
import net.mcreator.puzzle_code.procedures.ReplaceHotbarDisplayOffProcedure;
import net.mcreator.puzzle_code.procedures.ReplaceArmorDisplayOffProcedure;
import net.mcreator.puzzle_code.procedures.DisplayReplaceInventoryProcedure;
import net.mcreator.puzzle_code.procedures.DisplayReplaceHotbarProcedure;
import net.mcreator.puzzle_code.procedures.DisplayReplaceArmorProcedure;
import net.mcreator.puzzle_code.network.InventoryReplacerGUI4ButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class InventoryReplacerGUI4Screen extends AbstractContainerScreen<InventoryReplacerGUI4Menu> {
	private final static HashMap<String, Object> guistate = InventoryReplacerGUI4Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_replace_hotbar_slots;
	Button button_replace_slots_inventory;
	Button button_replace_armor_slots;
	Button button_1;
	Button button_2;
	Button button_3;
	Button button_4;

	public InventoryReplacerGUI4Screen(InventoryReplacerGUI4Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 171;
		this.imageHeight = 147;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/screens/inventory_replacer_gui_4.png");

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
		if (DisplayReplaceHotbarProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("puzzle_code:textures/screens/logic_true.png"), this.leftPos + -45, this.topPos + 6, 0, 0, 48, 20, 48, 20);
		}
		if (ReplaceHotbarDisplayOffProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("puzzle_code:textures/screens/logic_false.png"), this.leftPos + -45, this.topPos + 6, 0, 0, 48, 20, 48, 20);
		}
		if (DisplayReplaceInventoryProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("puzzle_code:textures/screens/logic_true.png"), this.leftPos + -45, this.topPos + 42, 0, 0, 48, 20, 48, 20);
		}
		if (ReplaceInventoryDisplayOffProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("puzzle_code:textures/screens/logic_false.png"), this.leftPos + -45, this.topPos + 42, 0, 0, 48, 20, 48, 20);
		}
		if (DisplayReplaceArmorProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("puzzle_code:textures/screens/logic_true.png"), this.leftPos + -45, this.topPos + 78, 0, 0, 48, 20, 48, 20);
		}
		if (ReplaceArmorDisplayOffProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("puzzle_code:textures/screens/logic_false.png"), this.leftPos + -45, this.topPos + 78, 0, 0, 48, 20, 48, 20);
		}
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
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.inventory_replacer_gui_4.label_nbt_replacearmor"), 9, 101, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.inventory_replacer_gui_4.label_nbt_replaceinventory"), 9, 65, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.inventory_replacer_gui_4.label_nbt_replacehotbar"), 9, 29, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_replace_hotbar_slots = Button.builder(Component.translatable("gui.puzzle_code.inventory_replacer_gui_4.button_replace_hotbar_slots"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new InventoryReplacerGUI4ButtonMessage(0, x, y, z));
				InventoryReplacerGUI4ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 9, this.topPos + 6, 153, 20).build();
		guistate.put("button:button_replace_hotbar_slots", button_replace_hotbar_slots);
		this.addRenderableWidget(button_replace_hotbar_slots);
		button_replace_slots_inventory = Button.builder(Component.translatable("gui.puzzle_code.inventory_replacer_gui_4.button_replace_slots_inventory"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new InventoryReplacerGUI4ButtonMessage(1, x, y, z));
				InventoryReplacerGUI4ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 9, this.topPos + 42, 153, 20).build();
		guistate.put("button:button_replace_slots_inventory", button_replace_slots_inventory);
		this.addRenderableWidget(button_replace_slots_inventory);
		button_replace_armor_slots = Button.builder(Component.translatable("gui.puzzle_code.inventory_replacer_gui_4.button_replace_armor_slots"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new InventoryReplacerGUI4ButtonMessage(2, x, y, z));
				InventoryReplacerGUI4ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 9, this.topPos + 78, 153, 20).build();
		guistate.put("button:button_replace_armor_slots", button_replace_armor_slots);
		this.addRenderableWidget(button_replace_armor_slots);
		button_1 = Button.builder(Component.translatable("gui.puzzle_code.inventory_replacer_gui_4.button_1"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new InventoryReplacerGUI4ButtonMessage(3, x, y, z));
				InventoryReplacerGUI4ButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 49, this.topPos + 123, 18, 20).build();
		guistate.put("button:button_1", button_1);
		this.addRenderableWidget(button_1);
		button_2 = Button.builder(Component.translatable("gui.puzzle_code.inventory_replacer_gui_4.button_2"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new InventoryReplacerGUI4ButtonMessage(4, x, y, z));
				InventoryReplacerGUI4ButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + 67, this.topPos + 123, 18, 20).build();
		guistate.put("button:button_2", button_2);
		this.addRenderableWidget(button_2);
		button_3 = Button.builder(Component.translatable("gui.puzzle_code.inventory_replacer_gui_4.button_3"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new InventoryReplacerGUI4ButtonMessage(5, x, y, z));
				InventoryReplacerGUI4ButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}).bounds(this.leftPos + 85, this.topPos + 123, 18, 20).build();
		guistate.put("button:button_3", button_3);
		this.addRenderableWidget(button_3);
		button_4 = Button.builder(Component.translatable("gui.puzzle_code.inventory_replacer_gui_4.button_4"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new InventoryReplacerGUI4ButtonMessage(6, x, y, z));
				InventoryReplacerGUI4ButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}).bounds(this.leftPos + 103, this.topPos + 123, 18, 20).build();
		guistate.put("button:button_4", button_4);
		this.addRenderableWidget(button_4);
	}
}
