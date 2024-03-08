package net.mcreator.puzzle_code.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.puzzle_code.world.inventory.AdvancedPlacerBlockGUIRangeMenu;
import net.mcreator.puzzle_code.procedures.ReturnRangeProcedure;
import net.mcreator.puzzle_code.network.AdvancedPlacerBlockGUIRangeButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class AdvancedPlacerBlockGUIRangeScreen extends AbstractContainerScreen<AdvancedPlacerBlockGUIRangeMenu> {
	private final static HashMap<String, Object> guistate = AdvancedPlacerBlockGUIRangeMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox rangeField;
	Button button_apply;
	Button button_edit;
	Button button_back;

	public AdvancedPlacerBlockGUIRangeScreen(AdvancedPlacerBlockGUIRangeMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 114;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/screens/advanced_placer_block_gui_range.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		rangeField.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (rangeField.isFocused())
			return rangeField.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		rangeField.tick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.advanced_placer_block_gui_range.label_range"), 74, 4, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnRangeProcedure.execute(world, x, y, z), 6, 40, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.advanced_placer_block_gui_range.label_nbt_range"), 6, 53, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		rangeField = new EditBox(this.font, this.leftPos + 7, this.topPos + 18, 160, 18, Component.translatable("gui.puzzle_code.advanced_placer_block_gui_range.rangeField"));
		rangeField.setMaxLength(32767);
		guistate.put("text:rangeField", rangeField);
		this.addWidget(this.rangeField);
		button_apply = Button.builder(Component.translatable("gui.puzzle_code.advanced_placer_block_gui_range.button_apply"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new AdvancedPlacerBlockGUIRangeButtonMessage(0, x, y, z));
				AdvancedPlacerBlockGUIRangeButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 67, 77, 20).build();
		guistate.put("button:button_apply", button_apply);
		this.addRenderableWidget(button_apply);
		button_edit = Button.builder(Component.translatable("gui.puzzle_code.advanced_placer_block_gui_range.button_edit"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new AdvancedPlacerBlockGUIRangeButtonMessage(1, x, y, z));
				AdvancedPlacerBlockGUIRangeButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 92, this.topPos + 67, 76, 20).build();
		guistate.put("button:button_edit", button_edit);
		this.addRenderableWidget(button_edit);
		button_back = Button.builder(Component.translatable("gui.puzzle_code.advanced_placer_block_gui_range.button_back"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new AdvancedPlacerBlockGUIRangeButtonMessage(2, x, y, z));
				AdvancedPlacerBlockGUIRangeButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 89, 162, 20).build();
		guistate.put("button:button_back", button_back);
		this.addRenderableWidget(button_back);
	}
}
