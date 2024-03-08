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

import net.mcreator.puzzle_code.world.inventory.HealthBlockGUIIsDisabledMenu;
import net.mcreator.puzzle_code.procedures.IsDisabledDisplayOnProcedure;
import net.mcreator.puzzle_code.procedures.IsDisabledDisplayOffProcedure;
import net.mcreator.puzzle_code.network.HealthBlockGUIIsDisabledButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class HealthBlockGUIIsDisabledScreen extends AbstractContainerScreen<HealthBlockGUIIsDisabledMenu> {
	private final static HashMap<String, Object> guistate = HealthBlockGUIIsDisabledMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_back;
	ImageButton imagebutton_change_button;

	public HealthBlockGUIIsDisabledScreen(HealthBlockGUIIsDisabledMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 125;
		this.imageHeight = 80;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/screens/health_block_gui_is_disabled.png");

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
		if (IsDisabledDisplayOnProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("puzzle_code:textures/screens/logic_true.png"), this.leftPos + 8, this.topPos + 18, 0, 0, 48, 20, 48, 20);
		}
		if (IsDisabledDisplayOffProcedure.execute(world, x, y, z)) {
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
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.health_block_gui_is_disabled.label_is_disabled"), 31, 5, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.health_block_gui_is_disabled.label_nbt_isdisabled"), 8, 41, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_back = Button.builder(Component.translatable("gui.puzzle_code.health_block_gui_is_disabled.button_back"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new HealthBlockGUIIsDisabledButtonMessage(0, x, y, z));
				HealthBlockGUIIsDisabledButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 8, this.topPos + 54, 108, 20).build();
		guistate.put("button:button_back", button_back);
		this.addRenderableWidget(button_back);
		imagebutton_change_button = new ImageButton(this.leftPos + 94, this.topPos + 18, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_change_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new HealthBlockGUIIsDisabledButtonMessage(1, x, y, z));
				HealthBlockGUIIsDisabledButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_change_button", imagebutton_change_button);
		this.addRenderableWidget(imagebutton_change_button);
	}
}
