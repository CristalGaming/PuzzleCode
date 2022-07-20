
/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.puzzle_code.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.effect.MobEffect;

import net.mcreator.puzzle_code.potion.YellowSwitcherEffectMobEffect;
import net.mcreator.puzzle_code.PuzzleCodeMod;

public class PuzzleCodeModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, PuzzleCodeMod.MODID);
	public static final RegistryObject<MobEffect> YELLOW_SWITCHER_EFFECT = REGISTRY.register("yellow_switcher_effect",
			() -> new YellowSwitcherEffectMobEffect());
}
