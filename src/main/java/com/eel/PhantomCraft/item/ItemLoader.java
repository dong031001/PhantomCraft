package com.eel.PhantomCraft.item;


import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

import com.eel.PhantomCraft.Material;
import com.eel.PhantomCraft.PhantomCraft;
import com.eel.PhantomCraft.creativetab.CreativeTabsPC;

public class ItemLoader
{
    public static Item phantomEssence = new ItemPhantom();
    public static Item concentratedPhantomEssence = new ItemConcentratedPhantomEssence();
    public static Item compactPhantomEssence = new ItemPhantom();
    public static Item phantomStick = new ItemPhantom();
    public static Item phantomSword = new ItemPhantomSword();
    public static Item phantomPickaxe = new ItemPhantomPickaxe();
    public static Item phantomAxe = new ItemPhantomAxe();
    public static Item phantomHelmet = new ItemPhantomArmor(Material.armorMaterialPhantomEssence,EntityEquipmentSlot.HEAD);
    public static Item phantomChestplate = new ItemPhantomArmor(Material.armorMaterialPhantomEssence,EntityEquipmentSlot.CHEST);
    public static Item phantomLeggings = new ItemPhantomArmor(Material.armorMaterialPhantomEssence,EntityEquipmentSlot.LEGS);
    public static Item phantomBoots = new ItemPhantomArmor(Material.armorMaterialPhantomEssence,EntityEquipmentSlot.FEET);
    
    public static Item heavenDirt = new ItemPhantomFood(2,3F,true);
    public static Item religiousFood = new ItemPhantomFood(14,2F,false);
    
    public static Item curstPhantomEssence = new ItemCurstPhantomEssence();
    

    public ItemLoader(FMLPreInitializationEvent event)
    {
        Register(phantomEssence, "phantom_essence","phantomEssence");
        Register(concentratedPhantomEssence,"concentrated_phantom_essence","concentratedPhantomEssence");
        Register(compactPhantomEssence,"compact_phantom_essence","compactPhantomEssence");
        Register(phantomStick,"phantom_stick","phantomStick");
        Register(curstPhantomEssence,"curst_phantom_essence","curstPhantomEssence");
        Register(phantomSword,"phantom_sword","phantomSword");
        //Armor
        Register(phantomHelmet,"phantom_helmet","phantomHelmet");
        Register(phantomChestplate,"phantom_chestplate","phantomChestplate");
        Register(phantomLeggings,"phantom_leggings","phantomLeggings");
        Register(phantomBoots,"phantom_boots","phantomBoots");
        //Tools
        Register(phantomPickaxe,"phantom_pickaxe","phantomPickaxe");
        Register(phantomAxe,"phantom_axe","phantomAxe");
        //Foods
        Register(heavenDirt,"heaven_dirt","heavenDirt");
        Register(religiousFood,"religious_food","religiousFood");
    }
    
    public static void registerRenders()
    {
        registerRender(phantomEssence);
        registerRender(concentratedPhantomEssence);
        registerRender(compactPhantomEssence);
        registerRender(phantomStick);
        registerRender(phantomSword);
        registerRender(phantomHelmet);
        registerRender(phantomLeggings);
        registerRender(phantomChestplate);
        registerRender(phantomBoots);
        registerRender(phantomPickaxe);
        registerRender(phantomAxe);
        registerRender(heavenDirt);
        registerRender(religiousFood);
        registerRender(curstPhantomEssence);
    }

    private static void Register(Item item, String name,String unlname)
    {
    	item.setUnlocalizedName(unlname);
        item.setCreativeTab(CreativeTabsPC.CTPC);
        item.setRegistryName(PhantomCraft.ModID, name);
        GameRegistry.findRegistry(Item.class).register(item);
    }
    
    private static void registerRender(Item item)
    {
        ModelResourceLocation model = new ModelResourceLocation(item.getRegistryName(), "inventory");
        ModelLoader.setCustomModelResourceLocation(item, 0, model);
    }
}