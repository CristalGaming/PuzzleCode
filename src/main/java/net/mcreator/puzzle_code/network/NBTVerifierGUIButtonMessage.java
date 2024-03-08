
package net.mcreator.puzzle_code.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.puzzle_code.world.inventory.NBTVerifierGUIMenu;
import net.mcreator.puzzle_code.procedures.ApplyNBTVerifierVariableTypeTextVarProcedure;
import net.mcreator.puzzle_code.procedures.ApplyNBTVerifierVariableTypeNumberVarProcedure;
import net.mcreator.puzzle_code.procedures.ApplyNBTVerifierVariableTypeLogicVarProcedure;
import net.mcreator.puzzle_code.procedures.ApplyNBTVerifierVarProcedure;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class NBTVerifierGUIButtonMessage {
	private final int buttonID, x, y, z;

	public NBTVerifierGUIButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public NBTVerifierGUIButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(NBTVerifierGUIButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(NBTVerifierGUIButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = NBTVerifierGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			ApplyNBTVerifierVariableTypeNumberVarProcedure.execute(entity);
		}
		if (buttonID == 1) {

			ApplyNBTVerifierVariableTypeLogicVarProcedure.execute(entity);
		}
		if (buttonID == 2) {

			ApplyNBTVerifierVariableTypeTextVarProcedure.execute(entity);
		}
		if (buttonID == 3) {

			ApplyNBTVerifierVarProcedure.execute(entity, guistate);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PuzzleCodeMod.addNetworkMessage(NBTVerifierGUIButtonMessage.class, NBTVerifierGUIButtonMessage::buffer, NBTVerifierGUIButtonMessage::new, NBTVerifierGUIButtonMessage::handler);
	}
}
