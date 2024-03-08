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

import net.mcreator.puzzle_code.world.inventory.CommandCodeBlockGUIMenu;
import net.mcreator.puzzle_code.procedures.RetrunTextCodeBlockProcedure;
import net.mcreator.puzzle_code.procedures.IsDisabledDisplayOnProcedure;
import net.mcreator.puzzle_code.procedures.IsDisabledDisplayOffProcedure;
import net.mcreator.puzzle_code.network.CommandCodeBlockGUIButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class CommandCodeBlockGUIScreen extends AbstractContainerScreen<CommandCodeBlockGUIMenu> {
	private final static HashMap<String, Object> guistate = CommandCodeBlockGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox textCodeBlockField;
	Button button_2;
	Button button_1;
	ImageButton imagebutton_edit_button;
	ImageButton imagebutton_enter_button;
	ImageButton imagebutton_change_button;
	ImageButton imagebutton_settings_button;

	public CommandCodeBlockGUIScreen(CommandCodeBlockGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 129;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/screens/command_code_block_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		textCodeBlockField.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		guiGraphics.blit(new ResourceLocation("puzzle_code:textures/screens/puzzle_jump_logo.png"), this.leftPos + 150, this.topPos + -12, 0, 0, -1, -1, -1, -1);

		if (IsDisabledDisplayOnProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("puzzle_code:textures/screens/logic_true.png"), this.leftPos + 92, this.topPos + 74, 0, 0, 48, 20, 48, 20);
		}
		if (IsDisabledDisplayOffProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("puzzle_code:textures/screens/logic_false.png"), this.leftPos + 92, this.topPos + 74, 0, 0, 48, 20, 48, 20);
		}
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (textCodeBlockField.isFocused())
			return textCodeBlockField.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		textCodeBlockField.tick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.command_code_block_gui.label_text_bnbttexttextcodeblock"), 6, 42, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.command_code_block_gui.label_is_disabled"), 56, 60, -12829636, false);
		guiGraphics.drawString(this.font,

				RetrunTextCodeBlockProcedure.execute(world, x, y, z), 42, 42, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.command_code_block_gui.label_nbt_textcodeblock"), 6, 29, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		textCodeBlockField = new EditBox(this.font, this.leftPos + 7, this.topPos + 7, 111, 18, Component.translatable("gui.puzzle_code.command_code_block_gui.textCodeBlockField")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.puzzle_code.command_code_block_gui.textCodeBlockField").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.puzzle_code.command_code_block_gui.textCodeBlockField").getString());
				else
					setSuggestion(null);
			}
		};
		textCodeBlockField.setSuggestion(Component.translatable("gui.puzzle_code.command_code_block_gui.textCodeBlockField").getString());
		textCodeBlockField.setMaxLength(32767);
		guistate.put("text:textCodeBlockField", textCodeBlockField);
		this.addWidget(this.textCodeBlockField);
		button_2 = Button.builder(Component.translatable("gui.puzzle_code.command_code_block_gui.button_2"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CommandCodeBlockGUIButtonMessage(0, x, y, z));
				CommandCodeBlockGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 92, this.topPos + 101, 18, 20).build();
		guistate.put("button:button_2", button_2);
		this.addRenderableWidget(button_2);
		button_1 = Button.builder(Component.translatable("gui.puzzle_code.command_code_block_gui.button_1"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CommandCodeBlockGUIButtonMessage(1, x, y, z));
				CommandCodeBlockGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 65, this.topPos + 101, 18, 20).build();
		guistate.put("button:button_1", button_1);
		this.addRenderableWidget(button_1);
		imagebutton_edit_button = new ImageButton(this.leftPos + 123, this.topPos + 6, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_edit_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CommandCodeBlockGUIButtonMessage(2, x, y, z));
				CommandCodeBlockGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_edit_button", imagebutton_edit_button);
		this.addRenderableWidget(imagebutton_edit_button);
		imagebutton_enter_button = new ImageButton(this.leftPos + 146, this.topPos + 6, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_enter_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CommandCodeBlockGUIButtonMessage(3, x, y, z));
				CommandCodeBlockGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_enter_button", imagebutton_enter_button);
		this.addRenderableWidget(imagebutton_enter_button);
		imagebutton_change_button = new ImageButton(this.leftPos + 42, this.topPos + 74, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_change_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CommandCodeBlockGUIButtonMessage(4, x, y, z));
				CommandCodeBlockGUIButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:imagebutton_change_button", imagebutton_change_button);
		this.addRenderableWidget(imagebutton_change_button);
		imagebutton_settings_button = new ImageButton(this.leftPos + 65, this.topPos + 74, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_settings_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CommandCodeBlockGUIButtonMessage(5, x, y, z));
				CommandCodeBlockGUIButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:imagebutton_settings_button", imagebutton_settings_button);
		this.addRenderableWidget(imagebutton_settings_button);
	}
}
