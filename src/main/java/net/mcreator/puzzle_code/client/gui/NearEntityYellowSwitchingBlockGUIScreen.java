package net.mcreator.puzzle_code.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.puzzle_code.world.inventory.NearEntityYellowSwitchingBlockGUIMenu;
import net.mcreator.puzzle_code.procedures.ReturnRangeProcedure;
import net.mcreator.puzzle_code.procedures.ReturnMinPowerProcedure;
import net.mcreator.puzzle_code.network.NearEntityYellowSwitchingBlockGUIButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class NearEntityYellowSwitchingBlockGUIScreen extends AbstractContainerScreen<NearEntityYellowSwitchingBlockGUIMenu> {
	private final static HashMap<String, Object> guistate = NearEntityYellowSwitchingBlockGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox minPowerField;
	EditBox rangeField;
	ImageButton imagebutton_enter_button;
	ImageButton imagebutton_enter_button1;
	ImageButton imagebutton_edit_button;
	ImageButton imagebutton_edit_button1;

	public NearEntityYellowSwitchingBlockGUIScreen(NearEntityYellowSwitchingBlockGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 110;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/screens/near_entity_yellow_switching_block_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		minPowerField.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (minPowerField.isFocused())
			return minPowerField.keyPressed(key, b, c);
		if (rangeField.isFocused())
			return rangeField.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		minPowerField.tick();
		rangeField.tick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.near_entity_yellow_switching_block_gui.label_power_needed_bnbtintegerminp"), 6, 30, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.near_entity_yellow_switching_block_gui.label_nbt_minpower"), 6, 43, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnMinPowerProcedure.execute(world, x, y, z), 83, 30, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.near_entity_yellow_switching_block_gui.label_range"), 6, 79, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnRangeProcedure.execute(world, x, y, z), 42, 79, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.near_entity_yellow_switching_block_gui.label_nbt_range"), 6, 93, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		minPowerField = new EditBox(this.font, this.leftPos + 7, this.topPos + 8, 111, 18, Component.translatable("gui.puzzle_code.near_entity_yellow_switching_block_gui.minPowerField"));
		minPowerField.setMaxLength(32767);
		guistate.put("text:minPowerField", minPowerField);
		this.addWidget(this.minPowerField);
		rangeField = new EditBox(this.font, this.leftPos + 7, this.topPos + 58, 111, 18, Component.translatable("gui.puzzle_code.near_entity_yellow_switching_block_gui.rangeField"));
		rangeField.setMaxLength(32767);
		guistate.put("text:rangeField", rangeField);
		this.addWidget(this.rangeField);
		imagebutton_enter_button = new ImageButton(this.leftPos + 146, this.topPos + 7, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_enter_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new NearEntityYellowSwitchingBlockGUIButtonMessage(0, x, y, z));
				NearEntityYellowSwitchingBlockGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_enter_button", imagebutton_enter_button);
		this.addRenderableWidget(imagebutton_enter_button);
		imagebutton_enter_button1 = new ImageButton(this.leftPos + 146, this.topPos + 57, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_enter_button1.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new NearEntityYellowSwitchingBlockGUIButtonMessage(1, x, y, z));
				NearEntityYellowSwitchingBlockGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_enter_button1", imagebutton_enter_button1);
		this.addRenderableWidget(imagebutton_enter_button1);
		imagebutton_edit_button = new ImageButton(this.leftPos + 123, this.topPos + 57, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_edit_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new NearEntityYellowSwitchingBlockGUIButtonMessage(2, x, y, z));
				NearEntityYellowSwitchingBlockGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_edit_button", imagebutton_edit_button);
		this.addRenderableWidget(imagebutton_edit_button);
		imagebutton_edit_button1 = new ImageButton(this.leftPos + 123, this.topPos + 7, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_edit_button1.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new NearEntityYellowSwitchingBlockGUIButtonMessage(3, x, y, z));
				NearEntityYellowSwitchingBlockGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_edit_button1", imagebutton_edit_button1);
		this.addRenderableWidget(imagebutton_edit_button1);
	}
}
