package com.nali.wild.entity.memo.client.ezoredfox;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;
import com.nali.da.client.IClientDaS;
import com.nali.list.render.s.RenderEzoRedFox;
import com.nali.small.entity.EntityRefSound;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.client.ClientLeInv;
import com.nali.small.entity.memo.client.IClientERsInv;
import com.nali.small.entity.memo.client.IClientESound;
import com.nali.small.entity.memo.client.box.mix.MixBoxSleInv;
import com.nali.small.entity.memo.client.ci.MixCIE;
import com.nali.small.entity.memo.client.render.mix.MixRenderSleInv;
import com.nali.wild.entity.sound.SoundEzoRedFox;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.WildData.MODEL_STEP;

@SideOnly(Side.CLIENT)
public class ClientEzoRedFox
<
	IE extends InvLe,
	RC extends IClientDaS,
	R extends RenderEzoRedFox<IE, E, I, MC, MB, MR, ?, BD, RC>,
	BD extends IBothDaNe & IBothDaSn,
	E extends EntityLivingBase,
	I extends IMixE<BD, E>,
	MC extends MixCIE<RC, R, BD, E, I, MB, MR, ?>,
	MB extends MixBoxSleInv<RC, R, BD, E, I, MC, MR, ?>,
	MR extends MixRenderSleInv<IE, RC, R, BD, E, I, MC, MB, ?>
> extends ClientLeInv<IE, RC, R, BD, E, I, MC, MB, MR> implements IClientERsInv, IClientESound
{
//	@SideOnly(Side.CLIENT)
	public static int[] IV_INT_ARRAY = new int[]
	{
		2/*+0*/ + MODEL_STEP, 8760,
		2/*+0*/ + MODEL_STEP, 10195,
		4/*+0*/ + MODEL_STEP, 1525,
		2/*+0*/ + MODEL_STEP, 5390,
		2/*+0*/ + MODEL_STEP, 14181,
		11/*+0*/ + MODEL_STEP, 961
	};
//	@SideOnly(Side.CLIENT)
	public static float[] ROTATION_FLOAT_ARRAY = new float[]
	{
		0.0F, 0.0F,
		0.0F, 0.0F
	};
//	@SideOnly(Side.CLIENT)
	public static float[] TRANSFORM_FLOAT_ARRAY = new float[]
	{
		0.0F, -0.55F * 0.5F, 0.0F,
		0.0F, -1.0F * 0.5F, 0.1F * 0.5F,
		0.0F, -1.2F * 0.5F, 0.14F * 0.5F,
		0.0F, 0.0F, 0.14F * 0.5F
	};

	public SoundEzoRedFox soundezoredfox = new SoundEzoRedFox();

	public ClientEzoRedFox(I i, R r)
	{
		super(i, r);
	}

	public ClientEzoRedFox(R r)
	{
		super(r);
	}

	@Override
	public SoundEzoRedFox getSound()
	{
		return this.soundezoredfox;
	}

	@Override
	public int[] getIVIntArray()
	{
		return IV_INT_ARRAY;
	}

	@Override
	public float[] getRotationFloatArray()
	{
		return ROTATION_FLOAT_ARRAY;
	}

	@Override
	public float[] getTransformFloatArray()
	{
		return TRANSFORM_FLOAT_ARRAY;
	}

	@Override
	public void getHurtSound(DamageSource damagesource)
	{
		this.getSound().play(this.getSound().getSoundBuffer(EntityRefSound.HURT));
	}

	@Override
	public void getDeathSound()
	{
		this.getSound().play(this.getSound().getSoundBuffer(EntityRefSound.DEATH));
	}
}
