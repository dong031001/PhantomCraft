package com.eel.PhantomCraft.item;

import com.eel.PhantomCraft.entity.EntityConcentratedPhantomEssence;
import com.eel.PhantomCraft.entity.EntityCurstPhantomEssence;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemCurstPhantomEssence extends ItemPhantom {
	@Override
	public boolean hasCustomEntity( final ItemStack stack )
	{
		return true;
	}

	@Override
	public Entity createEntity( final World world, final Entity location, final ItemStack itemstack )
	{
		final EntityCurstPhantomEssence ecpe = new EntityCurstPhantomEssence( world, location.posX, location.posY, location.posZ, itemstack );

		ecpe.motionX = location.motionX;
		ecpe.motionY = location.motionY;
		ecpe.motionZ = location.motionZ;

		// Cannot read the pickup delay of the original item, so we
		// use the pickup delay used for items dropped by a player instead
		ecpe.setPickupDelay( 40 );
		return ecpe;
	}
}
