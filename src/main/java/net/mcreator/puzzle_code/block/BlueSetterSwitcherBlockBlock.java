
package net.mcreator.puzzle_code.block;

import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.puzzle_code.procedures.LockedBlueSwicherBlockRedstoneOnProcedure;

import java.util.List;
import java.util.Collections;

public class BlueSetterSwitcherBlockBlock extends Block {
	public BlueSetterSwitcherBlockBlock() {
		super(BlockBehaviour.Properties.of().instrument(NoteBlockInstrument.BASEDRUM).sound(SoundType.STONE).strength(3f, 30f).requiresCorrectToolForDrops());
	}

	@Override
	public void appendHoverText(ItemStack itemstack, BlockGetter world, List<Component> list, TooltipFlag flag) {
		super.appendHoverText(itemstack, world, list, flag);
	}

	@Override
	public int getLightBlock(BlockState state, BlockGetter worldIn, BlockPos pos) {
		return 15;
	}

	@Override
	public boolean canHarvestBlock(BlockState state, BlockGetter world, BlockPos pos, Player player) {
		if (player.getInventory().getSelected().getItem() instanceof PickaxeItem tieredItem)
			return tieredItem.getTier().getLevel() >= 1;
		return false;
	}

	@Override
	public List<ItemStack> getDrops(BlockState state, LootParams.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDrops(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(this, 1));
	}

	@Override
	public void neighborChanged(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, BlockPos fromPos, boolean moving) {
		super.neighborChanged(blockstate, world, pos, neighborBlock, fromPos, moving);
		if (world.getBestNeighborSignal(pos) > 0) {
			LockedBlueSwicherBlockRedstoneOnProcedure.execute(world);
		}
	}
}
