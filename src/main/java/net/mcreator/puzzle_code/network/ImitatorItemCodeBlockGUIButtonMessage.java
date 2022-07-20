
package net.mcreator.puzzle_code.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.puzzle_code.world.inventory.ImitatorItemCodeBlockGUIMenu;
import net.mcreator.puzzle_code.procedures.OpenImitatorItemCodeBlockGUI2Procedure;
import net.mcreator.puzzle_code.procedures.EditzPosProcedure;
import net.mcreator.puzzle_code.procedures.EdityPosProcedure;
import net.mcreator.puzzle_code.procedures.EditxPosProcedure;
import net.mcreator.puzzle_code.procedures.ApplyzPosProcedure;
import net.mcreator.puzzle_code.procedures.ApplyyPosProcedure;
import net.mcreator.puzzle_code.procedures.ApplyxPosProcedure;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class ImitatorItemCodeBlockGUIButtonMessage {
	private final int buttonID, x, y, z;

	public ImitatorItemCodeBlockGUIButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public ImitatorItemCodeBlockGUIButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(ImitatorItemCodeBlockGUIButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(ImitatorItemCodeBlockGUIButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = ImitatorItemCodeBlockGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			ApplyxPosProcedure.execute(world, x, y, z, guistate);
		}
		if (buttonID == 1) {

			ApplyyPosProcedure.execute(world, x, y, z, guistate);
		}
		if (buttonID == 2) {

			ApplyzPosProcedure.execute(world, x, y, z, guistate);
		}
		if (buttonID == 3) {

			OpenImitatorItemCodeBlockGUI2Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			EditxPosProcedure.execute(world, x, y, z, guistate);
		}
		if (buttonID == 5) {

			EdityPosProcedure.execute(world, x, y, z, guistate);
		}
		if (buttonID == 6) {

			EditzPosProcedure.execute(world, x, y, z, guistate);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PuzzleCodeMod.addNetworkMessage(ImitatorItemCodeBlockGUIButtonMessage.class, ImitatorItemCodeBlockGUIButtonMessage::buffer,
				ImitatorItemCodeBlockGUIButtonMessage::new, ImitatorItemCodeBlockGUIButtonMessage::handler);
	}
}
