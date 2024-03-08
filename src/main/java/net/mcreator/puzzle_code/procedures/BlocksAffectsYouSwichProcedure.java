package net.mcreator.puzzle_code.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.puzzle_code.init.PuzzleCodeModGameRules;

public class BlocksAffectsYouSwichProcedure {
	public static void execute(LevelAccessor world) {
		if (world.getLevelData().getGameRules().getBoolean(PuzzleCodeModGameRules.BLOCKSAFFECTSYOU) == true) {
			world.getLevelData().getGameRules().getRule(PuzzleCodeModGameRules.BLOCKSAFFECTSYOU).set(false, world.getServer());
		} else {
			world.getLevelData().getGameRules().getRule(PuzzleCodeModGameRules.BLOCKSAFFECTSYOU).set(true, world.getServer());
		}
	}
}
