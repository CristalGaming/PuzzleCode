package net.mcreator.puzzle_code.procedures;

import net.minecraft.world.level.LevelAccessor;

public class PuzzleCrafterUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		RegenerationBlockRecipe1Procedure.execute(world, x, y, z);
		FakeBlockRecipe1Procedure.execute(world, x, y, z);
		NormalItemRecipe1Procedure.execute(world, x, y, z);
		EffectBlocksRecipesProcedure.execute(world, x, y, z);
		DamageBlockRecipe1Procedure.execute(world, x, y, z);
		FireDamageBlockRecipe1Procedure.execute(world, x, y, z);
	}
}
