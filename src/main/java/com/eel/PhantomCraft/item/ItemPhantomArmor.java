package com.eel.PhantomCraft.item;

import com.eel.PhantomCraft.creativetab.CreativeTabsPC;

import net.minecraft.block.material.Material;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class ItemPhantomArmor extends ItemArmor{
	public ItemPhantomArmor(ArmorMaterial material, EntityEquipmentSlot slot) {
			super(material, 5, slot);
	        this.setMaxStackSize(1);
	    }

}
