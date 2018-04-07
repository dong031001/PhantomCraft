package com.eel.PhantomCraft.crafting;

import com.eel.PhantomCraft.block.BlockLoader;
import com.eel.PhantomCraft.item.ItemLoader;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.IFuelHandler;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class CraftingLoader
{
    public CraftingLoader()
    {
        registerSmelting();
        registerFuel();
    }

    private static void registerSmelting()
    {
    	GameRegistry.addSmelting(BlockLoader.blockPhantomEssenceBlock, new ItemStack(ItemLoader.concentratedPhantomEssence), 1F);
    }

    private static void registerFuel()
    {
    	GameRegistry.registerFuelHandler(new IFuelHandler()
        {
            @Override
            public int getBurnTime(ItemStack fuel)
            {
                return ItemLoader.phantomEssence != fuel.getItem() ? 0 : 600;
            }
        });
    	GameRegistry.registerFuelHandler(new IFuelHandler()
        {
            @Override
            public int getBurnTime(ItemStack fuel)
            {
                return ItemLoader.concentratedPhantomEssence != fuel.getItem() ? 0 : 6400;
            }
        });
    }
}