package com.nali.wild.entities.memory.client;

import com.nali.data.BothData;
import com.nali.list.render.EzoRedFoxRender;
import com.nali.render.EntitiesRenderMemory;
import com.nali.render.NoSoundRender;
import com.nali.render.ObjectRender;
import com.nali.render.SoundRender;
import com.nali.small.entities.bytes.WorkBytes;
import com.nali.small.entities.memory.client.ClientEntitiesMemory;
import com.nali.small.entities.skinning.SkinningEntities;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.WildData.MODEL_STEP;

@SideOnly(Side.CLIENT)
public class ClientEzoRedFoxMemory extends ClientEntitiesMemory
{
//    @SideOnly(Side.CLIENT)
    public static int[] IV_INT_ARRAY = new int[]
    {
        2+1 + MODEL_STEP, 8760,
        2+1 + MODEL_STEP, 10195,
        4+1 + MODEL_STEP, 1525,
        2+1 + MODEL_STEP, 5390,
        2+1 + MODEL_STEP, 14181,
        11+1 + MODEL_STEP, 961
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

    public ClientEzoRedFoxMemory(SkinningEntities skinningentities, BothData bothdata, WorkBytes workbytes)
    {
        super(skinningentities, bothdata, workbytes);
        this.itemlayerrender.iv_int_array = IV_INT_ARRAY;
        this.itemlayerrender.rotation_float_array = ROTATION_FLOAT_ARRAY;
        this.itemlayerrender.transform_float_array = TRANSFORM_FLOAT_ARRAY;
    }

    @Override
    public void initFakeFrame()
    {
        EzoRedFoxRender skinningrender = (EzoRedFoxRender)this.objectrender;
        skinningrender.model_byte_array[8 / 8] &= 254;//255 - Math.pow(2, 8 % 8)
//        skinningrender.model_byte_array[5 / 8] &= 223;//255 - Math.pow(2, 5 % 8)
//        skinningrender.model_byte_array[6 / 8] &= 191;//255 - Math.pow(2, 6 % 8)
//        skinningrender.model_byte_array[7 / 8] &= 127;//255 - Math.pow(2, 7 % 8)
        skinningrender.model_byte_array[0] &= 223 & 191 & 127;
    }

    @Override
    public ObjectRender createObjectRender()
    {
        return new EzoRedFoxRender(new EntitiesRenderMemory(), this.main_skinningentities);
    }

    @Override
    public SoundRender createSoundRender()
    {
        return new NoSoundRender();
    }

    @Override
    public int[] getIVIntArray()
    {
        return ClientEzoRedFoxMemory.IV_INT_ARRAY;
    }
}
