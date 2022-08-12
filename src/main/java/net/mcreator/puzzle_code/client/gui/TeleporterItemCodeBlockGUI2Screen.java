
package net.mcreator.puzzle_code.client.gui;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.puzzle_code.world.inventory.TeleporterItemCodeBlockGUI2Menu;
import net.mcreator.puzzle_code.network.TeleporterItemCodeBlockGUI2ButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class TeleporterItemCodeBlockGUI2Screen extends AbstractContainerScreen<TeleporterItemCodeBlockGUI2Menu> {
	private final static HashMap<String, Object> guistate = TeleporterItemCodeBlockGUI2Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox getSlotID;
	EditBox setSlotID;

	public TeleporterItemCodeBlockGUI2Screen(TeleporterItemCodeBlockGUI2Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 155;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/screens/teleporter_item_code_block_gui_2.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		getSlotID.render(ms, mouseX, mouseY, partialTicks);
		setSlotID.render(ms, mouseX, mouseY, partialTicks);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		RenderSystem.setShaderTexture(0, new ResourceLocation("puzzle_code:textures/screens/puzzle_jump_logo.png"));
		this.blit(ms, this.leftPos + 150, this.topPos + 1, 0, 0, -1, -1, -1, -1);

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
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, "From slot: " + ((int) new Object() {
			public double getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getTileData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "getSlotNumber")) + "", 6, 51, -12829636);
		this.font.draw(poseStack, "To slot: " + ((int) new Object() {
			public double getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getTileData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "setSlotNumber")) + "", 6, 114, -12829636);
		this.font.draw(poseStack, "[2]", 24, 132, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		getSlotID = new EditBox(this.font, this.leftPos + 6, this.topPos + 6, 162, 20, new TextComponent("From slot")) {
			{
				setSuggestion("From slot");
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion("From slot");
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion("From slot");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:getSlotID", getSlotID);
		getSlotID.setMaxLength(32767);
		this.addWidget(this.getSlotID);
		setSlotID = new EditBox(this.font, this.leftPos + 6, this.topPos + 64, 162, 20, new TextComponent("To Slot")) {
			{
				setSuggestion("To Slot");
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion("To Slot");
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion("To Slot");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:setSlotID", setSlotID);
		setSlotID.setMaxLength(32767);
		this.addWidget(this.setSlotID);
		this.addRenderableWidget(new Button(this.leftPos + 6, this.topPos + 28, 77, 20, new TextComponent("Apply"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new TeleporterItemCodeBlockGUI2ButtonMessage(0, x, y, z));
				TeleporterItemCodeBlockGUI2ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 6, this.topPos + 87, 77, 20, new TextComponent("Apply"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new TeleporterItemCodeBlockGUI2ButtonMessage(1, x, y, z));
				TeleporterItemCodeBlockGUI2ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 6, this.topPos + 127, 14, 20, new TextComponent("1"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new TeleporterItemCodeBlockGUI2ButtonMessage(2, x, y, z));
				TeleporterItemCodeBlockGUI2ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 92, this.topPos + 28, 77, 20, new TextComponent("Edit"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new TeleporterItemCodeBlockGUI2ButtonMessage(3, x, y, z));
				TeleporterItemCodeBlockGUI2ButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 92, this.topPos + 87, 76, 20, new TextComponent("Edit"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new TeleporterItemCodeBlockGUI2ButtonMessage(4, x, y, z));
				TeleporterItemCodeBlockGUI2ButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}));
	}
}
