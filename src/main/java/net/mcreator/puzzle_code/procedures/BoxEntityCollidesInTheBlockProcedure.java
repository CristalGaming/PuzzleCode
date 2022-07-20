package net.mcreator.puzzle_code.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.puzzle_code.init.PuzzleCodeModBlocks;

public class BoxEntityCollidesInTheBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((world.getBlockState(new BlockPos((entity.getDirection()).getStepX() + x, y, (entity.getDirection()).getStepZ() + z)))
				.getBlock() == Blocks.AIR) {
			world.setBlock(new BlockPos((entity.getDirection()).getStepX() + x, y, (entity.getDirection()).getStepZ() + z),
					PuzzleCodeModBlocks.BOX.get().defaultBlockState(), 3);
			world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
		}
	}
}
