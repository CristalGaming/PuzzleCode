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

import net.mcreator.puzzle_code.world.inventory.EffectBlockGUI3Menu;
import net.mcreator.puzzle_code.procedures.ReturnRangeProcedure;
import net.mcreator.puzzle_code.procedures.EffectBlockGUIPage3ValueDisplayConditionProcedure;
import net.mcreator.puzzle_code.procedures.EffectBlockGUIPage3TextProcedure;
import net.mcreator.puzzle_code.procedures.EffectBlockGUIPage3LogicDisplayTrueProcedure;
import net.mcreator.puzzle_code.procedures.EffectBlockGUIPage3LogicDisplayFalseProcedure;
import net.mcreator.puzzle_code.network.EffectBlockGUI3ButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class EffectBlockGUI3Screen extends AbstractContainerScreen<EffectBlockGUI3Menu> {
	private final static HashMap<String, Object> guistate = EffectBlockGUI3Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_1;
	Button button_2;
	Button button_3;
	Button button_41;
	Button button_51;
	ImageButton imagebutton_edit_button;
	ImageButton imagebutton_tab_potion_deselected;
	ImageButton imagebutton_tab_potion_deselected1;
	ImageButton imagebutton_tab_interaction;
	ImageButton imagebutton_position_button;

	public EffectBlockGUI3Screen(EffectBlockGUI3Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 181;
		this.imageHeight = 80;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/screens/effect_block_gui_3.png");

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
		if (EffectBlockGUIPage3LogicDisplayTrueProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("puzzle_code:textures/screens/logic_true.png"), this.leftPos + 122, this.topPos + 50, 0, 0, 48, 20, 48, 20);
		}
		if (EffectBlockGUIPage3LogicDisplayFalseProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("puzzle_code:textures/screens/logic_false.png"), this.leftPos + 122, this.topPos + 50, 0, 0, 48, 20, 48, 20);
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
		guiGraphics.drawString(this.font,

				EffectBlockGUIPage3TextProcedure.execute(world, x, y, z), 9, 32, -12829636, false);
		if (EffectBlockGUIPage3ValueDisplayConditionProcedure.execute(world, x, y, z))
			guiGraphics.drawString(this.font,

					ReturnRangeProcedure.execute(world, x, y, z), 59, 54, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_1 = Button.builder(Component.translatable("gui.puzzle_code.effect_block_gui_3.button_1"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new EffectBlockGUI3ButtonMessage(0, x, y, z));
				EffectBlockGUI3ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 9, this.topPos + 5, 18, 20).build();
		guistate.put("button:button_1", button_1);
		this.addRenderableWidget(button_1);
		button_2 = Button.builder(Component.translatable("gui.puzzle_code.effect_block_gui_3.button_2"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new EffectBlockGUI3ButtonMessage(1, x, y, z));
				EffectBlockGUI3ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 45, this.topPos + 5, 18, 20).build();
		guistate.put("button:button_2", button_2);
		this.addRenderableWidget(button_2);
		button_3 = Button.builder(Component.translatable("gui.puzzle_code.effect_block_gui_3.button_3"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new EffectBlockGUI3ButtonMessage(2, x, y, z));
				EffectBlockGUI3ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 81, this.topPos + 5, 18, 20).build();
		guistate.put("button:button_3", button_3);
		this.addRenderableWidget(button_3);
		button_41 = Button.builder(Component.translatable("gui.puzzle_code.effect_block_gui_3.button_41"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new EffectBlockGUI3ButtonMessage(3, x, y, z));
				EffectBlockGUI3ButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}).bounds(this.leftPos + 117, this.topPos + 5, 18, 20).build();
		guistate.put("button:button_41", button_41);
		this.addRenderableWidget(button_41);
		button_51 = Button.builder(Component.translatable("gui.puzzle_code.effect_block_gui_3.button_51"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new EffectBlockGUI3ButtonMessage(4, x, y, z));
				EffectBlockGUI3ButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		}).bounds(this.leftPos + 153, this.topPos + 5, 18, 20).build();
		guistate.put("button:button_51", button_51);
		this.addRenderableWidget(button_51);
		imagebutton_edit_button = new ImageButton(this.leftPos + 32, this.topPos + 50, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_edit_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new EffectBlockGUI3ButtonMessage(5, x, y, z));
				EffectBlockGUI3ButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:imagebutton_edit_button", imagebutton_edit_button);
		this.addRenderableWidget(imagebutton_edit_button);
		imagebutton_tab_potion_deselected = new ImageButton(this.leftPos + 0, this.topPos + 77, 32, 32, 0, 0, 32, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_tab_potion_deselected.png"), 32, 64, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new EffectBlockGUI3ButtonMessage(6, x, y, z));
				EffectBlockGUI3ButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		});
		guistate.put("button:imagebutton_tab_potion_deselected", imagebutton_tab_potion_deselected);
		this.addRenderableWidget(imagebutton_tab_potion_deselected);
		imagebutton_tab_potion_deselected1 = new ImageButton(this.leftPos + 72, this.topPos + 77, 32, 32, 0, 0, 32, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_tab_potion_deselected1.png"), 32, 64, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new EffectBlockGUI3ButtonMessage(7, x, y, z));
				EffectBlockGUI3ButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		});
		guistate.put("button:imagebutton_tab_potion_deselected1", imagebutton_tab_potion_deselected1);
		this.addRenderableWidget(imagebutton_tab_potion_deselected1);
		imagebutton_tab_interaction = new ImageButton(this.leftPos + 147, this.topPos + 77, 32, 32, 0, 0, 32, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_tab_interaction.png"), 32, 64, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new EffectBlockGUI3ButtonMessage(8, x, y, z));
				EffectBlockGUI3ButtonMessage.handleButtonAction(entity, 8, x, y, z);
			}
		});
		guistate.put("button:imagebutton_tab_interaction", imagebutton_tab_interaction);
		this.addRenderableWidget(imagebutton_tab_interaction);
		imagebutton_position_button = new ImageButton(this.leftPos + 9, this.topPos + 50, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_position_button.png"), 20, 40, e -> {
		});
		guistate.put("button:imagebutton_position_button", imagebutton_position_button);
		this.addRenderableWidget(imagebutton_position_button);
	}
}
