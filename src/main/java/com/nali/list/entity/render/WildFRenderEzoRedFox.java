package com.nali.list.entity.render;

import com.nali.list.entity.WildEzoRedFox;
import com.nali.small.entity.memo.client.render.FRenderSeInv;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class WildFRenderEzoRedFox
<
	E extends WildEzoRedFox
> extends FRenderSeInv<E>
{
	public WildFRenderEzoRedFox(RenderManager rendermanager)
	{
		super(rendermanager);
	}
}
