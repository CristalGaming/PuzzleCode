package net.mcreator.puzzle_code.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class LogicToRedstoneCodeBlockValueProcedure {
	public static double execute(LevelAccessor world, double x, double y, double z) {
		if ((new Object() {
			public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getBoolean(tag);
				return false;
			}
		}.getValue(world, BlockPos.containing(((new Object() {
			public Direction getDirection(BlockPos pos) {
				BlockState _bs = world.getBlockState(pos);
				Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (property != null && _bs.getValue(property) instanceof Direction _dir)
					return _dir;
				else if (_bs.hasProperty(BlockStateProperties.AXIS))
					return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), Direction.AxisDirection.POSITIVE);
				else if (_bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
					return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), Direction.AxisDirection.POSITIVE);
				return Direction.NORTH;
			}
		}.getDirection(BlockPos.containing(x, y, z))).getOpposite()).getStepX() + x, ((new Object() {
			public Direction getDirection(BlockPos pos) {
				BlockState _bs = world.getBlockState(pos);
				Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (property != null && _bs.getValue(property) instanceof Direction _dir)
					return _dir;
				else if (_bs.hasProperty(BlockStateProperties.AXIS))
					return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), Direction.AxisDirection.POSITIVE);
				else if (_bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
					return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), Direction.AxisDirection.POSITIVE);
				return Direction.NORTH;
			}
		}.getDirection(BlockPos.containing(x, y, z))).getOpposite()).getStepY() + y, ((new Object() {
			public Direction getDirection(BlockPos pos) {
				BlockState _bs = world.getBlockState(pos);
				Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
				if (property != null && _bs.getValue(property) instanceof Direction _dir)
					return _dir;
				else if (_bs.hasProperty(BlockStateProperties.AXIS))
					return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.AXIS), Direction.AxisDirection.POSITIVE);
				else if (_bs.hasProperty(BlockStateProperties.HORIZONTAL_AXIS))
					return Direction.fromAxisAndDirection(_bs.getValue(BlockStateProperties.HORIZONTAL_AXIS), Direction.AxisDirection.POSITIVE);
				return Direction.NORTH;
			}
		}.getDirection(BlockPos.containing(x, y, z))).getOpposite()).getStepZ() + z), "logicCodeBlock")) == true) {
			return 15;
		}
		return 0;
	}
}
