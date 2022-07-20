
package net.mcreator.puzzle_code.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.puzzle_code.world.inventory.CreativeSettingsGUIGamerulesMenu;
import net.mcreator.puzzle_code.procedures.CreativeSettingsRightclickedProcedure;
import net.mcreator.puzzle_code.procedures.ChangeKeepInventoryProcedure;
import net.mcreator.puzzle_code.procedures.ChangeDoWeatherCycleProcedure;
import net.mcreator.puzzle_code.procedures.ChangeDoMobSpawiningProcedure;
import net.mcreator.puzzle_code.procedures.ChangeDoDaylightCyclesProcedure;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreativeSettingsGUIGamerulesButtonMessage {
	private final int buttonID, x, y, z;

	public CreativeSettingsGUIGamerulesButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public CreativeSettingsGUIGamerulesButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(CreativeSettingsGUIGamerulesButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(CreativeSettingsGUIGamerulesButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = CreativeSettingsGUIGamerulesMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			ChangeDoDaylightCyclesProcedure.execute(world);
		}
		if (buttonID == 1) {

			ChangeKeepInventoryProcedure.execute(world);
		}
		if (buttonID == 2) {

			ChangeDoMobSpawiningProcedure.execute(world);
		}
		if (buttonID == 3) {

			ChangeDoWeatherCycleProcedure.execute(world);
		}
		if (buttonID == 4) {

			CreativeSettingsRightclickedProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PuzzleCodeMod.addNetworkMessage(CreativeSettingsGUIGamerulesButtonMessage.class, CreativeSettingsGUIGamerulesButtonMessage::buffer,
				CreativeSettingsGUIGamerulesButtonMessage::new, CreativeSettingsGUIGamerulesButtonMessage::handler);
	}
}
