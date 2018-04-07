package com.eel.PhantomCraft;



import org.apache.logging.log4j.Logger;

import com.eel.PhantomCraft.common.CommonProxy;
import com.eel.PhantomCraft.item.ItemLoader;

import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid="phantomcraft",name="PhantomCraft",version="0.3",acceptedMinecraftVersions="1.12.2")
public class PhantomCraft {
	
	public static final String ModID = "phantomcraft";
	
	@Instance(ModID)
    public static PhantomCraft instance;
	private Logger logger;
	
	@SidedProxy(clientSide = "com.eel.PhantomCraft.client.ClientProxy", 
            serverSide = "com.eel.PhantomCraft.common.CommonProxy")
    public static CommonProxy proxy;
	
	 @EventHandler
	    public void preInit(FMLPreInitializationEvent event)
	    {
		 	logger = event.getModLog();
	        proxy.preInit(event);
	    }

	    @EventHandler
	    public void init(FMLInitializationEvent event)
	    {
	        proxy.init(event);
	    }

	    @EventHandler
	    public void postInit(FMLPostInitializationEvent event)
	    {
	        proxy.postInit(event);
	    }
	    
	    public Logger getLogger()
	    {
	        return logger;
	    }

}