package com.eel.PhantomCraft.block;

import com.eel.PhantomCraft.PhantomCraft;
import com.eel.PhantomCraft.creativetab.CreativeTabsPC;

import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class BlockLoader
{
    public static Block blockPhantomEssenceBlock = new BlockPhantomEssenceBlock();
    public static Block blockPhantomAltar = new BlockPhantomAltar();

    public BlockLoader(FMLPreInitializationEvent event)
    {
        register(blockPhantomEssenceBlock, "phantom_essence_block","phantomEssenceBlock");
        register(blockPhantomAltar,"phantom_altar","phantomAltar");
    }
    
    @SideOnly(Side.CLIENT)
    public static void registerRenders()
    {
        registerRender(blockPhantomEssenceBlock);
        registerRender(blockPhantomAltar);
    }

    private static void register(Block block, String name, String unlname)
    {
    	ItemBlock itemblock = new ItemBlock(block);
    	
        GameRegistry.findRegistry(Block.class).register(block.setRegistryName(name));
        GameRegistry.findRegistry(Item.class).register(new ItemBlock(block).setRegistryName(PhantomCraft.ModID, name).setUnlocalizedName(unlname).setCreativeTab(CreativeTabsPC.CTPC));
    }
    
    @SideOnly(Side.CLIENT)
    private static void registerRender(Block block)
    {
        ModelResourceLocation model = new ModelResourceLocation(block.getRegistryName(), "inventory");
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, model);
    }
}
