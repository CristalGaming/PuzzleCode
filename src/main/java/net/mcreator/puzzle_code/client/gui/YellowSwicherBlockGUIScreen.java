package net.mcreator.puzzle_code.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.puzzle_code.world.inventory.YellowSwicherBlockGUIMenu;
import net.mcreator.puzzle_code.procedures.ReturnMinPowerProcedure;
import net.mcreator.puzzle_code.network.YellowSwicherBlockGUIButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class YellowSwicherBlockGUIScreen extends AbstractContainerScreen<YellowSwicherBlockGUIMenu> {
	private final static HashMap<String, Object> guistate = YellowSwicherBlockGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox minPowerField;
	ImageButton imagebutton_enter_button;
	ImageButton imagebutton_edit_button;

	public YellowSwicherBlockGUIScreen(YellowSwicherBlockGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 57;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/screens/yellow_swicher_block_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		minPowerField.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (minPowerField.isFocused())
			return minPowerField.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		minPowerField.tick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.yellow_swicher_block_gui.label_power_needed_bnbtintegerminp"), 6, 30, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.yellow_swicher_block_gui.label_nbt_minpower"), 6, 43, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnMinPowerProcedure.execute(world, x, y, z), 78, 30, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		minPowerField = new EditBox(this.font, this.leftPos + 7, this.topPos + 8, 111, 18, Component.translatable("gui.puzzle_code.yellow_swicher_block_gui.minPowerField"));
		minPowerField.setMaxLength(32767);
		guistate.put("text:minPowerField", minPowerField);
		this.addWidget(this.minPowerField);
		imagebutton_enter_button = new ImageButton(this.leftPos + 146, this.topPos + 7, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_enter_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new YellowSwicherBlockGUIButtonMessage(0, x, y, z));
				YellowSwicherBlockGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:imagebutton_enter_button", imagebutton_enter_button);
		this.addRenderableWidget(imagebutton_enter_button);
		imagebutton_edit_button = new ImageButton(this.leftPos + 123, this.topPos + 7, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_edit_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new YellowSwicherBlockGUIButtonMessage(1, x, y, z));
				YellowSwicherBlockGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_edit_button", imagebutton_edit_button);
		this.addRenderableWidget(imagebutton_edit_button);
	}
}
