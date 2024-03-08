package net.mcreator.puzzle_code.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import java.util.concurrent.atomic.AtomicReference;

public class ItemInventoryToItemCodeBlockUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		{
			BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x + (new Object() {
				public Direction getDirection(BlockState _bs) {
					Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
					if (_prop instanceof DirectionProperty _dp)
						return _bs.getValue(_dp);
					_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
					return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
				}
			}.getDirection(blockstate)).getStepX(), y + (new Object() {
				public Direction getDirection(BlockState _bs) {
					Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
					if (_prop instanceof DirectionProperty _dp)
						return _bs.getValue(_dp);
					_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
					return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
				}
			}.getDirection(blockstate)).getStepY(), z + (new Object() {
				public Direction getDirection(BlockState _bs) {
					Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
					if (_prop instanceof DirectionProperty _dp)
						return _bs.getValue(_dp);
					_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
					return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis ? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE) : Direction.NORTH;
				}
			}.getDirection(blockstate)).getStepZ()));
			if (_ent != null) {
				final int _slotid = (int) (new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getDouble(tag);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x, y, z), "setSlotID"));
				final ItemStack _setstack = (new Object() {
					public ItemStack getItemStack(int sltid, ItemStack _isc) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						_isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).copy());
						});
						return _retval.get();
					}
				}.getItemStack((int) (new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getDouble(tag);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x, y, z), "getSlotID")), (new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
						return _retval.get();
					}
				}.getItemStack(world, BlockPos.containing(x + ((new Object() {
					public Direction getDirection(BlockState _bs) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (_prop instanceof DirectionProperty _dp)
							return _bs.getValue(_dp);
						_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
						return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
								? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
								: Direction.NORTH;
					}
				}.getDirection(blockstate)).getOpposite()).getStepX(), y + ((new Object() {
					public Direction getDirection(BlockState _bs) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (_prop instanceof DirectionProperty _dp)
							return _bs.getValue(_dp);
						_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
						return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
								? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
								: Direction.NORTH;
					}
				}.getDirection(blockstate)).getOpposite()).getStepY(), z + ((new Object() {
					public Direction getDirection(BlockState _bs) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (_prop instanceof DirectionProperty _dp)
							return _bs.getValue(_dp);
						_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
						return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
								? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
								: Direction.NORTH;
					}
				}.getDirection(blockstate)).getOpposite()).getStepZ()), 0))));
				_setstack.setCount((new Object() {
					public ItemStack getItemStack(int sltid, ItemStack _isc) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						_isc.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
							_retval.set(capability.getStackInSlot(sltid).copy());
						});
						return _retval.get();
					}
				}.getItemStack((int) (new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getDouble(tag);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x, y, z), "getSlotID")), (new Object() {
					public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
						return _retval.get();
					}
				}.getItemStack(world, BlockPos.containing(x + ((new Object() {
					public Direction getDirection(BlockState _bs) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (_prop instanceof DirectionProperty _dp)
							return _bs.getValue(_dp);
						_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
						return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
								? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
								: Direction.NORTH;
					}
				}.getDirection(blockstate)).getOpposite()).getStepX(), y + ((new Object() {
					public Direction getDirection(BlockState _bs) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (_prop instanceof DirectionProperty _dp)
							return _bs.getValue(_dp);
						_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
						return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
								? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
								: Direction.NORTH;
					}
				}.getDirection(blockstate)).getOpposite()).getStepY(), z + ((new Object() {
					public Direction getDirection(BlockState _bs) {
						Property<?> _prop = _bs.getBlock().getStateDefinition().getProperty("facing");
						if (_prop instanceof DirectionProperty _dp)
							return _bs.getValue(_dp);
						_prop = _bs.getBlock().getStateDefinition().getProperty("axis");
						return _prop instanceof EnumProperty _ep && _ep.getPossibleValues().toArray()[0] instanceof Direction.Axis
								? Direction.fromAxisAndDirection((Direction.Axis) _bs.getValue(_ep), Direction.AxisDirection.POSITIVE)
								: Direction.NORTH;
					}
				}.getDirection(blockstate)).getOpposite()).getStepZ()), 0)))).getCount());
				_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable)
						((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
				});
			}
		}
	}
}
