package net.mcreator.puzzle_code.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.puzzle_code.init.PuzzleCodeModBlocks;

public class MovingBlockOnBlockRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((world.getBlockState(BlockPos.containing(x + (entity.getDirection()).getStepX(), y, z + (entity.getDirection()).getStepZ()))).getBlock() == Blocks.AIR) {
			world.setBlock(BlockPos.containing(x + (entity.getDirection()).getStepX(), y, z + (entity.getDirection()).getStepZ()), PuzzleCodeModBlocks.MOVING_BLOCK.get().defaultBlockState(), 3);
			world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
		}
	}
}
