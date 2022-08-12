
package net.mcreator.puzzle_code.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.puzzle_code.world.inventory.InEffectBlockGUI1Menu;
import net.mcreator.puzzle_code.procedures.InEffectBlockPage4Procedure;
import net.mcreator.puzzle_code.procedures.InEffectBlockPage3Procedure;
import net.mcreator.puzzle_code.procedures.InEffectBlockPage2Procedure;
import net.mcreator.puzzle_code.procedures.EffectBlockGUIPage5Procedure;
import net.mcreator.puzzle_code.procedures.EditPowerEffectProcedure;
import net.mcreator.puzzle_code.procedures.EditDurationEffectProcedure;
import net.mcreator.puzzle_code.procedures.ApplyPowerEffectProcedure;
import net.mcreator.puzzle_code.procedures.ApplyDurationEffectProcedure;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class InEffectBlockGUI1ButtonMessage {
	private final int buttonID, x, y, z;

	public InEffectBlockGUI1ButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public InEffectBlockGUI1ButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(InEffectBlockGUI1ButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(InEffectBlockGUI1ButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = InEffectBlockGUI1Menu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			ApplyPowerEffectProcedure.execute(world, x, y, z, guistate);
		}
		if (buttonID == 1) {

			ApplyDurationEffectProcedure.execute(world, x, y, z, guistate);
		}
		if (buttonID == 2) {

			InEffectBlockPage2Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 3) {

			EditPowerEffectProcedure.execute(world, x, y, z, guistate);
		}
		if (buttonID == 4) {

			EditDurationEffectProcedure.execute(world, x, y, z, guistate);
		}
		if (buttonID == 5) {

			InEffectBlockPage3Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			InEffectBlockPage4Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			EffectBlockGUIPage5Procedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PuzzleCodeMod.addNetworkMessage(InEffectBlockGUI1ButtonMessage.class, InEffectBlockGUI1ButtonMessage::buffer,
				InEffectBlockGUI1ButtonMessage::new, InEffectBlockGUI1ButtonMessage::handler);
	}
}
