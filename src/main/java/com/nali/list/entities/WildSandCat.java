package com.nali.list.entities;

import com.nali.data.BothData;
import com.nali.render.SkinningRender;
import com.nali.small.entities.bytes.SkinningEntitiesBytes;
import com.nali.small.entities.skinning.SkinningEntities;
import com.nali.small.entities.skinning.ai.frame.SkinningEntitiesLiveFrame;
import com.nali.wild.data.SandCatData;
import com.nali.wild.entities.bytes.SandCatBytes;
import com.nali.wild.render.RenderHelper;
import com.nali.wild.render.SandCatRender;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.function.Supplier;

public class WildSandCat extends SkinningEntities
{
    public static int eggPrimary = 0xffebc7;
    public static int eggSecondary = 0x614c41;
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

    public int client_eyes_tick = 0;
    public boolean server_how_attack;
    public byte server_pat_state;

    static
    {
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
        SkinningRender skinningrender = (SkinningRender)this.client_object;
        int frame = skinningrender.frame_int_array[0];

        if (this.ticksExisted % 100 == 0)
        {
            skinningrender.model_boolean_array[4] = false;
            skinningrender.model_boolean_array[3] = true;
            this.client_eyes_tick = 20;
        }
        else if (--this.client_eyes_tick <= 0)
        {
            skinningrender.model_boolean_array[4] = true;
            skinningrender.model_boolean_array[3] = false;
        }

        float scale = skinningrender.scale;
        if (frame > 1043 && frame < 1364)
        {
            this.width = this.bothdata.Width() * scale;
            this.height = 0.7F * scale;
        }
//        else if (frame >  && frame < )
//        {
//            this.width = 1.5F * scale;
//            this.height = 0.25F * scale;
//        }
        else
        {
            this.width = this.bothdata.Width() * scale;
            this.height = this.bothdata.Height() * scale;
        }

        skinningrender.model_boolean_array[7] = false;
        skinningrender.model_boolean_array[10] = false;
        skinningrender.model_boolean_array[11] = false;
    }

    @Override
    public void initFakeFrame()
    {
        SkinningRender skinningrender = (SkinningRender)this.client_object;
        skinningrender.model_boolean_array[4] = false;
        skinningrender.model_boolean_array[7] = false;
        skinningrender.model_boolean_array[10] = false;
        skinningrender.model_boolean_array[11] = false;
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
        return new SandCatData();
    }

    @Override
    public SkinningEntitiesBytes createBytes()
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
        this.server_skinningentitiesliveframe_array = new SkinningEntitiesLiveFrame[1];

        this.skinningentitiesattack.attack_frame_int_array = ATTACK_FRAME_INT_ARRAY;
        this.skinningentitiesattack.minimum_distance = 0.5D;

        this.server_skinningentitiesliveframe_array[0] = new SkinningEntitiesLiveFrame(this, 0, FRAME_INT_2D_ARRAY);
        this.server_skinningentitiesliveframe_array[0].condition_boolean_supplier_array = new Supplier[]
        {
            () -> this.isZeroMove() && this.server_skinningentitiesliveframe_array[0].setTLoopInSet(3, 4),
            () -> this.server_skinningentitiesliveframe_array[0].setFLoopInSet(3, 5) && this.skinningentitiesfindmove.endGoalT(),
            () -> this.isZeroMove() && this.server_skinningentitiesliveframe_array[0].setFLoop(3),

            () -> this.server_work_byte_array[this.skinningentitiesbytes.SIT()] == 1 && this.server_skinningentitiesliveframe_array[0].setTLoopInSet(6, 7),
            () -> this.server_skinningentitiesliveframe_array[0].setFLoopInSet(6, 8) && this.skinningentitiesfindmove.endGoalT(),
            () -> this.server_work_byte_array[this.skinningentitiesbytes.SIT()] == 1 && this.server_skinningentitiesliveframe_array[0].setFLoop(6),

            () -> !(this.skinningentitiesattack.state == 0 || this.skinningentitiesattack.state == 1) && this.server_skinningentitiesliveframe_array[0].setFLoopOffSet(14, 14) && this.skinningentitiesfindmove.endGoalT(),
            () -> !(this.skinningentitiesattack.state == 0 || this.skinningentitiesattack.state == 1) && this.server_skinningentitiesliveframe_array[0].setFLoopOffSet(15, 15) && this.skinningentitiesfindmove.endGoalT(),
            () ->
            {
                boolean result = this.skinningentitiesattack.state == 0 || this.skinningentitiesattack.state == 1;
                if (result)
                {
                    this.server_skinningentitiesliveframe_array[0].step = 1;

                    int id = 14;
                    this.skinningentitiesattack.minimum_distance = 0.5D;
                    if (this.server_how_attack)
                    {
                        id = 15;
                        this.skinningentitiesattack.minimum_distance = 1.0D;
                    }

                    if (this.server_frame_int_array[this.server_skinningentitiesliveframe_array[0].integer_index] < this.server_skinningentitiesliveframe_array[0].int_2d_array[id][0] || this.server_frame_int_array[this.server_skinningentitiesliveframe_array[0].integer_index] >= this.server_skinningentitiesliveframe_array[0].int_2d_array[id][1])
                    {
                        this.server_frame_int_array[this.server_skinningentitiesliveframe_array[0].integer_index] = this.server_skinningentitiesliveframe_array[0].int_2d_array[id][0];
                        this.server_skinningentitiesliveframe_array[0].step = 0;
                        return true;
                    }

                    for (int attack_frame : this.skinningentitiesattack.attack_frame_int_array)
                    {
                        if (this.server_frame_int_array[this.server_skinningentitiesliveframe_array[0].integer_index] == attack_frame)
                        {
                            this.skinningentitiesattack.state = 1;
                            break;
                        }
                    }
                }
                else
                {
                    if (this.ticksExisted % 50 == 0)
                    {
                        this.server_how_attack = !this.server_how_attack;
                    }
                }

                return result;
            },

            () -> this.main_server_work_byte_array[this.skinningentitiesbytes.ATTACK()] == 1 && this.moveForward != 0 && this.server_skinningentitiesliveframe_array[0].setTLoop(1),
            () -> this.moveForward != 0 && this.server_skinningentitiesliveframe_array[0].setTLoop(0),

            () -> this.server_work_byte_array[this.skinningentitiesbytes.HARD_READY()] == 1 && this.server_skinningentitiesliveframe_array[0].setFLoopFree(9, this.skinningentitiesbytes.HARD_READY()),
            () -> this.server_work_byte_array[this.skinningentitiesbytes.SOFT_READY()] == 1 && this.server_skinningentitiesliveframe_array[0].setFLoopFree(10, this.skinningentitiesbytes.SOFT_READY()),

            () ->
            {
                boolean result = this.server_work_byte_array[this.skinningentitiesbytes.ON_PAT()] == 1;
                int id = 11;
                if (result)
                {
                    switch (this.server_pat_state)
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
                        ++this.server_pat_state;

                        if (this.server_pat_state > 3)
                        {
                            this.server_pat_state = 0;
                        }
                    }
                }

                return result && this.server_skinningentitiesliveframe_array[0].setFLoopFree(id, this.skinningentitiesbytes.ON_PAT());
            },
            () -> this.server_skinningentitiesliveframe_array[0].setTLoop(12)
        };

        this.skinningentitiesattack.minimum_distance = 48.0F;
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
    public Object createClientObject()
    {
        return new SandCatRender(this.bothdata, RenderHelper.DATALOADER, this);
    }
}
