package com.nali.wild.data.client;

import com.nali.data.client.SkinningClientData;

public class SandCatClientData implements SkinningClientData
{
    @Override
    public int AnimationID()
    {
        return 14;
    }

    @Override
    public int StartPart()
    {
        return 15;
    }

    @Override
    public int EndPart()
    {
        return 28;
    }
}
