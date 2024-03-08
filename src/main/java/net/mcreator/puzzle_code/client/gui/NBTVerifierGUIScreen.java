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

import net.mcreator.puzzle_code.world.inventory.NBTVerifierGUIMenu;
import net.mcreator.puzzle_code.procedures.VarReturnNBTVerifierVariableTypeProcedure;
import net.mcreator.puzzle_code.procedures.VarReturnNBTVerifierNBTProcedure;
import net.mcreator.puzzle_code.procedures.VarReturnNBTVerifierCurrentValueProcedure;
import net.mcreator.puzzle_code.network.NBTVerifierGUIButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class NBTVerifierGUIScreen extends AbstractContainerScreen<NBTVerifierGUIMenu> {
	private final static HashMap<String, Object> guistate = NBTVerifierGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox NBTVerifyField;
	Button button_number;
	Button button_logic;
	Button button_text;
	ImageButton imagebutton_enter_button;

	public NBTVerifierGUIScreen(NBTVerifierGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 119;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/screens/nbt_verifier_gui.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		NBTVerifyField.render(guiGraphics, mouseX, mouseY, partialTicks);
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
		if (NBTVerifyField.isFocused())
			return NBTVerifyField.keyPressed(key, b, c);
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
		NBTVerifyField.tick();
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.nbt_verifier_gui.label_nbt_namevarnbtverifiernbt"), 6, 28, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.puzzle_code.nbt_verifier_gui.label_nbt_current_value"), 6, 87, -12829636, false);
		guiGraphics.drawString(this.font,

				VarReturnNBTVerifierCurrentValueProcedure.execute(entity), 6, 100, -12829636, false);
		guiGraphics.drawString(this.font,

				VarReturnNBTVerifierVariableTypeProcedure.execute(entity), 6, 69, -12829636, false);
		guiGraphics.drawString(this.font,

				VarReturnNBTVerifierNBTProcedure.execute(entity), 60, 28, -12829636, false);
	}

	@Override
	public void onClose() {
		super.onClose();
	}

	@Override
	public void init() {
		super.init();
		NBTVerifyField = new EditBox(this.font, this.leftPos + 7, this.topPos + 7, 133, 18, Component.translatable("gui.puzzle_code.nbt_verifier_gui.NBTVerifyField"));
		NBTVerifyField.setMaxLength(32767);
		guistate.put("text:NBTVerifyField", NBTVerifyField);
		this.addWidget(this.NBTVerifyField);
		button_number = Button.builder(Component.translatable("gui.puzzle_code.nbt_verifier_gui.button_number"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new NBTVerifierGUIButtonMessage(0, x, y, z));
				NBTVerifierGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 6, this.topPos + 46, 50, 20).build();
		guistate.put("button:button_number", button_number);
		this.addRenderableWidget(button_number);
		button_logic = Button.builder(Component.translatable("gui.puzzle_code.nbt_verifier_gui.button_logic"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new NBTVerifierGUIButtonMessage(1, x, y, z));
				NBTVerifierGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}).bounds(this.leftPos + 60, this.topPos + 46, 54, 20).build();
		guistate.put("button:button_logic", button_logic);
		this.addRenderableWidget(button_logic);
		button_text = Button.builder(Component.translatable("gui.puzzle_code.nbt_verifier_gui.button_text"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new NBTVerifierGUIButtonMessage(2, x, y, z));
				NBTVerifierGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}).bounds(this.leftPos + 119, this.topPos + 46, 50, 20).build();
		guistate.put("button:button_text", button_text);
		this.addRenderableWidget(button_text);
		imagebutton_enter_button = new ImageButton(this.leftPos + 146, this.topPos + 6, 20, 20, 0, 0, 20, new ResourceLocation("puzzle_code:textures/screens/atlas/imagebutton_enter_button.png"), 20, 40, e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new NBTVerifierGUIButtonMessage(3, x, y, z));
				NBTVerifierGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:imagebutton_enter_button", imagebutton_enter_button);
		this.addRenderableWidget(imagebutton_enter_button);
	}
}
