package jlcat.bstools.item.equipment;

import java.util.List;

import jlcat.bstools.BSTools;
import jlcat.bstools.common.BSToolsTab;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBetterSword extends ItemSword implements IItemEquipment {

	private static final String name = "sword";
	private static final ItemBetterSword instance = new ItemBetterSword();

	private ItemBetterSword() {
		super(ItemEquipmentUtils.TOOLS_MATERIAL);
		setUnlocalizedName(name);
		setCreativeTab(BSToolsTab.TAB_BSTOOLS);
		setRegistryName(new ResourceLocation(BSTools.MOD_ID, name));
		GameRegistry.register(this);
	}

	public static final ItemBetterSword instance() {
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
