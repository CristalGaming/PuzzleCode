package net.mcreator.puzzle_code.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.Entity;

public class CatapulterItemRightclickedProcedure {
	public static void execute(Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		entity.setDeltaMovement(new Vec3((itemstack.getOrCreateTag().getDouble("xPos") == 0 ? entity.getDeltaMovement().x() : itemstack.getOrCreateTag().getDouble("xPos")),
				(itemstack.getOrCreateTag().getDouble("yPos") == 0 ? entity.getDeltaMovement().y() : itemstack.getOrCreateTag().getDouble("yPos")),
				(itemstack.getOrCreateTag().getDouble("zPos") == 0 ? entity.getDeltaMovement().z() : itemstack.getOrCreateTag().getDouble("zPos"))));
	}
}
