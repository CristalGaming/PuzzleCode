package net.mcreator.puzzle_code.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.puzzle_code.init.PuzzleCodeModBlocks;

public class BoxEntityWalksOnTheBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		world.setBlock(BlockPos.containing((entity.getDirection()).getStepX() + x, (entity.getDirection()).getStepY() + y, (entity.getDirection()).getStepZ() + z), PuzzleCodeModBlocks.BOX.get().defaultBlockState(), 3);
		world.setBlock(BlockPos.containing(x, y, z), Blocks.AIR.defaultBlockState(), 3);
	}
}
