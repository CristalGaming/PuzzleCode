
package net.mcreator.puzzle_code.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.puzzle_code.world.inventory.CommandCodeBlockGUI2Menu;
import net.mcreator.puzzle_code.procedures.SwitchWalkingReactProcedure;
import net.mcreator.puzzle_code.procedures.SwitchRedstoneReactProcedure;
import net.mcreator.puzzle_code.procedures.SwitchClickingReactProcedure;
import net.mcreator.puzzle_code.procedures.OpenWalkingReactGUIPageProcedure;
import net.mcreator.puzzle_code.procedures.OpenRedstoneReactGUIPageProcedure;
import net.mcreator.puzzle_code.procedures.OpenClickingReactGUIPageProcedure;
import net.mcreator.puzzle_code.procedures.CommandCodeBlockPage2Procedure;
import net.mcreator.puzzle_code.procedures.CommandCodeBlockPage1Procedure;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CommandCodeBlockGUI2ButtonMessage {
	private final int buttonID, x, y, z;

	public CommandCodeBlockGUI2ButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public CommandCodeBlockGUI2ButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(CommandCodeBlockGUI2ButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(CommandCodeBlockGUI2ButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = CommandCodeBlockGUI2Menu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			CommandCodeBlockPage1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			CommandCodeBlockPage2Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			SwitchWalkingReactProcedure.execute(world, x, y, z);
		}
		if (buttonID == 3) {

			SwitchRedstoneReactProcedure.execute(world, x, y, z);
		}
		if (buttonID == 4) {

			SwitchClickingReactProcedure.execute(world, x, y, z);
		}
		if (buttonID == 5) {

			OpenWalkingReactGUIPageProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			OpenClickingReactGUIPageProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			OpenRedstoneReactGUIPageProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PuzzleCodeMod.addNetworkMessage(CommandCodeBlockGUI2ButtonMessage.class, CommandCodeBlockGUI2ButtonMessage::buffer, CommandCodeBlockGUI2ButtonMessage::new, CommandCodeBlockGUI2ButtonMessage::handler);
	}
}
