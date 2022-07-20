
package net.mcreator.puzzle_code.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.puzzle_code.world.inventory.TeleporterNumberCodeBlockGUI2Menu;
import net.mcreator.puzzle_code.procedures.TeleporterNumberCodeBlockGUIPage1Procedure;
import net.mcreator.puzzle_code.procedures.EditSetNBTProcedure;
import net.mcreator.puzzle_code.procedures.EditGetNBTProcedure;
import net.mcreator.puzzle_code.procedures.ApplySetNBTProcedure;
import net.mcreator.puzzle_code.procedures.ApplyGetNBTProcedure;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TeleporterNumberCodeBlockGUI2ButtonMessage {
	private final int buttonID, x, y, z;

	public TeleporterNumberCodeBlockGUI2ButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public TeleporterNumberCodeBlockGUI2ButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(TeleporterNumberCodeBlockGUI2ButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(TeleporterNumberCodeBlockGUI2ButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		Level world = entity.level;
		HashMap guistate = TeleporterNumberCodeBlockGUI2Menu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			TeleporterNumberCodeBlockGUIPage1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			ApplyGetNBTProcedure.execute(world, x, y, z, guistate);
		}
		if (buttonID == 2) {

			ApplySetNBTProcedure.execute(world, x, y, z, guistate);
		}
		if (buttonID == 3) {

			EditGetNBTProcedure.execute(world, x, y, z, guistate);
		}
		if (buttonID == 4) {

			EditSetNBTProcedure.execute(world, x, y, z, guistate);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PuzzleCodeMod.addNetworkMessage(TeleporterNumberCodeBlockGUI2ButtonMessage.class, TeleporterNumberCodeBlockGUI2ButtonMessage::buffer,
				TeleporterNumberCodeBlockGUI2ButtonMessage::new, TeleporterNumberCodeBlockGUI2ButtonMessage::handler);
	}
}
