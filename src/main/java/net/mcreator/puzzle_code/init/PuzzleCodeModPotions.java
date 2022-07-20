
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.puzzle_code.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.item.alchemy.Potion;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.puzzle_code.PuzzleCodeMod;

public class PuzzleCodeModPotions {
	public static final DeferredRegister<Potion> REGISTRY = DeferredRegister.create(ForgeRegistries.POTIONS, PuzzleCodeMod.MODID);
	public static final RegistryObject<Potion> LEVITATION_POTION = REGISTRY.register("levitation_potion",
			() -> new Potion(new MobEffectInstance(MobEffects.LEVITATION, 3600, 0, false, true)));
	public static final RegistryObject<Potion> WITHER_POTION = REGISTRY.register("wither_potion",
			() -> new Potion(new MobEffectInstance(MobEffects.WITHER, 3600, 0, false, true)));
	public static final RegistryObject<Potion> YELLOW_SWITCHER_POTION_ITEM = REGISTRY.register("yellow_switcher_potion_item",
			() -> new Potion(new MobEffectInstance(PuzzleCodeModMobEffects.YELLOW_SWITCHER_EFFECT.get(), 2400, 0, false, true)));
}
