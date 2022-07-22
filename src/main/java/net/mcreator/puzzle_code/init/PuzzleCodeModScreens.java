
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.puzzle_code.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.puzzle_code.client.gui.YellowSwicherBlockGUIScreen;
import net.mcreator.puzzle_code.client.gui.WalkingBlockGUIScreen;
import net.mcreator.puzzle_code.client.gui.UnswitchableTermsNumberCodeBlockGUIScreen;
import net.mcreator.puzzle_code.client.gui.TransferItemCodeBlockGUIScreen;
import net.mcreator.puzzle_code.client.gui.TransferCodeBlockGUIScreen;
import net.mcreator.puzzle_code.client.gui.TitleTextCodeBlockGUIScreen;
import net.mcreator.puzzle_code.client.gui.TextCodeBlockGuiScreen;
import net.mcreator.puzzle_code.client.gui.TeleporterTextCodeBlockGUIScreen;
import net.mcreator.puzzle_code.client.gui.TeleporterTextCodeBlockGUI2Screen;
import net.mcreator.puzzle_code.client.gui.TeleporterNumberCodeBlockGUIScreen;
import net.mcreator.puzzle_code.client.gui.TeleporterNumberCodeBlockGUI2Screen;
import net.mcreator.puzzle_code.client.gui.TeleporterLogicCodeBlockGUIScreen;
import net.mcreator.puzzle_code.client.gui.TeleporterLogicCodeBlockGUI2Screen;
import net.mcreator.puzzle_code.client.gui.TeleporterItemCodeBlockGUI2Screen;
import net.mcreator.puzzle_code.client.gui.TeleporterItemCodeBlockGUI1Screen;
import net.mcreator.puzzle_code.client.gui.SwitchableTermsNumberCodeBlockGUIScreen;
import net.mcreator.puzzle_code.client.gui.ReplacerGUIScreen;
import net.mcreator.puzzle_code.client.gui.RandomizerNumberCodeBlockGUIScreen;
import net.mcreator.puzzle_code.client.gui.PuzzleCrafterGUIScreen;
import net.mcreator.puzzle_code.client.gui.PropertyTransferCodeBlockGUIScreen;
import net.mcreator.puzzle_code.client.gui.PropertyToNBTCodeBlockGUIScreen;
import net.mcreator.puzzle_code.client.gui.PositionSetGUIScreen;
import net.mcreator.puzzle_code.client.gui.NumberCodeBlockGuiScreen;
import net.mcreator.puzzle_code.client.gui.NBTVerifierGUIScreen;
import net.mcreator.puzzle_code.client.gui.NBTToPropertyCodeBlockGUIScreen;
import net.mcreator.puzzle_code.client.gui.MessagerBlockGUIScreen;
import net.mcreator.puzzle_code.client.gui.LogicCodeBlockGuiScreen;
import net.mcreator.puzzle_code.client.gui.ItemCodeBlockGUIScreen;
import net.mcreator.puzzle_code.client.gui.InventoryReplacerGUIScreen;
import net.mcreator.puzzle_code.client.gui.InventoryReplacerGUI4Screen;
import net.mcreator.puzzle_code.client.gui.InventoryReplacerGUI3Screen;
import net.mcreator.puzzle_code.client.gui.InventoryReplacerGUI2Screen;
import net.mcreator.puzzle_code.client.gui.InEffectBlocksGuiScreen;
import net.mcreator.puzzle_code.client.gui.InEffectBlocksGui2Screen;
import net.mcreator.puzzle_code.client.gui.ImitatorTextCodeBlockGUIScreen;
import net.mcreator.puzzle_code.client.gui.ImitatorNumberCodeBlockGUIScreen;
import net.mcreator.puzzle_code.client.gui.ImitatorLogicCodeBlockGUIScreen;
import net.mcreator.puzzle_code.client.gui.ImitatorItemCodeBlockGUIScreen;
import net.mcreator.puzzle_code.client.gui.ImitatorItemCodeBlockGUI2Screen;
import net.mcreator.puzzle_code.client.gui.HealthChangerBlockGUIScreen;
import net.mcreator.puzzle_code.client.gui.FillerGui2Screen;
import net.mcreator.puzzle_code.client.gui.FillerGui1Screen;
import net.mcreator.puzzle_code.client.gui.FillerCodeBlockGUI3Screen;
import net.mcreator.puzzle_code.client.gui.FillerCodeBlockGUI2Screen;
import net.mcreator.puzzle_code.client.gui.FillerCodeBlockGUI1Screen;
import net.mcreator.puzzle_code.client.gui.EffectBlocksGuiScreen;
import net.mcreator.puzzle_code.client.gui.EffectBlocksGui2Screen;
import net.mcreator.puzzle_code.client.gui.CreativeSettingsGUIScreen;
import net.mcreator.puzzle_code.client.gui.CreativeSettingsGUIGamerulesScreen;
import net.mcreator.puzzle_code.client.gui.CreativeSettingsGUICreativeItemsScreen;
import net.mcreator.puzzle_code.client.gui.CommandCodeBlockGUIScreen;
import net.mcreator.puzzle_code.client.gui.AdvencedTimeBlockGuiScreen;
import net.mcreator.puzzle_code.client.gui.AdvancedTeleporterBlockGuiScreen;
import net.mcreator.puzzle_code.client.gui.AdvancedPlacerGUIScreen;
import net.mcreator.puzzle_code.client.gui.ABlockIsBrokenGlobalBlockGUIScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class PuzzleCodeModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(PuzzleCodeModMenus.CREATIVE_SETTINGS_GUI, CreativeSettingsGUIScreen::new);
			MenuScreens.register(PuzzleCodeModMenus.EFFECT_BLOCKS_GUI, EffectBlocksGuiScreen::new);
			MenuScreens.register(PuzzleCodeModMenus.ADVANCED_TELEPORTER_BLOCK_GUI, AdvancedTeleporterBlockGuiScreen::new);
			MenuScreens.register(PuzzleCodeModMenus.ADVENCED_TIME_BLOCK_GUI, AdvencedTimeBlockGuiScreen::new);
			MenuScreens.register(PuzzleCodeModMenus.ADVANCED_PLACER_GUI, AdvancedPlacerGUIScreen::new);
			MenuScreens.register(PuzzleCodeModMenus.EFFECT_BLOCKS_GUI_2, EffectBlocksGui2Screen::new);
			MenuScreens.register(PuzzleCodeModMenus.IN_EFFECT_BLOCKS_GUI, InEffectBlocksGuiScreen::new);
			MenuScreens.register(PuzzleCodeModMenus.YELLOW_SWICHER_BLOCK_GUI, YellowSwicherBlockGUIScreen::new);
			MenuScreens.register(PuzzleCodeModMenus.WALKING_BLOCK_GUI, WalkingBlockGUIScreen::new);
			MenuScreens.register(PuzzleCodeModMenus.HEALTH_CHANGER_BLOCK_GUI, HealthChangerBlockGUIScreen::new);
			MenuScreens.register(PuzzleCodeModMenus.NUMBER_CODE_BLOCK_GUI, NumberCodeBlockGuiScreen::new);
			MenuScreens.register(PuzzleCodeModMenus.LOGIC_CODE_BLOCK_GUI, LogicCodeBlockGuiScreen::new);
			MenuScreens.register(PuzzleCodeModMenus.TEXT_CODE_BLOCK_GUI, TextCodeBlockGuiScreen::new);
			MenuScreens.register(PuzzleCodeModMenus.REPLACER_GUI, ReplacerGUIScreen::new);
			MenuScreens.register(PuzzleCodeModMenus.MESSAGER_BLOCK_GUI, MessagerBlockGUIScreen::new);
			MenuScreens.register(PuzzleCodeModMenus.ITEM_CODE_BLOCK_GUI, ItemCodeBlockGUIScreen::new);
			MenuScreens.register(PuzzleCodeModMenus.COMMAND_CODE_BLOCK_GUI, CommandCodeBlockGUIScreen::new);
			MenuScreens.register(PuzzleCodeModMenus.POSITION_SET_GUI, PositionSetGUIScreen::new);
			MenuScreens.register(PuzzleCodeModMenus.CREATIVE_SETTINGS_GUI_CREATIVE_ITEMS, CreativeSettingsGUICreativeItemsScreen::new);
			MenuScreens.register(PuzzleCodeModMenus.PUZZLE_CRAFTER_GUI, PuzzleCrafterGUIScreen::new);
			MenuScreens.register(PuzzleCodeModMenus.FILLER_GUI_1, FillerGui1Screen::new);
			MenuScreens.register(PuzzleCodeModMenus.FILLER_GUI_2, FillerGui2Screen::new);
			MenuScreens.register(PuzzleCodeModMenus.RANDOMIZER_NUMBER_CODE_BLOCK_GUI, RandomizerNumberCodeBlockGUIScreen::new);
			MenuScreens.register(PuzzleCodeModMenus.CREATIVE_SETTINGS_GUI_GAMERULES, CreativeSettingsGUIGamerulesScreen::new);
			MenuScreens.register(PuzzleCodeModMenus.A_BLOCK_IS_BROKEN_GLOBAL_BLOCK_GUI, ABlockIsBrokenGlobalBlockGUIScreen::new);
			MenuScreens.register(PuzzleCodeModMenus.TITLE_TEXT_CODE_BLOCK_GUI, TitleTextCodeBlockGUIScreen::new);
			MenuScreens.register(PuzzleCodeModMenus.INVENTORY_REPLACER_GUI, InventoryReplacerGUIScreen::new);
			MenuScreens.register(PuzzleCodeModMenus.INVENTORY_REPLACER_GUI_2, InventoryReplacerGUI2Screen::new);
			MenuScreens.register(PuzzleCodeModMenus.INVENTORY_REPLACER_GUI_3, InventoryReplacerGUI3Screen::new);
			MenuScreens.register(PuzzleCodeModMenus.INVENTORY_REPLACER_GUI_4, InventoryReplacerGUI4Screen::new);
			MenuScreens.register(PuzzleCodeModMenus.IN_EFFECT_BLOCKS_GUI_2, InEffectBlocksGui2Screen::new);
			MenuScreens.register(PuzzleCodeModMenus.IMITATOR_ITEM_CODE_BLOCK_GUI, ImitatorItemCodeBlockGUIScreen::new);
			MenuScreens.register(PuzzleCodeModMenus.IMITATOR_ITEM_CODE_BLOCK_GUI_2, ImitatorItemCodeBlockGUI2Screen::new);
			MenuScreens.register(PuzzleCodeModMenus.SWITCHABLE_TERMS_NUMBER_CODE_BLOCK_GUI, SwitchableTermsNumberCodeBlockGUIScreen::new);
			MenuScreens.register(PuzzleCodeModMenus.UNSWITCHABLE_TERMS_NUMBER_CODE_BLOCK_GUI, UnswitchableTermsNumberCodeBlockGUIScreen::new);
			MenuScreens.register(PuzzleCodeModMenus.TRANSFER_ITEM_CODE_BLOCK_GUI, TransferItemCodeBlockGUIScreen::new);
			MenuScreens.register(PuzzleCodeModMenus.TELEPORTER_ITEM_CODE_BLOCK_GUI_1, TeleporterItemCodeBlockGUI1Screen::new);
			MenuScreens.register(PuzzleCodeModMenus.TELEPORTER_ITEM_CODE_BLOCK_GUI_2, TeleporterItemCodeBlockGUI2Screen::new);
			MenuScreens.register(PuzzleCodeModMenus.NBT_VERIFIER_GUI, NBTVerifierGUIScreen::new);
			MenuScreens.register(PuzzleCodeModMenus.TRANSFER_CODE_BLOCK_GUI, TransferCodeBlockGUIScreen::new);
			MenuScreens.register(PuzzleCodeModMenus.TELEPORTER_NUMBER_CODE_BLOCK_GUI, TeleporterNumberCodeBlockGUIScreen::new);
			MenuScreens.register(PuzzleCodeModMenus.IMITATOR_NUMBER_CODE_BLOCK_GUI, ImitatorNumberCodeBlockGUIScreen::new);
			MenuScreens.register(PuzzleCodeModMenus.TELEPORTER_NUMBER_CODE_BLOCK_GUI_2, TeleporterNumberCodeBlockGUI2Screen::new);
			MenuScreens.register(PuzzleCodeModMenus.IMITATOR_LOGIC_CODE_BLOCK_GUI, ImitatorLogicCodeBlockGUIScreen::new);
			MenuScreens.register(PuzzleCodeModMenus.TELEPORTER_LOGIC_CODE_BLOCK_GUI_2, TeleporterLogicCodeBlockGUI2Screen::new);
			MenuScreens.register(PuzzleCodeModMenus.TELEPORTER_LOGIC_CODE_BLOCK_GUI, TeleporterLogicCodeBlockGUIScreen::new);
			MenuScreens.register(PuzzleCodeModMenus.IMITATOR_TEXT_CODE_BLOCK_GUI, ImitatorTextCodeBlockGUIScreen::new);
			MenuScreens.register(PuzzleCodeModMenus.TELEPORTER_TEXT_CODE_BLOCK_GUI, TeleporterTextCodeBlockGUIScreen::new);
			MenuScreens.register(PuzzleCodeModMenus.TELEPORTER_TEXT_CODE_BLOCK_GUI_2, TeleporterTextCodeBlockGUI2Screen::new);
			MenuScreens.register(PuzzleCodeModMenus.PROPERTY_TO_NBT_CODE_BLOCK_GUI, PropertyToNBTCodeBlockGUIScreen::new);
			MenuScreens.register(PuzzleCodeModMenus.NBT_TO_PROPERTY_CODE_BLOCK_GUI, NBTToPropertyCodeBlockGUIScreen::new);
			MenuScreens.register(PuzzleCodeModMenus.PROPERTY_TRANSFER_CODE_BLOCK_GUI, PropertyTransferCodeBlockGUIScreen::new);
			MenuScreens.register(PuzzleCodeModMenus.FILLER_CODE_BLOCK_GUI_1, FillerCodeBlockGUI1Screen::new);
			MenuScreens.register(PuzzleCodeModMenus.FILLER_CODE_BLOCK_GUI_2, FillerCodeBlockGUI2Screen::new);
			MenuScreens.register(PuzzleCodeModMenus.FILLER_CODE_BLOCK_GUI_3, FillerCodeBlockGUI3Screen::new);
		});
	}
}
