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

import net.mcreator.puzzle_code.world.inventory.WalkingBlockGUIMenu;
import net.mcreator.puzzle_code.procedures.ReturnWaitingOnTicksProcedure;
import net.mcreator.puzzle_code.procedures.ReturnWaitingOffTicksProcedure;
import net.mcreator.puzzle_code.network.WalkingBlockGUIButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class WalkingBlockGUIScreen extends AbstractContainerScreen<WalkingBlockGUIMenu> {
	private final static HashMap<String, Object> guistate = WalkingBlockGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox waitingOffField;
	EditBox waitingOnField;
	ImageButton imagebutton_enter_button;
	ImageButton imagebutton_edit_button;
	ImageButton imagebutton_enter_button1;
	ImageButton imagebutton_edit_button1;

	public WalkingBlockGUIScreen(WalkingBlockGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 177;
		this.imageHeight = 110;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/screens/walking_block_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		waitingOffField.render(guiGraphics, mouseX, mouseY, partialTicks);
		waitingOnField.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (waitingOffField.isFocused())
			return waitingOffField.keyPressed(key, b, c);
		if (waitingOnField.isFocused())
			return waitingOnField.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		waitingOffField.tick();
		waitingOnField.tick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.walking_block_gui.label_waiting_to_switch_off_bnbtnum"), 7, 29, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.walking_block_gui.label_waiting_to_switch_on_bnbtnumb"), 7, 78, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnWaitingOffTicksProcedure.execute(world, x, y, z), 106, 78, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnWaitingOnTicksProcedure.execute(world, x, y, z), 102, 29, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.walking_block_gui.label_nbt_waitingoffticks"), 7, 92, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.walking_block_gui.label_nbt_waitingonticks"), 7, 42, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		waitingOffField = new EditBox(this.font, this.leftPos + 8, this.topPos + 7, 111, 18, Component.translatable("gui.puzzle_code.walking_block_gui.waitingOffField"));
		waitingOffField.setMaxLength(32767);
		guistate.put("text:waitingOffField", waitingOffField);
		this.addWidget(this.waitingOffField);
		waitingOnField = new EditBox(this.font, this.leftPos + 8, this.topPos + 57, 111, 18, Component.translatable("gui.puzzle_code.walking_block_gui.waitingOnField"));
		waitingOnField.setMaxLength(32767);
		guistate.put("text:waitingOnField", waitingOnField);
		this.addWidget(this.waitingOnField);
		imagebutton_enter_button = new ImageButton(this.leftPos + 147, this.topPos + 6, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_enter_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new WalkingBlockGUIButtonMessage(0, x, y, z));
				WalkingBlockGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_enter_button", imagebutton_enter_button);
		this.addRenderableWidget(imagebutton_enter_button);
		imagebutton_edit_button = new ImageButton(this.leftPos + 124, this.topPos + 6, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_edit_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new WalkingBlockGUIButtonMessage(1, x, y, z));
				WalkingBlockGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_edit_button", imagebutton_edit_button);
		this.addRenderableWidget(imagebutton_edit_button);
		imagebutton_enter_button1 = new ImageButton(this.leftPos + 147, this.topPos + 56, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_enter_button1.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new WalkingBlockGUIButtonMessage(2, x, y, z));
				WalkingBlockGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_enter_button1", imagebutton_enter_button1);
		this.addRenderableWidget(imagebutton_enter_button1);
		imagebutton_edit_button1 = new ImageButton(this.leftPos + 124, this.topPos + 56, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_edit_button1.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new WalkingBlockGUIButtonMessage(3, x, y, z));
				WalkingBlockGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_edit_button1", imagebutton_edit_button1);
		this.addRenderableWidget(imagebutton_edit_button1);
	}
}
