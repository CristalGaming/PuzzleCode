package net.mcreator.puzzle_code.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.world.BlockEvent;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;

import net.mcreator.puzzle_code.network.PuzzleCodeModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ABlockIsPlacedGlobalTriggerProcedure {
	@SubscribeEvent
	public static void onBlockPlace(BlockEvent.EntityPlaceEvent event) {
		execute(event, event.getWorld(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getState());
	}

	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		execute(null, world, x, y, z, blockstate);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		PuzzleCodeModVariables.MapVariables.get(world).ABlockIsPlacedBlockstate = blockstate;
		PuzzleCodeModVariables.MapVariables.get(world).syncData(world);
		PuzzleCodeModVariables.MapVariables.get(world).ABlockIsPlacedX_Pos = x;
		PuzzleCodeModVariables.MapVariables.get(world).syncData(world);
		PuzzleCodeModVariables.MapVariables.get(world).ABlockIsPlacedY_Pos = y;
		PuzzleCodeModVariables.MapVariables.get(world).syncData(world);
		PuzzleCodeModVariables.MapVariables.get(world).ABlockIsPlacedZ_Pos = z;
		PuzzleCodeModVariables.MapVariables.get(world).syncData(world);
	}
}
