package com.nali.wild;

import com.nali.system.opengl.memo.client.MemoC;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = Wild.ID)
public class Wild
{
    public final static String ID = "wild";
    static
    {
        if (FMLCommonHandler.instance().getSide() == Side.CLIENT)
        {
            int max_bone = 68 * 16;
            if (MemoC.MAX_BONE < max_bone)
            {
                MemoC.MAX_BONE = max_bone;
            }
        }
    }

//    @Mod.Instance
//    public static Wild I;

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
