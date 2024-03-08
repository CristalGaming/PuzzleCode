
package net.mcreator.puzzle_code.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.puzzle_code.world.inventory.HealthBlockGUI2Menu;
import net.mcreator.puzzle_code.procedures.HealthBlockPage2Procedure;
import net.mcreator.puzzle_code.procedures.HealthBlockPage1Procedure;
import net.mcreator.puzzle_code.procedures.HealthBlockGUIPageRangeProcedure;
import net.mcreator.puzzle_code.procedures.HealthBlockGUIPageNearReactProcedure;
import net.mcreator.puzzle_code.procedures.HealthBlockGUIPageIsDisabledProcedure;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class HealthBlockGUI2ButtonMessage {
	private final int buttonID, x, y, z;

	public HealthBlockGUI2ButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public HealthBlockGUI2ButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(HealthBlockGUI2ButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(HealthBlockGUI2ButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = HealthBlockGUI2Menu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			HealthBlockPage1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			HealthBlockPage2Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			HealthBlockGUIPageNearReactProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			HealthBlockGUIPageRangeProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			HealthBlockGUIPageIsDisabledProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PuzzleCodeMod.addNetworkMessage(HealthBlockGUI2ButtonMessage.class, HealthBlockGUI2ButtonMessage::buffer, HealthBlockGUI2ButtonMessage::new, HealthBlockGUI2ButtonMessage::handler);
	}
}
