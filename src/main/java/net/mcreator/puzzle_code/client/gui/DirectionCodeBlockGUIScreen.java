package net.mcreator.puzzle_code.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.puzzle_code.world.inventory.DirectionCodeBlockGUIMenu;
import net.mcreator.puzzle_code.procedures.ReturnDirectionCodeBlockProcedure;
import net.mcreator.puzzle_code.network.DirectionCodeBlockGUIButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class DirectionCodeBlockGUIScreen extends AbstractContainerScreen<DirectionCodeBlockGUIMenu> {
	private final static HashMap<String, Object> guistate = DirectionCodeBlockGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	ImageButton imagebutton_change_button;
	ImageButton imagebutton_change_button1;
	ImageButton imagebutton_change_button2;
	ImageButton imagebutton_change_button3;
	ImageButton imagebutton_change_button4;
	ImageButton imagebutton_change_button5;

	public DirectionCodeBlockGUIScreen(DirectionCodeBlockGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 141;
		this.imageHeight = 105;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/screens/direction_code_block_gui.png");

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
		guiGraphics.drawString(this.font,

				ReturnDirectionCodeBlockProcedure.execute(world, x, y, z), 7, 75, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.direction_code_block_gui.label_nbt_directioncodeblock"), 7, 89, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		imagebutton_change_button = new ImageButton(this.leftPos + 57, this.topPos + 8, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_change_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new DirectionCodeBlockGUIButtonMessage(0, x, y, z));
				DirectionCodeBlockGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_change_button", imagebutton_change_button);
		this.addRenderableWidget(imagebutton_change_button);
		imagebutton_change_button1 = new ImageButton(this.leftPos + 57, this.topPos + 30, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_change_button1.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new DirectionCodeBlockGUIButtonMessage(1, x, y, z));
				DirectionCodeBlockGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_change_button1", imagebutton_change_button1);
		this.addRenderableWidget(imagebutton_change_button1);
		imagebutton_change_button2 = new ImageButton(this.leftPos + 57, this.topPos + 53, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_change_button2.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new DirectionCodeBlockGUIButtonMessage(2, x, y, z));
				DirectionCodeBlockGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_change_button2", imagebutton_change_button2);
		this.addRenderableWidget(imagebutton_change_button2);
		imagebutton_change_button3 = new ImageButton(this.leftPos + 34, this.topPos + 30, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_change_button3.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new DirectionCodeBlockGUIButtonMessage(3, x, y, z));
				DirectionCodeBlockGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_change_button3", imagebutton_change_button3);
		this.addRenderableWidget(imagebutton_change_button3);
		imagebutton_change_button4 = new ImageButton(this.leftPos + 79, this.topPos + 30, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_change_button4.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new DirectionCodeBlockGUIButtonMessage(4, x, y, z));
				DirectionCodeBlockGUIButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:imagebutton_change_button4", imagebutton_change_button4);
		this.addRenderableWidget(imagebutton_change_button4);
		imagebutton_change_button5 = new ImageButton(this.leftPos + 79, this.topPos + 53, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_change_button5.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new DirectionCodeBlockGUIButtonMessage(5, x, y, z));
				DirectionCodeBlockGUIButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:imagebutton_change_button5", imagebutton_change_button5);
		this.addRenderableWidget(imagebutton_change_button5);
	}
}
