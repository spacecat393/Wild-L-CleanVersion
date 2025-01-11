package com.nali.wild.entity.memo.client.ezoredfox;

import com.nali.list.da.BothDaEzoRedFox;
import com.nali.list.render.RenderEzoRedFox;
import com.nali.small.entity.EntityLe;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.IMixES;
import com.nali.small.entity.IMixESInv;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.client.ClientLeInv;
import com.nali.small.entity.memo.client.IClientESound;
import com.nali.small.entity.memo.client.box.mix.MixBoxSleInv;
import com.nali.small.entity.memo.client.ci.MixCIE;
import com.nali.small.entity.memo.client.render.mix.MixRenderSleInv;
import com.nali.small.render.IRenderS;
import com.nali.sound.SoundE;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientEzoRedFox
<
	IE extends InvLe,
	R extends RenderEzoRedFox<IE, E, I, MC, MB, MR, ?> & IRenderS<BothDaEzoRedFox, R>,
	E extends EntityLe,
	I extends IMixE<BothDaEzoRedFox, E> & IMixES & IMixESInv,
	MC extends MixCIE<BothDaEzoRedFox, R, E, I, MB, MR, ?>,
	MB extends MixBoxSleInv<BothDaEzoRedFox, R, E, I, MC, MR, ?>,
	MR extends MixRenderSleInv<IE, BothDaEzoRedFox, R, E, I, MC, MB, ?>
> extends ClientLeInv<IE, BothDaEzoRedFox, R, E, I, MC, MB, MR> implements IClientESound
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
