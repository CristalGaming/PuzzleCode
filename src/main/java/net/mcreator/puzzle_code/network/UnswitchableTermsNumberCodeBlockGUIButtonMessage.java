
package net.mcreator.puzzle_code.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.puzzle_code.world.inventory.UnswitchableTermsNumberCodeBlockGUIMenu;
import net.mcreator.puzzle_code.procedures.SwitchIsDisabledProcedure;
import net.mcreator.puzzle_code.procedures.SetTerm2ToRightProcedure;
import net.mcreator.puzzle_code.procedures.SetTerm2ToLeftProcedure;
import net.mcreator.puzzle_code.procedures.SetTerm2ToBackProcedure;
import net.mcreator.puzzle_code.procedures.SetTerm1ToRightProcedure;
import net.mcreator.puzzle_code.procedures.SetTerm1ToLeftProcedure;
import net.mcreator.puzzle_code.procedures.SetTerm1ToBackProcedure;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class UnswitchableTermsNumberCodeBlockGUIButtonMessage {
	private final int buttonID, x, y, z;

	public UnswitchableTermsNumberCodeBlockGUIButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public UnswitchableTermsNumberCodeBlockGUIButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(UnswitchableTermsNumberCodeBlockGUIButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(UnswitchableTermsNumberCodeBlockGUIButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
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
		HashMap guistate = UnswitchableTermsNumberCodeBlockGUIMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			SetTerm1ToLeftProcedure.execute(world, x, y, z);
		}
		if (buttonID == 1) {

			SetTerm1ToBackProcedure.execute(world, x, y, z);
		}
		if (buttonID == 2) {

			SetTerm1ToRightProcedure.execute(world, x, y, z);
		}
		if (buttonID == 3) {

			SwitchIsDisabledProcedure.execute(world, x, y, z);
		}
		if (buttonID == 4) {

			SetTerm2ToLeftProcedure.execute(world, x, y, z);
		}
		if (buttonID == 5) {

			SetTerm2ToBackProcedure.execute(world, x, y, z);
		}
		if (buttonID == 6) {

			SetTerm2ToRightProcedure.execute(world, x, y, z);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		PuzzleCodeMod.addNetworkMessage(UnswitchableTermsNumberCodeBlockGUIButtonMessage.class,
				UnswitchableTermsNumberCodeBlockGUIButtonMessage::buffer, UnswitchableTermsNumberCodeBlockGUIButtonMessage::new,
				UnswitchableTermsNumberCodeBlockGUIButtonMessage::handler);
	}
}
