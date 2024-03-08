
package net.mcreator.puzzle_code.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.puzzle_code.world.inventory.CreativeSettingsGUIMenu;
import net.mcreator.puzzle_code.procedures.TimeSetNightCreativeItemProcedure;
import net.mcreator.puzzle_code.procedures.TimeSetDayCreativeItemProcedure;
import net.mcreator.puzzle_code.procedures.SpawnpointCreativeItemProcedure;
import net.mcreator.puzzle_code.procedures.ResetHungerCreativeItemProcedure;
import net.mcreator.puzzle_code.procedures.ResetHPCreativeItemProcedure;
import net.mcreator.puzzle_code.procedures.PlaceAFakeBlockProcedure;
import net.mcreator.puzzle_code.procedures.OpenCreativeSettingsGuiCreativeItemsProcedure;
import net.mcreator.puzzle_code.procedures.OpenCreativeSettingsGUIGamerulesProcedure;
import net.mcreator.puzzle_code.procedures.GamemodeSurvivalCreativeItemProcedure;
import net.mcreator.puzzle_code.procedures.GamemodeSpectatorCreativeItemProcedure;
import net.mcreator.puzzle_code.procedures.GamemodeCreativeCreativeItemProcedure;
import net.mcreator.puzzle_code.procedures.CleanEffectsCreativeItemProcedure;
import net.mcreator.puzzle_code.procedures.BlocksAffectsYouSwichProcedure;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreativeSettingsGUIButtonMessage {
	private final int buttonID, x, y, z;

	public CreativeSettingsGUIButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public CreativeSettingsGUIButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(CreativeSettingsGUIButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(CreativeSettingsGUIButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = CreativeSettingsGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			BlocksAffectsYouSwichProcedure.execute(world);
		}
		if (buttonID == 1) {

			PlaceAFakeBlockProcedure.execute(world, x, y, z);
		}
		if (buttonID == 2) {

			TimeSetDayCreativeItemProcedure.execute(world);
		}
		if (buttonID == 3) {

			CleanEffectsCreativeItemProcedure.execute(entity);
		}
		if (buttonID == 4) {

			ResetHPCreativeItemProcedure.execute(entity);
		}
		if (buttonID == 5) {

			ResetHungerCreativeItemProcedure.execute(entity);
		}
		if (buttonID == 6) {

			TimeSetNightCreativeItemProcedure.execute(world);
		}
		if (buttonID == 7) {

			GamemodeCreativeCreativeItemProcedure.execute(entity);
		}
		if (buttonID == 8) {

			GamemodeSurvivalCreativeItemProcedure.execute(entity);
		}
		if (buttonID == 9) {

			GamemodeSpectatorCreativeItemProcedure.execute(entity);
		}
		if (buttonID == 10) {

			SpawnpointCreativeItemProcedure.execute(x, y, z, entity);
		}
		if (buttonID == 11) {

			OpenCreativeSettingsGuiCreativeItemsProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 12) {

			OpenCreativeSettingsGUIGamerulesProcedure.execute(world, x, y, z, entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PuzzleCodeMod.addNetworkMessage(CreativeSettingsGUIButtonMessage.class, CreativeSettingsGUIButtonMessage::buffer, CreativeSettingsGUIButtonMessage::new, CreativeSettingsGUIButtonMessage::handler);
	}
}
