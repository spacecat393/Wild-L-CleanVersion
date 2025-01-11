package com.nali.wild.entity.memo.client.sandcat;

import com.nali.list.da.BothDaSandCat;
import com.nali.list.render.RenderSandCat;
import com.nali.small.entity.EntityLe;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.IMixES;
import com.nali.small.entity.IMixESInv;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.client.ClientLeInv;
import com.nali.small.entity.memo.client.box.mix.MixBoxSleInv;
import com.nali.small.entity.memo.client.ci.MixCIE;
import com.nali.small.render.IRenderS;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class MixCISandCat
<
	IE extends InvLe,
	R extends RenderSandCat<IE, E, I, ?, MB, MR, C> & IRenderS<BothDaSandCat, R>,
	E extends EntityLe,
	I extends IMixE<BothDaSandCat, E> & IMixES & IMixESInv,
	MB extends MixBoxSleInv<BothDaSandCat, R, E, I, ?, MR, C>,
	MR extends MixRenderSandCat<IE, BothDaSandCat, R, E, I, ?, MB, C>,
	C extends ClientLeInv<IE, BothDaSandCat, R, E, I, ?, MB, MR>
> extends MixCIE<BothDaSandCat, R, E, I, MB, MR, C>
{
	public int eyes_tick = 0;

	public MixCISandCat(C c)
	{
		super(c);
	}

	@Override
	public void updateBox()
	{
		R r = this.c.r;
		I i = this.c.i;
		E e = i.getE();
		short key = r.key_short_array[0];

		if (e.ticksExisted % 100 == 0)
		{
			r.model_byte_array[4 / 8] &= 239;//255 - Math.pow(2, 4 % 8)
			r.model_byte_array[3 / 8] |= 8;//Math.pow(2, 3 % 8)
			this.eyes_tick = 20;
		}
		else if (--this.eyes_tick <= 0)
		{
			r.model_byte_array[4 / 8] |= 16;//Math.pow(2, 4 % 8)
			r.model_byte_array[3 / 8] &= 247;//255 - Math.pow(2, 3 % 8)
		}

		float scale = r.scale;
		if (key > 1043 && key < 1364)
		{
			e.width = BothDaSandCat.IDA.E_Width() * scale;
			e.height = 0.7F * scale;
		}
//		else if (key >  && key < )
//		{
//			this.width = 1.5F * scale;
//			this.height = 0.25F * scale;
//		}
		else
		{
			e.width = BothDaSandCat.IDA.E_Width() * scale;
			e.height = BothDaSandCat.IDA.E_Height() * scale;
		}

		r.model_byte_array[7 / 8] &= 127;//255 - Math.pow(2, 7 % 8)
//		skinningrender.model_byte_array[10 / 8] &= 251;//255 - Math.pow(2, 10 % 8)
//		skinningrender.model_byte_array[11 / 8] &= 247;//255 - Math.pow(2, 11 % 8)
		r.model_byte_array[1] &= 251 & 247;

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
	public void onReadNBT()
	{
		R r = this.c.r;
//		skinningrender.model_byte_array[4 / 8] &= 239;//255 - Math.pow(2, 4 % 8)
//		skinningrender.model_byte_array[7 / 8] &= 127;//255 - Math.pow(2, 7 % 8)
		r.model_byte_array[0] &= 239 & 127;
//		skinningrender.model_byte_array[10 / 8] &= 251;//255 - Math.pow(2, 10 % 8)
//		skinningrender.model_byte_array[11 / 8] &= 247;//255 - Math.pow(2, 11 % 8)
		r.model_byte_array[1] &= 251 & 247;
		super.onReadNBT();
	}
}
