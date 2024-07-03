package com.nali.wild.data.both;

import com.nali.data.BothData;

public class BothDaSandCat implements BothData
{
    public static int MAX_FRAME = 1;
    public static int MAX_SYNC = 1;

    @Override
    public float Width()
    {
        return 0.45F;
    }

    @Override
    public float Height()
    {
        return 1.6F;
    }

    @Override
    public float Scale()
    {
        return 1.0F;
    }

    @Override
    public int MaxFrame()
    {
        return MAX_FRAME;
    }

    @Override
    public int MaxSync()
    {
        return MAX_SYNC;
    }
}
