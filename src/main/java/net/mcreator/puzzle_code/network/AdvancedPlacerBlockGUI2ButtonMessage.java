
package net.mcreator.puzzle_code.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.puzzle_code.world.inventory.AdvancedPlacerBlockGUI2Menu;
import net.mcreator.puzzle_code.procedures.SwitchRedstoneReactProcedure;
import net.mcreator.puzzle_code.procedures.SwitchRedstoneContinuouslyProcedure;
import net.mcreator.puzzle_code.procedures.AdvancedPlacerBlockPage2Procedure;
import net.mcreator.puzzle_code.procedures.AdvancedPlacerBlockPage1Procedure;
import net.mcreator.puzzle_code.procedures.AdvancedPlacerBlockGUIPageRedstoneContinuouslyProcedure;
import net.mcreator.puzzle_code.procedures.AdvancedPlacerBlockGUIPageRangeProcedure;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AdvancedPlacerBlockGUI2ButtonMessage {
	private final int buttonID, x, y, z;

	public AdvancedPlacerBlockGUI2ButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public AdvancedPlacerBlockGUI2ButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(AdvancedPlacerBlockGUI2ButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(AdvancedPlacerBlockGUI2ButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = AdvancedPlacerBlockGUI2Menu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			AdvancedPlacerBlockPage1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			AdvancedPlacerBlockPage2Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			AdvancedPlacerBlockGUIPageRangeProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			AdvancedPlacerBlockGUIPageRedstoneContinuouslyProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			SwitchRedstoneReactProcedure.execute(world, x, y, z);
		}
		if (buttonID == 5) {

			SwitchRedstoneContinuouslyProcedure.execute(world, x, y, z);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PuzzleCodeMod.addNetworkMessage(AdvancedPlacerBlockGUI2ButtonMessage.class, AdvancedPlacerBlockGUI2ButtonMessage::buffer, AdvancedPlacerBlockGUI2ButtonMessage::new, AdvancedPlacerBlockGUI2ButtonMessage::handler);
	}
}
