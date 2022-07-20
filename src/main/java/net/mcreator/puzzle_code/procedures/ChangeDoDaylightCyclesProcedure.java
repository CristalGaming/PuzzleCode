package net.mcreator.puzzle_code.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.GameRules;

public class ChangeDoDaylightCyclesProcedure {
	public static void execute(LevelAccessor world) {
		if (world instanceof Level _level)
			_level.getGameRules().getRule(GameRules.RULE_DAYLIGHT).set((!world.getLevelData().getGameRules().getBoolean(GameRules.RULE_DAYLIGHT)),
					_level.getServer());
	}
}
