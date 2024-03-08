package net.mcreator.puzzle_code.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;

import java.util.concurrent.atomic.AtomicReference;

public class ItemAreaGUIButtonSwapProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double temp = 0;
		ItemStack itemSlot = ItemStack.EMPTY;
		itemSlot = (new Object() {
			public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				BlockEntity _ent = world.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
				return _retval.get();
			}
		}.getItemStack(world, BlockPos.containing(x, y, z), 0));
		temp = itemSlot.getOrCreateTag().getDouble((itemSlot.getOrCreateTag().getString("currentSelectedAxis") + "Pos"));
		itemSlot.getOrCreateTag().putDouble((itemSlot.getOrCreateTag().getString("currentSelectedAxis") + "Pos"), (itemSlot.getOrCreateTag().getDouble((itemSlot.getOrCreateTag().getString("currentSelectedAxis") + "Pos2"))));
		itemSlot.getOrCreateTag().putDouble((itemSlot.getOrCreateTag().getString("currentSelectedAxis") + "Pos2"), temp);
		{
			BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
			if (_ent != null) {
				final int _slotid = 0;
				final ItemStack _setstack = itemSlot;
				_setstack.setCount(itemSlot.getCount());
				_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
					if (capability instanceof IItemHandlerModifiable)
						((IItemHandlerModifiable) capability).setStackInSlot(_slotid, _setstack);
				});
			}
		}
	}
}
