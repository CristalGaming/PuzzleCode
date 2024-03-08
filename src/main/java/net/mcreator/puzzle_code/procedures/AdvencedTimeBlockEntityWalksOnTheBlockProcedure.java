package net.mcreator.puzzle_code.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.puzzle_code.init.PuzzleCodeModGameRules;

public class AdvencedTimeBlockEntityWalksOnTheBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)
				&& (world.getLevelData().getGameRules().getBoolean(PuzzleCodeModGameRules.BLOCKSAFFECTSYOU) || (entity instanceof Player _plr ? _plr.getAbilities().instabuild : false))) {
			if (world instanceof ServerLevel _level)
				_level.setDayTime((int) (new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getDouble(tag);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x, y, z), "time")));
		}
	}
}
