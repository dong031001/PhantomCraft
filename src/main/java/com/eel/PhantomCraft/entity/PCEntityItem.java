package com.eel.PhantomCraft.entity;

import java.util.List;

import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

public abstract class PCEntityItem extends EntityItem {

	public PCEntityItem( final World world )
	{
		super( world );
	}

	public PCEntityItem( final World world, final double x, final double y, final double z, final ItemStack stack )
	{
		super(world,x,y,z,stack);
	}

	@SuppressWarnings( "unchecked" )
	protected List<Entity> getCheckedEntitiesWithinAABBExcludingEntity( final AxisAlignedBB region )
	{
		return this.world.getEntitiesWithinAABBExcludingEntity( this, region );
	}

}
