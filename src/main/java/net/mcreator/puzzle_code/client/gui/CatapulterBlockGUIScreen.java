package net.mcreator.puzzle_code.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.puzzle_code.world.inventory.CatapulterBlockGUIMenu;
import net.mcreator.puzzle_code.procedures.ReturnzPosProcedure;
import net.mcreator.puzzle_code.procedures.ReturnyPosProcedure;
import net.mcreator.puzzle_code.procedures.ReturnxPosProcedure;
import net.mcreator.puzzle_code.network.CatapulterBlockGUIButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class CatapulterBlockGUIScreen extends AbstractContainerScreen<CatapulterBlockGUIMenu> {
	private final static HashMap<String, Object> guistate = CatapulterBlockGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox xPosField;
	EditBox yPosField;
	EditBox zPosField;
	Button button_1;
	Button button_2;
	ImageButton imagebutton_enter_button;
	ImageButton imagebutton_edit_button;
	ImageButton imagebutton_enter_button1;
	ImageButton imagebutton_edit_button1;
	ImageButton imagebutton_enter_button2;
	ImageButton imagebutton_edit_button2;

	public CatapulterBlockGUIScreen(CatapulterBlockGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 142;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/screens/catapulter_block_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		xPosField.render(guiGraphics, mouseX, mouseY, partialTicks);
		yPosField.render(guiGraphics, mouseX, mouseY, partialTicks);
		zPosField.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (xPosField.isFocused())
			return xPosField.keyPressed(key, b, c);
		if (yPosField.isFocused())
			return yPosField.keyPressed(key, b, c);
		if (zPosField.isFocused())
			return zPosField.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		xPosField.tick();
		yPosField.tick();
		zPosField.tick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.catapulter_block_gui.label_x_position"), 6, 31, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnxPosProcedure.execute(world, x, y, z), 69, 31, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.catapulter_block_gui.label_y_position"), 6, 67, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.catapulter_block_gui.label_z_position"), 6, 103, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnyPosProcedure.execute(world, x, y, z), 69, 67, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnzPosProcedure.execute(world, x, y, z), 69, 103, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		xPosField = new EditBox(this.font, this.leftPos + 7, this.topPos + 10, 111, 18, Component.translatable("gui.puzzle_code.catapulter_block_gui.xPosField"));
		xPosField.setMaxLength(32767);
		guistate.put("text:xPosField", xPosField);
		this.addWidget(this.xPosField);
		yPosField = new EditBox(this.font, this.leftPos + 7, this.topPos + 46, 111, 18, Component.translatable("gui.puzzle_code.catapulter_block_gui.yPosField"));
		yPosField.setMaxLength(32767);
		guistate.put("text:yPosField", yPosField);
		this.addWidget(this.yPosField);
		zPosField = new EditBox(this.font, this.leftPos + 7, this.topPos + 82, 111, 18, Component.translatable("gui.puzzle_code.catapulter_block_gui.zPosField"));
		zPosField.setMaxLength(32767);
		guistate.put("text:zPosField", zPosField);
		this.addWidget(this.zPosField);
		button_1 = Button.builder(Component.translatable("gui.puzzle_code.catapulter_block_gui.button_1"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CatapulterBlockGUIButtonMessage(0, x, y, z));
				CatapulterBlockGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 65, this.topPos + 117, 18, 20).build();
		guistate.put("button:button_1", button_1);
		this.addRenderableWidget(button_1);
		button_2 = Button.builder(Component.translatable("gui.puzzle_code.catapulter_block_gui.button_2"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CatapulterBlockGUIButtonMessage(1, x, y, z));
				CatapulterBlockGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 92, this.topPos + 117, 18, 20).build();
		guistate.put("button:button_2", button_2);
		this.addRenderableWidget(button_2);
		imagebutton_enter_button = new ImageButton(this.leftPos + 146, this.topPos + 9, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_enter_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CatapulterBlockGUIButtonMessage(2, x, y, z));
				CatapulterBlockGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_enter_button", imagebutton_enter_button);
		this.addRenderableWidget(imagebutton_enter_button);
		imagebutton_edit_button = new ImageButton(this.leftPos + 123, this.topPos + 9, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_edit_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CatapulterBlockGUIButtonMessage(3, x, y, z));
				CatapulterBlockGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_edit_button", imagebutton_edit_button);
		this.addRenderableWidget(imagebutton_edit_button);
		imagebutton_enter_button1 = new ImageButton(this.leftPos + 146, this.topPos + 45, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_enter_button1.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CatapulterBlockGUIButtonMessage(4, x, y, z));
				CatapulterBlockGUIButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:imagebutton_enter_button1", imagebutton_enter_button1);
		this.addRenderableWidget(imagebutton_enter_button1);
		imagebutton_edit_button1 = new ImageButton(this.leftPos + 123, this.topPos + 45, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_edit_button1.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CatapulterBlockGUIButtonMessage(5, x, y, z));
				CatapulterBlockGUIButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:imagebutton_edit_button1", imagebutton_edit_button1);
		this.addRenderableWidget(imagebutton_edit_button1);
		imagebutton_enter_button2 = new ImageButton(this.leftPos + 146, this.topPos + 81, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_enter_button2.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CatapulterBlockGUIButtonMessage(6, x, y, z));
				CatapulterBlockGUIButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		});
		guistate.put("button:imagebutton_enter_button2", imagebutton_enter_button2);
		this.addRenderableWidget(imagebutton_enter_button2);
		imagebutton_edit_button2 = new ImageButton(this.leftPos + 123, this.topPos + 81, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_edit_button2.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CatapulterBlockGUIButtonMessage(7, x, y, z));
				CatapulterBlockGUIButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		});
		guistate.put("button:imagebutton_edit_button2", imagebutton_edit_button2);
		this.addRenderableWidget(imagebutton_edit_button2);
	}
}
