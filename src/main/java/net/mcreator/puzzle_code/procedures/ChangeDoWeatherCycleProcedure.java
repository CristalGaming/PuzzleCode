package net.mcreator.puzzle_code.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameRules;

public class ChangeDoWeatherCycleProcedure {
	public static void execute(LevelAccessor world) {
		world.getLevelData().getGameRules().getRule(GameRules.RULE_WEATHER_CYCLE).set((!world.getLevelData().getGameRules().getBoolean(GameRules.RULE_WEATHER_CYCLE)), world.getServer());
	}
}
