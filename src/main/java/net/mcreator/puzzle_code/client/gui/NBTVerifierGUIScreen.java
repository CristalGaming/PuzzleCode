
package net.mcreator.puzzle_code.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.puzzle_code.world.inventory.NBTVerifierGUIMenu;
import net.mcreator.puzzle_code.network.PuzzleCodeModVariables;
import net.mcreator.puzzle_code.network.NBTVerifierGUIButtonMessage;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class NBTVerifierGUIScreen extends AbstractContainerScreen<NBTVerifierGUIMenu> {
	private final static HashMap<String, Object> guistate = NBTVerifierGUIMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	EditBox NBTVerifyField;

	public NBTVerifierGUIScreen(NBTVerifierGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 176;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("puzzle_code:textures/nbt_verifier_gui.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
		NBTVerifyField.render(ms, mouseX, mouseY, partialTicks);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);

		RenderSystem.setShaderTexture(0, new ResourceLocation("puzzle_code:textures/puzzle_code_logo.png"));
		this.blit(ms, this.leftPos + 150, this.topPos + 7, 0, 0, 16, 16, 16, 16);

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
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, "NBT name:" + ((entity.getCapability(PuzzleCodeModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new PuzzleCodeModVariables.PlayerVariables())).NBTVerifierNBT) + "", 6, 52, -12829636);
		this.font.draw(poseStack, "NBT Current Value:", 6, 133, -12829636);
		this.font.draw(poseStack, "" + ((entity.getCapability(PuzzleCodeModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new PuzzleCodeModVariables.PlayerVariables())).NBTVerifierCurrentValue) + "", 6, 147, -12829636);
		this.font.draw(poseStack, "" + ((entity.getCapability(PuzzleCodeModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new PuzzleCodeModVariables.PlayerVariables())).NBTVerifierVariableType) + "", 6, 93, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		NBTVerifyField = new EditBox(this.font, this.leftPos + 6, this.topPos + 25, 112, 20, new TextComponent(""));
		guistate.put("text:NBTVerifyField", NBTVerifyField);
		NBTVerifyField.setMaxLength(32767);
		this.addWidget(this.NBTVerifyField);
		this.addRenderableWidget(new Button(this.leftPos + 119, this.topPos + 25, 51, 20, new TextComponent("Apply"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new NBTVerifierGUIButtonMessage(0, x, y, z));
				NBTVerifierGUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 6, this.topPos + 66, 50, 20, new TextComponent("Number"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new NBTVerifierGUIButtonMessage(1, x, y, z));
				NBTVerifierGUIButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 60, this.topPos + 66, 50, 20, new TextComponent("Logic"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new NBTVerifierGUIButtonMessage(2, x, y, z));
				NBTVerifierGUIButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		}));
		this.addRenderableWidget(new Button(this.leftPos + 114, this.topPos + 66, 50, 20, new TextComponent("Text"), e -> {
			if (true) {
				PuzzleCodeMod.PACKET_HANDLER.sendToServer(new NBTVerifierGUIButtonMessage(3, x, y, z));
				NBTVerifierGUIButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		}));
	}
}
