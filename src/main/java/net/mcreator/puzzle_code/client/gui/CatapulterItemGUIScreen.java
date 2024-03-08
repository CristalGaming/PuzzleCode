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

import net.mcreator.puzzle_code.world.inventory.CatapulterItemGUIMenu;
import net.mcreator.puzzle_code.procedures.ReturnItemPositionsProcedure;
import net.mcreator.puzzle_code.network.CatapulterItemGUIButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class CatapulterItemGUIScreen extends AbstractContainerScreen<CatapulterItemGUIMenu> {
	private final static HashMap<String, Object> guistate = CatapulterItemGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_back;
	ImageButton imagebutton_settings_button;
	ImageButton imagebutton_add_button;

	public CatapulterItemGUIScreen(CatapulterItemGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 51;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/screens/catapulter_item_gui.png");

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
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.catapulter_item_gui.label_position"), 56, 12, -12829636, false);
		guiGraphics.drawString(this.font,

				ReturnItemPositionsProcedure.execute(world, x, y, z), 6, 30, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		button_back = Button.builder(Component.translatable("gui.puzzle_code.catapulter_item_gui.button_back"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CatapulterItemGUIButtonMessage(0, x, y, z));
				CatapulterItemGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 119, this.topPos + 17, 46, 20).build();
		guistate.put("button:button_back", button_back);
		this.addRenderableWidget(button_back);
		imagebutton_settings_button = new ImageButton(this.leftPos + 29, this.topPos + 8, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_settings_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new CatapulterItemGUIButtonMessage(1, x, y, z));
				CatapulterItemGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:imagebutton_settings_button", imagebutton_settings_button);
		this.addRenderableWidget(imagebutton_settings_button);
		imagebutton_add_button = new ImageButton(this.leftPos + 6, this.topPos + 8, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_add_button.png"), 20, 40, e -> {
		});
		guistate.put("button:imagebutton_add_button", imagebutton_add_button);
		this.addRenderableWidget(imagebutton_add_button);
	}
}
