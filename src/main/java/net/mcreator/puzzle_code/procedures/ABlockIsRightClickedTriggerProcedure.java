package net.mcreator.puzzle_code.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;

import net.mcreator.puzzle_code.network.PuzzleCodeModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class ABlockIsRightClickedTriggerProcedure {
	@SubscribeEvent
	public static void onRightClickBlock(PlayerInteractEvent.RightClickBlock event) {
		if (event.getHand() != event.getEntity().getUsedItemHand())
			return;
		execute(event, event.getLevel(), event.getPos().getX(), event.getPos().getY(), event.getPos().getZ(), event.getLevel().getBlockState(event.getPos()));
	}

	public static void execute(LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		execute(null, world, x, y, z, blockstate);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, double x, double y, double z, BlockState blockstate) {
		PuzzleCodeModVariables.MapVariables.get(world).ABlockIsRightClickedBlockstate = blockstate;
		PuzzleCodeModVariables.MapVariables.get(world).syncData(world);
		PuzzleCodeModVariables.MapVariables.get(world).ABlockIsRightClickedX_Pos = x;
		PuzzleCodeModVariables.MapVariables.get(world).syncData(world);
		PuzzleCodeModVariables.MapVariables.get(world).ABlockIsRightClickedY_Pos = y;
		PuzzleCodeModVariables.MapVariables.get(world).syncData(world);
		PuzzleCodeModVariables.MapVariables.get(world).ABlockIsRightClickedZ_Pos = z;
		PuzzleCodeModVariables.MapVariables.get(world).syncData(world);
	}
}
