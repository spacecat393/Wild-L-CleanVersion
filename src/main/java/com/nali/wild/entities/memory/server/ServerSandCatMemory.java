package com.nali.wild.entities.memory.server;

import com.nali.data.BothData;
import com.nali.small.entities.bytes.WorkBytes;
import com.nali.small.entities.memory.server.ServerEntitiesMemory;
import com.nali.small.entities.skinning.SkinningEntities;

public class ServerSandCatMemory extends ServerEntitiesMemory
{
    public boolean how_attack;
    public byte pat_state;

    public ServerSandCatMemory(SkinningEntities skinningentities, BothData bothdata, WorkBytes workbytes)
    {
        super(skinningentities, bothdata, workbytes);
    }
}
