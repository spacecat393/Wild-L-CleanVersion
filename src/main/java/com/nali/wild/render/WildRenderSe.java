package com.nali.wild.render;

import com.nali.da.IBothDaE;
import com.nali.da.IBothDaO;
import com.nali.da.IBothDaS;
import com.nali.render.RenderS;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.IMixES;
import com.nali.small.entity.memo.client.ClientE;
import com.nali.small.entity.memo.client.box.mix.MixBoxE;
import com.nali.small.entity.memo.client.ci.MixCIE;
import com.nali.small.entity.memo.client.render.mix.MixRenderSe;
import com.nali.small.render.IRenderS;
import com.nali.small.render.RenderSe;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.WildData.SHADER_STEP;
import static com.nali.list.data.WildData.TEXTURE_STEP;

@SideOnly(Side.CLIENT)
public class WildRenderSe
<
	E extends Entity,
	I extends IMixE<BD, E> & IMixES,
	MC extends MixCIE<BD, ?, E, I, MB, MR, C>,
	MB extends MixBoxE<BD, ?, E, I, MC, MR, C>,
	MR extends MixRenderSe<BD, ?, E, I, MC, MB, C>,
	C extends ClientE<BD, ?, E, I, MC, MB, MR>,
	BD extends IBothDaE & IBothDaO & IBothDaS,
	R extends RenderS<BD> & IRenderS<BD, R>
> extends RenderSe<E, I, MC, MB, MR, C, BD, R>
{
	public WildRenderSe(BD bd)
	{
		super(bd);
	}

	@Override
	public int getTextureID()
	{
		return TEXTURE_STEP + super.getTextureID();
	}

	@Override
	public int getShaderID()
	{
		return SHADER_STEP + super.getShaderID();
	}
}
