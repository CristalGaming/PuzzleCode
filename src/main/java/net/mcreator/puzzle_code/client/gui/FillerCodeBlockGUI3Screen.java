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

import net.mcreator.puzzle_code.world.inventory.FillerCodeBlockGUI3Menu;
import net.mcreator.puzzle_code.procedures.ReturnSetNBTProcedure;
import net.mcreator.puzzle_code.procedures.ReturnGetNBTProcedure;
import net.mcreator.puzzle_code.network.FillerCodeBlockGUI3ButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class FillerCodeBlockGUI3Screen extends AbstractContainerScreen<FillerCodeBlockGUI3Menu> {
	private final static HashMap<String, Object> guistate = FillerCodeBlockGUI3Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox getNBTField;
	EditBox setNBTField;
	Button button_1;
	Button button_3;
	ImageButton imagebutton_enter_button;
	ImageButton imagebutton_enter_button1;
	ImageButton imagebutton_edit_button;
	ImageButton imagebutton_edit_button1;

	public FillerCodeBlockGUI3Screen(FillerCodeBlockGUI3Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 174;
		this.imageHeight = 146;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/screens/filler_code_block_gui_3.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		getNBTField.render(guiGraphics, mouseX, mouseY, partialTicks);
		setNBTField.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("puzzle_code:textures/screens/puzzle_jump_logo.png"), this.leftPos + 149, this.topPos + 24, 0, 0, -1, -1, -1, -1);

		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (getNBTField.isFocused())
			return getNBTField.keyPressed(key, b, c);
		if (setNBTField.isFocused())
			return setNBTField.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		getNBTField.tick();
		setNBTField.tick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.filler_code_block_gui_3.label_from_nbt_bnbttextgetnbt"), 5, 42, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.filler_code_block_gui_3.label_to_nbt_bnbttextsetnbt"), 5, 96, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnGetNBTProcedure.execute(world, x, y, z), 59, 42, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnSetNBTProcedure.execute(world, x, y, z), 50, 96, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.filler_code_block_gui_3.label_nbt_getnbt"), 5, 29, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.filler_code_block_gui_3.label_nbt_setnbt"), 5, 83, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		getNBTField = new EditBox(this.font, this.leftPos + 6, this.topPos + 7, 111, 18, Component.translatable("gui.puzzle_code.filler_code_block_gui_3.getNBTField")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.puzzle_code.filler_code_block_gui_3.getNBTField").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.puzzle_code.filler_code_block_gui_3.getNBTField").getString());
				else
					setSuggestion(null);
			}
		};
		getNBTField.setSuggestion(Component.translatable("gui.puzzle_code.filler_code_block_gui_3.getNBTField").getString());
		getNBTField.setMaxLength(32767);
		guistate.put("text:getNBTField", getNBTField);
		this.addWidget(this.getNBTField);
		setNBTField = new EditBox(this.font, this.leftPos + 6, this.topPos + 57, 111, 18, Component.translatable("gui.puzzle_code.filler_code_block_gui_3.setNBTField")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.puzzle_code.filler_code_block_gui_3.setNBTField").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.puzzle_code.filler_code_block_gui_3.setNBTField").getString());
				else
					setSuggestion(null);
			}
		};
		setNBTField.setSuggestion(Component.translatable("gui.puzzle_code.filler_code_block_gui_3.setNBTField").getString());
		setNBTField.setMaxLength(32767);
		guistate.put("text:setNBTField", setNBTField);
		this.addWidget(this.setNBTField);
		button_1 = Button.builder(Component.translatable("gui.puzzle_code.filler_code_block_gui_3.button_1"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new FillerCodeBlockGUI3ButtonMessage(0, x, y, z));
				FillerCodeBlockGUI3ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 64, this.topPos + 119, 18, 20).build();
		guistate.put("button:button_1", button_1);
		this.addRenderableWidget(button_1);
		button_3 = Button.builder(Component.translatable("gui.puzzle_code.filler_code_block_gui_3.button_3"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new FillerCodeBlockGUI3ButtonMessage(1, x, y, z));
				FillerCodeBlockGUI3ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 91, this.topPos + 119, 18, 20).build();
		guistate.put("button:button_3", button_3);
		this.addRenderableWidget(button_3);
		imagebutton_enter_button = new ImageButton(this.leftPos + 145, this.topPos + 6, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_enter_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new FillerCodeBlockGUI3ButtonMessage(2, x, y, z));
				FillerCodeBlockGUI3ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_enter_button", imagebutton_enter_button);
		this.addRenderableWidget(imagebutton_enter_button);
		imagebutton_enter_button1 = new ImageButton(this.leftPos + 145, this.topPos + 56, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_enter_button1.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new FillerCodeBlockGUI3ButtonMessage(3, x, y, z));
				FillerCodeBlockGUI3ButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_enter_button1", imagebutton_enter_button1);
		this.addRenderableWidget(imagebutton_enter_button1);
		imagebutton_edit_button = new ImageButton(this.leftPos + 122, this.topPos + 6, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_edit_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new FillerCodeBlockGUI3ButtonMessage(4, x, y, z));
				FillerCodeBlockGUI3ButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:imagebutton_edit_button", imagebutton_edit_button);
		this.addRenderableWidget(imagebutton_edit_button);
		imagebutton_edit_button1 = new ImageButton(this.leftPos + 122, this.topPos + 56, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_edit_button1.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new FillerCodeBlockGUI3ButtonMessage(5, x, y, z));
				FillerCodeBlockGUI3ButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:imagebutton_edit_button1", imagebutton_edit_button1);
		this.addRenderableWidget(imagebutton_edit_button1);
	}
}
