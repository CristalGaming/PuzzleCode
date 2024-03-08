
package net.mcreator.puzzle_code.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.puzzle_code.world.inventory.AdvancedTeleporterBlockGUI2Menu;
import net.mcreator.puzzle_code.procedures.SwitchWalkingReactProcedure;
import net.mcreator.puzzle_code.procedures.SwitchRedstoneReactProcedure;
import net.mcreator.puzzle_code.procedures.SwitchClickingReactProcedure;
import net.mcreator.puzzle_code.procedures.EntityTeleporterBlockPage3Procedure;
import net.mcreator.puzzle_code.procedures.EntityTeleporterBlockPage2Procedure;
import net.mcreator.puzzle_code.procedures.EntityTeleporterBlockPage1Procedure;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AdvancedTeleporterBlockGUI2ButtonMessage {
	private final int buttonID, x, y, z;

	public AdvancedTeleporterBlockGUI2ButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public AdvancedTeleporterBlockGUI2ButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(AdvancedTeleporterBlockGUI2ButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(AdvancedTeleporterBlockGUI2ButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = AdvancedTeleporterBlockGUI2Menu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			EntityTeleporterBlockPage3Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			EntityTeleporterBlockPage1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			EntityTeleporterBlockPage2Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			SwitchRedstoneReactProcedure.execute(world, x, y, z);
		}
		if (buttonID == 4) {

			SwitchClickingReactProcedure.execute(world, x, y, z);
		}
		if (buttonID == 5) {

			SwitchWalkingReactProcedure.execute(world, x, y, z);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PuzzleCodeMod.addNetworkMessage(AdvancedTeleporterBlockGUI2ButtonMessage.class, AdvancedTeleporterBlockGUI2ButtonMessage::buffer, AdvancedTeleporterBlockGUI2ButtonMessage::new, AdvancedTeleporterBlockGUI2ButtonMessage::handler);
	}
}
