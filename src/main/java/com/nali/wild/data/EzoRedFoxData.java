package com.nali.wild.data;

import com.nali.data.BothData;

public class EzoRedFoxData implements BothData
{
    public static int MAX_FRAME = 1;

    @Override
    public int MaxPart()
    {
        return 13;
    }

    @Override
    public int StepModels()
    {
        return 1;
    }

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
}
