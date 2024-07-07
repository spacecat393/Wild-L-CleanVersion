package com.nali.wild.da.client;

import com.nali.da.client.IClientDaS;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.WildData.ANIMATION_STEP;
import static com.nali.list.data.WildData.MODEL_S_STEP;

@SideOnly(Side.CLIENT)
public class ClientDaEzoRedFox implements IClientDaS
{
    public static IClientDaS ICLIENTDAS = new ClientDaEzoRedFox();

    @Override
    public int AnimationID()
    {
        return ANIMATION_STEP/* + 0*/;
    }

    @Override
    public int StartPart()
    {
        return MODEL_S_STEP/* + 0*/;
    }

    @Override
    public int EndPart()
    {
        return MODEL_S_STEP + 13;
    }
}
