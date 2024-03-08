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

import net.mcreator.puzzle_code.world.inventory.TitleTextCodeBlockGUIMenu;
import net.mcreator.puzzle_code.procedures.ReturnColorProcedure;
import net.mcreator.puzzle_code.procedures.RetrunTextCodeBlockProcedure;
import net.mcreator.puzzle_code.network.TitleTextCodeBlockGUIButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class TitleTextCodeBlockGUIScreen extends AbstractContainerScreen<TitleTextCodeBlockGUIMenu> {
	private final static HashMap<String, Object> guistate = TitleTextCodeBlockGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox textCodeBlockField;
	EditBox colorField;
	Button button_apply;
	Button button_apply1;
	Button button_edit;

	public TitleTextCodeBlockGUIScreen(TitleTextCodeBlockGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 126;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/screens/title_text_code_block_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		textCodeBlockField.render(guiGraphics, mouseX, mouseY, partialTicks);
		colorField.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (textCodeBlockField.isFocused())
			return textCodeBlockField.keyPressed(key, b, c);
		if (colorField.isFocused())
			return colorField.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		textCodeBlockField.tick();
		colorField.tick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.title_text_code_block_gui.label_text_bnbttexttextcodeblock"), 6, 50, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.title_text_code_block_gui.label_color_bnbttextcolor"), 6, 109, -12829636, false);
		guiGraphics.drawString(this.font,

				RetrunTextCodeBlockProcedure.execute(world, x, y, z), 38, 50, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnColorProcedure.execute(world, x, y, z), 42, 109, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		textCodeBlockField = new EditBox(this.font, this.leftPos + 7, this.topPos + 6, 160, 18, Component.translatable("gui.puzzle_code.title_text_code_block_gui.textCodeBlockField"));
		textCodeBlockField.setMaxLength(32767);
		guistate.put("text:textCodeBlockField", textCodeBlockField);
		this.addWidget(this.textCodeBlockField);
		colorField = new EditBox(this.font, this.leftPos + 7, this.topPos + 65, 160, 18, Component.translatable("gui.puzzle_code.title_text_code_block_gui.colorField"));
		colorField.setMaxLength(32767);
		guistate.put("text:colorField", colorField);
		this.addWidget(this.colorField);
		button_apply = Button.builder(Component.translatable("gui.puzzle_code.title_text_code_block_gui.button_apply"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new TitleTextCodeBlockGUIButtonMessage(0, x, y, z));
				TitleTextCodeBlockGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 28, 77, 20).build();
		guistate.put("button:button_apply", button_apply);
		this.addRenderableWidget(button_apply);
		button_apply1 = Button.builder(Component.translatable("gui.puzzle_code.title_text_code_block_gui.button_apply1"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new TitleTextCodeBlockGUIButtonMessage(1, x, y, z));
				TitleTextCodeBlockGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 86, 162, 20).build();
		guistate.put("button:button_apply1", button_apply1);
		this.addRenderableWidget(button_apply1);
		button_edit = Button.builder(Component.translatable("gui.puzzle_code.title_text_code_block_gui.button_edit"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new TitleTextCodeBlockGUIButtonMessage(2, x, y, z));
				TitleTextCodeBlockGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 92, this.topPos + 28, 76, 20).build();
		guistate.put("button:button_edit", button_edit);
		this.addRenderableWidget(button_edit);
	}
}
