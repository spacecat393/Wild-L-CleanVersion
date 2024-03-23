package com.nali.list.render;

import com.nali.data.BothData;
import com.nali.list.entities.WildEzoRedFox;
import com.nali.render.EntitiesRenderMemory;
import com.nali.small.render.SkinningEntitiesRender;
import com.nali.system.DataLoader;
import com.nali.wild.render.RenderHelper;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class EzoRedFoxRender extends SkinningEntitiesRender
{
    public static int ID;
    public static DataLoader DATALOADER = RenderHelper.DATALOADER;
    public static BothData BOTHDATA = WildEzoRedFox.BOTHDATA;

    public EzoRedFoxRender(EntitiesRenderMemory entitiesrendermemory, Entity entity)
    {
        super(entitiesrendermemory, BOTHDATA, DATALOADER, entity, ID);
        this.texture_index_int_array[0] = 0;
        this.texture_index_int_array[1] = 0;
        this.texture_index_int_array[2] = 1;
        this.texture_index_int_array[3] = 2;
        this.texture_index_int_array[4] = 4;
        this.texture_index_int_array[5] = 2;
        this.texture_index_int_array[6] = 4;
        this.texture_index_int_array[7] = 4;
        this.texture_index_int_array[8] = 2;
        this.texture_index_int_array[9] = 2;
        this.texture_index_int_array[10] = 2;
        this.texture_index_int_array[11] = 2;
        this.texture_index_int_array[12] = 3;
    }

//    @Override
//    public void setGlow()
//    {
//        this.glow_byte_array[6 / 8] = true;
//        this.glow_byte_array[7 / 8] = true;
//        super.setGlow();
//    }
}
