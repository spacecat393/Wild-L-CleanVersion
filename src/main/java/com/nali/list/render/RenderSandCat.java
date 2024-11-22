package com.nali.list.render;

import com.nali.list.da.BothDaSandCat;
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
public class RenderSandCat
<
	IE extends InvLe,
	E extends EntityLivingBase,
	I extends IMixE<BothDaSandCat, E> & IMixES & IMixESInv,
	MC extends MixCIE<BothDaSandCat, ?, E, I, MB, MR, C>,
	MB extends MixBoxSleInv<BothDaSandCat, ?, E, I, MC, MR, C>,
	MR extends MixRenderSe<BothDaSandCat, ?, E, I, MC, MB, C>,
	C extends ClientLeInv<IE, BothDaSandCat, ?, E, I, MC, MB, MR>
> extends WildRenderSe<E, I, MC, MB, MR, C, BothDaSandCat>
{
	public byte[] model_byte_array;

	public RenderSandCat()
	{
		super(BothDaSandCat.IDA);
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
	public void draw(int index)
	{
		int i = index - BothDaSandCat.IDA.O_StartPart();
		if ((this.model_byte_array[i / 8] >> i % 8 & 1) == 1)
		{
			super.draw(index);
		}
	}

	@Override
	public void drawLater(int index)
	{
		int i = index - BothDaSandCat.IDA.O_StartPart();
		if ((this.model_byte_array[i / 8] >> i % 8 & 1) == 1)
		{
			super.drawLater(index);
		}
	}

//	@Override
//	public void setGlow()
//	{
//		this.glow_boolean_array[] = true;
//		this.glow_boolean_array[] = true;
//		super.setGlow();
//	}
}
