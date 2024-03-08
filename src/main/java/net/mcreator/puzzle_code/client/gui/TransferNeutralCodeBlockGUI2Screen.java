package net.mcreator.puzzle_code.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.puzzle_code.world.inventory.TransferNeutralCodeBlockGUI2Menu;
import net.mcreator.puzzle_code.procedures.ReturnNBTTypeProcedure;
import net.mcreator.puzzle_code.network.TransferNeutralCodeBlockGUI2ButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class TransferNeutralCodeBlockGUI2Screen extends AbstractContainerScreen<TransferNeutralCodeBlockGUI2Menu> {
	private final static HashMap<String, Object> guistate = TransferNeutralCodeBlockGUI2Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_number;
	Button button_logic;
	Button button_text;
	Button button_1;
	Button button_2;

	public TransferNeutralCodeBlockGUI2Screen(TransferNeutralCodeBlockGUI2Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 82;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/screens/transfer_neutral_code_block_gui_2.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.transfer_neutral_code_block_gui_2.label_nbt_type"), 6, 28, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.transfer_neutral_code_block_gui_2.label_nbt_nbttype"), 6, 42, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnNBTTypeProcedure.execute(world, x, y, z), 60, 28, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_number = Button.builder(Component.translatable("gui.puzzle_code.transfer_neutral_code_block_gui_2.button_number"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new TransferNeutralCodeBlockGUI2ButtonMessage(0, x, y, z));
				TransferNeutralCodeBlockGUI2ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 6, 54, 20).build();
		guistate.put("button:button_number", button_number);
		this.addRenderableWidget(button_number);
		button_logic = Button.builder(Component.translatable("gui.puzzle_code.transfer_neutral_code_block_gui_2.button_logic"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new TransferNeutralCodeBlockGUI2ButtonMessage(1, x, y, z));
				TransferNeutralCodeBlockGUI2ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 65, this.topPos + 6, 54, 20).build();
		guistate.put("button:button_logic", button_logic);
		this.addRenderableWidget(button_logic);
		button_text = Button.builder(Component.translatable("gui.puzzle_code.transfer_neutral_code_block_gui_2.button_text"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new TransferNeutralCodeBlockGUI2ButtonMessage(2, x, y, z));
				TransferNeutralCodeBlockGUI2ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 123, this.topPos + 6, 45, 20).build();
		guistate.put("button:button_text", button_text);
		this.addRenderableWidget(button_text);
		button_1 = Button.builder(Component.translatable("gui.puzzle_code.transfer_neutral_code_block_gui_2.button_1"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new TransferNeutralCodeBlockGUI2ButtonMessage(3, x, y, z));
				TransferNeutralCodeBlockGUI2ButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 60, this.topPos + 55, 18, 20).build();
		guistate.put("button:button_1", button_1);
		this.addRenderableWidget(button_1);
		button_2 = Button.builder(Component.translatable("gui.puzzle_code.transfer_neutral_code_block_gui_2.button_2"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new TransferNeutralCodeBlockGUI2ButtonMessage(4, x, y, z));
				TransferNeutralCodeBlockGUI2ButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + 87, this.topPos + 55, 18, 20).build();
		guistate.put("button:button_2", button_2);
		this.addRenderableWidget(button_2);
	}
}
