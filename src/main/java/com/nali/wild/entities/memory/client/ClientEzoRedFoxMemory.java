package com.nali.wild.entities.memory.client;

import com.nali.data.BothData;
import com.nali.small.entities.bytes.WorkBytes;
import com.nali.small.entities.memory.ClientEntitiesMemory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ClientEzoRedFoxMemory extends ClientEntitiesMemory
{
    @SideOnly(Side.CLIENT)
    public int eyes_tick = 0;

    public ClientEzoRedFoxMemory(BothData bothdata, WorkBytes workbytes)
    {
        super(bothdata, workbytes);
    }
}
