
package net.mcreator.puzzle_code.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.puzzle_code.world.inventory.CheckpointBlockGUI1Menu;
import net.mcreator.puzzle_code.procedures.OpenWalkingReactGUIPageProcedure;
import net.mcreator.puzzle_code.procedures.OpenRedstoneReactGUIPageProcedure;
import net.mcreator.puzzle_code.procedures.OpenClickingReactGUIPageProcedure;
import net.mcreator.puzzle_code.procedures.CheckpointBlockPage2Procedure;
import net.mcreator.puzzle_code.procedures.CheckpointBlockPage1Procedure;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CheckpointBlockGUI1ButtonMessage {
	private final int buttonID, x, y, z;

	public CheckpointBlockGUI1ButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public CheckpointBlockGUI1ButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(CheckpointBlockGUI1ButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(CheckpointBlockGUI1ButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = CheckpointBlockGUI1Menu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			CheckpointBlockPage2Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			CheckpointBlockPage1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			OpenWalkingReactGUIPageProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			OpenClickingReactGUIPageProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			OpenRedstoneReactGUIPageProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PuzzleCodeMod.addNetworkMessage(CheckpointBlockGUI1ButtonMessage.class, CheckpointBlockGUI1ButtonMessage::buffer, CheckpointBlockGUI1ButtonMessage::new, CheckpointBlockGUI1ButtonMessage::handler);
	}
}
