package net.mcreator.puzzle_code.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameRules;

public class CreativeSettingsGUIGamerulesDoDaylightCyclesProcedure {
	public static boolean execute(LevelAccessor world) {
		if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_DAYLIGHT)) {
			return true;
		}
		return false;
	}
}
