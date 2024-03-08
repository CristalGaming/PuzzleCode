package net.mcreator.puzzle_code.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;

public class CheckpointBlockEntityWalksOnTheBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (new Object() {
			public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getBoolean(tag);
				return false;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "walkingReact") && !(new Object() {
			public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getBoolean(tag);
				return false;
			}
		}.getValue(world, BlockPos.containing(x, y, z), "isDisabled"))) {
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.setRespawnPosition(_serverPlayer.level().dimension(), BlockPos.containing(x + 0.5, y + 1, z + 0.5), _serverPlayer.getYRot(), true, false);
		}
	}
}
