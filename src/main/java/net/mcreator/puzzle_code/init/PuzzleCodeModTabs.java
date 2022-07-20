
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.puzzle_code.init;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTab;

public class PuzzleCodeModTabs {
	public static CreativeModeTab TAB_PUZZLE_CODE_TAB;

	public static void load() {
		TAB_PUZZLE_CODE_TAB = new CreativeModeTab("tabpuzzle_code_tab") {
			@Override
			public ItemStack makeIcon() {
				return new ItemStack(PuzzleCodeModBlocks.NORMAL_BLOCK.get());
			}

			@OnlyIn(Dist.CLIENT)
			public boolean hasSearchBar() {
				return true;
			}
		}.setBackgroundSuffix("item_search.png");
	}
}
