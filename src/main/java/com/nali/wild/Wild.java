package com.nali.wild;

import com.nali.wild.render.RenderHelper;
import com.nali.wild.system.Reference;
import com.nali.system.DataLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME)
public class Wild
{
    @Instance
    public static Wild I;

//    public static Logger LOGGER = LogManager.getLogger(Reference.MOD_ID);
    @EventHandler
    public void onFMLPreInitializationEvent(FMLPreInitializationEvent event)
    {
        if (event.getSide().isClient())
        {
            DataLoader.setModels(RenderHelper.DATALOADER, Reference.MOD_ID);
        }
    }
//    public static void error(Throwable t)
//    {
//        LOGGER.error(t);
//        FMLCommonHandler.instance().exitJava(-1, true);
//    }
//
//    public static void error(String s)
//    {
//        LOGGER.error(s);
//        FMLCommonHandler.instance().exitJava(-1, true);
//    }
}
