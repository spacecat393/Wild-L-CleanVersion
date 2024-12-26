package com.nali.list.da;

import com.nali.da.*;

import static com.nali.list.data.WildData.FRAME_STEP;
import static com.nali.list.data.WildData.MODEL_STEP;

public class BothDaSandCat implements IBothDaE, IBothDaO, IBothDaS, IBothDaSe, IBothDaNe
{
	public static BothDaSandCat IDA;

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
		return (byte)
		(
			4 +//scale
			4 +//rotation_yaw_head
			1 +//inv
			this.S_MaxFrame() * 2
		);
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
		return 1;
	}

	@Override
	public int S_FrameID()
	{
		return FRAME_STEP + 1;
	}

	@Override
	public byte Se_SyncIndex()
	{
		return
			4 +
			4 +
			1;
	}

	@Override
	public int Ne_EAT()
	{
		return -1;
	}

	@Override
	public int Ne_HURT()
	{
		return -1;
	}

	@Override
	public int Ne_DEATH()
	{
		return -1;
	}

	@Override
	public int Ne_PAT()
	{
		return -1;
	}

	@Override
	public int Ne_SOFT_READY()
	{
		return -1;
	}

	@Override
	public int Ne_HARD_READY()
	{
		return -1;
	}
}
