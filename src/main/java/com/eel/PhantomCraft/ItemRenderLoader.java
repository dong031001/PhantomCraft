package com.eel.PhantomCraft;

import com.eel.PhantomCraft.block.BlockLoader;
import com.eel.PhantomCraft.item.ItemLoader;

public class ItemRenderLoader {
	public ItemRenderLoader()
    {
        ItemLoader.registerRenders();
        BlockLoader.registerRenders();
    }
}
