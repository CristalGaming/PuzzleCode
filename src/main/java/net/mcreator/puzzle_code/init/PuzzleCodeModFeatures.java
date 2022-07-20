
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.puzzle_code.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;

import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.Holder;

import net.mcreator.puzzle_code.world.features.ores.WitherEffectBlockFeature;
import net.mcreator.puzzle_code.world.features.ores.WaterBreathingEffectBlockFeature;
import net.mcreator.puzzle_code.world.features.ores.SpeedEffectBlockFeature;
import net.mcreator.puzzle_code.world.features.ores.PoisonEffectBlockFeature;
import net.mcreator.puzzle_code.world.features.ores.JumpBoostEffectBlockFeature;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import java.util.function.Supplier;
import java.util.Set;
import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber
public class PuzzleCodeModFeatures {
	public static final DeferredRegister<Feature<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.FEATURES, PuzzleCodeMod.MODID);
	private static final List<FeatureRegistration> FEATURE_REGISTRATIONS = new ArrayList<>();
	public static final RegistryObject<Feature<?>> JUMP_BOOST_EFFECT_BLOCK = register("jump_boost_effect_block", JumpBoostEffectBlockFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, JumpBoostEffectBlockFeature.GENERATE_BIOMES,
					JumpBoostEffectBlockFeature::placedFeature));
	public static final RegistryObject<Feature<?>> SPEED_EFFECT_BLOCK = register("speed_effect_block", SpeedEffectBlockFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, SpeedEffectBlockFeature.GENERATE_BIOMES,
					SpeedEffectBlockFeature::placedFeature));
	public static final RegistryObject<Feature<?>> POISON_EFFECT_BLOCK = register("poison_effect_block", PoisonEffectBlockFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, PoisonEffectBlockFeature.GENERATE_BIOMES,
					PoisonEffectBlockFeature::placedFeature));
	public static final RegistryObject<Feature<?>> WITHER_EFFECT_BLOCK = register("wither_effect_block", WitherEffectBlockFeature::feature,
			new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES, WitherEffectBlockFeature.GENERATE_BIOMES,
					WitherEffectBlockFeature::placedFeature));
	public static final RegistryObject<Feature<?>> WATER_BREATHING_EFFECT_BLOCK = register("water_breathing_effect_block",
			WaterBreathingEffectBlockFeature::feature, new FeatureRegistration(GenerationStep.Decoration.UNDERGROUND_ORES,
					WaterBreathingEffectBlockFeature.GENERATE_BIOMES, WaterBreathingEffectBlockFeature::placedFeature));

	private static RegistryObject<Feature<?>> register(String registryname, Supplier<Feature<?>> feature, FeatureRegistration featureRegistration) {
		FEATURE_REGISTRATIONS.add(featureRegistration);
		return REGISTRY.register(registryname, feature);
	}

	@SubscribeEvent
	public static void addFeaturesToBiomes(BiomeLoadingEvent event) {
		for (FeatureRegistration registration : FEATURE_REGISTRATIONS) {
			if (registration.biomes() == null || registration.biomes().contains(event.getName()))
				event.getGeneration().getFeatures(registration.stage()).add(registration.placedFeature().get());
		}
	}

	private static record FeatureRegistration(GenerationStep.Decoration stage, Set<ResourceLocation> biomes,
			Supplier<Holder<PlacedFeature>> placedFeature) {
	}
}
