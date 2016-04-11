package jlcat.bstools.item.items;

import jlcat.bstools.BSTools;
import jlcat.bstools.common.BSToolsTab;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBasicItems extends Item {

	private static final String name_bluestone = "bluestone";
	private static final String name_reinforced_stick = "reinforced_stick";
	private static final String name_bluediamond = "bluediamond";
	private static final String name_nether_essence = "nether_essence";
	private static final String name_rope = "rope";

	private static final ItemBasicItems bluestone = new ItemBasicItems(name_bluestone);
	private static final ItemBasicItems reinforced_stick = new ItemBasicItems(name_reinforced_stick);
	private static final ItemBasicItems bluediamond = new ItemBasicItems(name_bluediamond);
	private static final ItemBasicItems nether_essence = new ItemBasicItems(name_nether_essence);
	private static final ItemBasicItems rope = new ItemBasicItems(name_rope);

	private ItemBasicItems(String name) {
		super();
		setUnlocalizedName(name);
		setCreativeTab(BSToolsTab.TAB_BSTOOLS);
		setRegistryName(new ResourceLocation(BSTools.MOD_ID, name));
		GameRegistry.register(this);
	}

	public static final ItemBasicItems instance(String name) {
		if (name_bluestone.equals(name))
			return bluestone;
		if (name_reinforced_stick.equals(name))
			return reinforced_stick;
		if (name_bluediamond.equals(name))
			return bluediamond;
		if (name_nether_essence.equals(name))
			return nether_essence;
		if (name_rope.equals(name))
			return rope;
		return null;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack) {
		return this.getUnlocalizedName().substring(5).equals("nether_essence");
	}

}
