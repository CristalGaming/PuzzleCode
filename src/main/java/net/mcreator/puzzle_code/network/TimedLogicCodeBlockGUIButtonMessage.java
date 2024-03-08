
package net.mcreator.puzzle_code.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.puzzle_code.world.inventory.TimedLogicCodeBlockGUIMenu;
import net.mcreator.puzzle_code.procedures.EditTrueDelayProcedure;
import net.mcreator.puzzle_code.procedures.EditFalseDelayProcedure;
import net.mcreator.puzzle_code.procedures.ApplyTrueDelayProcedure;
import net.mcreator.puzzle_code.procedures.ApplyFalseDelayProcedure;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TimedLogicCodeBlockGUIButtonMessage {
	private final int buttonID, x, y, z;

	public TimedLogicCodeBlockGUIButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public TimedLogicCodeBlockGUIButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(TimedLogicCodeBlockGUIButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(TimedLogicCodeBlockGUIButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = TimedLogicCodeBlockGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			ApplyTrueDelayProcedure.execute(world, x, y, z, guistate);
		}
		if (buttonID == 1) {

			EditTrueDelayProcedure.execute(world, x, y, z, guistate);
		}
		if (buttonID == 2) {

			EditFalseDelayProcedure.execute(world, x, y, z, guistate);
		}
		if (buttonID == 3) {

			ApplyFalseDelayProcedure.execute(world, x, y, z, guistate);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PuzzleCodeMod.addNetworkMessage(TimedLogicCodeBlockGUIButtonMessage.class, TimedLogicCodeBlockGUIButtonMessage::buffer, TimedLogicCodeBlockGUIButtonMessage::new, TimedLogicCodeBlockGUIButtonMessage::handler);
	}
}
