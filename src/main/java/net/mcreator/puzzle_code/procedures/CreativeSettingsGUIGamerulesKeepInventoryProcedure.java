package net.mcreator.puzzle_code.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameRules;

public class CreativeSettingsGUIGamerulesKeepInventoryProcedure {
	public static boolean execute(LevelAccessor world) {
		if (world.getLevelData().getGameRules().getBoolean(GameRules.RULE_KEEPINVENTORY)) {
			return true;
		}
		return false;
	}
}
