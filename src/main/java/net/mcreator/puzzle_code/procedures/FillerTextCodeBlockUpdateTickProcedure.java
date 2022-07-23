package net.mcreator.puzzle_code.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class FillerTextCodeBlockUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double sx = 0;
		double sy = 0;
		double sz = 0;
		boolean isBiggerFirstX = false;
		boolean isBiggerFirstY = false;
		boolean isBiggerFirstZ = false;
		isBiggerFirstX = new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos(x, y, z), "xPos") > new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos(x, y, z), "xPos2");
		isBiggerFirstY = new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos(x, y, z), "yPos") > new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos(x, y, z), "yPos2");
		isBiggerFirstZ = new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos(x, y, z), "zPos") > new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos(x, y, z), "zPos2");
		sx = new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos(x, y, z), "xPos");
		sy = new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos(x, y, z), "yPos");
		sz = new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos(x, y, z), "zPos");
		while (!(sx == new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos(x, y, z), "xPos2") + (isBiggerFirstX ? -1 : 1))) {
			while (!(sy == new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos(x, y, z), "yPos2") + (isBiggerFirstY ? -1 : 1))) {
				while (!(sz == new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getTileData().getDouble(tag);
						return -1;
					}
				}.getValue(world, new BlockPos(x, y, z), "zPos2") + (isBiggerFirstZ ? -1 : 1))) {
					if (!world.isClientSide()) {
						BlockPos _bp = new BlockPos(sx, sy, sz);
						BlockEntity _blockEntity = world.getBlockEntity(_bp);
						BlockState _bs = world.getBlockState(_bp);
						if (_blockEntity != null)
							_blockEntity.getTileData().putString((new Object() {
								public String getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getTileData().getString(tag);
									return "";
								}
							}.getValue(world, new BlockPos(x, y, z), "setNBT")), (new Object() {
								public String getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getTileData().getString(tag);
									return "";
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
							}.getDirection(new BlockPos(x, y, z))).getOpposite()).getStepX(), y + ((new Object() {
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
							}.getDirection(new BlockPos(x, y, z))).getOpposite()).getStepY(), z + ((new Object() {
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
							}.getDirection(new BlockPos(x, y, z))).getOpposite()).getStepZ()), (new Object() {
								public String getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getTileData().getString(tag);
									return "";
								}
							}.getValue(world, new BlockPos(x, y, z), "getNBT")))));
						if (world instanceof Level _level)
							_level.sendBlockUpdated(_bp, _bs, _bs, 3);
					}
					sz = isBiggerFirstZ ? sz - 1 : sz + 1;
				}
				sy = isBiggerFirstY ? sy - 1 : sy + 1;
				sz = new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getTileData().getDouble(tag);
						return -1;
					}
				}.getValue(world, new BlockPos(x, y, z), "zPos");
			}
			sx = isBiggerFirstX ? sx - 1 : sx + 1;
			sy = new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos(x, y, z), "yPos");
			sz = new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getTileData().getDouble(tag);
					return -1;
				}
			}.getValue(world, new BlockPos(x, y, z), "zPos");
		}
	}
}
