
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.puzzle_code.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.biome.Biome;

import net.mcreator.puzzle_code.world.biome.TheZoneOfDarkBiome;
import net.mcreator.puzzle_code.world.biome.TheVolcanoOfProtectionBiome;
import net.mcreator.puzzle_code.world.biome.HealthValleyBiome;
import net.mcreator.puzzle_code.world.biome.DeathPlaceBiome;
import net.mcreator.puzzle_code.world.biome.BlockyZoneBiome;
import net.mcreator.puzzle_code.PuzzleCodeMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PuzzleCodeModBiomes {
	public static final DeferredRegister<Biome> REGISTRY = DeferredRegister.create(ForgeRegistries.BIOMES, PuzzleCodeMod.MODID);
	public static final RegistryObject<Biome> BLOCKY_ZONE = REGISTRY.register("blocky_zone", () -> BlockyZoneBiome.createBiome());
	public static final RegistryObject<Biome> DEATH_PLACE = REGISTRY.register("death_place", () -> DeathPlaceBiome.createBiome());
	public static final RegistryObject<Biome> HEALTH_VALLEY = REGISTRY.register("health_valley", () -> HealthValleyBiome.createBiome());
	public static final RegistryObject<Biome> THE_ZONE_OF_DARK = REGISTRY.register("the_zone_of_dark", () -> TheZoneOfDarkBiome.createBiome());
	public static final RegistryObject<Biome> THE_VOLCANO_OF_PROTECTION = REGISTRY.register("the_volcano_of_protection",
			() -> TheVolcanoOfProtectionBiome.createBiome());

	@SubscribeEvent
	public static void init(FMLCommonSetupEvent event) {
		event.enqueueWork(() -> {
			BlockyZoneBiome.init();
			DeathPlaceBiome.init();
			HealthValleyBiome.init();
			TheZoneOfDarkBiome.init();
			TheVolcanoOfProtectionBiome.init();
		});
	}
}
