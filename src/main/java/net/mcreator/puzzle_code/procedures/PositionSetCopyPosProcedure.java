package net.mcreator.puzzle_code.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.puzzle_code.network.PuzzleCodeModVariables;

public class PositionSetCopyPosProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = (entity.getCapability(PuzzleCodeModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new PuzzleCodeModVariables.PlayerVariables())).positionSetXPos;
			entity.getCapability(PuzzleCodeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.positionSetXPos2 = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = (entity.getCapability(PuzzleCodeModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new PuzzleCodeModVariables.PlayerVariables())).positionSetYPos;
			entity.getCapability(PuzzleCodeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.positionSetYPos2 = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = (entity.getCapability(PuzzleCodeModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new PuzzleCodeModVariables.PlayerVariables())).positionSetZPos;
			entity.getCapability(PuzzleCodeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.positionSetZPos2 = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
