package jlcat.bstools.item.equipment;

import java.util.List;
import java.util.Set;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Sets;

import jlcat.bstools.BSTools;
import jlcat.bstools.common.BSToolsTab;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBetterAxe extends ItemTool implements IItemEquipment {

	private static final String name = "axe";
	private static final ItemBetterAxe instance = new ItemBetterAxe();

	private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(new Block[] { Blocks.planks, Blocks.bookshelf,
			Blocks.log, Blocks.log2, Blocks.chest, Blocks.pumpkin, Blocks.lit_pumpkin, Blocks.melon_block,
			Blocks.ladder, Blocks.wooden_button, Blocks.wooden_pressure_plate });

	private ItemBetterAxe() {
		super(ItemEquipmentUtils.TOOLS_MATERIAL, EFFECTIVE_ON);
		setUnlocalizedName(name);
		setCreativeTab(BSToolsTab.TAB_BSTOOLS);
		this.damageVsEntity = 9.0F;
		this.attackSpeed = -3.0F;
		setRegistryName(new ResourceLocation(BSTools.MOD_ID, name));
		GameRegistry.register(this);
	}

	@Override
	public Set<String> getToolClasses(ItemStack stack) {
		return ImmutableSet.of("axe");
	}

	@Override
	public float getStrVsBlock(ItemStack stack, IBlockState state) {
		Material material = state.getMaterial();
		return material != Material.wood && material != Material.plants && material != Material.vine ? 1.0F
				: this.efficiencyOnProperMaterial;
	}

	public static final ItemBetterAxe instance() {
		return instance;
	}

	@Override
	public int getRepairCost() {
		return 3;
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
