package net.mcreator.puzzle_code.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.TickEvent;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.puzzle_code.network.PuzzleCodeModVariables;
import net.mcreator.puzzle_code.PuzzleCodeMod;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class TimedSwichingBlockWorldUpdateProcedure {
	@SubscribeEvent
	public static void onWorldTick(TickEvent.LevelTickEvent event) {
		if (event.phase == TickEvent.Phase.END) {
			execute(event, event.level);
		}
	}

	public static void execute(LevelAccessor world) {
		execute(null, world);
	}

	private static void execute(@Nullable Event event, LevelAccessor world) {
		double number1 = 0;
		double number2 = 0;
		if (PuzzleCodeModVariables.MapVariables.get(world).IsTimedSwitched) {
			PuzzleCodeMod.queueServerWork(80, () -> {
				PuzzleCodeModVariables.MapVariables.get(world).IsTimedSwitched = false;
				PuzzleCodeModVariables.MapVariables.get(world).syncData(world);
			});
		} else {
			PuzzleCodeMod.queueServerWork(80, () -> {
				PuzzleCodeModVariables.MapVariables.get(world).IsTimedSwitched = true;
				PuzzleCodeModVariables.MapVariables.get(world).syncData(world);
			});
		}
	}
}
