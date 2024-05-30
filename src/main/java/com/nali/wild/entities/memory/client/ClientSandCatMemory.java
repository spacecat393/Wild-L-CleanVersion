package com.nali.wild.entities.memory.client;

import com.nali.data.BothData;
import com.nali.list.render.SandCatRender;
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
public class ClientSandCatMemory extends ClientEntitiesMemory
{
//    @SideOnly(Side.CLIENT)
    public static int[] IV_INT_ARRAY = new int[]
    {
        8+15 + MODEL_STEP, 25349,
        8+15 + MODEL_STEP, 22457,
        6+15 + MODEL_STEP, 906,
        8+15 + MODEL_STEP, 14975,
        8+15 + MODEL_STEP, 7196,
        2+15 + MODEL_STEP, 572
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

    public ClientSandCatMemory(SkinningEntities skinningentities, BothData bothdata, WorkBytes workbytes)
    {
        super(skinningentities, bothdata, workbytes);
        this.itemlayerrender.iv_int_array = IV_INT_ARRAY;
        this.itemlayerrender.rotation_float_array = ROTATION_FLOAT_ARRAY;
        this.itemlayerrender.transform_float_array = TRANSFORM_FLOAT_ARRAY;
    }

    @Override
    public void initFakeFrame()
    {
        SandCatRender skinningrender = (SandCatRender)this.objectrender;
//        skinningrender.model_byte_array[4 / 8] &= 239;//255 - Math.pow(2, 4 % 8)
//        skinningrender.model_byte_array[7 / 8] &= 127;//255 - Math.pow(2, 7 % 8)
        skinningrender.model_byte_array[0] &= 239 & 127;
//        skinningrender.model_byte_array[10 / 8] &= 251;//255 - Math.pow(2, 10 % 8)
//        skinningrender.model_byte_array[11 / 8] &= 247;//255 - Math.pow(2, 11 % 8)
        skinningrender.model_byte_array[1] &= 251 & 247;
    }

    @Override
    public ObjectRender createObjectRender()
    {
        return new SandCatRender(new EntitiesRenderMemory(), this.main_skinningentities);
    }

    @Override
    public SoundRender createSoundRender()
    {
        return new NoSoundRender();
    }

    @Override
    public int[] getIVIntArray()
    {
        return ClientSandCatMemory.IV_INT_ARRAY;
    }
}
