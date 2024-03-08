
package net.mcreator.puzzle_code.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.puzzle_code.world.inventory.CatapulterBlockGUIMenu;
import net.mcreator.puzzle_code.procedures.EditzPosProcedure;
import net.mcreator.puzzle_code.procedures.EdityPosProcedure;
import net.mcreator.puzzle_code.procedures.EditxPosProcedure;
import net.mcreator.puzzle_code.procedures.CatapulterBlockGUIPage2Procedure;
import net.mcreator.puzzle_code.procedures.CatapulterBlockGUIPage1Procedure;
import net.mcreator.puzzle_code.procedures.ApplyzPosProcedure;
import net.mcreator.puzzle_code.procedures.ApplyyPosProcedure;
import net.mcreator.puzzle_code.procedures.ApplyxPosProcedure;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CatapulterBlockGUIButtonMessage {
	private final int buttonID, x, y, z;

	public CatapulterBlockGUIButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public CatapulterBlockGUIButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(CatapulterBlockGUIButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(CatapulterBlockGUIButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = CatapulterBlockGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			CatapulterBlockGUIPage1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			CatapulterBlockGUIPage2Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			ApplyxPosProcedure.execute(world, x, y, z, guistate);
		}
		if (buttonID == 3) {

			EditxPosProcedure.execute(world, x, y, z, guistate);
		}
		if (buttonID == 4) {

			ApplyyPosProcedure.execute(world, x, y, z, guistate);
		}
		if (buttonID == 5) {

			EdityPosProcedure.execute(world, x, y, z, guistate);
		}
		if (buttonID == 6) {

			ApplyzPosProcedure.execute(world, x, y, z, guistate);
		}
		if (buttonID == 7) {

			EditzPosProcedure.execute(world, x, y, z, guistate);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PuzzleCodeMod.addNetworkMessage(CatapulterBlockGUIButtonMessage.class, CatapulterBlockGUIButtonMessage::buffer, CatapulterBlockGUIButtonMessage::new, CatapulterBlockGUIButtonMessage::handler);
	}
}
