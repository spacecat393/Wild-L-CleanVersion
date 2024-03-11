package com.nali.list.entities;

import com.nali.data.BothData;
import com.nali.render.EntitiesRenderMemory;
import com.nali.render.SkinningRender;
import com.nali.small.entities.bytes.WorkBytes;
import com.nali.small.entities.memory.ClientEntitiesMemory;
import com.nali.small.entities.skinning.SkinningEntities;
import com.nali.small.entities.skinning.ai.frame.SkinningEntitiesLiveFrame;
import com.nali.wild.data.SandCatData;
import com.nali.wild.entities.bytes.SandCatBytes;
import com.nali.wild.entities.memory.client.ClientSandCatMemory;
import com.nali.wild.entities.memory.server.ServerSandCatMemory;
import com.nali.wild.render.RenderHelper;
import com.nali.wild.render.SandCatRender;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;

import java.util.function.Supplier;

public class WildSandCat extends SkinningEntities
{
    public static int eggPrimary = 0xffebc7;
    public static int eggSecondary = 0x614c41;
    public final static DataParameter<Byte>[] BYTE_DATAPARAMETER_ARRAY = new DataParameter[SandCatData.MAX_SYNC];
    public final static DataParameter<Integer>[] INTEGER_DATAPARAMETER_ARRAY = new DataParameter[SandCatData.MAX_FRAME];
    public final static DataParameter<Float>[] FLOAT_DATAPARAMETER_ARRAY = new DataParameter[1];

    public static int[] ATTACK_FRAME_INT_ARRAY = new int[]
    {
        911,
        912,
        913,
        1004,
        1005,
        1006
    };
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

    static
    {
        for (int i = 0; i < BYTE_DATAPARAMETER_ARRAY.length; ++i)
        {
            BYTE_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(WildSandCat.class, DataSerializers.BYTE);
        }

        for (int i = 0; i < INTEGER_DATAPARAMETER_ARRAY.length; ++i)
        {
            INTEGER_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(WildSandCat.class, DataSerializers.VARINT);
        }

        for (int i = 0; i < FLOAT_DATAPARAMETER_ARRAY.length; ++i)
        {
            FLOAT_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(WildSandCat.class, DataSerializers.FLOAT);
        }
    }

    public WildSandCat(World world)
    {
        super(world);
    }

    @Override
    public void updateClient()
    {
        ClientSandCatMemory cliententitiesmemory = (ClientSandCatMemory)this.bothentitiesmemory;
        SkinningRender skinningrender = (SkinningRender)cliententitiesmemory.objectrender;
        BothData bothdata = cliententitiesmemory.bothdata;
        int frame = skinningrender.frame_int_array[0];

        if (this.ticksExisted % 100 == 0)
        {
            skinningrender.model_boolean_array[4] = false;
            skinningrender.model_boolean_array[3] = true;
            cliententitiesmemory.eyes_tick = 20;
        }
        else if (--cliententitiesmemory.eyes_tick <= 0)
        {
            skinningrender.model_boolean_array[4] = true;
            skinningrender.model_boolean_array[3] = false;
        }

        float scale = skinningrender.entitiesrendermemory.scale;
        if (frame > 1043 && frame < 1364)
        {
            this.width = bothdata.Width() * scale;
            this.height = 0.7F * scale;
        }
//        else if (frame >  && frame < )
//        {
//            this.width = 1.5F * scale;
//            this.height = 0.25F * scale;
//        }
        else
        {
            this.width = bothdata.Width() * scale;
            this.height = bothdata.Height() * scale;
        }

        skinningrender.model_boolean_array[7] = false;
        skinningrender.model_boolean_array[10] = false;
        skinningrender.model_boolean_array[11] = false;

//        OpenGLSkinningMemory openglskinningmemory = (OpenGLSkinningMemory)cliententitiesmemory.objectrender.memory_object_array[2];
//        for (int v = 0; v < openglskinningmemory.index_int_array.length; ++v)
//        {
//            int vi = openglskinningmemory.index_int_array[v] * 3;
//            float x = openglskinningmemory.vertices_float_array[vi];
//            float y = openglskinningmemory.vertices_float_array[vi + 1];
//            float z = openglskinningmemory.vertices_float_array[vi + 2];
//
//            Vec3d vec3d_a = new Vec3d(0.000005F, -0.112555F, 1.40225F);
//
//            if (vec3d_a.squareDistanceTo(x, y, z) < 0.0001F)
//            {
//                Small.LOGGER.info("V " + v);
//            }
//        }
    }

    @Override
    public void initFakeFrame()
    {
        ClientEntitiesMemory cliententitiesmemory = (ClientEntitiesMemory)this.bothentitiesmemory;
        SkinningRender skinningrender = (SkinningRender)cliententitiesmemory.objectrender;
        skinningrender.model_boolean_array[4] = false;
        skinningrender.model_boolean_array[7] = false;
        skinningrender.model_boolean_array[10] = false;
        skinningrender.model_boolean_array[11] = false;
    }

//    @Override
//    public AxisAlignedBB getMouthAxisAlignedBB()
//    {
//        if (this.isZeroMove())
//        {
//            return this.getEntityBoundingBox().grow(0.25);
//        }
//        else
//        {
//            double hw = this.width / 2.0F;
//            double hh = 0.5;
//            Vec3d view_vec3d = this.getLookVec().scale(0.25);
//            double x = this.posX + view_vec3d.x;
//            double y = this.posY + (double)(this.height / 1.5F) + view_vec3d.y;
//            double z = this.posZ + view_vec3d.z;
//            return new AxisAlignedBB(x - hw, y, z - hw, x + hw, y + hh, z + hw);
//        }
//    }

    @Override
    public BothData createBothData()
    {
        return new SandCatData();
    }

    @Override
    public WorkBytes createWorkBytes()
    {
        return new SandCatBytes();
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
        ServerSandCatMemory serverentitiesmemory = (ServerSandCatMemory)this.bothentitiesmemory;
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

            () -> serverentitiesmemory.main_work_byte_array[workbytes.ATTACK()] == 1 && this.moveForward != 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(1),
            () -> this.moveForward != 0 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(0),

            () -> (serverentitiesmemory.statentitiesmemory.stat & 4) == 4 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(9, (byte)4),
            () -> (serverentitiesmemory.statentitiesmemory.stat & 2) == 2 && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(10, (byte)2),

            () ->
            {
                boolean result = (serverentitiesmemory.statentitiesmemory.stat & 1) == 1 || (serverentitiesmemory.statentitiesmemory.stat & 8) == 8;
                int id = 11;
                if (result)
                {
                    switch (serverentitiesmemory.pat_state)
                    {
                        case 0:
                        {
                            id = 2;
                            break;
                        }
                        case 1:
                        {
                            id = 13;
                            break;
                        }
                        case 2:
                        {
                            id = 16;
                            break;
                        }
                        default:
                        {
                            break;
                        }
                    }
                }
                else
                {
                    if (this.ticksExisted % 50 == 0)
                    {
                        ++serverentitiesmemory.pat_state;

                        if (serverentitiesmemory.pat_state > 3)
                        {
                            serverentitiesmemory.pat_state = 0;
                        }
                    }
                }

                return result && serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setFLoopFree(id, (byte)(1 + 8));
            },
            () -> serverentitiesmemory.entitiesaimemory.skinningentitiesliveframe_array[0].setTLoop(12)
        };

        serverentitiesmemory.entitiesaimemory.skinningentitiesattack.minimum_distance = 48.0F;
    }

    @Override
    public DataParameter<Byte>[] getByteDataParameterArray()
    {
        return BYTE_DATAPARAMETER_ARRAY;
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
        return new SandCatRender(new EntitiesRenderMemory(), this.bothentitiesmemory.bothdata, RenderHelper.DATALOADER, this);
    }

    @Override
    public int[] getIVIntArray()
    {
        return ClientSandCatMemory.IV_INT_ARRAY;
    }

    @Override
    public void createClientEntitiesMemory(SkinningEntities skinningentities, BothData bothdata, WorkBytes workbytes)
    {
        new ClientSandCatMemory(skinningentities, bothdata, workbytes);
    }

    @Override
    public void createServerEntitiesMemory(SkinningEntities skinningentities, BothData bothdata, WorkBytes workbytes)
    {
        new ServerSandCatMemory(skinningentities, bothdata, workbytes);
    }
}
