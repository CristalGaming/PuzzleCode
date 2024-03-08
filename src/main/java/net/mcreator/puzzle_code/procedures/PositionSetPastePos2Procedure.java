package net.mcreator.puzzle_code.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.puzzle_code.network.PuzzleCodeModVariables;

public class PositionSetPastePos2Procedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing((entity.getCapability(PuzzleCodeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PuzzleCodeModVariables.PlayerVariables())).positionSetXPos,
					(entity.getCapability(PuzzleCodeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PuzzleCodeModVariables.PlayerVariables())).positionSetYPos,
					(entity.getCapability(PuzzleCodeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PuzzleCodeModVariables.PlayerVariables())).positionSetZPos);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null)
				_blockEntity.getPersistentData().putDouble("xPos2", ((entity.getCapability(PuzzleCodeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PuzzleCodeModVariables.PlayerVariables())).positionSetXPos2));
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing((entity.getCapability(PuzzleCodeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PuzzleCodeModVariables.PlayerVariables())).positionSetXPos,
					(entity.getCapability(PuzzleCodeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PuzzleCodeModVariables.PlayerVariables())).positionSetYPos,
					(entity.getCapability(PuzzleCodeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PuzzleCodeModVariables.PlayerVariables())).positionSetZPos);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null)
				_blockEntity.getPersistentData().putDouble("yPos2", ((entity.getCapability(PuzzleCodeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PuzzleCodeModVariables.PlayerVariables())).positionSetYPos2));
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing((entity.getCapability(PuzzleCodeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PuzzleCodeModVariables.PlayerVariables())).positionSetXPos,
					(entity.getCapability(PuzzleCodeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PuzzleCodeModVariables.PlayerVariables())).positionSetYPos,
					(entity.getCapability(PuzzleCodeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PuzzleCodeModVariables.PlayerVariables())).positionSetZPos);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null)
				_blockEntity.getPersistentData().putDouble("zPos2", ((entity.getCapability(PuzzleCodeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PuzzleCodeModVariables.PlayerVariables())).positionSetZPos2));
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
	}
}
