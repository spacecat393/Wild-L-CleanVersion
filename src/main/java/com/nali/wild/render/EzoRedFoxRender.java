package com.nali.wild.render;

import com.nali.data.BothData;
import com.nali.small.render.SkinningEntitiesRender;
import com.nali.system.DataLoader;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class EzoRedFoxRender extends SkinningEntitiesRender
{
    public EzoRedFoxRender(BothData bothdata, DataLoader dataloader, Entity entity)
    {
        super(bothdata, dataloader, entity);
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

    @Override
    public void setGlow()
    {
        this.glow_boolean_array[6] = true;
        this.glow_boolean_array[7] = true;
        super.setGlow();
    }
}
