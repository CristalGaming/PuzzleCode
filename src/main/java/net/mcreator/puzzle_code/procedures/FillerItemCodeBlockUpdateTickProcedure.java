package net.mcreator.puzzle_code.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
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
import java.util.concurrent.atomic.AtomicInteger;

public class FillerItemCodeBlockUpdateTickProcedure {
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
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "xPos") > new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "xPos2");
		isBiggerFirstY = new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "yPos") > new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "yPos2");
		isBiggerFirstZ = new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "zPos") > new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "zPos2");
		sx = new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "xPos");
		sy = new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "yPos");
		sz = new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "zPos");
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
		}.getDirection(BlockPos.containing(x, y, z))).getOpposite()).getStepZ()))) - 1) >= new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getDouble(tag);
				return -1;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "getSlotNumber")) {
			while (!(sx == new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getDouble(tag);
					return -1;
				}
			}.getValue(world, BlockPos.containing(x, y, z), "xPos2") + (isBiggerFirstX ? -1 : 1))) {
				while (!(sy == new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getDouble(tag);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x, y, z), "yPos2") + (isBiggerFirstY ? -1 : 1))) {
					while (!(sz == new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "zPos2") + (isBiggerFirstZ ? -1 : 1))) {
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
						}.getAmount(world, new BlockPos((int) sx, (int) sy, (int) sz)) - 1) >= new Object() {
							public double getValue(LevelAccessor world, BlockPos pos, String tag) {
								BlockEntity blockEntity = world.getBlockEntity(pos);
								if (blockEntity != null)
									return blockEntity.getPersistentData().getDouble(tag);
								return -1;
							}
						}.getValue(world, BlockPos.containing(x, y, z), "setSlotNumber")) {
							{
								BlockEntity _ent = world.getBlockEntity(BlockPos.containing(sx, sy, sz));
								if (_ent != null) {
									final int _slotid = (int) (new Object() {
										public double getValue(LevelAccessor world, BlockPos pos, String tag) {
											BlockEntity blockEntity = world.getBlockEntity(pos);
											if (blockEntity != null)
												return blockEntity.getPersistentData().getDouble(tag);
											return -1;
										}
									}.getValue(world, BlockPos.containing(x, y, z), "setSlotNumber"));
									final ItemStack _setstack = (new Object() {
										public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
											AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
											BlockEntity _ent = world.getBlockEntity(pos);
											if (_ent != null)
												_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
											return _retval.get();
										}
									}.getItemStack(world, BlockPos.containing(x + ((new Object() {
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
									}.getDirection(BlockPos.containing(x, y, z))).getOpposite()).getStepZ()), (int) (new Object() {
										public double getValue(LevelAccessor world, BlockPos pos, String tag) {
											BlockEntity blockEntity = world.getBlockEntity(pos);
											if (blockEntity != null)
												return blockEntity.getPersistentData().getDouble(tag);
											return -1;
										}
									}.getValue(world, BlockPos.containing(x, y, z), "getSlotNumber"))));
									_setstack.setCount(new Object() {
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
									}.getDirection(BlockPos.containing(x, y, z))).getOpposite()).getStepZ()), (int) (new Object() {
										public double getValue(LevelAccessor world, BlockPos pos, String tag) {
											BlockEntity blockEntity = world.getBlockEntity(pos);
											if (blockEntity != null)
												return blockEntity.getPersistentData().getDouble(tag);
											return -1;
										}
									}.getValue(world, BlockPos.containing(x, y, z), "getSlotNumber"))));
									_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
										if (capability instanceof IItemHandlerModifiable)
											((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
									});
								}
							}
						}
						sz = isBiggerFirstZ ? sz - 1 : sz + 1;
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("current x", 0);
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("current y", 0);
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
						if (!world.isClientSide()) {
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockEntity _blockEntity = world.getBlockEntity(_bp);
							BlockState _bs = world.getBlockState(_bp);
							if (_blockEntity != null)
								_blockEntity.getPersistentData().putDouble("current z", 0);
							if (world instanceof Level _level)
								_level.sendBlockUpdated(_bp, _bs, _bs, 3);
						}
					}
					sy = isBiggerFirstY ? sy - 1 : sy + 1;
					sz = new Object() {
						public double getValue(LevelAccessor world, BlockPos pos, String tag) {
							BlockEntity blockEntity = world.getBlockEntity(pos);
							if (blockEntity != null)
								return blockEntity.getPersistentData().getDouble(tag);
							return -1;
						}
					}.getValue(world, BlockPos.containing(x, y, z), "zPos");
				}
				sx = isBiggerFirstX ? sx - 1 : sx + 1;
				sy = new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getDouble(tag);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x, y, z), "yPos");
				sz = new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getDouble(tag);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x, y, z), "zPos");
			}
		}
	}
}
