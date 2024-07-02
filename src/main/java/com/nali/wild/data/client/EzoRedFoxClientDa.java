package com.nali.wild.data.client;

import com.nali.data.client.SkinningClientData;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.WildData.MODEL_STEP;

@SideOnly(Side.CLIENT)
public class EzoRedFoxClientDa implements SkinningClientData
{
    @Override
    public int AnimationID()
    {
        return MODEL_STEP/* + 0*/;
    }

    @Override
    public int StartPart()
    {
        return MODEL_STEP + 1;
    }

    @Override
    public int EndPart()
    {
        return MODEL_STEP + 14;
    }
}
