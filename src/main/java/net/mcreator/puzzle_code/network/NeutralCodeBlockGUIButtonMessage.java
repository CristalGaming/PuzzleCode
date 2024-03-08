
package net.mcreator.puzzle_code.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.puzzle_code.world.inventory.NeutralCodeBlockGUIMenu;
import net.mcreator.puzzle_code.procedures.NBTTypeTextButtonProcedure;
import net.mcreator.puzzle_code.procedures.NBTTypeNumberButtonProcedure;
import net.mcreator.puzzle_code.procedures.NBTTypeLogicButtonProcedure;
import net.mcreator.puzzle_code.procedures.EditNBTValueProcedure;
import net.mcreator.puzzle_code.procedures.EditNBTNameProcedure;
import net.mcreator.puzzle_code.procedures.ApplyNBTValueProcedure;
import net.mcreator.puzzle_code.procedures.ApplyNBTNameProcedure;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class NeutralCodeBlockGUIButtonMessage {
	private final int buttonID, x, y, z;

	public NeutralCodeBlockGUIButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public NeutralCodeBlockGUIButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(NeutralCodeBlockGUIButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(NeutralCodeBlockGUIButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = NeutralCodeBlockGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			NBTTypeNumberButtonProcedure.execute(world, x, y, z);
		}
		if (buttonID == 1) {

			NBTTypeLogicButtonProcedure.execute(world, x, y, z);
		}
		if (buttonID == 2) {

			NBTTypeTextButtonProcedure.execute(world, x, y, z);
		}
		if (buttonID == 3) {

			EditNBTNameProcedure.execute(world, x, y, z, guistate);
		}
		if (buttonID == 4) {

			ApplyNBTNameProcedure.execute(world, x, y, z, guistate);
		}
		if (buttonID == 5) {

			EditNBTValueProcedure.execute(world, x, y, z, guistate);
		}
		if (buttonID == 6) {

			ApplyNBTValueProcedure.execute(world, x, y, z, guistate);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PuzzleCodeMod.addNetworkMessage(NeutralCodeBlockGUIButtonMessage.class, NeutralCodeBlockGUIButtonMessage::buffer, NeutralCodeBlockGUIButtonMessage::new, NeutralCodeBlockGUIButtonMessage::handler);
	}
}
