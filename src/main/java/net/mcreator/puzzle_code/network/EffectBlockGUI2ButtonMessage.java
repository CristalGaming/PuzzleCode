
package net.mcreator.puzzle_code.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.puzzle_code.world.inventory.EffectBlockGUI2Menu;
import net.mcreator.puzzle_code.procedures.EffectBlockGUIPage3Procedure;
import net.mcreator.puzzle_code.procedures.EffectBlockGUIPage2SettingsProcedure;
import net.mcreator.puzzle_code.procedures.EffectBlockGUIPage2Procedure;
import net.mcreator.puzzle_code.procedures.EffectBlockGUIPage2DisplayPositionButtonProcedure;
import net.mcreator.puzzle_code.procedures.EffectBlockGUIPage2Button3Procedure;
import net.mcreator.puzzle_code.procedures.EffectBlockGUIPage2Button2Procedure;
import net.mcreator.puzzle_code.procedures.EffectBlockGUIPage2Button1Procedure;
import net.mcreator.puzzle_code.procedures.EffectBlockGUIPage1Procedure;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EffectBlockGUI2ButtonMessage {
	private final int buttonID, x, y, z;

	public EffectBlockGUI2ButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public EffectBlockGUI2ButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(EffectBlockGUI2ButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(EffectBlockGUI2ButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = EffectBlockGUI2Menu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			EffectBlockGUIPage2Button1Procedure.execute(world, x, y, z);
		}
		if (buttonID == 1) {

			EffectBlockGUIPage2Button2Procedure.execute(world, x, y, z);
		}
		if (buttonID == 2) {

			EffectBlockGUIPage2Button3Procedure.execute(world, x, y, z);
		}
		if (buttonID == 3) {

			EffectBlockGUIPage2SettingsProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			EffectBlockGUIPage2DisplayPositionButtonProcedure.execute(world, x, y, z);
		}
		if (buttonID == 5) {

			EffectBlockGUIPage1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			EffectBlockGUIPage3Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			EffectBlockGUIPage2Procedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PuzzleCodeMod.addNetworkMessage(EffectBlockGUI2ButtonMessage.class, EffectBlockGUI2ButtonMessage::buffer, EffectBlockGUI2ButtonMessage::new, EffectBlockGUI2ButtonMessage::handler);
	}
}
