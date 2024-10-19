package chaching.block;

import chaching.Chaching;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
	public static final Block CONVERTER_BLOCK = registerBlock("converter_block", new ConverterBlock(AbstractBlock.Settings.create().sounds(BlockSoundGroup.METAL)), true);

	private static void addBlocksToFunctionalTab(FabricItemGroupEntries entries) {
		entries.add(CONVERTER_BLOCK.asItem());
	}

	private static Block registerBlock(String name, Block block, boolean shouldRegisterItem) {
		Identifier id = Identifier.of(Chaching.MOD_ID, name);

		if (shouldRegisterItem) {
			Registry.register(Registries.ITEM, id, new BlockItem(block, new Item.Settings()));
		}

		return Registry.register(Registries.BLOCK, id, block);
	}

	public static void init() {
		// This method is called from Chaching.onInitialize()
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(ModBlocks::addBlocksToFunctionalTab);
	}
}
