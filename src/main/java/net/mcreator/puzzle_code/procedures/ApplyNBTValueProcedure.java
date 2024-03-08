package net.mcreator.puzzle_code.procedures;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;
import net.minecraft.client.gui.components.EditBox;

import java.util.HashMap;

public class ApplyNBTValueProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, HashMap guistate) {
		if (guistate == null)
			return;
		String NBTName = "";
		String NBTType = "";
		boolean falseOutput = false;
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
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putDouble(NBTType, new Object() {
						double convert(String s) {
							try {
								return Double.parseDouble(s.trim());
							} catch (Exception e) {
							}
							return 0;
						}
					}.convert(guistate.containsKey("text:NBTValueField") ? ((EditBox) guistate.get("text:NBTValueField")).getValue() : ""));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		} else if ((NBTName).equals("logic")) {
			falseOutput = ((guistate.containsKey("text:NBTValueField") ? ((EditBox) guistate.get("text:NBTValueField")).getValue() : "").toLowerCase()).equals("false")
					|| (guistate.containsKey("text:NBTValueField") ? ((EditBox) guistate.get("text:NBTValueField")).getValue() : "").equals("0") ? false : false;
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putBoolean(NBTType, (((guistate.containsKey("text:NBTValueField") ? ((EditBox) guistate.get("text:NBTValueField")).getValue() : "").toLowerCase()).equals("true")
							|| (guistate.containsKey("text:NBTValueField") ? ((EditBox) guistate.get("text:NBTValueField")).getValue() : "").equals("1") ? true : falseOutput));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		} else if ((NBTName).equals("text")) {
			if (!world.isClientSide()) {
				BlockPos _bp = BlockPos.containing(x, y, z);
				BlockEntity _blockEntity = world.getBlockEntity(_bp);
				BlockState _bs = world.getBlockState(_bp);
				if (_blockEntity != null)
					_blockEntity.getPersistentData().putString(NBTType, (guistate.containsKey("text:NBTValueField") ? ((EditBox) guistate.get("text:NBTValueField")).getValue() : ""));
				if (world instanceof Level _level)
					_level.sendBlockUpdated(_bp, _bs, _bs, 3);
			}
		}
	}
}
