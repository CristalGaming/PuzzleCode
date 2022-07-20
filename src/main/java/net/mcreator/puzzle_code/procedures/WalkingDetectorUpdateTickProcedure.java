package net.mcreator.puzzle_code.procedures;

import net.minecraft.world.level.LevelAccessor;

public class WalkingDetectorUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		EntityDetectorUpdateTickProcedure.execute(world, x, y, z);
	}
}
