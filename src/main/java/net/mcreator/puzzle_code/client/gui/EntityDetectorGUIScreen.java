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

import net.mcreator.puzzle_code.world.inventory.EntityDetectorGUIMenu;
import net.mcreator.puzzle_code.procedures.ReturnRangeProcedure;
import net.mcreator.puzzle_code.network.EntityDetectorGUIButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class EntityDetectorGUIScreen extends AbstractContainerScreen<EntityDetectorGUIMenu> {
	private final static HashMap<String, Object> guistate = EntityDetectorGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox rangeField;
	ImageButton imagebutton_enter_button;
	ImageButton imagebutton_edit_button_hovered;

	public EntityDetectorGUIScreen(EntityDetectorGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 65;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/screens/entity_detector_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (rangeField.isFocused())
			return rangeField.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		rangeField.tick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.entity_detector_gui.label_range_bnbtnumberrange"), 6, 33, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.entity_detector_gui.label_nbt_range"), 6, 46, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnRangeProcedure.execute(world, x, y, z), 42, 33, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		rangeField = new EditBox(this.font, this.leftPos + 7, this.topPos + 7, 111, 18, Component.translatable("gui.puzzle_code.entity_detector_gui.rangeField")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.puzzle_code.entity_detector_gui.rangeField").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.puzzle_code.entity_detector_gui.rangeField").getString());
				else
					setSuggestion(null);
			}
		};
		rangeField.setSuggestion(Component.translatable("gui.puzzle_code.entity_detector_gui.rangeField").getString());
		rangeField.setMaxLength(32767);
		guistate.put("text:rangeField", rangeField);
		this.addWidget(this.rangeField);
		imagebutton_enter_button = new ImageButton(this.leftPos + 146, this.topPos + 6, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_enter_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new EntityDetectorGUIButtonMessage(0, x, y, z));
				EntityDetectorGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_enter_button", imagebutton_enter_button);
		this.addRenderableWidget(imagebutton_enter_button);
		imagebutton_edit_button_hovered = new ImageButton(this.leftPos + 123, this.topPos + 6, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_edit_button_hovered.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new EntityDetectorGUIButtonMessage(1, x, y, z));
				EntityDetectorGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_edit_button_hovered", imagebutton_edit_button_hovered);
		this.addRenderableWidget(imagebutton_edit_button_hovered);
	}
}
