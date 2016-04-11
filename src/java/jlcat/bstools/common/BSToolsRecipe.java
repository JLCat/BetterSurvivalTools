package jlcat.bstools.common;

import jlcat.bstools.item.equipment.ItemBetterArmor;
import jlcat.bstools.item.equipment.ItemBetterAxe;
import jlcat.bstools.item.equipment.ItemBetterHoe;
import jlcat.bstools.item.equipment.ItemBetterPickaxe;
import jlcat.bstools.item.equipment.ItemBetterShovel;
import jlcat.bstools.item.equipment.ItemBetterSword;
import jlcat.bstools.item.items.ItemBag;
import jlcat.bstools.item.items.ItemBasicItems;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class BSToolsRecipe {

	public static void regRecipe() {
		regShapelessRecipe();
		regShapeRecipe();
	}

	private static void regShapelessRecipe() {
		GameRegistry.addShapelessRecipe(new ItemStack(ItemBasicItems.instance("bluestone"), 2), Items.redstone, new ItemStack(Items.dye, 1, 4));
	}

	private static void regShapeRecipe() {
		GameRegistry.addRecipe(new ItemStack(ItemBasicItems.instance("reinforced_stick")), "BGB", "GSG", "BGB", 'G', Items.gold_nugget, 'B', ItemBasicItems.instance("bluestone"), 'S', Items.stick);
		GameRegistry.addRecipe(new ItemStack(ItemBasicItems.instance("bluediamond")), "BGB", "GDG", "BGB", 'G', Items.gold_ingot, 'B', ItemBasicItems.instance("bluestone"), 'D', Items.diamond);
		GameRegistry.addRecipe(new ItemStack(ItemBasicItems.instance("nether_essence"), 4), "DDD", "DND", "DDD", 'D', ItemBasicItems.instance("bluediamond"), 'N', Items.nether_star);
		GameRegistry.addRecipe(new ItemStack(ItemBag.instance()), "LLL", "RBR", "LLL", 'L', Items.leather, 'R', ItemBasicItems.instance("rope"), 'B', ItemBasicItems.instance("bluestone"));
		GameRegistry.addRecipe(new ItemStack(ItemBasicItems.instance("rope")), "V V", " V ", "V V", 'V', Blocks.vine);
		GameRegistry.addRecipe(new ItemStack(ItemBasicItems.instance("rope")), "V V", " V ", "V V", 'V', Blocks.tallgrass);

		GameRegistry.addRecipe(new ItemStack(ItemBetterAxe.instance()), "##", "#S", " S", '#', ItemBasicItems.instance("bluediamond"), 'S', ItemBasicItems.instance("reinforced_stick"));
		GameRegistry.addRecipe(new ItemStack(ItemBetterHoe.instance()), "##", " S", " S", '#', ItemBasicItems.instance("bluediamond"), 'S', ItemBasicItems.instance("reinforced_stick"));
		GameRegistry.addRecipe(new ItemStack(ItemBetterPickaxe.instance()), "###", " S ", " S ", '#', ItemBasicItems.instance("bluediamond"), 'S', ItemBasicItems.instance("reinforced_stick"));
		GameRegistry.addRecipe(new ItemStack(ItemBetterShovel.instance()), "#", "S", "S", '#', ItemBasicItems.instance("bluediamond"), 'S', ItemBasicItems.instance("reinforced_stick"));
		GameRegistry.addRecipe(new ItemStack(ItemBetterSword.instance()), "#", "#", "S", '#', ItemBasicItems.instance("bluediamond"), 'S', ItemBasicItems.instance("reinforced_stick"));

		GameRegistry.addRecipe(new ItemStack(ItemBetterArmor.instance(EntityEquipmentSlot.HEAD)), "###", "# #", "   ", '#', ItemBasicItems.instance("bluediamond"));
		GameRegistry.addRecipe(new ItemStack(ItemBetterArmor.instance(EntityEquipmentSlot.CHEST)), "# #", "###", "###", '#', ItemBasicItems.instance("bluediamond"));
		GameRegistry.addRecipe(new ItemStack(ItemBetterArmor.instance(EntityEquipmentSlot.LEGS)), "###", "# #", "# #", '#', ItemBasicItems.instance("bluediamond"));
		GameRegistry.addRecipe(new ItemStack(ItemBetterArmor.instance(EntityEquipmentSlot.FEET)), "   ", "# #", "# #", '#', ItemBasicItems.instance("bluediamond"));
	}

}