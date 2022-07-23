
package net.mcreator.puzzle_code.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.puzzle_code.world.inventory.FillerItemCodeBlockGUI2Menu;
import net.mcreator.puzzle_code.procedures.FillerItemCodeBlockGUIPage3Procedure;
import net.mcreator.puzzle_code.procedures.FillerItemCodeBlockGUIPage1Procedure;
import net.mcreator.puzzle_code.procedures.EditzPos2Procedure;
import net.mcreator.puzzle_code.procedures.EdityPos2Procedure;
import net.mcreator.puzzle_code.procedures.EditxPos2Procedure;
import net.mcreator.puzzle_code.procedures.ApplyzPos2Procedure;
import net.mcreator.puzzle_code.procedures.ApplyyPos2Procedure;
import net.mcreator.puzzle_code.procedures.ApplyxPos2Procedure;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class FillerItemCodeBlockGUI2ButtonMessage {
	private final int buttonID, x, y, z;

	public FillerItemCodeBlockGUI2ButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public FillerItemCodeBlockGUI2ButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(FillerItemCodeBlockGUI2ButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(FillerItemCodeBlockGUI2ButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = FillerItemCodeBlockGUI2Menu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			ApplyxPos2Procedure.execute(world, x, y, z, guistate);
		}
		if (buttonID == 1) {

			ApplyyPos2Procedure.execute(world, x, y, z, guistate);
		}
		if (buttonID == 2) {

			ApplyzPos2Procedure.execute(world, x, y, z, guistate);
		}
		if (buttonID == 3) {

			FillerItemCodeBlockGUIPage1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			EditxPos2Procedure.execute(world, x, y, z, guistate);
		}
		if (buttonID == 5) {

			EdityPos2Procedure.execute(world, x, y, z, guistate);
		}
		if (buttonID == 6) {

			EditzPos2Procedure.execute(world, x, y, z, guistate);
		}
		if (buttonID == 7) {

			FillerItemCodeBlockGUIPage3Procedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PuzzleCodeMod.addNetworkMessage(FillerItemCodeBlockGUI2ButtonMessage.class, FillerItemCodeBlockGUI2ButtonMessage::buffer,
				FillerItemCodeBlockGUI2ButtonMessage::new, FillerItemCodeBlockGUI2ButtonMessage::handler);
	}
}
