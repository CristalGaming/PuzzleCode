package net.mcreator.puzzle_code.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.puzzle_code.init.PuzzleCodeModBlocks;

public class PlaceAFakeBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.setBlock(new BlockPos(x, y, z), PuzzleCodeModBlocks.FAKE_BLOCK.get().defaultBlockState(), 3);
	}
}
