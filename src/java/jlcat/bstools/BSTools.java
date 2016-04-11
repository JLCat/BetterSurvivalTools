package jlcat.bstools;

import jlcat.bstools.internal.BSToolsProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = BSTools.MOD_ID, name = BSTools.MOD_NAME, version = BSTools.VERSION)
public class BSTools {

	public static final String MOD_ID = "BSTools";
	public static final String MOD_NAME = "Better Survival Tools";
	public static final String VERSION = "1.9-1.1.2";
	public static final String CLIENT_PROXY = "jlcat.bstools.internal.BSToolsClientProxy";
	public static final String SERVER_PROXY = "jlcat.bstools.internal.BSToolsProxy";

	@Instance(BSTools.MOD_ID)
	public static BSTools instance = new BSTools();
	
	@SidedProxy(clientSide = BSTools.CLIENT_PROXY, serverSide = BSTools.SERVER_PROXY)
	public static BSToolsProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		proxy.preInit(e);
	}

	@EventHandler
	public void init(FMLInitializationEvent e) {
		proxy.init(e);
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		proxy.postInit(e);
	}
}
