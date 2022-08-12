package net.mcreator.puzzle_code.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.puzzle_code.network.PuzzleCodeModVariables;

public class BlueSwitchingItemRightclickedProcedure {
	public static void execute(LevelAccessor world) {
		PuzzleCodeModVariables.MapVariables.get(world).IsSwitchedBlue = true;
		PuzzleCodeModVariables.MapVariables.get(world).syncData(world);
	}
}
