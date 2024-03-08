package net.mcreator.puzzle_code.procedures;

import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;
import net.minecraft.client.gui.components.EditBox;

import java.util.HashMap;

public class EditNBTValueProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, HashMap guistate) {
		if (guistate == null)
			return;
		String NBTName = "";
		String NBTType = "";
		NBTName = new Object() {
			public String getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getString(tag);
				return "";
			}
		}.getValue(world, BlockPos.containing(x, y, z), "NBTType");
		NBTType = new Object() {
			public String getValue(LevelAccessor world, BlockPos pos, String tag) {
				BlockEntity blockEntity = world.getBlockEntity(pos);
				if (blockEntity != null)
					return blockEntity.getPersistentData().getString(tag);
				return "";
			}
		}.getValue(world, BlockPos.containing(x, y, z), "NBTName");
		if ((NBTName).equals("number")) {
			if (guistate.get("text:NBTValue") instanceof EditBox _tf)
				_tf.setValue(("" + (new Object() {
					public double getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getDouble(tag);
						return -1;
					}
				}.getValue(world, BlockPos.containing(x, y, z), NBTType))));
		} else if ((NBTName).equals("logic")) {
			if (guistate.get("text:NBTValue") instanceof EditBox _tf)
				_tf.setValue(("" + (new Object() {
					public boolean getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getBoolean(tag);
						return false;
					}
				}.getValue(world, BlockPos.containing(x, y, z), NBTType))));
		} else if ((NBTName).equals("text")) {
			if (guistate.get("text:NBTValue") instanceof EditBox _tf)
				_tf.setValue((new Object() {
					public String getValue(LevelAccessor world, BlockPos pos, String tag) {
						BlockEntity blockEntity = world.getBlockEntity(pos);
						if (blockEntity != null)
							return blockEntity.getPersistentData().getString(tag);
						return "";
					}
				}.getValue(world, BlockPos.containing(x, y, z), NBTType)));
		}
	}
}
