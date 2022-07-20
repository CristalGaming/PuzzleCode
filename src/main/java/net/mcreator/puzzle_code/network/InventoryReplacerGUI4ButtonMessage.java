
package net.mcreator.puzzle_code.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.puzzle_code.world.inventory.InventoryReplacerGUI4Menu;
import net.mcreator.puzzle_code.procedures.OpenInventoryReplacerGUIProcedure;
import net.mcreator.puzzle_code.procedures.OpenInventoryReplacerGUI3Procedure;
import net.mcreator.puzzle_code.procedures.OpenInventoryReplacerGUI2Procedure;
import net.mcreator.puzzle_code.procedures.ChangeReplaceInventoryProcedure;
import net.mcreator.puzzle_code.procedures.ChangeReplaceHotbarProcedure;
import net.mcreator.puzzle_code.procedures.ChangeReplaceArmorProcedure;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class InventoryReplacerGUI4ButtonMessage {
	private final int buttonID, x, y, z;

	public InventoryReplacerGUI4ButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public InventoryReplacerGUI4ButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(InventoryReplacerGUI4ButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(InventoryReplacerGUI4ButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = InventoryReplacerGUI4Menu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			ChangeReplaceHotbarProcedure.execute(world, x, y, z);
		}
		if (buttonID == 1) {

			ChangeReplaceInventoryProcedure.execute(world, x, y, z);
		}
		if (buttonID == 2) {

			ChangeReplaceArmorProcedure.execute(world, x, y, z);
		}
		if (buttonID == 3) {

			OpenInventoryReplacerGUIProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			OpenInventoryReplacerGUI2Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			OpenInventoryReplacerGUI3Procedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PuzzleCodeMod.addNetworkMessage(InventoryReplacerGUI4ButtonMessage.class, InventoryReplacerGUI4ButtonMessage::buffer,
				InventoryReplacerGUI4ButtonMessage::new, InventoryReplacerGUI4ButtonMessage::handler);
	}
}
