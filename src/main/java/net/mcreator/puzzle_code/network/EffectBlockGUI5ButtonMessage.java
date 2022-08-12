
package net.mcreator.puzzle_code.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.puzzle_code.world.inventory.EffectBlockGUI5Menu;
import net.mcreator.puzzle_code.procedures.SetNearReactTrueProcedure;
import net.mcreator.puzzle_code.procedures.SetNearReactFalseProcedure;
import net.mcreator.puzzle_code.procedures.EffectBlockGUIPage4Procedure;
import net.mcreator.puzzle_code.procedures.EffectBlockGUIPage3Procedure;
import net.mcreator.puzzle_code.procedures.EffectBlockGUIPage2Procedure;
import net.mcreator.puzzle_code.procedures.EffectBlockGUIPage1Procedure;
import net.mcreator.puzzle_code.procedures.EditRangeProcedure;
import net.mcreator.puzzle_code.procedures.ApplyRangeProcedure;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EffectBlockGUI5ButtonMessage {
	private final int buttonID, x, y, z;

	public EffectBlockGUI5ButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public EffectBlockGUI5ButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(EffectBlockGUI5ButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(EffectBlockGUI5ButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = EffectBlockGUI5Menu.guistate;
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

			EffectBlockGUIPage1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			EffectBlockGUIPage2Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			EffectBlockGUIPage3Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			EffectBlockGUIPage4Procedure.execute(world, x, y, z, entity);
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
		PuzzleCodeMod.addNetworkMessage(EffectBlockGUI5ButtonMessage.class, EffectBlockGUI5ButtonMessage::buffer, EffectBlockGUI5ButtonMessage::new,
				EffectBlockGUI5ButtonMessage::handler);
	}
}
