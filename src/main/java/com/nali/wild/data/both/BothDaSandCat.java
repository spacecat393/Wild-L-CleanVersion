package com.nali.wild.data.both;

import com.nali.data.IBothDaNe;
import com.nali.data.IBothDaNs;
import com.nali.data.IBothDaSn;
import com.nali.sound.ISoundLe;
import com.nali.wild.entity.sounds.SoundSandCat;

public class BothDaSandCat<SD extends ISoundLe> extends IBothDaNs<SD> implements IBothDaSn, IBothDaNe
{
    public static BothDaSandCat IBOTHDASN = new BothDaSandCat(SoundSandCat.ISOUNDLE);

    public static byte MAX_FRAME = 1;
    public static byte MAX_SYNC = 1;

    public BothDaSandCat(SD sd)
    {
        super(sd);
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
    public byte MaxFrame()
    {
        return MAX_FRAME;
    }

    @Override
    public byte MaxSync()
    {
        return MAX_SYNC;
    }
}
