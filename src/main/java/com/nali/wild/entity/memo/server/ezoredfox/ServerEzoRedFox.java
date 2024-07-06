package com.nali.wild.entity.memo.server.ezoredfox;

import com.nali.data.IBothDaNe;
import com.nali.data.IBothDaSn;
import com.nali.small.entity.EntityLeInv;
import com.nali.small.entity.IMixLe;
import com.nali.small.entity.Inventory;
import com.nali.small.entity.memo.server.ServerSleInv;
import com.nali.small.entity.memo.server.ai.MixAIE;
import com.nali.small.entity.memo.server.ai.frame.FrameS;
import com.nali.small.entity.memo.server.ai.frame.FrameSleMelee;
import com.nali.small.entity.memo.server.ai.frame.floop.FrameSeFLoopSit;
import com.nali.small.entity.memo.server.ai.frame.floop.FrameSleFLoopDie;
import com.nali.small.entity.memo.server.ai.frame.floopfree.FrameSFLoopFreeHardReady;
import com.nali.small.entity.memo.server.ai.frame.floopfree.FrameSFLoopFreeSoftReady;
import com.nali.small.entity.memo.server.ai.frame.floopfree.FrameSleFLoopFreePE;
import com.nali.small.entity.memo.server.ai.frame.floopinset.FrameSFLoopInSet;
import com.nali.small.entity.memo.server.ai.frame.floopinset.FrameSleFLoopInSetEndMove;
import com.nali.small.entity.memo.server.ai.frame.floopoffset.FrameSleFLoopOffSetAttackPrepare;
import com.nali.small.entity.memo.server.ai.frame.tloop.FrameSTLoop;
import com.nali.small.entity.memo.server.ai.frame.tloop.FrameSleTLoopAttackWalk;
import com.nali.small.entity.memo.server.ai.frame.tloop.FrameSleTLoopWalk;
import com.nali.small.entity.memo.server.ai.frame.tloopinset.FrameSeTLoopInSetSit;
import com.nali.small.entity.memo.server.ai.frame.tloopinset.FrameSleTLoopInSetDie;
import com.nali.small.entity.memo.server.ai.frame.tloopinset.FrameSleTLoopInSetWalk;
import com.nali.sound.ISoundLe;

public class ServerEzoRedFox<SD extends ISoundLe, BD extends IBothDaNe & IBothDaSn, E extends EntityLeInv, I extends IMixLe<SD, BD, E>, A extends MixAIE<SD, BD, E, I, ?>> extends ServerSleInv<SD, BD, E, I, A>
{
    public static int[][] FRAME_INT_2D_ARRAY = new int[][]
    {
        { 0, 25 },//walk
        { 26, 84 },
        { 85, 110 },
        { 242, 342 },//sit
        { 343, 543 },
        { 544, 594 },
        { 595, 655 },//wait
        { 656, 693 },
        { 694, 799 },
        { 800, 866 },//yes
        { 867, 950 },//sad
        { 990, 1073 },//joy
        { 1074, 1163 },//idle
        { 951, 989 },//run
        { 111, 190 },//attack long
        { 191, 241 }//attack short
    };

    public static byte[] FRAME_BYTE_ARRAY = new byte[]
    {
        0, 3, 4,
        0, 3, 5,
        0, 3,
        0, 6, 7,
        0, 6, 8,
        0, 6,
        0, 14, 14,
        0, 15, 15,
        0, 14, 15,
        0, 13,
        0, 0, 1,
        0, 0, 2,
        0, 0,
        0, 9,
        0, 10,
        0, 11,
        0, 12
    };

    public FrameS[] frames_array;

    public ServerEzoRedFox(I i, Inventory inventory)
    {
        super(i, inventory);
    }

    @Override
    public void initFrame()
    {
        this.frames_array = new FrameS[]
        {
            new FrameSleTLoopInSetDie(this, 0),
            new FrameSleFLoopInSetEndMove(this, 3),
            new FrameSleFLoopDie(this, 6),

            new FrameSeTLoopInSetSit(this, 8),
            new FrameSleFLoopInSetEndMove(this, 11),
            new FrameSeFLoopSit(this, 14),

            new FrameSleFLoopOffSetAttackPrepare(this, 16),
            new FrameSleFLoopOffSetAttackPrepare(this, 19),
            new FrameSleMelee(this, 22, (byte)2),

            new FrameSleTLoopAttackWalk(this, 25),

            new FrameSleTLoopInSetWalk(this, 27),
            new FrameSFLoopInSet(this, 30),
            new FrameSleTLoopWalk(this, 33),

            new FrameSFLoopFreeHardReady(this, 35),
            new FrameSFLoopFreeSoftReady(this, 37),
            new FrameSleFLoopFreePE(this, 39),
            new FrameSTLoop(this, 41)
        };
//        () -> this.isZeroMove() && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoopInSet(3, 4),
//        () -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopInSet(3, 5) && serverentitiesmemory.entitiesaimemory.skinningentitiesfindmove.endGoalT(),
//        () -> this.isZeroMove() && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(3),

//        () -> (serverentitiesmemory.current_work_byte_array[workbytes.SIT() / 8] >> workbytes.SIT() % 8 & 1) == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoopInSet(6, 7),
//        () -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopInSet(6, 8) && serverentitiesmemory.entitiesaimemory.skinningentitiesfindmove.endGoalT(),
//        () -> (serverentitiesmemory.current_work_byte_array[workbytes.SIT() / 8] >> workbytes.SIT() % 8 & 1) == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(6),

//        () -> (serverentitiesmemory.entitiesaimemory.skinningentitiesattack.flag & 2) == 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopOffSet(14, 14) && serverentitiesmemory.entitiesaimemory.skinningentitiesfindmove.endGoalT(),
//        () -> (serverentitiesmemory.entitiesaimemory.skinningentitiesattack.flag & 2) == 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopOffSet(15, 15) && serverentitiesmemory.entitiesaimemory.skinningentitiesfindmove.endGoalT(),
//        () ->
//        {
//            boolean result = (serverentitiesmemory.entitiesaimemory.skinningentitiesattack.flag & 2) == 2;
//            if (result)
//            {
//                serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].step = 1;
//
//                int id = 14;
////                    serverentitiesmemory.entitiesaimemory.skinningentitiesattack.minimum_distance = 0.5F;
//                if (serverentitiesmemory.how_attack)
//                {
//                    id = 15;
////                        serverentitiesmemory.entitiesaimemory.skinningentitiesattack.minimum_distance = 1.0F;
//                }
//
//                if (serverentitiesmemory.frame_int_array[serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].integer_index] < serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].int_2d_array[id][0] || serverentitiesmemory.frame_int_array[serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].integer_index] >= serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].int_2d_array[id][1])
//                {
//                    serverentitiesmemory.frame_int_array[serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].integer_index] = serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].int_2d_array[id][0];
//                    serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].step = 0;
//                    return true;
//                }
//
//                for (int attack_frame : serverentitiesmemory.entitiesaimemory.skinningentitiesattack.attack_frame_int_array)
//                {
//                    if (serverentitiesmemory.frame_int_array[serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].integer_index] == attack_frame)
//                    {
//                        serverentitiesmemory.entitiesaimemory.skinningentitiesattack.flag |= 4;
//                        break;
//                    }
//                }
//            }
//            else
//            {
//                if (this.ticksExisted % 50 == 0)
//                {
//                    serverentitiesmemory.how_attack = !serverentitiesmemory.how_attack;
//                }
//            }
//
//            return result;
//        },

//        () -> (serverentitiesmemory.main_work_byte_array[workbytes.ATTACK() / 8] >> workbytes.ATTACK() % 8 & 1) == 1 && this.moveForward != 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(13),

//        () -> this.moveForward != 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoopInSet(0, 1),
//        () -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopInSet(0, 2),
//        () -> this.moveForward != 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(0),

//        () -> (serverentitiesmemory.statentitiesmemory.stat & 4) == 4 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(9, (byte)4),
//        () -> (serverentitiesmemory.statentitiesmemory.stat & 2) == 2 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(10, (byte)2),
//        () -> ((serverentitiesmemory.statentitiesmemory.stat & 1) == 1 || (serverentitiesmemory.statentitiesmemory.stat & 8) == 8) && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(11, (byte)(1 + 8)),
//        () -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(12)
    }

    @Override
    public void updateServer()
    {

    }

    @Override
    public FrameS[] getFrameSArray()
    {
        return this.frames_array;
    }

    @Override
    public byte[] getFrameByteArray()
    {
        return FRAME_BYTE_ARRAY;
    }

    @Override
    public int[][] getFrame2DIntArray()
    {
        return FRAME_INT_2D_ARRAY;
    }
}
