package jlcat.bstools.internal;

import jlcat.bstools.BSTools;
import jlcat.bstools.common.BSToolsRecipe;
import jlcat.bstools.eventhandler.AnvilHandler;
import jlcat.bstools.gui.ModGuiHandler;
import jlcat.bstools.item.ItemManager;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;

public class BSToolsProxy {

	public void preInit(FMLPreInitializationEvent e) {
		ItemManager.createItems();
		MinecraftForge.EVENT_BUS.register(AnvilHandler.getInstance());
	}

	public void init(FMLInitializationEvent e) {
		BSToolsRecipe.regRecipe();
		NetworkRegistry.INSTANCE.registerGuiHandler(BSTools.instance, new ModGuiHandler());
	}

	public void postInit(FMLPostInitializationEvent e) {
	}
}
