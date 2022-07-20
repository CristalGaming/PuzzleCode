package net.mcreator.puzzle_code.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameRules;

public class CreativeSettingsGUIGamerulesDoWeatherCycleProcedure {
	public static boolean execute(LevelAccessor world) {
		if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_WEATHER_CYCLE)) {
			return true;
		}
		return false;
	}
}
