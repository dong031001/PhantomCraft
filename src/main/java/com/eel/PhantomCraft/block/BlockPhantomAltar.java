package com.eel.PhantomCraft.block;

import com.eel.PhantomCraft.creativetab.CreativeTabsPC;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class BlockPhantomAltar extends Block {

	public BlockPhantomAltar() {
		
		super(Material.ROCK);
		setHardness(4f);
		setUnlocalizedName("phantomAltar");
        setResistance(15.0f);
        setLightLevel(2f);
        setHarvestLevel("pickaxe", 3);
        setSoundType(SoundType.STONE);
        setCreativeTab(CreativeTabsPC.CTPC);
	}

}
