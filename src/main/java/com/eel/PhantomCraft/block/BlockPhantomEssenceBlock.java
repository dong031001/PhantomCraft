package com.eel.PhantomCraft.block;

import com.eel.PhantomCraft.creativetab.CreativeTabsPC;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

public class BlockPhantomEssenceBlock extends Block{
	public BlockPhantomEssenceBlock()
    {
        super(Material.GROUND);
        setUnlocalizedName("phantomEssenceBlock");
        setHardness(3f);
        setResistance(10.0f);
        setLightLevel(0.5f);
        setHarvestLevel("pickaxe", 0);
        setSoundType(SoundType.CLOTH);  
        setCreativeTab(CreativeTabsPC.CTPC);
    }
}
