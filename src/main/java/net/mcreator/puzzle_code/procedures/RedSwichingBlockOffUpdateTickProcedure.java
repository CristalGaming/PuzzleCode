package net.mcreator.puzzle_code.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.puzzle_code.network.PuzzleCodeModVariables;
import net.mcreator.puzzle_code.init.PuzzleCodeModBlocks;

public class RedSwichingBlockOffUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (PuzzleCodeModVariables.MapVariables.get(world).IsSwitchedBlue == false) {
			world.setBlock(new BlockPos(x, y, z), PuzzleCodeModBlocks.RED_SWITCHING_BLOCK.get().defaultBlockState(), 3);
		}
	}
}
