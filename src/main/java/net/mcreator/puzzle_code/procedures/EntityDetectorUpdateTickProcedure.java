package net.mcreator.puzzle_code.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

public class EntityDetectorUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double sx = 0;
		double sy = 0;
		double sz = 0;
		sx = -1;
		for (int index0 = 0; index0 < 3; index0++) {
			sy = -1;
			for (int index1 = 0; index1 < 3; index1++) {
				sz = -1;
				for (int index2 = 0; index2 < 3; index2++) {
					if (world instanceof Level _level)
						_level.updateNeighborsAt(BlockPos.containing(x + sx, y + sy, z + sz), _level.getBlockState(BlockPos.containing(x + sx, y + sy, z + sz)).getBlock());
					sz = sz + 1;
				}
				sy = sy + 1;
			}
			sx = sx + 1;
		}
	}
}
