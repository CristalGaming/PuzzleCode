package net.mcreator.puzzle_code.procedures;

import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.common.capabilities.ForgeCapabilities;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.GameType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.client.Minecraft;

import net.mcreator.puzzle_code.init.PuzzleCodeModGameRules;

public class ItemRemoverBlockEntityWalksOnTheBlockProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		double slot = 0;
		if (new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
				} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
				}
				return false;
			}
		}.checkGamemode(entity) && world.getLevelData().getGameRules().getBoolean(PuzzleCodeModGameRules.BLOCKSAFFECTSYOU) == true || !(new Object() {
			public boolean checkGamemode(Entity _ent) {
				if (_ent instanceof ServerPlayer _serverPlayer) {
					return _serverPlayer.gameMode.getGameModeForPlayer() == GameType.CREATIVE;
				} else if (_ent.level().isClientSide() && _ent instanceof Player _player) {
					return Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()) != null && Minecraft.getInstance().getConnection().getPlayerInfo(_player.getGameProfile().getId()).getGameMode() == GameType.CREATIVE;
				}
				return false;
			}
		}.checkGamemode(entity))) {
			slot = 0;
			while (slot < 36) {
				{
					final int _slotid = (int) slot;
					final ItemStack _setstack = new ItemStack(Blocks.AIR);
					_setstack.setCount(0);
					entity.getCapability(ForgeCapabilities.ITEM_HANDLER, null).ifPresent(capability -> {
						if (capability instanceof IItemHandlerModifiable _modHandler)
							_modHandler.setStackInSlot(_slotid, _setstack);
					});
				}
				slot = slot + 1;
			}
		}
	}
}
