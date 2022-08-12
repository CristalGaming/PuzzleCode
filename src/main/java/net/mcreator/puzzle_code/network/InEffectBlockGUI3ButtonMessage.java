
package net.mcreator.puzzle_code.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.puzzle_code.world.inventory.InEffectBlockGUI3Menu;
import net.mcreator.puzzle_code.procedures.SetRedstoneReactTrueProcedure;
import net.mcreator.puzzle_code.procedures.SetRedstoneReactFalseProcedure;
import net.mcreator.puzzle_code.procedures.SetRedstoneContinuouslyTrueProcedure;
import net.mcreator.puzzle_code.procedures.SetRedstoneContinuouslyFalseProcedure;
import net.mcreator.puzzle_code.procedures.InEffectBlockPage5Procedure;
import net.mcreator.puzzle_code.procedures.InEffectBlockPage4Procedure;
import net.mcreator.puzzle_code.procedures.InEffectBlockPage2Procedure;
import net.mcreator.puzzle_code.procedures.InEffectBlockPage1Procedure;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class InEffectBlockGUI3ButtonMessage {
	private final int buttonID, x, y, z;

	public InEffectBlockGUI3ButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public InEffectBlockGUI3ButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(InEffectBlockGUI3ButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(InEffectBlockGUI3ButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = InEffectBlockGUI3Menu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			SetRedstoneReactTrueProcedure.execute(world, x, y, z);
		}
		if (buttonID == 1) {

			SetRedstoneReactFalseProcedure.execute(world, x, y, z);
		}
		if (buttonID == 2) {

			InEffectBlockPage1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			InEffectBlockPage2Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			InEffectBlockPage4Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 5) {

			InEffectBlockPage5Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			SetRedstoneContinuouslyTrueProcedure.execute(world, x, y, z);
		}
		if (buttonID == 7) {

			SetRedstoneContinuouslyFalseProcedure.execute(world, x, y, z);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PuzzleCodeMod.addNetworkMessage(InEffectBlockGUI3ButtonMessage.class, InEffectBlockGUI3ButtonMessage::buffer,
				InEffectBlockGUI3ButtonMessage::new, InEffectBlockGUI3ButtonMessage::handler);
	}
}
