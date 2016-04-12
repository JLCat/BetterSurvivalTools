package jlcat.bstools.item.items;

import jlcat.bstools.BSTools;
import jlcat.bstools.common.BSToolsTab;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemPlayerUpgrade extends Item {

	private static final String name_timeUpgrade = "time_upgrade";
	private static final String name_coordinatesUpgrade = "coordinates_upgrade";
	private static final String name_craftUpgrade = "craft_upgrade";
	private static final String name_inventoryUpgrade = "inventory_upgrade";

	private static final ItemPlayerUpgrade time_upgrade = new ItemPlayerUpgrade(name_timeUpgrade);
	private static final ItemPlayerUpgrade coordinates_upgrade = new ItemPlayerUpgrade(name_coordinatesUpgrade);
	private static final ItemPlayerUpgrade craft_upgrade = new ItemPlayerUpgrade(name_craftUpgrade);
	private static final ItemPlayerUpgrade inventory_upgrade = new ItemPlayerUpgrade(name_inventoryUpgrade);

	private ItemPlayerUpgrade(String name) {
		super();
		setUnlocalizedName(name);
		setCreativeTab(BSToolsTab.TAB_BSTOOLS);
		setRegistryName(new ResourceLocation(BSTools.MOD_ID, name));
		GameRegistry.register(this);
	}

	public static final ItemPlayerUpgrade instance(String name) {
		if (name_timeUpgrade.equals(name))
			return time_upgrade;
		if (name_coordinatesUpgrade.equals(name))
			return coordinates_upgrade;
		if (name_craftUpgrade.equals(name))
			return craft_upgrade;
		if (name_inventoryUpgrade.equals(name))
			return inventory_upgrade;
		return null;
	}

	@Override
	public int getItemStackLimit() {
		return 1;
	}

	@Override
	public boolean hasEffect(ItemStack stack) {
		return false;
	}

	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return false;
	}

	@Override
	public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
		return false;
	}

}
