package net.mcreator.puzzle_code.procedures;

import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import java.util.concurrent.atomic.AtomicInteger;

public class NumberOfItemsCodeBlockUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (new Object() {
			public int getContainerSize(LevelAccessor world, BlockPos pos) {
				BlockEntity _ent = world.getBlockEntity(pos);
				if (_ent != null) {
					if (_ent instanceof BaseContainerBlockEntity _block) {
						return _block.getContainerSize();
					}
				}
				return 0;
			}

			public int getAmount(LevelAccessor world, BlockPos pos) {
				Block block = world.getBlockState(pos).getBlock();
				if (block == Blocks.CHEST || block == Blocks.TRAPPED_CHEST) {
					boolean isSingle = block.getStateDefinition().getProperty("type") instanceof EnumProperty _getep5 && world.getBlockState(pos).getValue(_getep5).toString().equals("SINGLE");
					if (!isSingle) {
						return getContainerSize(world, pos) * 2;
					}
				}
				return getContainerSize(world, pos);
			}
		}.getAmount(world, new BlockPos((int) (x + ((new Object() {
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
		}.getDirection(BlockPos.containing(x, y, z))).getOpposite()).getStepX()), (int) (y + ((new Object() {
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
		}.getDirection(BlockPos.containing(x, y, z))).getOpposite()).getStepY()), (int) (z + ((new Object() {
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
		}.getDirection(BlockPos.containing(x, y, z))).getOpposite()).getStepZ()))) >= 1) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x + (new Object() {
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
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble("numberCodeBlock", (new Object() {
						public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicInteger _retval = new AtomicInteger(0);
							BlockEntity _ent = world.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getCount()));
							return _retval.get();
						}
					}.getAmount(world, BlockPos.containing(x + ((new Object() {
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
					}.getDirection(BlockPos.containing(x, y, z))).getOpposite()).getStepZ()), 0)));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
	}
}
