package net.mcreator.puzzle_code.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.projectile.ThrowableProjectile;
import net.minecraft.world.entity.projectile.SpectralArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.core.BlockPos;

public class EntityDetectorValueProcedure {
	public static double execute(LevelAccessor world, double x, double y, double z) {
		double range = 0;
		range = new Object() {
			public double getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getTileData().getDouble(tag);
				return -1;
			}
		}.getValue(world, new BlockPos(x, y, z), "range");
		if (!world.getEntitiesOfClass(Player.class, AABB.ofSize(new Vec3((x + 0.5), (y + 0.5), (z + 0.5)), range, range, range), e -> true)
				.isEmpty()) {
			return 15;
		} else if (!world.getEntitiesOfClass(Mob.class, AABB.ofSize(new Vec3((x + 0.5), (y + 0.5), (z + 0.5)), range, range, range), e -> true)
				.isEmpty()) {
			return 13;
		} else if (!world
				.getEntitiesOfClass(FallingBlockEntity.class, AABB.ofSize(new Vec3((x + 0.5), (y + 0.5), (z + 0.5)), range, range, range), e -> true)
				.isEmpty()) {
			return 10;
		} else if (!world
				.getEntitiesOfClass(ThrowableProjectile.class, AABB.ofSize(new Vec3((x + 0.5), (y + 0.5), (z + 0.5)), range, range, range), e -> true)
				.isEmpty()
				|| !world.getEntitiesOfClass(Arrow.class, AABB.ofSize(new Vec3((x + 0.5), (y + 0.5), (z + 0.5)), range, range, range), e -> true)
						.isEmpty()
				|| !world.getEntitiesOfClass(SpectralArrow.class, AABB.ofSize(new Vec3((x + 0.5), (y + 0.5), (z + 0.5)), range, range, range),
						e -> true).isEmpty()) {
			return 7;
		} else if (!world.getEntitiesOfClass(ItemEntity.class, AABB.ofSize(new Vec3((x + 0.5), (y + 0.5), (z + 0.5)), range, range, range), e -> true)
				.isEmpty()) {
			return 5;
		}
		return 0;
	}
}
