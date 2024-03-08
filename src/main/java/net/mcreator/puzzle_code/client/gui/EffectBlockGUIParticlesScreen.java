package net.mcreator.puzzle_code.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.puzzle_code.world.inventory.EffectBlockGUIParticlesMenu;
import net.mcreator.puzzle_code.procedures.ParticlesDisplayOnProcedure;
import net.mcreator.puzzle_code.procedures.ParticlesDisplayOffProcedure;
import net.mcreator.puzzle_code.network.EffectBlockGUIParticlesButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class EffectBlockGUIParticlesScreen extends AbstractContainerScreen<EffectBlockGUIParticlesMenu> {
	private final static HashMap<String, Object> guistate = EffectBlockGUIParticlesMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_back;
	ImageButton imagebutton_change_button;

	public EffectBlockGUIParticlesScreen(EffectBlockGUIParticlesMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 125;
		this.imageHeight = 80;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/screens/effect_block_gui_particles.png");

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
		if (ParticlesDisplayOnProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("puzzle_code:textures/screens/logic_true.png"), this.leftPos + 8, this.topPos + 18, 0, 0, 48, 20, 48, 20);
		}
		if (ParticlesDisplayOffProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("puzzle_code:textures/screens/logic_false.png"), this.leftPos + 8, this.topPos + 18, 0, 0, 48, 20, 48, 20);
		}
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
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.effect_block_gui_particles.label_particles"), 40, 5, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.effect_block_gui_particles.label_nbt_particles"), 8, 41, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_back = Button.builder(Component.translatable("gui.puzzle_code.effect_block_gui_particles.button_back"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new EffectBlockGUIParticlesButtonMessage(0, x, y, z));
				EffectBlockGUIParticlesButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 8, this.topPos + 54, 108, 20).build();
		guistate.put("button:button_back", button_back);
		this.addRenderableWidget(button_back);
		imagebutton_change_button = new ImageButton(this.leftPos + 98, this.topPos + 18, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_change_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new EffectBlockGUIParticlesButtonMessage(1, x, y, z));
				EffectBlockGUIParticlesButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_change_button", imagebutton_change_button);
		this.addRenderableWidget(imagebutton_change_button);
	}
}
