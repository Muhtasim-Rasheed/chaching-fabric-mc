package chaching.block;

import chaching.Chaching;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlocks {
	private static Block registerBlock(String name, Block block, boolean shouldRegisterItem) {
		Identifier id = Identifier.of(Chaching.MOD_ID, name);

		if (shouldRegisterItem) {
			Registry.register(Registries.ITEM, id, new BlockItem(block, new Item.Settings()));
		}

		return Registry.register(Registries.BLOCK, id, block);
	}
}
