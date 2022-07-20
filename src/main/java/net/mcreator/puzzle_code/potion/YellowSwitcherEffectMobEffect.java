
package net.mcreator.puzzle_code.potion;

import net.minecraft.world.entity.ai.attributes.AttributeMap;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;

import net.mcreator.puzzle_code.procedures.YellowSwicherPotionPotionStartedappliedProcedure;
import net.mcreator.puzzle_code.procedures.YellowSwicherPotionPotionExpiresProcedure;

public class YellowSwitcherEffectMobEffect extends MobEffect {
	public YellowSwitcherEffectMobEffect() {
		super(MobEffectCategory.NEUTRAL, -3355648);
	}

	@Override
	public String getDescriptionId() {
		return "effect.puzzle_code.yellow_switcher_effect";
	}

	@Override
	public void addAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		YellowSwicherPotionPotionStartedappliedProcedure.execute(entity);
	}

	@Override
	public void removeAttributeModifiers(LivingEntity entity, AttributeMap attributeMap, int amplifier) {
		super.removeAttributeModifiers(entity, attributeMap, amplifier);
		YellowSwicherPotionPotionExpiresProcedure.execute(entity);
	}

	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return true;
	}
}
