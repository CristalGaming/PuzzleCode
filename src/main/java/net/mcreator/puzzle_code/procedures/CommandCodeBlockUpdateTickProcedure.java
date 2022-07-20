package net.mcreator.puzzle_code.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.client.gui.components.Checkbox;

import java.util.HashMap;

public class CommandCodeBlockUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, HashMap guistate) {
		if (guistate == null)
			return;
		if (guistate.containsKey("checkbox:always_active") ? ((Checkbox) guistate.get("checkbox:always_active")).selected() : false) {
			CommandCodeBlockRedstoneOnProcedure.execute(world, x, y, z);
		}
	}
}
