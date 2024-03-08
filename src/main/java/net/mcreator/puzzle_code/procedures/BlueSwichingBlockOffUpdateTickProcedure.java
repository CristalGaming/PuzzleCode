package net.mcreator.puzzle_code.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

import net.mcreator.puzzle_code.network.PuzzleCodeModVariables;
import net.mcreator.puzzle_code.init.PuzzleCodeModBlocks;

public class BlueSwichingBlockOffUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (PuzzleCodeModVariables.MapVariables.get(world).IsSwitchedBlue == true) {
			world.setBlock(BlockPos.containing(x, y, z), PuzzleCodeModBlocks.BLUE_SWITCHING_BLOCK.get().defaultBlockState(), 3);
		}
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null)
				_blockEntity.getPersistentData().putBoolean("isSwitchedBlue", PuzzleCodeModVariables.MapVariables.get(world).IsSwitchedBlue);
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null)
				_blockEntity.getPersistentData().putBoolean("isSwitchedRed", (!PuzzleCodeModVariables.MapVariables.get(world).IsSwitchedBlue));
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null)
				_blockEntity.getPersistentData().putBoolean("isSwitchedOn", PuzzleCodeModVariables.MapVariables.get(world).IsSwitchedBlue);
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
	}
}
