package com.nali.list.da;

import com.nali.da.IBothDaE;
import com.nali.da.IBothDaNE;
import com.nali.da.IBothDaO;
import com.nali.da.IBothDaS;

import static com.nali.list.data.WildData.FRAME_STEP;
import static com.nali.list.data.WildData.MODEL_STEP;

public class BothDaSandCat implements IBothDaE, IBothDaO, IBothDaS, IBothDaNE
{
	public static BothDaSandCat IDA = new BothDaSandCat();

	public static byte MAX_FRAME = 1;
	public static byte MAX_SYNC = 1;

	@Override
	public float E_Width()
	{
		return 0.45F;
	}

	@Override
	public float E_Height()
	{
		return 1.6F;
	}

	@Override
	public float E_Scale()
	{
		return 1.0F;
	}

	@Override
	public byte E_MaxSync()
	{
		return MAX_SYNC;
	}

	@Override
	public int O_StartPart()
	{
		return MODEL_STEP + 13;
	}

	@Override
	public int O_EndPart()
	{
		return MODEL_STEP + 26;
	}

	@Override
	public byte S_MaxFrame()
	{
		return MAX_FRAME;
	}

	@Override
	public int S_FrameID()
	{
		return FRAME_STEP + 1;
	}

	@Override
	public int NE_EAT()
	{
		return -1;
	}

	@Override
	public int NE_HURT()
	{
		return -1;
	}

	@Override
	public int NE_DEATH()
	{
		return -1;
	}

	@Override
	public int NE_PAT()
	{
		return -1;
	}

	@Override
	public int NE_SOFT_READY()
	{
		return -1;
	}

	@Override
	public int NE_HARD_READY()
	{
		return -1;
	}
}
