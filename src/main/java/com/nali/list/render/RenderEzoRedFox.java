package com.nali.list.render;

import com.nali.list.da.BothDaEzoRedFox;
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
public class RenderEzoRedFox
<
	E extends EntityLe,
	I extends IMixE<BD, E> & IMixES & IMixESInv,
	MC extends MixCIE<BD, ?, E, I, MB, MR, C>,
	MB extends MixBoxSle<BD, ?, E, I, MC, MR, C>,
	MR extends MixRenderSe<BD, ?, E, I, MC, MB, C>,
	C extends ClientLe<BD, ?, E, I, MC, MB, MR>,
	BD extends BothDaEzoRedFox,
	R extends RenderS<BD> & IRenderS<BD, R>
> extends WildRenderSe<E, I, MC, MB, MR, C, BD, R>
{
	public byte[] model_byte_array;

	public RenderEzoRedFox()
	{
		super((BD)BothDaEzoRedFox.IDA);
		this.model_byte_array = new byte[(int)Math.ceil((BothDaEzoRedFox.IDA.O_EndPart() - BothDaEzoRedFox.IDA.O_StartPart()) / 8.0D)];
//		this.texture_index_int_array[0] = 0;
//		this.texture_index_int_array[1] = 0;
//		this.texture_index_int_array[2] = 1;
//		this.texture_index_int_array[3] = 2;
//		this.texture_index_int_array[4] = 4;
//		this.texture_index_int_array[5] = 2;
//		this.texture_index_int_array[6] = 4;
//		this.texture_index_int_array[7] = 4;
//		this.texture_index_int_array[8] = 2;
//		this.texture_index_int_array[9] = 2;
//		this.texture_index_int_array[10] = 2;
//		this.texture_index_int_array[11] = 2;
//		this.texture_index_int_array[12] = 3;
		Arrays.fill(this.model_byte_array, (byte)255);
	}

	@Override
	public void drawLater()
	{
		int i = this.i - BothDaEzoRedFox.IDA.O_StartPart();
		if ((this.model_byte_array[i / 8] >> i % 8 & 1) == 1)
		{
			super.drawLater();
		}
	}

//	@Override
//	public void draw()
//	{
//		int i = this.i - BothDaEzoRedFox.IDA.O_StartPart();
//		if ((this.model_byte_array[i / 8] >> i % 8 & 1) == 1)
//		{
//			super.draw();
//		}
//	}

//	@Override
//	public void setGlow()
//	{
//		this.glow_byte_array[6 / 8] = true;
//		this.glow_byte_array[7 / 8] = true;
//		super.setGlow();
//	}
}
