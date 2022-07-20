package net.mcreator.puzzle_code.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.puzzle_code.network.PuzzleCodeModVariables;
import net.mcreator.puzzle_code.init.PuzzleCodeModBlocks;

public class RedSwichingBlockUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (PuzzleCodeModVariables.MapVariables.get(world).IsSwitchedBlue == true) {
			world.setBlock(new BlockPos(x, y, z), PuzzleCodeModBlocks.RED_SWITCHING_BLOCK_OFF.get().defaultBlockState(), 3);
		}
	}
}
