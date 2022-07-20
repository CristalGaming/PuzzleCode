
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.puzzle_code.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.Block;

import net.mcreator.puzzle_code.block.entity.YellowSwitchingSlabOffBlockEntity;
import net.mcreator.puzzle_code.block.entity.YellowSwitchingSlabBlockEntity;
import net.mcreator.puzzle_code.block.entity.YellowSwitchingBlockOffBlockEntity;
import net.mcreator.puzzle_code.block.entity.YellowSwitchingBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.YellowSwitcherEffectStairsBlockEntity;
import net.mcreator.puzzle_code.block.entity.YellowSwitcherEffectBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.YearNumberCodeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.WitherEffectStairsBlockEntity;
import net.mcreator.puzzle_code.block.entity.WitherEffectSlabBlockEntity;
import net.mcreator.puzzle_code.block.entity.WitherEffectBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.WeaknessEffectStairsBlockEntity;
import net.mcreator.puzzle_code.block.entity.WeaknessEffectSlabBlockEntity;
import net.mcreator.puzzle_code.block.entity.WeaknessEffectBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.WaterBreathingEffectStairsBlockEntity;
import net.mcreator.puzzle_code.block.entity.WaterBreathingEffectSlabBlockEntity;
import net.mcreator.puzzle_code.block.entity.WaterBreathingEffectBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.WalkingSwitchingBlockOffBlockEntity;
import net.mcreator.puzzle_code.block.entity.WalkingSwitchingBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.WalkingDetectorBlockEntity;
import net.mcreator.puzzle_code.block.entity.UnluckEffectStairsBlockEntity;
import net.mcreator.puzzle_code.block.entity.UnluckEffectSlabBlockEntity;
import net.mcreator.puzzle_code.block.entity.UnluckEffectBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.UnequalNumberCodeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.TransferTextCodeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.TransferNumberCodeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.TransferLogicCodeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.TransferItemCodeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.TitleTextCodeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.TextCodeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.TeleporterTextCodeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.TeleporterNumberCodeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.TeleporterLogicCodeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.TeleporterItemCodeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.SwitchingBlockRedBlockEntity;
import net.mcreator.puzzle_code.block.entity.SwitcherBlockBlueBlockEntity;
import net.mcreator.puzzle_code.block.entity.SurvivalTextCodeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.SurvivalNumberCodeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.SurvivalLogicCodeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.SurvivalItemCodeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.SubstractionNumberCodeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.SpeedEffectStairsBlockEntity;
import net.mcreator.puzzle_code.block.entity.SpeedEffectSlabBlockEntity;
import net.mcreator.puzzle_code.block.entity.SpeedEffectBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.SlownessEffectStairsBlockEntity;
import net.mcreator.puzzle_code.block.entity.SlownessEffectSlabBlockEntity;
import net.mcreator.puzzle_code.block.entity.SlownessEffectBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.SlowFallingEffectStairsBlockEntity;
import net.mcreator.puzzle_code.block.entity.SlowFallingEffectSlabBlockEntity;
import net.mcreator.puzzle_code.block.entity.SlowFallingEffectBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.SaturationEffectStairsBlockEntity;
import net.mcreator.puzzle_code.block.entity.SaturationEffectSlabBlockEntity;
import net.mcreator.puzzle_code.block.entity.SaturationEffectBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.RightTransferTextCodeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.RightTransferNumberCodeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.RightTransferItemCodeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.ReverseYellowSwitchingSlabOffBlockEntity;
import net.mcreator.puzzle_code.block.entity.ReverseYellowSwitchingSlabBlockEntity;
import net.mcreator.puzzle_code.block.entity.ReverseYellowSwitchingBlockOffBlockEntity;
import net.mcreator.puzzle_code.block.entity.ReverseYellowSwitchingBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.ResistanceEffectStairsBlockEntity;
import net.mcreator.puzzle_code.block.entity.ResistanceEffectSlabBlockEntity;
import net.mcreator.puzzle_code.block.entity.ResistanceEffectBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.ReplacerBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.RemoteMoverBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.RegenerationEffectStairsBlockEntity;
import net.mcreator.puzzle_code.block.entity.RegenerationEffectSlabBlockEntity;
import net.mcreator.puzzle_code.block.entity.RegenerationEffectBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.RandomizerNumberCodeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.RandomizerIntegerNumberCodeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.PuzzleCrafterBlockEntity;
import net.mcreator.puzzle_code.block.entity.PropertyTransferTextCodeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.PropertyTransferNumberCodeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.PropertyToNBTNumberCodeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.PropertyToNBTLogicCodeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.PowerNumberCodeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.PoisonEffectStairsBlockEntity;
import net.mcreator.puzzle_code.block.entity.PoisonEffectSlabBlockEntity;
import net.mcreator.puzzle_code.block.entity.PoisonEffectBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.PlacerBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.PiNumberCodeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.NumberCodeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.NightVisionEffectStairsBlockEntity;
import net.mcreator.puzzle_code.block.entity.NightVisionEffectSlabBlockEntity;
import net.mcreator.puzzle_code.block.entity.NightVisionEffectBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.NauseaEffectStairsBlockEntity;
import net.mcreator.puzzle_code.block.entity.NauseaEffectSlabBlockEntity;
import net.mcreator.puzzle_code.block.entity.NauseaEffectBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.NBTToPropertyTextCodeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.NBTToPropertyNumberClodeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.NBTToPropertyLogicCodeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.MultiplicationNumberCodeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.MonthNumberCodeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.MiningFatigueEffectStairsBlockEntity;
import net.mcreator.puzzle_code.block.entity.MiningFatigueEffectSlabBlockEntity;
import net.mcreator.puzzle_code.block.entity.MiningFatigueEffectBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.MessagerBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.MaxHPOfEntityToNumberCodeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.LuckEffectStairsBlockEntity;
import net.mcreator.puzzle_code.block.entity.LuckEffectSlabBlockEntity;
import net.mcreator.puzzle_code.block.entity.LuckEffectBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.LogicCodeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.LevitationEffectSlabBlockEntity;
import net.mcreator.puzzle_code.block.entity.LevitationEffectBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.LeftTransferTextCodeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.LeftTransferNumberCodeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.LeftTransferLogicCodeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.LeftTransferItemCodeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.JumpBoostEffectStairsBlockEntity;
import net.mcreator.puzzle_code.block.entity.JumpBoostEffectSlabBlockEntity;
import net.mcreator.puzzle_code.block.entity.JumpBoostEffectBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.ItemCodeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.InvisibilityEffectStairsBlockEntity;
import net.mcreator.puzzle_code.block.entity.InvisibilityEffectSlabBlockEntity;
import net.mcreator.puzzle_code.block.entity.InvisibilityEffectBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.InventoryReplacerBlockEntity;
import net.mcreator.puzzle_code.block.entity.InYellowSwitcherEffectStairsBlockEntity;
import net.mcreator.puzzle_code.block.entity.InYellowSwitcherEffectBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.InWitherEffectStairsBlockEntity;
import net.mcreator.puzzle_code.block.entity.InWitherEffectSlabBlockEntity;
import net.mcreator.puzzle_code.block.entity.InWitherEffectBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.InWeaknessEffectStairsBlockEntity;
import net.mcreator.puzzle_code.block.entity.InWeaknessEffectSlabBlockEntity;
import net.mcreator.puzzle_code.block.entity.InWaterBreathingEffectStairsBlockEntity;
import net.mcreator.puzzle_code.block.entity.InWaterBreathingEffectSlabBlockEntity;
import net.mcreator.puzzle_code.block.entity.InUnluckEffectStairsBlockEntity;
import net.mcreator.puzzle_code.block.entity.InUnluckEffectSlabBlockEntity;
import net.mcreator.puzzle_code.block.entity.InUnluckEffectBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.InSpeedEffectStairsBlockEntity;
import net.mcreator.puzzle_code.block.entity.InSpeedEffectSlabBlockEntity;
import net.mcreator.puzzle_code.block.entity.InSpeedEffectBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.InSlownessEffectStairsBlockEntity;
import net.mcreator.puzzle_code.block.entity.InSlownessEffectSlabBlockEntity;
import net.mcreator.puzzle_code.block.entity.InSlownessEffectBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.InSlowFallingEffectStairsBlockEntity;
import net.mcreator.puzzle_code.block.entity.InSlowFallingEffectSlabBlockEntity;
import net.mcreator.puzzle_code.block.entity.InSlowFallingEffectBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.InSaturationEffectStairsBlockEntity;
import net.mcreator.puzzle_code.block.entity.InSaturationEffectSlabBlockEntity;
import net.mcreator.puzzle_code.block.entity.InSaturationEffectBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.InResistanceEffectStairsBlockEntity;
import net.mcreator.puzzle_code.block.entity.InResistanceEffectSlabBlockEntity;
import net.mcreator.puzzle_code.block.entity.InResistanceEffectBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.InRegenerationEffectStairsBlockEntity;
import net.mcreator.puzzle_code.block.entity.InRegenerationEffectSlabBlockEntity;
import net.mcreator.puzzle_code.block.entity.InRegenerationEffectBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.InPoisonEffectStairsBlockEntity;
import net.mcreator.puzzle_code.block.entity.InPoisonEffectSlabBlockEntity;
import net.mcreator.puzzle_code.block.entity.InPoisonEffectBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.InNightVisionEffectSlabBlockEntity;
import net.mcreator.puzzle_code.block.entity.InNightVisionEffectBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.InNauseaEffectStairsBlockEntity;
import net.mcreator.puzzle_code.block.entity.InNauseaEffectBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.InMiningFatigueEffectStairsBlockEntity;
import net.mcreator.puzzle_code.block.entity.InMiningFatigueEffectSlabBlockEntity;
import net.mcreator.puzzle_code.block.entity.InMiningFatigueEffectBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.InLuckEffestStairsBlockEntity;
import net.mcreator.puzzle_code.block.entity.InLuckEffectSlabBlockEntity;
import net.mcreator.puzzle_code.block.entity.InLuckEffectBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.InLevitationEffectStairsBlockEntity;
import net.mcreator.puzzle_code.block.entity.InLevitationEffectSlabBlockEntity;
import net.mcreator.puzzle_code.block.entity.InLevitationEffectBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.InJumpBoostEffectSlabBlockEntity;
import net.mcreator.puzzle_code.block.entity.InJumpBoostEffectBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.InInvisibilityEffectStairsBlockEntity;
import net.mcreator.puzzle_code.block.entity.InInvisibilityEffectSlabBlockEntity;
import net.mcreator.puzzle_code.block.entity.InInvisibilityEffectBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.InHungerEffectStairsBlockEntity;
import net.mcreator.puzzle_code.block.entity.InHungerEffectSlabBlockEntity;
import net.mcreator.puzzle_code.block.entity.InHungerEffectBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.InHasteEffectSlabBlockEntity;
import net.mcreator.puzzle_code.block.entity.InHasteEffectBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.InGlowingEffectStairsBlockEntity;
import net.mcreator.puzzle_code.block.entity.InGlowingEffectSlabBlockEntity;
import net.mcreator.puzzle_code.block.entity.InGlowingEffectBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.InFireResistanceEffectSlabBlockEntity;
import net.mcreator.puzzle_code.block.entity.InFireResistanceEffectBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.InDolphinsGraceEffectStairsBlockEntity;
import net.mcreator.puzzle_code.block.entity.InDolphinsGraceEffectSlabBlockEntity;
import net.mcreator.puzzle_code.block.entity.InDolphinsGraceEffectBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.InDayTimeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.InBlindnessEffectStairsBlockEntity;
import net.mcreator.puzzle_code.block.entity.InBlindnessEffectSlabBlockEntity;
import net.mcreator.puzzle_code.block.entity.InBlindnessEffectBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.ImitatorTextCodeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.ImitatorNumberCodeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.ImitatorLogicCodeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.ImitatorItemCodeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.HungerEffectStairsBlockEntity;
import net.mcreator.puzzle_code.block.entity.HungerEffectBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.HealthChangerBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.HasteEffectStairsBlockEntity;
import net.mcreator.puzzle_code.block.entity.HasteEffectSlabBlockEntity;
import net.mcreator.puzzle_code.block.entity.HasteEffectBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.HPOfEntityToNumberCodeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.GlowingEffectStairsBlockEntity;
import net.mcreator.puzzle_code.block.entity.GlowingEffectSlabBlockEntity;
import net.mcreator.puzzle_code.block.entity.GlowingEffectBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.FireResistanceEffectStairsBlockEntity;
import net.mcreator.puzzle_code.block.entity.FireResistanceEffectSlabBlockEntity;
import net.mcreator.puzzle_code.block.entity.FireResistanceEffectBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.FillerBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.EntityTeleporterBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.DolphinsGraceEffectStairsBlockEntity;
import net.mcreator.puzzle_code.block.entity.DolphinsGraceEffectSlabBlockEntity;
import net.mcreator.puzzle_code.block.entity.DolphinsGraceEffectBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.DivizionNumberCodeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.DayNumberCodeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.CommandCodeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.ChainTextCodeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.ChainNumberCodeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.ChainLogicCodeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.ChainItemCodeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.BlockEntityPlacerBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.BlindnessEffectSlabBlockEntity;
import net.mcreator.puzzle_code.block.entity.BlindnessEffectBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.AdvencedTimeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.AdvancedPlacerBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.AdditionNumberCodeBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.ABlockIsPlacedGlobalBlockBlockEntity;
import net.mcreator.puzzle_code.block.entity.ABlockIsBrokenGlobalBlockBlockEntity;
import net.mcreator.puzzle_code.PuzzleCodeMod;

public class PuzzleCodeModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, PuzzleCodeMod.MODID);
	public static final RegistryObject<BlockEntityType<?>> JUMP_BOOST_EFFECT_BLOCK = register("jump_boost_effect_block",
			PuzzleCodeModBlocks.JUMP_BOOST_EFFECT_BLOCK, JumpBoostEffectBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> JUMP_BOOST_EFFECT_STAIRS = register("jump_boost_effect_stairs",
			PuzzleCodeModBlocks.JUMP_BOOST_EFFECT_STAIRS, JumpBoostEffectStairsBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> JUMP_BOOST_EFFECT_SLAB = register("jump_boost_effect_slab",
			PuzzleCodeModBlocks.JUMP_BOOST_EFFECT_SLAB, JumpBoostEffectSlabBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_JUMP_BOOST_EFFECT_BLOCK = register("in_jump_boost_effect_block",
			PuzzleCodeModBlocks.IN_JUMP_BOOST_EFFECT_BLOCK, InJumpBoostEffectBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_JUMP_BOOST_EFFECT_SLAB = register("in_jump_boost_effect_slab",
			PuzzleCodeModBlocks.IN_JUMP_BOOST_EFFECT_SLAB, InJumpBoostEffectSlabBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SPEED_EFFECT_BLOCK = register("speed_effect_block", PuzzleCodeModBlocks.SPEED_EFFECT_BLOCK,
			SpeedEffectBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SPEED_EFFECT_STAIRS = register("speed_effect_stairs",
			PuzzleCodeModBlocks.SPEED_EFFECT_STAIRS, SpeedEffectStairsBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SPEED_EFFECT_SLAB = register("speed_effect_slab", PuzzleCodeModBlocks.SPEED_EFFECT_SLAB,
			SpeedEffectSlabBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_SPEED_EFFECT_BLOCK = register("in_speed_effect_block",
			PuzzleCodeModBlocks.IN_SPEED_EFFECT_BLOCK, InSpeedEffectBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_SPEED_EFFECT_STAIRS = register("in_speed_effect_stairs",
			PuzzleCodeModBlocks.IN_SPEED_EFFECT_STAIRS, InSpeedEffectStairsBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_SPEED_EFFECT_SLAB = register("in_speed_effect_slab",
			PuzzleCodeModBlocks.IN_SPEED_EFFECT_SLAB, InSpeedEffectSlabBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> POISON_EFFECT_BLOCK = register("poison_effect_block",
			PuzzleCodeModBlocks.POISON_EFFECT_BLOCK, PoisonEffectBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> POISON_EFFECT_STAIRS = register("poison_effect_stairs",
			PuzzleCodeModBlocks.POISON_EFFECT_STAIRS, PoisonEffectStairsBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> POISON_EFFECT_SLAB = register("poison_effect_slab", PuzzleCodeModBlocks.POISON_EFFECT_SLAB,
			PoisonEffectSlabBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_POISON_EFFECT_BLOCK = register("in_poison_effect_block",
			PuzzleCodeModBlocks.IN_POISON_EFFECT_BLOCK, InPoisonEffectBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_POISON_EFFECT_STAIRS = register("in_poison_effect_stairs",
			PuzzleCodeModBlocks.IN_POISON_EFFECT_STAIRS, InPoisonEffectStairsBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_POISON_EFFECT_SLAB = register("in_poison_effect_slab",
			PuzzleCodeModBlocks.IN_POISON_EFFECT_SLAB, InPoisonEffectSlabBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> WITHER_EFFECT_BLOCK = register("wither_effect_block",
			PuzzleCodeModBlocks.WITHER_EFFECT_BLOCK, WitherEffectBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> WITHER_EFFECT_STAIRS = register("wither_effect_stairs",
			PuzzleCodeModBlocks.WITHER_EFFECT_STAIRS, WitherEffectStairsBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> WITHER_EFFECT_SLAB = register("wither_effect_slab", PuzzleCodeModBlocks.WITHER_EFFECT_SLAB,
			WitherEffectSlabBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_WITHER_EFFECT_BLOCK = register("in_wither_effect_block",
			PuzzleCodeModBlocks.IN_WITHER_EFFECT_BLOCK, InWitherEffectBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_WITHER_EFFECT_STAIRS = register("in_wither_effect_stairs",
			PuzzleCodeModBlocks.IN_WITHER_EFFECT_STAIRS, InWitherEffectStairsBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_WITHER_EFFECT_SLAB = register("in_wither_effect_slab",
			PuzzleCodeModBlocks.IN_WITHER_EFFECT_SLAB, InWitherEffectSlabBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> REGENERATION_EFFECT_BLOCK = register("regeneration_effect_block",
			PuzzleCodeModBlocks.REGENERATION_EFFECT_BLOCK, RegenerationEffectBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> REGENERATION_EFFECT_STAIRS = register("regeneration_effect_stairs",
			PuzzleCodeModBlocks.REGENERATION_EFFECT_STAIRS, RegenerationEffectStairsBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> REGENERATION_EFFECT_SLAB = register("regeneration_effect_slab",
			PuzzleCodeModBlocks.REGENERATION_EFFECT_SLAB, RegenerationEffectSlabBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_REGENERATION_EFFECT_BLOCK = register("in_regeneration_effect_block",
			PuzzleCodeModBlocks.IN_REGENERATION_EFFECT_BLOCK, InRegenerationEffectBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_REGENERATION_EFFECT_STAIRS = register("in_regeneration_effect_stairs",
			PuzzleCodeModBlocks.IN_REGENERATION_EFFECT_STAIRS, InRegenerationEffectStairsBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_REGENERATION_EFFECT_SLAB = register("in_regeneration_effect_slab",
			PuzzleCodeModBlocks.IN_REGENERATION_EFFECT_SLAB, InRegenerationEffectSlabBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> RESISTANCE_EFFECT_BLOCK = register("resistance_effect_block",
			PuzzleCodeModBlocks.RESISTANCE_EFFECT_BLOCK, ResistanceEffectBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> RESISTANCE_EFFECT_STAIRS = register("resistance_effect_stairs",
			PuzzleCodeModBlocks.RESISTANCE_EFFECT_STAIRS, ResistanceEffectStairsBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> RESISTANCE_EFFECT_SLAB = register("resistance_effect_slab",
			PuzzleCodeModBlocks.RESISTANCE_EFFECT_SLAB, ResistanceEffectSlabBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_RESISTANCE_EFFECT_BLOCK = register("in_resistance_effect_block",
			PuzzleCodeModBlocks.IN_RESISTANCE_EFFECT_BLOCK, InResistanceEffectBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_RESISTANCE_EFFECT_STAIRS = register("in_resistance_effect_stairs",
			PuzzleCodeModBlocks.IN_RESISTANCE_EFFECT_STAIRS, InResistanceEffectStairsBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_RESISTANCE_EFFECT_SLAB = register("in_resistance_effect_slab",
			PuzzleCodeModBlocks.IN_RESISTANCE_EFFECT_SLAB, InResistanceEffectSlabBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> WEAKNESS_EFFECT_BLOCK = register("weakness_effect_block",
			PuzzleCodeModBlocks.WEAKNESS_EFFECT_BLOCK, WeaknessEffectBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> WEAKNESS_EFFECT_STAIRS = register("weakness_effect_stairs",
			PuzzleCodeModBlocks.WEAKNESS_EFFECT_STAIRS, WeaknessEffectStairsBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> WEAKNESS_EFFECT_SLAB = register("weakness_effect_slab",
			PuzzleCodeModBlocks.WEAKNESS_EFFECT_SLAB, WeaknessEffectSlabBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_WEAKNESS_EFFECT_STAIRS = register("in_weakness_effect_stairs",
			PuzzleCodeModBlocks.IN_WEAKNESS_EFFECT_STAIRS, InWeaknessEffectStairsBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_WEAKNESS_EFFECT_SLAB = register("in_weakness_effect_slab",
			PuzzleCodeModBlocks.IN_WEAKNESS_EFFECT_SLAB, InWeaknessEffectSlabBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> LEVITATION_EFFECT_BLOCK = register("levitation_effect_block",
			PuzzleCodeModBlocks.LEVITATION_EFFECT_BLOCK, LevitationEffectBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> LEVITATION_EFFECT_SLAB = register("levitation_effect_slab",
			PuzzleCodeModBlocks.LEVITATION_EFFECT_SLAB, LevitationEffectSlabBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_LEVITATION_EFFECT_BLOCK = register("in_levitation_effect_block",
			PuzzleCodeModBlocks.IN_LEVITATION_EFFECT_BLOCK, InLevitationEffectBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_LEVITATION_EFFECT_STAIRS = register("in_levitation_effect_stairs",
			PuzzleCodeModBlocks.IN_LEVITATION_EFFECT_STAIRS, InLevitationEffectStairsBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_LEVITATION_EFFECT_SLAB = register("in_levitation_effect_slab",
			PuzzleCodeModBlocks.IN_LEVITATION_EFFECT_SLAB, InLevitationEffectSlabBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SLOW_FALLING_EFFECT_BLOCK = register("slow_falling_effect_block",
			PuzzleCodeModBlocks.SLOW_FALLING_EFFECT_BLOCK, SlowFallingEffectBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SLOW_FALLING_EFFECT_STAIRS = register("slow_falling_effect_stairs",
			PuzzleCodeModBlocks.SLOW_FALLING_EFFECT_STAIRS, SlowFallingEffectStairsBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SLOW_FALLING_EFFECT_SLAB = register("slow_falling_effect_slab",
			PuzzleCodeModBlocks.SLOW_FALLING_EFFECT_SLAB, SlowFallingEffectSlabBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_SLOW_FALLING_EFFECT_BLOCK = register("in_slow_falling_effect_block",
			PuzzleCodeModBlocks.IN_SLOW_FALLING_EFFECT_BLOCK, InSlowFallingEffectBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_SLOW_FALLING_EFFECT_STAIRS = register("in_slow_falling_effect_stairs",
			PuzzleCodeModBlocks.IN_SLOW_FALLING_EFFECT_STAIRS, InSlowFallingEffectStairsBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_SLOW_FALLING_EFFECT_SLAB = register("in_slow_falling_effect_slab",
			PuzzleCodeModBlocks.IN_SLOW_FALLING_EFFECT_SLAB, InSlowFallingEffectSlabBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> INVISIBILITY_EFFECT_BLOCK = register("invisibility_effect_block",
			PuzzleCodeModBlocks.INVISIBILITY_EFFECT_BLOCK, InvisibilityEffectBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> INVISIBILITY_EFFECT_STAIRS = register("invisibility_effect_stairs",
			PuzzleCodeModBlocks.INVISIBILITY_EFFECT_STAIRS, InvisibilityEffectStairsBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> INVISIBILITY_EFFECT_SLAB = register("invisibility_effect_slab",
			PuzzleCodeModBlocks.INVISIBILITY_EFFECT_SLAB, InvisibilityEffectSlabBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_INVISIBILITY_EFFECT_BLOCK = register("in_invisibility_effect_block",
			PuzzleCodeModBlocks.IN_INVISIBILITY_EFFECT_BLOCK, InInvisibilityEffectBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_INVISIBILITY_EFFECT_STAIRS = register("in_invisibility_effect_stairs",
			PuzzleCodeModBlocks.IN_INVISIBILITY_EFFECT_STAIRS, InInvisibilityEffectStairsBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_INVISIBILITY_EFFECT_SLAB = register("in_invisibility_effect_slab",
			PuzzleCodeModBlocks.IN_INVISIBILITY_EFFECT_SLAB, InInvisibilityEffectSlabBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> GLOWING_EFFECT_BLOCK = register("glowing_effect_block",
			PuzzleCodeModBlocks.GLOWING_EFFECT_BLOCK, GlowingEffectBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> GLOWING_EFFECT_STAIRS = register("glowing_effect_stairs",
			PuzzleCodeModBlocks.GLOWING_EFFECT_STAIRS, GlowingEffectStairsBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> GLOWING_EFFECT_SLAB = register("glowing_effect_slab",
			PuzzleCodeModBlocks.GLOWING_EFFECT_SLAB, GlowingEffectSlabBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_GLOWING_EFFECT_BLOCK = register("in_glowing_effect_block",
			PuzzleCodeModBlocks.IN_GLOWING_EFFECT_BLOCK, InGlowingEffectBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_GLOWING_EFFECT_STAIRS = register("in_glowing_effect_stairs",
			PuzzleCodeModBlocks.IN_GLOWING_EFFECT_STAIRS, InGlowingEffectStairsBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_GLOWING_EFFECT_SLAB = register("in_glowing_effect_slab",
			PuzzleCodeModBlocks.IN_GLOWING_EFFECT_SLAB, InGlowingEffectSlabBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> HASTE_EFFECT_BLOCK = register("haste_effect_block", PuzzleCodeModBlocks.HASTE_EFFECT_BLOCK,
			HasteEffectBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> HASTE_EFFECT_STAIRS = register("haste_effect_stairs",
			PuzzleCodeModBlocks.HASTE_EFFECT_STAIRS, HasteEffectStairsBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> HASTE_EFFECT_SLAB = register("haste_effect_slab", PuzzleCodeModBlocks.HASTE_EFFECT_SLAB,
			HasteEffectSlabBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_HASTE_EFFECT_BLOCK = register("in_haste_effect_block",
			PuzzleCodeModBlocks.IN_HASTE_EFFECT_BLOCK, InHasteEffectBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_HASTE_EFFECT_SLAB = register("in_haste_effect_slab",
			PuzzleCodeModBlocks.IN_HASTE_EFFECT_SLAB, InHasteEffectSlabBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> MINING_FATIGUE_EFFECT_BLOCK = register("mining_fatigue_effect_block",
			PuzzleCodeModBlocks.MINING_FATIGUE_EFFECT_BLOCK, MiningFatigueEffectBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> MINING_FATIGUE_EFFECT_STAIRS = register("mining_fatigue_effect_stairs",
			PuzzleCodeModBlocks.MINING_FATIGUE_EFFECT_STAIRS, MiningFatigueEffectStairsBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> MINING_FATIGUE_EFFECT_SLAB = register("mining_fatigue_effect_slab",
			PuzzleCodeModBlocks.MINING_FATIGUE_EFFECT_SLAB, MiningFatigueEffectSlabBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_MINING_FATIGUE_EFFECT_BLOCK = register("in_mining_fatigue_effect_block",
			PuzzleCodeModBlocks.IN_MINING_FATIGUE_EFFECT_BLOCK, InMiningFatigueEffectBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_MINING_FATIGUE_EFFECT_STAIRS = register("in_mining_fatigue_effect_stairs",
			PuzzleCodeModBlocks.IN_MINING_FATIGUE_EFFECT_STAIRS, InMiningFatigueEffectStairsBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_MINING_FATIGUE_EFFECT_SLAB = register("in_mining_fatigue_effect_slab",
			PuzzleCodeModBlocks.IN_MINING_FATIGUE_EFFECT_SLAB, InMiningFatigueEffectSlabBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> FIRE_RESISTANCE_EFFECT_BLOCK = register("fire_resistance_effect_block",
			PuzzleCodeModBlocks.FIRE_RESISTANCE_EFFECT_BLOCK, FireResistanceEffectBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> FIRE_RESISTANCE_EFFECT_STAIRS = register("fire_resistance_effect_stairs",
			PuzzleCodeModBlocks.FIRE_RESISTANCE_EFFECT_STAIRS, FireResistanceEffectStairsBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> FIRE_RESISTANCE_EFFECT_SLAB = register("fire_resistance_effect_slab",
			PuzzleCodeModBlocks.FIRE_RESISTANCE_EFFECT_SLAB, FireResistanceEffectSlabBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_FIRE_RESISTANCE_EFFECT_BLOCK = register("in_fire_resistance_effect_block",
			PuzzleCodeModBlocks.IN_FIRE_RESISTANCE_EFFECT_BLOCK, InFireResistanceEffectBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_FIRE_RESISTANCE_EFFECT_SLAB = register("in_fire_resistance_effect_slab",
			PuzzleCodeModBlocks.IN_FIRE_RESISTANCE_EFFECT_SLAB, InFireResistanceEffectSlabBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> WATER_BREATHING_EFFECT_BLOCK = register("water_breathing_effect_block",
			PuzzleCodeModBlocks.WATER_BREATHING_EFFECT_BLOCK, WaterBreathingEffectBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> WATER_BREATHING_EFFECT_STAIRS = register("water_breathing_effect_stairs",
			PuzzleCodeModBlocks.WATER_BREATHING_EFFECT_STAIRS, WaterBreathingEffectStairsBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> WATER_BREATHING_EFFECT_SLAB = register("water_breathing_effect_slab",
			PuzzleCodeModBlocks.WATER_BREATHING_EFFECT_SLAB, WaterBreathingEffectSlabBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_WATER_BREATHING_EFFECT_STAIRS = register("in_water_breathing_effect_stairs",
			PuzzleCodeModBlocks.IN_WATER_BREATHING_EFFECT_STAIRS, InWaterBreathingEffectStairsBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_WATER_BREATHING_EFFECT_SLAB = register("in_water_breathing_effect_slab",
			PuzzleCodeModBlocks.IN_WATER_BREATHING_EFFECT_SLAB, InWaterBreathingEffectSlabBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> DOLPHINS_GRACE_EFFECT_BLOCK = register("dolphins_grace_effect_block",
			PuzzleCodeModBlocks.DOLPHINS_GRACE_EFFECT_BLOCK, DolphinsGraceEffectBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> DOLPHINS_GRACE_EFFECT_STAIRS = register("dolphins_grace_effect_stairs",
			PuzzleCodeModBlocks.DOLPHINS_GRACE_EFFECT_STAIRS, DolphinsGraceEffectStairsBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> DOLPHINS_GRACE_EFFECT_SLAB = register("dolphins_grace_effect_slab",
			PuzzleCodeModBlocks.DOLPHINS_GRACE_EFFECT_SLAB, DolphinsGraceEffectSlabBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_DOLPHINS_GRACE_EFFECT_BLOCK = register("in_dolphins_grace_effect_block",
			PuzzleCodeModBlocks.IN_DOLPHINS_GRACE_EFFECT_BLOCK, InDolphinsGraceEffectBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_DOLPHINS_GRACE_EFFECT_STAIRS = register("in_dolphins_grace_effect_stairs",
			PuzzleCodeModBlocks.IN_DOLPHINS_GRACE_EFFECT_STAIRS, InDolphinsGraceEffectStairsBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_DOLPHINS_GRACE_EFFECT_SLAB = register("in_dolphins_grace_effect_slab",
			PuzzleCodeModBlocks.IN_DOLPHINS_GRACE_EFFECT_SLAB, InDolphinsGraceEffectSlabBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SLOWNESS_EFFECT_BLOCK = register("slowness_effect_block",
			PuzzleCodeModBlocks.SLOWNESS_EFFECT_BLOCK, SlownessEffectBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SLOWNESS_EFFECT_STAIRS = register("slowness_effect_stairs",
			PuzzleCodeModBlocks.SLOWNESS_EFFECT_STAIRS, SlownessEffectStairsBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SLOWNESS_EFFECT_SLAB = register("slowness_effect_slab",
			PuzzleCodeModBlocks.SLOWNESS_EFFECT_SLAB, SlownessEffectSlabBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_SLOWNESS_EFFECT_BLOCK = register("in_slowness_effect_block",
			PuzzleCodeModBlocks.IN_SLOWNESS_EFFECT_BLOCK, InSlownessEffectBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_SLOWNESS_EFFECT_STAIRS = register("in_slowness_effect_stairs",
			PuzzleCodeModBlocks.IN_SLOWNESS_EFFECT_STAIRS, InSlownessEffectStairsBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_SLOWNESS_EFFECT_SLAB = register("in_slowness_effect_slab",
			PuzzleCodeModBlocks.IN_SLOWNESS_EFFECT_SLAB, InSlownessEffectSlabBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BLINDNESS_EFFECT_BLOCK = register("blindness_effect_block",
			PuzzleCodeModBlocks.BLINDNESS_EFFECT_BLOCK, BlindnessEffectBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BLINDNESS_EFFECT_SLAB = register("blindness_effect_slab",
			PuzzleCodeModBlocks.BLINDNESS_EFFECT_SLAB, BlindnessEffectSlabBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_BLINDNESS_EFFECT_BLOCK = register("in_blindness_effect_block",
			PuzzleCodeModBlocks.IN_BLINDNESS_EFFECT_BLOCK, InBlindnessEffectBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_BLINDNESS_EFFECT_STAIRS = register("in_blindness_effect_stairs",
			PuzzleCodeModBlocks.IN_BLINDNESS_EFFECT_STAIRS, InBlindnessEffectStairsBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_BLINDNESS_EFFECT_SLAB = register("in_blindness_effect_slab",
			PuzzleCodeModBlocks.IN_BLINDNESS_EFFECT_SLAB, InBlindnessEffectSlabBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> NAUSEA_EFFECT_BLOCK = register("nausea_effect_block",
			PuzzleCodeModBlocks.NAUSEA_EFFECT_BLOCK, NauseaEffectBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> NAUSEA_EFFECT_STAIRS = register("nausea_effect_stairs",
			PuzzleCodeModBlocks.NAUSEA_EFFECT_STAIRS, NauseaEffectStairsBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> NAUSEA_EFFECT_SLAB = register("nausea_effect_slab", PuzzleCodeModBlocks.NAUSEA_EFFECT_SLAB,
			NauseaEffectSlabBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_NAUSEA_EFFECT_BLOCK = register("in_nausea_effect_block",
			PuzzleCodeModBlocks.IN_NAUSEA_EFFECT_BLOCK, InNauseaEffectBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_NAUSEA_EFFECT_STAIRS = register("in_nausea_effect_stairs",
			PuzzleCodeModBlocks.IN_NAUSEA_EFFECT_STAIRS, InNauseaEffectStairsBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> NIGHT_VISION_EFFECT_BLOCK = register("night_vision_effect_block",
			PuzzleCodeModBlocks.NIGHT_VISION_EFFECT_BLOCK, NightVisionEffectBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> NIGHT_VISION_EFFECT_STAIRS = register("night_vision_effect_stairs",
			PuzzleCodeModBlocks.NIGHT_VISION_EFFECT_STAIRS, NightVisionEffectStairsBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> NIGHT_VISION_EFFECT_SLAB = register("night_vision_effect_slab",
			PuzzleCodeModBlocks.NIGHT_VISION_EFFECT_SLAB, NightVisionEffectSlabBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_NIGHT_VISION_EFFECT_BLOCK = register("in_night_vision_effect_block",
			PuzzleCodeModBlocks.IN_NIGHT_VISION_EFFECT_BLOCK, InNightVisionEffectBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_NIGHT_VISION_EFFECT_SLAB = register("in_night_vision_effect_slab",
			PuzzleCodeModBlocks.IN_NIGHT_VISION_EFFECT_SLAB, InNightVisionEffectSlabBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SATURATION_EFFECT_BLOCK = register("saturation_effect_block",
			PuzzleCodeModBlocks.SATURATION_EFFECT_BLOCK, SaturationEffectBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SATURATION_EFFECT_STAIRS = register("saturation_effect_stairs",
			PuzzleCodeModBlocks.SATURATION_EFFECT_STAIRS, SaturationEffectStairsBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SATURATION_EFFECT_SLAB = register("saturation_effect_slab",
			PuzzleCodeModBlocks.SATURATION_EFFECT_SLAB, SaturationEffectSlabBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_SATURATION_EFFECT_BLOCK = register("in_saturation_effect_block",
			PuzzleCodeModBlocks.IN_SATURATION_EFFECT_BLOCK, InSaturationEffectBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_SATURATION_EFFECT_STAIRS = register("in_saturation_effect_stairs",
			PuzzleCodeModBlocks.IN_SATURATION_EFFECT_STAIRS, InSaturationEffectStairsBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_SATURATION_EFFECT_SLAB = register("in_saturation_effect_slab",
			PuzzleCodeModBlocks.IN_SATURATION_EFFECT_SLAB, InSaturationEffectSlabBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> HUNGER_EFFECT_BLOCK = register("hunger_effect_block",
			PuzzleCodeModBlocks.HUNGER_EFFECT_BLOCK, HungerEffectBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> HUNGER_EFFECT_STAIRS = register("hunger_effect_stairs",
			PuzzleCodeModBlocks.HUNGER_EFFECT_STAIRS, HungerEffectStairsBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_HUNGER_EFFECT_BLOCK = register("in_hunger_effect_block",
			PuzzleCodeModBlocks.IN_HUNGER_EFFECT_BLOCK, InHungerEffectBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_HUNGER_EFFECT_STAIRS = register("in_hunger_effect_stairs",
			PuzzleCodeModBlocks.IN_HUNGER_EFFECT_STAIRS, InHungerEffectStairsBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_HUNGER_EFFECT_SLAB = register("in_hunger_effect_slab",
			PuzzleCodeModBlocks.IN_HUNGER_EFFECT_SLAB, InHungerEffectSlabBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> YELLOW_SWITCHER_EFFECT_BLOCK = register("yellow_switcher_effect_block",
			PuzzleCodeModBlocks.YELLOW_SWITCHER_EFFECT_BLOCK, YellowSwitcherEffectBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> YELLOW_SWITCHER_EFFECT_STAIRS = register("yellow_switcher_effect_stairs",
			PuzzleCodeModBlocks.YELLOW_SWITCHER_EFFECT_STAIRS, YellowSwitcherEffectStairsBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_YELLOW_SWITCHER_EFFECT_BLOCK = register("in_yellow_switcher_effect_block",
			PuzzleCodeModBlocks.IN_YELLOW_SWITCHER_EFFECT_BLOCK, InYellowSwitcherEffectBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_YELLOW_SWITCHER_EFFECT_STAIRS = register("in_yellow_switcher_effect_stairs",
			PuzzleCodeModBlocks.IN_YELLOW_SWITCHER_EFFECT_STAIRS, InYellowSwitcherEffectStairsBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> LUCK_EFFECT_BLOCK = register("luck_effect_block", PuzzleCodeModBlocks.LUCK_EFFECT_BLOCK,
			LuckEffectBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> LUCK_EFFECT_STAIRS = register("luck_effect_stairs", PuzzleCodeModBlocks.LUCK_EFFECT_STAIRS,
			LuckEffectStairsBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> LUCK_EFFECT_SLAB = register("luck_effect_slab", PuzzleCodeModBlocks.LUCK_EFFECT_SLAB,
			LuckEffectSlabBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_LUCK_EFFECT_BLOCK = register("in_luck_effect_block",
			PuzzleCodeModBlocks.IN_LUCK_EFFECT_BLOCK, InLuckEffectBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_LUCK_EFFEST_STAIRS = register("in_luck_effest_stairs",
			PuzzleCodeModBlocks.IN_LUCK_EFFEST_STAIRS, InLuckEffestStairsBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_LUCK_EFFECT_SLAB = register("in_luck_effect_slab",
			PuzzleCodeModBlocks.IN_LUCK_EFFECT_SLAB, InLuckEffectSlabBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> UNLUCK_EFFECT_BLOCK = register("unluck_effect_block",
			PuzzleCodeModBlocks.UNLUCK_EFFECT_BLOCK, UnluckEffectBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> UNLUCK_EFFECT_STAIRS = register("unluck_effect_stairs",
			PuzzleCodeModBlocks.UNLUCK_EFFECT_STAIRS, UnluckEffectStairsBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> UNLUCK_EFFECT_SLAB = register("unluck_effect_slab", PuzzleCodeModBlocks.UNLUCK_EFFECT_SLAB,
			UnluckEffectSlabBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_UNLUCK_EFFECT_BLOCK = register("in_unluck_effect_block",
			PuzzleCodeModBlocks.IN_UNLUCK_EFFECT_BLOCK, InUnluckEffectBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_UNLUCK_EFFECT_STAIRS = register("in_unluck_effect_stairs",
			PuzzleCodeModBlocks.IN_UNLUCK_EFFECT_STAIRS, InUnluckEffectStairsBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_UNLUCK_EFFECT_SLAB = register("in_unluck_effect_slab",
			PuzzleCodeModBlocks.IN_UNLUCK_EFFECT_SLAB, InUnluckEffectSlabBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> INVENTORY_REPLACER = register("inventory_replacer", PuzzleCodeModBlocks.INVENTORY_REPLACER,
			InventoryReplacerBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> ENTITY_TELEPORTER_BLOCK = register("entity_teleporter_block",
			PuzzleCodeModBlocks.ENTITY_TELEPORTER_BLOCK, EntityTeleporterBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> PLACER_BLOCK = register("placer_block", PuzzleCodeModBlocks.PLACER_BLOCK,
			PlacerBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> ADVANCED_PLACER_BLOCK = register("advanced_placer_block",
			PuzzleCodeModBlocks.ADVANCED_PLACER_BLOCK, AdvancedPlacerBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> REPLACER_BLOCK = register("replacer_block", PuzzleCodeModBlocks.REPLACER_BLOCK,
			ReplacerBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> FILLER_BLOCK = register("filler_block", PuzzleCodeModBlocks.FILLER_BLOCK,
			FillerBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> HEALTH_CHANGER_BLOCK = register("health_changer_block",
			PuzzleCodeModBlocks.HEALTH_CHANGER_BLOCK, HealthChangerBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> ADVENCED_TIME_BLOCK = register("advenced_time_block",
			PuzzleCodeModBlocks.ADVENCED_TIME_BLOCK, AdvencedTimeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IN_DAY_TIME_BLOCK = register("in_day_time_block", PuzzleCodeModBlocks.IN_DAY_TIME_BLOCK,
			InDayTimeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SWITCHING_BLOCK_RED = register("switching_block_red",
			PuzzleCodeModBlocks.SWITCHING_BLOCK_RED, SwitchingBlockRedBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> YELLOW_SWITCHING_BLOCK = register("yellow_switching_block",
			PuzzleCodeModBlocks.YELLOW_SWITCHING_BLOCK, YellowSwitchingBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> REVERSE_YELLOW_SWITCHING_BLOCK = register("reverse_yellow_switching_block",
			PuzzleCodeModBlocks.REVERSE_YELLOW_SWITCHING_BLOCK, ReverseYellowSwitchingBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> YELLOW_SWITCHING_SLAB = register("yellow_switching_slab",
			PuzzleCodeModBlocks.YELLOW_SWITCHING_SLAB, YellowSwitchingSlabBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> YELLOW_SWITCHING_SLAB_OFF = register("yellow_switching_slab_off",
			PuzzleCodeModBlocks.YELLOW_SWITCHING_SLAB_OFF, YellowSwitchingSlabOffBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> REVERSE_YELLOW_SWITCHING_SLAB = register("reverse_yellow_switching_slab",
			PuzzleCodeModBlocks.REVERSE_YELLOW_SWITCHING_SLAB, ReverseYellowSwitchingSlabBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> REVERSE_YELLOW_SWITCHING_SLAB_OFF = register("reverse_yellow_switching_slab_off",
			PuzzleCodeModBlocks.REVERSE_YELLOW_SWITCHING_SLAB_OFF, ReverseYellowSwitchingSlabOffBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> WALKING_SWITCHING_BLOCK = register("walking_switching_block",
			PuzzleCodeModBlocks.WALKING_SWITCHING_BLOCK, WalkingSwitchingBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> A_BLOCK_IS_BROKEN_GLOBAL_BLOCK = register("a_block_is_broken_global_block",
			PuzzleCodeModBlocks.A_BLOCK_IS_BROKEN_GLOBAL_BLOCK, ABlockIsBrokenGlobalBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> A_BLOCK_IS_PLACED_GLOBAL_BLOCK = register("a_block_is_placed_global_block",
			PuzzleCodeModBlocks.A_BLOCK_IS_PLACED_GLOBAL_BLOCK, ABlockIsPlacedGlobalBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> NUMBER_CODE_BLOCK = register("number_code_block", PuzzleCodeModBlocks.NUMBER_CODE_BLOCK,
			NumberCodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SURVIVAL_NUMBER_CODE_BLOCK = register("survival_number_code_block",
			PuzzleCodeModBlocks.SURVIVAL_NUMBER_CODE_BLOCK, SurvivalNumberCodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CHAIN_NUMBER_CODE_BLOCK = register("chain_number_code_block",
			PuzzleCodeModBlocks.CHAIN_NUMBER_CODE_BLOCK, ChainNumberCodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> PI_NUMBER_CODE_BLOCK = register("pi_number_code_block",
			PuzzleCodeModBlocks.PI_NUMBER_CODE_BLOCK, PiNumberCodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> RANDOMIZER_INTEGER_NUMBER_CODE_BLOCK = register("randomizer_integer_number_code_block",
			PuzzleCodeModBlocks.RANDOMIZER_INTEGER_NUMBER_CODE_BLOCK, RandomizerIntegerNumberCodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> RANDOMIZER_NUMBER_CODE_BLOCK = register("randomizer_number_code_block",
			PuzzleCodeModBlocks.RANDOMIZER_NUMBER_CODE_BLOCK, RandomizerNumberCodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> ADDITION_NUMBER_CODE_BLOCK = register("addition_number_code_block",
			PuzzleCodeModBlocks.ADDITION_NUMBER_CODE_BLOCK, AdditionNumberCodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SUBSTRACTION_NUMBER_CODE_BLOCK = register("substraction_number_code_block",
			PuzzleCodeModBlocks.SUBSTRACTION_NUMBER_CODE_BLOCK, SubstractionNumberCodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> DIVIZION_NUMBER_CODE_BLOCK = register("divizion_number_code_block",
			PuzzleCodeModBlocks.DIVIZION_NUMBER_CODE_BLOCK, DivizionNumberCodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> MULTIPLICATION_NUMBER_CODE_BLOCK = register("multiplication_number_code_block",
			PuzzleCodeModBlocks.MULTIPLICATION_NUMBER_CODE_BLOCK, MultiplicationNumberCodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> POWER_NUMBER_CODE_BLOCK = register("power_number_code_block",
			PuzzleCodeModBlocks.POWER_NUMBER_CODE_BLOCK, PowerNumberCodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> UNEQUAL_NUMBER_CODE_BLOCK = register("unequal_number_code_block",
			PuzzleCodeModBlocks.UNEQUAL_NUMBER_CODE_BLOCK, UnequalNumberCodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> DAY_NUMBER_CODE_BLOCK = register("day_number_code_block",
			PuzzleCodeModBlocks.DAY_NUMBER_CODE_BLOCK, DayNumberCodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> MONTH_NUMBER_CODE_BLOCK = register("month_number_code_block",
			PuzzleCodeModBlocks.MONTH_NUMBER_CODE_BLOCK, MonthNumberCodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> YEAR_NUMBER_CODE_BLOCK = register("year_number_code_block",
			PuzzleCodeModBlocks.YEAR_NUMBER_CODE_BLOCK, YearNumberCodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> TRANSFER_NUMBER_CODE_BLOCK = register("transfer_number_code_block",
			PuzzleCodeModBlocks.TRANSFER_NUMBER_CODE_BLOCK, TransferNumberCodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> LEFT_TRANSFER_NUMBER_CODE_BLOCK = register("left_transfer_number_code_block",
			PuzzleCodeModBlocks.LEFT_TRANSFER_NUMBER_CODE_BLOCK, LeftTransferNumberCodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> RIGHT_TRANSFER_NUMBER_CODE_BLOCK = register("right_transfer_number_code_block",
			PuzzleCodeModBlocks.RIGHT_TRANSFER_NUMBER_CODE_BLOCK, RightTransferNumberCodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> PROPERTY_TO_NBT_NUMBER_CODE_BLOCK = register("property_to_nbt_number_code_block",
			PuzzleCodeModBlocks.PROPERTY_TO_NBT_NUMBER_CODE_BLOCK, PropertyToNBTNumberCodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> NBT_TO_PROPERTY_NUMBER_CLODE_BLOCK = register("nbt_to_property_number_clode_block",
			PuzzleCodeModBlocks.NBT_TO_PROPERTY_NUMBER_CLODE_BLOCK, NBTToPropertyNumberClodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> PROPERTY_TRANSFER_NUMBER_CODE_BLOCK = register("property_transfer_number_code_block",
			PuzzleCodeModBlocks.PROPERTY_TRANSFER_NUMBER_CODE_BLOCK, PropertyTransferNumberCodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IMITATOR_NUMBER_CODE_BLOCK = register("imitator_number_code_block",
			PuzzleCodeModBlocks.IMITATOR_NUMBER_CODE_BLOCK, ImitatorNumberCodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> TELEPORTER_NUMBER_CODE_BLOCK = register("teleporter_number_code_block",
			PuzzleCodeModBlocks.TELEPORTER_NUMBER_CODE_BLOCK, TeleporterNumberCodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> LOGIC_CODE_BLOCK = register("logic_code_block", PuzzleCodeModBlocks.LOGIC_CODE_BLOCK,
			LogicCodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SURVIVAL_LOGIC_CODE_BLOCK = register("survival_logic_code_block",
			PuzzleCodeModBlocks.SURVIVAL_LOGIC_CODE_BLOCK, SurvivalLogicCodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CHAIN_LOGIC_CODE_BLOCK = register("chain_logic_code_block",
			PuzzleCodeModBlocks.CHAIN_LOGIC_CODE_BLOCK, ChainLogicCodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> TRANSFER_LOGIC_CODE_BLOCK = register("transfer_logic_code_block",
			PuzzleCodeModBlocks.TRANSFER_LOGIC_CODE_BLOCK, TransferLogicCodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> LEFT_TRANSFER_LOGIC_CODE_BLOCK = register("left_transfer_logic_code_block",
			PuzzleCodeModBlocks.LEFT_TRANSFER_LOGIC_CODE_BLOCK, LeftTransferLogicCodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> NBT_TO_PROPERTY_LOGIC_CODE_BLOCK = register("nbt_to_property_logic_code_block",
			PuzzleCodeModBlocks.NBT_TO_PROPERTY_LOGIC_CODE_BLOCK, NBTToPropertyLogicCodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> PROPERTY_TO_NBT_LOGIC_CODE_BLOCK = register("property_to_nbt_logic_code_block",
			PuzzleCodeModBlocks.PROPERTY_TO_NBT_LOGIC_CODE_BLOCK, PropertyToNBTLogicCodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IMITATOR_LOGIC_CODE_BLOCK = register("imitator_logic_code_block",
			PuzzleCodeModBlocks.IMITATOR_LOGIC_CODE_BLOCK, ImitatorLogicCodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> TELEPORTER_LOGIC_CODE_BLOCK = register("teleporter_logic_code_block",
			PuzzleCodeModBlocks.TELEPORTER_LOGIC_CODE_BLOCK, TeleporterLogicCodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> HP_OF_ENTITY_TO_NUMBER_CODE_BLOCK = register("hp_of_entity_to_number_code_block",
			PuzzleCodeModBlocks.HP_OF_ENTITY_TO_NUMBER_CODE_BLOCK, HPOfEntityToNumberCodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> MAX_HP_OF_ENTITY_TO_NUMBER_CODE_BLOCK = register("max_hp_of_entity_to_number_code_block",
			PuzzleCodeModBlocks.MAX_HP_OF_ENTITY_TO_NUMBER_CODE_BLOCK, MaxHPOfEntityToNumberCodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> TEXT_CODE_BLOCK = register("text_code_block", PuzzleCodeModBlocks.TEXT_CODE_BLOCK,
			TextCodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SURVIVAL_TEXT_CODE_BLOCK = register("survival_text_code_block",
			PuzzleCodeModBlocks.SURVIVAL_TEXT_CODE_BLOCK, SurvivalTextCodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CHAIN_TEXT_CODE_BLOCK = register("chain_text_code_block",
			PuzzleCodeModBlocks.CHAIN_TEXT_CODE_BLOCK, ChainTextCodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> MESSAGER_BLOCK = register("messager_block", PuzzleCodeModBlocks.MESSAGER_BLOCK,
			MessagerBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> TITLE_TEXT_CODE_BLOCK = register("title_text_code_block",
			PuzzleCodeModBlocks.TITLE_TEXT_CODE_BLOCK, TitleTextCodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> COMMAND_CODE_BLOCK = register("command_code_block", PuzzleCodeModBlocks.COMMAND_CODE_BLOCK,
			CommandCodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> TRANSFER_TEXT_CODE_BLOCK = register("transfer_text_code_block",
			PuzzleCodeModBlocks.TRANSFER_TEXT_CODE_BLOCK, TransferTextCodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> LEFT_TRANSFER_TEXT_CODE_BLOCK = register("left_transfer_text_code_block",
			PuzzleCodeModBlocks.LEFT_TRANSFER_TEXT_CODE_BLOCK, LeftTransferTextCodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> RIGHT_TRANSFER_TEXT_CODE_BLOCK = register("right_transfer_text_code_block",
			PuzzleCodeModBlocks.RIGHT_TRANSFER_TEXT_CODE_BLOCK, RightTransferTextCodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> NBT_TO_PROPERTY_TEXT_CODE_BLOCK = register("nbt_to_property_text_code_block",
			PuzzleCodeModBlocks.NBT_TO_PROPERTY_TEXT_CODE_BLOCK, NBTToPropertyTextCodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> PROPERTY_TRANSFER_TEXT_CODE_BLOCK = register("property_transfer_text_code_block",
			PuzzleCodeModBlocks.PROPERTY_TRANSFER_TEXT_CODE_BLOCK, PropertyTransferTextCodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IMITATOR_TEXT_CODE_BLOCK = register("imitator_text_code_block",
			PuzzleCodeModBlocks.IMITATOR_TEXT_CODE_BLOCK, ImitatorTextCodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> TELEPORTER_TEXT_CODE_BLOCK = register("teleporter_text_code_block",
			PuzzleCodeModBlocks.TELEPORTER_TEXT_CODE_BLOCK, TeleporterTextCodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> ITEM_CODE_BLOCK = register("item_code_block", PuzzleCodeModBlocks.ITEM_CODE_BLOCK,
			ItemCodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SURVIVAL_ITEM_CODE_BLOCK = register("survival_item_code_block",
			PuzzleCodeModBlocks.SURVIVAL_ITEM_CODE_BLOCK, SurvivalItemCodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> CHAIN_ITEM_CODE_BLOCK = register("chain_item_code_block",
			PuzzleCodeModBlocks.CHAIN_ITEM_CODE_BLOCK, ChainItemCodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> TRANSFER_ITEM_CODE_BLOCK = register("transfer_item_code_block",
			PuzzleCodeModBlocks.TRANSFER_ITEM_CODE_BLOCK, TransferItemCodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> LEFT_TRANSFER_ITEM_CODE_BLOCK = register("left_transfer_item_code_block",
			PuzzleCodeModBlocks.LEFT_TRANSFER_ITEM_CODE_BLOCK, LeftTransferItemCodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> RIGHT_TRANSFER_ITEM_CODE_BLOCK = register("right_transfer_item_code_block",
			PuzzleCodeModBlocks.RIGHT_TRANSFER_ITEM_CODE_BLOCK, RightTransferItemCodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> IMITATOR_ITEM_CODE_BLOCK = register("imitator_item_code_block",
			PuzzleCodeModBlocks.IMITATOR_ITEM_CODE_BLOCK, ImitatorItemCodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> TELEPORTER_ITEM_CODE_BLOCK = register("teleporter_item_code_block",
			PuzzleCodeModBlocks.TELEPORTER_ITEM_CODE_BLOCK, TeleporterItemCodeBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> PUZZLE_CRAFTER = register("puzzle_crafter", PuzzleCodeModBlocks.PUZZLE_CRAFTER,
			PuzzleCrafterBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> REMOTE_MOVER_BLOCK = register("remote_mover_block", PuzzleCodeModBlocks.REMOTE_MOVER_BLOCK,
			RemoteMoverBlockBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> WALKING_DETECTOR = register("walking_detector", PuzzleCodeModBlocks.WALKING_DETECTOR,
			WalkingDetectorBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> SWITCHER_BLOCK_BLUE = register("switcher_block_blue",
			PuzzleCodeModBlocks.SWITCHER_BLOCK_BLUE, SwitcherBlockBlueBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> YELLOW_SWITCHING_BLOCK_OFF = register("yellow_switching_block_off",
			PuzzleCodeModBlocks.YELLOW_SWITCHING_BLOCK_OFF, YellowSwitchingBlockOffBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> REVERSE_YELLOW_SWITCHING_BLOCK_OFF = register("reverse_yellow_switching_block_off",
			PuzzleCodeModBlocks.REVERSE_YELLOW_SWITCHING_BLOCK_OFF, ReverseYellowSwitchingBlockOffBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> WALKING_SWITCHING_BLOCK_OFF = register("walking_switching_block_off",
			PuzzleCodeModBlocks.WALKING_SWITCHING_BLOCK_OFF, WalkingSwitchingBlockOffBlockEntity::new);
	public static final RegistryObject<BlockEntityType<?>> BLOCK_ENTITY_PLACER_BLOCK = register("block_entity_placer_block",
			PuzzleCodeModBlocks.BLOCK_ENTITY_PLACER_BLOCK, BlockEntityPlacerBlockBlockEntity::new);

	private static RegistryObject<BlockEntityType<?>> register(String registryname, RegistryObject<Block> block,
			BlockEntityType.BlockEntitySupplier<?> supplier) {
		return REGISTRY.register(registryname, () -> BlockEntityType.Builder.of(supplier, block.get()).build(null));
	}
}
