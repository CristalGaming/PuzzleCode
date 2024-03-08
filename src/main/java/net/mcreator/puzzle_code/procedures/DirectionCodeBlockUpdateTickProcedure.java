package net.mcreator.puzzle_code.procedures;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class DirectionCodeBlockUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double directionCodeBlock = 0;
		directionCodeBlock = new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "directionCodeBlock");
		if (!(directionCodeBlock >= 0) || !(directionCodeBlock <= 5) || !(directionCodeBlock == Math.round(directionCodeBlock))) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("directionCodeBlock", Math.floor(directionCodeBlock % 6));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null)
				_blockEntity.getPersistentData().putString("direction", ("" + Direction.from3DDataValue((int) directionCodeBlock)).toUpperCase());
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
	}
}
