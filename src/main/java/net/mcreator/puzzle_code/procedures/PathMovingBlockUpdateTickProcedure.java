package net.mcreator.puzzle_code.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class PathMovingBlockUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		new Object() {
			private int ticks = 0;
			private float waitTicks;
			private LevelAccessor world;

			public void start(LevelAccessor world, int waitTicks) {
				this.waitTicks = waitTicks;
				MinecraftForge.EVENT_BUS.register(this);
				this.world = world;
			}

			@SubscribeEvent
			public void tick(TickEvent.ServerTickEvent event) {
				if (event.phase == TickEvent.Phase.END) {
					this.ticks += 1;
					if (this.ticks >= this.waitTicks)
						run();
				}
			}

			private void run() {
				if ((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == (world.getBlockState(new BlockPos(x + (new Object() {
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
				}.getDirection(new BlockPos(x, y, z))).getStepX(), y - 1, z + (new Object() {
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
				}.getDirection(new BlockPos(x, y, z))).getStepZ()))).getBlock() && (world.getBlockState(new BlockPos(x + (new Object() {
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
				}.getDirection(new BlockPos(x, y, z))).getStepX(), y, z + (new Object() {
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
				}.getDirection(new BlockPos(x, y, z))).getStepZ()))).getBlock() == Blocks.AIR) {
					world.setBlock(new BlockPos(x + (new Object() {
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
					}.getDirection(new BlockPos(x, y, z))).getStepX(), y, z + (new Object() {
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
					}.getDirection(new BlockPos(x, y, z))).getStepZ()), (world.getBlockState(new BlockPos(x, y, z))), 3);
					world.setBlock(new BlockPos(x, y, z), Blocks.AIR.defaultBlockState(), 3);
				} else if ((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == (world.getBlockState(new BlockPos(x + ((new Object() {
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
				}.getDirection(new BlockPos(x, y, z))).getClockWise(Direction.Axis.Y)).getStepX(), y - 1, z + ((new Object() {
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
				}.getDirection(new BlockPos(x, y, z))).getClockWise(Direction.Axis.Y)).getStepZ()))).getBlock()
						&& (world.getBlockState(new BlockPos(x + ((new Object() {
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
						}.getDirection(new BlockPos(x, y, z))).getClockWise(Direction.Axis.Y)).getStepX(), y, z + ((new Object() {
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
						}.getDirection(new BlockPos(x, y, z))).getClockWise(Direction.Axis.Y)).getStepZ()))).getBlock() == Blocks.AIR) {
					{
						Direction _dir = ((new Object() {
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
						}.getDirection(new BlockPos(x, y, z))).getClockWise(Direction.Axis.Y));
						BlockPos _pos = new BlockPos(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
							world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
						} else {
							_property = _bs.getBlock().getStateDefinition().getProperty("axis");
							if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
								world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
						}
					}
				} else if ((world.getBlockState(new BlockPos(x, y - 1, z))).getBlock() == (world.getBlockState(new BlockPos(x + ((new Object() {
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
				}.getDirection(new BlockPos(x, y, z))).getCounterClockWise(Direction.Axis.Y)).getStepX(), y - 1, z + ((new Object() {
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
				}.getDirection(new BlockPos(x, y, z))).getCounterClockWise(Direction.Axis.Y)).getStepZ()))).getBlock()
						&& (world.getBlockState(new BlockPos(x + ((new Object() {
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
						}.getDirection(new BlockPos(x, y, z))).getCounterClockWise(Direction.Axis.Y)).getStepX(), y, z + ((new Object() {
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
						}.getDirection(new BlockPos(x, y, z))).getCounterClockWise(Direction.Axis.Y)).getStepZ()))).getBlock() == Blocks.AIR) {
					{
						Direction _dir = ((new Object() {
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
						}.getDirection(new BlockPos(x, y, z))).getCounterClockWise(Direction.Axis.Y));
						BlockPos _pos = new BlockPos(x, y, z);
						BlockState _bs = world.getBlockState(_pos);
						Property<?> _property = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (_property instanceof DirectionProperty _dp && _dp.getPossibleValues().contains(_dir)) {
							world.setBlock(_pos, _bs.setValue(_dp, _dir), 3);
						} else {
							_property = _bs.getBlock().getStateDefinition().getProperty("axis");
							if (_property instanceof EnumProperty _ap && _ap.getPossibleValues().contains(_dir.getAxis()))
								world.setBlock(_pos, _bs.setValue(_ap, _dir.getAxis()), 3);
						}
					}
				}
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, 10);
	}
}
