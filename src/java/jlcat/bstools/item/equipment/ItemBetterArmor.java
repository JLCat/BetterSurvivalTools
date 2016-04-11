package jlcat.bstools.item.equipment;

import java.util.List;

import jlcat.bstools.BSTools;
import jlcat.bstools.common.BSToolsTab;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemBetterArmor extends ItemArmor implements IItemEquipment {

	private static final String name_helmet = "helmet";
	private static final String name_chestplate = "chestplate";
	private static final String name_leggings = "leggings";
	private static final String name_boots = "boots";

	private static final ItemBetterArmor helmet = new ItemBetterArmor(name_helmet, 1, EntityEquipmentSlot.HEAD);
	private static final ItemBetterArmor chestplate = new ItemBetterArmor(name_chestplate, 1, EntityEquipmentSlot.CHEST);
	private static final ItemBetterArmor leggings = new ItemBetterArmor(name_leggings, 2, EntityEquipmentSlot.LEGS);
	private static final ItemBetterArmor boots = new ItemBetterArmor(name_boots, 1, EntityEquipmentSlot.FEET);

	private ItemBetterArmor(String name, int renderIndex, EntityEquipmentSlot equipmentSlot) {
		super(ItemEquipmentUtils.ARMOR_MATERIAL, renderIndex, equipmentSlot);
		setUnlocalizedName(name);
		setCreativeTab(BSToolsTab.TAB_BSTOOLS);
		setRegistryName(new ResourceLocation(BSTools.MOD_ID, name));
		GameRegistry.register(this);
	}

	public static final ItemBetterArmor instance(EntityEquipmentSlot equipmentSlot) {
		switch (equipmentSlot) {
		case HEAD:
			return helmet;
		case CHEST:
			return chestplate;
		case LEGS:
			return leggings;
		case FEET:
			return boots;
		default:
			return null;
		}
	}

	@Override
	public int getRepairCost() {
		switch (armorType) {
		case HEAD:
			return 5;
		case CHEST:
			return 8;
		case LEGS:
			return 7;
		case FEET:
			return 4;
		default:
			return 0;
		}
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

	private int[] armorState = { 0, 0, 0, 0 };

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {

		armorState = ItemEquipmentUtils.armorCheck(player);

		if (armorState[0] == 1) {
			ItemEquipmentUtils.effectPlayer(player, Potion.getPotionById(16), 0);
		} else if (armorState[0] == 2) {
			ItemEquipmentUtils.effectPlayer(player, Potion.getPotionById(16), 0);
			ItemEquipmentUtils.effectPlayer(player, Potion.getPotionById(13), 0);
		}

		if (armorState[1] == 1) {
			ItemEquipmentUtils.effectPlayer(player, Potion.getPotionById(3), 0);
		} else if (armorState[1] == 2) {
			ItemEquipmentUtils.effectPlayer(player, Potion.getPotionById(3), 1);
		}

		if (armorState[2] == 1) {
			ItemEquipmentUtils.effectPlayer(player, Potion.getPotionById(1), 0);
		} else if (armorState[2] == 2) {
			ItemEquipmentUtils.effectPlayer(player, Potion.getPotionById(1), 1);
		}

		if (armorState[3] == 1) {
			ItemEquipmentUtils.effectPlayer(player, Potion.getPotionById(8), 0);
		} else if (armorState[3] == 2) {
			ItemEquipmentUtils.effectPlayer(player, Potion.getPotionById(8), 1);
		}

		if (armorState[0] == 2 && armorState[1] == 2 && armorState[2] == 2 && armorState[3] == 2) {
			ItemEquipmentUtils.effectPlayer(player, Potion.getPotionById(5), 1);
			player.capabilities.allowFlying = true;
		} else if (armorState[0] > 0 && armorState[1] > 0 && armorState[2] > 0 && armorState[3] > 0) {
			ItemEquipmentUtils.effectPlayer(player, Potion.getPotionById(5), 0);
			if (!player.isCreative() && !player.isSpectator()) {
				player.capabilities.allowFlying = false;
				player.capabilities.isFlying = false;
			}
		} else {
			if (!player.isCreative() && !player.isSpectator()) {
				player.capabilities.allowFlying = false;
				player.capabilities.isFlying = false;
			}
		}
	}
}
