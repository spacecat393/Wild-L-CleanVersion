package com.nali.wild.render.skinning;

import com.nali.data.BothData;
import com.nali.data.client.ClientData;
import com.nali.render.EntitiesRenderMemory;
import com.nali.small.render.SkinningEntitiesRender;
import com.nali.system.opengl.memory.OpenGLObjectMemory;
import net.minecraft.entity.Entity;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.WildData.SHADER_STEP;
import static com.nali.list.data.WildData.TEXTURE_STEP;

@SideOnly(Side.CLIENT)
public class WildSkinningEntitiesRender extends SkinningEntitiesRender
{
    public WildSkinningEntitiesRender(EntitiesRenderMemory entitiesrendermemory, BothData bothdata, ClientData clientdata, Entity entity)
    {
        super(entitiesrendermemory, bothdata, clientdata, entity);
    }

    @Override
    public int getTextureID(OpenGLObjectMemory openglobjectmemory)
    {
        return TEXTURE_STEP + super.getTextureID(openglobjectmemory);
    }

    @Override
    public int getShaderID(OpenGLObjectMemory openglobjectmemory)
    {
        return SHADER_STEP + super.getShaderID(openglobjectmemory);
    }
}
