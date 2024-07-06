package com.nali.wild.entity.memo.client.ezoredfox;

import com.nali.data.IBothDaNe;
import com.nali.data.IBothDaSn;
import com.nali.data.client.IClientDaS;
import com.nali.list.render.s.RenderEzoRedFox;
import com.nali.small.entity.IMixLe;
import com.nali.small.entity.Inventory;
import com.nali.small.entity.memo.client.ClientSleInv;
import com.nali.small.entity.memo.client.box.mix.MixBoxSle;
import com.nali.small.entity.memo.client.render.mix.MixRenderSleInv;
import com.nali.sound.ISoundLe;
import com.nali.sound.NoSound;
import com.nali.sound.Sound;
import com.nali.system.opengl.memo.client.MemoGs;
import com.nali.system.opengl.memo.client.MemoSs;
import com.nali.system.opengl.memo.client.store.StoreS;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.WildData.MODEL_S_STEP;

@SideOnly(Side.CLIENT)
public class ClientEzoRedFox<RG extends MemoGs, RS extends MemoSs, RC extends IClientDaS, RST extends StoreS<RG, RS>, R extends RenderEzoRedFox<E, I, MB, MR, ?, SD, BD, RG, RS, RST, RC>, SD extends ISoundLe, BD extends IBothDaNe & IBothDaSn, E extends EntityLivingBase, I extends IMixLe<SD, BD, E>, MB extends MixBoxSle<RG, RS, RC, RST, R, SD, BD, E, I, MR, ?>, MR extends MixRenderSleInv<RG, RS, RC, RST, R, SD, BD, E, I, MB, ?>> extends ClientSleInv<RG, RS, RC, RST, R, SD, BD, E, I, MB, MR>
{
//    @SideOnly(Side.CLIENT)
    public static int[] IV_INT_ARRAY = new int[]
    {
        2/*+0*/ + MODEL_S_STEP, 8760,
        2/*+0*/ + MODEL_S_STEP, 10195,
        4/*+0*/ + MODEL_S_STEP, 1525,
        2/*+0*/ + MODEL_S_STEP, 5390,
        2/*+0*/ + MODEL_S_STEP, 14181,
        11/*+0*/ + MODEL_S_STEP, 961
    };
//    @SideOnly(Side.CLIENT)
    public static float[] ROTATION_FLOAT_ARRAY = new float[]
    {
        0.0F, 0.0F,
        0.0F, 0.0F
    };
//    @SideOnly(Side.CLIENT)
    public static float[] TRANSFORM_FLOAT_ARRAY = new float[]
    {
        0.0F, -0.55F * 0.5F, 0.0F,
        0.0F, -1.0F * 0.5F, 0.1F * 0.5F,
        0.0F, -1.2F * 0.5F, 0.14F * 0.5F,
        0.0F, 0.0F, 0.14F * 0.5F
    };

//    @SideOnly(Side.CLIENT)
    public int eyes_tick = 0;

    public ClientEzoRedFox(I i, R r, Inventory inventory)
    {
        super(i, r, inventory);
    }

    @Override
    public void updateClient()
    {
        E e = this.i.getE();
        int frame = this.r.frame_int_array[0];

        if (e.ticksExisted % 100 == 0)
        {
            this.r.model_byte_array[8 / 8] &= 254;//255 - Math.pow(2, 8 % 8)
            this.r.model_byte_array[9 / 8] |= 2;//Math.pow(2, 9 % 8)
            this.eyes_tick = 20;
        }
        else if (--this.eyes_tick <= 0)
        {
            this.r.model_byte_array[8 / 8] |= 1;//Math.pow(2, 8 % 8)
            this.r.model_byte_array[9 / 8] &= 253;//255 - Math.pow(2, 9 % 8)
        }

        float scale = this.r.scale;
        BD bd = this.i.getBD();
        if ((frame > 241 && frame < 595) || (frame > 594 && frame < 800))
        {
            e.width = bd.Width() * scale;
            e.height = 0.7F * scale;
        }
        else
        {
            e.width = bd.Width() * scale;
            e.height = bd.Height() * scale;
        }

//        skinningrender.model_byte_array[5 / 8] &= 223;//255 - Math.pow(2, 5 % 8)
//        skinningrender.model_byte_array[6 / 8] &= 191;//255 - Math.pow(2, 6 % 8)
//        skinningrender.model_byte_array[7 / 8] &= 127;//255 - Math.pow(2, 7 % 8)
        this.r.model_byte_array[0] &= 223 & 191 & 127;
    }

    @Override
    public void initFakeFrame()
    {
        this.r.model_byte_array[8 / 8] &= 254;//255 - Math.pow(2, 8 % 8)
//        skinningrender.model_byte_array[5 / 8] &= 223;//255 - Math.pow(2, 5 % 8)
//        skinningrender.model_byte_array[6 / 8] &= 191;//255 - Math.pow(2, 6 % 8)
//        skinningrender.model_byte_array[7 / 8] &= 127;//255 - Math.pow(2, 7 % 8)
        this.r.model_byte_array[0] &= 223 & 191 & 127;
    }

    @Override
    public Sound createSound()
    {
        return new NoSound();
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
}
