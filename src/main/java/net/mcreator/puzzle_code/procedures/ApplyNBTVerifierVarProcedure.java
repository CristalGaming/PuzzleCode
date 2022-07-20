package net.mcreator.puzzle_code.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.client.gui.components.EditBox;

import net.mcreator.puzzle_code.network.PuzzleCodeModVariables;

import java.util.HashMap;

public class ApplyNBTVerifierVarProcedure {
	public static void execute(Entity entity, HashMap guistate) {
		if (entity == null || guistate == null)
			return;
		{
			String _setval = guistate.containsKey("text:NBTVerifyField") ? ((EditBox) guistate.get("text:NBTVerifyField")).getValue() : "";
			entity.getCapability(PuzzleCodeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.NBTVerifierNBT = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
