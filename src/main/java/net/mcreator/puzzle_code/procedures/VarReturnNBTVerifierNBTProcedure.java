package net.mcreator.puzzle_code.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.puzzle_code.network.PuzzleCodeModVariables;

public class VarReturnNBTVerifierNBTProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		return (entity.getCapability(PuzzleCodeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PuzzleCodeModVariables.PlayerVariables())).NBTVerifierNBT;
	}
}
