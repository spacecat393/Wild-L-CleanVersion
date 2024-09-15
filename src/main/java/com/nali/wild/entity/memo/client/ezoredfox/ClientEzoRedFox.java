package com.nali.wild.entity.memo.client.ezoredfox;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;
import com.nali.da.client.IClientDaS;
import com.nali.list.entity.ci.CIEFrame;
import com.nali.list.entity.ci.CIESound;
import com.nali.list.render.s.RenderEzoRedFox;
import com.nali.small.entity.IMixE;
import com.nali.small.entity.IMixESoundDa;
import com.nali.small.entity.inv.InvLe;
import com.nali.small.entity.memo.client.ClientLeInv;
import com.nali.small.entity.memo.client.IClientERsInv;
import com.nali.small.entity.memo.client.IClientESound;
import com.nali.small.entity.memo.client.box.mix.MixBoxSleInv;
import com.nali.small.entity.memo.client.ci.MixCIE;
import com.nali.small.entity.memo.client.render.mix.MixRenderSleInv;
import com.nali.sound.ISoundDaLe;
import com.nali.sound.NoSound;
import com.nali.sound.Sound;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.WildData.MODEL_STEP;

@SideOnly(Side.CLIENT)
public class ClientEzoRedFox
<
	IE extends InvLe,
	RC extends IClientDaS,
	R extends RenderEzoRedFox<IE, E, I, MC, MB, MR, ?, SD, BD, RC>,
	SD extends ISoundDaLe,
	BD extends IBothDaNe & IBothDaSn,
	E extends EntityLivingBase,
	I extends IMixE<BD, E> & IMixESoundDa<SD>,
	MC extends MixCIE<RC, R, BD, E, I, MB, MR, ?>,
	MB extends MixBoxSleInv<RC, R, SD, BD, E, I, MC, MR, ?>,
	MR extends MixRenderSleInv<IE, RC, R, SD, BD, E, I, MC, MB, ?>
> extends ClientLeInv<IE, RC, R, SD, BD, E, I, MC, MB, MR> implements IClientERsInv, IClientESound
{
	public static byte[] CI_BYTE_ARRAY =
	{
		CIEFrame.ID,
		CIESound.ID
	};

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

	public Sound sound = new NoSound();

	public ClientEzoRedFox(I i, R r)
	{
		super(i, r);
	}

	@Override
	public Sound getSound()
	{
		return this.sound;
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
	public byte[] getCI()
	{
		return CI_BYTE_ARRAY;
	}
}
