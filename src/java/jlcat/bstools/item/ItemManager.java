package jlcat.bstools.item;

import java.util.ArrayList;
import java.util.List;

import jlcat.bstools.item.equipment.ItemBetterArmor;
import jlcat.bstools.item.equipment.ItemBetterAxe;
import jlcat.bstools.item.equipment.ItemBetterHoe;
import jlcat.bstools.item.equipment.ItemBetterPickaxe;
import jlcat.bstools.item.equipment.ItemBetterShovel;
import jlcat.bstools.item.equipment.ItemBetterSword;
import jlcat.bstools.item.items.ItemBag;
import jlcat.bstools.item.items.ItemBasicItems;
import jlcat.bstools.item.items.ItemPlayerUpgrade;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;

public class ItemManager {

	private static List<Item> itemList = new ArrayList<Item>();

	public static void createItems() {

		// armor
		itemList.add(ItemBetterArmor.instance(EntityEquipmentSlot.HEAD));
		itemList.add(ItemBetterArmor.instance(EntityEquipmentSlot.CHEST));
		itemList.add(ItemBetterArmor.instance(EntityEquipmentSlot.LEGS));
		itemList.add(ItemBetterArmor.instance(EntityEquipmentSlot.FEET));

		// tools
		itemList.add(ItemBetterAxe.instance());
		itemList.add(ItemBetterHoe.instance());
		itemList.add(ItemBetterPickaxe.instance());
		itemList.add(ItemBetterShovel.instance());
		itemList.add(ItemBetterSword.instance());

		// items
		itemList.add(ItemBasicItems.instance("bluestone"));
		itemList.add(ItemBasicItems.instance("reinforced_stick"));
		itemList.add(ItemBasicItems.instance("bluediamond"));
		itemList.add(ItemBasicItems.instance("nether_essence"));
		itemList.add(ItemBasicItems.instance("rope"));

		// upgrades
		itemList.add(ItemPlayerUpgrade.instance("time_upgrade"));
		itemList.add(ItemPlayerUpgrade.instance("coordinates_upgrade"));
		itemList.add(ItemPlayerUpgrade.instance("craft_upgrade"));
		itemList.add(ItemPlayerUpgrade.instance("inventory_upgrade"));

		// bag
		itemList.add(ItemBag.instance());

	}

	public static List<Item> getItemList() {

		return itemList;
	}
}
