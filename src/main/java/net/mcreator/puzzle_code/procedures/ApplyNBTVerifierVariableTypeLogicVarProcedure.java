package net.mcreator.puzzle_code.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.puzzle_code.network.PuzzleCodeModVariables;

public class ApplyNBTVerifierVariableTypeLogicVarProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			String _setval = "Logic";
			entity.getCapability(PuzzleCodeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.NBTVerifierVariableType = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
