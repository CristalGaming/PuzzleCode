
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.puzzle_code.init;

import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.AbstractContainerMenu;

import net.mcreator.puzzle_code.world.inventory.YellowSwicherBlockGUIMenu;
import net.mcreator.puzzle_code.world.inventory.WalkingBlockGUIMenu;
import net.mcreator.puzzle_code.world.inventory.UnswitchableTermsNumberCodeBlockGUIMenu;
import net.mcreator.puzzle_code.world.inventory.TransferItemCodeBlockGUIMenu;
import net.mcreator.puzzle_code.world.inventory.TransferCodeBlockGUIMenu;
import net.mcreator.puzzle_code.world.inventory.TitleTextCodeBlockGUIMenu;
import net.mcreator.puzzle_code.world.inventory.TextCodeBlockGuiMenu;
import net.mcreator.puzzle_code.world.inventory.TeleporterTextCodeBlockGUIMenu;
import net.mcreator.puzzle_code.world.inventory.TeleporterTextCodeBlockGUI2Menu;
import net.mcreator.puzzle_code.world.inventory.TeleporterNumberCodeBlockGUIMenu;
import net.mcreator.puzzle_code.world.inventory.TeleporterNumberCodeBlockGUI2Menu;
import net.mcreator.puzzle_code.world.inventory.TeleporterLogicCodeBlockGUIMenu;
import net.mcreator.puzzle_code.world.inventory.TeleporterLogicCodeBlockGUI2Menu;
import net.mcreator.puzzle_code.world.inventory.TeleporterItemCodeBlockGUI2Menu;
import net.mcreator.puzzle_code.world.inventory.TeleporterItemCodeBlockGUI1Menu;
import net.mcreator.puzzle_code.world.inventory.SwitchableTermsNumberCodeBlockGUIMenu;
import net.mcreator.puzzle_code.world.inventory.ReplacerGUIMenu;
import net.mcreator.puzzle_code.world.inventory.RandomizerNumberCodeBlockGUIMenu;
import net.mcreator.puzzle_code.world.inventory.PuzzleCrafterGUIMenu;
import net.mcreator.puzzle_code.world.inventory.PropertyTransferCodeBlockGUIMenu;
import net.mcreator.puzzle_code.world.inventory.PropertyToNBTCodeBlockGUIMenu;
import net.mcreator.puzzle_code.world.inventory.PositionSetGUIMenu;
import net.mcreator.puzzle_code.world.inventory.NumberCodeBlockGuiMenu;
import net.mcreator.puzzle_code.world.inventory.NBTVerifierGUIMenu;
import net.mcreator.puzzle_code.world.inventory.NBTToPropertyCodeBlockGUIMenu;
import net.mcreator.puzzle_code.world.inventory.MessagerBlockGUIMenu;
import net.mcreator.puzzle_code.world.inventory.LogicCodeBlockGuiMenu;
import net.mcreator.puzzle_code.world.inventory.ItemCodeBlockGUIMenu;
import net.mcreator.puzzle_code.world.inventory.InventoryReplacerGUIMenu;
import net.mcreator.puzzle_code.world.inventory.InventoryReplacerGUI4Menu;
import net.mcreator.puzzle_code.world.inventory.InventoryReplacerGUI3Menu;
import net.mcreator.puzzle_code.world.inventory.InventoryReplacerGUI2Menu;
import net.mcreator.puzzle_code.world.inventory.InEffectBlocksGuiMenu;
import net.mcreator.puzzle_code.world.inventory.InEffectBlocksGui2Menu;
import net.mcreator.puzzle_code.world.inventory.ImitatorTextCodeBlockGUIMenu;
import net.mcreator.puzzle_code.world.inventory.ImitatorNumberCodeBlockGUIMenu;
import net.mcreator.puzzle_code.world.inventory.ImitatorLogicCodeBlockGUIMenu;
import net.mcreator.puzzle_code.world.inventory.ImitatorItemCodeBlockGUIMenu;
import net.mcreator.puzzle_code.world.inventory.ImitatorItemCodeBlockGUI2Menu;
import net.mcreator.puzzle_code.world.inventory.HealthChangerBlockGUIMenu;
import net.mcreator.puzzle_code.world.inventory.FillerGui2Menu;
import net.mcreator.puzzle_code.world.inventory.FillerGui1Menu;
import net.mcreator.puzzle_code.world.inventory.FillerCodeBlockGUI3Menu;
import net.mcreator.puzzle_code.world.inventory.FillerCodeBlockGUI2Menu;
import net.mcreator.puzzle_code.world.inventory.FillerCodeBlockGUI1Menu;
import net.mcreator.puzzle_code.world.inventory.EffectBlocksGuiMenu;
import net.mcreator.puzzle_code.world.inventory.EffectBlocksGui2Menu;
import net.mcreator.puzzle_code.world.inventory.CreativeSettingsGUIMenu;
import net.mcreator.puzzle_code.world.inventory.CreativeSettingsGUIGamerulesMenu;
import net.mcreator.puzzle_code.world.inventory.CreativeSettingsGUICreativeItemsMenu;
import net.mcreator.puzzle_code.world.inventory.CommandCodeBlockGUIMenu;
import net.mcreator.puzzle_code.world.inventory.AdvencedTimeBlockGuiMenu;
import net.mcreator.puzzle_code.world.inventory.AdvancedTeleporterBlockGuiMenu;
import net.mcreator.puzzle_code.world.inventory.AdvancedPlacerGUIMenu;
import net.mcreator.puzzle_code.world.inventory.ABlockIsBrokenGlobalBlockGUIMenu;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class PuzzleCodeModMenus {
	private static final List<MenuType<?>> REGISTRY = new ArrayList<>();
	public static final MenuType<CreativeSettingsGUIMenu> CREATIVE_SETTINGS_GUI = register("creative_settings_gui",
			(id, inv, extraData) -> new CreativeSettingsGUIMenu(id, inv, extraData));
	public static final MenuType<EffectBlocksGuiMenu> EFFECT_BLOCKS_GUI = register("effect_blocks_gui",
			(id, inv, extraData) -> new EffectBlocksGuiMenu(id, inv, extraData));
	public static final MenuType<AdvancedTeleporterBlockGuiMenu> ADVANCED_TELEPORTER_BLOCK_GUI = register("advanced_teleporter_block_gui",
			(id, inv, extraData) -> new AdvancedTeleporterBlockGuiMenu(id, inv, extraData));
	public static final MenuType<AdvencedTimeBlockGuiMenu> ADVENCED_TIME_BLOCK_GUI = register("advenced_time_block_gui",
			(id, inv, extraData) -> new AdvencedTimeBlockGuiMenu(id, inv, extraData));
	public static final MenuType<AdvancedPlacerGUIMenu> ADVANCED_PLACER_GUI = register("advanced_placer_gui",
			(id, inv, extraData) -> new AdvancedPlacerGUIMenu(id, inv, extraData));
	public static final MenuType<EffectBlocksGui2Menu> EFFECT_BLOCKS_GUI_2 = register("effect_blocks_gui_2",
			(id, inv, extraData) -> new EffectBlocksGui2Menu(id, inv, extraData));
	public static final MenuType<InEffectBlocksGuiMenu> IN_EFFECT_BLOCKS_GUI = register("in_effect_blocks_gui",
			(id, inv, extraData) -> new InEffectBlocksGuiMenu(id, inv, extraData));
	public static final MenuType<YellowSwicherBlockGUIMenu> YELLOW_SWICHER_BLOCK_GUI = register("yellow_swicher_block_gui",
			(id, inv, extraData) -> new YellowSwicherBlockGUIMenu(id, inv, extraData));
	public static final MenuType<WalkingBlockGUIMenu> WALKING_BLOCK_GUI = register("walking_block_gui",
			(id, inv, extraData) -> new WalkingBlockGUIMenu(id, inv, extraData));
	public static final MenuType<HealthChangerBlockGUIMenu> HEALTH_CHANGER_BLOCK_GUI = register("health_changer_block_gui",
			(id, inv, extraData) -> new HealthChangerBlockGUIMenu(id, inv, extraData));
	public static final MenuType<NumberCodeBlockGuiMenu> NUMBER_CODE_BLOCK_GUI = register("number_code_block_gui",
			(id, inv, extraData) -> new NumberCodeBlockGuiMenu(id, inv, extraData));
	public static final MenuType<LogicCodeBlockGuiMenu> LOGIC_CODE_BLOCK_GUI = register("logic_code_block_gui",
			(id, inv, extraData) -> new LogicCodeBlockGuiMenu(id, inv, extraData));
	public static final MenuType<TextCodeBlockGuiMenu> TEXT_CODE_BLOCK_GUI = register("text_code_block_gui",
			(id, inv, extraData) -> new TextCodeBlockGuiMenu(id, inv, extraData));
	public static final MenuType<ReplacerGUIMenu> REPLACER_GUI = register("replacer_gui",
			(id, inv, extraData) -> new ReplacerGUIMenu(id, inv, extraData));
	public static final MenuType<MessagerBlockGUIMenu> MESSAGER_BLOCK_GUI = register("messager_block_gui",
			(id, inv, extraData) -> new MessagerBlockGUIMenu(id, inv, extraData));
	public static final MenuType<ItemCodeBlockGUIMenu> ITEM_CODE_BLOCK_GUI = register("item_code_block_gui",
			(id, inv, extraData) -> new ItemCodeBlockGUIMenu(id, inv, extraData));
	public static final MenuType<CommandCodeBlockGUIMenu> COMMAND_CODE_BLOCK_GUI = register("command_code_block_gui",
			(id, inv, extraData) -> new CommandCodeBlockGUIMenu(id, inv, extraData));
	public static final MenuType<PositionSetGUIMenu> POSITION_SET_GUI = register("position_set_gui",
			(id, inv, extraData) -> new PositionSetGUIMenu(id, inv, extraData));
	public static final MenuType<CreativeSettingsGUICreativeItemsMenu> CREATIVE_SETTINGS_GUI_CREATIVE_ITEMS = register(
			"creative_settings_gui_creative_items", (id, inv, extraData) -> new CreativeSettingsGUICreativeItemsMenu(id, inv, extraData));
	public static final MenuType<PuzzleCrafterGUIMenu> PUZZLE_CRAFTER_GUI = register("puzzle_crafter_gui",
			(id, inv, extraData) -> new PuzzleCrafterGUIMenu(id, inv, extraData));
	public static final MenuType<FillerGui1Menu> FILLER_GUI_1 = register("filler_gui_1",
			(id, inv, extraData) -> new FillerGui1Menu(id, inv, extraData));
	public static final MenuType<FillerGui2Menu> FILLER_GUI_2 = register("filler_gui_2",
			(id, inv, extraData) -> new FillerGui2Menu(id, inv, extraData));
	public static final MenuType<RandomizerNumberCodeBlockGUIMenu> RANDOMIZER_NUMBER_CODE_BLOCK_GUI = register("randomizer_number_code_block_gui",
			(id, inv, extraData) -> new RandomizerNumberCodeBlockGUIMenu(id, inv, extraData));
	public static final MenuType<CreativeSettingsGUIGamerulesMenu> CREATIVE_SETTINGS_GUI_GAMERULES = register("creative_settings_gui_gamerules",
			(id, inv, extraData) -> new CreativeSettingsGUIGamerulesMenu(id, inv, extraData));
	public static final MenuType<ABlockIsBrokenGlobalBlockGUIMenu> A_BLOCK_IS_BROKEN_GLOBAL_BLOCK_GUI = register("a_block_is_broken_global_block_gui",
			(id, inv, extraData) -> new ABlockIsBrokenGlobalBlockGUIMenu(id, inv, extraData));
	public static final MenuType<TitleTextCodeBlockGUIMenu> TITLE_TEXT_CODE_BLOCK_GUI = register("title_text_code_block_gui",
			(id, inv, extraData) -> new TitleTextCodeBlockGUIMenu(id, inv, extraData));
	public static final MenuType<InventoryReplacerGUIMenu> INVENTORY_REPLACER_GUI = register("inventory_replacer_gui",
			(id, inv, extraData) -> new InventoryReplacerGUIMenu(id, inv, extraData));
	public static final MenuType<InventoryReplacerGUI2Menu> INVENTORY_REPLACER_GUI_2 = register("inventory_replacer_gui_2",
			(id, inv, extraData) -> new InventoryReplacerGUI2Menu(id, inv, extraData));
	public static final MenuType<InventoryReplacerGUI3Menu> INVENTORY_REPLACER_GUI_3 = register("inventory_replacer_gui_3",
			(id, inv, extraData) -> new InventoryReplacerGUI3Menu(id, inv, extraData));
	public static final MenuType<InventoryReplacerGUI4Menu> INVENTORY_REPLACER_GUI_4 = register("inventory_replacer_gui_4",
			(id, inv, extraData) -> new InventoryReplacerGUI4Menu(id, inv, extraData));
	public static final MenuType<InEffectBlocksGui2Menu> IN_EFFECT_BLOCKS_GUI_2 = register("in_effect_blocks_gui_2",
			(id, inv, extraData) -> new InEffectBlocksGui2Menu(id, inv, extraData));
	public static final MenuType<ImitatorItemCodeBlockGUIMenu> IMITATOR_ITEM_CODE_BLOCK_GUI = register("imitator_item_code_block_gui",
			(id, inv, extraData) -> new ImitatorItemCodeBlockGUIMenu(id, inv, extraData));
	public static final MenuType<ImitatorItemCodeBlockGUI2Menu> IMITATOR_ITEM_CODE_BLOCK_GUI_2 = register("imitator_item_code_block_gui_2",
			(id, inv, extraData) -> new ImitatorItemCodeBlockGUI2Menu(id, inv, extraData));
	public static final MenuType<SwitchableTermsNumberCodeBlockGUIMenu> SWITCHABLE_TERMS_NUMBER_CODE_BLOCK_GUI = register(
			"switchable_terms_number_code_block_gui", (id, inv, extraData) -> new SwitchableTermsNumberCodeBlockGUIMenu(id, inv, extraData));
	public static final MenuType<UnswitchableTermsNumberCodeBlockGUIMenu> UNSWITCHABLE_TERMS_NUMBER_CODE_BLOCK_GUI = register(
			"unswitchable_terms_number_code_block_gui", (id, inv, extraData) -> new UnswitchableTermsNumberCodeBlockGUIMenu(id, inv, extraData));
	public static final MenuType<TransferItemCodeBlockGUIMenu> TRANSFER_ITEM_CODE_BLOCK_GUI = register("transfer_item_code_block_gui",
			(id, inv, extraData) -> new TransferItemCodeBlockGUIMenu(id, inv, extraData));
	public static final MenuType<TeleporterItemCodeBlockGUI1Menu> TELEPORTER_ITEM_CODE_BLOCK_GUI_1 = register("teleporter_item_code_block_gui_1",
			(id, inv, extraData) -> new TeleporterItemCodeBlockGUI1Menu(id, inv, extraData));
	public static final MenuType<TeleporterItemCodeBlockGUI2Menu> TELEPORTER_ITEM_CODE_BLOCK_GUI_2 = register("teleporter_item_code_block_gui_2",
			(id, inv, extraData) -> new TeleporterItemCodeBlockGUI2Menu(id, inv, extraData));
	public static final MenuType<NBTVerifierGUIMenu> NBT_VERIFIER_GUI = register("nbt_verifier_gui",
			(id, inv, extraData) -> new NBTVerifierGUIMenu(id, inv, extraData));
	public static final MenuType<TransferCodeBlockGUIMenu> TRANSFER_CODE_BLOCK_GUI = register("transfer_code_block_gui",
			(id, inv, extraData) -> new TransferCodeBlockGUIMenu(id, inv, extraData));
	public static final MenuType<TeleporterNumberCodeBlockGUIMenu> TELEPORTER_NUMBER_CODE_BLOCK_GUI = register("teleporter_number_code_block_gui",
			(id, inv, extraData) -> new TeleporterNumberCodeBlockGUIMenu(id, inv, extraData));
	public static final MenuType<ImitatorNumberCodeBlockGUIMenu> IMITATOR_NUMBER_CODE_BLOCK_GUI = register("imitator_number_code_block_gui",
			(id, inv, extraData) -> new ImitatorNumberCodeBlockGUIMenu(id, inv, extraData));
	public static final MenuType<TeleporterNumberCodeBlockGUI2Menu> TELEPORTER_NUMBER_CODE_BLOCK_GUI_2 = register(
			"teleporter_number_code_block_gui_2", (id, inv, extraData) -> new TeleporterNumberCodeBlockGUI2Menu(id, inv, extraData));
	public static final MenuType<ImitatorLogicCodeBlockGUIMenu> IMITATOR_LOGIC_CODE_BLOCK_GUI = register("imitator_logic_code_block_gui",
			(id, inv, extraData) -> new ImitatorLogicCodeBlockGUIMenu(id, inv, extraData));
	public static final MenuType<TeleporterLogicCodeBlockGUI2Menu> TELEPORTER_LOGIC_CODE_BLOCK_GUI_2 = register("teleporter_logic_code_block_gui_2",
			(id, inv, extraData) -> new TeleporterLogicCodeBlockGUI2Menu(id, inv, extraData));
	public static final MenuType<TeleporterLogicCodeBlockGUIMenu> TELEPORTER_LOGIC_CODE_BLOCK_GUI = register("teleporter_logic_code_block_gui",
			(id, inv, extraData) -> new TeleporterLogicCodeBlockGUIMenu(id, inv, extraData));
	public static final MenuType<ImitatorTextCodeBlockGUIMenu> IMITATOR_TEXT_CODE_BLOCK_GUI = register("imitator_text_code_block_gui",
			(id, inv, extraData) -> new ImitatorTextCodeBlockGUIMenu(id, inv, extraData));
	public static final MenuType<TeleporterTextCodeBlockGUIMenu> TELEPORTER_TEXT_CODE_BLOCK_GUI = register("teleporter_text_code_block_gui",
			(id, inv, extraData) -> new TeleporterTextCodeBlockGUIMenu(id, inv, extraData));
	public static final MenuType<TeleporterTextCodeBlockGUI2Menu> TELEPORTER_TEXT_CODE_BLOCK_GUI_2 = register("teleporter_text_code_block_gui_2",
			(id, inv, extraData) -> new TeleporterTextCodeBlockGUI2Menu(id, inv, extraData));
	public static final MenuType<PropertyToNBTCodeBlockGUIMenu> PROPERTY_TO_NBT_CODE_BLOCK_GUI = register("property_to_nbt_code_block_gui",
			(id, inv, extraData) -> new PropertyToNBTCodeBlockGUIMenu(id, inv, extraData));
	public static final MenuType<NBTToPropertyCodeBlockGUIMenu> NBT_TO_PROPERTY_CODE_BLOCK_GUI = register("nbt_to_property_code_block_gui",
			(id, inv, extraData) -> new NBTToPropertyCodeBlockGUIMenu(id, inv, extraData));
	public static final MenuType<PropertyTransferCodeBlockGUIMenu> PROPERTY_TRANSFER_CODE_BLOCK_GUI = register("property_transfer_code_block_gui",
			(id, inv, extraData) -> new PropertyTransferCodeBlockGUIMenu(id, inv, extraData));
	public static final MenuType<FillerCodeBlockGUI1Menu> FILLER_CODE_BLOCK_GUI_1 = register("filler_code_block_gui_1",
			(id, inv, extraData) -> new FillerCodeBlockGUI1Menu(id, inv, extraData));
	public static final MenuType<FillerCodeBlockGUI2Menu> FILLER_CODE_BLOCK_GUI_2 = register("filler_code_block_gui_2",
			(id, inv, extraData) -> new FillerCodeBlockGUI2Menu(id, inv, extraData));
	public static final MenuType<FillerCodeBlockGUI3Menu> FILLER_CODE_BLOCK_GUI_3 = register("filler_code_block_gui_3",
			(id, inv, extraData) -> new FillerCodeBlockGUI3Menu(id, inv, extraData));

	private static <T extends AbstractContainerMenu> MenuType<T> register(String registryname, IContainerFactory<T> containerFactory) {
		MenuType<T> menuType = new MenuType<T>(containerFactory);
		menuType.setRegistryName(registryname);
		REGISTRY.add(menuType);
		return menuType;
	}

	@SubscribeEvent
	public static void registerContainers(RegistryEvent.Register<MenuType<?>> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new MenuType[0]));
	}
}
