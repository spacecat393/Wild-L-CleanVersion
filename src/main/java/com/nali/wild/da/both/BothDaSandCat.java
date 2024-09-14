package com.nali.wild.da.both;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;

public class BothDaSandCat implements IBothDaSn, IBothDaNe
{
	public static BothDaSandCat IBOTHDASN = new BothDaSandCat();

	public static byte MAX_FRAME = 1;
	public static byte MAX_SYNC = 1;

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
