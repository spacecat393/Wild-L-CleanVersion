package com.nali.list.render;

import com.nali.data.client.ClientData;
import com.nali.list.entity.WildSandCat;
import com.nali.render.EntitiesRenderMemory;
import com.nali.wild.data.client.ClientDaSandCat;
import com.nali.wild.render.skinning.WildRenderSe;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;

@SideOnly(Side.CLIENT)
public class RenderSandCat extends WildRenderSe
{
//    public static int ID;
//    public static DataLoader DATALOADER = RenderHelper.DATALOADER;
//    public static BothData BOTHDATA = WildSandCat.BOTHDATA;
    public static ClientData CLIENTDATA = new ClientDaSandCat();
    public byte[] model_byte_array;

    public RenderSandCat(EntitiesRenderMemory entitiesrendermemory, Entity entity)
    {
        super(entitiesrendermemory, WildSandCat.BOTHDATA, CLIENTDATA/*, RenderHelper.DATALOADER*/, entity);
        this.model_byte_array = new byte[(int)Math.ceil((CLIENTDATA.EndPart() - CLIENTDATA.StartPart()) / 8.0D)];
//        this.texture_index_int_array[0] = 5;
//        this.texture_index_int_array[1] = 5;
//        this.texture_index_int_array[2] = 6;
//        this.texture_index_int_array[3] = 6;
//        this.texture_index_int_array[4] = 6;
//        this.texture_index_int_array[5] = 6;
//        this.texture_index_int_array[6] = 7;
//        this.texture_index_int_array[7] = 6;
//        this.texture_index_int_array[8] = 8;
//        this.texture_index_int_array[9] = 6;
//        this.texture_index_int_array[10] = 7;
//        this.texture_index_int_array[11] = 7;
//        this.texture_index_int_array[12] = 9;
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
//        this.glow_boolean_array[] = true;
//        this.glow_boolean_array[] = true;
//        super.setGlow();
//    }
}
