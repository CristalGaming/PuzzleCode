
package net.mcreator.puzzle_code.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.puzzle_code.world.inventory.EffectBlockGUI4Menu;
import net.mcreator.puzzle_code.procedures.SwitchIsDisabledProcedure;
import net.mcreator.puzzle_code.procedures.SetWalkingReactTrueProcedure;
import net.mcreator.puzzle_code.procedures.SetWalkingReactFalseProcedure;
import net.mcreator.puzzle_code.procedures.SetClickingReactTrueProcedure;
import net.mcreator.puzzle_code.procedures.SetClickingReactFalseProcedure;
import net.mcreator.puzzle_code.procedures.EffectBlockGUIPage5Procedure;
import net.mcreator.puzzle_code.procedures.EffectBlockGUIPage3Procedure;
import net.mcreator.puzzle_code.procedures.EffectBlockGUIPage2Procedure;
import net.mcreator.puzzle_code.procedures.EffectBlockGUIPage1Procedure;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EffectBlockGUI4ButtonMessage {
	private final int buttonID, x, y, z;

	public EffectBlockGUI4ButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public EffectBlockGUI4ButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(EffectBlockGUI4ButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(EffectBlockGUI4ButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = EffectBlockGUI4Menu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			EffectBlockGUIPage1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			EffectBlockGUIPage2Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			EffectBlockGUIPage3Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			SetClickingReactTrueProcedure.execute(world, x, y, z);
		}
		if (buttonID == 4) {

			SetClickingReactFalseProcedure.execute(world, x, y, z);
		}
		if (buttonID == 5) {

			SwitchIsDisabledProcedure.execute(world, x, y, z);
		}
		if (buttonID == 6) {

			SetWalkingReactTrueProcedure.execute(world, x, y, z);
		}
		if (buttonID == 7) {

			SetWalkingReactFalseProcedure.execute(world, x, y, z);
		}
		if (buttonID == 8) {

			EffectBlockGUIPage5Procedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PuzzleCodeMod.addNetworkMessage(EffectBlockGUI4ButtonMessage.class, EffectBlockGUI4ButtonMessage::buffer, EffectBlockGUI4ButtonMessage::new,
				EffectBlockGUI4ButtonMessage::handler);
	}
}
