package net.mcreator.puzzle_code.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.puzzle_code.network.PuzzleCodeModVariables;

public class SwicherBlockRedRedstoneOnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!(new Object() {
			public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getBoolean(tag);
				return false;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "swichingDelay"))) {
			PuzzleCodeModVariables.MapVariables.get(world).IsSwitchedBlue = true;
			PuzzleCodeModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
