package com.nali.list.entity.render;

import com.nali.list.entity.WildSandCat;
import com.nali.small.entity.memo.client.render.FRenderSeInv;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class WildFRenderSandCat
<
	E extends WildSandCat
> extends FRenderSeInv<E>
{
	public WildFRenderSandCat(RenderManager rendermanager)
	{
		super(rendermanager);
	}
}
