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

import net.mcreator.puzzle_code.world.inventory.CommandCodeBlockGUI2Menu;
import net.mcreator.puzzle_code.procedures.WalkingReactDisplayOnProcedure;
import net.mcreator.puzzle_code.procedures.WalkingReactDisplayOffProcedure;
import net.mcreator.puzzle_code.procedures.RedstoneReactDisplayOnProcedure;
import net.mcreator.puzzle_code.procedures.RedstoneReactDisplayOffProcedure;
import net.mcreator.puzzle_code.procedures.ClickingReactDisplayOnProcedure;
import net.mcreator.puzzle_code.procedures.ClickingReactDisplayOffProcedure;
import net.mcreator.puzzle_code.network.CommandCodeBlockGUI2ButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class CommandCodeBlockGUI2Screen extends AbstractContainerScreen<CommandCodeBlockGUI2Menu> {
	private final static HashMap<String, Object> guistate = CommandCodeBlockGUI2Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_1;
	Button button_2;
	ImageButton imagebutton_change_button;
	ImageButton imagebutton_change_button1;
	ImageButton imagebutton_change_button2;
	ImageButton imagebutton_settings_button;
	ImageButton imagebutton_settings_button1;
	ImageButton imagebutton_settings_button2;

	public CommandCodeBlockGUI2Screen(CommandCodeBlockGUI2Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 157;
		this.imageHeight = 144;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/screens/command_code_block_gui_2.png");

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
		if (WalkingReactDisplayOnProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("puzzle_code:textures/screens/logic_true.png"), this.leftPos + 87, this.topPos + 19, 0, 0, 48, 20, 48, 20);
		}
		if (WalkingReactDisplayOffProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("puzzle_code:textures/screens/logic_false.png"), this.leftPos + 87, this.topPos + 19, 0, 0, 48, 20, 48, 20);
		}
		if (ClickingReactDisplayOnProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("puzzle_code:textures/screens/logic_true.png"), this.leftPos + 87, this.topPos + 55, 0, 0, 48, 20, 48, 20);
		}
		if (ClickingReactDisplayOffProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("puzzle_code:textures/screens/logic_false.png"), this.leftPos + 87, this.topPos + 55, 0, 0, 48, 20, 48, 20);
		}
		if (RedstoneReactDisplayOnProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("puzzle_code:textures/screens/logic_true.png"), this.leftPos + 87, this.topPos + 91, 0, 0, 48, 20, 48, 20);
		}
		if (RedstoneReactDisplayOffProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("puzzle_code:textures/screens/logic_false.png"), this.leftPos + 87, this.topPos + 91, 0, 0, 48, 20, 48, 20);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.command_code_block_gui_2.label_react_when_is_walked"), 24, 5, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.command_code_block_gui_2.label_react_when_is_clicked"), 24, 41, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.command_code_block_gui_2.label_react_when_it_gets_redstone"), 6, 77, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_1 = Button.builder(Component.translatable("gui.puzzle_code.command_code_block_gui_2.button_1"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CommandCodeBlockGUI2ButtonMessage(0, x, y, z));
				CommandCodeBlockGUI2ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 56, this.topPos + 118, 18, 20).build();
		guistate.put("button:button_1", button_1);
		this.addRenderableWidget(button_1);
		button_2 = Button.builder(Component.translatable("gui.puzzle_code.command_code_block_gui_2.button_2"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CommandCodeBlockGUI2ButtonMessage(1, x, y, z));
				CommandCodeBlockGUI2ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 83, this.topPos + 118, 18, 20).build();
		guistate.put("button:button_2", button_2);
		this.addRenderableWidget(button_2);
		imagebutton_change_button = new ImageButton(this.leftPos + 38, this.topPos + 19, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_change_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CommandCodeBlockGUI2ButtonMessage(2, x, y, z));
				CommandCodeBlockGUI2ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_change_button", imagebutton_change_button);
		this.addRenderableWidget(imagebutton_change_button);
		imagebutton_change_button1 = new ImageButton(this.leftPos + 38, this.topPos + 91, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_change_button1.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CommandCodeBlockGUI2ButtonMessage(3, x, y, z));
				CommandCodeBlockGUI2ButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_change_button1", imagebutton_change_button1);
		this.addRenderableWidget(imagebutton_change_button1);
		imagebutton_change_button2 = new ImageButton(this.leftPos + 38, this.topPos + 55, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_change_button2.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CommandCodeBlockGUI2ButtonMessage(4, x, y, z));
				CommandCodeBlockGUI2ButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:imagebutton_change_button2", imagebutton_change_button2);
		this.addRenderableWidget(imagebutton_change_button2);
		imagebutton_settings_button = new ImageButton(this.leftPos + 60, this.topPos + 19, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_settings_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CommandCodeBlockGUI2ButtonMessage(5, x, y, z));
				CommandCodeBlockGUI2ButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:imagebutton_settings_button", imagebutton_settings_button);
		this.addRenderableWidget(imagebutton_settings_button);
		imagebutton_settings_button1 = new ImageButton(this.leftPos + 60, this.topPos + 55, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_settings_button1.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CommandCodeBlockGUI2ButtonMessage(6, x, y, z));
				CommandCodeBlockGUI2ButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		});
		guistate.put("button:imagebutton_settings_button1", imagebutton_settings_button1);
		this.addRenderableWidget(imagebutton_settings_button1);
		imagebutton_settings_button2 = new ImageButton(this.leftPos + 60, this.topPos + 91, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_settings_button2.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CommandCodeBlockGUI2ButtonMessage(7, x, y, z));
				CommandCodeBlockGUI2ButtonMessage.handleButtonAction(entity, 7, x, y, z);
			}
		});
		guistate.put("button:imagebutton_settings_button2", imagebutton_settings_button2);
		this.addRenderableWidget(imagebutton_settings_button2);
	}
}
