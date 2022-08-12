
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

import net.mcreator.puzzle_code.world.inventory.RandomizerNumberCodeBlockGUIMenu;
import net.mcreator.puzzle_code.network.RandomizerNumberCodeBlockGUIButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class RandomizerNumberCodeBlockGUIScreen extends AbstractContainerScreen<RandomizerNumberCodeBlockGUIMenu> {
	private final static HashMap<String, Object> guistate = RandomizerNumberCodeBlockGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox minValueField;
	EditBox maxValueField;

	public RandomizerNumberCodeBlockGUIScreen(RandomizerNumberCodeBlockGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 147;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/screens/randomizer_number_code_block_gui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		minValueField.render(ms, mouseX, mouseY, partialTicks);
		maxValueField.render(ms, mouseX, mouseY, partialTicks);
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
		if (minValueField.isFocused())
			return minValueField.keyPressed(key, b, c);
		if (maxValueField.isFocused())
			return maxValueField.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		minValueField.tick();
		maxValueField.tick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, "Min: " + (new Object() {
			public double getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getTileData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "minValue")) + "", 6, 51, -12829636);
		this.font.draw(poseStack, "Max: " + (new Object() {
			public double getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getTileData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "maxValue")) + "", 6, 110, -12829636);
		this.font.draw(poseStack, "Current Value: " + (new Object() {
			public double getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getTileData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "numberCodeBlock")) + "", 6, 128, -12829636);
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
		minValueField = new EditBox(this.font, this.leftPos + 6, this.topPos + 6, 162, 20, new TextComponent("min. value")) {
			{
				setSuggestion("min. value");
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion("min. value");
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion("min. value");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:minValueField", minValueField);
		minValueField.setMaxLength(32767);
		this.addWidget(this.minValueField);
		this.addRenderableWidget(new Button(this.leftPos + 6, this.topPos + 29, 77, 20, new TextComponent("Apply"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new RandomizerNumberCodeBlockGUIButtonMessage(0, x, y, z));
				RandomizerNumberCodeBlockGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		maxValueField = new EditBox(this.font, this.leftPos + 6, this.topPos + 65, 162, 20, new TextComponent("max Value")) {
			{
				setSuggestion("max Value");
			}

			@Override
			public void insertText(String text) {
				super.insertText(text);
				if (getValue().isEmpty())
					setSuggestion("max Value");
				else
					setSuggestion(null);
			}

			@Override
			public void moveCursorTo(int pos) {
				super.moveCursorTo(pos);
				if (getValue().isEmpty())
					setSuggestion("max Value");
				else
					setSuggestion(null);
			}
		};
		guistate.put("text:maxValueField", maxValueField);
		maxValueField.setMaxLength(32767);
		this.addWidget(this.maxValueField);
		this.addRenderableWidget(new Button(this.leftPos + 6, this.topPos + 87, 77, 20, new TextComponent("Apply"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new RandomizerNumberCodeBlockGUIButtonMessage(1, x, y, z));
				RandomizerNumberCodeBlockGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 92, this.topPos + 29, 76, 20, new TextComponent("Edit"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new RandomizerNumberCodeBlockGUIButtonMessage(2, x, y, z));
				RandomizerNumberCodeBlockGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 92, this.topPos + 87, 76, 20, new TextComponent("Edit"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new RandomizerNumberCodeBlockGUIButtonMessage(3, x, y, z));
				RandomizerNumberCodeBlockGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}));
	}
}
