
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.puzzle_code.init;

import net.minecraftforge.fml.common.Mod;

import net.minecraft.world.level.GameRules;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PuzzleCodeModGameRules {
	public static final GameRules.Key<GameRules.BooleanValue> BLOCKSAFFECTSYOU = GameRules.register("blocksAffectsYou", GameRules.Category.PLAYER,
			GameRules.BooleanValue.create(true));
}
