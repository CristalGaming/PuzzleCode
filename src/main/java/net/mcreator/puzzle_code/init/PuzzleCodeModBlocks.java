
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.puzzle_code.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.level.block.Block;

import net.mcreator.puzzle_code.block.YellowSwitchingSlabOffBlock;
import net.mcreator.puzzle_code.block.YellowSwitchingSlabBlock;
import net.mcreator.puzzle_code.block.YellowSwitchingBlockOffBlock;
import net.mcreator.puzzle_code.block.YellowSwitchingBlockBlock;
import net.mcreator.puzzle_code.block.YellowSwitcherEffectStairsBlock;
import net.mcreator.puzzle_code.block.YellowSwitcherEffectSlabBlock;
import net.mcreator.puzzle_code.block.YellowSwitcherEffectBlockBlock;
import net.mcreator.puzzle_code.block.YearNumberCodeBlockBlock;
import net.mcreator.puzzle_code.block.XorLogicCodeBlockBlock;
import net.mcreator.puzzle_code.block.WitherEffectStairsBlock;
import net.mcreator.puzzle_code.block.WitherEffectSlabBlock;
import net.mcreator.puzzle_code.block.WitherEffectBlockBlock;
import net.mcreator.puzzle_code.block.WeaknessEffectStairsBlock;
import net.mcreator.puzzle_code.block.WeaknessEffectSlabBlock;
import net.mcreator.puzzle_code.block.WeaknessEffectBlockBlock;
import net.mcreator.puzzle_code.block.WaterBreathingEffectStairsBlock;
import net.mcreator.puzzle_code.block.WaterBreathingEffectSlabBlock;
import net.mcreator.puzzle_code.block.WaterBreathingEffectBlockBlock;
import net.mcreator.puzzle_code.block.WalkingSwitchingBlockOffBlock;
import net.mcreator.puzzle_code.block.WalkingSwitchingBlockBlock;
import net.mcreator.puzzle_code.block.WalkingDetectorBlock;
import net.mcreator.puzzle_code.block.UnluckEffectStairsBlock;
import net.mcreator.puzzle_code.block.UnluckEffectSlabBlock;
import net.mcreator.puzzle_code.block.UnluckEffectBlockBlock;
import net.mcreator.puzzle_code.block.UnequalTextCodeBlockBlock;
import net.mcreator.puzzle_code.block.UnequalNumberCodeBlockBlock;
import net.mcreator.puzzle_code.block.UnequalLogicCodeBlockBlock;
import net.mcreator.puzzle_code.block.UnequalItemCodeBlockBlock;
import net.mcreator.puzzle_code.block.TransferTextCodeBlockBlock;
import net.mcreator.puzzle_code.block.TransferNumberCodeBlockBlock;
import net.mcreator.puzzle_code.block.TransferLogicCodeBlockBlock;
import net.mcreator.puzzle_code.block.TransferItemCodeBlockBlock;
import net.mcreator.puzzle_code.block.TitleTextCodeBlockBlock;
import net.mcreator.puzzle_code.block.TimedSwitchingBlockOffBlock;
import net.mcreator.puzzle_code.block.TimedSwitchingBlockBlock;
import net.mcreator.puzzle_code.block.TextToNumberCodeBlockBlock;
import net.mcreator.puzzle_code.block.TextCodeBlockBlock;
import net.mcreator.puzzle_code.block.TeleporterTextCodeBlockBlock;
import net.mcreator.puzzle_code.block.TeleporterNumberCodeBlockBlock;
import net.mcreator.puzzle_code.block.TeleporterLogicCodeBlockBlock;
import net.mcreator.puzzle_code.block.TeleporterItemCodeBlockBlock;
import net.mcreator.puzzle_code.block.SwitchingBlockRedBlock;
import net.mcreator.puzzle_code.block.SwitcherBlockBlueBlock;
import net.mcreator.puzzle_code.block.SurvivalTextCodeBlockBlock;
import net.mcreator.puzzle_code.block.SurvivalNumberCodeBlockBlock;
import net.mcreator.puzzle_code.block.SurvivalLogicCodeBlockBlock;
import net.mcreator.puzzle_code.block.SurvivalItemCodeBlockBlock;
import net.mcreator.puzzle_code.block.SubstractionNumberCodeBlockBlock;
import net.mcreator.puzzle_code.block.StrengthEffectStairsBlock;
import net.mcreator.puzzle_code.block.StrengthEffectSlabBlock;
import net.mcreator.puzzle_code.block.StrengthEffectBlockBlock;
import net.mcreator.puzzle_code.block.SpeedLingeringBlockBlock;
import net.mcreator.puzzle_code.block.SpeedEffectStairsBlock;
import net.mcreator.puzzle_code.block.SpeedEffectSlabBlock;
import net.mcreator.puzzle_code.block.SpeedEffectBlockBlock;
import net.mcreator.puzzle_code.block.SpeedChangerBlockBlock;
import net.mcreator.puzzle_code.block.SpeedAcceleratorBlockBlock;
import net.mcreator.puzzle_code.block.SmallerThanNumberCodeBlockBlock;
import net.mcreator.puzzle_code.block.SmallerOrEqualThanNumberCodeBlockBlock;
import net.mcreator.puzzle_code.block.SlownessEffectStairsBlock;
import net.mcreator.puzzle_code.block.SlownessEffectSlabBlock;
import net.mcreator.puzzle_code.block.SlownessEffectBlockBlock;
import net.mcreator.puzzle_code.block.SlowFallingEffectStairsBlock;
import net.mcreator.puzzle_code.block.SlowFallingEffectSlabBlock;
import net.mcreator.puzzle_code.block.SlowFallingEffectBlockBlock;
import net.mcreator.puzzle_code.block.SaturationEffectStairsBlock;
import net.mcreator.puzzle_code.block.SaturationEffectSlabBlock;
import net.mcreator.puzzle_code.block.SaturationEffectBlockBlock;
import net.mcreator.puzzle_code.block.SaturationBlockBlock;
import net.mcreator.puzzle_code.block.RoundUpNumberCodeBlockBlock;
import net.mcreator.puzzle_code.block.RoundNumberCodeBlockBlock;
import net.mcreator.puzzle_code.block.RoundDownNumberCodeBlockBlock;
import net.mcreator.puzzle_code.block.RightTransferTextCodeBlockBlock;
import net.mcreator.puzzle_code.block.RightTransferNumberCodeBlockBlock;
import net.mcreator.puzzle_code.block.RightTransferLogicCodeBlockBlock;
import net.mcreator.puzzle_code.block.RightTransferItemCodeBlockBlock;
import net.mcreator.puzzle_code.block.ReverseYellowSwitchingSlabOffBlock;
import net.mcreator.puzzle_code.block.ReverseYellowSwitchingSlabBlock;
import net.mcreator.puzzle_code.block.ReverseYellowSwitchingBlockOffBlock;
import net.mcreator.puzzle_code.block.ReverseYellowSwitchingBlockBlock;
import net.mcreator.puzzle_code.block.ReverseTimedSwitchingBlockOffBlock;
import net.mcreator.puzzle_code.block.ReverseTimedSwitchingBlockBlock;
import net.mcreator.puzzle_code.block.ResistanceEffectStairsBlock;
import net.mcreator.puzzle_code.block.ResistanceEffectSlabBlock;
import net.mcreator.puzzle_code.block.ResistanceEffectBlockBlock;
import net.mcreator.puzzle_code.block.ReplacerBlockBlock;
import net.mcreator.puzzle_code.block.RemoteMoverBlockBlock;
import net.mcreator.puzzle_code.block.RegenerationEffectStairsBlock;
import net.mcreator.puzzle_code.block.RegenerationEffectSlabBlock;
import net.mcreator.puzzle_code.block.RegenerationEffectBlockBlock;
import net.mcreator.puzzle_code.block.RedstoneToNumberConverterCodeBlockBlock;
import net.mcreator.puzzle_code.block.RedstoneToLogicCodeBlockBlock;
import net.mcreator.puzzle_code.block.RedstoneCodeBlockBlock;
import net.mcreator.puzzle_code.block.RedSwitchingSlabOffBlock;
import net.mcreator.puzzle_code.block.RedSwitchingSlabBlock;
import net.mcreator.puzzle_code.block.RedSwitchingBlockOffBlock;
import net.mcreator.puzzle_code.block.RedSwitchingBlockBlock;
import net.mcreator.puzzle_code.block.RedKillSwitchingBlockOffBlock;
import net.mcreator.puzzle_code.block.RedKillSwitchingBlockBlock;
import net.mcreator.puzzle_code.block.RedBlueSwitchingLogicGlobalBlockBlock;
import net.mcreator.puzzle_code.block.RandomizerNumberCodeBlockBlock;
import net.mcreator.puzzle_code.block.RandomizerIntegerNumberCodeBlockBlock;
import net.mcreator.puzzle_code.block.RadiansToDegreesNumberCodeBlockBlock;
import net.mcreator.puzzle_code.block.PuzzleCrafterBlock;
import net.mcreator.puzzle_code.block.PropertyTransferTextCodeBlockBlock;
import net.mcreator.puzzle_code.block.PropertyTransferNumberCodeBlockBlock;
import net.mcreator.puzzle_code.block.PropertyTransferLogicCodeBlockBlock;
import net.mcreator.puzzle_code.block.PropertyToNBTTextCodeBlockBlock;
import net.mcreator.puzzle_code.block.PropertyToNBTNumberCodeBlockBlock;
import net.mcreator.puzzle_code.block.PropertyToNBTLogicCodeBlockBlock;
import net.mcreator.puzzle_code.block.PowerNumberCodeBlockBlock;
import net.mcreator.puzzle_code.block.PoisonEffectStairsBlock;
import net.mcreator.puzzle_code.block.PoisonEffectSlabBlock;
import net.mcreator.puzzle_code.block.PoisonEffectBlockBlock;
import net.mcreator.puzzle_code.block.PlacerBlockBlock;
import net.mcreator.puzzle_code.block.PiNumberCodeBlockBlock;
import net.mcreator.puzzle_code.block.PathMovingBlockBlock;
import net.mcreator.puzzle_code.block.OrLogicCodeBlockBlock;
import net.mcreator.puzzle_code.block.OppositeTransferNumberCodeBlockBlock;
import net.mcreator.puzzle_code.block.OppositeTransferLogicCodeBlockBlock;
import net.mcreator.puzzle_code.block.NumberToTextCodeBlockBlock;
import net.mcreator.puzzle_code.block.NumberToRedstoneConverterCodeBlockBlock;
import net.mcreator.puzzle_code.block.NumberOfItemsCodeBlockBlock;
import net.mcreator.puzzle_code.block.NumberCodeBlockBlock;
import net.mcreator.puzzle_code.block.NormalStairsBlock;
import net.mcreator.puzzle_code.block.NormalSlabBlock;
import net.mcreator.puzzle_code.block.NormalBlockBlock;
import net.mcreator.puzzle_code.block.NightVisionEffectStairsBlock;
import net.mcreator.puzzle_code.block.NightVisionEffectSlabBlock;
import net.mcreator.puzzle_code.block.NightVisionEffectBlockBlock;
import net.mcreator.puzzle_code.block.NightTimeBlockBlock;
import net.mcreator.puzzle_code.block.NauseaEffectStairsBlock;
import net.mcreator.puzzle_code.block.NauseaEffectSlabBlock;
import net.mcreator.puzzle_code.block.NauseaEffectBlockBlock;
import net.mcreator.puzzle_code.block.NBTToPropertyTextCodeBlockBlock;
import net.mcreator.puzzle_code.block.NBTToPropertyNumberClodeBlockBlock;
import net.mcreator.puzzle_code.block.NBTToPropertyLogicCodeBlockBlock;
import net.mcreator.puzzle_code.block.MultiplicationNumberCodeBlockBlock;
import net.mcreator.puzzle_code.block.MovingBlockBlock;
import net.mcreator.puzzle_code.block.MonthNumberCodeBlockBlock;
import net.mcreator.puzzle_code.block.MiningFatigueEffectStairsBlock;
import net.mcreator.puzzle_code.block.MiningFatigueEffectSlabBlock;
import net.mcreator.puzzle_code.block.MiningFatigueEffectBlockBlock;
import net.mcreator.puzzle_code.block.MessagerBlockBlock;
import net.mcreator.puzzle_code.block.MergeTextCodeBlockBlock;
import net.mcreator.puzzle_code.block.MaxHPOfEntityToNumberCodeBlockBlock;
import net.mcreator.puzzle_code.block.LuckEffectStairsBlock;
import net.mcreator.puzzle_code.block.LuckEffectSlabBlock;
import net.mcreator.puzzle_code.block.LuckEffectBlockBlock;
import net.mcreator.puzzle_code.block.LogicToRedstoneCodeBlockBlock;
import net.mcreator.puzzle_code.block.LogicToNumberCodeBlockBlock;
import net.mcreator.puzzle_code.block.LogicCodeBlockBlock;
import net.mcreator.puzzle_code.block.LockedRedSwitcherBlockBlock;
import net.mcreator.puzzle_code.block.LockedBlueSwitchierBlockBlock;
import net.mcreator.puzzle_code.block.LevitationEffectStairsBlock;
import net.mcreator.puzzle_code.block.LevitationEffectSlabBlock;
import net.mcreator.puzzle_code.block.LevitationEffectBlockBlock;
import net.mcreator.puzzle_code.block.LeftTransferTextCodeBlockBlock;
import net.mcreator.puzzle_code.block.LeftTransferNumberCodeBlockBlock;
import net.mcreator.puzzle_code.block.LeftTransferLogicCodeBlockBlock;
import net.mcreator.puzzle_code.block.LeftTransferItemCodeBlockBlock;
import net.mcreator.puzzle_code.block.LadderBlockBlock;
import net.mcreator.puzzle_code.block.KillStairsBlock;
import net.mcreator.puzzle_code.block.KillSlabBlock;
import net.mcreator.puzzle_code.block.KillBlockBlock;
import net.mcreator.puzzle_code.block.JumpBoostEffectStairsBlock;
import net.mcreator.puzzle_code.block.JumpBoostEffectSlabBlock;
import net.mcreator.puzzle_code.block.JumpBoostEffectBlockBlock;
import net.mcreator.puzzle_code.block.ItemRemoverBlockBlock;
import net.mcreator.puzzle_code.block.ItemCodeBlockBlock;
import net.mcreator.puzzle_code.block.InvisibilityEffectStairsBlock;
import net.mcreator.puzzle_code.block.InvisibilityEffectSlabBlock;
import net.mcreator.puzzle_code.block.InvisibilityEffectBlockBlock;
import net.mcreator.puzzle_code.block.InventoryReplacerBlock;
import net.mcreator.puzzle_code.block.InstantSaturationStairsBlock;
import net.mcreator.puzzle_code.block.InstantSaturationSlabBlock;
import net.mcreator.puzzle_code.block.InstantSaturationBlockBlock;
import net.mcreator.puzzle_code.block.InstantHungerStairsBlock;
import net.mcreator.puzzle_code.block.InstantHungerSlabBlock;
import net.mcreator.puzzle_code.block.InstantHungerBlockBlock;
import net.mcreator.puzzle_code.block.InstantHealthStairsBlock;
import net.mcreator.puzzle_code.block.InstantHealthSlabBlock;
import net.mcreator.puzzle_code.block.InstantHealthBlockBlock;
import net.mcreator.puzzle_code.block.InYellowSwitcherEffectStairsBlock;
import net.mcreator.puzzle_code.block.InYellowSwitcherEffectSlabBlock;
import net.mcreator.puzzle_code.block.InYellowSwitcherEffectBlockBlock;
import net.mcreator.puzzle_code.block.InWitherEffectStairsBlock;
import net.mcreator.puzzle_code.block.InWitherEffectSlabBlock;
import net.mcreator.puzzle_code.block.InWitherEffectBlockBlock;
import net.mcreator.puzzle_code.block.InWeaknessEffectStairsBlock;
import net.mcreator.puzzle_code.block.InWeaknessEffectSlabBlock;
import net.mcreator.puzzle_code.block.InWeaknessEffectBlockBlock;
import net.mcreator.puzzle_code.block.InWaterBreathingEffectStairsBlock;
import net.mcreator.puzzle_code.block.InWaterBreathingEffectSlabBlock;
import net.mcreator.puzzle_code.block.InWaterBreathingEffectBlockBlock;
import net.mcreator.puzzle_code.block.InUnluckEffectStairsBlock;
import net.mcreator.puzzle_code.block.InUnluckEffectSlabBlock;
import net.mcreator.puzzle_code.block.InUnluckEffectBlockBlock;
import net.mcreator.puzzle_code.block.InStrengthEffectStairsBlock;
import net.mcreator.puzzle_code.block.InStrengthEffectSlabBlock;
import net.mcreator.puzzle_code.block.InStrengthEffectBlockBlock;
import net.mcreator.puzzle_code.block.InSpeedEffectStairsBlock;
import net.mcreator.puzzle_code.block.InSpeedEffectSlabBlock;
import net.mcreator.puzzle_code.block.InSpeedEffectBlockBlock;
import net.mcreator.puzzle_code.block.InSlownessEffectStairsBlock;
import net.mcreator.puzzle_code.block.InSlownessEffectSlabBlock;
import net.mcreator.puzzle_code.block.InSlownessEffectBlockBlock;
import net.mcreator.puzzle_code.block.InSlowFallingEffectStairsBlock;
import net.mcreator.puzzle_code.block.InSlowFallingEffectSlabBlock;
import net.mcreator.puzzle_code.block.InSlowFallingEffectBlockBlock;
import net.mcreator.puzzle_code.block.InSaturationEffectStairsBlock;
import net.mcreator.puzzle_code.block.InSaturationEffectSlabBlock;
import net.mcreator.puzzle_code.block.InSaturationEffectBlockBlock;
import net.mcreator.puzzle_code.block.InResistanceEffectStairsBlock;
import net.mcreator.puzzle_code.block.InResistanceEffectSlabBlock;
import net.mcreator.puzzle_code.block.InResistanceEffectBlockBlock;
import net.mcreator.puzzle_code.block.InRegenerationEffectStairsBlock;
import net.mcreator.puzzle_code.block.InRegenerationEffectSlabBlock;
import net.mcreator.puzzle_code.block.InRegenerationEffectBlockBlock;
import net.mcreator.puzzle_code.block.InPoisonEffectStairsBlock;
import net.mcreator.puzzle_code.block.InPoisonEffectSlabBlock;
import net.mcreator.puzzle_code.block.InPoisonEffectBlockBlock;
import net.mcreator.puzzle_code.block.InNightVisionEffectStairsBlock;
import net.mcreator.puzzle_code.block.InNightVisionEffectSlabBlock;
import net.mcreator.puzzle_code.block.InNightVisionEffectBlockBlock;
import net.mcreator.puzzle_code.block.InNightTimeBlockBlock;
import net.mcreator.puzzle_code.block.InNauseaEffectStairsBlock;
import net.mcreator.puzzle_code.block.InNauseaEffectSlabBlock;
import net.mcreator.puzzle_code.block.InNauseaEffectBlockBlock;
import net.mcreator.puzzle_code.block.InMiningFatigueEffectStairsBlock;
import net.mcreator.puzzle_code.block.InMiningFatigueEffectSlabBlock;
import net.mcreator.puzzle_code.block.InMiningFatigueEffectBlockBlock;
import net.mcreator.puzzle_code.block.InLuckEffestStairsBlock;
import net.mcreator.puzzle_code.block.InLuckEffectSlabBlock;
import net.mcreator.puzzle_code.block.InLuckEffectBlockBlock;
import net.mcreator.puzzle_code.block.InLevitationEffectStairsBlock;
import net.mcreator.puzzle_code.block.InLevitationEffectSlabBlock;
import net.mcreator.puzzle_code.block.InLevitationEffectBlockBlock;
import net.mcreator.puzzle_code.block.InKillStairsBlock;
import net.mcreator.puzzle_code.block.InKillSlabBlock;
import net.mcreator.puzzle_code.block.InKillBlockBlock;
import net.mcreator.puzzle_code.block.InJumpBoostEffectStairsBlock;
import net.mcreator.puzzle_code.block.InJumpBoostEffectSlabBlock;
import net.mcreator.puzzle_code.block.InJumpBoostEffectBlockBlock;
import net.mcreator.puzzle_code.block.InItemRemoverBlock;
import net.mcreator.puzzle_code.block.InInvisibilityEffectStairsBlock;
import net.mcreator.puzzle_code.block.InInvisibilityEffectSlabBlock;
import net.mcreator.puzzle_code.block.InInvisibilityEffectBlockBlock;
import net.mcreator.puzzle_code.block.InInstantSaturationStairsBlock;
import net.mcreator.puzzle_code.block.InInstantSaturationSlabBlock;
import net.mcreator.puzzle_code.block.InInstantSaturationBlockBlock;
import net.mcreator.puzzle_code.block.InInstantHungerStairsBlock;
import net.mcreator.puzzle_code.block.InInstantHungerSlabBlock;
import net.mcreator.puzzle_code.block.InInstantHungerBlockBlock;
import net.mcreator.puzzle_code.block.InInstantHealthStairsBlock;
import net.mcreator.puzzle_code.block.InInstantHealthSlabBlock;
import net.mcreator.puzzle_code.block.InInstantHealthBlockBlock;
import net.mcreator.puzzle_code.block.InHungerEffectStairsBlock;
import net.mcreator.puzzle_code.block.InHungerEffectSlabBlock;
import net.mcreator.puzzle_code.block.InHungerEffectBlockBlock;
import net.mcreator.puzzle_code.block.InHasteEffectStairsBlock;
import net.mcreator.puzzle_code.block.InHasteEffectSlabBlock;
import net.mcreator.puzzle_code.block.InHasteEffectBlockBlock;
import net.mcreator.puzzle_code.block.InGlowingEffectStairsBlock;
import net.mcreator.puzzle_code.block.InGlowingEffectSlabBlock;
import net.mcreator.puzzle_code.block.InGlowingEffectBlockBlock;
import net.mcreator.puzzle_code.block.InFireResistanceEffectStairsBlock;
import net.mcreator.puzzle_code.block.InFireResistanceEffectSlabBlock;
import net.mcreator.puzzle_code.block.InFireResistanceEffectBlockBlock;
import net.mcreator.puzzle_code.block.InFireKillerStairsBlock;
import net.mcreator.puzzle_code.block.InFireKillerSlabBlock;
import net.mcreator.puzzle_code.block.InFireKillerBlockBlock;
import net.mcreator.puzzle_code.block.InEffectRemoverBlockBlock;
import net.mcreator.puzzle_code.block.InDolphinsGraceEffectStairsBlock;
import net.mcreator.puzzle_code.block.InDolphinsGraceEffectSlabBlock;
import net.mcreator.puzzle_code.block.InDolphinsGraceEffectBlockBlock;
import net.mcreator.puzzle_code.block.InDayTimeBlockBlock;
import net.mcreator.puzzle_code.block.InCheckpointStairsBlock;
import net.mcreator.puzzle_code.block.InCheckpointSlabBlock;
import net.mcreator.puzzle_code.block.InCheckpointBlockBlock;
import net.mcreator.puzzle_code.block.InBlindnessEffectStairsBlock;
import net.mcreator.puzzle_code.block.InBlindnessEffectSlabBlock;
import net.mcreator.puzzle_code.block.InBlindnessEffectBlockBlock;
import net.mcreator.puzzle_code.block.ImitatorTextCodeBlockBlock;
import net.mcreator.puzzle_code.block.ImitatorNumberCodeBlockBlock;
import net.mcreator.puzzle_code.block.ImitatorLogicCodeBlockBlock;
import net.mcreator.puzzle_code.block.ImitatorItemCodeBlockBlock;
import net.mcreator.puzzle_code.block.HungerEffectStairsBlock;
import net.mcreator.puzzle_code.block.HungerEffectSlabBlock;
import net.mcreator.puzzle_code.block.HungerEffectBlockBlock;
import net.mcreator.puzzle_code.block.HungerBlockBlock;
import net.mcreator.puzzle_code.block.HealthRegenerationBlockBlock;
import net.mcreator.puzzle_code.block.HealthChangerBlockBlock;
import net.mcreator.puzzle_code.block.HasteEffectStairsBlock;
import net.mcreator.puzzle_code.block.HasteEffectSlabBlock;
import net.mcreator.puzzle_code.block.HasteEffectBlockBlock;
import net.mcreator.puzzle_code.block.HPOfEntityToNumberCodeBlockBlock;
import net.mcreator.puzzle_code.block.GlowingEffectStairsBlock;
import net.mcreator.puzzle_code.block.GlowingEffectSlabBlock;
import net.mcreator.puzzle_code.block.GlowingEffectBlockBlock;
import net.mcreator.puzzle_code.block.FireResistanceEffectStairsBlock;
import net.mcreator.puzzle_code.block.FireResistanceEffectSlabBlock;
import net.mcreator.puzzle_code.block.FireResistanceEffectBlockBlock;
import net.mcreator.puzzle_code.block.FireKillerStairsBlock;
import net.mcreator.puzzle_code.block.FireKillerSlabBlock;
import net.mcreator.puzzle_code.block.FireKillerBlockBlock;
import net.mcreator.puzzle_code.block.FireDamageBlockBlock;
import net.mcreator.puzzle_code.block.FillerTextCodeBlockBlock;
import net.mcreator.puzzle_code.block.FillerNumberCodeBlockBlock;
import net.mcreator.puzzle_code.block.FillerLogicCodeBlockBlock;
import net.mcreator.puzzle_code.block.FillerItemCodeBlockBlock;
import net.mcreator.puzzle_code.block.FillerBlockBlock;
import net.mcreator.puzzle_code.block.FakeBlockBlock;
import net.mcreator.puzzle_code.block.EqualTextCodeBlockBlock;
import net.mcreator.puzzle_code.block.EqualNumberCodeBlockBlock;
import net.mcreator.puzzle_code.block.EqualLogicCodeBlockBlock;
import net.mcreator.puzzle_code.block.EqualItemCodeBlockBlock;
import net.mcreator.puzzle_code.block.EntityTeleporterBlockBlock;
import net.mcreator.puzzle_code.block.EntityDetectorBlock;
import net.mcreator.puzzle_code.block.EffectRemoverBlockBlock;
import net.mcreator.puzzle_code.block.DolphinsGraceEffectStairsBlock;
import net.mcreator.puzzle_code.block.DolphinsGraceEffectSlabBlock;
import net.mcreator.puzzle_code.block.DolphinsGraceEffectBlockBlock;
import net.mcreator.puzzle_code.block.DivizionNumberCodeBlockBlock;
import net.mcreator.puzzle_code.block.DegreesToRadiansNumberCodeBlockBlock;
import net.mcreator.puzzle_code.block.DayTimeBlockBlock;
import net.mcreator.puzzle_code.block.DayNumberCodeBlockBlock;
import net.mcreator.puzzle_code.block.DamageBlockBlock;
import net.mcreator.puzzle_code.block.CommandCodeBlockBlock;
import net.mcreator.puzzle_code.block.ClickingSwitchingBlockOffBlock;
import net.mcreator.puzzle_code.block.ClickingSwitchingBlockBlock;
import net.mcreator.puzzle_code.block.CheckpointStairsBlock;
import net.mcreator.puzzle_code.block.CheckpointSlabBlock;
import net.mcreator.puzzle_code.block.CheckpointBlockBlock;
import net.mcreator.puzzle_code.block.ChainTextCodeBlockBlock;
import net.mcreator.puzzle_code.block.ChainNumberCodeBlockBlock;
import net.mcreator.puzzle_code.block.ChainLogicCodeBlockBlock;
import net.mcreator.puzzle_code.block.ChainItemCodeBlockBlock;
import net.mcreator.puzzle_code.block.BoxBlock;
import net.mcreator.puzzle_code.block.BouncyBlockBlock;
import net.mcreator.puzzle_code.block.BlueSwitcingSlabBlock;
import net.mcreator.puzzle_code.block.BlueSwitchingSlabOffBlock;
import net.mcreator.puzzle_code.block.BlueSwitchingBlockOffBlock;
import net.mcreator.puzzle_code.block.BlueSwitchingBlockBlock;
import net.mcreator.puzzle_code.block.BlueKillSwitchingBlockOffBlock;
import net.mcreator.puzzle_code.block.BlueKillSwitchingBlockBlock;
import net.mcreator.puzzle_code.block.BlockyWorldPortalBlock;
import net.mcreator.puzzle_code.block.BlockEntityPlacerBlockBlock;
import net.mcreator.puzzle_code.block.BlindnessEffectStairsBlock;
import net.mcreator.puzzle_code.block.BlindnessEffectSlabBlock;
import net.mcreator.puzzle_code.block.BlindnessEffectBlockBlock;
import net.mcreator.puzzle_code.block.BiggerThanNumberCodeBlockBlock;
import net.mcreator.puzzle_code.block.BiggerOrEqualThanNumberCodeBlockBlock;
import net.mcreator.puzzle_code.block.AndLogicCodeBlockBlock;
import net.mcreator.puzzle_code.block.AdvencedTimeBlockBlock;
import net.mcreator.puzzle_code.block.AdvancedPlacerBlockBlock;
import net.mcreator.puzzle_code.block.AdditionNumberCodeBlockBlock;
import net.mcreator.puzzle_code.block.ABlockIsPlacedGlobalBlockBlock;
import net.mcreator.puzzle_code.block.ABlockIsBrokenGlobalBlockBlock;
import net.mcreator.puzzle_code.PuzzleCodeMod;

public class PuzzleCodeModBlocks {
	public static final DeferredRegister<Block> REGISTRY = DeferredRegister.create(ForgeRegistries.BLOCKS, PuzzleCodeMod.MODID);
	public static final RegistryObject<Block> NORMAL_BLOCK = REGISTRY.register("normal_block", () -> new NormalBlockBlock());
	public static final RegistryObject<Block> NORMAL_SLAB = REGISTRY.register("normal_slab", () -> new NormalSlabBlock());
	public static final RegistryObject<Block> NORMAL_STAIRS = REGISTRY.register("normal_stairs", () -> new NormalStairsBlock());
	public static final RegistryObject<Block> CHECKPOINT_BLOCK = REGISTRY.register("checkpoint_block", () -> new CheckpointBlockBlock());
	public static final RegistryObject<Block> CHECKPOINT_STAIRS = REGISTRY.register("checkpoint_stairs", () -> new CheckpointStairsBlock());
	public static final RegistryObject<Block> CHECKPOINT_SLAB = REGISTRY.register("checkpoint_slab", () -> new CheckpointSlabBlock());
	public static final RegistryObject<Block> IN_CHECKPOINT_BLOCK = REGISTRY.register("in_checkpoint_block", () -> new InCheckpointBlockBlock());
	public static final RegistryObject<Block> IN_CHECKPOINT_STAIRS = REGISTRY.register("in_checkpoint_stairs", () -> new InCheckpointStairsBlock());
	public static final RegistryObject<Block> IN_CHECKPOINT_SLAB = REGISTRY.register("in_checkpoint_slab", () -> new InCheckpointSlabBlock());
	public static final RegistryObject<Block> JUMP_BOOST_EFFECT_BLOCK = REGISTRY.register("jump_boost_effect_block",
			() -> new JumpBoostEffectBlockBlock());
	public static final RegistryObject<Block> JUMP_BOOST_EFFECT_STAIRS = REGISTRY.register("jump_boost_effect_stairs",
			() -> new JumpBoostEffectStairsBlock());
	public static final RegistryObject<Block> JUMP_BOOST_EFFECT_SLAB = REGISTRY.register("jump_boost_effect_slab",
			() -> new JumpBoostEffectSlabBlock());
	public static final RegistryObject<Block> IN_JUMP_BOOST_EFFECT_BLOCK = REGISTRY.register("in_jump_boost_effect_block",
			() -> new InJumpBoostEffectBlockBlock());
	public static final RegistryObject<Block> IN_JUMP_BOOST_EFFECT_STAIRS = REGISTRY.register("in_jump_boost_effect_stairs",
			() -> new InJumpBoostEffectStairsBlock());
	public static final RegistryObject<Block> IN_JUMP_BOOST_EFFECT_SLAB = REGISTRY.register("in_jump_boost_effect_slab",
			() -> new InJumpBoostEffectSlabBlock());
	public static final RegistryObject<Block> SPEED_EFFECT_BLOCK = REGISTRY.register("speed_effect_block", () -> new SpeedEffectBlockBlock());
	public static final RegistryObject<Block> SPEED_EFFECT_STAIRS = REGISTRY.register("speed_effect_stairs", () -> new SpeedEffectStairsBlock());
	public static final RegistryObject<Block> SPEED_EFFECT_SLAB = REGISTRY.register("speed_effect_slab", () -> new SpeedEffectSlabBlock());
	public static final RegistryObject<Block> IN_SPEED_EFFECT_BLOCK = REGISTRY.register("in_speed_effect_block", () -> new InSpeedEffectBlockBlock());
	public static final RegistryObject<Block> IN_SPEED_EFFECT_STAIRS = REGISTRY.register("in_speed_effect_stairs",
			() -> new InSpeedEffectStairsBlock());
	public static final RegistryObject<Block> IN_SPEED_EFFECT_SLAB = REGISTRY.register("in_speed_effect_slab", () -> new InSpeedEffectSlabBlock());
	public static final RegistryObject<Block> SLOWNESS_EFFECT_BLOCK = REGISTRY.register("slowness_effect_block",
			() -> new SlownessEffectBlockBlock());
	public static final RegistryObject<Block> SLOWNESS_EFFECT_STAIRS = REGISTRY.register("slowness_effect_stairs",
			() -> new SlownessEffectStairsBlock());
	public static final RegistryObject<Block> SLOWNESS_EFFECT_SLAB = REGISTRY.register("slowness_effect_slab", () -> new SlownessEffectSlabBlock());
	public static final RegistryObject<Block> IN_SLOWNESS_EFFECT_BLOCK = REGISTRY.register("in_slowness_effect_block",
			() -> new InSlownessEffectBlockBlock());
	public static final RegistryObject<Block> IN_SLOWNESS_EFFECT_STAIRS = REGISTRY.register("in_slowness_effect_stairs",
			() -> new InSlownessEffectStairsBlock());
	public static final RegistryObject<Block> IN_SLOWNESS_EFFECT_SLAB = REGISTRY.register("in_slowness_effect_slab",
			() -> new InSlownessEffectSlabBlock());
	public static final RegistryObject<Block> POISON_EFFECT_BLOCK = REGISTRY.register("poison_effect_block", () -> new PoisonEffectBlockBlock());
	public static final RegistryObject<Block> POISON_EFFECT_STAIRS = REGISTRY.register("poison_effect_stairs", () -> new PoisonEffectStairsBlock());
	public static final RegistryObject<Block> POISON_EFFECT_SLAB = REGISTRY.register("poison_effect_slab", () -> new PoisonEffectSlabBlock());
	public static final RegistryObject<Block> IN_POISON_EFFECT_BLOCK = REGISTRY.register("in_poison_effect_block",
			() -> new InPoisonEffectBlockBlock());
	public static final RegistryObject<Block> IN_POISON_EFFECT_STAIRS = REGISTRY.register("in_poison_effect_stairs",
			() -> new InPoisonEffectStairsBlock());
	public static final RegistryObject<Block> IN_POISON_EFFECT_SLAB = REGISTRY.register("in_poison_effect_slab", () -> new InPoisonEffectSlabBlock());
	public static final RegistryObject<Block> WITHER_EFFECT_BLOCK = REGISTRY.register("wither_effect_block", () -> new WitherEffectBlockBlock());
	public static final RegistryObject<Block> WITHER_EFFECT_STAIRS = REGISTRY.register("wither_effect_stairs", () -> new WitherEffectStairsBlock());
	public static final RegistryObject<Block> WITHER_EFFECT_SLAB = REGISTRY.register("wither_effect_slab", () -> new WitherEffectSlabBlock());
	public static final RegistryObject<Block> IN_WITHER_EFFECT_BLOCK = REGISTRY.register("in_wither_effect_block",
			() -> new InWitherEffectBlockBlock());
	public static final RegistryObject<Block> IN_WITHER_EFFECT_STAIRS = REGISTRY.register("in_wither_effect_stairs",
			() -> new InWitherEffectStairsBlock());
	public static final RegistryObject<Block> IN_WITHER_EFFECT_SLAB = REGISTRY.register("in_wither_effect_slab", () -> new InWitherEffectSlabBlock());
	public static final RegistryObject<Block> REGENERATION_EFFECT_BLOCK = REGISTRY.register("regeneration_effect_block",
			() -> new RegenerationEffectBlockBlock());
	public static final RegistryObject<Block> REGENERATION_EFFECT_STAIRS = REGISTRY.register("regeneration_effect_stairs",
			() -> new RegenerationEffectStairsBlock());
	public static final RegistryObject<Block> REGENERATION_EFFECT_SLAB = REGISTRY.register("regeneration_effect_slab",
			() -> new RegenerationEffectSlabBlock());
	public static final RegistryObject<Block> IN_REGENERATION_EFFECT_BLOCK = REGISTRY.register("in_regeneration_effect_block",
			() -> new InRegenerationEffectBlockBlock());
	public static final RegistryObject<Block> IN_REGENERATION_EFFECT_STAIRS = REGISTRY.register("in_regeneration_effect_stairs",
			() -> new InRegenerationEffectStairsBlock());
	public static final RegistryObject<Block> IN_REGENERATION_EFFECT_SLAB = REGISTRY.register("in_regeneration_effect_slab",
			() -> new InRegenerationEffectSlabBlock());
	public static final RegistryObject<Block> RESISTANCE_EFFECT_BLOCK = REGISTRY.register("resistance_effect_block",
			() -> new ResistanceEffectBlockBlock());
	public static final RegistryObject<Block> RESISTANCE_EFFECT_STAIRS = REGISTRY.register("resistance_effect_stairs",
			() -> new ResistanceEffectStairsBlock());
	public static final RegistryObject<Block> RESISTANCE_EFFECT_SLAB = REGISTRY.register("resistance_effect_slab",
			() -> new ResistanceEffectSlabBlock());
	public static final RegistryObject<Block> IN_RESISTANCE_EFFECT_BLOCK = REGISTRY.register("in_resistance_effect_block",
			() -> new InResistanceEffectBlockBlock());
	public static final RegistryObject<Block> IN_RESISTANCE_EFFECT_STAIRS = REGISTRY.register("in_resistance_effect_stairs",
			() -> new InResistanceEffectStairsBlock());
	public static final RegistryObject<Block> IN_RESISTANCE_EFFECT_SLAB = REGISTRY.register("in_resistance_effect_slab",
			() -> new InResistanceEffectSlabBlock());
	public static final RegistryObject<Block> STRENGTH_EFFECT_BLOCK = REGISTRY.register("strength_effect_block",
			() -> new StrengthEffectBlockBlock());
	public static final RegistryObject<Block> STRENGTH_EFFECT_STAIRS = REGISTRY.register("strength_effect_stairs",
			() -> new StrengthEffectStairsBlock());
	public static final RegistryObject<Block> STRENGTH_EFFECT_SLAB = REGISTRY.register("strength_effect_slab", () -> new StrengthEffectSlabBlock());
	public static final RegistryObject<Block> IN_STRENGTH_EFFECT_BLOCK = REGISTRY.register("in_strength_effect_block",
			() -> new InStrengthEffectBlockBlock());
	public static final RegistryObject<Block> IN_STRENGTH_EFFECT_STAIRS = REGISTRY.register("in_strength_effect_stairs",
			() -> new InStrengthEffectStairsBlock());
	public static final RegistryObject<Block> IN_STRENGTH_EFFECT_SLAB = REGISTRY.register("in_strength_effect_slab",
			() -> new InStrengthEffectSlabBlock());
	public static final RegistryObject<Block> WEAKNESS_EFFECT_BLOCK = REGISTRY.register("weakness_effect_block",
			() -> new WeaknessEffectBlockBlock());
	public static final RegistryObject<Block> WEAKNESS_EFFECT_STAIRS = REGISTRY.register("weakness_effect_stairs",
			() -> new WeaknessEffectStairsBlock());
	public static final RegistryObject<Block> WEAKNESS_EFFECT_SLAB = REGISTRY.register("weakness_effect_slab", () -> new WeaknessEffectSlabBlock());
	public static final RegistryObject<Block> IN_WEAKNESS_EFFECT_BLOCK = REGISTRY.register("in_weakness_effect_block",
			() -> new InWeaknessEffectBlockBlock());
	public static final RegistryObject<Block> IN_WEAKNESS_EFFECT_STAIRS = REGISTRY.register("in_weakness_effect_stairs",
			() -> new InWeaknessEffectStairsBlock());
	public static final RegistryObject<Block> IN_WEAKNESS_EFFECT_SLAB = REGISTRY.register("in_weakness_effect_slab",
			() -> new InWeaknessEffectSlabBlock());
	public static final RegistryObject<Block> HASTE_EFFECT_BLOCK = REGISTRY.register("haste_effect_block", () -> new HasteEffectBlockBlock());
	public static final RegistryObject<Block> HASTE_EFFECT_STAIRS = REGISTRY.register("haste_effect_stairs", () -> new HasteEffectStairsBlock());
	public static final RegistryObject<Block> HASTE_EFFECT_SLAB = REGISTRY.register("haste_effect_slab", () -> new HasteEffectSlabBlock());
	public static final RegistryObject<Block> IN_HASTE_EFFECT_BLOCK = REGISTRY.register("in_haste_effect_block", () -> new InHasteEffectBlockBlock());
	public static final RegistryObject<Block> IN_HASTE_EFFECT_STAIRS = REGISTRY.register("in_haste_effect_stairs",
			() -> new InHasteEffectStairsBlock());
	public static final RegistryObject<Block> IN_HASTE_EFFECT_SLAB = REGISTRY.register("in_haste_effect_slab", () -> new InHasteEffectSlabBlock());
	public static final RegistryObject<Block> MINING_FATIGUE_EFFECT_BLOCK = REGISTRY.register("mining_fatigue_effect_block",
			() -> new MiningFatigueEffectBlockBlock());
	public static final RegistryObject<Block> MINING_FATIGUE_EFFECT_STAIRS = REGISTRY.register("mining_fatigue_effect_stairs",
			() -> new MiningFatigueEffectStairsBlock());
	public static final RegistryObject<Block> MINING_FATIGUE_EFFECT_SLAB = REGISTRY.register("mining_fatigue_effect_slab",
			() -> new MiningFatigueEffectSlabBlock());
	public static final RegistryObject<Block> IN_MINING_FATIGUE_EFFECT_BLOCK = REGISTRY.register("in_mining_fatigue_effect_block",
			() -> new InMiningFatigueEffectBlockBlock());
	public static final RegistryObject<Block> IN_MINING_FATIGUE_EFFECT_STAIRS = REGISTRY.register("in_mining_fatigue_effect_stairs",
			() -> new InMiningFatigueEffectStairsBlock());
	public static final RegistryObject<Block> IN_MINING_FATIGUE_EFFECT_SLAB = REGISTRY.register("in_mining_fatigue_effect_slab",
			() -> new InMiningFatigueEffectSlabBlock());
	public static final RegistryObject<Block> LEVITATION_EFFECT_BLOCK = REGISTRY.register("levitation_effect_block",
			() -> new LevitationEffectBlockBlock());
	public static final RegistryObject<Block> LEVITATION_EFFECT_STAIRS = REGISTRY.register("levitation_effect_stairs",
			() -> new LevitationEffectStairsBlock());
	public static final RegistryObject<Block> LEVITATION_EFFECT_SLAB = REGISTRY.register("levitation_effect_slab",
			() -> new LevitationEffectSlabBlock());
	public static final RegistryObject<Block> IN_LEVITATION_EFFECT_BLOCK = REGISTRY.register("in_levitation_effect_block",
			() -> new InLevitationEffectBlockBlock());
	public static final RegistryObject<Block> IN_LEVITATION_EFFECT_STAIRS = REGISTRY.register("in_levitation_effect_stairs",
			() -> new InLevitationEffectStairsBlock());
	public static final RegistryObject<Block> IN_LEVITATION_EFFECT_SLAB = REGISTRY.register("in_levitation_effect_slab",
			() -> new InLevitationEffectSlabBlock());
	public static final RegistryObject<Block> SLOW_FALLING_EFFECT_BLOCK = REGISTRY.register("slow_falling_effect_block",
			() -> new SlowFallingEffectBlockBlock());
	public static final RegistryObject<Block> SLOW_FALLING_EFFECT_STAIRS = REGISTRY.register("slow_falling_effect_stairs",
			() -> new SlowFallingEffectStairsBlock());
	public static final RegistryObject<Block> SLOW_FALLING_EFFECT_SLAB = REGISTRY.register("slow_falling_effect_slab",
			() -> new SlowFallingEffectSlabBlock());
	public static final RegistryObject<Block> IN_SLOW_FALLING_EFFECT_BLOCK = REGISTRY.register("in_slow_falling_effect_block",
			() -> new InSlowFallingEffectBlockBlock());
	public static final RegistryObject<Block> IN_SLOW_FALLING_EFFECT_STAIRS = REGISTRY.register("in_slow_falling_effect_stairs",
			() -> new InSlowFallingEffectStairsBlock());
	public static final RegistryObject<Block> IN_SLOW_FALLING_EFFECT_SLAB = REGISTRY.register("in_slow_falling_effect_slab",
			() -> new InSlowFallingEffectSlabBlock());
	public static final RegistryObject<Block> INVISIBILITY_EFFECT_BLOCK = REGISTRY.register("invisibility_effect_block",
			() -> new InvisibilityEffectBlockBlock());
	public static final RegistryObject<Block> INVISIBILITY_EFFECT_STAIRS = REGISTRY.register("invisibility_effect_stairs",
			() -> new InvisibilityEffectStairsBlock());
	public static final RegistryObject<Block> INVISIBILITY_EFFECT_SLAB = REGISTRY.register("invisibility_effect_slab",
			() -> new InvisibilityEffectSlabBlock());
	public static final RegistryObject<Block> IN_INVISIBILITY_EFFECT_BLOCK = REGISTRY.register("in_invisibility_effect_block",
			() -> new InInvisibilityEffectBlockBlock());
	public static final RegistryObject<Block> IN_INVISIBILITY_EFFECT_STAIRS = REGISTRY.register("in_invisibility_effect_stairs",
			() -> new InInvisibilityEffectStairsBlock());
	public static final RegistryObject<Block> IN_INVISIBILITY_EFFECT_SLAB = REGISTRY.register("in_invisibility_effect_slab",
			() -> new InInvisibilityEffectSlabBlock());
	public static final RegistryObject<Block> GLOWING_EFFECT_BLOCK = REGISTRY.register("glowing_effect_block", () -> new GlowingEffectBlockBlock());
	public static final RegistryObject<Block> GLOWING_EFFECT_STAIRS = REGISTRY.register("glowing_effect_stairs",
			() -> new GlowingEffectStairsBlock());
	public static final RegistryObject<Block> GLOWING_EFFECT_SLAB = REGISTRY.register("glowing_effect_slab", () -> new GlowingEffectSlabBlock());
	public static final RegistryObject<Block> IN_GLOWING_EFFECT_BLOCK = REGISTRY.register("in_glowing_effect_block",
			() -> new InGlowingEffectBlockBlock());
	public static final RegistryObject<Block> IN_GLOWING_EFFECT_STAIRS = REGISTRY.register("in_glowing_effect_stairs",
			() -> new InGlowingEffectStairsBlock());
	public static final RegistryObject<Block> IN_GLOWING_EFFECT_SLAB = REGISTRY.register("in_glowing_effect_slab",
			() -> new InGlowingEffectSlabBlock());
	public static final RegistryObject<Block> FIRE_RESISTANCE_EFFECT_BLOCK = REGISTRY.register("fire_resistance_effect_block",
			() -> new FireResistanceEffectBlockBlock());
	public static final RegistryObject<Block> FIRE_RESISTANCE_EFFECT_STAIRS = REGISTRY.register("fire_resistance_effect_stairs",
			() -> new FireResistanceEffectStairsBlock());
	public static final RegistryObject<Block> FIRE_RESISTANCE_EFFECT_SLAB = REGISTRY.register("fire_resistance_effect_slab",
			() -> new FireResistanceEffectSlabBlock());
	public static final RegistryObject<Block> IN_FIRE_RESISTANCE_EFFECT_BLOCK = REGISTRY.register("in_fire_resistance_effect_block",
			() -> new InFireResistanceEffectBlockBlock());
	public static final RegistryObject<Block> IN_FIRE_RESISTANCE_EFFECT_STAIRS = REGISTRY.register("in_fire_resistance_effect_stairs",
			() -> new InFireResistanceEffectStairsBlock());
	public static final RegistryObject<Block> IN_FIRE_RESISTANCE_EFFECT_SLAB = REGISTRY.register("in_fire_resistance_effect_slab",
			() -> new InFireResistanceEffectSlabBlock());
	public static final RegistryObject<Block> WATER_BREATHING_EFFECT_BLOCK = REGISTRY.register("water_breathing_effect_block",
			() -> new WaterBreathingEffectBlockBlock());
	public static final RegistryObject<Block> WATER_BREATHING_EFFECT_STAIRS = REGISTRY.register("water_breathing_effect_stairs",
			() -> new WaterBreathingEffectStairsBlock());
	public static final RegistryObject<Block> WATER_BREATHING_EFFECT_SLAB = REGISTRY.register("water_breathing_effect_slab",
			() -> new WaterBreathingEffectSlabBlock());
	public static final RegistryObject<Block> IN_WATER_BREATHING_EFFECT_BLOCK = REGISTRY.register("in_water_breathing_effect_block",
			() -> new InWaterBreathingEffectBlockBlock());
	public static final RegistryObject<Block> IN_WATER_BREATHING_EFFECT_STAIRS = REGISTRY.register("in_water_breathing_effect_stairs",
			() -> new InWaterBreathingEffectStairsBlock());
	public static final RegistryObject<Block> IN_WATER_BREATHING_EFFECT_SLAB = REGISTRY.register("in_water_breathing_effect_slab",
			() -> new InWaterBreathingEffectSlabBlock());
	public static final RegistryObject<Block> DOLPHINS_GRACE_EFFECT_BLOCK = REGISTRY.register("dolphins_grace_effect_block",
			() -> new DolphinsGraceEffectBlockBlock());
	public static final RegistryObject<Block> DOLPHINS_GRACE_EFFECT_STAIRS = REGISTRY.register("dolphins_grace_effect_stairs",
			() -> new DolphinsGraceEffectStairsBlock());
	public static final RegistryObject<Block> DOLPHINS_GRACE_EFFECT_SLAB = REGISTRY.register("dolphins_grace_effect_slab",
			() -> new DolphinsGraceEffectSlabBlock());
	public static final RegistryObject<Block> IN_DOLPHINS_GRACE_EFFECT_BLOCK = REGISTRY.register("in_dolphins_grace_effect_block",
			() -> new InDolphinsGraceEffectBlockBlock());
	public static final RegistryObject<Block> IN_DOLPHINS_GRACE_EFFECT_STAIRS = REGISTRY.register("in_dolphins_grace_effect_stairs",
			() -> new InDolphinsGraceEffectStairsBlock());
	public static final RegistryObject<Block> IN_DOLPHINS_GRACE_EFFECT_SLAB = REGISTRY.register("in_dolphins_grace_effect_slab",
			() -> new InDolphinsGraceEffectSlabBlock());
	public static final RegistryObject<Block> BLINDNESS_EFFECT_BLOCK = REGISTRY.register("blindness_effect_block",
			() -> new BlindnessEffectBlockBlock());
	public static final RegistryObject<Block> BLINDNESS_EFFECT_STAIRS = REGISTRY.register("blindness_effect_stairs",
			() -> new BlindnessEffectStairsBlock());
	public static final RegistryObject<Block> BLINDNESS_EFFECT_SLAB = REGISTRY.register("blindness_effect_slab",
			() -> new BlindnessEffectSlabBlock());
	public static final RegistryObject<Block> IN_BLINDNESS_EFFECT_BLOCK = REGISTRY.register("in_blindness_effect_block",
			() -> new InBlindnessEffectBlockBlock());
	public static final RegistryObject<Block> IN_BLINDNESS_EFFECT_STAIRS = REGISTRY.register("in_blindness_effect_stairs",
			() -> new InBlindnessEffectStairsBlock());
	public static final RegistryObject<Block> IN_BLINDNESS_EFFECT_SLAB = REGISTRY.register("in_blindness_effect_slab",
			() -> new InBlindnessEffectSlabBlock());
	public static final RegistryObject<Block> NAUSEA_EFFECT_BLOCK = REGISTRY.register("nausea_effect_block", () -> new NauseaEffectBlockBlock());
	public static final RegistryObject<Block> NAUSEA_EFFECT_STAIRS = REGISTRY.register("nausea_effect_stairs", () -> new NauseaEffectStairsBlock());
	public static final RegistryObject<Block> NAUSEA_EFFECT_SLAB = REGISTRY.register("nausea_effect_slab", () -> new NauseaEffectSlabBlock());
	public static final RegistryObject<Block> IN_NAUSEA_EFFECT_BLOCK = REGISTRY.register("in_nausea_effect_block",
			() -> new InNauseaEffectBlockBlock());
	public static final RegistryObject<Block> IN_NAUSEA_EFFECT_STAIRS = REGISTRY.register("in_nausea_effect_stairs",
			() -> new InNauseaEffectStairsBlock());
	public static final RegistryObject<Block> IN_NAUSEA_EFFECT_SLAB = REGISTRY.register("in_nausea_effect_slab", () -> new InNauseaEffectSlabBlock());
	public static final RegistryObject<Block> NIGHT_VISION_EFFECT_BLOCK = REGISTRY.register("night_vision_effect_block",
			() -> new NightVisionEffectBlockBlock());
	public static final RegistryObject<Block> NIGHT_VISION_EFFECT_STAIRS = REGISTRY.register("night_vision_effect_stairs",
			() -> new NightVisionEffectStairsBlock());
	public static final RegistryObject<Block> NIGHT_VISION_EFFECT_SLAB = REGISTRY.register("night_vision_effect_slab",
			() -> new NightVisionEffectSlabBlock());
	public static final RegistryObject<Block> IN_NIGHT_VISION_EFFECT_BLOCK = REGISTRY.register("in_night_vision_effect_block",
			() -> new InNightVisionEffectBlockBlock());
	public static final RegistryObject<Block> IN_NIGHT_VISION_EFFECT_STAIRS = REGISTRY.register("in_night_vision_effect_stairs",
			() -> new InNightVisionEffectStairsBlock());
	public static final RegistryObject<Block> IN_NIGHT_VISION_EFFECT_SLAB = REGISTRY.register("in_night_vision_effect_slab",
			() -> new InNightVisionEffectSlabBlock());
	public static final RegistryObject<Block> SATURATION_EFFECT_BLOCK = REGISTRY.register("saturation_effect_block",
			() -> new SaturationEffectBlockBlock());
	public static final RegistryObject<Block> SATURATION_EFFECT_STAIRS = REGISTRY.register("saturation_effect_stairs",
			() -> new SaturationEffectStairsBlock());
	public static final RegistryObject<Block> SATURATION_EFFECT_SLAB = REGISTRY.register("saturation_effect_slab",
			() -> new SaturationEffectSlabBlock());
	public static final RegistryObject<Block> IN_SATURATION_EFFECT_BLOCK = REGISTRY.register("in_saturation_effect_block",
			() -> new InSaturationEffectBlockBlock());
	public static final RegistryObject<Block> IN_SATURATION_EFFECT_STAIRS = REGISTRY.register("in_saturation_effect_stairs",
			() -> new InSaturationEffectStairsBlock());
	public static final RegistryObject<Block> IN_SATURATION_EFFECT_SLAB = REGISTRY.register("in_saturation_effect_slab",
			() -> new InSaturationEffectSlabBlock());
	public static final RegistryObject<Block> HUNGER_EFFECT_BLOCK = REGISTRY.register("hunger_effect_block", () -> new HungerEffectBlockBlock());
	public static final RegistryObject<Block> HUNGER_EFFECT_STAIRS = REGISTRY.register("hunger_effect_stairs", () -> new HungerEffectStairsBlock());
	public static final RegistryObject<Block> HUNGER_EFFECT_SLAB = REGISTRY.register("hunger_effect_slab", () -> new HungerEffectSlabBlock());
	public static final RegistryObject<Block> IN_HUNGER_EFFECT_BLOCK = REGISTRY.register("in_hunger_effect_block",
			() -> new InHungerEffectBlockBlock());
	public static final RegistryObject<Block> IN_HUNGER_EFFECT_STAIRS = REGISTRY.register("in_hunger_effect_stairs",
			() -> new InHungerEffectStairsBlock());
	public static final RegistryObject<Block> IN_HUNGER_EFFECT_SLAB = REGISTRY.register("in_hunger_effect_slab", () -> new InHungerEffectSlabBlock());
	public static final RegistryObject<Block> YELLOW_SWITCHER_EFFECT_BLOCK = REGISTRY.register("yellow_switcher_effect_block",
			() -> new YellowSwitcherEffectBlockBlock());
	public static final RegistryObject<Block> YELLOW_SWITCHER_EFFECT_STAIRS = REGISTRY.register("yellow_switcher_effect_stairs",
			() -> new YellowSwitcherEffectStairsBlock());
	public static final RegistryObject<Block> YELLOW_SWITCHER_EFFECT_SLAB = REGISTRY.register("yellow_switcher_effect_slab",
			() -> new YellowSwitcherEffectSlabBlock());
	public static final RegistryObject<Block> IN_YELLOW_SWITCHER_EFFECT_BLOCK = REGISTRY.register("in_yellow_switcher_effect_block",
			() -> new InYellowSwitcherEffectBlockBlock());
	public static final RegistryObject<Block> IN_YELLOW_SWITCHER_EFFECT_STAIRS = REGISTRY.register("in_yellow_switcher_effect_stairs",
			() -> new InYellowSwitcherEffectStairsBlock());
	public static final RegistryObject<Block> IN_YELLOW_SWITCHER_EFFECT_SLAB = REGISTRY.register("in_yellow_switcher_effect_slab",
			() -> new InYellowSwitcherEffectSlabBlock());
	public static final RegistryObject<Block> LUCK_EFFECT_BLOCK = REGISTRY.register("luck_effect_block", () -> new LuckEffectBlockBlock());
	public static final RegistryObject<Block> LUCK_EFFECT_STAIRS = REGISTRY.register("luck_effect_stairs", () -> new LuckEffectStairsBlock());
	public static final RegistryObject<Block> LUCK_EFFECT_SLAB = REGISTRY.register("luck_effect_slab", () -> new LuckEffectSlabBlock());
	public static final RegistryObject<Block> IN_LUCK_EFFECT_BLOCK = REGISTRY.register("in_luck_effect_block", () -> new InLuckEffectBlockBlock());
	public static final RegistryObject<Block> IN_LUCK_EFFEST_STAIRS = REGISTRY.register("in_luck_effest_stairs", () -> new InLuckEffestStairsBlock());
	public static final RegistryObject<Block> IN_LUCK_EFFECT_SLAB = REGISTRY.register("in_luck_effect_slab", () -> new InLuckEffectSlabBlock());
	public static final RegistryObject<Block> UNLUCK_EFFECT_BLOCK = REGISTRY.register("unluck_effect_block", () -> new UnluckEffectBlockBlock());
	public static final RegistryObject<Block> UNLUCK_EFFECT_STAIRS = REGISTRY.register("unluck_effect_stairs", () -> new UnluckEffectStairsBlock());
	public static final RegistryObject<Block> UNLUCK_EFFECT_SLAB = REGISTRY.register("unluck_effect_slab", () -> new UnluckEffectSlabBlock());
	public static final RegistryObject<Block> IN_UNLUCK_EFFECT_BLOCK = REGISTRY.register("in_unluck_effect_block",
			() -> new InUnluckEffectBlockBlock());
	public static final RegistryObject<Block> IN_UNLUCK_EFFECT_STAIRS = REGISTRY.register("in_unluck_effect_stairs",
			() -> new InUnluckEffectStairsBlock());
	public static final RegistryObject<Block> IN_UNLUCK_EFFECT_SLAB = REGISTRY.register("in_unluck_effect_slab", () -> new InUnluckEffectSlabBlock());
	public static final RegistryObject<Block> EFFECT_REMOVER_BLOCK = REGISTRY.register("effect_remover_block", () -> new EffectRemoverBlockBlock());
	public static final RegistryObject<Block> IN_EFFECT_REMOVER_BLOCK = REGISTRY.register("in_effect_remover_block",
			() -> new InEffectRemoverBlockBlock());
	public static final RegistryObject<Block> INVENTORY_REPLACER = REGISTRY.register("inventory_replacer", () -> new InventoryReplacerBlock());
	public static final RegistryObject<Block> BOUNCY_BLOCK = REGISTRY.register("bouncy_block", () -> new BouncyBlockBlock());
	public static final RegistryObject<Block> ENTITY_TELEPORTER_BLOCK = REGISTRY.register("entity_teleporter_block",
			() -> new EntityTeleporterBlockBlock());
	public static final RegistryObject<Block> PATH_MOVING_BLOCK = REGISTRY.register("path_moving_block", () -> new PathMovingBlockBlock());
	public static final RegistryObject<Block> PLACER_BLOCK = REGISTRY.register("placer_block", () -> new PlacerBlockBlock());
	public static final RegistryObject<Block> ADVANCED_PLACER_BLOCK = REGISTRY.register("advanced_placer_block",
			() -> new AdvancedPlacerBlockBlock());
	public static final RegistryObject<Block> REPLACER_BLOCK = REGISTRY.register("replacer_block", () -> new ReplacerBlockBlock());
	public static final RegistryObject<Block> FILLER_BLOCK = REGISTRY.register("filler_block", () -> new FillerBlockBlock());
	public static final RegistryObject<Block> BLOCK_ENTITY_PLACER_BLOCK = REGISTRY.register("block_entity_placer_block",
			() -> new BlockEntityPlacerBlockBlock());
	public static final RegistryObject<Block> MOVING_BLOCK = REGISTRY.register("moving_block", () -> new MovingBlockBlock());
	public static final RegistryObject<Block> ITEM_REMOVER_BLOCK = REGISTRY.register("item_remover_block", () -> new ItemRemoverBlockBlock());
	public static final RegistryObject<Block> IN_ITEM_REMOVER = REGISTRY.register("in_item_remover", () -> new InItemRemoverBlock());
	public static final RegistryObject<Block> DAMAGE_BLOCK = REGISTRY.register("damage_block", () -> new DamageBlockBlock());
	public static final RegistryObject<Block> KILL_BLOCK = REGISTRY.register("kill_block", () -> new KillBlockBlock());
	public static final RegistryObject<Block> KILL_STAIRS = REGISTRY.register("kill_stairs", () -> new KillStairsBlock());
	public static final RegistryObject<Block> KILL_SLAB = REGISTRY.register("kill_slab", () -> new KillSlabBlock());
	public static final RegistryObject<Block> IN_KILL_BLOCK = REGISTRY.register("in_kill_block", () -> new InKillBlockBlock());
	public static final RegistryObject<Block> IN_KILL_STAIRS = REGISTRY.register("in_kill_stairs", () -> new InKillStairsBlock());
	public static final RegistryObject<Block> IN_KILL_SLAB = REGISTRY.register("in_kill_slab", () -> new InKillSlabBlock());
	public static final RegistryObject<Block> FIRE_DAMAGE_BLOCK = REGISTRY.register("fire_damage_block", () -> new FireDamageBlockBlock());
	public static final RegistryObject<Block> FIRE_KILLER_BLOCK = REGISTRY.register("fire_killer_block", () -> new FireKillerBlockBlock());
	public static final RegistryObject<Block> FIRE_KILLER_STAIRS = REGISTRY.register("fire_killer_stairs", () -> new FireKillerStairsBlock());
	public static final RegistryObject<Block> FIRE_KILLER_SLAB = REGISTRY.register("fire_killer_slab", () -> new FireKillerSlabBlock());
	public static final RegistryObject<Block> IN_FIRE_KILLER_BLOCK = REGISTRY.register("in_fire_killer_block", () -> new InFireKillerBlockBlock());
	public static final RegistryObject<Block> IN_FIRE_KILLER_STAIRS = REGISTRY.register("in_fire_killer_stairs", () -> new InFireKillerStairsBlock());
	public static final RegistryObject<Block> IN_FIRE_KILLER_SLAB = REGISTRY.register("in_fire_killer_slab", () -> new InFireKillerSlabBlock());
	public static final RegistryObject<Block> HEALTH_REGENERATION_BLOCK = REGISTRY.register("health_regeneration_block",
			() -> new HealthRegenerationBlockBlock());
	public static final RegistryObject<Block> INSTANT_HEALTH_BLOCK = REGISTRY.register("instant_health_block", () -> new InstantHealthBlockBlock());
	public static final RegistryObject<Block> INSTANT_HEALTH_STAIRS = REGISTRY.register("instant_health_stairs",
			() -> new InstantHealthStairsBlock());
	public static final RegistryObject<Block> INSTANT_HEALTH_SLAB = REGISTRY.register("instant_health_slab", () -> new InstantHealthSlabBlock());
	public static final RegistryObject<Block> IN_INSTANT_HEALTH_BLOCK = REGISTRY.register("in_instant_health_block",
			() -> new InInstantHealthBlockBlock());
	public static final RegistryObject<Block> IN_INSTANT_HEALTH_STAIRS = REGISTRY.register("in_instant_health_stairs",
			() -> new InInstantHealthStairsBlock());
	public static final RegistryObject<Block> IN_INSTANT_HEALTH_SLAB = REGISTRY.register("in_instant_health_slab",
			() -> new InInstantHealthSlabBlock());
	public static final RegistryObject<Block> HEALTH_CHANGER_BLOCK = REGISTRY.register("health_changer_block", () -> new HealthChangerBlockBlock());
	public static final RegistryObject<Block> HUNGER_BLOCK = REGISTRY.register("hunger_block", () -> new HungerBlockBlock());
	public static final RegistryObject<Block> INSTANT_HUNGER_BLOCK = REGISTRY.register("instant_hunger_block", () -> new InstantHungerBlockBlock());
	public static final RegistryObject<Block> INSTANT_HUNGER_STAIRS = REGISTRY.register("instant_hunger_stairs",
			() -> new InstantHungerStairsBlock());
	public static final RegistryObject<Block> INSTANT_HUNGER_SLAB = REGISTRY.register("instant_hunger_slab", () -> new InstantHungerSlabBlock());
	public static final RegistryObject<Block> IN_INSTANT_HUNGER_BLOCK = REGISTRY.register("in_instant_hunger_block",
			() -> new InInstantHungerBlockBlock());
	public static final RegistryObject<Block> IN_INSTANT_HUNGER_STAIRS = REGISTRY.register("in_instant_hunger_stairs",
			() -> new InInstantHungerStairsBlock());
	public static final RegistryObject<Block> IN_INSTANT_HUNGER_SLAB = REGISTRY.register("in_instant_hunger_slab",
			() -> new InInstantHungerSlabBlock());
	public static final RegistryObject<Block> SATURATION_BLOCK = REGISTRY.register("saturation_block", () -> new SaturationBlockBlock());
	public static final RegistryObject<Block> INSTANT_SATURATION_BLOCK = REGISTRY.register("instant_saturation_block",
			() -> new InstantSaturationBlockBlock());
	public static final RegistryObject<Block> INSTANT_SATURATION_STAIRS = REGISTRY.register("instant_saturation_stairs",
			() -> new InstantSaturationStairsBlock());
	public static final RegistryObject<Block> INSTANT_SATURATION_SLAB = REGISTRY.register("instant_saturation_slab",
			() -> new InstantSaturationSlabBlock());
	public static final RegistryObject<Block> IN_INSTANT_SATURATION_BLOCK = REGISTRY.register("in_instant_saturation_block",
			() -> new InInstantSaturationBlockBlock());
	public static final RegistryObject<Block> IN_INSTANT_SATURATION_STAIRS = REGISTRY.register("in_instant_saturation_stairs",
			() -> new InInstantSaturationStairsBlock());
	public static final RegistryObject<Block> IN_INSTANT_SATURATION_SLAB = REGISTRY.register("in_instant_saturation_slab",
			() -> new InInstantSaturationSlabBlock());
	public static final RegistryObject<Block> ADVENCED_TIME_BLOCK = REGISTRY.register("advenced_time_block", () -> new AdvencedTimeBlockBlock());
	public static final RegistryObject<Block> DAY_TIME_BLOCK = REGISTRY.register("day_time_block", () -> new DayTimeBlockBlock());
	public static final RegistryObject<Block> IN_DAY_TIME_BLOCK = REGISTRY.register("in_day_time_block", () -> new InDayTimeBlockBlock());
	public static final RegistryObject<Block> NIGHT_TIME_BLOCK = REGISTRY.register("night_time_block", () -> new NightTimeBlockBlock());
	public static final RegistryObject<Block> IN_NIGHT_TIME_BLOCK = REGISTRY.register("in_night_time_block", () -> new InNightTimeBlockBlock());
	public static final RegistryObject<Block> RED_SWITCHING_BLOCK = REGISTRY.register("red_switching_block", () -> new RedSwitchingBlockBlock());
	public static final RegistryObject<Block> RED_SWITCHING_SLAB = REGISTRY.register("red_switching_slab", () -> new RedSwitchingSlabBlock());
	public static final RegistryObject<Block> RED_SWITCHING_SLAB_OFF = REGISTRY.register("red_switching_slab_off",
			() -> new RedSwitchingSlabOffBlock());
	public static final RegistryObject<Block> RED_KILL_SWITCHING_BLOCK = REGISTRY.register("red_kill_switching_block",
			() -> new RedKillSwitchingBlockBlock());
	public static final RegistryObject<Block> BLUE_SWITCHING_BLOCK = REGISTRY.register("blue_switching_block", () -> new BlueSwitchingBlockBlock());
	public static final RegistryObject<Block> BLUE_SWITCING_SLAB = REGISTRY.register("blue_switcing_slab", () -> new BlueSwitcingSlabBlock());
	public static final RegistryObject<Block> BLUE_SWITCHING_SLAB_OFF = REGISTRY.register("blue_switching_slab_off",
			() -> new BlueSwitchingSlabOffBlock());
	public static final RegistryObject<Block> BLUE_KILL_SWITCHING_BLOCK = REGISTRY.register("blue_kill_switching_block",
			() -> new BlueKillSwitchingBlockBlock());
	public static final RegistryObject<Block> SWITCHING_BLOCK_RED = REGISTRY.register("switching_block_red", () -> new SwitchingBlockRedBlock());
	public static final RegistryObject<Block> LOCKED_RED_SWITCHER_BLOCK = REGISTRY.register("locked_red_switcher_block",
			() -> new LockedRedSwitcherBlockBlock());
	public static final RegistryObject<Block> LOCKED_BLUE_SWITCHIER_BLOCK = REGISTRY.register("locked_blue_switchier_block",
			() -> new LockedBlueSwitchierBlockBlock());
	public static final RegistryObject<Block> YELLOW_SWITCHING_BLOCK = REGISTRY.register("yellow_switching_block",
			() -> new YellowSwitchingBlockBlock());
	public static final RegistryObject<Block> REVERSE_YELLOW_SWITCHING_BLOCK = REGISTRY.register("reverse_yellow_switching_block",
			() -> new ReverseYellowSwitchingBlockBlock());
	public static final RegistryObject<Block> YELLOW_SWITCHING_SLAB = REGISTRY.register("yellow_switching_slab",
			() -> new YellowSwitchingSlabBlock());
	public static final RegistryObject<Block> YELLOW_SWITCHING_SLAB_OFF = REGISTRY.register("yellow_switching_slab_off",
			() -> new YellowSwitchingSlabOffBlock());
	public static final RegistryObject<Block> REVERSE_YELLOW_SWITCHING_SLAB = REGISTRY.register("reverse_yellow_switching_slab",
			() -> new ReverseYellowSwitchingSlabBlock());
	public static final RegistryObject<Block> REVERSE_YELLOW_SWITCHING_SLAB_OFF = REGISTRY.register("reverse_yellow_switching_slab_off",
			() -> new ReverseYellowSwitchingSlabOffBlock());
	public static final RegistryObject<Block> TIMED_SWITCHING_BLOCK = REGISTRY.register("timed_switching_block",
			() -> new TimedSwitchingBlockBlock());
	public static final RegistryObject<Block> REVERSE_TIMED_SWITCHING_BLOCK = REGISTRY.register("reverse_timed_switching_block",
			() -> new ReverseTimedSwitchingBlockBlock());
	public static final RegistryObject<Block> WALKING_SWITCHING_BLOCK = REGISTRY.register("walking_switching_block",
			() -> new WalkingSwitchingBlockBlock());
	public static final RegistryObject<Block> CLICKING_SWITCHING_BLOCK = REGISTRY.register("clicking_switching_block",
			() -> new ClickingSwitchingBlockBlock());
	public static final RegistryObject<Block> ENTITY_DETECTOR = REGISTRY.register("entity_detector", () -> new EntityDetectorBlock());
	public static final RegistryObject<Block> LADDER_BLOCK = REGISTRY.register("ladder_block", () -> new LadderBlockBlock());
	public static final RegistryObject<Block> FAKE_BLOCK = REGISTRY.register("fake_block", () -> new FakeBlockBlock());
	public static final RegistryObject<Block> A_BLOCK_IS_BROKEN_GLOBAL_BLOCK = REGISTRY.register("a_block_is_broken_global_block",
			() -> new ABlockIsBrokenGlobalBlockBlock());
	public static final RegistryObject<Block> A_BLOCK_IS_PLACED_GLOBAL_BLOCK = REGISTRY.register("a_block_is_placed_global_block",
			() -> new ABlockIsPlacedGlobalBlockBlock());
	public static final RegistryObject<Block> RED_BLUE_SWITCHING_LOGIC_GLOBAL_BLOCK = REGISTRY.register("red_blue_switching_logic_global_block",
			() -> new RedBlueSwitchingLogicGlobalBlockBlock());
	public static final RegistryObject<Block> NUMBER_CODE_BLOCK = REGISTRY.register("number_code_block", () -> new NumberCodeBlockBlock());
	public static final RegistryObject<Block> SURVIVAL_NUMBER_CODE_BLOCK = REGISTRY.register("survival_number_code_block",
			() -> new SurvivalNumberCodeBlockBlock());
	public static final RegistryObject<Block> CHAIN_NUMBER_CODE_BLOCK = REGISTRY.register("chain_number_code_block",
			() -> new ChainNumberCodeBlockBlock());
	public static final RegistryObject<Block> PI_NUMBER_CODE_BLOCK = REGISTRY.register("pi_number_code_block", () -> new PiNumberCodeBlockBlock());
	public static final RegistryObject<Block> RANDOMIZER_INTEGER_NUMBER_CODE_BLOCK = REGISTRY.register("randomizer_integer_number_code_block",
			() -> new RandomizerIntegerNumberCodeBlockBlock());
	public static final RegistryObject<Block> RANDOMIZER_NUMBER_CODE_BLOCK = REGISTRY.register("randomizer_number_code_block",
			() -> new RandomizerNumberCodeBlockBlock());
	public static final RegistryObject<Block> ADDITION_NUMBER_CODE_BLOCK = REGISTRY.register("addition_number_code_block",
			() -> new AdditionNumberCodeBlockBlock());
	public static final RegistryObject<Block> SUBSTRACTION_NUMBER_CODE_BLOCK = REGISTRY.register("substraction_number_code_block",
			() -> new SubstractionNumberCodeBlockBlock());
	public static final RegistryObject<Block> DIVIZION_NUMBER_CODE_BLOCK = REGISTRY.register("divizion_number_code_block",
			() -> new DivizionNumberCodeBlockBlock());
	public static final RegistryObject<Block> MULTIPLICATION_NUMBER_CODE_BLOCK = REGISTRY.register("multiplication_number_code_block",
			() -> new MultiplicationNumberCodeBlockBlock());
	public static final RegistryObject<Block> POWER_NUMBER_CODE_BLOCK = REGISTRY.register("power_number_code_block",
			() -> new PowerNumberCodeBlockBlock());
	public static final RegistryObject<Block> EQUAL_NUMBER_CODE_BLOCK = REGISTRY.register("equal_number_code_block",
			() -> new EqualNumberCodeBlockBlock());
	public static final RegistryObject<Block> UNEQUAL_NUMBER_CODE_BLOCK = REGISTRY.register("unequal_number_code_block",
			() -> new UnequalNumberCodeBlockBlock());
	public static final RegistryObject<Block> BIGGER_THAN_NUMBER_CODE_BLOCK = REGISTRY.register("bigger_than_number_code_block",
			() -> new BiggerThanNumberCodeBlockBlock());
	public static final RegistryObject<Block> SMALLER_THAN_NUMBER_CODE_BLOCK = REGISTRY.register("smaller_than_number_code_block",
			() -> new SmallerThanNumberCodeBlockBlock());
	public static final RegistryObject<Block> SMALLER_OR_EQUAL_THAN_NUMBER_CODE_BLOCK = REGISTRY.register("smaller_or_equal_than_number_code_block",
			() -> new SmallerOrEqualThanNumberCodeBlockBlock());
	public static final RegistryObject<Block> BIGGER_OR_EQUAL_THAN_NUMBER_CODE_BLOCK = REGISTRY.register("bigger_or_equal_than_number_code_block",
			() -> new BiggerOrEqualThanNumberCodeBlockBlock());
	public static final RegistryObject<Block> DAY_NUMBER_CODE_BLOCK = REGISTRY.register("day_number_code_block", () -> new DayNumberCodeBlockBlock());
	public static final RegistryObject<Block> MONTH_NUMBER_CODE_BLOCK = REGISTRY.register("month_number_code_block",
			() -> new MonthNumberCodeBlockBlock());
	public static final RegistryObject<Block> YEAR_NUMBER_CODE_BLOCK = REGISTRY.register("year_number_code_block",
			() -> new YearNumberCodeBlockBlock());
	public static final RegistryObject<Block> ROUND_NUMBER_CODE_BLOCK = REGISTRY.register("round_number_code_block",
			() -> new RoundNumberCodeBlockBlock());
	public static final RegistryObject<Block> ROUND_UP_NUMBER_CODE_BLOCK = REGISTRY.register("round_up_number_code_block",
			() -> new RoundUpNumberCodeBlockBlock());
	public static final RegistryObject<Block> ROUND_DOWN_NUMBER_CODE_BLOCK = REGISTRY.register("round_down_number_code_block",
			() -> new RoundDownNumberCodeBlockBlock());
	public static final RegistryObject<Block> TRANSFER_NUMBER_CODE_BLOCK = REGISTRY.register("transfer_number_code_block",
			() -> new TransferNumberCodeBlockBlock());
	public static final RegistryObject<Block> LEFT_TRANSFER_NUMBER_CODE_BLOCK = REGISTRY.register("left_transfer_number_code_block",
			() -> new LeftTransferNumberCodeBlockBlock());
	public static final RegistryObject<Block> RIGHT_TRANSFER_NUMBER_CODE_BLOCK = REGISTRY.register("right_transfer_number_code_block",
			() -> new RightTransferNumberCodeBlockBlock());
	public static final RegistryObject<Block> OPPOSITE_TRANSFER_NUMBER_CODE_BLOCK = REGISTRY.register("opposite_transfer_number_code_block",
			() -> new OppositeTransferNumberCodeBlockBlock());
	public static final RegistryObject<Block> DEGREES_TO_RADIANS_NUMBER_CODE_BLOCK = REGISTRY.register("degrees_to_radians_number_code_block",
			() -> new DegreesToRadiansNumberCodeBlockBlock());
	public static final RegistryObject<Block> RADIANS_TO_DEGREES_NUMBER_CODE_BLOCK = REGISTRY.register("radians_to_degrees_number_code_block",
			() -> new RadiansToDegreesNumberCodeBlockBlock());
	public static final RegistryObject<Block> PROPERTY_TO_NBT_NUMBER_CODE_BLOCK = REGISTRY.register("property_to_nbt_number_code_block",
			() -> new PropertyToNBTNumberCodeBlockBlock());
	public static final RegistryObject<Block> NBT_TO_PROPERTY_NUMBER_CLODE_BLOCK = REGISTRY.register("nbt_to_property_number_clode_block",
			() -> new NBTToPropertyNumberClodeBlockBlock());
	public static final RegistryObject<Block> PROPERTY_TRANSFER_NUMBER_CODE_BLOCK = REGISTRY.register("property_transfer_number_code_block",
			() -> new PropertyTransferNumberCodeBlockBlock());
	public static final RegistryObject<Block> IMITATOR_NUMBER_CODE_BLOCK = REGISTRY.register("imitator_number_code_block",
			() -> new ImitatorNumberCodeBlockBlock());
	public static final RegistryObject<Block> TELEPORTER_NUMBER_CODE_BLOCK = REGISTRY.register("teleporter_number_code_block",
			() -> new TeleporterNumberCodeBlockBlock());
	public static final RegistryObject<Block> FILLER_NUMBER_CODE_BLOCK = REGISTRY.register("filler_number_code_block",
			() -> new FillerNumberCodeBlockBlock());
	public static final RegistryObject<Block> NUMBER_TO_REDSTONE_CONVERTER_CODE_BLOCK = REGISTRY.register("number_to_redstone_converter_code_block",
			() -> new NumberToRedstoneConverterCodeBlockBlock());
	public static final RegistryObject<Block> REDSTONE_TO_NUMBER_CONVERTER_CODE_BLOCK = REGISTRY.register("redstone_to_number_converter_code_block",
			() -> new RedstoneToNumberConverterCodeBlockBlock());
	public static final RegistryObject<Block> NUMBER_TO_TEXT_CODE_BLOCK = REGISTRY.register("number_to_text_code_block",
			() -> new NumberToTextCodeBlockBlock());
	public static final RegistryObject<Block> HP_OF_ENTITY_TO_NUMBER_CODE_BLOCK = REGISTRY.register("hp_of_entity_to_number_code_block",
			() -> new HPOfEntityToNumberCodeBlockBlock());
	public static final RegistryObject<Block> MAX_HP_OF_ENTITY_TO_NUMBER_CODE_BLOCK = REGISTRY.register("max_hp_of_entity_to_number_code_block",
			() -> new MaxHPOfEntityToNumberCodeBlockBlock());
	public static final RegistryObject<Block> LOGIC_CODE_BLOCK = REGISTRY.register("logic_code_block", () -> new LogicCodeBlockBlock());
	public static final RegistryObject<Block> SURVIVAL_LOGIC_CODE_BLOCK = REGISTRY.register("survival_logic_code_block",
			() -> new SurvivalLogicCodeBlockBlock());
	public static final RegistryObject<Block> CHAIN_LOGIC_CODE_BLOCK = REGISTRY.register("chain_logic_code_block",
			() -> new ChainLogicCodeBlockBlock());
	public static final RegistryObject<Block> EQUAL_LOGIC_CODE_BLOCK = REGISTRY.register("equal_logic_code_block",
			() -> new EqualLogicCodeBlockBlock());
	public static final RegistryObject<Block> UNEQUAL_LOGIC_CODE_BLOCK = REGISTRY.register("unequal_logic_code_block",
			() -> new UnequalLogicCodeBlockBlock());
	public static final RegistryObject<Block> AND_LOGIC_CODE_BLOCK = REGISTRY.register("and_logic_code_block", () -> new AndLogicCodeBlockBlock());
	public static final RegistryObject<Block> OR_LOGIC_CODE_BLOCK = REGISTRY.register("or_logic_code_block", () -> new OrLogicCodeBlockBlock());
	public static final RegistryObject<Block> XOR_LOGIC_CODE_BLOCK = REGISTRY.register("xor_logic_code_block", () -> new XorLogicCodeBlockBlock());
	public static final RegistryObject<Block> TRANSFER_LOGIC_CODE_BLOCK = REGISTRY.register("transfer_logic_code_block",
			() -> new TransferLogicCodeBlockBlock());
	public static final RegistryObject<Block> LEFT_TRANSFER_LOGIC_CODE_BLOCK = REGISTRY.register("left_transfer_logic_code_block",
			() -> new LeftTransferLogicCodeBlockBlock());
	public static final RegistryObject<Block> RIGHT_TRANSFER_LOGIC_CODE_BLOCK = REGISTRY.register("right_transfer_logic_code_block",
			() -> new RightTransferLogicCodeBlockBlock());
	public static final RegistryObject<Block> OPPOSITE_TRANSFER_LOGIC_CODE_BLOCK = REGISTRY.register("opposite_transfer_logic_code_block",
			() -> new OppositeTransferLogicCodeBlockBlock());
	public static final RegistryObject<Block> NBT_TO_PROPERTY_LOGIC_CODE_BLOCK = REGISTRY.register("nbt_to_property_logic_code_block",
			() -> new NBTToPropertyLogicCodeBlockBlock());
	public static final RegistryObject<Block> PROPERTY_TO_NBT_LOGIC_CODE_BLOCK = REGISTRY.register("property_to_nbt_logic_code_block",
			() -> new PropertyToNBTLogicCodeBlockBlock());
	public static final RegistryObject<Block> PROPERTY_TRANSFER_LOGIC_CODE_BLOCK = REGISTRY.register("property_transfer_logic_code_block",
			() -> new PropertyTransferLogicCodeBlockBlock());
	public static final RegistryObject<Block> IMITATOR_LOGIC_CODE_BLOCK = REGISTRY.register("imitator_logic_code_block",
			() -> new ImitatorLogicCodeBlockBlock());
	public static final RegistryObject<Block> TELEPORTER_LOGIC_CODE_BLOCK = REGISTRY.register("teleporter_logic_code_block",
			() -> new TeleporterLogicCodeBlockBlock());
	public static final RegistryObject<Block> FILLER_LOGIC_CODE_BLOCK = REGISTRY.register("filler_logic_code_block",
			() -> new FillerLogicCodeBlockBlock());
	public static final RegistryObject<Block> REDSTONE_TO_LOGIC_CODE_BLOCK = REGISTRY.register("redstone_to_logic_code_block",
			() -> new RedstoneToLogicCodeBlockBlock());
	public static final RegistryObject<Block> LOGIC_TO_REDSTONE_CODE_BLOCK = REGISTRY.register("logic_to_redstone_code_block",
			() -> new LogicToRedstoneCodeBlockBlock());
	public static final RegistryObject<Block> LOGIC_TO_NUMBER_CODE_BLOCK = REGISTRY.register("logic_to_number_code_block",
			() -> new LogicToNumberCodeBlockBlock());
	public static final RegistryObject<Block> TEXT_CODE_BLOCK = REGISTRY.register("text_code_block", () -> new TextCodeBlockBlock());
	public static final RegistryObject<Block> SURVIVAL_TEXT_CODE_BLOCK = REGISTRY.register("survival_text_code_block",
			() -> new SurvivalTextCodeBlockBlock());
	public static final RegistryObject<Block> CHAIN_TEXT_CODE_BLOCK = REGISTRY.register("chain_text_code_block", () -> new ChainTextCodeBlockBlock());
	public static final RegistryObject<Block> MESSAGER_BLOCK = REGISTRY.register("messager_block", () -> new MessagerBlockBlock());
	public static final RegistryObject<Block> TITLE_TEXT_CODE_BLOCK = REGISTRY.register("title_text_code_block", () -> new TitleTextCodeBlockBlock());
	public static final RegistryObject<Block> COMMAND_CODE_BLOCK = REGISTRY.register("command_code_block", () -> new CommandCodeBlockBlock());
	public static final RegistryObject<Block> TRANSFER_TEXT_CODE_BLOCK = REGISTRY.register("transfer_text_code_block",
			() -> new TransferTextCodeBlockBlock());
	public static final RegistryObject<Block> LEFT_TRANSFER_TEXT_CODE_BLOCK = REGISTRY.register("left_transfer_text_code_block",
			() -> new LeftTransferTextCodeBlockBlock());
	public static final RegistryObject<Block> RIGHT_TRANSFER_TEXT_CODE_BLOCK = REGISTRY.register("right_transfer_text_code_block",
			() -> new RightTransferTextCodeBlockBlock());
	public static final RegistryObject<Block> MERGE_TEXT_CODE_BLOCK = REGISTRY.register("merge_text_code_block", () -> new MergeTextCodeBlockBlock());
	public static final RegistryObject<Block> EQUAL_TEXT_CODE_BLOCK = REGISTRY.register("equal_text_code_block", () -> new EqualTextCodeBlockBlock());
	public static final RegistryObject<Block> UNEQUAL_TEXT_CODE_BLOCK = REGISTRY.register("unequal_text_code_block",
			() -> new UnequalTextCodeBlockBlock());
	public static final RegistryObject<Block> NBT_TO_PROPERTY_TEXT_CODE_BLOCK = REGISTRY.register("nbt_to_property_text_code_block",
			() -> new NBTToPropertyTextCodeBlockBlock());
	public static final RegistryObject<Block> PROPERTY_TO_NBT_TEXT_CODE_BLOCK = REGISTRY.register("property_to_nbt_text_code_block",
			() -> new PropertyToNBTTextCodeBlockBlock());
	public static final RegistryObject<Block> PROPERTY_TRANSFER_TEXT_CODE_BLOCK = REGISTRY.register("property_transfer_text_code_block",
			() -> new PropertyTransferTextCodeBlockBlock());
	public static final RegistryObject<Block> IMITATOR_TEXT_CODE_BLOCK = REGISTRY.register("imitator_text_code_block",
			() -> new ImitatorTextCodeBlockBlock());
	public static final RegistryObject<Block> TELEPORTER_TEXT_CODE_BLOCK = REGISTRY.register("teleporter_text_code_block",
			() -> new TeleporterTextCodeBlockBlock());
	public static final RegistryObject<Block> FILLER_TEXT_CODE_BLOCK = REGISTRY.register("filler_text_code_block",
			() -> new FillerTextCodeBlockBlock());
	public static final RegistryObject<Block> TEXT_TO_NUMBER_CODE_BLOCK = REGISTRY.register("text_to_number_code_block",
			() -> new TextToNumberCodeBlockBlock());
	public static final RegistryObject<Block> ITEM_CODE_BLOCK = REGISTRY.register("item_code_block", () -> new ItemCodeBlockBlock());
	public static final RegistryObject<Block> SURVIVAL_ITEM_CODE_BLOCK = REGISTRY.register("survival_item_code_block",
			() -> new SurvivalItemCodeBlockBlock());
	public static final RegistryObject<Block> CHAIN_ITEM_CODE_BLOCK = REGISTRY.register("chain_item_code_block", () -> new ChainItemCodeBlockBlock());
	public static final RegistryObject<Block> TRANSFER_ITEM_CODE_BLOCK = REGISTRY.register("transfer_item_code_block",
			() -> new TransferItemCodeBlockBlock());
	public static final RegistryObject<Block> LEFT_TRANSFER_ITEM_CODE_BLOCK = REGISTRY.register("left_transfer_item_code_block",
			() -> new LeftTransferItemCodeBlockBlock());
	public static final RegistryObject<Block> RIGHT_TRANSFER_ITEM_CODE_BLOCK = REGISTRY.register("right_transfer_item_code_block",
			() -> new RightTransferItemCodeBlockBlock());
	public static final RegistryObject<Block> EQUAL_ITEM_CODE_BLOCK = REGISTRY.register("equal_item_code_block", () -> new EqualItemCodeBlockBlock());
	public static final RegistryObject<Block> UNEQUAL_ITEM_CODE_BLOCK = REGISTRY.register("unequal_item_code_block",
			() -> new UnequalItemCodeBlockBlock());
	public static final RegistryObject<Block> IMITATOR_ITEM_CODE_BLOCK = REGISTRY.register("imitator_item_code_block",
			() -> new ImitatorItemCodeBlockBlock());
	public static final RegistryObject<Block> TELEPORTER_ITEM_CODE_BLOCK = REGISTRY.register("teleporter_item_code_block",
			() -> new TeleporterItemCodeBlockBlock());
	public static final RegistryObject<Block> FILLER_ITEM_CODE_BLOCK = REGISTRY.register("filler_item_code_block",
			() -> new FillerItemCodeBlockBlock());
	public static final RegistryObject<Block> NUMBER_OF_ITEMS_CODE_BLOCK = REGISTRY.register("number_of_items_code_block",
			() -> new NumberOfItemsCodeBlockBlock());
	public static final RegistryObject<Block> PUZZLE_CRAFTER = REGISTRY.register("puzzle_crafter", () -> new PuzzleCrafterBlock());
	public static final RegistryObject<Block> BLOCKY_WORLD_PORTAL = REGISTRY.register("blocky_world_portal", () -> new BlockyWorldPortalBlock());
	public static final RegistryObject<Block> BOX = REGISTRY.register("box", () -> new BoxBlock());
	public static final RegistryObject<Block> SPEED_ACCELERATOR_BLOCK = REGISTRY.register("speed_accelerator_block",
			() -> new SpeedAcceleratorBlockBlock());
	public static final RegistryObject<Block> SPEED_LINGERING_BLOCK = REGISTRY.register("speed_lingering_block",
			() -> new SpeedLingeringBlockBlock());
	public static final RegistryObject<Block> REMOTE_MOVER_BLOCK = REGISTRY.register("remote_mover_block", () -> new RemoteMoverBlockBlock());
	public static final RegistryObject<Block> WALKING_DETECTOR = REGISTRY.register("walking_detector", () -> new WalkingDetectorBlock());
	public static final RegistryObject<Block> SPEED_CHANGER_BLOCK = REGISTRY.register("speed_changer_block", () -> new SpeedChangerBlockBlock());
	public static final RegistryObject<Block> TIMED_SWITCHING_BLOCK_OFF = REGISTRY.register("timed_switching_block_off",
			() -> new TimedSwitchingBlockOffBlock());
	public static final RegistryObject<Block> REVERSE_TIMED_SWITCHING_BLOCK_OFF = REGISTRY.register("reverse_timed_switching_block_off",
			() -> new ReverseTimedSwitchingBlockOffBlock());
	public static final RegistryObject<Block> SWITCHER_BLOCK_BLUE = REGISTRY.register("switcher_block_blue", () -> new SwitcherBlockBlueBlock());
	public static final RegistryObject<Block> BLUE_SWITCHING_BLOCK_OFF = REGISTRY.register("blue_switching_block_off",
			() -> new BlueSwitchingBlockOffBlock());
	public static final RegistryObject<Block> RED_SWITCHING_BLOCK_OFF = REGISTRY.register("red_switching_block_off",
			() -> new RedSwitchingBlockOffBlock());
	public static final RegistryObject<Block> BLUE_KILL_SWITCHING_BLOCK_OFF = REGISTRY.register("blue_kill_switching_block_off",
			() -> new BlueKillSwitchingBlockOffBlock());
	public static final RegistryObject<Block> RED_KILL_SWITCHING_BLOCK_OFF = REGISTRY.register("red_kill_switching_block_off",
			() -> new RedKillSwitchingBlockOffBlock());
	public static final RegistryObject<Block> YELLOW_SWITCHING_BLOCK_OFF = REGISTRY.register("yellow_switching_block_off",
			() -> new YellowSwitchingBlockOffBlock());
	public static final RegistryObject<Block> REVERSE_YELLOW_SWITCHING_BLOCK_OFF = REGISTRY.register("reverse_yellow_switching_block_off",
			() -> new ReverseYellowSwitchingBlockOffBlock());
	public static final RegistryObject<Block> WALKING_SWITCHING_BLOCK_OFF = REGISTRY.register("walking_switching_block_off",
			() -> new WalkingSwitchingBlockOffBlock());
	public static final RegistryObject<Block> CLICKING_SWITCHING_BLOCK_OFF = REGISTRY.register("clicking_switching_block_off",
			() -> new ClickingSwitchingBlockOffBlock());
	public static final RegistryObject<Block> REDSTONE_CODE_BLOCK = REGISTRY.register("redstone_code_block", () -> new RedstoneCodeBlockBlock());

	@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class ClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			InCheckpointBlockBlock.registerRenderLayer();
			InCheckpointStairsBlock.registerRenderLayer();
			InCheckpointSlabBlock.registerRenderLayer();
			InJumpBoostEffectBlockBlock.registerRenderLayer();
			InJumpBoostEffectStairsBlock.registerRenderLayer();
			InJumpBoostEffectSlabBlock.registerRenderLayer();
			InSpeedEffectBlockBlock.registerRenderLayer();
			InSpeedEffectStairsBlock.registerRenderLayer();
			InSpeedEffectSlabBlock.registerRenderLayer();
			InSlownessEffectBlockBlock.registerRenderLayer();
			InSlownessEffectStairsBlock.registerRenderLayer();
			InSlownessEffectSlabBlock.registerRenderLayer();
			InPoisonEffectBlockBlock.registerRenderLayer();
			InPoisonEffectStairsBlock.registerRenderLayer();
			InPoisonEffectSlabBlock.registerRenderLayer();
			InWitherEffectBlockBlock.registerRenderLayer();
			InWitherEffectStairsBlock.registerRenderLayer();
			InWitherEffectSlabBlock.registerRenderLayer();
			InRegenerationEffectBlockBlock.registerRenderLayer();
			InRegenerationEffectStairsBlock.registerRenderLayer();
			InRegenerationEffectSlabBlock.registerRenderLayer();
			InResistanceEffectBlockBlock.registerRenderLayer();
			InResistanceEffectStairsBlock.registerRenderLayer();
			InResistanceEffectSlabBlock.registerRenderLayer();
			InStrengthEffectBlockBlock.registerRenderLayer();
			InStrengthEffectStairsBlock.registerRenderLayer();
			InStrengthEffectSlabBlock.registerRenderLayer();
			InWeaknessEffectBlockBlock.registerRenderLayer();
			InWeaknessEffectStairsBlock.registerRenderLayer();
			InWeaknessEffectSlabBlock.registerRenderLayer();
			InHasteEffectBlockBlock.registerRenderLayer();
			InHasteEffectStairsBlock.registerRenderLayer();
			InHasteEffectSlabBlock.registerRenderLayer();
			InMiningFatigueEffectBlockBlock.registerRenderLayer();
			InMiningFatigueEffectStairsBlock.registerRenderLayer();
			InMiningFatigueEffectSlabBlock.registerRenderLayer();
			InLevitationEffectBlockBlock.registerRenderLayer();
			InLevitationEffectStairsBlock.registerRenderLayer();
			InLevitationEffectSlabBlock.registerRenderLayer();
			InSlowFallingEffectBlockBlock.registerRenderLayer();
			InSlowFallingEffectStairsBlock.registerRenderLayer();
			InSlowFallingEffectSlabBlock.registerRenderLayer();
			InInvisibilityEffectBlockBlock.registerRenderLayer();
			InInvisibilityEffectStairsBlock.registerRenderLayer();
			InInvisibilityEffectSlabBlock.registerRenderLayer();
			InGlowingEffectBlockBlock.registerRenderLayer();
			InGlowingEffectStairsBlock.registerRenderLayer();
			InGlowingEffectSlabBlock.registerRenderLayer();
			InFireResistanceEffectBlockBlock.registerRenderLayer();
			InFireResistanceEffectStairsBlock.registerRenderLayer();
			InFireResistanceEffectSlabBlock.registerRenderLayer();
			InWaterBreathingEffectBlockBlock.registerRenderLayer();
			InWaterBreathingEffectStairsBlock.registerRenderLayer();
			InWaterBreathingEffectSlabBlock.registerRenderLayer();
			InDolphinsGraceEffectBlockBlock.registerRenderLayer();
			InDolphinsGraceEffectStairsBlock.registerRenderLayer();
			InDolphinsGraceEffectSlabBlock.registerRenderLayer();
			InBlindnessEffectBlockBlock.registerRenderLayer();
			InBlindnessEffectStairsBlock.registerRenderLayer();
			InBlindnessEffectSlabBlock.registerRenderLayer();
			InNauseaEffectBlockBlock.registerRenderLayer();
			InNauseaEffectStairsBlock.registerRenderLayer();
			InNauseaEffectSlabBlock.registerRenderLayer();
			NightVisionEffectBlockBlock.registerRenderLayer();
			InNightVisionEffectBlockBlock.registerRenderLayer();
			InNightVisionEffectStairsBlock.registerRenderLayer();
			InNightVisionEffectSlabBlock.registerRenderLayer();
			InSaturationEffectBlockBlock.registerRenderLayer();
			InSaturationEffectStairsBlock.registerRenderLayer();
			InSaturationEffectSlabBlock.registerRenderLayer();
			InHungerEffectBlockBlock.registerRenderLayer();
			InHungerEffectStairsBlock.registerRenderLayer();
			InHungerEffectSlabBlock.registerRenderLayer();
			InYellowSwitcherEffectBlockBlock.registerRenderLayer();
			InYellowSwitcherEffectStairsBlock.registerRenderLayer();
			InYellowSwitcherEffectSlabBlock.registerRenderLayer();
			InLuckEffectBlockBlock.registerRenderLayer();
			InLuckEffestStairsBlock.registerRenderLayer();
			InLuckEffectSlabBlock.registerRenderLayer();
			InUnluckEffectBlockBlock.registerRenderLayer();
			InUnluckEffectStairsBlock.registerRenderLayer();
			InUnluckEffectSlabBlock.registerRenderLayer();
			InEffectRemoverBlockBlock.registerRenderLayer();
			InItemRemoverBlock.registerRenderLayer();
			InKillBlockBlock.registerRenderLayer();
			InKillStairsBlock.registerRenderLayer();
			InKillSlabBlock.registerRenderLayer();
			InFireKillerBlockBlock.registerRenderLayer();
			InFireKillerStairsBlock.registerRenderLayer();
			InFireKillerSlabBlock.registerRenderLayer();
			InInstantHealthBlockBlock.registerRenderLayer();
			InInstantHealthStairsBlock.registerRenderLayer();
			InInstantHealthSlabBlock.registerRenderLayer();
			HealthChangerBlockBlock.registerRenderLayer();
			InInstantHungerBlockBlock.registerRenderLayer();
			InInstantHungerStairsBlock.registerRenderLayer();
			InInstantHungerSlabBlock.registerRenderLayer();
			InInstantSaturationBlockBlock.registerRenderLayer();
			InInstantSaturationStairsBlock.registerRenderLayer();
			InInstantSaturationSlabBlock.registerRenderLayer();
			InDayTimeBlockBlock.registerRenderLayer();
			InNightTimeBlockBlock.registerRenderLayer();
			RedSwitchingSlabOffBlock.registerRenderLayer();
			BlueSwitchingSlabOffBlock.registerRenderLayer();
			YellowSwitchingSlabOffBlock.registerRenderLayer();
			LadderBlockBlock.registerRenderLayer();
			FakeBlockBlock.registerRenderLayer();
			TimedSwitchingBlockOffBlock.registerRenderLayer();
			ReverseTimedSwitchingBlockOffBlock.registerRenderLayer();
			BlueSwitchingBlockOffBlock.registerRenderLayer();
			RedSwitchingBlockOffBlock.registerRenderLayer();
			BlueKillSwitchingBlockOffBlock.registerRenderLayer();
			RedKillSwitchingBlockOffBlock.registerRenderLayer();
			YellowSwitchingBlockOffBlock.registerRenderLayer();
			ReverseYellowSwitchingBlockOffBlock.registerRenderLayer();
			WalkingSwitchingBlockOffBlock.registerRenderLayer();
			ClickingSwitchingBlockOffBlock.registerRenderLayer();
		}
	}
}
