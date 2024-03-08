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

import net.mcreator.puzzle_code.world.inventory.FillerGui2Menu;
import net.mcreator.puzzle_code.procedures.ReturnzPos2Procedure;
import net.mcreator.puzzle_code.procedures.ReturnyPos2Procedure;
import net.mcreator.puzzle_code.procedures.ReturnxPos2Procedure;
import net.mcreator.puzzle_code.network.FillerGui2ButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class FillerGui2Screen extends AbstractContainerScreen<FillerGui2Menu> {
	private final static HashMap<String, Object> guistate = FillerGui2Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox xPos2Field;
	EditBox yPos2Field;
	EditBox zPos2Field;
	Button button_1;
	Button button_2;
	ImageButton imagebutton_enter_button;
	ImageButton imagebutton_edit_button;
	ImageButton imagebutton_enter_button1;
	ImageButton imagebutton_edit_button1;
	ImageButton imagebutton_enter_button2;
	ImageButton imagebutton_edit_button2;

	public FillerGui2Screen(FillerGui2Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 174;
		this.imageHeight = 152;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/screens/filler_gui_2.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		xPos2Field.render(guiGraphics, mouseX, mouseY, partialTicks);
		yPos2Field.render(guiGraphics, mouseX, mouseY, partialTicks);
		zPos2Field.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (xPos2Field.isFocused())
			return xPos2Field.keyPressed(key, b, c);
		if (yPos2Field.isFocused())
			return yPos2Field.keyPressed(key, b, c);
		if (zPos2Field.isFocused())
			return zPos2Field.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		xPos2Field.tick();
		yPos2Field.tick();
		zPos2Field.tick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.filler_gui_2.label_x2_bnbtintegerxpos2"), 5, 32, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.filler_gui_2.label_y2_bnbtintegerypos2"), 5, 68, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.filler_gui_2.label_z2_bnbtintegerzpos2"), 5, 104, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnxPos2Procedure.execute(world, x, y, z), 28, 32, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnyPos2Procedure.execute(world, x, y, z), 28, 68, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnzPos2Procedure.execute(world, x, y, z), 28, 104, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		xPos2Field = new EditBox(this.font, this.leftPos + 6, this.topPos + 10, 111, 18, Component.translatable("gui.puzzle_code.filler_gui_2.xPos2Field")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.puzzle_code.filler_gui_2.xPos2Field").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.puzzle_code.filler_gui_2.xPos2Field").getString());
				else
					setSuggestion(null);
			}
		};
		xPos2Field.setSuggestion(Component.translatable("gui.puzzle_code.filler_gui_2.xPos2Field").getString());
		xPos2Field.setMaxLength(32767);
		guistate.put("text:xPos2Field", xPos2Field);
		this.addWidget(this.xPos2Field);
		yPos2Field = new EditBox(this.font, this.leftPos + 6, this.topPos + 46, 111, 18, Component.translatable("gui.puzzle_code.filler_gui_2.yPos2Field")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.puzzle_code.filler_gui_2.yPos2Field").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.puzzle_code.filler_gui_2.yPos2Field").getString());
				else
					setSuggestion(null);
			}
		};
		yPos2Field.setSuggestion(Component.translatable("gui.puzzle_code.filler_gui_2.yPos2Field").getString());
		yPos2Field.setMaxLength(32767);
		guistate.put("text:yPos2Field", yPos2Field);
		this.addWidget(this.yPos2Field);
		zPos2Field = new EditBox(this.font, this.leftPos + 6, this.topPos + 82, 111, 18, Component.translatable("gui.puzzle_code.filler_gui_2.zPos2Field")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.puzzle_code.filler_gui_2.zPos2Field").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.puzzle_code.filler_gui_2.zPos2Field").getString());
				else
					setSuggestion(null);
			}
		};
		zPos2Field.setSuggestion(Component.translatable("gui.puzzle_code.filler_gui_2.zPos2Field").getString());
		zPos2Field.setMaxLength(32767);
		guistate.put("text:zPos2Field", zPos2Field);
		this.addWidget(this.zPos2Field);
		button_1 = Button.builder(Component.translatable("gui.puzzle_code.filler_gui_2.button_1"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new FillerGui2ButtonMessage(0, x, y, z));
				FillerGui2ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 64, this.topPos + 126, 18, 20).build();
		guistate.put("button:button_1", button_1);
		this.addRenderableWidget(button_1);
		button_2 = Button.builder(Component.translatable("gui.puzzle_code.filler_gui_2.button_2"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new FillerGui2ButtonMessage(1, x, y, z));
				FillerGui2ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 91, this.topPos + 126, 18, 20).build();
		guistate.put("button:button_2", button_2);
		this.addRenderableWidget(button_2);
		imagebutton_enter_button = new ImageButton(this.leftPos + 145, this.topPos + 9, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_enter_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new FillerGui2ButtonMessage(2, x, y, z));
				FillerGui2ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_enter_button", imagebutton_enter_button);
		this.addRenderableWidget(imagebutton_enter_button);
		imagebutton_edit_button = new ImageButton(this.leftPos + 122, this.topPos + 9, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_edit_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new FillerGui2ButtonMessage(3, x, y, z));
				FillerGui2ButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_edit_button", imagebutton_edit_button);
		this.addRenderableWidget(imagebutton_edit_button);
		imagebutton_enter_button1 = new ImageButton(this.leftPos + 145, this.topPos + 45, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_enter_button1.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new FillerGui2ButtonMessage(4, x, y, z));
				FillerGui2ButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:imagebutton_enter_button1", imagebutton_enter_button1);
		this.addRenderableWidget(imagebutton_enter_button1);
		imagebutton_edit_button1 = new ImageButton(this.leftPos + 122, this.topPos + 45, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_edit_button1.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new FillerGui2ButtonMessage(5, x, y, z));
				FillerGui2ButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:imagebutton_edit_button1", imagebutton_edit_button1);
		this.addRenderableWidget(imagebutton_edit_button1);
		imagebutton_enter_button2 = new ImageButton(this.leftPos + 145, this.topPos + 81, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_enter_button2.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new FillerGui2ButtonMessage(6, x, y, z));
				FillerGui2ButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		});
		guistate.put("button:imagebutton_enter_button2", imagebutton_enter_button2);
		this.addRenderableWidget(imagebutton_enter_button2);
		imagebutton_edit_button2 = new ImageButton(this.leftPos + 122, this.topPos + 81, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_edit_button2.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new FillerGui2ButtonMessage(7, x, y, z));
				FillerGui2ButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		});
		guistate.put("button:imagebutton_edit_button2", imagebutton_edit_button2);
		this.addRenderableWidget(imagebutton_edit_button2);
	}
}
