package net.mcreator.puzzle_code.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;

public class SpawnpointCreativeItemProcedure {
	public static void execute(double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof ServerPlayer _serverPlayer)
			_serverPlayer.setRespawnPosition(_serverPlayer.level().dimension(), BlockPos.containing(x, y, z), _serverPlayer.getYRot(), true, false);
	}
}
