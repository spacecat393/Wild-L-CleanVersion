package com.nali.wild.entity.memo.client.sandcat;

import com.nali.list.da.BothDaSandCat;
import com.nali.list.render.RenderSandCat;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.IMixES;
import com.nali.small.entity.IMixESInv;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.client.ClientLeInv;
import com.nali.small.entity.memo.client.IClientESound;
import com.nali.small.entity.memo.client.box.mix.MixBoxSleInv;
import com.nali.small.entity.memo.client.ci.MixCIE;
import com.nali.small.entity.memo.client.render.mix.MixRenderSleInv;
import com.nali.sound.SoundE;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class ClientSandCat
<
	IE extends InvLe,
	R extends RenderSandCat<IE, E, I, MC, MB, MR, ?>,
	E extends EntityLivingBase,
	I extends IMixE<BothDaSandCat, E> & IMixES & IMixESInv,
	MC extends MixCIE<BothDaSandCat, R, E, I, MB, MR, ?>,
	MB extends MixBoxSleInv<BothDaSandCat, R, E, I, MC, MR, ?>,
	MR extends MixRenderSleInv<IE, BothDaSandCat, R, E, I, MC, MB, ?>
> extends ClientLeInv<IE, BothDaSandCat, R, E, I, MC, MB, MR> implements IClientESound
{
	public SoundE sounde = new SoundE();

	public ClientSandCat(I i, R r)
	{
		super(i, r);
	}

	public ClientSandCat(R r)
	{
		super(r);
	}

	@Override
	public SoundE getSound()
	{
		return this.sounde;
	}
}
