package net.mcreator.puzzle_code.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicInteger;

public class SetDirectionDownDirectionCodeItemProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		ItemStack ItemSlot = ItemStack.EMPTY;
		ItemSlot = (new Object() {
			public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				BlockEntity _ent = world.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
				return _retval.get();
			}
		}.getItemStack(world, BlockPos.containing(x, y, z), 0));
		ItemSlot.getOrCreateTag().putDouble("directionCodeBlock", 0);
		ItemSlot.getOrCreateTag().putString("direction", "DOWN");
		{
			BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
			if (_ent != null) {
				final int _slotid = 0;
				final ItemStack _setstack = ItemSlot;
				_setstack.setCount(new Object() {
					public int getAmount(LevelAccessor world, BlockPos pos, int slotid) {
						AtomicInteger _retval = new AtomicInteger(0);
						BlockEntity _ent = world.getBlockEntity(pos);
						if (_ent != null)
							_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).getCount()));
						return _retval.get();
					}
				}.getAmount(world, BlockPos.containing(x, y, z), 0));
				_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable)
						((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
				});
			}
		}
	}
}
