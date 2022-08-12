
package net.mcreator.puzzle_code.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.puzzle_code.world.inventory.InEffectBlockGUI5Menu;
import net.mcreator.puzzle_code.procedures.SetNearReactTrueProcedure;
import net.mcreator.puzzle_code.procedures.SetNearReactFalseProcedure;
import net.mcreator.puzzle_code.procedures.InEffectBlockPage4Procedure;
import net.mcreator.puzzle_code.procedures.InEffectBlockPage3Procedure;
import net.mcreator.puzzle_code.procedures.InEffectBlockPage2Procedure;
import net.mcreator.puzzle_code.procedures.InEffectBlockPage1Procedure;
import net.mcreator.puzzle_code.procedures.EditRangeProcedure;
import net.mcreator.puzzle_code.procedures.ApplyRangeProcedure;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class InEffectBlockGUI5ButtonMessage {
	private final int buttonID, x, y, z;

	public InEffectBlockGUI5ButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public InEffectBlockGUI5ButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(InEffectBlockGUI5ButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(InEffectBlockGUI5ButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = InEffectBlockGUI5Menu.guistate;
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

			InEffectBlockPage1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			InEffectBlockPage2Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			InEffectBlockPage3Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			InEffectBlockPage4Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			ApplyRangeProcedure.execute(world, x, y, z, guistate);
		}
		if (buttonID == 7) {

			EditRangeProcedure.execute(world, x, y, z, guistate);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PuzzleCodeMod.addNetworkMessage(InEffectBlockGUI5ButtonMessage.class, InEffectBlockGUI5ButtonMessage::buffer,
				InEffectBlockGUI5ButtonMessage::new, InEffectBlockGUI5ButtonMessage::handler);
	}
}
