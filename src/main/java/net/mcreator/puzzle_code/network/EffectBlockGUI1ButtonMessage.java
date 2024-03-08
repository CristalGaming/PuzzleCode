
package net.mcreator.puzzle_code.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.puzzle_code.world.inventory.EffectBlockGUI1Menu;
import net.mcreator.puzzle_code.procedures.EffectBlockGUIPagePowerEffectProcedure;
import net.mcreator.puzzle_code.procedures.EffectBlockGUIPageParticlesProcedure;
import net.mcreator.puzzle_code.procedures.EffectBlockGUIPageDurationEffectProcedure;
import net.mcreator.puzzle_code.procedures.EffectBlockGUIPageAmbientProcedure;
import net.mcreator.puzzle_code.procedures.EffectBlockGUIPage3Procedure;
import net.mcreator.puzzle_code.procedures.EffectBlockGUIPage2Procedure;
import net.mcreator.puzzle_code.procedures.EffectBlockGUIPage1Procedure;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EffectBlockGUI1ButtonMessage {
	private final int buttonID, x, y, z;

	public EffectBlockGUI1ButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public EffectBlockGUI1ButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(EffectBlockGUI1ButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(EffectBlockGUI1ButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = EffectBlockGUI1Menu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			EffectBlockGUIPagePowerEffectProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			EffectBlockGUIPageDurationEffectProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 2) {

			EffectBlockGUIPageAmbientProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			EffectBlockGUIPageParticlesProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			EffectBlockGUIPage1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			EffectBlockGUIPage2Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			EffectBlockGUIPage3Procedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PuzzleCodeMod.addNetworkMessage(EffectBlockGUI1ButtonMessage.class, EffectBlockGUI1ButtonMessage::buffer, EffectBlockGUI1ButtonMessage::new, EffectBlockGUI1ButtonMessage::handler);
	}
}
