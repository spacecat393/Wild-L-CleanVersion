package com.nali.wild.entity.memo.server.sandcat;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;
import com.nali.small.entity.EntityLeInv;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.IMixESoundDa;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.server.IServerS;
import com.nali.small.entity.memo.server.ServerLeInv;
import com.nali.small.entity.memo.server.si.MixSIE;
import com.nali.small.entity.memo.server.si.frame.FrameS;
import com.nali.small.entity.memo.server.si.frame.attack.FrameSleAttackPlus;
import com.nali.small.entity.memo.server.si.frame.floop.FrameSFLoopSit;
import com.nali.small.entity.memo.server.si.frame.floop.FrameSleFLoopDie;
import com.nali.small.entity.memo.server.si.frame.floopfree.FrameSFLoopFreeHardReady;
import com.nali.small.entity.memo.server.si.frame.floopfree.FrameSFLoopFreeSoftReady;
import com.nali.small.entity.memo.server.si.frame.floopfree.FrameSleFLoopFreePEPlus;
import com.nali.small.entity.memo.server.si.frame.floopinset.FrameSleFLoopInSetEndMove;
import com.nali.small.entity.memo.server.si.frame.floopoffset.FrameSleFLoopOffSetAttackPrepare;
import com.nali.small.entity.memo.server.si.frame.tloop.FrameSTLoop;
import com.nali.small.entity.memo.server.si.frame.tloop.FrameSleTLoopAttackWalk;
import com.nali.small.entity.memo.server.si.frame.tloop.FrameSleTLoopWalk;
import com.nali.small.entity.memo.server.si.frame.tloopinset.FrameSTLoopInSetSit;
import com.nali.small.entity.memo.server.si.frame.tloopinset.FrameSleTLoopInSetDie;
import com.nali.sound.ISoundDaLe;

public class ServerSandCat
<
	IE extends InvLe,
	SD extends ISoundDaLe,
	BD extends IBothDaNe & IBothDaSn,
	E extends EntityLeInv,
	I extends IMixE<BD, E> & IMixESoundDa<SD>,
	MS extends MixSIE<BD, E, I, ?>
> extends ServerLeInv<IE, SD, BD, E, I, MS> implements IServerS
{
	public static int[][] FRAME_INT_2D_ARRAY = new int[][]
	{
		{ 1403, 1432 },//walk
		{ 1364, 1402 },//run
		{ 313, 429 },//pat
		{ 1044, 1144 },//sit
		{ 1145, 1245 },
		{ 1246, 1296 },
		{ 0, 93 },//wait
		{ 94, 242 },
		{ 243, 312 },
		{ 430, 496 },//yes
		{ 497, 597 },//sad
		{ 598, 681 },//joy 1
		{ 834, 892 },//idle
		{ 682, 757 },//cool
		{ 959, 1043 },//attack long
		{ 893, 958 },//attack short
		{ 758, 833 }//joy 2
	};
	public static byte[] FRAME_BYTE_ARRAY = new byte[]
	{
		0, 3, 4,
		0, 3, 5,
		0, 3,
		0, 6, 7,
		0, 6, 8,
		0, 6,
		0, 14, 14,
		0, 15, 15,
		0, 2, 14, 15,
		0, 1,
		0, 0,
		0, 9,
		0, 10,
		0, 4, 11, 2, 13, 16,
		0, 12
	};
	public FrameS[][] frames_2d_array;

//	public boolean how_attack;
//	public byte pat_state;

	public ServerSandCat(I i)
	{
		super(i);
	}

	@Override
	public void initFrame()
	{
		this.frames_2d_array = new FrameS[][]
		{
			{
				new FrameSleTLoopInSetDie(this, 0),
				new FrameSleFLoopInSetEndMove(this, 3),
				new FrameSleFLoopDie(this, 6),

				new FrameSTLoopInSetSit(this, 8),
				new FrameSleFLoopInSetEndMove(this, 11),
				new FrameSFLoopSit(this, 14),

				new FrameSleFLoopOffSetAttackPrepare(this, 16),
				new FrameSleFLoopOffSetAttackPrepare(this, 19),
				new FrameSleAttackPlus(this, 22/*, (byte)2*/),

				new FrameSleTLoopAttackWalk(this, 25+1+2),
				new FrameSleTLoopWalk(this, 27+1+2),

				new FrameSFLoopFreeHardReady(this, 29+1+2),
				new FrameSFLoopFreeSoftReady(this, 31+1+2),

				new FrameSleFLoopFreePEPlus(this, 33+1+2/*, (byte)4*/),
				new FrameSTLoop(this, 38+1+2+1+4)
			}
		};
//		() -> this.isZeroMove() && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoopInSet(3, 4),
//		() -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopInSet(3, 5) && serverentitiesmemory.entitiesaimemory.skinningentitiesfindmove.endGoalT(),
//		() -> this.isZeroMove() && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(3),

//		() -> (serverentitiesmemory.current_work_byte_array[workbytes.SIT() / 8] >> workbytes.SIT() % 8 & 1) == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoopInSet(6, 7),
//		() -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopInSet(6, 8) && serverentitiesmemory.entitiesaimemory.skinningentitiesfindmove.endGoalT(),
//		() -> (serverentitiesmemory.current_work_byte_array[workbytes.SIT() / 8] >> workbytes.SIT() % 8 & 1) == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(6),

//		() -> (serverentitiesmemory.entitiesaimemory.skinningentitiesattack.flag & 2) == 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopOffSet(14, 14) && serverentitiesmemory.entitiesaimemory.skinningentitiesfindmove.endGoalT(),
//		() -> (serverentitiesmemory.entitiesaimemory.skinningentitiesattack.flag & 2) == 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopOffSet(15, 15) && serverentitiesmemory.entitiesaimemory.skinningentitiesfindmove.endGoalT(),
//		() ->
//		{
//			boolean result = (serverentitiesmemory.entitiesaimemory.skinningentitiesattack.flag & 2) == 2;
//			if (result)
//			{
//				serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].step = 1;
//
//				int id = 14;
////					serverentitiesmemory.entitiesaimemory.skinningentitiesattack.minimum_distance = 0.5F;
//				if (serverentitiesmemory.how_attack)
//				{
//					id = 15;
////						serverentitiesmemory.entitiesaimemory.skinningentitiesattack.minimum_distance = 1.0F;
//				}
//
//				if (serverentitiesmemory.frame_int_array[serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].integer_index] < serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].int_2d_array[id][0] || serverentitiesmemory.frame_int_array[serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].integer_index] >= serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].int_2d_array[id][1])
//				{
//					serverentitiesmemory.frame_int_array[serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].integer_index] = serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].int_2d_array[id][0];
//					serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].step = 0;
//					return true;
//				}
//
//				for (int attack_frame : serverentitiesmemory.entitiesaimemory.skinningentitiesattack.attack_frame_int_array)
//				{
//					if (serverentitiesmemory.frame_int_array[serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].integer_index] == attack_frame)
//					{
//						serverentitiesmemory.entitiesaimemory.skinningentitiesattack.flag |= 4;
//						break;
//					}
//				}
//			}
//			else
//			{
//				if (this.ticksExisted % 50 == 0)
//				{
//					serverentitiesmemory.how_attack = !serverentitiesmemory.how_attack;
//				}
//			}
//
//			return result;
//		},

//		() -> (serverentitiesmemory.main_work_byte_array[workbytes.ATTACK() / 8] >> workbytes.ATTACK() % 8 & 1) == 1 && this.moveForward != 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(1),
//		() -> this.moveForward != 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(0),

//		() -> (serverentitiesmemory.statentitiesmemory.stat & 4) == 4 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(9, (byte)4),
//		() -> (serverentitiesmemory.statentitiesmemory.stat & 2) == 2 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(10, (byte)2),

//		() ->
//		{
//			boolean result = (serverentitiesmemory.statentitiesmemory.stat & 1) == 1 || (serverentitiesmemory.statentitiesmemory.stat & 8) == 8;
//			int id = 11;
//			if (result)
//			{
//				switch (serverentitiesmemory.pat_state)
//				{
//					case 0:
//					{
//						id = 2;
//						break;
//					}
//					case 1:
//					{
//						id = 13;
//						break;
//					}
//					default:
//					{
//						id = 16;
//					}
//				}
//			}
//			else
//			{
//				if (this.ticksExisted % 50 == 0)
//				{
//					++serverentitiesmemory.pat_state;
//
//					if (serverentitiesmemory.pat_state > 3)
//					{
//						serverentitiesmemory.pat_state = 0;
//					}
//				}
//			}
//
//			return result && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(id, (byte)(1 + 8));
//		},
//		() -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(12)
	}

	@Override
	public void updateServer()
	{

	}

	@Override
	public FrameS[][] getFrameS2DArray()
	{
		return this.frames_2d_array;
	}

	@Override
	public byte[] getFrameByteArray()
	{
		return FRAME_BYTE_ARRAY;
	}

	@Override
	public int[][] getFrame2DIntArray()
	{
		return FRAME_INT_2D_ARRAY;
	}
}
