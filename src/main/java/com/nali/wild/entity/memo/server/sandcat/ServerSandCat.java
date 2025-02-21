package com.nali.wild.entity.memo.server.sandcat;

import com.nali.da.IBothDaE;
import com.nali.da.IBothDaNe;
import com.nali.list.entity.ci.CIESound;
import com.nali.list.network.message.ClientMessage;
import com.nali.network.NetworkRegistry;
import com.nali.small.entity.EntityLe;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.memo.server.IServerS;
import com.nali.small.entity.memo.server.ServerLe;
import com.nali.small.entity.memo.server.si.MixSIE;
import com.nali.small.entity.memo.server.si.frame.KeyS;
import com.nali.small.entity.memo.server.si.frame.attack.KeySleAttackPlus;
import com.nali.small.entity.memo.server.si.frame.floop.KeySFLoopSit;
import com.nali.small.entity.memo.server.si.frame.floop.KeySleFLoopDie;
import com.nali.small.entity.memo.server.si.frame.floopfree.KeySFLoopFreeHardReady;
import com.nali.small.entity.memo.server.si.frame.floopfree.KeySFLoopFreeSoftReady;
import com.nali.small.entity.memo.server.si.frame.floopfree.KeySleFLoopFreePEPlus;
import com.nali.small.entity.memo.server.si.frame.floopinset.KeySleFLoopInSetEndMove;
import com.nali.small.entity.memo.server.si.frame.floopoffset.KeySleFLoopOffSetAttackPrepare;
import com.nali.small.entity.memo.server.si.frame.tloop.KeySTLoop;
import com.nali.small.entity.memo.server.si.frame.tloop.KeySleTLoopAttackWalk;
import com.nali.small.entity.memo.server.si.frame.tloop.KeySleTLoopWalk;
import com.nali.small.entity.memo.server.si.frame.tloopinset.KeySTLoopInSetSit;
import com.nali.small.entity.memo.server.si.frame.tloopinset.KeySleTLoopInSetDie;
import com.nali.system.bytes.ByteWriter;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;

public class ServerSandCat
<
	BD extends IBothDaE & IBothDaNe,
	E extends EntityLe,
	I extends IMixE<BD, E>,
	MS extends MixSIE<BD, E, I, ?>
> extends ServerLe<BD, E, I, MS> implements IServerS
{
	public static short[] FIX_KEY_SHORT_ARRAY = new short[]
	{
		1403, 1432,//walk
		1364, 1402,//run
		313, 429,//pat
		1044, 1144,//sit
		1145, 1245,
		1246, 1296,
		0, 93,//wait
		94, 242,
		243, 312,
		430, 496,//yes
		497, 597,//sad
		598, 681,//joy 1
		834, 892,//idle
		682, 757,//cool
		959, 1043,//attack long
		893, 958,//attack short
		758, 833//joy 2
	};
	public static byte[] KEY_DATA_BYTE_ARRAY = new byte[]
	{
		0, 3*2, 4*2,
		0, 3*2, 5*2,
		0, 3*2,
		0, 6*2, 7*2,
		0, 6*2, 8*2,
		0, 6*2,
		0, 14*2, 14*2,
		0, 15*2, 15*2,
		0, 2, 14*2, 15*2,
		0, 1*2,
		0, 0*2,
		0, 9*2,
		0, 10*2,
		0, 4, 11*2, 2*2, 13*2, 16*2,
		0, 12*2
	};
	public KeyS[][] keys_2d_array;

//	public boolean how_attack;
//	public byte pat_state;

	public ServerSandCat(I i)
	{
		super(i);
	}

	@Override
	public void init()
	{
		super.init();
		this.sileinv.itemstack_array = new ItemStack[4*9];
	}

	@Override
	public void initKey()
	{
		this.keys_2d_array = new KeyS[][]
		{
			{
				new KeySleTLoopInSetDie(this, (byte)0),
				new KeySleFLoopInSetEndMove(this, (byte)3),
				new KeySleFLoopDie(this, (byte)6),

				new KeySTLoopInSetSit(this, (byte)8),
				new KeySleFLoopInSetEndMove(this, (byte)11),
				new KeySFLoopSit(this, (byte)14),

				new KeySleFLoopOffSetAttackPrepare(this, (byte)16),
				new KeySleFLoopOffSetAttackPrepare(this, (byte)19),
				new KeySleAttackPlus(this, (byte)22/*, (byte)2*/),

				new KeySleTLoopAttackWalk(this, (byte)(25+1+2)),
				new KeySleTLoopWalk(this, (byte)(27+1+2)),

				new KeySFLoopFreeHardReady(this, (byte)(29+1+2)),
				new KeySFLoopFreeSoftReady(this, (byte)(31+1+2)),

				new KeySleFLoopFreePEPlus(this, (byte)(33+1+2)/*, (byte)4*/),
				new KeySTLoop(this, (byte)(38+1+2+1+4))
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
	public KeyS[][] getKeyS2DArray()
	{
		return this.keys_2d_array;
	}

	@Override
	public byte[] getKeyDataByteArray()
	{
		return KEY_DATA_BYTE_ARRAY;
	}

	@Override
	public short[] getFixKeyShortArray()
	{
		return FIX_KEY_SHORT_ARRAY;
	}

	@Override
	public void getHurtSound(DamageSource damagesource)
	{
		byte[] byte_array = new byte[1 + 8 + 1 + 4];
		this.setCCI(byte_array, CIESound.ID);
		ByteWriter.set(byte_array, this.i.getBD().Ne_HURT(), 1 + 8 + 1);
		NetworkRegistry.I.sendToAll(new ClientMessage(byte_array));
	}

	@Override
	public void getDeathSound()
	{
		byte[] byte_array = new byte[1 + 8 + 1 + 4];
		this.setCCI(byte_array, CIESound.ID);
		ByteWriter.set(byte_array, this.i.getBD().Ne_DEATH(), 1 + 8 + 1);
		NetworkRegistry.I.sendToAll(new ClientMessage(byte_array));
	}
}
