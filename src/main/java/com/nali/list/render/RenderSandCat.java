package com.nali.list.render;

import com.nali.list.da.BothDaSandCat;
import com.nali.render.RenderS;
import com.nali.small.entity.EntityLe;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.IMixES;
import com.nali.small.entity.IMixESInv;
import com.nali.small.entity.memo.client.ClientLe;
import com.nali.small.entity.memo.client.box.mix.MixBoxSle;
import com.nali.small.entity.memo.client.ci.MixCIE;
import com.nali.small.entity.memo.client.render.mix.MixRenderSe;
import com.nali.small.render.IRenderS;
import com.nali.wild.render.WildRenderSe;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;

@SideOnly(Side.CLIENT)
public class RenderSandCat
<
	E extends EntityLe,
	I extends IMixE<BD, E> & IMixES & IMixESInv,
	MC extends MixCIE<BD, ?, E, I, MB, MR, C>,
	MB extends MixBoxSle<BD, ?, E, I, MC, MR, C>,
	MR extends MixRenderSe<BD, ?, E, I, MC, MB, C>,
	C extends ClientLe<BD, ?, E, I, MC, MB, MR>,
	BD extends BothDaSandCat,
	R extends RenderS<BD> & IRenderS<BD, R>
> extends WildRenderSe<E, I, MC, MB, MR, C, BD, R>
{
	public byte[] model_byte_array;

	public RenderSandCat()
	{
		super((BD)BothDaSandCat.IDA);
		this.model_byte_array = new byte[(int)Math.ceil((BothDaSandCat.IDA.O_EndPart() - BothDaSandCat.IDA.O_StartPart()) / 8.0D)];
//		this.texture_index_int_array[0] = 5;
//		this.texture_index_int_array[1] = 5;
//		this.texture_index_int_array[2] = 6;
//		this.texture_index_int_array[3] = 6;
//		this.texture_index_int_array[4] = 6;
//		this.texture_index_int_array[5] = 6;
//		this.texture_index_int_array[6] = 7;
//		this.texture_index_int_array[7] = 6;
//		this.texture_index_int_array[8] = 8;
//		this.texture_index_int_array[9] = 6;
//		this.texture_index_int_array[10] = 7;
//		this.texture_index_int_array[11] = 7;
//		this.texture_index_int_array[12] = 9;
		Arrays.fill(this.model_byte_array, (byte)255);
	}

	@Override
	public void drawLater()
	{
		int i = this.i - BothDaSandCat.IDA.O_StartPart();
		if ((this.model_byte_array[i / 8] >> i % 8 & 1) == 1)
		{
			super.drawLater();
		}
	}

//	@Override
//	public void draw()
//	{
//		int i = this.i - BothDaSandCat.IDA.O_StartPart();
//		if ((this.model_byte_array[i / 8] >> i % 8 & 1) == 1)
//		{
//			super.draw();
//		}
//	}

//	@Override
//	public void setGlow()
//	{
//		this.glow_boolean_array[] = true;
//		this.glow_boolean_array[] = true;
//		super.setGlow();
//	}
}
