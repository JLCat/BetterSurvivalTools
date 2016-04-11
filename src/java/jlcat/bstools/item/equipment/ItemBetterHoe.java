package jlcat.bstools.item.equipment;

import java.util.List;

import jlcat.bstools.BSTools;
import jlcat.bstools.common.BSToolsTab;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemHoe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBetterHoe extends ItemHoe implements IItemEquipment {

	private static final String name = "hoe";
	private static final ItemBetterHoe instance = new ItemBetterHoe();

	private ItemBetterHoe() {
		super(ItemEquipmentUtils.TOOLS_MATERIAL);
		setUnlocalizedName(name);
		setCreativeTab(BSToolsTab.TAB_BSTOOLS);
		setRegistryName(new ResourceLocation(BSTools.MOD_ID, name));
		GameRegistry.register(this);
	}

	public static final ItemBetterHoe instance() {
		return instance;
	}

	@Override
	public int getRepairCost() {
		return 2;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack stack) {
		return ItemEquipmentUtils.isUpgraded(stack);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void addInformation(ItemStack stack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		ItemEquipmentUtils.addInfo(stack, tooltip);
	}

	@Override
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		return false;
	}

}
