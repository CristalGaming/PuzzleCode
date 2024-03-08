
package net.mcreator.puzzle_code.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.puzzle_code.world.inventory.ItemAreaGUIMenu;
import net.mcreator.puzzle_code.procedures.ItemPositionGUIButtonZProcedure;
import net.mcreator.puzzle_code.procedures.ItemPositionGUIButtonYProcedure;
import net.mcreator.puzzle_code.procedures.ItemPositionGUIButtonXProcedure;
import net.mcreator.puzzle_code.procedures.ItemAreaGUIButtonSwapProcedure;
import net.mcreator.puzzle_code.procedures.ItemAreaGUIButton2Procedure;
import net.mcreator.puzzle_code.procedures.ItemAreaGUIButton1Procedure;
import net.mcreator.puzzle_code.procedures.EditItemPositionValueAreaProcedure;
import net.mcreator.puzzle_code.procedures.AreaGUIBackProcedure;
import net.mcreator.puzzle_code.procedures.ApplyItemPositionValueAreaProcedure;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ItemAreaGUIButtonMessage {
	private final int buttonID, x, y, z;

	public ItemAreaGUIButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public ItemAreaGUIButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(ItemAreaGUIButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(ItemAreaGUIButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = ItemAreaGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			ItemPositionGUIButtonXProcedure.execute(world, x, y, z);
		}
		if (buttonID == 1) {

			ItemPositionGUIButtonYProcedure.execute(world, x, y, z);
		}
		if (buttonID == 2) {

			ItemPositionGUIButtonZProcedure.execute(world, x, y, z);
		}
		if (buttonID == 3) {

			AreaGUIBackProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			ItemAreaGUIButton1Procedure.execute(world, x, y, z);
		}
		if (buttonID == 5) {

			ItemAreaGUIButton2Procedure.execute(world, x, y, z);
		}
		if (buttonID == 6) {

			ApplyItemPositionValueAreaProcedure.execute(world, x, y, z, guistate);
		}
		if (buttonID == 7) {

			EditItemPositionValueAreaProcedure.execute(world, x, y, z, guistate);
		}
		if (buttonID == 8) {

			ItemAreaGUIButtonSwapProcedure.execute(world, x, y, z);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PuzzleCodeMod.addNetworkMessage(ItemAreaGUIButtonMessage.class, ItemAreaGUIButtonMessage::buffer, ItemAreaGUIButtonMessage::new, ItemAreaGUIButtonMessage::handler);
	}
}
