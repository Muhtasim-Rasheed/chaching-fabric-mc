package chaching.item;

import chaching.Chaching;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroupEntries;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
	public static final Item CASH = registerItem("cash", new CashItem(new Item.Settings()));

	private static void addItemsToFunctionalTab(FabricItemGroupEntries entries) {
		entries.add(CASH);
	}

	private static Item registerItem(String name, Item item) {
		Identifier id = Identifier.of(Chaching.MOD_ID, name);

		return Registry.register(Registries.ITEM, id, item);
	}

	public static void init() {
		// This method is called from Chaching.onInitialize()
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(ModItems::addItemsToFunctionalTab);
	}
}
