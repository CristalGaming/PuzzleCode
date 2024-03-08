package net.mcreator.puzzle_code.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.puzzle_code.network.PuzzleCodeModVariables;
import net.mcreator.puzzle_code.init.PuzzleCodeModMobEffects;

import java.util.ArrayList;

public class YellowSwicherPotionPotionExpiresProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		boolean disableEffect = false;
		disableEffect = true;
		for (Entity entityiterator : new ArrayList<>(world.players())) {
			if (entityiterator instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(PuzzleCodeModMobEffects.YELLOW_SWITCHER_EFFECT.get())) {
				disableEffect = false;
			}
		}
		if (disableEffect) {
			{
				boolean _setval = false;
				entity.getCapability(PuzzleCodeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.IsSwitchedYellow = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				double _setval = 0;
				entity.getCapability(PuzzleCodeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.YellowSwitcherEffectPower = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
