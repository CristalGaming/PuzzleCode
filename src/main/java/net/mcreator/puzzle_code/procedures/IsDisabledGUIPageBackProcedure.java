package net.mcreator.puzzle_code.procedures;

import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.puzzle_code.world.inventory.EffectBlockGUI3Menu;
import net.mcreator.puzzle_code.world.inventory.CommandCodeBlockGUIMenu;
import net.mcreator.puzzle_code.world.inventory.CheckpointBlockGUI2Menu;
import net.mcreator.puzzle_code.init.PuzzleCodeModBlocks;

import io.netty.buffer.Unpooled;

public class IsDisabledGUIPageBackProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((new ItemStack((world.getBlockState(BlockPos.containing(x, y, z))).getBlock())).is(ItemTags.create(new ResourceLocation("puzzle_code:effect_blocks")))) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("EffectBlockGUI3");
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new EffectBlockGUI3Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((new ItemStack((world.getBlockState(BlockPos.containing(x, y, z))).getBlock())).is(ItemTags.create(new ResourceLocation("puzzle_code:checkpoint_blocks")))) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("CheckpointBlockGUI2");
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new CheckpointBlockGUI2Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PuzzleCodeModBlocks.COMMAND_CODE_BLOCK.get()) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("CommandCodeBlockGUI");
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new CommandCodeBlockGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
	}
}
