
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

import net.mcreator.puzzle_code.world.inventory.TitleTextCodeBlockGUIMenu;
import net.mcreator.puzzle_code.network.TitleTextCodeBlockGUIButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class TitleTextCodeBlockGUIScreen extends AbstractContainerScreen<TitleTextCodeBlockGUIMenu> {
	private final static HashMap<String, Object> guistate = TitleTextCodeBlockGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox textCodeBlockField;
	EditBox colorField;

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
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		textCodeBlockField.render(ms, mouseX, mouseY, partialTicks);
		colorField.render(ms, mouseX, mouseY, partialTicks);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
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
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, "Text: " + (new Object() {
			public String getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getTileData().getString(tag);
				return "";
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "textCodeBlock")) + "", 6, 50, -12829636);
		this.font.draw(poseStack, "Color: " + (new Object() {
			public String getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getTileData().getString(tag);
				return "";
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "color")) + "", 6, 109, -12829636);
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
		textCodeBlockField = new EditBox(this.font, this.leftPos + 6, this.topPos + 5, 162, 20, new TextComponent(""));
		guistate.put("text:textCodeBlockField", textCodeBlockField);
		textCodeBlockField.setMaxLength(32767);
		this.addWidget(this.textCodeBlockField);
		this.addRenderableWidget(new Button(this.leftPos + 6, this.topPos + 28, 77, 20, new TextComponent("Apply"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new TitleTextCodeBlockGUIButtonMessage(0, x, y, z));
				TitleTextCodeBlockGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		colorField = new EditBox(this.font, this.leftPos + 6, this.topPos + 64, 162, 20, new TextComponent(""));
		guistate.put("text:colorField", colorField);
		colorField.setMaxLength(32767);
		this.addWidget(this.colorField);
		this.addRenderableWidget(new Button(this.leftPos + 6, this.topPos + 86, 162, 20, new TextComponent("Apply"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new TitleTextCodeBlockGUIButtonMessage(1, x, y, z));
				TitleTextCodeBlockGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 92, this.topPos + 28, 76, 20, new TextComponent("Edit"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new TitleTextCodeBlockGUIButtonMessage(2, x, y, z));
				TitleTextCodeBlockGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));
	}
}
