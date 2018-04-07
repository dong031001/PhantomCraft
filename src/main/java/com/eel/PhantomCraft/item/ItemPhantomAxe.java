package com.eel.PhantomCraft.item;

import java.util.HashSet;

import com.eel.PhantomCraft.Material;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemTool;

public class ItemPhantomAxe extends ItemTool
{
    public ItemPhantomAxe()
    {
        super(4f, 2.0f, Material.toolPhantomEssence, new HashSet());
        setHarvestLevel("axe", 3);
        setMaxDamage(201);
    }
}