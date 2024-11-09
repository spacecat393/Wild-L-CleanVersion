package com.nali.wild.entity.memo.client.sandcat;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;
import com.nali.da.client.IClientDaS;
import com.nali.list.render.s.RenderSandCat;
import com.nali.small.entity.EntityRefSound;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.client.ClientLeInv;
import com.nali.small.entity.memo.client.IClientERsInv;
import com.nali.small.entity.memo.client.IClientESound;
import com.nali.small.entity.memo.client.box.mix.MixBoxSleInv;
import com.nali.small.entity.memo.client.ci.MixCIE;
import com.nali.small.entity.memo.client.render.mix.MixRenderSleInv;
import com.nali.wild.entity.sound.SoundSandCat;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.WildData.MODEL_STEP;

@SideOnly(Side.CLIENT)
public class ClientSandCat
<
	IE extends InvLe,
	RC extends IClientDaS,
	R extends RenderSandCat<IE, E, I, MC, MB, MR, ?, BD, RC>,
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
		8+13 + MODEL_STEP, 25349,
		8+13 + MODEL_STEP, 22457,
		6+13 + MODEL_STEP, 906,
		8+13 + MODEL_STEP, 14975,
		8+13 + MODEL_STEP, 7196,
		2+13 + MODEL_STEP, 572
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

	public SoundSandCat soundsandcat = new SoundSandCat();

	public ClientSandCat(I i, R r)
	{
		super(i, r);
	}

	public ClientSandCat(R r)
	{
		super(r);
	}

	@Override
	public SoundSandCat getSound()
	{
		return this.soundsandcat;
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
