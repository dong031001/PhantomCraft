package com.eel.PhantomCraft;

import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.common.util.EnumHelper;

public class Material {
	public final static ToolMaterial toolPhantomEssence = EnumHelper.addToolMaterial("PhantomEssence", 4, 301, 15.0F, 4.0F, 10);
	public final static ArmorMaterial armorMaterialPhantomEssence = addArmorMaterial("PhantomEssence", "phantomcraft:phantom_essence_armor", 1201, new int[] {3, 6, 5, 5}, 15, SoundEvents.ITEM_ARMOR_EQUIP_GENERIC, 0);	
	
	private static ItemArmor.ArmorMaterial addArmorMaterial(String enumName, String textureName, int durability, int[] reductionAmounts, int enchantability, SoundEvent soundOnEquip, float toughness) {
		return EnumHelper.addEnum(ItemArmor.ArmorMaterial.class, enumName, new Class<?>[]{String.class, int.class, int[].class, int.class, SoundEvent.class, float.class}, textureName, durability, reductionAmounts, enchantability, soundOnEquip, toughness);
	}
}
