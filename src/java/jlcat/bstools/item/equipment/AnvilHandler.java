package jlcat.bstools.item.equipment;

import jlcat.bstools.item.items.ItemBasicItems;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class AnvilHandler {

	public static AnvilHandler instance = new AnvilHandler();

	@SubscribeEvent
	public void handleAnvilEvent(AnvilUpdateEvent evt) {

		if (evt.getLeft() == null || evt.getRight() == null) {
			return;
		}

		if (evt.getLeft().getItem() instanceof IItemEquipment) {
			if (evt.getRight().getItem() == ItemBasicItems.instance("bluediamond")) {
				handleRepair(evt);
			} else if (evt.getRight().getItem() == ItemBasicItems.instance("nether_essence")) {
				handleUpgrade(evt);
			}
		}
	}

	private void handleRepair(AnvilUpdateEvent evt) {

		ItemStack targetStack = evt.getLeft();
		ItemStack diamonds = evt.getRight();

		IItemEquipment targetItem = (IItemEquipment) targetStack.getItem();
		int maxDiamonds = targetItem.getRepairCost();

		double damPerc = (double) targetStack.getItemDamage() / targetStack.getMaxDamage();
		int required = (int) Math.ceil(damPerc * maxDiamonds);
		if (diamonds.stackSize > required) {
			return;
		}

		int damageAddedPerIngot = (int) Math.ceil((double) targetStack.getMaxDamage() / maxDiamonds);
		int totalDamageRemoved = damageAddedPerIngot * diamonds.stackSize;

		ItemStack resultStack = targetStack.copy();
		resultStack.setItemDamage(Math.max(0, resultStack.getItemDamage() - totalDamageRemoved));

		evt.setOutput(resultStack);
		evt.setCost(diamonds.stackSize * 2);
	}

	private void handleUpgrade(AnvilUpdateEvent evt) {

		ItemStack targetStack = evt.getLeft();
		ItemStack upgrades = evt.getRight();

		if (upgrades.stackSize > 1) {
			return;
		}

		if (!targetStack.hasTagCompound() || !targetStack.getTagCompound().hasKey("Upgraded") || targetStack.getTagCompound().getInteger("Upgraded") != 1) {
			ItemStack res = new ItemStack(evt.getLeft().getItem(), 1, evt.getLeft().getItemDamage());

			NBTTagCompound nbt = new NBTTagCompound();
			nbt.setInteger("Upgraded", 1);
			res.setTagCompound(nbt);

			evt.setOutput(res);
			evt.setCost(20);

		}
	}
}
