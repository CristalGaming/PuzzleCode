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

import net.mcreator.puzzle_code.world.inventory.TeleporterItemCodeBlockGUI2Menu;
import net.mcreator.puzzle_code.procedures.ReturnSetSlotIDProcedure;
import net.mcreator.puzzle_code.procedures.ReturnGetSlotIDProcedure;
import net.mcreator.puzzle_code.network.TeleporterItemCodeBlockGUI2ButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class TeleporterItemCodeBlockGUI2Screen extends AbstractContainerScreen<TeleporterItemCodeBlockGUI2Menu> {
	private final static HashMap<String, Object> guistate = TeleporterItemCodeBlockGUI2Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox getSlotID;
	EditBox setSlotID;
	Button button_1;
	Button button_2;
	ImageButton imagebutton_enter_button;
	ImageButton imagebutton_edit_button;
	ImageButton imagebutton_enter_button1;
	ImageButton imagebutton_edit_button1;

	public TeleporterItemCodeBlockGUI2Screen(TeleporterItemCodeBlockGUI2Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 136;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/screens/teleporter_item_code_block_gui_2.png");

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

		guiGraphics.blit(new ResourceLocation("puzzle_code:textures/screens/puzzle_jump_logo.png"), this.leftPos + 150, this.topPos + -8, 0, 0, -1, -1, -1, -1);

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
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.teleporter_item_code_block_gui_2.label_from_slot_bnbtintegergetslot"), 6, 42, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.teleporter_item_code_block_gui_2.label_to_slot_bnbtintegersetslotnu"), 6, 91, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnSetSlotIDProcedure.execute(world, x, y, z), 56, 91, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnGetSlotIDProcedure.execute(world, x, y, z), 69, 42, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.teleporter_item_code_block_gui_2.label_nbt_setnbt"), 6, 78, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.teleporter_item_code_block_gui_2.label_nbt_getnbt"), 6, 28, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		getSlotID = new EditBox(this.font, this.leftPos + 7, this.topPos + 7, 115, 18, Component.translatable("gui.puzzle_code.teleporter_item_code_block_gui_2.getSlotID")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.puzzle_code.teleporter_item_code_block_gui_2.getSlotID").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.puzzle_code.teleporter_item_code_block_gui_2.getSlotID").getString());
				else
					setSuggestion(null);
			}
		};
		getSlotID.setSuggestion(Component.translatable("gui.puzzle_code.teleporter_item_code_block_gui_2.getSlotID").getString());
		getSlotID.setMaxLength(32767);
		guistate.put("text:getSlotID", getSlotID);
		this.addWidget(this.getSlotID);
		setSlotID = new EditBox(this.font, this.leftPos + 7, this.topPos + 56, 115, 18, Component.translatable("gui.puzzle_code.teleporter_item_code_block_gui_2.setSlotID")) {
			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.puzzle_code.teleporter_item_code_block_gui_2.setSlotID").getString());
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion(Component.translatable("gui.puzzle_code.teleporter_item_code_block_gui_2.setSlotID").getString());
				else
					setSuggestion(null);
			}
		};
		setSlotID.setSuggestion(Component.translatable("gui.puzzle_code.teleporter_item_code_block_gui_2.setSlotID").getString());
		setSlotID.setMaxLength(32767);
		guistate.put("text:setSlotID", setSlotID);
		this.addWidget(this.setSlotID);
		button_1 = Button.builder(Component.translatable("gui.puzzle_code.teleporter_item_code_block_gui_2.button_1"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new TeleporterItemCodeBlockGUI2ButtonMessage(0, x, y, z));
				TeleporterItemCodeBlockGUI2ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 60, this.topPos + 109, 18, 20).build();
		guistate.put("button:button_1", button_1);
		this.addRenderableWidget(button_1);
		button_2 = Button.builder(Component.translatable("gui.puzzle_code.teleporter_item_code_block_gui_2.button_2"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new TeleporterItemCodeBlockGUI2ButtonMessage(1, x, y, z));
				TeleporterItemCodeBlockGUI2ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 87, this.topPos + 109, 18, 20).build();
		guistate.put("button:button_2", button_2);
		this.addRenderableWidget(button_2);
		imagebutton_enter_button = new ImageButton(this.leftPos + 150, this.topPos + 6, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_enter_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new TeleporterItemCodeBlockGUI2ButtonMessage(2, x, y, z));
				TeleporterItemCodeBlockGUI2ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_enter_button", imagebutton_enter_button);
		this.addRenderableWidget(imagebutton_enter_button);
		imagebutton_edit_button = new ImageButton(this.leftPos + 128, this.topPos + 6, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_edit_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new TeleporterItemCodeBlockGUI2ButtonMessage(3, x, y, z));
				TeleporterItemCodeBlockGUI2ButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_edit_button", imagebutton_edit_button);
		this.addRenderableWidget(imagebutton_edit_button);
		imagebutton_enter_button1 = new ImageButton(this.leftPos + 150, this.topPos + 55, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_enter_button1.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new TeleporterItemCodeBlockGUI2ButtonMessage(4, x, y, z));
				TeleporterItemCodeBlockGUI2ButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:imagebutton_enter_button1", imagebutton_enter_button1);
		this.addRenderableWidget(imagebutton_enter_button1);
		imagebutton_edit_button1 = new ImageButton(this.leftPos + 128, this.topPos + 55, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_edit_button1.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new TeleporterItemCodeBlockGUI2ButtonMessage(5, x, y, z));
				TeleporterItemCodeBlockGUI2ButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:imagebutton_edit_button1", imagebutton_edit_button1);
		this.addRenderableWidget(imagebutton_edit_button1);
	}
}
