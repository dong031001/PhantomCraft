package com.eel.PhantomCraft.entity;

import java.util.List;

import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.inventory.EntityEquipmentSlot;
import org.apache.commons.lang3.text.translate.EntityArrays;

import com.eel.PhantomCraft.PhantomCraft;
import com.eel.PhantomCraft.block.BlockLoader;
import com.eel.PhantomCraft.helpers.Reflected;
import com.eel.PhantomCraft.item.ItemLoader;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.item.ItemMonsterPlacer;

public final class EntityCurstPhantomEssence extends PCEntityItem {
	
	private int delay = 0;
	private int transformTime = 0;
	
	@Reflected
	public EntityCurstPhantomEssence(final World world) {
		super(world);
	}
	
	public EntityCurstPhantomEssence( final World w, final double x, final double y, final double z, final ItemStack is )
	{
		super( w, x, y, z, is );
	}
	
	@Override
	public void onUpdate()
	{
		super.onUpdate();
		PhantomCraft.instance.getLogger().info("MergeProcess: 0");
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
		PhantomCraft.instance.getLogger().info("MergeProcess: 1");
		if(!this.getEntityWorld().isRemote & b == BlockLoader.blockPhantomAltar )
		{
			PhantomCraft.instance.getLogger().info("MergeProcess: 2");
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
		PhantomCraft.instance.getLogger().info("MergeProcess: Ready");
		final AxisAlignedBB region = new AxisAlignedBB( this.posX - 1, this.posY - 1, this.posZ - 1, this.posX + 1, this.posY + 1, this.posZ + 1 );
		final List<Entity> l = this.getCheckedEntitiesWithinAABBExcludingEntity( region );
		String MobId = null;
		EntityItem titem = null;

		for( final Entity e : l )
		{
			if( e instanceof EntityItem && !e.isDead )
			{
				final ItemStack other = ( (EntityItem) e ).getItem();
				if( !other.isEmpty() )
				{
					if( ItemStack.areItemsEqual(other, new ItemStack(Items.BONE))) {
						titem = (EntityItem) e;
						MobId = "skeleton";
					}
					else if(ItemStack.areItemsEqual(other, new ItemStack(Items.ROTTEN_FLESH))){
						titem = (EntityItem) e;
						MobId = "zombie";
					}
					else if(ItemStack.areItemsEqual(other, new ItemStack(Items.GUNPOWDER))){
						titem = (EntityItem) e;
						MobId = "creeper";
					}
				}
			}
		}
		PhantomCraft.instance.getLogger().info("MergeProcess: Initializing");
		if(titem != null )
		{
			PhantomCraft.instance.getLogger().info("MergeProcess: Issuing");
			this.getItem().grow( -1 );
			titem.getItem().grow( -1 );

			if( this.getItem().getCount() <= 0 )
			{
				this.setDead();
			}

			if( titem.getItem().getCount() <= 0 )
			{
				titem.setDead();
			}

			PhantomCraft.instance.getLogger().info("MergeProcess: ForgingItem");
			EntityLoader.spawnMob(this.world, this.posX, this.posY, this.posZ, MobId);
			PhantomCraft.instance.getLogger().info("MergingProcess: Done");

			return true;
		}
		return false;
	}
}
