
package net.mcreator.puzzle_code.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.puzzle_code.world.inventory.CommandCodeBlockGUIMenu;
import net.mcreator.puzzle_code.procedures.TextCodeBlockGuiButtonPressedProcedure;
import net.mcreator.puzzle_code.procedures.SwitchIsDisabledProcedure;
import net.mcreator.puzzle_code.procedures.OpenIsDisabledGUIPageProcedure;
import net.mcreator.puzzle_code.procedures.EditTextCodeBlockProcedure;
import net.mcreator.puzzle_code.procedures.CommandCodeBlockPage2Procedure;
import net.mcreator.puzzle_code.procedures.CommandCodeBlockPage1Procedure;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommandCodeBlockGUIButtonMessage {
	private final int buttonID, x, y, z;

	public CommandCodeBlockGUIButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public CommandCodeBlockGUIButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(CommandCodeBlockGUIButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(CommandCodeBlockGUIButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level();
		HashMap guistate = CommandCodeBlockGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			CommandCodeBlockPage2Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			CommandCodeBlockPage1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			EditTextCodeBlockProcedure.execute(world, x, y, z, guistate);
		}
		if (buttonID == 3) {

			TextCodeBlockGuiButtonPressedProcedure.execute(world, x, y, z, guistate);
		}
		if (buttonID == 4) {

			SwitchIsDisabledProcedure.execute(world, x, y, z);
		}
		if (buttonID == 5) {

			OpenIsDisabledGUIPageProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PuzzleCodeMod.addNetworkMessage(CommandCodeBlockGUIButtonMessage.class, CommandCodeBlockGUIButtonMessage::buffer, CommandCodeBlockGUIButtonMessage::new, CommandCodeBlockGUIButtonMessage::handler);
	}
}
