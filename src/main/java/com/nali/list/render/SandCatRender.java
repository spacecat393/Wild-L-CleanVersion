package com.nali.list.render;

import com.nali.data.BothData;
import com.nali.list.entities.WildEzoRedFox;
import com.nali.list.entities.WildSandCat;
import com.nali.render.EntitiesRenderMemory;
import com.nali.small.render.SkinningEntitiesRender;
import com.nali.system.DataLoader;
import com.nali.wild.render.RenderHelper;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SandCatRender extends SkinningEntitiesRender
{
    public static int ID;
    public static DataLoader DATALOADER = RenderHelper.DATALOADER;
    public static BothData BOTHDATA = WildSandCat.BOTHDATA;

    public SandCatRender(EntitiesRenderMemory entitiesrendermemory, Entity entity)
    {
        super(entitiesrendermemory, BOTHDATA, DATALOADER, entity, ID);
        this.texture_index_int_array[0] = 5;
        this.texture_index_int_array[1] = 5;
        this.texture_index_int_array[2] = 6;
        this.texture_index_int_array[3] = 6;
        this.texture_index_int_array[4] = 6;
        this.texture_index_int_array[5] = 6;
        this.texture_index_int_array[6] = 7;
        this.texture_index_int_array[7] = 6;
        this.texture_index_int_array[8] = 8;
        this.texture_index_int_array[9] = 6;
        this.texture_index_int_array[10] = 7;
        this.texture_index_int_array[11] = 7;
        this.texture_index_int_array[12] = 9;
    }

//    @Override
//    public void setGlow()
//    {
//        this.glow_boolean_array[] = true;
//        this.glow_boolean_array[] = true;
//        super.setGlow();
//    }
}
