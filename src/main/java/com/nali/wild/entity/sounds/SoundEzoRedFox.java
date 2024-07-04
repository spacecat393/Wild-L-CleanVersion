package com.nali.wild.entity.sounds;

import com.nali.sound.ISoundLe;

public class SoundEzoRedFox implements ISoundLe
{
    public static ISoundLe ISOUNDLE = new SoundEzoRedFox();

    @Override
    public int HURT()
    {
        return -1;
    }

    @Override
    public int DEATH()
    {
        return -1;
    }

    @Override
    public int PAT()
    {
        return -1;
    }

    @Override
    public int SOFT_READY()
    {
        return -1;
    }

    @Override
    public int HARD_READY()
    {
        return -1;
    }
}
