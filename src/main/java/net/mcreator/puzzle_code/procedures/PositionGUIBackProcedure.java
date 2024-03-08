package net.mcreator.puzzle_code.procedures;

import net.minecraftforge.network.NetworkHooks;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.MenuProvider;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.puzzle_code.world.inventory.TeleporterTextCodeBlockGUIMenu;
import net.mcreator.puzzle_code.world.inventory.TeleporterNumberCodeBlockGUIMenu;
import net.mcreator.puzzle_code.world.inventory.TeleporterLogicCodeBlockGUIMenu;
import net.mcreator.puzzle_code.world.inventory.TeleporterItemCodeBlockGUI1Menu;
import net.mcreator.puzzle_code.world.inventory.ImitatorTextCodeBlockGUIMenu;
import net.mcreator.puzzle_code.world.inventory.ImitatorNumberCodeBlockGUIMenu;
import net.mcreator.puzzle_code.world.inventory.ImitatorLogicCodeBlockGUIMenu;
import net.mcreator.puzzle_code.world.inventory.ImitatorItemCodeBlockGUIMenu;
import net.mcreator.puzzle_code.world.inventory.ImitatorDirectionCodeBlockGUIMenu;
import net.mcreator.puzzle_code.init.PuzzleCodeModBlocks;

import io.netty.buffer.Unpooled;

public class PositionGUIBackProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PuzzleCodeModBlocks.IMITATOR_NUMBER_CODE_BLOCK.get()) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("ImitatorNumberCodeBlockGUI");
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new ImitatorNumberCodeBlockGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PuzzleCodeModBlocks.IMITATOR_LOGIC_CODE_BLOCK.get()) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("ImitatorLogicCodeBlockGUI");
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new ImitatorLogicCodeBlockGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PuzzleCodeModBlocks.IMITATOR_TEXT_CODE_BLOCK.get()) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("ImitatorTextCodeBlockGUI");
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new ImitatorTextCodeBlockGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PuzzleCodeModBlocks.IMITATOR_ITEM_CODE_BLOCK.get()) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("ImitatorItemCodeBlockGUI");
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new ImitatorItemCodeBlockGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PuzzleCodeModBlocks.IMITATOR_DIRECTION_CODE_BLOCK.get()) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("ImitatorDirectionCodeBlockGUI");
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new ImitatorDirectionCodeBlockGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PuzzleCodeModBlocks.TELEPORTER_NUMBER_CODE_BLOCK.get()) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("TeleporterNumberCodeBlockGUI");
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new TeleporterNumberCodeBlockGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PuzzleCodeModBlocks.TELEPORTER_LOGIC_CODE_BLOCK.get()) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("TeleporterLogicCodeBlockGUI");
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new TeleporterLogicCodeBlockGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PuzzleCodeModBlocks.TELEPORTER_TEXT_CODE_BLOCK.get()) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("TeleporterTextCodeBlockGUI");
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new TeleporterTextCodeBlockGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PuzzleCodeModBlocks.TELEPORTER_ITEM_CODE_BLOCK.get()) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("TeleporterItemCodeBlockGUI1");
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new TeleporterItemCodeBlockGUI1Menu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
		if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == PuzzleCodeModBlocks.TELEPORTER_DIRECTION_CODE_BLOCK.get()) {
			if (entity instanceof ServerPlayer _ent) {
				BlockPos _bpos = BlockPos.containing(x, y, z);
				NetworkHooks.openScreen((ServerPlayer) _ent, new MenuProvider() {
					@Override
					public Component getDisplayName() {
						return Component.literal("TeleporterNumberCodeBlockGUI");
					}

					@Override
					public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
						return new TeleporterNumberCodeBlockGUIMenu(id, inventory, new FriendlyByteBuf(Unpooled.buffer()).writeBlockPos(_bpos));
					}
				}, _bpos);
			}
		}
	}
}
