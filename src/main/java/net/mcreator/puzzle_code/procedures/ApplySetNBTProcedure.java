package net.mcreator.puzzle_code.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;
import net.minecraft.client.gui.components.EditBox;

import java.util.HashMap;

public class ApplySetNBTProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, HashMap guistate) {
		if (guistate == null)
			return;
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null)
				_blockEntity.getPersistentData().putString("setNBT", (guistate.containsKey("text:setNBTField") ? ((EditBox) guistate.get("text:setNBTField")).getValue() : ""));
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
	}
}
