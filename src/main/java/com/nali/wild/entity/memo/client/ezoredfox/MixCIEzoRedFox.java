package com.nali.wild.entity.memo.client.ezoredfox;

import com.nali.list.da.BothDaEzoRedFox;
import com.nali.list.render.RenderEzoRedFox;
import com.nali.small.entity.EntityLe;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.IMixES;
import com.nali.small.entity.IMixESInv;
import com.nali.small.entity.memo.client.ClientLe;
import com.nali.small.entity.memo.client.box.mix.MixBoxSle;
import com.nali.small.entity.memo.client.ci.MixCIE;
import com.nali.small.entity.memo.client.render.mix.MixRenderSle;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class MixCIEzoRedFox
<
	BD extends BothDaEzoRedFox,
	R extends RenderEzoRedFox<E, I, ?, MB, MR, C, BD, R>,
	E extends EntityLe,
	I extends IMixE<BD, E> & IMixES & IMixESInv,
	MB extends MixBoxSle<BD, R, E, I, ?, MR, C>,
	MR extends MixRenderSle<BD, R, E, I, ?, MB, C>,
	C extends ClientLe<BD, R, E, I, ?, MB, MR>
> extends MixCIE<BD, R, E, I, MB, MR, C>
{
	public int eyes_tick = 0;

	public MixCIEzoRedFox(C c)
	{
		super(c);
	}

	//!frame
//	@Override
//	public void updateBox()
//	{
//		R r = this.c.r;
//		I i = this.c.i;
//		E e = i.getE();
//		short key = r.key_short_array[0];
//
//		if (e.ticksExisted % 100 == 0)
//		{
//			r.model_byte_array[8 / 8] &= 254;//255 - Math.pow(2, 8 % 8)
//			r.model_byte_array[9 / 8] |= 2;//Math.pow(2, 9 % 8)
//			this.eyes_tick = 20;
//		}
//		else if (--this.eyes_tick <= 0)
//		{
//			r.model_byte_array[8 / 8] |= 1;//Math.pow(2, 8 % 8)
//			r.model_byte_array[9 / 8] &= 253;//255 - Math.pow(2, 9 % 8)
//		}
//
//		float scale = r.scale;
//		if ((key > 241 && key < 595) || (key > 594 && key < 800))
//		{
//			e.width = BothDaEzoRedFox.IDA.E_Width() * scale;
//			e.height = 0.7F * scale;
//		}
//		else
//		{
//			e.width = BothDaEzoRedFox.IDA.E_Width() * scale;
//			e.height = BothDaEzoRedFox.IDA.E_Height() * scale;
//		}
//
////		skinningrender.model_byte_array[5 / 8] &= 223;//255 - Math.pow(2, 5 % 8)
////		skinningrender.model_byte_array[6 / 8] &= 191;//255 - Math.pow(2, 6 % 8)
////		skinningrender.model_byte_array[7 / 8] &= 127;//255 - Math.pow(2, 7 % 8)
//		r.model_byte_array[0] &= 223 & 191 & 127;
//	}

//	@Override
//	public void onReadNBT()
//	{
//		R r = this.c.r;
//		r.model_byte_array[8 / 8] &= 254;//255 - Math.pow(2, 8 % 8)
////		skinningrender.model_byte_array[5 / 8] &= 223;//255 - Math.pow(2, 5 % 8)
////		skinningrender.model_byte_array[6 / 8] &= 191;//255 - Math.pow(2, 6 % 8)
////		skinningrender.model_byte_array[7 / 8] &= 127;//255 - Math.pow(2, 7 % 8)
//		r.model_byte_array[0] &= 223 & 191 & 127;
//		super.onReadNBT();
//	}
}
