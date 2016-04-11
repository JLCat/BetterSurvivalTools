package jlcat.bstools.gui;

import jlcat.bstools.inventory.ContainerBag;
import jlcat.bstools.inventory.InventoryBag;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class ModGuiHandler implements IGuiHandler {

	public static final int GUI_BAG = 1;

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == GUI_BAG)
			return new ContainerBag(player.inventory, new InventoryBag(player.getHeldItemMainhand()), player);
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == GUI_BAG)
			return new GuiBag(player.inventory, new InventoryBag(player.getHeldItemMainhand()), player);
		return null;
	}
}