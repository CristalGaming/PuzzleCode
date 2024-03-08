package net.mcreator.puzzle_code.procedures;

import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.block.entity.BlockEntity;
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
import net.mcreator.puzzle_code.world.inventory.CreativeSettingsGUIMenu;
import net.mcreator.puzzle_code.world.inventory.CheckpointBlockGUI2Menu;

import io.netty.buffer.Unpooled;

public class RangeGUIPageBackProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((new ItemStack((world.getBlockState(BlockPos.containing(x, y, z))).getBlock())).is(ItemTags.create(new ResourceLocation("puzzle_code:effect_blocks")))) {
			if (new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getDouble(tag);
					return -1;
				}
			}.getValue(world, BlockPos.containing(x, y, z), "page") == 2) {
				if (entity instanceof ServerPlayer _ent) {
					BlockPos _bpos = BlockPos.containing(x, y, z);
					NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
						@Override
						public Component getDisplayName() {
							return Component.literal("CreativeSettingsGUI");
						}

						@Override
						public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
							return new CreativeSettingsGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
						}
					}, _bpos);
				}
			} else {
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
	}
}
