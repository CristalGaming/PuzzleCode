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

import net.mcreator.puzzle_code.world.inventory.AdvancedTeleporterBlockGUI3Menu;
import net.mcreator.puzzle_code.procedures.ReturnRangeProcedure;
import net.mcreator.puzzle_code.procedures.NearReactDisplayOnProcedure;
import net.mcreator.puzzle_code.procedures.NearReactDisplayOffProcedure;
import net.mcreator.puzzle_code.procedures.IsDisabledDisplayOnProcedure;
import net.mcreator.puzzle_code.procedures.IsDisabledDisplayOffProcedure;
import net.mcreator.puzzle_code.network.AdvancedTeleporterBlockGUI3ButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class AdvancedTeleporterBlockGUI3Screen extends AbstractContainerScreen<AdvancedTeleporterBlockGUI3Menu> {
	private final static HashMap<String, Object> guistate = AdvancedTeleporterBlockGUI3Menu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox rangeField;
	Button button_2;
	Button button_1;
	Button button_3;
	ImageButton imagebutton_enter_button;
	ImageButton imagebutton_edit_button;
	ImageButton imagebutton_change_button;
	ImageButton imagebutton_change_button1;

	public AdvancedTeleporterBlockGUI3Screen(AdvancedTeleporterBlockGUI3Menu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 169;
		this.imageHeight = 164;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/screens/advanced_teleporter_block_gui_3.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		rangeField.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		if (NearReactDisplayOnProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("puzzle_code:textures/screens/logic_true.png"), this.leftPos + 89, this.topPos + 20, 0, 0, 48, 20, 48, 20);
		}
		if (NearReactDisplayOffProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("puzzle_code:textures/screens/logic_false.png"), this.leftPos + 89, this.topPos + 20, 0, 0, 48, 20, 48, 20);
		}
		if (IsDisabledDisplayOnProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("puzzle_code:textures/screens/logic_true.png"), this.leftPos + 89, this.topPos + 114, 0, 0, 48, 20, 48, 20);
		}
		if (IsDisabledDisplayOffProcedure.execute(world, x, y, z)) {
			guiGraphics.blit(new ResourceLocation("puzzle_code:textures/screens/logic_false.png"), this.leftPos + 89, this.topPos + 114, 0, 0, 48, 20, 48, 20);
		}
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		if (rangeField.isFocused())
			return rangeField.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		rangeField.tick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.advanced_teleporter_block_gui_3.label_react_when_entity_is_near_the_ra"), 17, 6, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnRangeProcedure.execute(world, x, y, z), 8, 83, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.advanced_teleporter_block_gui_3.label_is_disabled"), 57, 101, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.advanced_teleporter_block_gui_3.label_range"), 75, 47, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		rangeField = new EditBox(this.font, this.leftPos + 9, this.topPos + 61, 106, 18, Component.translatable("gui.puzzle_code.advanced_teleporter_block_gui_3.rangeField"));
		rangeField.setMaxLength(32767);
		guistate.put("text:rangeField", rangeField);
		this.addWidget(this.rangeField);
		button_2 = Button.builder(Component.translatable("gui.puzzle_code.advanced_teleporter_block_gui_3.button_2"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new AdvancedTeleporterBlockGUI3ButtonMessage(0, x, y, z));
				AdvancedTeleporterBlockGUI3ButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 75, this.topPos + 137, 18, 20).build();
		guistate.put("button:button_2", button_2);
		this.addRenderableWidget(button_2);
		button_1 = Button.builder(Component.translatable("gui.puzzle_code.advanced_teleporter_block_gui_3.button_1"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new AdvancedTeleporterBlockGUI3ButtonMessage(1, x, y, z));
				AdvancedTeleporterBlockGUI3ButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 53, this.topPos + 137, 18, 20).build();
		guistate.put("button:button_1", button_1);
		this.addRenderableWidget(button_1);
		button_3 = Button.builder(Component.translatable("gui.puzzle_code.advanced_teleporter_block_gui_3.button_3"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new AdvancedTeleporterBlockGUI3ButtonMessage(2, x, y, z));
				AdvancedTeleporterBlockGUI3ButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 98, this.topPos + 137, 18, 20).build();
		guistate.put("button:button_3", button_3);
		this.addRenderableWidget(button_3);
		imagebutton_enter_button = new ImageButton(this.leftPos + 143, this.topPos + 60, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_enter_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new AdvancedTeleporterBlockGUI3ButtonMessage(3, x, y, z));
				AdvancedTeleporterBlockGUI3ButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_enter_button", imagebutton_enter_button);
		this.addRenderableWidget(imagebutton_enter_button);
		imagebutton_edit_button = new ImageButton(this.leftPos + 120, this.topPos + 60, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_edit_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new AdvancedTeleporterBlockGUI3ButtonMessage(4, x, y, z));
				AdvancedTeleporterBlockGUI3ButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:imagebutton_edit_button", imagebutton_edit_button);
		this.addRenderableWidget(imagebutton_edit_button);
		imagebutton_change_button = new ImageButton(this.leftPos + 62, this.topPos + 20, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_change_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new AdvancedTeleporterBlockGUI3ButtonMessage(5, x, y, z));
				AdvancedTeleporterBlockGUI3ButtonMessage.handleButtonAction(entity, 5, x, y, z);
			}
		});
		guistate.put("button:imagebutton_change_button", imagebutton_change_button);
		this.addRenderableWidget(imagebutton_change_button);
		imagebutton_change_button1 = new ImageButton(this.leftPos + 62, this.topPos + 114, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_change_button1.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new AdvancedTeleporterBlockGUI3ButtonMessage(6, x, y, z));
				AdvancedTeleporterBlockGUI3ButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		});
		guistate.put("button:imagebutton_change_button1", imagebutton_change_button1);
		this.addRenderableWidget(imagebutton_change_button1);
	}
}
