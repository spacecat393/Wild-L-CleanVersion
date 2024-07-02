package com.nali.list.render;

import com.nali.data.client.ClientData;
import com.nali.list.entity.WildEzoRedFox;
import com.nali.render.EntitiesRenderMemory;
import com.nali.wild.data.client.EzoRedFoxClientDa;
import com.nali.wild.render.skinning.WildSkinningEntitiesRender;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;

@SideOnly(Side.CLIENT)
public class EzoRedFoxRender extends WildSkinningEntitiesRender
{
//    public static int ID;
//    public static DataLoader DATALOADER = RenderHelper.DATALOADER;
//    public static BothData BOTHDATA = WildEzoRedFox.BOTHDATA;
    public static ClientData CLIENTDATA = new EzoRedFoxClientDa();
    public byte[] model_byte_array;

    public EzoRedFoxRender(EntitiesRenderMemory entitiesrendermemory, Entity entity)
    {
        super(entitiesrendermemory, WildEzoRedFox.BOTHDATA, CLIENTDATA/*, RenderHelper.DATALOADER*/, entity);
        this.model_byte_array = new byte[(int)Math.ceil((CLIENTDATA.EndPart() - CLIENTDATA.StartPart()) / 8.0D)];
//        this.texture_index_int_array[0] = 0;
//        this.texture_index_int_array[1] = 0;
//        this.texture_index_int_array[2] = 1;
//        this.texture_index_int_array[3] = 2;
//        this.texture_index_int_array[4] = 4;
//        this.texture_index_int_array[5] = 2;
//        this.texture_index_int_array[6] = 4;
//        this.texture_index_int_array[7] = 4;
//        this.texture_index_int_array[8] = 2;
//        this.texture_index_int_array[9] = 2;
//        this.texture_index_int_array[10] = 2;
//        this.texture_index_int_array[11] = 2;
//        this.texture_index_int_array[12] = 3;
        Arrays.fill(this.model_byte_array, (byte)255);
    }

    @Override
    public void draw(int index)
    {
        int i = index - this.clientdata.StartPart();
        if ((this.model_byte_array[i / 8] >> i % 8 & 1) == 1)
        {
            super.draw(index);
        }
    }

    @Override
    public void drawLater(int index)
    {
        int i = index - this.clientdata.StartPart();
        if ((this.model_byte_array[i / 8] >> i % 8 & 1) == 1)
        {
            super.drawLater(index);
        }
    }

//    @Override
//    public void setGlow()
//    {
//        this.glow_byte_array[6 / 8] = true;
//        this.glow_byte_array[7 / 8] = true;
//        super.setGlow();
//    }
}
