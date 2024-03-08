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

import net.mcreator.puzzle_code.world.inventory.FillerItemCodeBlockGUI3Menu;
import net.mcreator.puzzle_code.procedures.ReturnSetSlotIDProcedure;
import net.mcreator.puzzle_code.procedures.ReturnGetSlotIDProcedure;
import net.mcreator.puzzle_code.network.FillerItemCodeBlockGUI3ButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class FillerItemCodeBlockGUI3Screen extends AbstractContainerScreen<FillerItemCodeBlockGUI3Menu> {
	private final static HashMap<String, Object> guistate = FillerItemCodeBlockGUI3Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox getSlotID;
	EditBox setSlotID;
	Button button_1;
	Button button_3;
	ImageButton imagebutton_enter_button;
	ImageButton imagebutton_edit_button;
	ImageButton imagebutton_enter_button1;
	ImageButton imagebutton_edit_button1;

	public FillerItemCodeBlockGUI3Screen(FillerItemCodeBlockGUI3Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 174;
		this.imageHeight = 146;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/screens/filler_item_code_block_gui_3.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		getSlotID.render(guiGraphics, mouseX, mouseY, partialTicks);
		setSlotID.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (getSlotID.isFocused())
			return getSlotID.keyPressed(key, b, c);
		if (setSlotID.isFocused())
			return setSlotID.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		getSlotID.tick();
		setSlotID.tick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.filler_item_code_block_gui_3.label_from_slot_bnbtintegergetslot"), 5, 42, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.filler_item_code_block_gui_3.label_to_slot_bnbtintegersetslotnu"), 5, 96, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnSetSlotIDProcedure.execute(world, x, y, z), 50, 96, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnGetSlotIDProcedure.execute(world, x, y, z), 59, 42, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.filler_item_code_block_gui_3.label_nbt_getslotid"), 5, 29, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.filler_item_code_block_gui_3.label_nbt_setslotid"), 5, 83, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		getSlotID = new EditBox(this.font, this.leftPos + 6, this.topPos + 7, 111, 18, Component.translatable("gui.puzzle_code.filler_item_code_block_gui_3.getSlotID")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.puzzle_code.filler_item_code_block_gui_3.getSlotID").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.puzzle_code.filler_item_code_block_gui_3.getSlotID").getString());
				else
					setSuggestion(null);
			}
		};
		getSlotID.setSuggestion(Component.translatable("gui.puzzle_code.filler_item_code_block_gui_3.getSlotID").getString());
		getSlotID.setMaxLength(32767);
		guistate.put("text:getSlotID", getSlotID);
		this.addWidget(this.getSlotID);
		setSlotID = new EditBox(this.font, this.leftPos + 6, this.topPos + 57, 111, 18, Component.translatable("gui.puzzle_code.filler_item_code_block_gui_3.setSlotID")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.puzzle_code.filler_item_code_block_gui_3.setSlotID").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.puzzle_code.filler_item_code_block_gui_3.setSlotID").getString());
				else
					setSuggestion(null);
			}
		};
		setSlotID.setSuggestion(Component.translatable("gui.puzzle_code.filler_item_code_block_gui_3.setSlotID").getString());
		setSlotID.setMaxLength(32767);
		guistate.put("text:setSlotID", setSlotID);
		this.addWidget(this.setSlotID);
		button_1 = Button.builder(Component.translatable("gui.puzzle_code.filler_item_code_block_gui_3.button_1"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new FillerItemCodeBlockGUI3ButtonMessage(0, x, y, z));
				FillerItemCodeBlockGUI3ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 55, this.topPos + 119, 18, 20).build();
		guistate.put("button:button_1", button_1);
		this.addRenderableWidget(button_1);
		button_3 = Button.builder(Component.translatable("gui.puzzle_code.filler_item_code_block_gui_3.button_3"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new FillerItemCodeBlockGUI3ButtonMessage(1, x, y, z));
				FillerItemCodeBlockGUI3ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 82, this.topPos + 119, 18, 20).build();
		guistate.put("button:button_3", button_3);
		this.addRenderableWidget(button_3);
		imagebutton_enter_button = new ImageButton(this.leftPos + 145, this.topPos + 6, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_enter_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new FillerItemCodeBlockGUI3ButtonMessage(2, x, y, z));
				FillerItemCodeBlockGUI3ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_enter_button", imagebutton_enter_button);
		this.addRenderableWidget(imagebutton_enter_button);
		imagebutton_edit_button = new ImageButton(this.leftPos + 122, this.topPos + 6, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_edit_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new FillerItemCodeBlockGUI3ButtonMessage(3, x, y, z));
				FillerItemCodeBlockGUI3ButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_edit_button", imagebutton_edit_button);
		this.addRenderableWidget(imagebutton_edit_button);
		imagebutton_enter_button1 = new ImageButton(this.leftPos + 145, this.topPos + 56, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_enter_button1.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new FillerItemCodeBlockGUI3ButtonMessage(4, x, y, z));
				FillerItemCodeBlockGUI3ButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:imagebutton_enter_button1", imagebutton_enter_button1);
		this.addRenderableWidget(imagebutton_enter_button1);
		imagebutton_edit_button1 = new ImageButton(this.leftPos + 122, this.topPos + 56, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_edit_button1.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new FillerItemCodeBlockGUI3ButtonMessage(5, x, y, z));
				FillerItemCodeBlockGUI3ButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:imagebutton_edit_button1", imagebutton_edit_button1);
		this.addRenderableWidget(imagebutton_edit_button1);
	}
}
