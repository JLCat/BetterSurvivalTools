package jlcat.bstools.common;

import jlcat.bstools.item.items.ItemBasicItems;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BSToolsTab extends CreativeTabs {
	
	public static final BSToolsTab TAB_BSTOOLS = new BSToolsTab("tabBSTools");
	
	public BSToolsTab(String label) {
		super(label);
	}

	@Override
	public Item getTabIconItem() {
		return ItemBasicItems.instance("nether_essence");
	}

}
