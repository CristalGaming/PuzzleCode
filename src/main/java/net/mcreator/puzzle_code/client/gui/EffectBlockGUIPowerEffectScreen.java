package net.mcreator.puzzle_code.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.puzzle_code.world.inventory.EffectBlockGUIPowerEffectMenu;
import net.mcreator.puzzle_code.procedures.ReturnPowerEffectProcedure;
import net.mcreator.puzzle_code.network.EffectBlockGUIPowerEffectButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class EffectBlockGUIPowerEffectScreen extends AbstractContainerScreen<EffectBlockGUIPowerEffectMenu> {
	private final static HashMap<String, Object> guistate = EffectBlockGUIPowerEffectMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox powerEffectField;
	Button button_back;
	ImageButton imagebutton_enter_button;
	ImageButton imagebutton_edit_button;

	public EffectBlockGUIPowerEffectScreen(EffectBlockGUIPowerEffectMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 96;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/screens/effect_block_gui_power_effect.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		powerEffectField.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (powerEffectField.isFocused())
			return powerEffectField.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		powerEffectField.tick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.effect_block_gui_power_effect.label_power"), 76, 5, -13421773, false);
		guiGraphics.drawString(this.font,

				ReturnPowerEffectProcedure.execute(world, x, y, z), 6, 40, -13421773, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.effect_block_gui_power_effect.label_nbt_powereffect"), 6, 53, -13421773, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		powerEffectField = new EditBox(this.font, this.leftPos + 7, this.topPos + 18, 115, 18, Component.translatable("gui.puzzle_code.effect_block_gui_power_effect.powerEffectField"));
		powerEffectField.setMaxLength(32767);
		guistate.put("text:powerEffectField", powerEffectField);
		this.addWidget(this.powerEffectField);
		button_back = Button.builder(Component.translatable("gui.puzzle_code.effect_block_gui_power_effect.button_back"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new EffectBlockGUIPowerEffectButtonMessage(0, x, y, z));
				EffectBlockGUIPowerEffectButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 67, 162, 20).build();
		guistate.put("button:button_back", button_back);
		this.addRenderableWidget(button_back);
		imagebutton_enter_button = new ImageButton(this.leftPos + 150, this.topPos + 17, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_enter_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new EffectBlockGUIPowerEffectButtonMessage(1, x, y, z));
				EffectBlockGUIPowerEffectButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_enter_button", imagebutton_enter_button);
		this.addRenderableWidget(imagebutton_enter_button);
		imagebutton_edit_button = new ImageButton(this.leftPos + 128, this.topPos + 17, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_edit_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new EffectBlockGUIPowerEffectButtonMessage(2, x, y, z));
				EffectBlockGUIPowerEffectButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:imagebutton_edit_button", imagebutton_edit_button);
		this.addRenderableWidget(imagebutton_edit_button);
	}
}
