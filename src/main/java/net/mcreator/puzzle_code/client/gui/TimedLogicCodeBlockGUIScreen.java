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

import net.mcreator.puzzle_code.world.inventory.TimedLogicCodeBlockGUIMenu;
import net.mcreator.puzzle_code.procedures.ReturnTrueDelayProcedure;
import net.mcreator.puzzle_code.procedures.ReturnFalseDelayProcedure;
import net.mcreator.puzzle_code.procedures.LogicCodeBlockDisplayOnProcedure;
import net.mcreator.puzzle_code.procedures.LogicCodeBlockDisplayOffProcedure;
import net.mcreator.puzzle_code.network.TimedLogicCodeBlockGUIButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class TimedLogicCodeBlockGUIScreen extends AbstractContainerScreen<TimedLogicCodeBlockGUIMenu> {
	private final static HashMap<String, Object> guistate = TimedLogicCodeBlockGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox trueDelayField;
	EditBox falseDelayField;
	ImageButton imagebutton_enter_button;
	ImageButton imagebutton_edit_button;
	ImageButton imagebutton_edit_button1;
	ImageButton imagebutton_enter_button1;

	public TimedLogicCodeBlockGUIScreen(TimedLogicCodeBlockGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/screens/timed_logic_code_block_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		trueDelayField.render(guiGraphics, mouseX, mouseY, partialTicks);
		falseDelayField.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		if (LogicCodeBlockDisplayOnProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("puzzle_code:textures/screens/logic_true.png"), this.leftPos + 69, this.topPos + 138, 0, 0, 48, 20, 48, 20);
		}
		if (LogicCodeBlockDisplayOffProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("puzzle_code:textures/screens/logic_false.png"), this.leftPos + 69, this.topPos + 138, 0, 0, 48, 20, 48, 20);
		}
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (trueDelayField.isFocused())
			return trueDelayField.keyPressed(key, b, c);
		if (falseDelayField.isFocused())
			return falseDelayField.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		trueDelayField.tick();
		falseDelayField.tick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.timed_logic_code_block_gui.label_nbt_truedelay"), 6, 30, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.timed_logic_code_block_gui.label_falsedelay"), 6, 79, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.timed_logic_code_block_gui.label_nbt_logiccodeblock"), 6, 124, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnTrueDelayProcedure.execute(world, x, y, z), 6, 43, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnFalseDelayProcedure.execute(world, x, y, z), 6, 93, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		trueDelayField = new EditBox(this.font, this.leftPos + 7, this.topPos + 8, 111, 18, Component.translatable("gui.puzzle_code.timed_logic_code_block_gui.trueDelayField"));
		trueDelayField.setMaxLength(32767);
		guistate.put("text:trueDelayField", trueDelayField);
		this.addWidget(this.trueDelayField);
		falseDelayField = new EditBox(this.font, this.leftPos + 7, this.topPos + 58, 111, 18, Component.translatable("gui.puzzle_code.timed_logic_code_block_gui.falseDelayField"));
		falseDelayField.setMaxLength(32767);
		guistate.put("text:falseDelayField", falseDelayField);
		this.addWidget(this.falseDelayField);
		imagebutton_enter_button = new ImageButton(this.leftPos + 146, this.topPos + 7, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_enter_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new TimedLogicCodeBlockGUIButtonMessage(0, x, y, z));
				TimedLogicCodeBlockGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_enter_button", imagebutton_enter_button);
		this.addRenderableWidget(imagebutton_enter_button);
		imagebutton_edit_button = new ImageButton(this.leftPos + 123, this.topPos + 7, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_edit_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new TimedLogicCodeBlockGUIButtonMessage(1, x, y, z));
				TimedLogicCodeBlockGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_edit_button", imagebutton_edit_button);
		this.addRenderableWidget(imagebutton_edit_button);
		imagebutton_edit_button1 = new ImageButton(this.leftPos + 123, this.topPos + 57, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_edit_button1.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new TimedLogicCodeBlockGUIButtonMessage(2, x, y, z));
				TimedLogicCodeBlockGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_edit_button1", imagebutton_edit_button1);
		this.addRenderableWidget(imagebutton_edit_button1);
		imagebutton_enter_button1 = new ImageButton(this.leftPos + 146, this.topPos + 57, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_enter_button1.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new TimedLogicCodeBlockGUIButtonMessage(3, x, y, z));
				TimedLogicCodeBlockGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_enter_button1", imagebutton_enter_button1);
		this.addRenderableWidget(imagebutton_enter_button1);
	}
}
