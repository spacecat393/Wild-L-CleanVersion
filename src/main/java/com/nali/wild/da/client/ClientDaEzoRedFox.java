package com.nali.wild.da.client;

import com.nali.da.client.IClientDaS;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.list.data.WildData.*;

@SideOnly(Side.CLIENT)
public class ClientDaEzoRedFox implements IClientDaS
{
//	public static IClientDaS ICLIENTDAS = new ClientDaEzoRedFox();

	@Override
	public int FrameID()
	{
		return FRAME_STEP/* + 0*/;
	}

	@Override
	public int StartPart()
	{
		return MODEL_STEP/* + 0*/;
	}

	@Override
	public int EndPart()
	{
		return MODEL_STEP + 13;
	}
}
