
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

import net.mcreator.puzzle_code.world.inventory.InEffectBlockGUI5Menu;
import net.mcreator.puzzle_code.network.InEffectBlockGUI5ButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class InEffectBlockGUI5Screen extends AbstractContainerScreen<InEffectBlockGUI5Menu> {
	private final static HashMap<String, Object> guistate = InEffectBlockGUI5Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox rangeField;

	public InEffectBlockGUI5Screen(InEffectBlockGUI5Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 229;
		this.imageHeight = 117;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/screens/in_effect_block_gui_5.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		rangeField.render(ms, mouseX, mouseY, partialTicks);
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
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, "React when entity is near the range?", 6, 9, -12829636);
		this.font.draw(poseStack, "" + (new Object() {
			public boolean getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getTileData().getBoolean(tag);
				return false;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "nearReact")) + "", 168, 27, -12829636);
		this.font.draw(poseStack, "[5]", 105, 95, -12829636);
		this.font.draw(poseStack, "Range: " + ((int) new Object() {
			public double getValue(BlockPos pos, String tag) {
				BlockEntity BlockEntity = world.getBlockEntity(pos);
				if (BlockEntity != null)
					return BlockEntity.getTileData().getDouble(tag);
				return 0;
			}
		}.getValue(new BlockPos((int) x, (int) y, (int) z), "range")) + "", 6, 68, -12829636);
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
		this.addRenderableWidget(new Button(this.leftPos + 6, this.topPos + 23, 77, 20, new TextComponent("True"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new InEffectBlockGUI5ButtonMessage(0, x, y, z));
				InEffectBlockGUI5ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 87, this.topPos + 23, 76, 20, new TextComponent("False"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new InEffectBlockGUI5ButtonMessage(1, x, y, z));
				InEffectBlockGUI5ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 33, this.topPos + 90, 14, 20, new TextComponent("1"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new InEffectBlockGUI5ButtonMessage(2, x, y, z));
				InEffectBlockGUI5ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 51, this.topPos + 90, 14, 20, new TextComponent("2"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new InEffectBlockGUI5ButtonMessage(3, x, y, z));
				InEffectBlockGUI5ButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 69, this.topPos + 90, 14, 20, new TextComponent("3"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new InEffectBlockGUI5ButtonMessage(4, x, y, z));
				InEffectBlockGUI5ButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 87, this.topPos + 90, 14, 20, new TextComponent("4"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new InEffectBlockGUI5ButtonMessage(5, x, y, z));
				InEffectBlockGUI5ButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		}));
		rangeField = new EditBox(this.font, this.leftPos + 6, this.topPos + 45, 108, 20, new TextComponent(""));
		guistate.put("text:rangeField", rangeField);
		rangeField.setMaxLength(32767);
		this.addWidget(this.rangeField);
		this.addRenderableWidget(new Button(this.leftPos + 119, this.topPos + 45, 50, 20, new TextComponent("Apply"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new InEffectBlockGUI5ButtonMessage(6, x, y, z));
				InEffectBlockGUI5ButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 173, this.topPos + 45, 50, 20, new TextComponent("Edit"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new InEffectBlockGUI5ButtonMessage(7, x, y, z));
				InEffectBlockGUI5ButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		}));
	}
}
