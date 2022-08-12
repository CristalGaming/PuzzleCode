
package net.mcreator.puzzle_code.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.puzzle_code.world.inventory.AdvancedTeleporterBlockGUI3Menu;
import net.mcreator.puzzle_code.procedures.SwitchIsDisabledProcedure;
import net.mcreator.puzzle_code.procedures.SetNearReactTrueProcedure;
import net.mcreator.puzzle_code.procedures.SetNearReactFalseProcedure;
import net.mcreator.puzzle_code.procedures.EntityTeleporterBlockPage2Procedure;
import net.mcreator.puzzle_code.procedures.EntityTeleporterBlockPage1Procedure;
import net.mcreator.puzzle_code.procedures.EditRangeProcedure;
import net.mcreator.puzzle_code.procedures.ApplyRangeProcedure;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AdvancedTeleporterBlockGUI3ButtonMessage {
	private final int buttonID, x, y, z;

	public AdvancedTeleporterBlockGUI3ButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public AdvancedTeleporterBlockGUI3ButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(AdvancedTeleporterBlockGUI3ButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(AdvancedTeleporterBlockGUI3ButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = AdvancedTeleporterBlockGUI3Menu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			SetNearReactTrueProcedure.execute(world, x, y, z);
		}
		if (buttonID == 1) {

			SetNearReactFalseProcedure.execute(world, x, y, z);
		}
		if (buttonID == 2) {

			EntityTeleporterBlockPage2Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			ApplyRangeProcedure.execute(world, x, y, z, guistate);
		}
		if (buttonID == 4) {

			EditRangeProcedure.execute(world, x, y, z, guistate);
		}
		if (buttonID == 5) {

			SwitchIsDisabledProcedure.execute(world, x, y, z);
		}
		if (buttonID == 6) {

			EntityTeleporterBlockPage1Procedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PuzzleCodeMod.addNetworkMessage(AdvancedTeleporterBlockGUI3ButtonMessage.class, AdvancedTeleporterBlockGUI3ButtonMessage::buffer,
				AdvancedTeleporterBlockGUI3ButtonMessage::new, AdvancedTeleporterBlockGUI3ButtonMessage::handler);
	}
}
