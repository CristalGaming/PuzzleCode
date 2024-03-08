package net.mcreator.puzzle_code.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.puzzle_code.world.inventory.ABlockIsBrokenGlobalBlockGUIMenu;
import net.mcreator.puzzle_code.procedures.ReturnzPosProcedure;
import net.mcreator.puzzle_code.procedures.ReturnyPosProcedure;
import net.mcreator.puzzle_code.procedures.ReturnxPosProcedure;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class ABlockIsBrokenGlobalBlockGUIScreen extends AbstractContainerScreen<ABlockIsBrokenGlobalBlockGUIMenu> {
	private final static HashMap<String, Object> guistate = ABlockIsBrokenGlobalBlockGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;

	public ABlockIsBrokenGlobalBlockGUIScreen(ABlockIsBrokenGlobalBlockGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/screens/a_block_is_broken_global_block_gui.png");

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
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.a_block_is_broken_global_block_gui.label_x_bnbtnumberxpos"), 6, 43, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.a_block_is_broken_global_block_gui.label_y_bnbtnumberypos"), 6, 57, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.a_block_is_broken_global_block_gui.label_z_bnbtnumberzpos"), 6, 70, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnxPosProcedure.execute(world, x, y, z), 69, 43, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnyPosProcedure.execute(world, x, y, z), 69, 57, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnzPosProcedure.execute(world, x, y, z), 69, 70, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
	}
}
