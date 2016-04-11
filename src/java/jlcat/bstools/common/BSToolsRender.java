package jlcat.bstools.common;

import java.util.List;

import jlcat.bstools.BSTools;
import jlcat.bstools.item.ItemManager;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;

public class BSToolsRender {

	public static void setResources() {
		List<Item> itemList = ItemManager.getItemList();
		if (!(itemList == null))
			for (Item item : itemList)
				regItem(item);
	}

	private static void regItem(Item item) {
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(
				new ResourceLocation(BSTools.MOD_ID, item.getUnlocalizedName().substring(5)), "inventory"));

	}

	/*
	 * private static void regBlock(Block block) {
	 * Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(
	 * Item.getItemFromBlock(block), 0, new
	 * ModelResourceLocation(BetterTools.MOD_ID + ":" +
	 * block.getUnlocalizedName().substring(5), "inventory")); }
	 */
}
