package com.nali.list.render;

import com.nali.list.da.BothDaEzoRedFox;
import com.nali.small.entity.EntityLe;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.IMixES;
import com.nali.small.entity.IMixESInv;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.client.ClientLeInv;
import com.nali.small.entity.memo.client.box.mix.MixBoxSleInv;
import com.nali.small.entity.memo.client.ci.MixCIE;
import com.nali.small.entity.memo.client.render.mix.MixRenderSe;
import com.nali.wild.render.WildRenderSe;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;

@SideOnly(Side.CLIENT)
public class RenderEzoRedFox
<
	IE extends InvLe,
	E extends EntityLe,
	I extends IMixE<BothDaEzoRedFox, E> & IMixES & IMixESInv,
	MC extends MixCIE<BothDaEzoRedFox, ?, E, I, MB, MR, C>,
	MB extends MixBoxSleInv<BothDaEzoRedFox, ?, E, I, MC, MR, C>,
	MR extends MixRenderSe<BothDaEzoRedFox, ?, E, I, MC, MB, C>,
	C extends ClientLeInv<IE, BothDaEzoRedFox, ?, E, I, MC, MB, MR>
> extends WildRenderSe<E, I, MC, MB, MR, C, BothDaEzoRedFox>
{
	public byte[] model_byte_array;

	public RenderEzoRedFox()
	{
		super(BothDaEzoRedFox.IDA);
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
	public void draw(int index)
	{
		int i = index - BothDaEzoRedFox.IDA.O_StartPart();
		if ((this.model_byte_array[i / 8] >> i % 8 & 1) == 1)
		{
			super.draw(index);
		}
	}

//	@Override
//	public void setGlow()
//	{
//		this.glow_byte_array[6 / 8] = true;
//		this.glow_byte_array[7 / 8] = true;
//		super.setGlow();
//	}
}
