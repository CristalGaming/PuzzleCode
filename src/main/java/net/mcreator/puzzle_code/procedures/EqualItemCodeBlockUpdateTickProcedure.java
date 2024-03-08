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
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import java.util.concurrent.atomic.AtomicReference;

public class EqualItemCodeBlockUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double xpos = 0;
		double ypos = 0;
		double zpos = 0;
		double xpos2 = 0;
		double ypos2 = 0;
		double zpos2 = 0;
		xpos = ((new Object() {
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
		}.getDirection(BlockPos.containing(x, y, z))).getClockWise(Direction.Axis.Y)).getStepX() + x;
		ypos = ((new Object() {
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
		}.getDirection(BlockPos.containing(x, y, z))).getClockWise(Direction.Axis.Y)).getStepY() + y;
		zpos = ((new Object() {
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
		}.getDirection(BlockPos.containing(x, y, z))).getClockWise(Direction.Axis.Y)).getStepZ() + z;
		xpos2 = ((new Object() {
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
		}.getDirection(BlockPos.containing(x, y, z))).getCounterClockWise(Direction.Axis.Y)).getStepX() + x;
		ypos2 = ((new Object() {
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
		}.getDirection(BlockPos.containing(x, y, z))).getCounterClockWise(Direction.Axis.Y)).getStepY() + y;
		zpos2 = ((new Object() {
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
		}.getDirection(BlockPos.containing(x, y, z))).getCounterClockWise(Direction.Axis.Y)).getStepZ() + z;
		if ((new Object() {
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
		}.getAmount(world, new BlockPos((int) xpos, (int) ypos, (int) zpos)) >= 1) == (new Object() {
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
		}.getAmount(world, new BlockPos((int) xpos2, (int) ypos2, (int) zpos2)) >= 1)) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing((new Object() {
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
				}.getDirection(BlockPos.containing(x, y, z))).getStepX() + x, (new Object() {
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
				}.getDirection(BlockPos.containing(x, y, z))).getStepY() + y, (new Object() {
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
				}.getDirection(BlockPos.containing(x, y, z))).getStepZ() + z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putBoolean("logicCodeBlock", ((new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							BlockEntity _ent = world.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
							return _retval.get();
						}
					}.getItemStack(world, BlockPos.containing(xpos, ypos, zpos), 0)).getItem() == (new Object() {
						public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
							AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
							BlockEntity _ent = world.getBlockEntity(pos);
							if (_ent != null)
								_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
							return _retval.get();
						}
					}.getItemStack(world, BlockPos.containing(xpos2, ypos2, zpos2), 0)).getItem()));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
	}
}
