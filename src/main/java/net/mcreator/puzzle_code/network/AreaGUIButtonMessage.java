
package net.mcreator.puzzle_code.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.puzzle_code.world.inventory.AreaGUIMenu;
import net.mcreator.puzzle_code.procedures.PositionGUIButtonZProcedure;
import net.mcreator.puzzle_code.procedures.PositionGUIButtonYProcedure;
import net.mcreator.puzzle_code.procedures.PositionGUIButtonXProcedure;
import net.mcreator.puzzle_code.procedures.EditPositionValueAreaProcedure;
import net.mcreator.puzzle_code.procedures.AreaGUIButtonSwapProcedure;
import net.mcreator.puzzle_code.procedures.AreaGUIButton2Procedure;
import net.mcreator.puzzle_code.procedures.AreaGUIButton1Procedure;
import net.mcreator.puzzle_code.procedures.AreaGUIBackProcedure;
import net.mcreator.puzzle_code.procedures.ApplyPositionValueAreaProcedure;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class AreaGUIButtonMessage {
	private final int buttonID, x, y, z;

	public AreaGUIButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public AreaGUIButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(AreaGUIButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(AreaGUIButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = AreaGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			PositionGUIButtonXProcedure.execute(world, x, y, z);
		}
		if (buttonID == 1) {

			PositionGUIButtonYProcedure.execute(world, x, y, z);
		}
		if (buttonID == 2) {

			PositionGUIButtonZProcedure.execute(world, x, y, z);
		}
		if (buttonID == 3) {

			AreaGUIBackProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			AreaGUIButton1Procedure.execute(world, x, y, z);
		}
		if (buttonID == 5) {

			AreaGUIButton2Procedure.execute(world, x, y, z);
		}
		if (buttonID == 6) {

			ApplyPositionValueAreaProcedure.execute(world, x, y, z, guistate);
		}
		if (buttonID == 7) {

			EditPositionValueAreaProcedure.execute(world, x, y, z, guistate);
		}
		if (buttonID == 8) {

			AreaGUIButtonSwapProcedure.execute(world, x, y, z);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PuzzleCodeMod.addNetworkMessage(AreaGUIButtonMessage.class, AreaGUIButtonMessage::buffer, AreaGUIButtonMessage::new, AreaGUIButtonMessage::handler);
	}
}
