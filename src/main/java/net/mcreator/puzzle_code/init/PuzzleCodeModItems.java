
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.puzzle_code.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import net.mcreator.puzzle_code.item.YellowSwicherEffectItemItem;
import net.mcreator.puzzle_code.item.WestRemoterMoverItemItem;
import net.mcreator.puzzle_code.item.WaterBreathingEffectItemItem;
import net.mcreator.puzzle_code.item.StrengthEffectItemItem;
import net.mcreator.puzzle_code.item.SpeedEffectItemItem;
import net.mcreator.puzzle_code.item.SouthRemoterMoverItemItem;
import net.mcreator.puzzle_code.item.SlownessEffectItemItem;
import net.mcreator.puzzle_code.item.SlowFallingEffectItemItem;
import net.mcreator.puzzle_code.item.ResistanceEffectItemItem;
import net.mcreator.puzzle_code.item.RegenerationEffectItemItem;
import net.mcreator.puzzle_code.item.RedSwitchingItemItem;
import net.mcreator.puzzle_code.item.RedOrBlueSwitchingItemItem;
import net.mcreator.puzzle_code.item.PositionSetItem;
import net.mcreator.puzzle_code.item.NorthRemoterMoverItemItem;
import net.mcreator.puzzle_code.item.NormalItemItem;
import net.mcreator.puzzle_code.item.NightVisionEffectItemItem;
import net.mcreator.puzzle_code.item.NBTVerifierItem;
import net.mcreator.puzzle_code.item.LuckEffectItemItem;
import net.mcreator.puzzle_code.item.LevitationEffectItemItem;
import net.mcreator.puzzle_code.item.KillItemItem;
import net.mcreator.puzzle_code.item.JumpBoostEffectItemItem;
import net.mcreator.puzzle_code.item.ItemRemoverItemItem;
import net.mcreator.puzzle_code.item.InvisibilityEffectItemItem;
import net.mcreator.puzzle_code.item.HasteEffectItemItem;
import net.mcreator.puzzle_code.item.GlowingEffectItemItem;
import net.mcreator.puzzle_code.item.GUISetItem;
import net.mcreator.puzzle_code.item.FireResistanceEffectItemItem;
import net.mcreator.puzzle_code.item.FireKillerItemItem;
import net.mcreator.puzzle_code.item.FireDamageItemItem;
import net.mcreator.puzzle_code.item.EffectRemoverItemItem;
import net.mcreator.puzzle_code.item.EastRemoterMoverItemItem;
import net.mcreator.puzzle_code.item.DolphinsGraceEffectItemItem;
import net.mcreator.puzzle_code.item.DamageItemItem;
import net.mcreator.puzzle_code.item.CreativeSettingsItem;
import net.mcreator.puzzle_code.item.CheckpointItemItem;
import net.mcreator.puzzle_code.item.BlueSwitchingItemItem;
import net.mcreator.puzzle_code.item.BlockyWorldItem;
import net.mcreator.puzzle_code.PuzzleCodeMod;

public class PuzzleCodeModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, PuzzleCodeMod.MODID);
	public static final RegistryObject<Item> CREATIVE_SETTINGS = REGISTRY.register("creative_settings", () -> new CreativeSettingsItem());
	public static final RegistryObject<Item> GUI_SET = REGISTRY.register("gui_set", () -> new GUISetItem());
	public static final RegistryObject<Item> POSITION_SET = REGISTRY.register("position_set", () -> new PositionSetItem());
	public static final RegistryObject<Item> NBT_VERIFIER = REGISTRY.register("nbt_verifier", () -> new NBTVerifierItem());
	public static final RegistryObject<Item> NORMAL_BLOCK = block(PuzzleCodeModBlocks.NORMAL_BLOCK, PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> NORMAL_SLAB = block(PuzzleCodeModBlocks.NORMAL_SLAB, PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> NORMAL_STAIRS = block(PuzzleCodeModBlocks.NORMAL_STAIRS, PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> NORMAL_ITEM = REGISTRY.register("normal_item", () -> new NormalItemItem());
	public static final RegistryObject<Item> CHECKPOINT_BLOCK = block(PuzzleCodeModBlocks.CHECKPOINT_BLOCK, PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> CHECKPOINT_STAIRS = block(PuzzleCodeModBlocks.CHECKPOINT_STAIRS, PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> CHECKPOINT_SLAB = block(PuzzleCodeModBlocks.CHECKPOINT_SLAB, PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_CHECKPOINT_BLOCK = block(PuzzleCodeModBlocks.IN_CHECKPOINT_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_CHECKPOINT_STAIRS = block(PuzzleCodeModBlocks.IN_CHECKPOINT_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_CHECKPOINT_SLAB = block(PuzzleCodeModBlocks.IN_CHECKPOINT_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> CHECKPOINT_ITEM = REGISTRY.register("checkpoint_item", () -> new CheckpointItemItem());
	public static final RegistryObject<Item> JUMP_BOOST_EFFECT_BLOCK = block(PuzzleCodeModBlocks.JUMP_BOOST_EFFECT_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> JUMP_BOOST_EFFECT_STAIRS = block(PuzzleCodeModBlocks.JUMP_BOOST_EFFECT_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> JUMP_BOOST_EFFECT_SLAB = block(PuzzleCodeModBlocks.JUMP_BOOST_EFFECT_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_JUMP_BOOST_EFFECT_BLOCK = block(PuzzleCodeModBlocks.IN_JUMP_BOOST_EFFECT_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_JUMP_BOOST_EFFECT_STAIRS = block(PuzzleCodeModBlocks.IN_JUMP_BOOST_EFFECT_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_JUMP_BOOST_EFFECT_SLAB = block(PuzzleCodeModBlocks.IN_JUMP_BOOST_EFFECT_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> JUMP_BOOST_EFFECT_ITEM = REGISTRY.register("jump_boost_effect_item",
			() -> new JumpBoostEffectItemItem());
	public static final RegistryObject<Item> SPEED_EFFECT_BLOCK = block(PuzzleCodeModBlocks.SPEED_EFFECT_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> SPEED_EFFECT_STAIRS = block(PuzzleCodeModBlocks.SPEED_EFFECT_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> SPEED_EFFECT_SLAB = block(PuzzleCodeModBlocks.SPEED_EFFECT_SLAB, PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_SPEED_EFFECT_BLOCK = block(PuzzleCodeModBlocks.IN_SPEED_EFFECT_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_SPEED_EFFECT_STAIRS = block(PuzzleCodeModBlocks.IN_SPEED_EFFECT_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_SPEED_EFFECT_SLAB = block(PuzzleCodeModBlocks.IN_SPEED_EFFECT_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> SPEED_EFFECT_ITEM = REGISTRY.register("speed_effect_item", () -> new SpeedEffectItemItem());
	public static final RegistryObject<Item> SLOWNESS_EFFECT_BLOCK = block(PuzzleCodeModBlocks.SLOWNESS_EFFECT_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> SLOWNESS_EFFECT_STAIRS = block(PuzzleCodeModBlocks.SLOWNESS_EFFECT_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> SLOWNESS_EFFECT_SLAB = block(PuzzleCodeModBlocks.SLOWNESS_EFFECT_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_SLOWNESS_EFFECT_BLOCK = block(PuzzleCodeModBlocks.IN_SLOWNESS_EFFECT_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_SLOWNESS_EFFECT_STAIRS = block(PuzzleCodeModBlocks.IN_SLOWNESS_EFFECT_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_SLOWNESS_EFFECT_SLAB = block(PuzzleCodeModBlocks.IN_SLOWNESS_EFFECT_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> SLOWNESS_EFFECT_ITEM = REGISTRY.register("slowness_effect_item", () -> new SlownessEffectItemItem());
	public static final RegistryObject<Item> POISON_EFFECT_BLOCK = block(PuzzleCodeModBlocks.POISON_EFFECT_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> POISON_EFFECT_STAIRS = block(PuzzleCodeModBlocks.POISON_EFFECT_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> POISON_EFFECT_SLAB = block(PuzzleCodeModBlocks.POISON_EFFECT_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_POISON_EFFECT_BLOCK = block(PuzzleCodeModBlocks.IN_POISON_EFFECT_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_POISON_EFFECT_STAIRS = block(PuzzleCodeModBlocks.IN_POISON_EFFECT_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_POISON_EFFECT_SLAB = block(PuzzleCodeModBlocks.IN_POISON_EFFECT_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> WITHER_EFFECT_BLOCK = block(PuzzleCodeModBlocks.WITHER_EFFECT_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> WITHER_EFFECT_STAIRS = block(PuzzleCodeModBlocks.WITHER_EFFECT_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> WITHER_EFFECT_SLAB = block(PuzzleCodeModBlocks.WITHER_EFFECT_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_WITHER_EFFECT_BLOCK = block(PuzzleCodeModBlocks.IN_WITHER_EFFECT_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_WITHER_EFFECT_STAIRS = block(PuzzleCodeModBlocks.IN_WITHER_EFFECT_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_WITHER_EFFECT_SLAB = block(PuzzleCodeModBlocks.IN_WITHER_EFFECT_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> REGENERATION_EFFECT_BLOCK = block(PuzzleCodeModBlocks.REGENERATION_EFFECT_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> REGENERATION_EFFECT_STAIRS = block(PuzzleCodeModBlocks.REGENERATION_EFFECT_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> REGENERATION_EFFECT_SLAB = block(PuzzleCodeModBlocks.REGENERATION_EFFECT_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_REGENERATION_EFFECT_BLOCK = block(PuzzleCodeModBlocks.IN_REGENERATION_EFFECT_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_REGENERATION_EFFECT_STAIRS = block(PuzzleCodeModBlocks.IN_REGENERATION_EFFECT_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_REGENERATION_EFFECT_SLAB = block(PuzzleCodeModBlocks.IN_REGENERATION_EFFECT_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> REGENERATION_EFFECT_ITEM = REGISTRY.register("regeneration_effect_item",
			() -> new RegenerationEffectItemItem());
	public static final RegistryObject<Item> RESISTANCE_EFFECT_BLOCK = block(PuzzleCodeModBlocks.RESISTANCE_EFFECT_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> RESISTANCE_EFFECT_STAIRS = block(PuzzleCodeModBlocks.RESISTANCE_EFFECT_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> RESISTANCE_EFFECT_SLAB = block(PuzzleCodeModBlocks.RESISTANCE_EFFECT_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_RESISTANCE_EFFECT_BLOCK = block(PuzzleCodeModBlocks.IN_RESISTANCE_EFFECT_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_RESISTANCE_EFFECT_STAIRS = block(PuzzleCodeModBlocks.IN_RESISTANCE_EFFECT_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_RESISTANCE_EFFECT_SLAB = block(PuzzleCodeModBlocks.IN_RESISTANCE_EFFECT_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> RESISTANCE_EFFECT_ITEM = REGISTRY.register("resistance_effect_item",
			() -> new ResistanceEffectItemItem());
	public static final RegistryObject<Item> STRENGTH_EFFECT_BLOCK = block(PuzzleCodeModBlocks.STRENGTH_EFFECT_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> STRENGTH_EFFECT_STAIRS = block(PuzzleCodeModBlocks.STRENGTH_EFFECT_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> STRENGTH_EFFECT_SLAB = block(PuzzleCodeModBlocks.STRENGTH_EFFECT_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_STRENGTH_EFFECT_BLOCK = block(PuzzleCodeModBlocks.IN_STRENGTH_EFFECT_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_STRENGTH_EFFECT_STAIRS = block(PuzzleCodeModBlocks.IN_STRENGTH_EFFECT_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_STRENGTH_EFFECT_SLAB = block(PuzzleCodeModBlocks.IN_STRENGTH_EFFECT_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> STRENGTH_EFFECT_ITEM = REGISTRY.register("strength_effect_item", () -> new StrengthEffectItemItem());
	public static final RegistryObject<Item> WEAKNESS_EFFECT_BLOCK = block(PuzzleCodeModBlocks.WEAKNESS_EFFECT_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> WEAKNESS_EFFECT_STAIRS = block(PuzzleCodeModBlocks.WEAKNESS_EFFECT_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> WEAKNESS_EFFECT_SLAB = block(PuzzleCodeModBlocks.WEAKNESS_EFFECT_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_WEAKNESS_EFFECT_BLOCK = block(PuzzleCodeModBlocks.IN_WEAKNESS_EFFECT_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_WEAKNESS_EFFECT_STAIRS = block(PuzzleCodeModBlocks.IN_WEAKNESS_EFFECT_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_WEAKNESS_EFFECT_SLAB = block(PuzzleCodeModBlocks.IN_WEAKNESS_EFFECT_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> HASTE_EFFECT_BLOCK = block(PuzzleCodeModBlocks.HASTE_EFFECT_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> HASTE_EFFECT_STAIRS = block(PuzzleCodeModBlocks.HASTE_EFFECT_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> HASTE_EFFECT_SLAB = block(PuzzleCodeModBlocks.HASTE_EFFECT_SLAB, PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_HASTE_EFFECT_BLOCK = block(PuzzleCodeModBlocks.IN_HASTE_EFFECT_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_HASTE_EFFECT_STAIRS = block(PuzzleCodeModBlocks.IN_HASTE_EFFECT_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_HASTE_EFFECT_SLAB = block(PuzzleCodeModBlocks.IN_HASTE_EFFECT_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> HASTE_EFFECT_ITEM = REGISTRY.register("haste_effect_item", () -> new HasteEffectItemItem());
	public static final RegistryObject<Item> MINING_FATIGUE_EFFECT_BLOCK = block(PuzzleCodeModBlocks.MINING_FATIGUE_EFFECT_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> MINING_FATIGUE_EFFECT_STAIRS = block(PuzzleCodeModBlocks.MINING_FATIGUE_EFFECT_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> MINING_FATIGUE_EFFECT_SLAB = block(PuzzleCodeModBlocks.MINING_FATIGUE_EFFECT_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_MINING_FATIGUE_EFFECT_BLOCK = block(PuzzleCodeModBlocks.IN_MINING_FATIGUE_EFFECT_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_MINING_FATIGUE_EFFECT_STAIRS = block(PuzzleCodeModBlocks.IN_MINING_FATIGUE_EFFECT_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_MINING_FATIGUE_EFFECT_SLAB = block(PuzzleCodeModBlocks.IN_MINING_FATIGUE_EFFECT_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> LEVITATION_EFFECT_BLOCK = block(PuzzleCodeModBlocks.LEVITATION_EFFECT_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> LEVITATION_EFFECT_STAIRS = block(PuzzleCodeModBlocks.LEVITATION_EFFECT_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> LEVITATION_EFFECT_SLAB = block(PuzzleCodeModBlocks.LEVITATION_EFFECT_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_LEVITATION_EFFECT_BLOCK = block(PuzzleCodeModBlocks.IN_LEVITATION_EFFECT_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_LEVITATION_EFFECT_STAIRS = block(PuzzleCodeModBlocks.IN_LEVITATION_EFFECT_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_LEVITATION_EFFECT_SLAB = block(PuzzleCodeModBlocks.IN_LEVITATION_EFFECT_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> LEVITATION_EFFECT_ITEM = REGISTRY.register("levitation_effect_item",
			() -> new LevitationEffectItemItem());
	public static final RegistryObject<Item> SLOW_FALLING_EFFECT_BLOCK = block(PuzzleCodeModBlocks.SLOW_FALLING_EFFECT_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> SLOW_FALLING_EFFECT_STAIRS = block(PuzzleCodeModBlocks.SLOW_FALLING_EFFECT_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> SLOW_FALLING_EFFECT_SLAB = block(PuzzleCodeModBlocks.SLOW_FALLING_EFFECT_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_SLOW_FALLING_EFFECT_BLOCK = block(PuzzleCodeModBlocks.IN_SLOW_FALLING_EFFECT_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_SLOW_FALLING_EFFECT_STAIRS = block(PuzzleCodeModBlocks.IN_SLOW_FALLING_EFFECT_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_SLOW_FALLING_EFFECT_SLAB = block(PuzzleCodeModBlocks.IN_SLOW_FALLING_EFFECT_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> SLOW_FALLING_EFFECT_ITEM = REGISTRY.register("slow_falling_effect_item",
			() -> new SlowFallingEffectItemItem());
	public static final RegistryObject<Item> INVISIBILITY_EFFECT_BLOCK = block(PuzzleCodeModBlocks.INVISIBILITY_EFFECT_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> INVISIBILITY_EFFECT_STAIRS = block(PuzzleCodeModBlocks.INVISIBILITY_EFFECT_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> INVISIBILITY_EFFECT_SLAB = block(PuzzleCodeModBlocks.INVISIBILITY_EFFECT_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_INVISIBILITY_EFFECT_BLOCK = block(PuzzleCodeModBlocks.IN_INVISIBILITY_EFFECT_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_INVISIBILITY_EFFECT_STAIRS = block(PuzzleCodeModBlocks.IN_INVISIBILITY_EFFECT_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_INVISIBILITY_EFFECT_SLAB = block(PuzzleCodeModBlocks.IN_INVISIBILITY_EFFECT_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> INVISIBILITY_EFFECT_ITEM = REGISTRY.register("invisibility_effect_item",
			() -> new InvisibilityEffectItemItem());
	public static final RegistryObject<Item> GLOWING_EFFECT_BLOCK = block(PuzzleCodeModBlocks.GLOWING_EFFECT_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> GLOWING_EFFECT_STAIRS = block(PuzzleCodeModBlocks.GLOWING_EFFECT_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> GLOWING_EFFECT_SLAB = block(PuzzleCodeModBlocks.GLOWING_EFFECT_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_GLOWING_EFFECT_BLOCK = block(PuzzleCodeModBlocks.IN_GLOWING_EFFECT_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_GLOWING_EFFECT_STAIRS = block(PuzzleCodeModBlocks.IN_GLOWING_EFFECT_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_GLOWING_EFFECT_SLAB = block(PuzzleCodeModBlocks.IN_GLOWING_EFFECT_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> GLOWING_EFFECT_ITEM = REGISTRY.register("glowing_effect_item", () -> new GlowingEffectItemItem());
	public static final RegistryObject<Item> FIRE_RESISTANCE_EFFECT_BLOCK = block(PuzzleCodeModBlocks.FIRE_RESISTANCE_EFFECT_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> FIRE_RESISTANCE_EFFECT_STAIRS = block(PuzzleCodeModBlocks.FIRE_RESISTANCE_EFFECT_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> FIRE_RESISTANCE_EFFECT_SLAB = block(PuzzleCodeModBlocks.FIRE_RESISTANCE_EFFECT_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_FIRE_RESISTANCE_EFFECT_BLOCK = block(PuzzleCodeModBlocks.IN_FIRE_RESISTANCE_EFFECT_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_FIRE_RESISTANCE_EFFECT_STAIRS = block(PuzzleCodeModBlocks.IN_FIRE_RESISTANCE_EFFECT_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_FIRE_RESISTANCE_EFFECT_SLAB = block(PuzzleCodeModBlocks.IN_FIRE_RESISTANCE_EFFECT_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> FIRE_RESISTANCE_EFFECT_ITEM = REGISTRY.register("fire_resistance_effect_item",
			() -> new FireResistanceEffectItemItem());
	public static final RegistryObject<Item> WATER_BREATHING_EFFECT_BLOCK = block(PuzzleCodeModBlocks.WATER_BREATHING_EFFECT_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> WATER_BREATHING_EFFECT_STAIRS = block(PuzzleCodeModBlocks.WATER_BREATHING_EFFECT_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> WATER_BREATHING_EFFECT_SLAB = block(PuzzleCodeModBlocks.WATER_BREATHING_EFFECT_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_WATER_BREATHING_EFFECT_BLOCK = block(PuzzleCodeModBlocks.IN_WATER_BREATHING_EFFECT_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_WATER_BREATHING_EFFECT_STAIRS = block(PuzzleCodeModBlocks.IN_WATER_BREATHING_EFFECT_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_WATER_BREATHING_EFFECT_SLAB = block(PuzzleCodeModBlocks.IN_WATER_BREATHING_EFFECT_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> WATER_BREATHING_EFFECT_ITEM = REGISTRY.register("water_breathing_effect_item",
			() -> new WaterBreathingEffectItemItem());
	public static final RegistryObject<Item> DOLPHINS_GRACE_EFFECT_BLOCK = block(PuzzleCodeModBlocks.DOLPHINS_GRACE_EFFECT_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> DOLPHINS_GRACE_EFFECT_STAIRS = block(PuzzleCodeModBlocks.DOLPHINS_GRACE_EFFECT_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> DOLPHINS_GRACE_EFFECT_SLAB = block(PuzzleCodeModBlocks.DOLPHINS_GRACE_EFFECT_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_DOLPHINS_GRACE_EFFECT_BLOCK = block(PuzzleCodeModBlocks.IN_DOLPHINS_GRACE_EFFECT_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_DOLPHINS_GRACE_EFFECT_STAIRS = block(PuzzleCodeModBlocks.IN_DOLPHINS_GRACE_EFFECT_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_DOLPHINS_GRACE_EFFECT_SLAB = block(PuzzleCodeModBlocks.IN_DOLPHINS_GRACE_EFFECT_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> DOLPHINS_GRACE_EFFECT_ITEM = REGISTRY.register("dolphins_grace_effect_item",
			() -> new DolphinsGraceEffectItemItem());
	public static final RegistryObject<Item> BLINDNESS_EFFECT_BLOCK = block(PuzzleCodeModBlocks.BLINDNESS_EFFECT_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> BLINDNESS_EFFECT_STAIRS = block(PuzzleCodeModBlocks.BLINDNESS_EFFECT_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> BLINDNESS_EFFECT_SLAB = block(PuzzleCodeModBlocks.BLINDNESS_EFFECT_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_BLINDNESS_EFFECT_BLOCK = block(PuzzleCodeModBlocks.IN_BLINDNESS_EFFECT_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_BLINDNESS_EFFECT_STAIRS = block(PuzzleCodeModBlocks.IN_BLINDNESS_EFFECT_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_BLINDNESS_EFFECT_SLAB = block(PuzzleCodeModBlocks.IN_BLINDNESS_EFFECT_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> NAUSEA_EFFECT_BLOCK = block(PuzzleCodeModBlocks.NAUSEA_EFFECT_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> NAUSEA_EFFECT_STAIRS = block(PuzzleCodeModBlocks.NAUSEA_EFFECT_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> NAUSEA_EFFECT_SLAB = block(PuzzleCodeModBlocks.NAUSEA_EFFECT_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_NAUSEA_EFFECT_BLOCK = block(PuzzleCodeModBlocks.IN_NAUSEA_EFFECT_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_NAUSEA_EFFECT_STAIRS = block(PuzzleCodeModBlocks.IN_NAUSEA_EFFECT_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_NAUSEA_EFFECT_SLAB = block(PuzzleCodeModBlocks.IN_NAUSEA_EFFECT_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> NIGHT_VISION_EFFECT_BLOCK = block(PuzzleCodeModBlocks.NIGHT_VISION_EFFECT_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> NIGHT_VISION_EFFECT_STAIRS = block(PuzzleCodeModBlocks.NIGHT_VISION_EFFECT_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> NIGHT_VISION_EFFECT_SLAB = block(PuzzleCodeModBlocks.NIGHT_VISION_EFFECT_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_NIGHT_VISION_EFFECT_BLOCK = block(PuzzleCodeModBlocks.IN_NIGHT_VISION_EFFECT_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_NIGHT_VISION_EFFECT_STAIRS = block(PuzzleCodeModBlocks.IN_NIGHT_VISION_EFFECT_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_NIGHT_VISION_EFFECT_SLAB = block(PuzzleCodeModBlocks.IN_NIGHT_VISION_EFFECT_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> NIGHT_VISION_EFFECT_ITEM = REGISTRY.register("night_vision_effect_item",
			() -> new NightVisionEffectItemItem());
	public static final RegistryObject<Item> SATURATION_EFFECT_BLOCK = block(PuzzleCodeModBlocks.SATURATION_EFFECT_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> SATURATION_EFFECT_STAIRS = block(PuzzleCodeModBlocks.SATURATION_EFFECT_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> SATURATION_EFFECT_SLAB = block(PuzzleCodeModBlocks.SATURATION_EFFECT_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_SATURATION_EFFECT_BLOCK = block(PuzzleCodeModBlocks.IN_SATURATION_EFFECT_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_SATURATION_EFFECT_STAIRS = block(PuzzleCodeModBlocks.IN_SATURATION_EFFECT_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_SATURATION_EFFECT_SLAB = block(PuzzleCodeModBlocks.IN_SATURATION_EFFECT_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> HUNGER_EFFECT_BLOCK = block(PuzzleCodeModBlocks.HUNGER_EFFECT_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> HUNGER_EFFECT_STAIRS = block(PuzzleCodeModBlocks.HUNGER_EFFECT_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> HUNGER_EFFECT_SLAB = block(PuzzleCodeModBlocks.HUNGER_EFFECT_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_HUNGER_EFFECT_BLOCK = block(PuzzleCodeModBlocks.IN_HUNGER_EFFECT_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_HUNGER_EFFECT_STAIRS = block(PuzzleCodeModBlocks.IN_HUNGER_EFFECT_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_HUNGER_EFFECT_SLAB = block(PuzzleCodeModBlocks.IN_HUNGER_EFFECT_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> YELLOW_SWITCHER_EFFECT_BLOCK = block(PuzzleCodeModBlocks.YELLOW_SWITCHER_EFFECT_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> YELLOW_SWITCHER_EFFECT_STAIRS = block(PuzzleCodeModBlocks.YELLOW_SWITCHER_EFFECT_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> YELLOW_SWITCHER_EFFECT_SLAB = block(PuzzleCodeModBlocks.YELLOW_SWITCHER_EFFECT_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_YELLOW_SWITCHER_EFFECT_BLOCK = block(PuzzleCodeModBlocks.IN_YELLOW_SWITCHER_EFFECT_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_YELLOW_SWITCHER_EFFECT_STAIRS = block(PuzzleCodeModBlocks.IN_YELLOW_SWITCHER_EFFECT_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_YELLOW_SWITCHER_EFFECT_SLAB = block(PuzzleCodeModBlocks.IN_YELLOW_SWITCHER_EFFECT_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> YELLOW_SWICHER_EFFECT_ITEM = REGISTRY.register("yellow_swicher_effect_item",
			() -> new YellowSwicherEffectItemItem());
	public static final RegistryObject<Item> LUCK_EFFECT_BLOCK = block(PuzzleCodeModBlocks.LUCK_EFFECT_BLOCK, PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> LUCK_EFFECT_STAIRS = block(PuzzleCodeModBlocks.LUCK_EFFECT_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> LUCK_EFFECT_SLAB = block(PuzzleCodeModBlocks.LUCK_EFFECT_SLAB, PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_LUCK_EFFECT_BLOCK = block(PuzzleCodeModBlocks.IN_LUCK_EFFECT_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_LUCK_EFFEST_STAIRS = block(PuzzleCodeModBlocks.IN_LUCK_EFFEST_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_LUCK_EFFECT_SLAB = block(PuzzleCodeModBlocks.IN_LUCK_EFFECT_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> LUCK_EFFECT_ITEM = REGISTRY.register("luck_effect_item", () -> new LuckEffectItemItem());
	public static final RegistryObject<Item> UNLUCK_EFFECT_BLOCK = block(PuzzleCodeModBlocks.UNLUCK_EFFECT_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> UNLUCK_EFFECT_STAIRS = block(PuzzleCodeModBlocks.UNLUCK_EFFECT_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> UNLUCK_EFFECT_SLAB = block(PuzzleCodeModBlocks.UNLUCK_EFFECT_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_UNLUCK_EFFECT_BLOCK = block(PuzzleCodeModBlocks.IN_UNLUCK_EFFECT_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_UNLUCK_EFFECT_STAIRS = block(PuzzleCodeModBlocks.IN_UNLUCK_EFFECT_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_UNLUCK_EFFECT_SLAB = block(PuzzleCodeModBlocks.IN_UNLUCK_EFFECT_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> EFFECT_REMOVER_BLOCK = block(PuzzleCodeModBlocks.EFFECT_REMOVER_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_EFFECT_REMOVER_BLOCK = block(PuzzleCodeModBlocks.IN_EFFECT_REMOVER_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> EFFECT_REMOVER_ITEM = REGISTRY.register("effect_remover_item", () -> new EffectRemoverItemItem());
	public static final RegistryObject<Item> INVENTORY_REPLACER = block(PuzzleCodeModBlocks.INVENTORY_REPLACER,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> BOUNCY_BLOCK = block(PuzzleCodeModBlocks.BOUNCY_BLOCK, PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> ENTITY_TELEPORTER_BLOCK = block(PuzzleCodeModBlocks.ENTITY_TELEPORTER_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> PATH_MOVING_BLOCK = block(PuzzleCodeModBlocks.PATH_MOVING_BLOCK, PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> PLACER_BLOCK = block(PuzzleCodeModBlocks.PLACER_BLOCK, PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> ADVANCED_PLACER_BLOCK = block(PuzzleCodeModBlocks.ADVANCED_PLACER_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> REPLACER_BLOCK = block(PuzzleCodeModBlocks.REPLACER_BLOCK, PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> FILLER_BLOCK = block(PuzzleCodeModBlocks.FILLER_BLOCK, PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> BLOCK_ENTITY_PLACER_BLOCK = block(PuzzleCodeModBlocks.BLOCK_ENTITY_PLACER_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> MOVING_BLOCK = block(PuzzleCodeModBlocks.MOVING_BLOCK, PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> ITEM_REMOVER_BLOCK = block(PuzzleCodeModBlocks.ITEM_REMOVER_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_ITEM_REMOVER = block(PuzzleCodeModBlocks.IN_ITEM_REMOVER, PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> ITEM_REMOVER_ITEM = REGISTRY.register("item_remover_item", () -> new ItemRemoverItemItem());
	public static final RegistryObject<Item> DAMAGE_BLOCK = block(PuzzleCodeModBlocks.DAMAGE_BLOCK, PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> DAMAGE_ITEM = REGISTRY.register("damage_item", () -> new DamageItemItem());
	public static final RegistryObject<Item> KILL_BLOCK = block(PuzzleCodeModBlocks.KILL_BLOCK, PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> KILL_STAIRS = block(PuzzleCodeModBlocks.KILL_STAIRS, PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> KILL_SLAB = block(PuzzleCodeModBlocks.KILL_SLAB, PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_KILL_BLOCK = block(PuzzleCodeModBlocks.IN_KILL_BLOCK, PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_KILL_STAIRS = block(PuzzleCodeModBlocks.IN_KILL_STAIRS, PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_KILL_SLAB = block(PuzzleCodeModBlocks.IN_KILL_SLAB, PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> KILL_ITEM = REGISTRY.register("kill_item", () -> new KillItemItem());
	public static final RegistryObject<Item> FIRE_DAMAGE_BLOCK = block(PuzzleCodeModBlocks.FIRE_DAMAGE_BLOCK, PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> FIRE_DAMAGE_ITEM = REGISTRY.register("fire_damage_item", () -> new FireDamageItemItem());
	public static final RegistryObject<Item> FIRE_KILLER_BLOCK = block(PuzzleCodeModBlocks.FIRE_KILLER_BLOCK, PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> FIRE_KILLER_STAIRS = block(PuzzleCodeModBlocks.FIRE_KILLER_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> FIRE_KILLER_SLAB = block(PuzzleCodeModBlocks.FIRE_KILLER_SLAB, PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_FIRE_KILLER_BLOCK = block(PuzzleCodeModBlocks.IN_FIRE_KILLER_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_FIRE_KILLER_STAIRS = block(PuzzleCodeModBlocks.IN_FIRE_KILLER_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_FIRE_KILLER_SLAB = block(PuzzleCodeModBlocks.IN_FIRE_KILLER_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> FIRE_KILLER_ITEM = REGISTRY.register("fire_killer_item", () -> new FireKillerItemItem());
	public static final RegistryObject<Item> HEALTH_REGENERATION_BLOCK = block(PuzzleCodeModBlocks.HEALTH_REGENERATION_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> INSTANT_HEALTH_BLOCK = block(PuzzleCodeModBlocks.INSTANT_HEALTH_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> INSTANT_HEALTH_STAIRS = block(PuzzleCodeModBlocks.INSTANT_HEALTH_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> INSTANT_HEALTH_SLAB = block(PuzzleCodeModBlocks.INSTANT_HEALTH_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_INSTANT_HEALTH_BLOCK = block(PuzzleCodeModBlocks.IN_INSTANT_HEALTH_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_INSTANT_HEALTH_STAIRS = block(PuzzleCodeModBlocks.IN_INSTANT_HEALTH_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_INSTANT_HEALTH_SLAB = block(PuzzleCodeModBlocks.IN_INSTANT_HEALTH_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> HEALTH_CHANGER_BLOCK = block(PuzzleCodeModBlocks.HEALTH_CHANGER_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> HUNGER_BLOCK = block(PuzzleCodeModBlocks.HUNGER_BLOCK, PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> INSTANT_HUNGER_BLOCK = block(PuzzleCodeModBlocks.INSTANT_HUNGER_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> INSTANT_HUNGER_STAIRS = block(PuzzleCodeModBlocks.INSTANT_HUNGER_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> INSTANT_HUNGER_SLAB = block(PuzzleCodeModBlocks.INSTANT_HUNGER_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_INSTANT_HUNGER_BLOCK = block(PuzzleCodeModBlocks.IN_INSTANT_HUNGER_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_INSTANT_HUNGER_STAIRS = block(PuzzleCodeModBlocks.IN_INSTANT_HUNGER_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_INSTANT_HUNGER_SLAB = block(PuzzleCodeModBlocks.IN_INSTANT_HUNGER_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> SATURATION_BLOCK = block(PuzzleCodeModBlocks.SATURATION_BLOCK, PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> INSTANT_SATURATION_BLOCK = block(PuzzleCodeModBlocks.INSTANT_SATURATION_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> INSTANT_SATURATION_STAIRS = block(PuzzleCodeModBlocks.INSTANT_SATURATION_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> INSTANT_SATURATION_SLAB = block(PuzzleCodeModBlocks.INSTANT_SATURATION_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_INSTANT_SATURATION_BLOCK = block(PuzzleCodeModBlocks.IN_INSTANT_SATURATION_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_INSTANT_SATURATION_STAIRS = block(PuzzleCodeModBlocks.IN_INSTANT_SATURATION_STAIRS,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_INSTANT_SATURATION_SLAB = block(PuzzleCodeModBlocks.IN_INSTANT_SATURATION_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> ADVENCED_TIME_BLOCK = block(PuzzleCodeModBlocks.ADVENCED_TIME_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> DAY_TIME_BLOCK = block(PuzzleCodeModBlocks.DAY_TIME_BLOCK, PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_DAY_TIME_BLOCK = block(PuzzleCodeModBlocks.IN_DAY_TIME_BLOCK, PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> NIGHT_TIME_BLOCK = block(PuzzleCodeModBlocks.NIGHT_TIME_BLOCK, PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IN_NIGHT_TIME_BLOCK = block(PuzzleCodeModBlocks.IN_NIGHT_TIME_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> RED_SWITCHING_BLOCK = block(PuzzleCodeModBlocks.RED_SWITCHING_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> RED_SWITCHING_SLAB = block(PuzzleCodeModBlocks.RED_SWITCHING_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> RED_SWITCHING_SLAB_OFF = block(PuzzleCodeModBlocks.RED_SWITCHING_SLAB_OFF,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> RED_KILL_SWITCHING_BLOCK = block(PuzzleCodeModBlocks.RED_KILL_SWITCHING_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> BLUE_SWITCHING_BLOCK = block(PuzzleCodeModBlocks.BLUE_SWITCHING_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> BLUE_SWITCING_SLAB = block(PuzzleCodeModBlocks.BLUE_SWITCING_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> BLUE_SWITCHING_SLAB_OFF = block(PuzzleCodeModBlocks.BLUE_SWITCHING_SLAB_OFF,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> BLUE_KILL_SWITCHING_BLOCK = block(PuzzleCodeModBlocks.BLUE_KILL_SWITCHING_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> SWITCHING_BLOCK_RED = block(PuzzleCodeModBlocks.SWITCHING_BLOCK_RED,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> LOCKED_RED_SWITCHER_BLOCK = block(PuzzleCodeModBlocks.LOCKED_RED_SWITCHER_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> LOCKED_BLUE_SWITCHIER_BLOCK = block(PuzzleCodeModBlocks.LOCKED_BLUE_SWITCHIER_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> RED_OR_BLUE_SWITCHING_ITEM = REGISTRY.register("red_or_blue_switching_item",
			() -> new RedOrBlueSwitchingItemItem());
	public static final RegistryObject<Item> RED_SWITCHING_ITEM = REGISTRY.register("red_switching_item", () -> new RedSwitchingItemItem());
	public static final RegistryObject<Item> BLUE_SWITCHING_ITEM = REGISTRY.register("blue_switching_item", () -> new BlueSwitchingItemItem());
	public static final RegistryObject<Item> YELLOW_SWITCHING_BLOCK = block(PuzzleCodeModBlocks.YELLOW_SWITCHING_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> REVERSE_YELLOW_SWITCHING_BLOCK = block(PuzzleCodeModBlocks.REVERSE_YELLOW_SWITCHING_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> YELLOW_SWITCHING_SLAB = block(PuzzleCodeModBlocks.YELLOW_SWITCHING_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> YELLOW_SWITCHING_SLAB_OFF = block(PuzzleCodeModBlocks.YELLOW_SWITCHING_SLAB_OFF,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> REVERSE_YELLOW_SWITCHING_SLAB = block(PuzzleCodeModBlocks.REVERSE_YELLOW_SWITCHING_SLAB,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> REVERSE_YELLOW_SWITCHING_SLAB_OFF = block(PuzzleCodeModBlocks.REVERSE_YELLOW_SWITCHING_SLAB_OFF,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> TIMED_SWITCHING_BLOCK = block(PuzzleCodeModBlocks.TIMED_SWITCHING_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> REVERSE_TIMED_SWITCHING_BLOCK = block(PuzzleCodeModBlocks.REVERSE_TIMED_SWITCHING_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> WALKING_SWITCHING_BLOCK = block(PuzzleCodeModBlocks.WALKING_SWITCHING_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> CLICKING_SWITCHING_BLOCK = block(PuzzleCodeModBlocks.CLICKING_SWITCHING_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> ENTITY_DETECTOR = block(PuzzleCodeModBlocks.ENTITY_DETECTOR, PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> LADDER_BLOCK = block(PuzzleCodeModBlocks.LADDER_BLOCK, PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> FAKE_BLOCK = block(PuzzleCodeModBlocks.FAKE_BLOCK, PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> A_BLOCK_IS_BROKEN_GLOBAL_BLOCK = block(PuzzleCodeModBlocks.A_BLOCK_IS_BROKEN_GLOBAL_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> A_BLOCK_IS_PLACED_GLOBAL_BLOCK = block(PuzzleCodeModBlocks.A_BLOCK_IS_PLACED_GLOBAL_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> RED_BLUE_SWITCHING_LOGIC_GLOBAL_BLOCK = block(PuzzleCodeModBlocks.RED_BLUE_SWITCHING_LOGIC_GLOBAL_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> NUMBER_CODE_BLOCK = block(PuzzleCodeModBlocks.NUMBER_CODE_BLOCK, PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> SURVIVAL_NUMBER_CODE_BLOCK = block(PuzzleCodeModBlocks.SURVIVAL_NUMBER_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> CHAIN_NUMBER_CODE_BLOCK = block(PuzzleCodeModBlocks.CHAIN_NUMBER_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> PI_NUMBER_CODE_BLOCK = block(PuzzleCodeModBlocks.PI_NUMBER_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> RANDOMIZER_INTEGER_NUMBER_CODE_BLOCK = block(PuzzleCodeModBlocks.RANDOMIZER_INTEGER_NUMBER_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> RANDOMIZER_NUMBER_CODE_BLOCK = block(PuzzleCodeModBlocks.RANDOMIZER_NUMBER_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> ADDITION_NUMBER_CODE_BLOCK = block(PuzzleCodeModBlocks.ADDITION_NUMBER_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> SUBSTRACTION_NUMBER_CODE_BLOCK = block(PuzzleCodeModBlocks.SUBSTRACTION_NUMBER_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> DIVIZION_NUMBER_CODE_BLOCK = block(PuzzleCodeModBlocks.DIVIZION_NUMBER_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> MULTIPLICATION_NUMBER_CODE_BLOCK = block(PuzzleCodeModBlocks.MULTIPLICATION_NUMBER_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> POWER_NUMBER_CODE_BLOCK = block(PuzzleCodeModBlocks.POWER_NUMBER_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> EQUAL_NUMBER_CODE_BLOCK = block(PuzzleCodeModBlocks.EQUAL_NUMBER_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> UNEQUAL_NUMBER_CODE_BLOCK = block(PuzzleCodeModBlocks.UNEQUAL_NUMBER_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> BIGGER_THAN_NUMBER_CODE_BLOCK = block(PuzzleCodeModBlocks.BIGGER_THAN_NUMBER_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> SMALLER_THAN_NUMBER_CODE_BLOCK = block(PuzzleCodeModBlocks.SMALLER_THAN_NUMBER_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> SMALLER_OR_EQUAL_THAN_NUMBER_CODE_BLOCK = block(
			PuzzleCodeModBlocks.SMALLER_OR_EQUAL_THAN_NUMBER_CODE_BLOCK, PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> BIGGER_OR_EQUAL_THAN_NUMBER_CODE_BLOCK = block(
			PuzzleCodeModBlocks.BIGGER_OR_EQUAL_THAN_NUMBER_CODE_BLOCK, PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> DAY_NUMBER_CODE_BLOCK = block(PuzzleCodeModBlocks.DAY_NUMBER_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> MONTH_NUMBER_CODE_BLOCK = block(PuzzleCodeModBlocks.MONTH_NUMBER_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> YEAR_NUMBER_CODE_BLOCK = block(PuzzleCodeModBlocks.YEAR_NUMBER_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> ROUND_NUMBER_CODE_BLOCK = block(PuzzleCodeModBlocks.ROUND_NUMBER_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> ROUND_UP_NUMBER_CODE_BLOCK = block(PuzzleCodeModBlocks.ROUND_UP_NUMBER_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> ROUND_DOWN_NUMBER_CODE_BLOCK = block(PuzzleCodeModBlocks.ROUND_DOWN_NUMBER_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> TRANSFER_NUMBER_CODE_BLOCK = block(PuzzleCodeModBlocks.TRANSFER_NUMBER_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> LEFT_TRANSFER_NUMBER_CODE_BLOCK = block(PuzzleCodeModBlocks.LEFT_TRANSFER_NUMBER_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> RIGHT_TRANSFER_NUMBER_CODE_BLOCK = block(PuzzleCodeModBlocks.RIGHT_TRANSFER_NUMBER_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> OPPOSITE_TRANSFER_NUMBER_CODE_BLOCK = block(PuzzleCodeModBlocks.OPPOSITE_TRANSFER_NUMBER_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> DEGREES_TO_RADIANS_NUMBER_CODE_BLOCK = block(PuzzleCodeModBlocks.DEGREES_TO_RADIANS_NUMBER_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> RADIANS_TO_DEGREES_NUMBER_CODE_BLOCK = block(PuzzleCodeModBlocks.RADIANS_TO_DEGREES_NUMBER_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> PROPERTY_TO_NBT_NUMBER_CODE_BLOCK = block(PuzzleCodeModBlocks.PROPERTY_TO_NBT_NUMBER_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> NBT_TO_PROPERTY_NUMBER_CLODE_BLOCK = block(PuzzleCodeModBlocks.NBT_TO_PROPERTY_NUMBER_CLODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> PROPERTY_TRANSFER_NUMBER_CODE_BLOCK = block(PuzzleCodeModBlocks.PROPERTY_TRANSFER_NUMBER_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IMITATOR_NUMBER_CODE_BLOCK = block(PuzzleCodeModBlocks.IMITATOR_NUMBER_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> TELEPORTER_NUMBER_CODE_BLOCK = block(PuzzleCodeModBlocks.TELEPORTER_NUMBER_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> FILLER_NUMBER_CODE_BLOCK = block(PuzzleCodeModBlocks.FILLER_NUMBER_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> NUMBER_TO_REDSTONE_CONVERTER_CODE_BLOCK = block(
			PuzzleCodeModBlocks.NUMBER_TO_REDSTONE_CONVERTER_CODE_BLOCK, PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> REDSTONE_TO_NUMBER_CONVERTER_CODE_BLOCK = block(
			PuzzleCodeModBlocks.REDSTONE_TO_NUMBER_CONVERTER_CODE_BLOCK, PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> NUMBER_TO_TEXT_CODE_BLOCK = block(PuzzleCodeModBlocks.NUMBER_TO_TEXT_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> HP_OF_ENTITY_TO_NUMBER_CODE_BLOCK = block(PuzzleCodeModBlocks.HP_OF_ENTITY_TO_NUMBER_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> MAX_HP_OF_ENTITY_TO_NUMBER_CODE_BLOCK = block(PuzzleCodeModBlocks.MAX_HP_OF_ENTITY_TO_NUMBER_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> LOGIC_CODE_BLOCK = block(PuzzleCodeModBlocks.LOGIC_CODE_BLOCK, PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> SURVIVAL_LOGIC_CODE_BLOCK = block(PuzzleCodeModBlocks.SURVIVAL_LOGIC_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> CHAIN_LOGIC_CODE_BLOCK = block(PuzzleCodeModBlocks.CHAIN_LOGIC_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> EQUAL_LOGIC_CODE_BLOCK = block(PuzzleCodeModBlocks.EQUAL_LOGIC_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> UNEQUAL_LOGIC_CODE_BLOCK = block(PuzzleCodeModBlocks.UNEQUAL_LOGIC_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> AND_LOGIC_CODE_BLOCK = block(PuzzleCodeModBlocks.AND_LOGIC_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> OR_LOGIC_CODE_BLOCK = block(PuzzleCodeModBlocks.OR_LOGIC_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> XOR_LOGIC_CODE_BLOCK = block(PuzzleCodeModBlocks.XOR_LOGIC_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> TRANSFER_LOGIC_CODE_BLOCK = block(PuzzleCodeModBlocks.TRANSFER_LOGIC_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> LEFT_TRANSFER_LOGIC_CODE_BLOCK = block(PuzzleCodeModBlocks.LEFT_TRANSFER_LOGIC_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> RIGHT_TRANSFER_LOGIC_CODE_BLOCK = block(PuzzleCodeModBlocks.RIGHT_TRANSFER_LOGIC_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> OPPOSITE_TRANSFER_LOGIC_CODE_BLOCK = block(PuzzleCodeModBlocks.OPPOSITE_TRANSFER_LOGIC_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> NBT_TO_PROPERTY_LOGIC_CODE_BLOCK = block(PuzzleCodeModBlocks.NBT_TO_PROPERTY_LOGIC_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> PROPERTY_TO_NBT_LOGIC_CODE_BLOCK = block(PuzzleCodeModBlocks.PROPERTY_TO_NBT_LOGIC_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> PROPERTY_TRANSFER_LOGIC_CODE_BLOCK = block(PuzzleCodeModBlocks.PROPERTY_TRANSFER_LOGIC_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IMITATOR_LOGIC_CODE_BLOCK = block(PuzzleCodeModBlocks.IMITATOR_LOGIC_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> TELEPORTER_LOGIC_CODE_BLOCK = block(PuzzleCodeModBlocks.TELEPORTER_LOGIC_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> FILLER_LOGIC_CODE_BLOCK = block(PuzzleCodeModBlocks.FILLER_LOGIC_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> REDSTONE_TO_LOGIC_CODE_BLOCK = block(PuzzleCodeModBlocks.REDSTONE_TO_LOGIC_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> LOGIC_TO_REDSTONE_CODE_BLOCK = block(PuzzleCodeModBlocks.LOGIC_TO_REDSTONE_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> LOGIC_TO_NUMBER_CODE_BLOCK = block(PuzzleCodeModBlocks.LOGIC_TO_NUMBER_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> TEXT_CODE_BLOCK = block(PuzzleCodeModBlocks.TEXT_CODE_BLOCK, PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> SURVIVAL_TEXT_CODE_BLOCK = block(PuzzleCodeModBlocks.SURVIVAL_TEXT_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> CHAIN_TEXT_CODE_BLOCK = block(PuzzleCodeModBlocks.CHAIN_TEXT_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> MESSAGER_BLOCK = block(PuzzleCodeModBlocks.MESSAGER_BLOCK, PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> TITLE_TEXT_CODE_BLOCK = block(PuzzleCodeModBlocks.TITLE_TEXT_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> COMMAND_CODE_BLOCK = block(PuzzleCodeModBlocks.COMMAND_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> TRANSFER_TEXT_CODE_BLOCK = block(PuzzleCodeModBlocks.TRANSFER_TEXT_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> LEFT_TRANSFER_TEXT_CODE_BLOCK = block(PuzzleCodeModBlocks.LEFT_TRANSFER_TEXT_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> RIGHT_TRANSFER_TEXT_CODE_BLOCK = block(PuzzleCodeModBlocks.RIGHT_TRANSFER_TEXT_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> MERGE_TEXT_CODE_BLOCK = block(PuzzleCodeModBlocks.MERGE_TEXT_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> EQUAL_TEXT_CODE_BLOCK = block(PuzzleCodeModBlocks.EQUAL_TEXT_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> UNEQUAL_TEXT_CODE_BLOCK = block(PuzzleCodeModBlocks.UNEQUAL_TEXT_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> NBT_TO_PROPERTY_TEXT_CODE_BLOCK = block(PuzzleCodeModBlocks.NBT_TO_PROPERTY_TEXT_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> PROPERTY_TO_NBT_TEXT_CODE_BLOCK = block(PuzzleCodeModBlocks.PROPERTY_TO_NBT_TEXT_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> PROPERTY_TRANSFER_TEXT_CODE_BLOCK = block(PuzzleCodeModBlocks.PROPERTY_TRANSFER_TEXT_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IMITATOR_TEXT_CODE_BLOCK = block(PuzzleCodeModBlocks.IMITATOR_TEXT_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> TELEPORTER_TEXT_CODE_BLOCK = block(PuzzleCodeModBlocks.TELEPORTER_TEXT_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> FILLER_TEXT_CODE_BLOCK = block(PuzzleCodeModBlocks.FILLER_TEXT_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> TEXT_TO_NUMBER_CODE_BLOCK = block(PuzzleCodeModBlocks.TEXT_TO_NUMBER_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> ITEM_CODE_BLOCK = block(PuzzleCodeModBlocks.ITEM_CODE_BLOCK, PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> SURVIVAL_ITEM_CODE_BLOCK = block(PuzzleCodeModBlocks.SURVIVAL_ITEM_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> CHAIN_ITEM_CODE_BLOCK = block(PuzzleCodeModBlocks.CHAIN_ITEM_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> TRANSFER_ITEM_CODE_BLOCK = block(PuzzleCodeModBlocks.TRANSFER_ITEM_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> LEFT_TRANSFER_ITEM_CODE_BLOCK = block(PuzzleCodeModBlocks.LEFT_TRANSFER_ITEM_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> RIGHT_TRANSFER_ITEM_CODE_BLOCK = block(PuzzleCodeModBlocks.RIGHT_TRANSFER_ITEM_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> EQUAL_ITEM_CODE_BLOCK = block(PuzzleCodeModBlocks.EQUAL_ITEM_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> UNEQUAL_ITEM_CODE_BLOCK = block(PuzzleCodeModBlocks.UNEQUAL_ITEM_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> IMITATOR_ITEM_CODE_BLOCK = block(PuzzleCodeModBlocks.IMITATOR_ITEM_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> TELEPORTER_ITEM_CODE_BLOCK = block(PuzzleCodeModBlocks.TELEPORTER_ITEM_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> FILLER_ITEM_CODE_BLOCK = block(PuzzleCodeModBlocks.FILLER_ITEM_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> NUMBER_OF_ITEMS_CODE_BLOCK = block(PuzzleCodeModBlocks.NUMBER_OF_ITEMS_CODE_BLOCK,
			PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> PUZZLE_CRAFTER = block(PuzzleCodeModBlocks.PUZZLE_CRAFTER, PuzzleCodeModTabs.TAB_PUZZLE_CODE_TAB);
	public static final RegistryObject<Item> BLOCKY_WORLD = REGISTRY.register("blocky_world", () -> new BlockyWorldItem());
	public static final RegistryObject<Item> BOX = block(PuzzleCodeModBlocks.BOX, null);
	public static final RegistryObject<Item> SPEED_ACCELERATOR_BLOCK = block(PuzzleCodeModBlocks.SPEED_ACCELERATOR_BLOCK, null);
	public static final RegistryObject<Item> SPEED_LINGERING_BLOCK = block(PuzzleCodeModBlocks.SPEED_LINGERING_BLOCK, null);
	public static final RegistryObject<Item> REMOTE_MOVER_BLOCK = block(PuzzleCodeModBlocks.REMOTE_MOVER_BLOCK, null);
	public static final RegistryObject<Item> NORTH_REMOTER_MOVER_ITEM = REGISTRY.register("north_remoter_mover_item",
			() -> new NorthRemoterMoverItemItem());
	public static final RegistryObject<Item> SOUTH_REMOTER_MOVER_ITEM = REGISTRY.register("south_remoter_mover_item",
			() -> new SouthRemoterMoverItemItem());
	public static final RegistryObject<Item> WEST_REMOTER_MOVER_ITEM = REGISTRY.register("west_remoter_mover_item",
			() -> new WestRemoterMoverItemItem());
	public static final RegistryObject<Item> EAST_REMOTER_MOVER_ITEM = REGISTRY.register("east_remoter_mover_item",
			() -> new EastRemoterMoverItemItem());
	public static final RegistryObject<Item> WALKING_DETECTOR = block(PuzzleCodeModBlocks.WALKING_DETECTOR, null);
	public static final RegistryObject<Item> SPEED_CHANGER_BLOCK = block(PuzzleCodeModBlocks.SPEED_CHANGER_BLOCK, null);
	public static final RegistryObject<Item> TIMED_SWITCHING_BLOCK_OFF = block(PuzzleCodeModBlocks.TIMED_SWITCHING_BLOCK_OFF, null);
	public static final RegistryObject<Item> REVERSE_TIMED_SWITCHING_BLOCK_OFF = block(PuzzleCodeModBlocks.REVERSE_TIMED_SWITCHING_BLOCK_OFF, null);
	public static final RegistryObject<Item> SWITCHER_BLOCK_BLUE = block(PuzzleCodeModBlocks.SWITCHER_BLOCK_BLUE, null);
	public static final RegistryObject<Item> BLUE_SWITCHING_BLOCK_OFF = block(PuzzleCodeModBlocks.BLUE_SWITCHING_BLOCK_OFF, null);
	public static final RegistryObject<Item> RED_SWITCHING_BLOCK_OFF = block(PuzzleCodeModBlocks.RED_SWITCHING_BLOCK_OFF, null);
	public static final RegistryObject<Item> BLUE_KILL_SWITCHING_BLOCK_OFF = block(PuzzleCodeModBlocks.BLUE_KILL_SWITCHING_BLOCK_OFF, null);
	public static final RegistryObject<Item> RED_KILL_SWITCHING_BLOCK_OFF = block(PuzzleCodeModBlocks.RED_KILL_SWITCHING_BLOCK_OFF, null);
	public static final RegistryObject<Item> YELLOW_SWITCHING_BLOCK_OFF = block(PuzzleCodeModBlocks.YELLOW_SWITCHING_BLOCK_OFF, null);
	public static final RegistryObject<Item> REVERSE_YELLOW_SWITCHING_BLOCK_OFF = block(PuzzleCodeModBlocks.REVERSE_YELLOW_SWITCHING_BLOCK_OFF, null);
	public static final RegistryObject<Item> WALKING_SWITCHING_BLOCK_OFF = block(PuzzleCodeModBlocks.WALKING_SWITCHING_BLOCK_OFF, null);
	public static final RegistryObject<Item> CLICKING_SWITCHING_BLOCK_OFF = block(PuzzleCodeModBlocks.CLICKING_SWITCHING_BLOCK_OFF, null);
	public static final RegistryObject<Item> REDSTONE_CODE_BLOCK = block(PuzzleCodeModBlocks.REDSTONE_CODE_BLOCK, null);

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
