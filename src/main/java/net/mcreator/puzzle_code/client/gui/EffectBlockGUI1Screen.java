package net.mcreator.puzzle_code.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.puzzle_code.world.inventory.EffectBlockGUI1Menu;
import net.mcreator.puzzle_code.procedures.ReturnPowerEffectProcedure;
import net.mcreator.puzzle_code.procedures.ReturnDurationEffectTicksProcedure;
import net.mcreator.puzzle_code.procedures.ReturnBlockNameProcedure;
import net.mcreator.puzzle_code.procedures.ParticlesDisplayOnProcedure;
import net.mcreator.puzzle_code.procedures.ParticlesDisplayOffProcedure;
import net.mcreator.puzzle_code.procedures.AmbientDisplayOnProcedure;
import net.mcreator.puzzle_code.procedures.AmbientDisplayOffProcedure;
import net.mcreator.puzzle_code.network.EffectBlockGUI1ButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class EffectBlockGUI1Screen extends AbstractContainerScreen<EffectBlockGUI1Menu> {
	private final static HashMap<String, Object> guistate = EffectBlockGUI1Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_edit_button;
	ImageButton imagebutton_edit_button1;
	ImageButton imagebutton_edit_button2;
	ImageButton imagebutton_edit_button3;
	ImageButton imagebutton_tab_potion;
	ImageButton imagebutton_tab_redstone_deselected;
	ImageButton imagebutton_tab_interaction_deselected;

	public EffectBlockGUI1Screen(EffectBlockGUI1Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 161;
		this.imageHeight = 145;
	}

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

		guiGraphics.blit(new ResourceLocation("puzzle_code:textures/screens/effect_block_gui_1.png"), this.leftPos + 0, this.topPos + 0, 0, 0, 161, 116, 161, 116);

		if (AmbientDisplayOnProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("puzzle_code:textures/screens/logic_true.png"), this.leftPos + 18, this.topPos + 85, 0, 0, 48, 20, 48, 20);
		}
		if (AmbientDisplayOffProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("puzzle_code:textures/screens/logic_false.png"), this.leftPos + 18, this.topPos + 85, 0, 0, 48, 20, 48, 20);
		}
		if (ParticlesDisplayOnProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("puzzle_code:textures/screens/logic_true.png"), this.leftPos + 94, this.topPos + 85, 0, 0, 48, 20, 48, 20);
		}
		if (ParticlesDisplayOffProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("puzzle_code:textures/screens/logic_false.png"), this.leftPos + 94, this.topPos + 85, 0, 0, 48, 20, 48, 20);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.effect_block_gui_1.label_power"), 40, 23, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.effect_block_gui_1.label_duration"), 110, 25, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnPowerEffectProcedure.execute(world, x, y, z), 9, 44, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnDurationEffectTicksProcedure.execute(world, x, y, z), 83, 44, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.effect_block_gui_1.label_ambient"), 35, 66, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.effect_block_gui_1.label_particles"), 105, 66, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnBlockNameProcedure.execute(world, x, y, z), 7, 7, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		imagebutton_edit_button = new ImageButton(this.leftPos + 10, this.topPos + 20, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_edit_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new EffectBlockGUI1ButtonMessage(0, x, y, z));
				EffectBlockGUI1ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_edit_button", imagebutton_edit_button);
		this.addRenderableWidget(imagebutton_edit_button);
		imagebutton_edit_button1 = new ImageButton(this.leftPos + 83, this.topPos + 20, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_edit_button1.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new EffectBlockGUI1ButtonMessage(1, x, y, z));
				EffectBlockGUI1ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_edit_button1", imagebutton_edit_button1);
		this.addRenderableWidget(imagebutton_edit_button1);
		imagebutton_edit_button2 = new ImageButton(this.leftPos + 9, this.topPos + 62, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_edit_button2.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new EffectBlockGUI1ButtonMessage(2, x, y, z));
				EffectBlockGUI1ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_edit_button2", imagebutton_edit_button2);
		this.addRenderableWidget(imagebutton_edit_button2);
		imagebutton_edit_button3 = new ImageButton(this.leftPos + 83, this.topPos + 61, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_edit_button3.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new EffectBlockGUI1ButtonMessage(3, x, y, z));
				EffectBlockGUI1ButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_edit_button3", imagebutton_edit_button3);
		this.addRenderableWidget(imagebutton_edit_button3);
		imagebutton_tab_potion = new ImageButton(this.leftPos + 0, this.topPos + 113, 32, 32, 0, 0, 32, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_tab_potion.png"), 32, 64, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new EffectBlockGUI1ButtonMessage(4, x, y, z));
				EffectBlockGUI1ButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:imagebutton_tab_potion", imagebutton_tab_potion);
		this.addRenderableWidget(imagebutton_tab_potion);
		imagebutton_tab_redstone_deselected = new ImageButton(this.leftPos + 65, this.topPos + 113, 32, 32, 0, 0, 32, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_tab_redstone_deselected.png"), 32, 64, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new EffectBlockGUI1ButtonMessage(5, x, y, z));
				EffectBlockGUI1ButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:imagebutton_tab_redstone_deselected", imagebutton_tab_redstone_deselected);
		this.addRenderableWidget(imagebutton_tab_redstone_deselected);
		imagebutton_tab_interaction_deselected = new ImageButton(this.leftPos + 128, this.topPos + 113, 32, 32, 0, 0, 32, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_tab_interaction_deselected.png"), 32, 64, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new EffectBlockGUI1ButtonMessage(6, x, y, z));
				EffectBlockGUI1ButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		});
		guistate.put("button:imagebutton_tab_interaction_deselected", imagebutton_tab_interaction_deselected);
		this.addRenderableWidget(imagebutton_tab_interaction_deselected);
	}
}
