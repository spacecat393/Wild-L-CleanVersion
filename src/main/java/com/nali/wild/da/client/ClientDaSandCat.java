package com.nali.wild.da.client;

import com.nali.da.client.IClientDaS;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.WildData.*;

@SideOnly(Side.CLIENT)
public class ClientDaSandCat implements IClientDaS
{
//	public static IClientDaS ICLIENTDAS = new ClientDaSandCat();

	@Override
	public int FrameID()
	{
		return FRAME_STEP + 1;
	}

	@Override
	public int StartPart()
	{
		return MODEL_STEP + 13;
	}

	@Override
	public int EndPart()
	{
		return MODEL_STEP + 26;
	}
}
