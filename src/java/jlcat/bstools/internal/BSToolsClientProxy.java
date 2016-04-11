package jlcat.bstools.internal;

import jlcat.bstools.common.BSToolsRender;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class BSToolsClientProxy extends BSToolsProxy {

	@Override
	public void preInit(FMLPreInitializationEvent e) {
		super.preInit(e);
		BSToolsRender.setResources();
	}

	@Override
	public void init(FMLInitializationEvent e) {
		super.init(e);
	}

	@Override
	public void postInit(FMLPostInitializationEvent e) {
		super.postInit(e);
	}

}
