package net.mcreator.puzzle_code.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;

import net.mcreator.puzzle_code.init.PuzzleCodeModGameRules;

public class BlocksAffectsYouSwichProcedure {
	public static void execute(LevelAccessor world) {
		if (world.getLevelData().getGameRules().getBoolean(PuzzleCodeModGameRules.BLOCKSAFFECTSYOU) == true) {
			if (world instanceof Level _level)
				_level.getGameRules().getRule(PuzzleCodeModGameRules.BLOCKSAFFECTSYOU).set((false), _level.getServer());
		} else {
			if (world instanceof Level _level)
				_level.getGameRules().getRule(PuzzleCodeModGameRules.BLOCKSAFFECTSYOU).set((true), _level.getServer());
		}
	}
}
