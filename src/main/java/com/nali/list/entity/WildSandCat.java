package com.nali.list.entity;

import com.nali.da.IBothDaE;
import com.nali.list.da.BothDaSandCat;
import com.nali.list.entity.ci.CIEFrame;
import com.nali.list.entity.ci.CIESound;
import com.nali.list.entity.si.*;
import com.nali.list.render.RenderSandCat;
import com.nali.math.M4x4;
import com.nali.math.V4;
import com.nali.small.entity.EntityLe;
import com.nali.small.entity.IMixES;
import com.nali.small.entity.IMixESInv;
import com.nali.small.entity.memo.IBothLe;
import com.nali.small.entity.memo.client.box.mix.MixBoxSle;
import com.nali.small.entity.memo.client.render.mix.MixRenderSle;
import com.nali.small.entity.memo.server.si.SILeLook;
import com.nali.small.entity.memo.server.si.path.SILeFindMove;
import com.nali.small.entity.memo.server.si.path.SILeMineTo;
import com.nali.sound.SoundE;
import com.nali.system.Time;
import com.nali.wild.entity.memo.client.sandcat.ClientSandCat;
import com.nali.wild.entity.memo.client.sandcat.MixCISandCat;
import com.nali.wild.entity.memo.server.sandcat.MixSISandCat;
import com.nali.wild.entity.memo.server.sandcat.ServerSandCat;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.WildData.MODEL_STEP;

public class WildSandCat extends EntityLe implements IMixES, IMixESInv
{
	public static int eggPrimary = 0xffebc7;
	public static int eggSecondary = 0x614c41;

	public static DataParameter<Byte>[] BYTE_DATAPARAMETER_ARRAY = new DataParameter[BothDaSandCat.IDA.E_MaxSync()];
//	public final static DataParameter<Integer>[] INTEGER_DATAPARAMETER_ARRAY = new DataParameter[BothDaSandCat.IDA.S_MaxFrame()];
//	public final static DataParameter<Float>[] FLOAT_DATAPARAMETER_ARRAY = new DataParameter[1];

	public static byte[] CI_BYTE_ARRAY;
	public static byte[] SI_BYTE_ARRAY;

	public IBothLe ibothle;

	public static int[] IV_INT_ARRAY = new int[]
	{
		8+13 + MODEL_STEP, 25349,
		8+13 + MODEL_STEP, 22457,
		6+13 + MODEL_STEP, 906,
		8+13 + MODEL_STEP, 14975,
		8+13 + MODEL_STEP, 7196,
		2+13 + MODEL_STEP, 572
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
			BYTE_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(WildSandCat.class, DataSerializers.BYTE);
		}

//		for (int i = 0; i < INTEGER_DATAPARAMETER_ARRAY.length; ++i)
//		{
//			INTEGER_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(WildSandCat.class, DataSerializers.VARINT);
//		}
//
//		for (int i = 0; i < FLOAT_DATAPARAMETER_ARRAY.length; ++i)
//		{
//			FLOAT_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(WildSandCat.class, DataSerializers.FLOAT);
//		}
	}

	public WildSandCat(World world)
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

			SIELock.ID,
			SILeLockDMG.ID,
			SILeMineTo.ID,
			SIEUseTo.ID,
			SIESit.ID,
			SIELocation.ID,
			SIEFollow.ID,
			SIERevive.ID,
			SIECareOwner.ID,
			SILeAttack.ID,
			SIEManageItem.ID,
			SIEInv.ID,
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

//	@SideOnly(Side.CLIENT)
//	public static ClientSandCat getC()
//	{
//		RenderSandCat r = new RenderSandCat();
//		ClientSandCat c = new ClientSandCat(r);
//		r.c = c;
//		c.mr = new MixRenderSandCat(c);
//		return c;
//	}
//	@Override
//	@SideOnly(Side.CLIENT)
//	public void initFakeFrame()
//	{
//		ClientEntitiesMemory cliententitiesmemory = (ClientEntitiesMemory)this.bothentitiesmemory;
//		SandCatRender skinningrender = (SandCatRender)cliententitiesmemory.objectrender;
////		skinningrender.model_byte_array[4 / 8] &= 239;//255 - Math.pow(2, 4 % 8)
////		skinningrender.model_byte_array[7 / 8] &= 127;//255 - Math.pow(2, 7 % 8)
//		skinningrender.model_byte_array[0] &= 239 & 127;
////		skinningrender.model_byte_array[10 / 8] &= 251;//255 - Math.pow(2, 10 % 8)
////		skinningrender.model_byte_array[11 / 8] &= 247;//255 - Math.pow(2, 11 % 8)
//		skinningrender.model_byte_array[1] &= 251 & 247;
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
		RenderSandCat r = new RenderSandCat();
		ClientSandCat c = new ClientSandCat(this, r, new SoundE());
		MixCISandCat mc = new MixCISandCat(c);
		c.mc = mc;
		c.mb = new MixBoxSle(c);
//		c.mr = new MixRenderSandCat(c);
		MixRenderSle mr = new MixRenderSle(c);
		mr.shadow_opaque = 0.5F;
		mr.shadow_size = 0.25F;
		c.mr = mr;
		r.c = c;
		this.ibothle = c;
	}

	@Override
	public void newS()
	{
		ServerSandCat s = new ServerSandCat(this);
		MixSISandCat ms = new MixSISandCat(s);
		s.ms = ms;
		ms.init();
		s.initKey();
		s.init();
		this.ibothle = s;
	}

	@Override
	public IBothDaE getBD()
	{
		return BothDaSandCat.IDA;
	}

	@Override
	public IBothLe getB()
	{
		return this.ibothle;
	}

//	@Override
//	@SideOnly(Side.CLIENT)
//	public Object createObjectRender()
//	{
//		return new SandCatRender(new EntitiesRenderMemory(), this);
//	}

//	@Override
//	@SideOnly(Side.CLIENT)
//	public Object createSoundRender()
//	{
////		return SoundRender.getSoundRender(DATALOADER);
//		return new NoSoundRender();
//	}
//
//	@Override
//	@SideOnly(Side.CLIENT)
//	public int[] getIVIntArray()
//	{
//		return ClientSandCatMemory.IV_INT_ARRAY;
//	}

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
	public void mulFrame(float[] skinning_float_array, short[] key_short_array)
	{
		float
			body_rot,
			head_rot,
			head_pitch;

		if (this.world.isRemote)
		{
			this.prev_rotation_yaw_body += (this.rotation_yaw_body - this.prev_rotation_yaw_body) * (float) Time.LINE;
			this.prev_rotation_yaw += (this.rotationYaw - this.prev_rotation_yaw) * (float)Time.LINE;
			this.prev_rotation_pitch += (this.rotationPitch - this.prev_rotation_pitch) * (float)Time.LINE;
			body_rot = (float)Math.toRadians(this.prev_rotation_yaw_body);
			head_rot = (float)Math.toRadians(this.prev_rotation_yaw);
			head_pitch = (float)Math.toRadians(this.prev_rotation_pitch);
		}
		else
		{
			body_rot = (float)Math.toRadians(this.rotation_yaw_body);
			head_rot = (float)Math.toRadians(this.rotationYaw);
			head_pitch = (float)Math.toRadians(this.rotationPitch);
		}

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

		M4x4.m(head_m4x4, skinning_float_array, 0, 27*16);

		M4x4.m(body_m4x4, skinning_float_array, 0, 0);
	}
}
