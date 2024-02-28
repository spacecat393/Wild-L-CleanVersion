package com.nali.wild.entities.memory.server;

import com.nali.data.BothData;
import com.nali.small.entities.bytes.WorkBytes;
import com.nali.small.entities.memory.server.ServerEntitiesMemory;
import com.nali.small.entities.skinning.SkinningEntities;

public class ServerEzoRedFoxMemory extends ServerEntitiesMemory
{
    public boolean how_attack;

    public ServerEzoRedFoxMemory(SkinningEntities skinningentities,  BothData bothdata, WorkBytes workbytes)
    {
        super(skinningentities, bothdata, workbytes);
    }
}
