package net.mcreator.puzzle_code.procedures;

import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.InteractionResult;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.puzzle_code.world.inventory.TransferItemCodeBlockGUIMenu;
import net.mcreator.puzzle_code.init.PuzzleCodeModItems;

import io.netty.buffer.Unpooled;

public class TransferItemCodeBlockOnBlockRightClickedProcedure {
	public static InteractionResult execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return InteractionResult.PASS;
		if ((entity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == PuzzleCodeModItems.GUI_SET.get()) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("TransferItemCodeBlockGUI");
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new TransferItemCodeBlockGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
			return InteractionResult.SUCCESS;
		}
		return InteractionResult.PASS;
	}
}
