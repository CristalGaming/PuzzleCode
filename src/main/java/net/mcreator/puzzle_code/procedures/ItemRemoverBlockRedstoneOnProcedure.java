package net.mcreator.puzzle_code.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.CapabilityItemHandler;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import java.util.Comparator;

public class ItemRemoverBlockRedstoneOnProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		double slot = 0;
		slot = 0;
		while (slot < 36) {
			{
				final int _slotid = (int) slot;
				final ItemStack _setstack = new ItemStack(Blocks.AIR);
				_setstack.setCount(1);
				((Entity) world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3(x, y, z), 4, 4, 4), e -> true).stream().sorted(new Object() {
					Comparator<Entity> compareDistOf(double _x, double _y, double _z) {
						return Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_x, _y, _z));
					}
				}.compareDistOf(x, y, z)).findFirst().orElse(null)).getCapability(CapabilityItemHandler.ITEM_HANDLER_CAPABILITY, null)
						.ifPresent(capability -> {
							if (capability instanceof IItemHandlerModifiable _modHandler)
								_modHandler.setStackInSlot(_slotid, _setstack);
						});
			}
			slot = slot + 1;
		}
	}
}
