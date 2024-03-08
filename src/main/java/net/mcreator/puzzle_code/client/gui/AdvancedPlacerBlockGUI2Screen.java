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

import net.mcreator.puzzle_code.world.inventory.AdvancedPlacerBlockGUI2Menu;
import net.mcreator.puzzle_code.procedures.RedstoneReactDisplayOnProcedure;
import net.mcreator.puzzle_code.procedures.RedstoneReactDisplayOffProcedure;
import net.mcreator.puzzle_code.procedures.RedstoneContinuouslyDisplayOnProcedure;
import net.mcreator.puzzle_code.procedures.RedstoneContinuouslyDisplayOffProcedure;
import net.mcreator.puzzle_code.network.AdvancedPlacerBlockGUI2ButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class AdvancedPlacerBlockGUI2Screen extends AbstractContainerScreen<AdvancedPlacerBlockGUI2Menu> {
	private final static HashMap<String, Object> guistate = AdvancedPlacerBlockGUI2Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_1;
	Button button_2;
	ImageButton imagebutton_settings_button;
	ImageButton imagebutton_settings_button1;
	ImageButton imagebutton_change_button;
	ImageButton imagebutton_change_button1;

	public AdvancedPlacerBlockGUI2Screen(AdvancedPlacerBlockGUI2Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 164;
		this.imageHeight = 115;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/screens/advanced_placer_block_gui_2.png");

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
		if (RedstoneReactDisplayOnProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("puzzle_code:textures/screens/logic_true.png"), this.leftPos + 86, this.topPos + 17, 0, 0, 48, 20, 48, 20);
		}
		if (RedstoneReactDisplayOffProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("puzzle_code:textures/screens/logic_false.png"), this.leftPos + 86, this.topPos + 17, 0, 0, 48, 20, 48, 20);
		}
		if (RedstoneContinuouslyDisplayOnProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("puzzle_code:textures/screens/logic_true.png"), this.leftPos + 86, this.topPos + 58, 0, 0, 48, 20, 48, 20);
		}
		if (RedstoneContinuouslyDisplayOffProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("puzzle_code:textures/screens/logic_false.png"), this.leftPos + 86, this.topPos + 58, 0, 0, 48, 20, 48, 20);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.advanced_placer_block_gui_2.label_react_when_it_gets_redstone"), 9, 4, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.advanced_placer_block_gui_2.label_does_react_continuously"), 18, 44, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_1 = Button.builder(Component.translatable("gui.puzzle_code.advanced_placer_block_gui_2.button_1"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new AdvancedPlacerBlockGUI2ButtonMessage(0, x, y, z));
				AdvancedPlacerBlockGUI2ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 59, this.topPos + 85, 18, 20).build();
		guistate.put("button:button_1", button_1);
		this.addRenderableWidget(button_1);
		button_2 = Button.builder(Component.translatable("gui.puzzle_code.advanced_placer_block_gui_2.button_2"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new AdvancedPlacerBlockGUI2ButtonMessage(1, x, y, z));
				AdvancedPlacerBlockGUI2ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 86, this.topPos + 85, 18, 20).build();
		guistate.put("button:button_2", button_2);
		this.addRenderableWidget(button_2);
		imagebutton_settings_button = new ImageButton(this.leftPos + 54, this.topPos + 17, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_settings_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new AdvancedPlacerBlockGUI2ButtonMessage(2, x, y, z));
				AdvancedPlacerBlockGUI2ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_settings_button", imagebutton_settings_button);
		this.addRenderableWidget(imagebutton_settings_button);
		imagebutton_settings_button1 = new ImageButton(this.leftPos + 54, this.topPos + 58, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_settings_button1.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new AdvancedPlacerBlockGUI2ButtonMessage(3, x, y, z));
				AdvancedPlacerBlockGUI2ButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_settings_button1", imagebutton_settings_button1);
		this.addRenderableWidget(imagebutton_settings_button1);
		imagebutton_change_button = new ImageButton(this.leftPos + 27, this.topPos + 17, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_change_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new AdvancedPlacerBlockGUI2ButtonMessage(4, x, y, z));
				AdvancedPlacerBlockGUI2ButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:imagebutton_change_button", imagebutton_change_button);
		this.addRenderableWidget(imagebutton_change_button);
		imagebutton_change_button1 = new ImageButton(this.leftPos + 27, this.topPos + 58, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_change_button1.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new AdvancedPlacerBlockGUI2ButtonMessage(5, x, y, z));
				AdvancedPlacerBlockGUI2ButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:imagebutton_change_button1", imagebutton_change_button1);
		this.addRenderableWidget(imagebutton_change_button1);
	}
}
