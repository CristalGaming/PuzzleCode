
package net.mcreator.puzzle_code.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.puzzle_code.world.inventory.InEffectBlockGUI2Menu;
import net.mcreator.puzzle_code.procedures.SetParticlesTrueProcedure;
import net.mcreator.puzzle_code.procedures.SetParticlesFalseProcedure;
import net.mcreator.puzzle_code.procedures.SetAmbientTrueProcedure;
import net.mcreator.puzzle_code.procedures.SetAmbientFalseProcedure;
import net.mcreator.puzzle_code.procedures.InEffectBlockPage5Procedure;
import net.mcreator.puzzle_code.procedures.InEffectBlockPage4Procedure;
import net.mcreator.puzzle_code.procedures.InEffectBlockPage3Procedure;
import net.mcreator.puzzle_code.procedures.InEffectBlockPage1Procedure;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class InEffectBlockGUI2ButtonMessage {
	private final int buttonID, x, y, z;

	public InEffectBlockGUI2ButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public InEffectBlockGUI2ButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(InEffectBlockGUI2ButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(InEffectBlockGUI2ButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = InEffectBlockGUI2Menu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			InEffectBlockPage1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			SetAmbientTrueProcedure.execute(world, x, y, z);
		}
		if (buttonID == 2) {

			SetAmbientFalseProcedure.execute(world, x, y, z);
		}
		if (buttonID == 3) {

			SetParticlesTrueProcedure.execute(world, x, y, z);
		}
		if (buttonID == 4) {

			SetParticlesFalseProcedure.execute(world, x, y, z);
		}
		if (buttonID == 5) {

			InEffectBlockPage3Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			InEffectBlockPage4Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			InEffectBlockPage5Procedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PuzzleCodeMod.addNetworkMessage(InEffectBlockGUI2ButtonMessage.class, InEffectBlockGUI2ButtonMessage::buffer,
				InEffectBlockGUI2ButtonMessage::new, InEffectBlockGUI2ButtonMessage::handler);
	}
}
