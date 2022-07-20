package net.mcreator.puzzle_code.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;

public class CheckpointBlockEntityWalksOnTheBlockProcedure {
	public static void execute(double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof ServerPlayer _serverPlayer)
			_serverPlayer.setRespawnPosition(_serverPlayer.level.dimension(), new BlockPos(x + 0.5, y + 1, z + 0.5), _serverPlayer.getYRot(), true,
					false);
	}
}
