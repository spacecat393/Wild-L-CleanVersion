package com.nali.wild.render.entity;

import com.nali.list.da.BothDaSandCat;
import com.nali.small.entity.EntityLe;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.IMixES;
import com.nali.small.entity.IMixESInv;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.client.ClientLeInv;
import com.nali.small.entity.memo.client.box.mix.MixBoxSleInv;
import com.nali.small.entity.memo.client.ci.MixCIE;
import com.nali.small.entity.memo.client.render.mix.MixRenderSe;
import com.nali.small.render.IRenderS;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderSandCat
<
	IE extends InvLe,
	E extends EntityLe,
	I extends IMixE<BothDaSandCat, E> & IMixES & IMixESInv,
	MC extends MixCIE<BothDaSandCat, ?, E, I, MB, MR, C>,
	MB extends MixBoxSleInv<BothDaSandCat, ?, E, I, MC, MR, C>,
	MR extends MixRenderSe<BothDaSandCat, ?, E, I, MC, MB, C>,
	C extends ClientLeInv<IE, BothDaSandCat, ?, E, I, MC, MB, MR>
> extends com.nali.list.render.RenderSandCat<IE, E, I, MC, MB, MR, C> implements IRenderS<BothDaSandCat, RenderSandCat<IE, E, I, MC, MB, MR, C>>
{
	@Override
	public void drawLater(RenderSandCat<IE, E, I, MC, MB, MR, C> r, int index)
	{
		int i = index - BothDaSandCat.IDA.O_StartPart();
		if ((this.model_byte_array[i / 8] >> i % 8 & 1) == 1)
		{
			IRenderS.super.drawLater(r, index);
		}
	}
}
