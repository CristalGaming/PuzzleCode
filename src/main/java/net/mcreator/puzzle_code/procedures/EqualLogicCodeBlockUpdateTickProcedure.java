package net.mcreator.puzzle_code.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class EqualLogicCodeBlockUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!world.isClientSide()) {
			BlockPos _bp = new BlockPos(x + (new Object() {
				public Direction getDirection(BlockPos pos) {
					BlockState _bs = world.getBlockState(pos);
					Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
					if (property != null && _bs.getValue(property) instanceof Direction _dir)
						return _dir;
					property = _bs.getBlock().getStateDefinition().getProperty("axis");
					if (property != null && _bs.getValue(property) instanceof Direction.Axis _axis)
						return Direction.fromAxisAndDirection(_axis, Direction.AxisDirection.POSITIVE);
					return Direction.NORTH;
				}
			}.getDirection(new BlockPos(x, y, z))).getStepX(), y + (new Object() {
				public Direction getDirection(BlockPos pos) {
					BlockState _bs = world.getBlockState(pos);
					Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
					if (property != null && _bs.getValue(property) instanceof Direction _dir)
						return _dir;
					property = _bs.getBlock().getStateDefinition().getProperty("axis");
					if (property != null && _bs.getValue(property) instanceof Direction.Axis _axis)
						return Direction.fromAxisAndDirection(_axis, Direction.AxisDirection.POSITIVE);
					return Direction.NORTH;
				}
			}.getDirection(new BlockPos(x, y, z))).getStepY(), z + (new Object() {
				public Direction getDirection(BlockPos pos) {
					BlockState _bs = world.getBlockState(pos);
					Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
					if (property != null && _bs.getValue(property) instanceof Direction _dir)
						return _dir;
					property = _bs.getBlock().getStateDefinition().getProperty("axis");
					if (property != null && _bs.getValue(property) instanceof Direction.Axis _axis)
						return Direction.fromAxisAndDirection(_axis, Direction.AxisDirection.POSITIVE);
					return Direction.NORTH;
				}
			}.getDirection(new BlockPos(x, y, z))).getStepZ());
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null)
				_blockEntity.getTileData().putBoolean("logicCodeBlock", ((new Object() {
					public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getTileData().getBoolean(tag);
						return false;
					}
				}.getValue(world, new BlockPos(x + ((new Object() {
					public Direction getDirection(BlockPos pos) {
						BlockState _bs = world.getBlockState(pos);
						Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (property != null && _bs.getValue(property) instanceof Direction _dir)
							return _dir;
						property = _bs.getBlock().getStateDefinition().getProperty("axis");
						if (property != null && _bs.getValue(property) instanceof Direction.Axis _axis)
							return Direction.fromAxisAndDirection(_axis, Direction.AxisDirection.POSITIVE);
						return Direction.NORTH;
					}
				}.getDirection(new BlockPos(x, y, z))).getClockWise(Direction.Axis.Y)).getStepX(), y + ((new Object() {
					public Direction getDirection(BlockPos pos) {
						BlockState _bs = world.getBlockState(pos);
						Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (property != null && _bs.getValue(property) instanceof Direction _dir)
							return _dir;
						property = _bs.getBlock().getStateDefinition().getProperty("axis");
						if (property != null && _bs.getValue(property) instanceof Direction.Axis _axis)
							return Direction.fromAxisAndDirection(_axis, Direction.AxisDirection.POSITIVE);
						return Direction.NORTH;
					}
				}.getDirection(new BlockPos(x, y, z))).getClockWise(Direction.Axis.Y)).getStepY(), z + ((new Object() {
					public Direction getDirection(BlockPos pos) {
						BlockState _bs = world.getBlockState(pos);
						Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (property != null && _bs.getValue(property) instanceof Direction _dir)
							return _dir;
						property = _bs.getBlock().getStateDefinition().getProperty("axis");
						if (property != null && _bs.getValue(property) instanceof Direction.Axis _axis)
							return Direction.fromAxisAndDirection(_axis, Direction.AxisDirection.POSITIVE);
						return Direction.NORTH;
					}
				}.getDirection(new BlockPos(x, y, z))).getClockWise(Direction.Axis.Y)).getStepZ()), "logicCodeBlock")) == (new Object() {
					public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getTileData().getBoolean(tag);
						return false;
					}
				}.getValue(world, new BlockPos(x + ((new Object() {
					public Direction getDirection(BlockPos pos) {
						BlockState _bs = world.getBlockState(pos);
						Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (property != null && _bs.getValue(property) instanceof Direction _dir)
							return _dir;
						property = _bs.getBlock().getStateDefinition().getProperty("axis");
						if (property != null && _bs.getValue(property) instanceof Direction.Axis _axis)
							return Direction.fromAxisAndDirection(_axis, Direction.AxisDirection.POSITIVE);
						return Direction.NORTH;
					}
				}.getDirection(new BlockPos(x, y, z))).getCounterClockWise(Direction.Axis.Y)).getStepX(), y + ((new Object() {
					public Direction getDirection(BlockPos pos) {
						BlockState _bs = world.getBlockState(pos);
						Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (property != null && _bs.getValue(property) instanceof Direction _dir)
							return _dir;
						property = _bs.getBlock().getStateDefinition().getProperty("axis");
						if (property != null && _bs.getValue(property) instanceof Direction.Axis _axis)
							return Direction.fromAxisAndDirection(_axis, Direction.AxisDirection.POSITIVE);
						return Direction.NORTH;
					}
				}.getDirection(new BlockPos(x, y, z))).getCounterClockWise(Direction.Axis.Y)).getStepY(), z + ((new Object() {
					public Direction getDirection(BlockPos pos) {
						BlockState _bs = world.getBlockState(pos);
						Property<?> property = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (property != null && _bs.getValue(property) instanceof Direction _dir)
							return _dir;
						property = _bs.getBlock().getStateDefinition().getProperty("axis");
						if (property != null && _bs.getValue(property) instanceof Direction.Axis _axis)
							return Direction.fromAxisAndDirection(_axis, Direction.AxisDirection.POSITIVE);
						return Direction.NORTH;
					}
				}.getDirection(new BlockPos(x, y, z))).getCounterClockWise(Direction.Axis.Y)).getStepZ()), "logicCodeBlock"))));
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
	}
}
