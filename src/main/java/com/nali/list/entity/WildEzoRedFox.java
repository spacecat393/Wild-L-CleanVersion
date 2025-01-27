package com.nali.list.entity;

import com.nali.da.IBothDaE;
import com.nali.list.da.BothDaEzoRedFox;
import com.nali.list.entity.ci.CIEFrame;
import com.nali.list.entity.ci.CIESound;
import com.nali.list.entity.si.*;
import com.nali.math.M4x4;
import com.nali.math.V4;
import com.nali.small.entity.EntityLeInv;
import com.nali.small.entity.EntityMath;
import com.nali.small.entity.IMixES;
import com.nali.small.entity.IMixESInv;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.IBothLeInv;
import com.nali.small.entity.memo.client.box.mix.MixBoxSleInv;
import com.nali.small.entity.memo.server.si.SILeLook;
import com.nali.small.entity.memo.server.si.path.SILeFindMove;
import com.nali.small.entity.memo.server.si.path.SILeMineTo;
import com.nali.sound.SoundE;
import com.nali.wild.entity.memo.client.ezoredfox.ClientEzoRedFox;
import com.nali.wild.entity.memo.client.ezoredfox.MixCIEzoRedFox;
import com.nali.wild.entity.memo.client.ezoredfox.MixRenderEzoRedFox;
import com.nali.wild.entity.memo.server.ezoredfox.MixSIEzoRedFox;
import com.nali.wild.entity.memo.server.ezoredfox.ServerEzoRedFox;
import com.nali.wild.render.entity.RenderEzoRedFox;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.WildData.MODEL_STEP;

public class WildEzoRedFox extends EntityLeInv implements IMixES, IMixESInv
{
	public static int eggPrimary = 0xffb56d;
	public static int eggSecondary = 0xc9453d;

	public final static DataParameter<Byte>[] BYTE_DATAPARAMETER_ARRAY = new DataParameter[BothDaEzoRedFox.IDA.E_MaxSync()];
//	public final static DataParameter<Integer>[] INTEGER_DATAPARAMETER_ARRAY = new DataParameter[BothDaEzoRedFox.IDA.S_MaxFrame()];
//	public final static DataParameter<Float>[] FLOAT_DATAPARAMETER_ARRAY = new DataParameter[1];

	public static byte[] CI_BYTE_ARRAY;
	public static byte[] SI_BYTE_ARRAY;

	public IBothLeInv ibothleinv;

	public static int[] IV_INT_ARRAY = new int[]
	{
		2/*+0*/ + MODEL_STEP, 8760,
		2/*+0*/ + MODEL_STEP, 10195,
		4/*+0*/ + MODEL_STEP, 1525,
		2/*+0*/ + MODEL_STEP, 5390,
		2/*+0*/ + MODEL_STEP, 14181,
		11/*+0*/ + MODEL_STEP, 961
	};
	public static float[] ROTATION_FLOAT_ARRAY = new float[]
	{
		0.0F, 0.0F,
		0.0F, 0.0F
	};
	public static float[] TRANSFORM_FLOAT_ARRAY = new float[]
	{
		0.0F, -0.55F * 0.5F, 0.0F,
		0.0F, -1.0F * 0.5F, 0.1F * 0.5F,
		0.0F, -1.2F * 0.5F, 0.14F * 0.5F,
		0.0F, 0.0F, 0.14F * 0.5F
	};

	static
	{
		for (int i = 0; i < BYTE_DATAPARAMETER_ARRAY.length; ++i)
		{
			BYTE_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(WildEzoRedFox.class, DataSerializers.BYTE);
		}

//		for (int i = 0; i < INTEGER_DATAPARAMETER_ARRAY.length; ++i)
//		{
//			INTEGER_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(WildEzoRedFox.class, DataSerializers.VARINT);
//		}
//
//		for (int i = 0; i < FLOAT_DATAPARAMETER_ARRAY.length; ++i)
//		{
//			FLOAT_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(WildEzoRedFox.class, DataSerializers.FLOAT);
//		}
	}

	public WildEzoRedFox(World world)
	{
		super(world);
	}

	public static void initID()
	{
		CI_BYTE_ARRAY = new byte[]
		{
			CIEFrame.ID,
			CIESound.ID
		};

		SI_BYTE_ARRAY = new byte[]
		{
			SIESound.ID,

			SIEArea.ID,
			SIEOwner.ID,
			SILeEat.ID,

			SIEPat.ID,

			SIEInvLockInv.ID,
			SILeLockDMG.ID,
			SILeMineTo.ID,
			SIEUseTo.ID,
			SIESit.ID,
			SIESetLocation.ID,
			SIEFollow.ID,
			SIERevive.ID,
			SIECareOwner.ID,
			SILeAttack.ID,
			SILeInvManageItem.ID,
			SIEInvGetItem.ID,
			SIERandomWalk.ID,
			SIELookTo.ID,
			SIERandomLook.ID,

			SIEKey.ID,

			SILeFindMove.ID,
			//SILeMove.ID,
			SIEWalkTo.ID,
			SILeLook.ID,
			//SILeJump.ID
		};
	}

	@SideOnly(Side.CLIENT)
	public static ClientEzoRedFox getC()
	{
		RenderEzoRedFox r = new RenderEzoRedFox();
		ClientEzoRedFox c = new ClientEzoRedFox(r);
		r.c = c;
		c.mr = new MixRenderEzoRedFox(c);
		return c;
	}

//	@Override
//	@SideOnly(Side.CLIENT)
//	public void initFakeFrame()
//	{
//		ClientEntitiesMemory cliententitiesmemory = (ClientEntitiesMemory)this.bothentitiesmemory;
//		EzoRedFoxRender skinningrender = (EzoRedFoxRender)cliententitiesmemory.objectrender;
//		skinningrender.model_byte_array[8 / 8] &= 254;//255 - Math.pow(2, 8 % 8)
////		skinningrender.model_byte_array[5 / 8] &= 223;//255 - Math.pow(2, 5 % 8)
////		skinningrender.model_byte_array[6 / 8] &= 191;//255 - Math.pow(2, 6 % 8)
////		skinningrender.model_byte_array[7 / 8] &= 127;//255 - Math.pow(2, 7 % 8)
//		skinningrender.model_byte_array[0] &= 223 & 191 & 127;
//	}

//	@Override
//	public AxisAlignedBB getMouthAxisAlignedBB()
//	{
//		if (this.isZeroMove())
//		{
//			return this.getEntityBoundingBox().grow(0.25);
//		}
//		else
//		{
//			double hw = this.width / 2.0F;
//			double hh = 0.5;
//			Vec3d view_vec3d = this.getLookVec().scale(0.25);
//			double x = this.posX + view_vec3d.x;
//			double y = this.posY + (double)(this.height / 1.5F) + view_vec3d.y;
//			double z = this.posZ + view_vec3d.z;
//			return new AxisAlignedBB(x - hw, y, z - hw, x + hw, y + hh, z + hw);
//		}
//	}

	@Override
	public void applyEntityAttributes()
	{
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(200.0D);
		//this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.05D);
		this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(50.0D);
		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(20.0D);
	}

	@Override
	public byte[] getCI()
	{
		return CI_BYTE_ARRAY;
	}

	@Override
	public byte[] getSI()
	{
		return SI_BYTE_ARRAY;
	}

	@Override
	public DataParameter<Byte>[] getByteDataParameterArray()
	{
		return BYTE_DATAPARAMETER_ARRAY;
	}

//	@Override
//	public DataParameter<Integer>[] getIntegerDataParameterArray()
//	{
//		return INTEGER_DATAPARAMETER_ARRAY;
//	}
//
//	@Override
//	public DataParameter<Float>[] getFloatDataParameterArray()
//	{
//		return FLOAT_DATAPARAMETER_ARRAY;
//	}

	@SideOnly(Side.CLIENT)
	@Override
	public void newC()
	{
		RenderEzoRedFox r = new RenderEzoRedFox();
		ClientEzoRedFox c = new ClientEzoRedFox(this, r, new SoundE());
		MixCIEzoRedFox mc = new MixCIEzoRedFox(c);
		c.mc = mc;
		mc.init();
		c.mb = new MixBoxSleInv(c);
		c.mr = new MixRenderEzoRedFox(c);
		r.c = c;
		c.ie = new InvLe();
		this.ibothleinv = c;
	}

	@Override
	public void newS()
	{
		ServerEzoRedFox s = new ServerEzoRedFox(this);
		MixSIEzoRedFox ms = new MixSIEzoRedFox(s);
		s.ms = ms;
		ms.init();
		s.initKey();
		s.ie = new InvLe();
		this.ibothleinv = s;
	}

	@Override
	public IBothDaE getBD()
	{
		return BothDaEzoRedFox.IDA;
	}

	@Override
	public IBothLeInv getB()
	{
		return this.ibothleinv;
	}

	@Override
	public int[] getIVIntArray()
	{
		return IV_INT_ARRAY;
	}

	@Override
	public float[] getRotationFloatArray()
	{
		return ROTATION_FLOAT_ARRAY;
	}

	@Override
	public float[] getTransformFloatArray()
	{
		return TRANSFORM_FLOAT_ARRAY;
	}

	@Override
	public void mulFrame(float[] skinning_float_array, short[] key_short_array, float partial_ticks)
	{
		float head_rot = (float)Math.toRadians(EntityMath.interpolateRotation(this.prev_rotation_yaw_head, this.rotation_yaw_head, partial_ticks));
		float head_pitch = (float)Math.toRadians(this.prevRotationPitch + (this.rotationPitch - this.prevRotationPitch) * partial_ticks);
		float body_rot = (float)Math.toRadians(EntityMath.interpolateRotation(this.prevRotationYaw, this.rotationYaw, partial_ticks));
		float net_head_yaw = head_rot - body_rot;

		if (head_pitch > 1.04719755119659774615F)
		{
			head_pitch = 1.04719755119659774615F;
		}
		else if (head_pitch < -1.04719755119659774615F)
		{
			head_pitch = -1.04719755119659774615F;
		}
		V4.q(V4.TV4_FLOAT_ARRAY, 0.0F, 0.0F, body_rot);
		float[] body_m4x4 = V4.getM4X4(V4.TV4_FLOAT_ARRAY);
		V4.q(V4.TV4_FLOAT_ARRAY, -head_pitch, 0, net_head_yaw);
		float[] head_m4x4 = V4.getM4X4(V4.TV4_FLOAT_ARRAY);

		M4x4.m(head_m4x4, skinning_float_array, 0, 33*16);

		M4x4.m(body_m4x4, skinning_float_array, 0, 0);
	}
}
