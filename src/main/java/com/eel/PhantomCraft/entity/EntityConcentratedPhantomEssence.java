package com.eel.PhantomCraft.entity;

import java.util.List;

import com.eel.PhantomCraft.PhantomCraft;
import com.eel.PhantomCraft.block.BlockLoader;
import com.eel.PhantomCraft.helpers.Reflected;
import com.eel.PhantomCraft.item.ItemLoader;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public final class EntityConcentratedPhantomEssence extends PCEntityItem {
	
	private int delay = 0;
	private int transformTime = 0;
	
	@Reflected
	public EntityConcentratedPhantomEssence(final World world) {
		super(world);
	}
	
	public EntityConcentratedPhantomEssence( final World w, final double x, final double y, final double z, final ItemStack is )
	{
		super( w, x, y, z, is );
	}
	
	@Override
	public void onUpdate()
	{
		super.onUpdate();

		if( this.isDead )
		{
			return;
		}

		this.delay++;

		final int j = MathHelper.floor( this.posX );
		final int i = MathHelper.floor( (this.getEntityBoundingBox().minY-0.5D) );
		final int k = MathHelper.floor( this.posZ );

		IBlockState state = this.world.getBlockState( new BlockPos( j, i, k ) );
		Block b = state.getBlock();
		if(!this.getEntityWorld().isRemote & b == BlockLoader.blockPhantomAltar )
		{
			this.transformTime++;
			if( this.transformTime > 60 )
			{
				if( !this.transform() )
				{
					this.transformTime = 0;
				}
			}
		}
		else
		{
			this.transformTime = 0;
		}
	}

	private boolean transform()
	{
		final ItemStack item = this.getItem();
		final ItemStack cpe = new ItemStack(ItemLoader.curstPhantomEssence);
		PhantomCraft.instance.getLogger().info("MergeProcess: Ready");
		final AxisAlignedBB region = new AxisAlignedBB( this.posX - 1, this.posY - 1, this.posZ - 1, this.posX + 1, this.posY + 1, this.posZ + 1 );
		final List<Entity> l = this.getCheckedEntitiesWithinAABBExcludingEntity( region );

		EntityItem netherQuartz = null;

		for( final Entity e : l )
		{
			if( e instanceof EntityItem && !e.isDead )
			{
				final ItemStack other = ( (EntityItem) e ).getItem();
				if( !other.isEmpty() )
				{
					if( ItemStack.areItemsEqual( other, new ItemStack( ItemLoader.religiousFood ) ) )
					{
						PhantomCraft.instance.getLogger().info("ECCPItems: Affirmitive");
						netherQuartz = (EntityItem) e;
					}
				}
			}
		}
		PhantomCraft.instance.getLogger().info("MergeProcess: Initializing");
		if(netherQuartz != null )
		{
			PhantomCraft.instance.getLogger().info("MergeProcess: Issuing");
			this.getItem().grow( -1 );
			netherQuartz.getItem().grow( -1 );

			if( this.getItem().getCount() <= 0 )
			{
				this.setDead();
			}

			if( netherQuartz.getItem().getCount() <= 0 )
			{
				netherQuartz.setDead();
			}
			
			PhantomCraft.instance.getLogger().info("MergeProcess: ForgingItem");
			
			final EntityItem entity = new EntityItem( this.world, this.posX, this.posY, this.posZ,new ItemStack(ItemLoader.curstPhantomEssence) );
			this.world.spawnEntity( entity );
			
			PhantomCraft.instance.getLogger().info("MergingProcess: Done");
			
			return true;
		}
		return false;
	}
}
