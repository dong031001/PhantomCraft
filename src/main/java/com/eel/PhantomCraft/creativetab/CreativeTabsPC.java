package com.eel.PhantomCraft.creativetab;

import com.eel.PhantomCraft.item.ItemLoader;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CreativeTabsPC extends CreativeTabs
{
	public static CreativeTabsPC CTPC = new CreativeTabsPC();
    public CreativeTabsPC()
    {
        super("phantomcraft");
    }

    @Override
    public ItemStack getTabIconItem()
    {
        return new ItemStack(ItemLoader.phantomEssence);
    }
}