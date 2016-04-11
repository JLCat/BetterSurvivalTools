package jlcat.bstools.item.equipment;

import java.util.List;

import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.common.util.EnumHelper;

public class ItemEquipmentUtils {

	protected static final ArmorMaterial ARMOR_MATERIAL = EnumHelper.addArmorMaterial("bluediamond", "bstools:bluediamond", 40, new int[] { 3, 6, 8, 3 }, 30, null);
	protected static final ToolMaterial TOOLS_MATERIAL = EnumHelper.addToolMaterial("bluediamond", 3, 2000, 9.0F, 4.0F, 30);

	protected static boolean isEquipmentItem(ItemStack itemStack) {

		if (itemStack == null) {
			return false;
		}

		if (itemStack.getItem() instanceof IItemEquipment) {
			return true;
		}
		return false;
	}

	protected static boolean isUpgraded(ItemStack itemStack) {

		if (itemStack == null) {
			return false;
		}

		if (isEquipmentItem(itemStack)) {
			if (itemStack.hasTagCompound() && itemStack.getTagCompound().hasKey("Upgraded")) {
				if (itemStack.getTagCompound().getInteger("Upgraded") == 1) {
					return true;
				}
			}
		}
		return false;
	}

	protected static void addInfo(ItemStack stack, List<String> tooltip) {

		if (isUpgraded(stack)) {
			tooltip.add(TextFormatting.BLUE + I18n.translateToLocal("tooltip.is_upgraded"));
		} else {
			tooltip.add(TextFormatting.GRAY + I18n.translateToLocal("tooltip.not_upgraded"));
		}
	}

	protected static int[] armorCheck(EntityPlayer player) {

		int[] armorState = { 0, 0, 0, 0 };

		if (ItemEquipmentUtils.isUpgraded(player.getItemStackFromSlot(EntityEquipmentSlot.HEAD))) {
			armorState[0] = 2;
		} else if (ItemEquipmentUtils.isEquipmentItem(player.getItemStackFromSlot(EntityEquipmentSlot.HEAD))) {
			armorState[0] = 1;
		}

		if (ItemEquipmentUtils.isUpgraded(player.getItemStackFromSlot(EntityEquipmentSlot.CHEST))) {
			armorState[1] = 2;
		} else if (ItemEquipmentUtils.isEquipmentItem(player.getItemStackFromSlot(EntityEquipmentSlot.CHEST))) {
			armorState[1] = 1;
		}

		if (ItemEquipmentUtils.isUpgraded(player.getItemStackFromSlot(EntityEquipmentSlot.LEGS))) {
			armorState[2] = 2;
		} else if (ItemEquipmentUtils.isEquipmentItem(player.getItemStackFromSlot(EntityEquipmentSlot.LEGS))) {
			armorState[2] = 1;
		}

		if (ItemEquipmentUtils.isUpgraded(player.getItemStackFromSlot(EntityEquipmentSlot.FEET))) {
			armorState[3] = 2;
		} else if (ItemEquipmentUtils.isEquipmentItem(player.getItemStackFromSlot(EntityEquipmentSlot.FEET))) {
			armorState[3] = 1;
		}

		return armorState;
	}

	protected static void effectPlayer(EntityPlayer player, Potion potion, int amplifier) {
		if (player.getActivePotionEffect(potion) == null || player.getActivePotionEffect(potion).getDuration() < 600)
			player.addPotionEffect(new PotionEffect(potion, 600, amplifier, true, true));
	}
}
