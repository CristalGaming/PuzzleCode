
package net.mcreator.puzzle_code.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.puzzle_code.world.inventory.DirectionCodeItemGUIMenu;
import net.mcreator.puzzle_code.procedures.SetDirectionWestDirectionCodeBlockProcedure;
import net.mcreator.puzzle_code.procedures.SetDirectionUpDirectionCodeItemProcedure;
import net.mcreator.puzzle_code.procedures.SetDirectionSouthDirectionCodeItemProcedure;
import net.mcreator.puzzle_code.procedures.SetDirectionNorthDirectionCodeItemProcedure;
import net.mcreator.puzzle_code.procedures.SetDirectionEastDirectionCodeBlockProcedure;
import net.mcreator.puzzle_code.procedures.SetDirectionDownDirectionCodeItemProcedure;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class DirectionCodeItemGUIButtonMessage {
	private final int buttonID, x, y, z;

	public DirectionCodeItemGUIButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public DirectionCodeItemGUIButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(DirectionCodeItemGUIButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(DirectionCodeItemGUIButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = DirectionCodeItemGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			SetDirectionUpDirectionCodeItemProcedure.execute(world, x, y, z);
		}
		if (buttonID == 1) {

			SetDirectionNorthDirectionCodeItemProcedure.execute(world, x, y, z);
		}
		if (buttonID == 2) {

			SetDirectionDownDirectionCodeItemProcedure.execute(world, x, y, z);
		}
		if (buttonID == 3) {

			SetDirectionWestDirectionCodeBlockProcedure.execute(world, x, y, z);
		}
		if (buttonID == 4) {

			SetDirectionEastDirectionCodeBlockProcedure.execute(world, x, y, z);
		}
		if (buttonID == 5) {

			SetDirectionSouthDirectionCodeItemProcedure.execute(world, x, y, z);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PuzzleCodeMod.addNetworkMessage(DirectionCodeItemGUIButtonMessage.class, DirectionCodeItemGUIButtonMessage::buffer, DirectionCodeItemGUIButtonMessage::new, DirectionCodeItemGUIButtonMessage::handler);
	}
}
