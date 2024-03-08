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

import net.mcreator.puzzle_code.world.inventory.RandomizerNumberCodeBlockGUIMenu;
import net.mcreator.puzzle_code.procedures.ReturnNumberCodeBlockProcedure;
import net.mcreator.puzzle_code.procedures.ReturnMinValueProcedure;
import net.mcreator.puzzle_code.procedures.ReturnMaxValueProcedure;
import net.mcreator.puzzle_code.network.RandomizerNumberCodeBlockGUIButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class RandomizerNumberCodeBlockGUIScreen extends AbstractContainerScreen<RandomizerNumberCodeBlockGUIMenu> {
	private final static HashMap<String, Object> guistate = RandomizerNumberCodeBlockGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox minValueField;
	EditBox maxValueField;
	ImageButton imagebutton_enter_button;
	ImageButton imagebutton_edit_button;
	ImageButton imagebutton_edit_button1;
	ImageButton imagebutton_enter_button1;

	public RandomizerNumberCodeBlockGUIScreen(RandomizerNumberCodeBlockGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 132;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/screens/randomizer_number_code_block_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		minValueField.render(guiGraphics, mouseX, mouseY, partialTicks);
		maxValueField.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (minValueField.isFocused())
			return minValueField.keyPressed(key, b, c);
		if (maxValueField.isFocused())
			return maxValueField.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		minValueField.tick();
		maxValueField.tick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.randomizer_number_code_block_gui.label_min_bnbtnumberminvalue"), 6, 44, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.randomizer_number_code_block_gui.label_max_bnbtnumbermaxvalue"), 6, 94, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.randomizer_number_code_block_gui.label_current_value_bnbtnumbernumb"), 6, 112, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnMinValueProcedure.execute(world, x, y, z), 33, 44, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnMaxValueProcedure.execute(world, x, y, z), 33, 94, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnNumberCodeBlockProcedure.execute(world, x, y, z), 83, 112, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.randomizer_number_code_block_gui.label_nbt_minvalue"), 6, 31, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.randomizer_number_code_block_gui.label_nbt_maxvalue"), 6, 80, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		minValueField = new EditBox(this.font, this.leftPos + 7, this.topPos + 9, 111, 18, Component.translatable("gui.puzzle_code.randomizer_number_code_block_gui.minValueField")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.puzzle_code.randomizer_number_code_block_gui.minValueField").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.puzzle_code.randomizer_number_code_block_gui.minValueField").getString());
				else
					setSuggestion(null);
			}
		};
		minValueField.setSuggestion(Component.translatable("gui.puzzle_code.randomizer_number_code_block_gui.minValueField").getString());
		minValueField.setMaxLength(32767);
		guistate.put("text:minValueField", minValueField);
		this.addWidget(this.minValueField);
		maxValueField = new EditBox(this.font, this.leftPos + 7, this.topPos + 59, 111, 18, Component.translatable("gui.puzzle_code.randomizer_number_code_block_gui.maxValueField")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.puzzle_code.randomizer_number_code_block_gui.maxValueField").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.puzzle_code.randomizer_number_code_block_gui.maxValueField").getString());
				else
					setSuggestion(null);
			}
		};
		maxValueField.setSuggestion(Component.translatable("gui.puzzle_code.randomizer_number_code_block_gui.maxValueField").getString());
		maxValueField.setMaxLength(32767);
		guistate.put("text:maxValueField", maxValueField);
		this.addWidget(this.maxValueField);
		imagebutton_enter_button = new ImageButton(this.leftPos + 146, this.topPos + 8, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_enter_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new RandomizerNumberCodeBlockGUIButtonMessage(0, x, y, z));
				RandomizerNumberCodeBlockGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_enter_button", imagebutton_enter_button);
		this.addRenderableWidget(imagebutton_enter_button);
		imagebutton_edit_button = new ImageButton(this.leftPos + 123, this.topPos + 8, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_edit_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new RandomizerNumberCodeBlockGUIButtonMessage(1, x, y, z));
				RandomizerNumberCodeBlockGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_edit_button", imagebutton_edit_button);
		this.addRenderableWidget(imagebutton_edit_button);
		imagebutton_edit_button1 = new ImageButton(this.leftPos + 123, this.topPos + 58, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_edit_button1.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new RandomizerNumberCodeBlockGUIButtonMessage(2, x, y, z));
				RandomizerNumberCodeBlockGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_edit_button1", imagebutton_edit_button1);
		this.addRenderableWidget(imagebutton_edit_button1);
		imagebutton_enter_button1 = new ImageButton(this.leftPos + 146, this.topPos + 58, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_enter_button1.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new RandomizerNumberCodeBlockGUIButtonMessage(3, x, y, z));
				RandomizerNumberCodeBlockGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_enter_button1", imagebutton_enter_button1);
		this.addRenderableWidget(imagebutton_enter_button1);
	}
}
