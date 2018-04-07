package com.eel.PhantomCraft.common;

import com.eel.PhantomCraft.ItemRenderLoader;
import com.eel.PhantomCraft.block.BlockLoader;
import com.eel.PhantomCraft.crafting.CraftingLoader;
import com.eel.PhantomCraft.item.ItemLoader;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy
{
    public void preInit(FMLPreInitializationEvent event)
    {
    	new ItemLoader(event);
    	new BlockLoader(event);
    }

    public void init(FMLInitializationEvent event)
    {
    	new CraftingLoader();
    	new EventLoader();
    }

    public void postInit(FMLPostInitializationEvent event)
    {

    }
}