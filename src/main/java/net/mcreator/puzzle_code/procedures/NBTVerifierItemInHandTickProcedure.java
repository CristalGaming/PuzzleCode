package net.mcreator.puzzle_code.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.Component;
import net.minecraft.core.BlockPos;

import net.mcreator.puzzle_code.network.PuzzleCodeModVariables;

public class NBTVerifierItemInHandTickProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		{
			double _setval = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getX();
			entity.getCapability(PuzzleCodeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.NBTVerifierXPosBlock = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getY();
			entity.getCapability(PuzzleCodeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.NBTVerifierYPosBlock = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			double _setval = entity.level().clip(new ClipContext(entity.getEyePosition(1f), entity.getEyePosition(1f).add(entity.getViewVector(1f).scale(5)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE, entity)).getBlockPos().getZ();
			entity.getCapability(PuzzleCodeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.NBTVerifierZPosBlock = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		if (((entity.getCapability(PuzzleCodeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PuzzleCodeModVariables.PlayerVariables())).NBTVerifierVariableType).equals("Text")) {
			{
				String _setval = new Object() {
					public String getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getString(tag);
						return "";
					}
				}.getValue(world,
						BlockPos.containing((entity.getCapability(PuzzleCodeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PuzzleCodeModVariables.PlayerVariables())).NBTVerifierXPosBlock,
								(entity.getCapability(PuzzleCodeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PuzzleCodeModVariables.PlayerVariables())).NBTVerifierYPosBlock,
								(entity.getCapability(PuzzleCodeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PuzzleCodeModVariables.PlayerVariables())).NBTVerifierZPosBlock),
						((entity.getCapability(PuzzleCodeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PuzzleCodeModVariables.PlayerVariables())).NBTVerifierNBT));
				entity.getCapability(PuzzleCodeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.NBTVerifierCurrentValue = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (((entity.getCapability(PuzzleCodeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PuzzleCodeModVariables.PlayerVariables())).NBTVerifierVariableType).equals("Number")) {
			{
				String _setval = "" + (new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getDouble(tag);
						return -1;
					}
				}.getValue(world,
						BlockPos.containing((entity.getCapability(PuzzleCodeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PuzzleCodeModVariables.PlayerVariables())).NBTVerifierXPosBlock,
								(entity.getCapability(PuzzleCodeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PuzzleCodeModVariables.PlayerVariables())).NBTVerifierYPosBlock,
								(entity.getCapability(PuzzleCodeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PuzzleCodeModVariables.PlayerVariables())).NBTVerifierZPosBlock),
						((entity.getCapability(PuzzleCodeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PuzzleCodeModVariables.PlayerVariables())).NBTVerifierNBT)));
				entity.getCapability(PuzzleCodeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.NBTVerifierCurrentValue = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		} else if (((entity.getCapability(PuzzleCodeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PuzzleCodeModVariables.PlayerVariables())).NBTVerifierVariableType).equals("Logic")) {
			{
				String _setval = "" + (new Object() {
					public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getBoolean(tag);
						return false;
					}
				}.getValue(world,
						BlockPos.containing((entity.getCapability(PuzzleCodeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PuzzleCodeModVariables.PlayerVariables())).NBTVerifierXPosBlock,
								(entity.getCapability(PuzzleCodeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PuzzleCodeModVariables.PlayerVariables())).NBTVerifierYPosBlock,
								(entity.getCapability(PuzzleCodeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PuzzleCodeModVariables.PlayerVariables())).NBTVerifierZPosBlock),
						((entity.getCapability(PuzzleCodeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PuzzleCodeModVariables.PlayerVariables())).NBTVerifierNBT)));
				entity.getCapability(PuzzleCodeModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
					capability.NBTVerifierCurrentValue = _setval;
					capability.syncPlayerVariables(entity);
				});
			}
		}
		if (entity instanceof Player _player && !_player.level().isClientSide())
			_player.displayClientMessage(Component.literal(("Current Value: " + (entity.getCapability(PuzzleCodeModVariables.PLAYER_VARIABLES_CAPABILITY, null).orElse(new PuzzleCodeModVariables.PlayerVariables())).NBTVerifierCurrentValue)), true);
	}
}
