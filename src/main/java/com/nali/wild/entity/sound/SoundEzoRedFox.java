package com.nali.wild.entity.sound;

import com.nali.sound.Sound;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class SoundEzoRedFox extends Sound
{
	@Override
	public void set()
	{
		setE(this.source);
	}

	@Override
	public int getSoundBuffer(byte b)
	{
		return -1;
	}
}
