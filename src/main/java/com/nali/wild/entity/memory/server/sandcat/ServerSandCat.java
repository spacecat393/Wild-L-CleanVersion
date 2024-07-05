package com.nali.wild.entity.memory.server.sandcat;

import com.nali.data.IBothDaNe;
import com.nali.data.IBothDaSn;
import com.nali.small.entity.EntityLeInv;
import com.nali.small.entity.IMixLe;
import com.nali.small.entity.Inventory;
import com.nali.small.entity.memo.server.ServerSleInv;
import com.nali.small.entity.memo.server.ai.MixAIE;
import com.nali.small.entity.memo.server.ai.frame.FrameS;
import com.nali.sound.ISoundLe;

public class ServerSandCat<SD extends ISoundLe, BD extends IBothDaNe & IBothDaSn, E extends EntityLeInv, I extends IMixLe<SD, BD, E>, A extends MixAIE<SD, BD, E, I, ?>> extends ServerSleInv<SD, BD, E, I, A>
{
    public static int[][] FRAME_INT_2D_ARRAY = new int[][]
    {
        { 1403, 1432 },//walk
        { 1364, 1402 },//run
        { 313, 429 },//pat
        { 1044, 1144 },//sit
        { 1145, 1245 },
        { 1246, 1296 },
        { 0, 93 },//wait
        { 94, 242 },
        { 243, 312 },
        { 430, 496 },//yes
        { 497, 597 },//sad
        { 598, 681 },//joy 1
        { 834, 892 },//idle
        { 682, 757 },//cool
        { 959, 1043 },//attack long
        { 893, 958 },//attack short
        { 758, 833 }//joy 2
    };

    public boolean how_attack;
    public byte pat_state;

    public ServerSandCat(I i, Inventory inventory)
    {
        super(i, inventory);
    }

    @Override
    public void initFrame()
    {

    }

    @Override
    public FrameS[] getFrameSArray()
    {
        return ;
    }

    @Override
    public int[][] getFrame2DIntArray()
    {
        return FRAME_INT_2D_ARRAY;
    }

    @Override
    public void updateServer()
    {

    }
}
