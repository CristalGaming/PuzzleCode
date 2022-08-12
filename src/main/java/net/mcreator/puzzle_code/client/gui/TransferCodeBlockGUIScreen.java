
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

import net.mcreator.puzzle_code.world.inventory.TransferCodeBlockGUIMenu;
import net.mcreator.puzzle_code.network.TransferCodeBlockGUIButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class TransferCodeBlockGUIScreen extends AbstractContainerScreen<TransferCodeBlockGUIMenu> {
	private final static HashMap<String, Object> guistate = TransferCodeBlockGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox getNBTField;
	EditBox setNBTField;

	public TransferCodeBlockGUIScreen(TransferCodeBlockGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 174;
		this.imageHeight = 128;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/screens/transfer_code_block_gui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		getNBTField.render(ms, mouseX, mouseY, partialTicks);
		setNBTField.render(ms, mouseX, mouseY, partialTicks);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		RenderSystem.setShaderTexture(0, new ResourceLocation("puzzle_code:textures/screens/puzzle_jump_logo.png"));
		this.blit(ms, this.leftPos + 149, this.topPos + 15, 0, 0, -1, -1, -1, -1);

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
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, "From NBT: " + (new Object() {
			public String getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getTileData().getString(tag);
				return "";
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "getNBT")) + "", 5, 51, -12829636);
		this.font.draw(poseStack, "To NBT: " + (new Object() {
			public String getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getTileData().getString(tag);
				return "";
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "setNBT")) + "", 5, 110, -12829636);
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
		getNBTField = new EditBox(this.font, this.leftPos + 5, this.topPos + 6, 162, 20, new TextComponent("From NBT")) {
			{
				setSuggestion("From NBT");
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion("From NBT");
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion("From NBT");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:getNBTField", getNBTField);
		getNBTField.setMaxLength(32767);
		this.addWidget(this.getNBTField);
		this.addRenderableWidget(new Button(this.leftPos + 5, this.topPos + 29, 77, 20, new TextComponent("Apply"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new TransferCodeBlockGUIButtonMessage(0, x, y, z));
				TransferCodeBlockGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		setNBTField = new EditBox(this.font, this.leftPos + 5, this.topPos + 65, 162, 20, new TextComponent("to NBT")) {
			{
				setSuggestion("to NBT");
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion("to NBT");
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion("to NBT");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:setNBTField", setNBTField);
		setNBTField.setMaxLength(32767);
		this.addWidget(this.setNBTField);
		this.addRenderableWidget(new Button(this.leftPos + 5, this.topPos + 87, 77, 20, new TextComponent("Apply"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new TransferCodeBlockGUIButtonMessage(1, x, y, z));
				TransferCodeBlockGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 91, this.topPos + 29, 77, 20, new TextComponent("Edit"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new TransferCodeBlockGUIButtonMessage(2, x, y, z));
				TransferCodeBlockGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 91, this.topPos + 87, 76, 20, new TextComponent("Edit"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new TransferCodeBlockGUIButtonMessage(3, x, y, z));
				TransferCodeBlockGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}));
	}
}
