package net.mcreator.puzzle_code.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.BlockPos;

import net.mcreator.puzzle_code.init.PuzzleCodeModMobEffects;
import net.mcreator.puzzle_code.init.PuzzleCodeModBlocks;

import java.util.Map;
import java.util.List;
import java.util.Comparator;

public class NearEntityYellowSwitchingBlockUpdateTickProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		{
			final Vec3 _center = new Vec3((x + 0.5), (y + 0.5), (z + 0.5));
			List<Entity> _entfound = world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate((new Object() {
				public double getValue(LevelAccessor world, BlockPos pos, String tag) {
					BlockEntity blockEntity = world.getBlockEntity(pos);
					if (blockEntity != null)
						return blockEntity.getPersistentData().getDouble(tag);
					return -1;
				}
			}.getValue(world, BlockPos.containing(x, y, z), "range")) / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList();
			for (Entity entityiterator : _entfound) {
				if (entityiterator instanceof LivingEntity _livEnt1 && _livEnt1.hasEffect(PuzzleCodeModMobEffects.YELLOW_SWITCHER_EFFECT.get())) {
					if ((entityiterator instanceof LivingEntity _livEnt && _livEnt.hasEffect(PuzzleCodeModMobEffects.YELLOW_SWITCHER_EFFECT.get())
							? _livEnt.getEffect(PuzzleCodeModMobEffects.YELLOW_SWITCHER_EFFECT.get()).getAmplifier()
							: 0) >= new Object() {
								public double getValue(LevelAccessor world, BlockPos pos, String tag) {
									BlockEntity blockEntity = world.getBlockEntity(pos);
									if (blockEntity != null)
										return blockEntity.getPersistentData().getDouble(tag);
									return -1;
								}
							}.getValue(world, BlockPos.containing(x, y, z), "minPower")) {
						{
							BlockPos _bp = BlockPos.containing(x, y, z);
							BlockState _bs = PuzzleCodeModBlocks.NEAR_ENTITY_YELLOW_SWITCHING_BLOCK_OFF.get().defaultBlockState();
							BlockState _bso = world.getBlockState(_bp);
							for (Map.Entry<Property<?>, Comparable<?>> entry : _bso.getValues().entrySet()) {
								Property _property = _bs.getBlock().getStateDefinition().getProperty(entry.getKey().getName());
								if (_property != null && _bs.getValue(_property) != null)
									try {
										_bs = _bs.setValue(_property, (Comparable) entry.getValue());
									} catch (Exception e) {
									}
							}
							BlockEntity _be = world.getBlockEntity(_bp);
							CompoundTag _bnbt = null;
							if (_be != null) {
								_bnbt = _be.saveWithFullMetadata();
								_be.setRemoved();
							}
							world.setBlock(_bp, _bs, 3);
							if (_bnbt != null) {
								_be = world.getBlockEntity(_bp);
								if (_be != null) {
									try {
										_be.load(_bnbt);
									} catch (Exception ignored) {
									}
								}
							}
						}
					}
				}
			}
		}
		if (!world.isClientSide()) {
			BlockPos _bp = BlockPos.containing(x, y, z);
			BlockEntity _blockEntity = world.getBlockEntity(_bp);
			BlockState _bs = world.getBlockState(_bp);
			if (_blockEntity != null)
				_blockEntity.getPersistentData().putBoolean("isSwitchedOn", true);
			if (world instanceof Level _level)
				_level.sendBlockUpdated(_bp, _bs, _bs, 3);
		}
	}
}
