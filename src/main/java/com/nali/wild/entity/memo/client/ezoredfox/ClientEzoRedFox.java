package com.nali.wild.entity.memo.client.ezoredfox;

import com.nali.list.da.BothDaEzoRedFox;
import com.nali.list.render.RenderEzoRedFox;
import com.nali.small.entity.EntityLe;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.IMixES;
import com.nali.small.entity.IMixESInv;
import com.nali.small.entity.memo.client.ClientLe;
import com.nali.small.entity.memo.client.IClientESound;
import com.nali.small.entity.memo.client.box.mix.MixBoxSle;
import com.nali.small.entity.memo.client.ci.MixCIE;
import com.nali.small.entity.memo.client.render.mix.MixRenderSle;
import com.nali.sound.SoundE;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientEzoRedFox
<
	BD extends BothDaEzoRedFox,
	R extends RenderEzoRedFox<E, I, MC, MB, MR, ?, BD, R>,
	E extends EntityLe,
	I extends IMixE<BD, E> & IMixES & IMixESInv,
	MC extends MixCIE<BD, R, E, I, MB, MR, ?>,
	MB extends MixBoxSle<BD, R, E, I, MC, MR, ?>,
	MR extends MixRenderSle<BD, R, E, I, MC, MB, ?>
> extends ClientLe<BD, R, E, I, MC, MB, MR> implements IClientESound
{
	public SoundE sounde;

	public ClientEzoRedFox(I i, R r, SoundE sounde)
	{
		super(i, r);
		this.sounde = sounde;
	}

	public ClientEzoRedFox(R r)
	{
		super(r);
	}

	@Override
	public SoundE getSound()
	{
		return this.sounde;
	}
}
