package com.goldenapple.grassblades;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerEvent;

@Mod(modid = "grassblades", version = "1.0", name = "Grass Blades")
public class GrassBlades{

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void onPlayerStartBreaking(PlayerEvent.BreakSpeed event){ //every time a player starts breaking a block
        if(event.entityPlayer.getCurrentEquippedItem() != null){ //if the player has an item equipped
            if(event.entityPlayer.getCurrentEquippedItem().getItem() instanceof ItemSword) { //if the item is a sword
                World world = event.entityPlayer.worldObj;
                Block block = world.getBlock(event.x, event.y, event.z);
                if(block.getBlockHardness(world, event.x, event.y, event.z) == 0.0F){
                    event.newSpeed = -1.0F;
                }
            }
        }
    }
}
