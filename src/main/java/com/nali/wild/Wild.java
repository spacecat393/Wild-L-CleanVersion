package com.nali.wild;

import com.nali.wild.system.Reference;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.Instance;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME)
public class Wild
{
    @Instance
    public static Wild I;

//    @EventHandler
//    public void onFMLPreInitializationEvent(FMLPreInitializationEvent event)
//    {
//        if (event.getSide().isClient())
//        {
//            DataLoader.setModels(RenderHelper.DATALOADER, Reference.MOD_ID);
//        }
//    }
//
//    @EventHandler
//    public void onFMLInitializationEvent(FMLInitializationEvent event)
//    {
//        if (event.getSide().isClient())
//        {
//            DataLoader.setSounds(RenderHelper.DATALOADER, Reference.MOD_ID);
//        }
//    }
}
