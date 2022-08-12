
package net.mcreator.puzzle_code.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;

import net.mcreator.puzzle_code.procedures.PositionSetRightClickedOnBlockProcedure;
import net.mcreator.puzzle_code.procedures.PositionSetItemInHandTickProcedure;
import net.mcreator.puzzle_code.init.PuzzleCodeModTabs;

public class PositionSetItem extends Item {
	public PositionSetItem() {
		super(new Item.Properties().tab(PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB).stacksTo(64).rarity(Rarity.UNCOMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		InteractionResult retval = super.useOn(context);
		PositionSetRightClickedOnBlockProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(),
				context.getClickedPos().getZ(), context.getPlayer());
		return retval;
	}

	@Override
	public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
		super.inventoryTick(itemstack, world, entity, slot, selected);
		if (selected)
			PositionSetItemInHandTickProcedure.execute(entity);
	}
}
