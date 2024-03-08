
package net.mcreator.puzzle_code.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.puzzle_code.world.inventory.EffectBlockGUI3Menu;
import net.mcreator.puzzle_code.procedures.EffectBlockGUIPage3SettingsProcedure;
import net.mcreator.puzzle_code.procedures.EffectBlockGUIPage3Procedure;
import net.mcreator.puzzle_code.procedures.EffectBlockGUIPage3Button5Procedure;
import net.mcreator.puzzle_code.procedures.EffectBlockGUIPage3Button4Procedure;
import net.mcreator.puzzle_code.procedures.EffectBlockGUIPage3Button3Procedure;
import net.mcreator.puzzle_code.procedures.EffectBlockGUIPage3Button2Procedure;
import net.mcreator.puzzle_code.procedures.EffectBlockGUIPage3Button1Procedure;
import net.mcreator.puzzle_code.procedures.EffectBlockGUIPage2Procedure;
import net.mcreator.puzzle_code.procedures.EffectBlockGUIPage1Procedure;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class EffectBlockGUI3ButtonMessage {
	private final int buttonID, x, y, z;

	public EffectBlockGUI3ButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public EffectBlockGUI3ButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(EffectBlockGUI3ButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(EffectBlockGUI3ButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = EffectBlockGUI3Menu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			EffectBlockGUIPage3Button1Procedure.execute(world, x, y, z);
		}
		if (buttonID == 1) {

			EffectBlockGUIPage3Button2Procedure.execute(world, x, y, z);
		}
		if (buttonID == 2) {

			EffectBlockGUIPage3Button3Procedure.execute(world, x, y, z);
		}
		if (buttonID == 3) {

			EffectBlockGUIPage3Button4Procedure.execute(world, x, y, z);
		}
		if (buttonID == 4) {

			EffectBlockGUIPage3Button5Procedure.execute(world, x, y, z);
		}
		if (buttonID == 5) {

			EffectBlockGUIPage3SettingsProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 6) {

			EffectBlockGUIPage1Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 7) {

			EffectBlockGUIPage2Procedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 8) {

			EffectBlockGUIPage3Procedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PuzzleCodeMod.addNetworkMessage(EffectBlockGUI3ButtonMessage.class, EffectBlockGUI3ButtonMessage::buffer, EffectBlockGUI3ButtonMessage::new, EffectBlockGUI3ButtonMessage::handler);
	}
}
