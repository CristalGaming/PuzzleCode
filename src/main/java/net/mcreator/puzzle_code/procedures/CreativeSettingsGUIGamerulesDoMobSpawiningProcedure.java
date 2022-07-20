package net.mcreator.puzzle_code.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameRules;

public class CreativeSettingsGUIGamerulesDoMobSpawiningProcedure {
	public static boolean execute(LevelAccessor world) {
		if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_DOMOBSPAWNING)) {
			return true;
		}
		return false;
	}
}
