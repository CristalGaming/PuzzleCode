package net.mcreator.puzzle_code.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;
import net.minecraft.client.gui.components.EditBox;

import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.HashMap;

public class ApplyItemPositionValueAreaProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, HashMap guistate) {
		if (guistate == null)
			return;
		ItemStack slotItem = ItemStack.EMPTY;
		slotItem = (new Object() {
			public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				BlockEntity _ent = world.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
				return _retval.get();
			}
		}.getItemStack(world, BlockPos.containing(x, y, z), 0));
		if (slotItem.getOrCreateTag().getDouble("currentCoordiante") == 1) {
			slotItem.getOrCreateTag().putDouble((slotItem.getOrCreateTag().getString("currentSelectedAxis") + "Pos"), new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(guistate.containsKey("text:positionField") ? ((EditBox) guistate.get("text:positionField")).getValue() : ""));
		} else if (slotItem.getOrCreateTag().getDouble("currentCoordiante") == 2) {
			slotItem.getOrCreateTag().putDouble((slotItem.getOrCreateTag().getString("currentSelectedAxis") + "Pos2"), new Object() {
				double convert(String s) {
					try {
						return Double.parseDouble(s.trim());
					} catch (Exception e) {
					}
					return 0;
				}
			}.convert(guistate.containsKey("text:positionField") ? ((EditBox) guistate.get("text:positionField")).getValue() : ""));
		}
		{
			BlockEntity _ent = world.getBlockEntity(BlockPos.containing(x, y, z));
			if (_ent != null) {
				final int _slotid = 0;
				final ItemStack _setstack = slotItem;
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
