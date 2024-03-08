package net.mcreator.puzzle_code.procedures;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.puzzle_code.network.PuzzleCodeModVariables;
import net.mcreator.puzzle_code.init.PuzzleCodeModMobEffects;

public class YellowSwicherPotionPotionStartedappliedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Player) {
			{
				double _setval = entity instanceof LivingEntity _livEnt && _livEnt.hasEffect(PuzzleCodeModMobEffects.YELLOW_SWITCHER_EFFECT.get()) ? _livEnt.getEffect(PuzzleCodeModMobEffects.YELLOW_SWITCHER_EFFECT.get()).getAmplifier() : 0;
				entity.getCapability(PuzzleCodeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.YellowSwitcherEffectPower = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
			{
				boolean _setval = true;
				entity.getCapability(PuzzleCodeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.IsSwitchedYellow = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
	}
}
