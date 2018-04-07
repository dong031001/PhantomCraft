package com.eel.PhantomCraft.item;

import net.minecraft.item.ItemFood;
import net.minecraft.potion.Potion;

public class ItemPhantomFood extends ItemFood {
	public ItemPhantomFood(int a,float f,boolean s)
    {
        super(a, f, false);
        if(s) {
        this.setAlwaysEdible();
        }
    }
}
