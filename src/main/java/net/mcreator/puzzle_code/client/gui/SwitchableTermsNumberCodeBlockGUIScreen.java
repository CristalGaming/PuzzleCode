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

import net.mcreator.puzzle_code.world.inventory.SwitchableTermsNumberCodeBlockGUIMenu;
import net.mcreator.puzzle_code.procedures.IsDisabledDisplayOnProcedure;
import net.mcreator.puzzle_code.procedures.IsDisabledDisplayOffProcedure;
import net.mcreator.puzzle_code.procedures.AddRightDisplayOnProcedure;
import net.mcreator.puzzle_code.procedures.AddRightDisplayOffProcedure;
import net.mcreator.puzzle_code.procedures.AddLeftDisplayOnProcedure;
import net.mcreator.puzzle_code.procedures.AddLeftDisplayOffProcedure;
import net.mcreator.puzzle_code.procedures.AddBackDisplayOnProcedure;
import net.mcreator.puzzle_code.procedures.AddBackDisplayOffProcedure;
import net.mcreator.puzzle_code.network.SwitchableTermsNumberCodeBlockGUIButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class SwitchableTermsNumberCodeBlockGUIScreen extends AbstractContainerScreen<SwitchableTermsNumberCodeBlockGUIMenu> {
	private final static HashMap<String, Object> guistate = SwitchableTermsNumberCodeBlockGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_left;
	Button button_back;
	Button button_right;
	ImageButton imagebutton_change_button;

	public SwitchableTermsNumberCodeBlockGUIScreen(SwitchableTermsNumberCodeBlockGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 177;
		this.imageHeight = 83;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/screens/switchable_terms_number_code_block_gui.png");

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
		if (AddLeftDisplayOnProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("puzzle_code:textures/screens/logic_true.png"), this.leftPos + 7, this.topPos + 33, 0, 0, 48, 20, 48, 20);
		}
		if (AddLeftDisplayOffProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("puzzle_code:textures/screens/logic_false.png"), this.leftPos + 7, this.topPos + 33, 0, 0, 48, 20, 48, 20);
		}
		if (AddBackDisplayOnProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("puzzle_code:textures/screens/logic_true.png"), this.leftPos + 63, this.topPos + 33, 0, 0, 48, 20, 48, 20);
		}
		if (AddBackDisplayOffProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("puzzle_code:textures/screens/logic_false.png"), this.leftPos + 63, this.topPos + 33, 0, 0, 48, 20, 48, 20);
		}
		if (AddRightDisplayOnProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("puzzle_code:textures/screens/logic_true.png"), this.leftPos + 119, this.topPos + 33, 0, 0, 48, 20, 48, 20);
		}
		if (AddRightDisplayOffProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("puzzle_code:textures/screens/logic_false.png"), this.leftPos + 119, this.topPos + 33, 0, 0, 48, 20, 48, 20);
		}
		if (IsDisabledDisplayOnProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("puzzle_code:textures/screens/logic_true.png"), this.leftPos + 75, this.topPos + 57, 0, 0, 48, 20, 48, 20);
		}
		if (IsDisabledDisplayOffProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("puzzle_code:textures/screens/logic_false.png"), this.leftPos + 75, this.topPos + 57, 0, 0, 48, 20, 48, 20);
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
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.switchable_terms_number_code_block_gui.label_is_disabled_bnbtlogicisdisab"), 7, 61, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_left = Button.builder(Component.translatable("gui.puzzle_code.switchable_terms_number_code_block_gui.button_left"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new SwitchableTermsNumberCodeBlockGUIButtonMessage(0, x, y, z));
				SwitchableTermsNumberCodeBlockGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 7, this.topPos + 5, 48, 20).build();
		guistate.put("button:button_left", button_left);
		this.addRenderableWidget(button_left);
		button_back = Button.builder(Component.translatable("gui.puzzle_code.switchable_terms_number_code_block_gui.button_back"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new SwitchableTermsNumberCodeBlockGUIButtonMessage(1, x, y, z));
				SwitchableTermsNumberCodeBlockGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 63, this.topPos + 5, 48, 20).build();
		guistate.put("button:button_back", button_back);
		this.addRenderableWidget(button_back);
		button_right = Button.builder(Component.translatable("gui.puzzle_code.switchable_terms_number_code_block_gui.button_right"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new SwitchableTermsNumberCodeBlockGUIButtonMessage(2, x, y, z));
				SwitchableTermsNumberCodeBlockGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 119, this.topPos + 5, 48, 20).build();
		guistate.put("button:button_right", button_right);
		this.addRenderableWidget(button_right);
		imagebutton_change_button = new ImageButton(this.leftPos + 151, this.topPos + 57, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_change_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new SwitchableTermsNumberCodeBlockGUIButtonMessage(3, x, y, z));
				SwitchableTermsNumberCodeBlockGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_change_button", imagebutton_change_button);
		this.addRenderableWidget(imagebutton_change_button);
	}
}
