package com.nali.wild.entity.memo.client.sandcat;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;
import com.nali.da.client.IClientDaS;
import com.nali.list.render.s.RenderSandCat;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.IMixESoundDa;
import com.nali.small.entity.Inventory;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.client.ClientLeInv;
import com.nali.small.entity.memo.client.IClientERsInv;
import com.nali.small.entity.memo.client.IClientESound;
import com.nali.small.entity.memo.client.box.mix.MixBoxSleInv;
import com.nali.small.entity.memo.client.ci.MixCIE;
import com.nali.small.entity.memo.client.render.mix.MixRenderSleInv;
import com.nali.sound.ISoundDaLe;
import com.nali.sound.NoSound;
import com.nali.sound.Sound;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.WildData.MODEL_STEP;

@SideOnly(Side.CLIENT)
public class ClientSandCat
<
	IE extends InvLe,
	RC extends IClientDaS,
	R extends RenderSandCat<IE, E, I, MC, MB, MR, ?, SD, BD, RC>,
	SD extends ISoundDaLe,
	BD extends IBothDaNe & IBothDaSn,
	E extends EntityLivingBase,
	I extends IMixE<BD, E> & IMixESoundDa<SD>,
	MC extends MixCIE<RC, R, BD, E, I, MB, MR, ?>,
	MB extends MixBoxSleInv<RC, R, SD, BD, E, I, MC, MR, ?>,
	MR extends MixRenderSleInv<IE, RC, R, SD, BD, E, I, MC, MB, ?>
> extends ClientLeInv<IE, RC, R, SD, BD, E, I, MC, MB, MR> implements IClientERsInv, IClientESound
{
	public Sound sound = new NoSound();
//	@SideOnly(Side.CLIENT)
	public static int[] IV_INT_ARRAY = new int[]
	{
		8+13 + MODEL_STEP, 25349,
		8+13 + MODEL_STEP, 22457,
		6+13 + MODEL_STEP, 906,
		8+13 + MODEL_STEP, 14975,
		8+13 + MODEL_STEP, 7196,
		2+13 + MODEL_STEP, 572
	};
//	@SideOnly(Side.CLIENT)
	public static float[] ROTATION_FLOAT_ARRAY = new float[]
	{
		0.0F, 0.0F,
		0.0F, 0.0F
	};
//	@SideOnly(Side.CLIENT)
	public static float[] TRANSFORM_FLOAT_ARRAY = new float[]
	{
		0.0F, -0.55F * 0.5F, 0.0F,
		0.0F, -1.0F * 0.5F, 0.1F * 0.5F,
		0.0F, -1.2F * 0.5F, 0.14F * 0.5F,
		0.0F, 0.0F, 0.14F * 0.5F
	};

//	@SideOnly(Side.CLIENT)
	public int eyes_tick = 0;

	public ClientSandCat(I i, R r)
	{
		super(i, r);
	}

	@Override
	public byte[] getCI()
	{
		return ;
	}

	@Override
	public void updateClient()
	{
		E e = this.i.getE();
		int frame = this.r.frame_int_array[0];

		if (e.ticksExisted % 100 == 0)
		{
			this.r.model_byte_array[4 / 8] &= 239;//255 - Math.pow(2, 4 % 8)
			this.r.model_byte_array[3 / 8] |= 8;//Math.pow(2, 3 % 8)
			this.eyes_tick = 20;
		}
		else if (--this.eyes_tick <= 0)
		{
			this.r.model_byte_array[4 / 8] |= 16;//Math.pow(2, 4 % 8)
			this.r.model_byte_array[3 / 8] &= 247;//255 - Math.pow(2, 3 % 8)
		}

		float scale = this.r.scale;
		BD bd = this.i.getBD();
		if (frame > 1043 && frame < 1364)
		{
			e.width = bd.Width() * scale;
			e.height = 0.7F * scale;
		}
//		else if (frame >  && frame < )
//		{
//			this.width = 1.5F * scale;
//			this.height = 0.25F * scale;
//		}
		else
		{
			e.width = bd.Width() * scale;
			e.height = bd.Height() * scale;
		}

		this.r.model_byte_array[7 / 8] &= 127;//255 - Math.pow(2, 7 % 8)
//		skinningrender.model_byte_array[10 / 8] &= 251;//255 - Math.pow(2, 10 % 8)
//		skinningrender.model_byte_array[11 / 8] &= 247;//255 - Math.pow(2, 11 % 8)
		this.r.model_byte_array[1] &= 251 & 247;

//		OpenGLSkinningMemory openglskinningmemory = (OpenGLSkinningMemory)cliententitiesmemory.objectrender.memory_object_array[2];
//		for (int v = 0; v < openglskinningmemory.index_int_array.length; ++v)
//		{
//			int vi = openglskinningmemory.index_int_array[v] * 3;
//			float x = openglskinningmemory.vertices_float_array[vi];
//			float y = openglskinningmemory.vertices_float_array[vi + 1];
//			float z = openglskinningmemory.vertices_float_array[vi + 2];
//
//			Vec3d vec3d_a = new Vec3d(0.000005F, -0.112555F, 1.40225F);
//
//			if (vec3d_a.squareDistanceTo(x, y, z) < 0.0001F)
//			{
//				Small.LOGGER.info("V " + v);
//			}
//		}
	}

	@Override
	public void initFakeFrame()
	{
//		skinningrender.model_byte_array[4 / 8] &= 239;//255 - Math.pow(2, 4 % 8)
//		skinningrender.model_byte_array[7 / 8] &= 127;//255 - Math.pow(2, 7 % 8)
		this.r.model_byte_array[0] &= 239 & 127;
//		skinningrender.model_byte_array[10 / 8] &= 251;//255 - Math.pow(2, 10 % 8)
//		skinningrender.model_byte_array[11 / 8] &= 247;//255 - Math.pow(2, 11 % 8)
		this.r.model_byte_array[1] &= 251 & 247;
		super.initFakeFrame();
	}

	@Override
	public Sound getSound()
	{
		return this.sound;
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
}
