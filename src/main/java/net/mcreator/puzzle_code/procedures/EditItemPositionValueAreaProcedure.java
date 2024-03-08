package net.mcreator.puzzle_code.procedures;

import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.core.BlockPos;
import net.minecraft.client.gui.components.EditBox;

import java.util.concurrent.atomic.AtomicReference;
import java.util.HashMap;

public class EditItemPositionValueAreaProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, HashMap guistate) {
		if (guistate == null)
			return;
		ItemStack SlotItem = ItemStack.EMPTY;
		SlotItem = (new Object() {
			public ItemStack getItemStack(LevelAccessor world, BlockPos pos, int slotid) {
				AtomicReference<ItemStack> _retval = new AtomicReference<>(ItemStack.EMPTY);
				BlockEntity _ent = world.getBlockEntity(pos);
				if (_ent != null)
					_ent.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> _retval.set(capability.getStackInSlot(slotid).copy()));
				return _retval.get();
			}
		}.getItemStack(world, BlockPos.containing(x, y, z), 0));
		if (guistate.get("text:positionField") instanceof EditBox _tf)
			_tf.setValue((SlotItem.getOrCreateTag().getDouble("currentCoordinate") == 1)
					? ("" + SlotItem.getOrCreateTag().getDouble((SlotItem.getOrCreateTag().getString("currentSelectedAxis") + "Pos")))
					: ("" + SlotItem.getOrCreateTag().getDouble((SlotItem.getOrCreateTag().getString("currentSelectedAxis") + "Pos2"))));
	}
}
