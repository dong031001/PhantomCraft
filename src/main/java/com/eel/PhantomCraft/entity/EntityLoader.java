package com.eel.PhantomCraft.entity;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemMonsterPlacer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityLoader {

    public static void spawnMob(World world, double x, double y, double z, String MobId){
        world.spawnEntity(getMob(world, x, y, z, MobId));
    }

    public static Entity getMob(World world, double x, double y, double z, String MobId){
        final Entity entity = ItemMonsterPlacer.spawnCreature(world, new ResourceLocation(MobId), x, y, z);
        return entity;
    }
}
