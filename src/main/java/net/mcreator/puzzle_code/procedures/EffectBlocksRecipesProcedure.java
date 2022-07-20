package net.mcreator.puzzle_code.procedures;

import net.minecraft.world.level.LevelAccessor;

public class EffectBlocksRecipesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		SpeedEffectBlockRecipe1Procedure.execute(world, x, y, z);
		JumpBoostEffectBlockRecipe1Procedure.execute(world, x, y, z);
		SlownessEffectBlockRecipe1Procedure.execute(world, x, y, z);
		NauseaEffectBlockRecipe1Procedure.execute(world, x, y, z);
		BlindnessEffectBlockRecipe1Procedure.execute(world, x, y, z);
		NightVisionEffectBlockRecipe1Procedure.execute(world, x, y, z);
		InvisibilityEffectBlockRecipe1Procedure.execute(world, x, y, z);
		LevitationEffectBlockRecipe1Procedure.execute(world, x, y, z);
		LevitationEffectBlockRecipe2Procedure.execute(world, x, y, z);
		SlowFallingEffectBlockRecipe1Procedure.execute(world, x, y, z);
		FireResistanceEffectBlockRecipe1Procedure.execute(world, x, y, z);
		ResistanceEffectBlockRecipe1Procedure.execute(world, x, y, z);
		WeaknessEffectBlockRecipe1Procedure.execute(world, x, y, z);
		WeaknessEffectBlockRecipe2Procedure.execute(world, x, y, z);
		GlowingEffectBlockRecipe1Procedure.execute(world, x, y, z);
	}
}
