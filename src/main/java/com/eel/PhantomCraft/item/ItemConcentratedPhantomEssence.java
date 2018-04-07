package com.eel.PhantomCraft.item;

import com.eel.PhantomCraft.entity.EntityConcentratedPhantomEssence;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemConcentratedPhantomEssence extends ItemPhantom {
	@Override
	public boolean hasCustomEntity( final ItemStack stack )
	{
		return true;
	}

	@Override
	public Entity createEntity( final World world, final Entity location, final ItemStack itemstack )
	{
		final EntityConcentratedPhantomEssence cpe = new EntityConcentratedPhantomEssence( world, location.posX, location.posY, location.posZ, itemstack );

		cpe.motionX = location.motionX;
		cpe.motionY = location.motionY;
		cpe.motionZ = location.motionZ;

		// Cannot read the pickup delay of the original item, so we
		// use the pickup delay used for items dropped by a player instead
		cpe.setPickupDelay( 40 );
		return cpe;
	}
}
