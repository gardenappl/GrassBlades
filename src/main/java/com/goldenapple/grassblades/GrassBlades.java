package com.goldenapple.grassblades;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

@Mod(modid = "grassblades", version = "1.0", name = "Grass Blades")
public class GrassBlades{

    @Mod.EventHandler
    public void init(FMLInitializationEvent event)
    {
        MinecraftForge.EVENT_BUS.register(new FMLEventHandler());
    }
}
