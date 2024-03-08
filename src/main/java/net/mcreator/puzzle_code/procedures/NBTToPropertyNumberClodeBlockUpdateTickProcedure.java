package net.mcreator.puzzle_code.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class NBTToPropertyNumberClodeBlockUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		{
			int _value = (int) (new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getDouble(tag);
					return -1;
				}
			}.getValue(world, BlockPos.containing(x + ((new Object() {
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
			}.getDirection(BlockPos.containing(x, y, z))).getOpposite()).getStepX(), y + ((new Object() {
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
			}.getDirection(BlockPos.containing(x, y, z))).getOpposite()).getStepY(), z + ((new Object() {
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
			}.getDirection(BlockPos.containing(x, y, z))).getOpposite()).getStepZ()), (new Object() {
				public String getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getString(tag);
					return "";
				}
			}.getValue(world, BlockPos.containing(x, y, z), "getNBT"))));
			BlockPos _pos = BlockPos.containing(x + (new Object() {
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
			}.getDirection(BlockPos.containing(x, y, z))).getStepX(), y + (new Object() {
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
			}.getDirection(BlockPos.containing(x, y, z))).getStepY(), z + (new Object() {
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
			}.getDirection(BlockPos.containing(x, y, z))).getStepZ());
			BlockState _bs = world.getBlockState(_pos);
			if (_bs.getBlock().getStateDefinition().getProperty((new Object() {
				public String getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getString(tag);
					return "";
				}
			}.getValue(world, BlockPos.containing(x, y, z), "setProperty"))) instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
				world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
		}
	}
}
