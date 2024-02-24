package com.nali.list.entities;

import com.nali.data.BothData;
import com.nali.render.ObjectRender;
import com.nali.render.SkinningRender;
import com.nali.small.entities.bytes.WorkBytes;
import com.nali.small.entities.memory.ClientEntitiesMemory;
import com.nali.small.entities.memory.server.ServerEntitiesMemory;
import com.nali.small.entities.skinning.SkinningEntities;
import com.nali.small.entities.skinning.ai.frame.SkinningEntitiesLiveFrame;
import com.nali.wild.data.EzoRedFoxData;
import com.nali.wild.entities.bytes.EzoRedFoxBytes;
import com.nali.wild.memory.client.ClientEzoRedFoxMemory;
import com.nali.wild.memory.server.ServerEzoRedFoxMemory;
import com.nali.wild.render.EzoRedFoxRender;
import com.nali.wild.render.RenderHelper;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.function.Supplier;

public class WildEzoRedFox extends SkinningEntities
{
    public static int eggPrimary = 0xffb56d;
    public static int eggSecondary = 0xc9453d;
    public final static DataParameter<Integer>[] INTEGER_DATAPARAMETER_ARRAY = new DataParameter[EzoRedFoxData.MAX_FRAME];
    public final static DataParameter<Float>[] FLOAT_DATAPARAMETER_ARRAY = new DataParameter[1];

    public static int[] ATTACK_FRAME_INT_ARRAY = new int[]
    {
        134,
        203
    };
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

    static
    {
        for (int i = 0; i < INTEGER_DATAPARAMETER_ARRAY.length; ++i)
        {
            INTEGER_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(WildEzoRedFox.class, DataSerializers.VARINT);
        }

        for (int i = 0; i < FLOAT_DATAPARAMETER_ARRAY.length; ++i)
        {
            FLOAT_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(WildEzoRedFox.class, DataSerializers.FLOAT);
        }
    }

    public WildEzoRedFox(World world)
    {
        super(world);
    }

    @Override
    public void updateClient()
    {
        ClientEzoRedFoxMemory cliententitiesmemory = (ClientEzoRedFoxMemory)this.bothentitiesmemory;
        SkinningRender skinningrender = (SkinningRender)cliententitiesmemory.objectrender;
        BothData bothdata = cliententitiesmemory.bothdata;
        int frame = skinningrender.frame_int_array[0];

        if (this.ticksExisted % 100 == 0)
        {
            skinningrender.model_boolean_array[8] = false;
            skinningrender.model_boolean_array[9] = true;
            cliententitiesmemory.eyes_tick = 20;
        }
        else if (--cliententitiesmemory.eyes_tick <= 0)
        {
            skinningrender.model_boolean_array[8] = true;
            skinningrender.model_boolean_array[9] = false;
        }

        float scale = skinningrender.scale;
        if ((frame > 241 && frame < 595) || (frame > 594 && frame < 800))
        {
            this.width = bothdata.Width() * scale;
            this.height = 0.7F * scale;
        }
        else
        {
            this.width = bothdata.Width() * scale;
            this.height = bothdata.Height() * scale;
        }

        skinningrender.model_boolean_array[5] = false;
        skinningrender.model_boolean_array[6] = false;
        skinningrender.model_boolean_array[7] = false;
    }

    @Override
    public void initFakeFrame()
    {
        ClientEntitiesMemory cliententitiesmemory = (ClientEntitiesMemory)this.bothentitiesmemory;
        SkinningRender skinningrender = (SkinningRender)cliententitiesmemory.objectrender;
        skinningrender.model_boolean_array[8] = false;
        skinningrender.model_boolean_array[5] = false;
        skinningrender.model_boolean_array[6] = false;
        skinningrender.model_boolean_array[7] = false;
    }

    @Override
    public AxisAlignedBB getMouthAxisAlignedBB()
    {
        if (this.isZeroMove())
        {
            return this.getEntityBoundingBox().grow(0.25);
        }
        else
        {
            double hw = this.width / 2.0F;
            double hh = 0.5;
            Vec3d view_vec3d = this.getLookVec().scale(0.25);
            double x = this.posX + view_vec3d.x;
            double y = this.posY + (double)(this.height / 1.5F) + view_vec3d.y;
            double z = this.posZ + view_vec3d.z;
            return new AxisAlignedBB(x - hw, y, z - hw, x + hw, y + hh, z + hw);
        }
    }

    @Override
    public BothData createBothData()
    {
        return new EzoRedFoxData();
    }

    @Override
    public WorkBytes createWorkBytes()
    {
        return new EzoRedFoxBytes();
    }

    @Override
    public void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(200.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.05D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(20.0D);
    }

    @Override
    public void createServer()
    {
        ServerEzoRedFoxMemory serverentitiesmemory = (ServerEzoRedFoxMemory)this.bothentitiesmemory;
        WorkBytes workbytes = serverentitiesmemory.workbytes;
        serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array = new SkinningEntitiesLiveFrame[1];

        serverentitiesmemory.entitiesaimemory.skinningentitiesattack.attack_frame_int_array = ATTACK_FRAME_INT_ARRAY;
//        serverentitiesmemory.entitiesaimemory.skinningentitiesattack.minimum_distance = 0.5D;

        serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0] = new SkinningEntitiesLiveFrame(this, 0, FRAME_INT_2D_ARRAY);
        serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].condition_boolean_supplier_array = new Supplier[]
        {
            () -> this.isZeroMove() && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoopInSet(3, 4),
            () -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopInSet(3, 5) && serverentitiesmemory.entitiesaimemory.skinningentitiesfindmove.endGoalT(),
            () -> this.isZeroMove() && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(3),

            () -> serverentitiesmemory.current_work_byte_array[workbytes.SIT()] == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoopInSet(6, 7),
            () -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopInSet(6, 8) && serverentitiesmemory.entitiesaimemory.skinningentitiesfindmove.endGoalT(),
            () -> serverentitiesmemory.current_work_byte_array[workbytes.SIT()] == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoop(6),

            () -> !(serverentitiesmemory.entitiesaimemory.skinningentitiesattack.state == 0 || serverentitiesmemory.entitiesaimemory.skinningentitiesattack.state == 1) && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopOffSet(14, 14) && serverentitiesmemory.entitiesaimemory.skinningentitiesfindmove.endGoalT(),
            () -> !(serverentitiesmemory.entitiesaimemory.skinningentitiesattack.state == 0 || serverentitiesmemory.entitiesaimemory.skinningentitiesattack.state == 1) && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopOffSet(15, 15) && serverentitiesmemory.entitiesaimemory.skinningentitiesfindmove.endGoalT(),
            () ->
            {
                boolean result = serverentitiesmemory.entitiesaimemory.skinningentitiesattack.state == 0 || serverentitiesmemory.entitiesaimemory.skinningentitiesattack.state == 1;
                if (result)
                {
                    serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].step = 1;

                    int id = 14;
                    serverentitiesmemory.entitiesaimemory.skinningentitiesattack.minimum_distance = 0.5D;
                    if (serverentitiesmemory.how_attack)
                    {
                        id = 15;
                        serverentitiesmemory.entitiesaimemory.skinningentitiesattack.minimum_distance = 1.0D;
                    }

                    if (serverentitiesmemory.frame_int_array[serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].integer_index] < serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].int_2d_array[id][0] || serverentitiesmemory.frame_int_array[serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].integer_index] >= serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].int_2d_array[id][1])
                    {
                        serverentitiesmemory.frame_int_array[serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].integer_index] = serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].int_2d_array[id][0];
                        serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].step = 0;
                        return true;
                    }

                    for (int attack_frame : serverentitiesmemory.entitiesaimemory.skinningentitiesattack.attack_frame_int_array)
                    {
                        if (serverentitiesmemory.frame_int_array[serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].integer_index] == attack_frame)
                        {
                            serverentitiesmemory.entitiesaimemory.skinningentitiesattack.state = 1;
                            break;
                        }
                    }
                }
                else
                {
                    if (this.ticksExisted % 50 == 0)
                    {
                        serverentitiesmemory.how_attack = !serverentitiesmemory.how_attack;
                    }
                }

                return result;
            },

            () -> serverentitiesmemory.main_work_byte_array[workbytes.ATTACK()] == 1 && this.moveForward != 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(13),

            () -> this.moveForward != 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoopInSet(0, 1),
            () -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopInSet(0, 2),
            () -> this.moveForward != 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(0),

            () -> serverentitiesmemory.current_work_byte_array[workbytes.HARD_READY()] == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(9, workbytes.HARD_READY()),
            () -> serverentitiesmemory.current_work_byte_array[workbytes.SOFT_READY()] == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(10, workbytes.SOFT_READY()),
            () -> serverentitiesmemory.current_work_byte_array[workbytes.ON_PAT()] == 1 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(11, workbytes.ON_PAT()),
            () -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(12)
        };

        serverentitiesmemory.entitiesaimemory.skinningentitiesattack.minimum_distance = 48.0F;
    }

    @Override
    public DataParameter<Integer>[] getIntegerDataParameterArray()
    {
        return INTEGER_DATAPARAMETER_ARRAY;
    }

    @Override
    public DataParameter<Float>[] getFloatDataParameterArray()
    {
        return FLOAT_DATAPARAMETER_ARRAY;
    }

    @Override
    public Object createObjectRender()
    {
        return new EzoRedFoxRender(this.bothentitiesmemory.bothdata, RenderHelper.DATALOADER, this);
    }

    @Override
    public ClientEntitiesMemory createClientEntitiesMemory(BothData bothdata, WorkBytes workbytes)
    {
        return new ClientEzoRedFoxMemory(bothdata, workbytes);
    }

    @Override
    public ServerEntitiesMemory createServerEntitiesMemory(BothData bothdata, WorkBytes workbytes)
    {
        return new ServerEzoRedFoxMemory(bothdata, workbytes);
    }
}
