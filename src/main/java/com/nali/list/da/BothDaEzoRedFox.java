package com.nali.list.da;

import com.nali.da.*;

import static com.nali.list.data.WildData.FRAME_STEP;
import static com.nali.list.data.WildData.MODEL_STEP;

public class BothDaEzoRedFox implements IBothDaE, IBothDaO, IBothDaS, IBothDaSe, IBothDaNe
{
	public static BothDaEzoRedFox IDA;

	public static short[] FIX_KEY_SHORT_ARRAY = new short[]
	{
		0, 25,//walk
		26, 84,
		85, 110,
		242, 342,//sit
		343, 543,
		544, 594,
		595, 655,//wait
		656, 693,
		694, 799,
		800, 866,//yes
		867, 950,//sad
		990, 1073,//joy
		1074, 1163,//idle
		951, 989,//run
		111, 190,//attack long
		191, 241//attack short
	};

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
			this.S_MaxFrame() * (4 + 1)
		);
	}

	@Override
	public int O_StartPart()
	{
		return MODEL_STEP/* + 0*/;
	}

	@Override
	public int O_EndPart()
	{
		return MODEL_STEP + 13;
	}

	@Override
	public byte S_MaxFrame()
	{
		return 1;
	}

	@Override
	public int S_FrameID()
	{
		return FRAME_STEP/* + 0*/;
	}

	@Override
	public short[] S_FixKeyShortArray()
	{
		return FIX_KEY_SHORT_ARRAY;
	}

	@Override
	public byte Se_SyncIndex()
	{
		return
			4 +
			4;
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
