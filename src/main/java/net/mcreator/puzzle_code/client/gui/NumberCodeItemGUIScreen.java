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

import net.mcreator.puzzle_code.world.inventory.NumberCodeItemGUIMenu;
import net.mcreator.puzzle_code.procedures.ReturnNumberCodeItemProcedure;
import net.mcreator.puzzle_code.network.NumberCodeItemGUIButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class NumberCodeItemGUIScreen extends AbstractContainerScreen<NumberCodeItemGUIMenu> {
	private final static HashMap<String, Object> guistate = NumberCodeItemGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox numberCodeItemField;
	ImageButton imagebutton_edit_button;
	ImageButton imagebutton_enter_button;

	public NumberCodeItemGUIScreen(NumberCodeItemGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 61;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/screens/number_code_item_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		numberCodeItemField.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (numberCodeItemField.isFocused())
			return numberCodeItemField.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		numberCodeItemField.tick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.number_code_item_gui.label_number_bnbtnumbernumbercodeb"), 6, 31, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.number_code_item_gui.label_nbt_numbercodeblock"), 6, 44, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnNumberCodeItemProcedure.execute(world, x, y, z), 47, 31, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		numberCodeItemField = new EditBox(this.font, this.leftPos + 7, this.topPos + 9, 111, 18, Component.translatable("gui.puzzle_code.number_code_item_gui.numberCodeItemField"));
		numberCodeItemField.setMaxLength(32767);
		guistate.put("text:numberCodeItemField", numberCodeItemField);
		this.addWidget(this.numberCodeItemField);
		imagebutton_edit_button = new ImageButton(this.leftPos + 123, this.topPos + 8, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_edit_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new NumberCodeItemGUIButtonMessage(0, x, y, z));
				NumberCodeItemGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_edit_button", imagebutton_edit_button);
		this.addRenderableWidget(imagebutton_edit_button);
		imagebutton_enter_button = new ImageButton(this.leftPos + 146, this.topPos + 8, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_enter_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new NumberCodeItemGUIButtonMessage(1, x, y, z));
				NumberCodeItemGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_enter_button", imagebutton_enter_button);
		this.addRenderableWidget(imagebutton_enter_button);
	}
}
