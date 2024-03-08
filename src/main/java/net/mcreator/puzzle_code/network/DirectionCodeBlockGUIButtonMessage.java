
package net.mcreator.puzzle_code.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.puzzle_code.world.inventory.DirectionCodeBlockGUIMenu;
import net.mcreator.puzzle_code.procedures.SetDirectionWestProcedure;
import net.mcreator.puzzle_code.procedures.SetDirectionUpProcedure;
import net.mcreator.puzzle_code.procedures.SetDirectionSouthProcedure;
import net.mcreator.puzzle_code.procedures.SetDirectionNorthProcedure;
import net.mcreator.puzzle_code.procedures.SetDirectionEastProcedure;
import net.mcreator.puzzle_code.procedures.SetDirectionDownProcedure;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DirectionCodeBlockGUIButtonMessage {
	private final int buttonID, x, y, z;

	public DirectionCodeBlockGUIButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public DirectionCodeBlockGUIButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(DirectionCodeBlockGUIButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(DirectionCodeBlockGUIButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = DirectionCodeBlockGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			SetDirectionUpProcedure.execute(world, x, y, z);
		}
		if (buttonID == 1) {

			SetDirectionNorthProcedure.execute(world, x, y, z);
		}
		if (buttonID == 2) {

			SetDirectionDownProcedure.execute(world, x, y, z);
		}
		if (buttonID == 3) {

			SetDirectionWestProcedure.execute(world, x, y, z);
		}
		if (buttonID == 4) {

			SetDirectionEastProcedure.execute(world, x, y, z);
		}
		if (buttonID == 5) {

			SetDirectionSouthProcedure.execute(world, x, y, z);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PuzzleCodeMod.addNetworkMessage(DirectionCodeBlockGUIButtonMessage.class, DirectionCodeBlockGUIButtonMessage::buffer, DirectionCodeBlockGUIButtonMessage::new, DirectionCodeBlockGUIButtonMessage::handler);
	}
}
