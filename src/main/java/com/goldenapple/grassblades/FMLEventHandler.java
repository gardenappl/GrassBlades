package com.goldenapple.grassblades;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.item.ItemSword;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class FMLEventHandler {
    @SubscribeEvent
    public void onPlayerStartBreaking(PlayerEvent.BreakSpeed event){ //every time a player starts breaking a block
        World world = event.entityPlayer.worldObj;
        Block block = world.getBlock(event.x, event.y, event.z);
        if(event.entityPlayer.getCurrentEquippedItem() != null){ //if the player has an item equipped
            if(event.entityPlayer.getCurrentEquippedItem().getItem() instanceof ItemSword) { //if the item is a sword
                if (block.getMaterial() == Material.plants || block.getMaterial() == Material.vine || block.getMaterial() == Material.circuits) { //if the block is a plant or a redstone circuit
                    event.newSpeed = -0.1F; //make the block unbreakable. unfortunately, setting the speed to something more
                }                           //than zero wont work so I have to make the block unbreakable
            }
        }
    }
}
