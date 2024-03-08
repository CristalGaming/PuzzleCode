package net.mcreator.puzzle_code.procedures;

import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

import net.mcreator.puzzle_code.network.PuzzleCodeModVariables;
import net.mcreator.puzzle_code.init.PuzzleCodeModBlocks;

import java.util.Map;

public class BlueSwichingSlabOffUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (PuzzleCodeModVariables.MapVariables.get(world).IsSwitchedBlue) {
			{
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockState _bs = PuzzleCodeModBlocks.BLUE_SWITCING_SLAB.get().defaultBlockState();
				BlockState _bso = world.getBlockState(_bp);
				for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
					Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
					if (_property != null && _bs.getValue(_property) != null)
						try {
							_bs = _bs.setValue(_property, (Comparable) entry.getValue());
						} catch (Exception e) {
						}
				}
				world.setBlock(_bp, _bs, 3);
			}
		}
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null)
				_blockEntity.getPersistentData().putBoolean("isSwitchedBlue", PuzzleCodeModVariables.MapVariables.get(world).IsSwitchedBlue);
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null)
				_blockEntity.getPersistentData().putBoolean("isSwitchedRed", (!PuzzleCodeModVariables.MapVariables.get(world).IsSwitchedBlue));
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null)
				_blockEntity.getPersistentData().putBoolean("isSwitchedOn", PuzzleCodeModVariables.MapVariables.get(world).IsSwitchedBlue);
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
	}
}
