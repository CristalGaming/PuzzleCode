package net.mcreator.puzzle_code.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.core.BlockPos;

public class CheckpointItemRightclickedProcedure {
	public static void execute(double x, double y, double z, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (!(entity instanceof Player _plr ? _plr.getAbilities().instabuild : false)) {
			if (entity instanceof Player _player) {
				ItemStack _stktoremove = itemstack;
				_player.getInventory().clearOrCountMatchingItems(p -> _stktoremove.getItem() == p.getItem(), 1, _player.inventoryMenu.getCraftSlots());
			}
		}
		if (entity instanceof ServerPlayer _serverPlayer)
			_serverPlayer.setRespawnPosition(_serverPlayer.level().dimension(), BlockPos.containing(x, y, z), _serverPlayer.getYRot(), true, false);
	}
}
