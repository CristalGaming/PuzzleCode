
package net.mcreator.puzzle_code.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.puzzle_code.world.inventory.CreativeSettingsGUICreativeItemsMenu;
import net.mcreator.puzzle_code.procedures.GiveStructureVoidCreativeSettingsProcedure;
import net.mcreator.puzzle_code.procedures.GiveStructureBlockCreativeSettingsProcedure;
import net.mcreator.puzzle_code.procedures.GiveDebugStickCreativeSettingsProcedure;
import net.mcreator.puzzle_code.procedures.GiveCommandBlockMinecartCreativeSettingsProcedure;
import net.mcreator.puzzle_code.procedures.GiveCommandBlockCreativeSettingsProcedure;
import net.mcreator.puzzle_code.procedures.GiveBarrierCreativeSettingsProcedure;
import net.mcreator.puzzle_code.procedures.CreativeSettingsGUIRightClickProcedure;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CreativeSettingsGUICreativeItemsButtonMessage {
	private final int buttonID, x, y, z;

	public CreativeSettingsGUICreativeItemsButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public CreativeSettingsGUICreativeItemsButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(CreativeSettingsGUICreativeItemsButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(CreativeSettingsGUICreativeItemsButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = CreativeSettingsGUICreativeItemsMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			GiveCommandBlockCreativeSettingsProcedure.execute(entity);
		}
		if (buttonID == 1) {

			GiveBarrierCreativeSettingsProcedure.execute(entity);
		}
		if (buttonID == 2) {

			GiveCommandBlockMinecartCreativeSettingsProcedure.execute(entity);
		}
		if (buttonID == 3) {

			CreativeSettingsGUIRightClickProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 4) {

			GiveDebugStickCreativeSettingsProcedure.execute(entity);
		}
		if (buttonID == 5) {

			GiveStructureVoidCreativeSettingsProcedure.execute(entity);
		}
		if (buttonID == 6) {

			GiveStructureBlockCreativeSettingsProcedure.execute(entity);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PuzzleCodeMod.addNetworkMessage(CreativeSettingsGUICreativeItemsButtonMessage.class, CreativeSettingsGUICreativeItemsButtonMessage::buffer, CreativeSettingsGUICreativeItemsButtonMessage::new,
				CreativeSettingsGUICreativeItemsButtonMessage::handler);
	}
}
