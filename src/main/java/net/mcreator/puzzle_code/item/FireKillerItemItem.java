
package net.mcreator.puzzle_code.item;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.UseAnim;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.InteractionHand;

import net.mcreator.puzzle_code.procedures.FireKillerItemRightclickedProcedure;
import net.mcreator.puzzle_code.init.PuzzleCodeModTabs;

public class FireKillerItemItem extends Item {
	public FireKillerItemItem() {
		super(new Item.Properties().tab(PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB).stacksTo(64).rarity(Rarity.UNCOMMON));
	}

	@Override
	public UseAnim getUseAnimation(ItemStack itemstack) {
		return UseAnim.EAT;
	}

	@Override
	public InteractionResultHolder<ItemStack> use(Level world, Player entity, InteractionHand hand) {
		InteractionResultHolder<ItemStack> ar = super.use(world, entity, hand);
		ItemStack itemstack = ar.getObject();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();

		FireKillerItemRightclickedProcedure.execute(entity);
		return ar;
	}
}
