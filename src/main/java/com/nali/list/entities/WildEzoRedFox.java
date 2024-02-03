package com.nali.list.entities;

import com.nali.data.BothData;
import com.nali.render.SkinningRender;
import com.nali.small.entities.bytes.SkinningEntitiesBytes;
import com.nali.small.entities.skinning.SkinningEntities;
import com.nali.small.entities.skinning.ai.frame.SkinningEntitiesLiveFrame;
import com.nali.wild.data.EzoRedFoxData;
import com.nali.wild.entities.bytes.EzoRedFoxBytes;
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

    public int client_eyes_tick = 0;
    public boolean server_how_attack;

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
        SkinningRender skinningrender = (SkinningRender)this.client_object;
        int frame = skinningrender.frame_int_array[0];

        if (this.ticksExisted % 100 == 0)
        {
            skinningrender.model_boolean_array[8] = false;
            skinningrender.model_boolean_array[9] = true;
            this.client_eyes_tick = 20;
        }
        else if (--this.client_eyes_tick <= 0)
        {
            skinningrender.model_boolean_array[8] = true;
            skinningrender.model_boolean_array[9] = false;
        }

        float scale = skinningrender.scale;
        if ((frame > 241 && frame < 595) || (frame > 594 && frame < 800))
        {
            this.width = this.bothdata.Width() * scale;
            this.height = 0.7F * scale;
        }
        else
        {
            this.width = this.bothdata.Width() * scale;
            this.height = this.bothdata.Height() * scale;
        }

        skinningrender.model_boolean_array[5] = false;
        skinningrender.model_boolean_array[6] = false;
        skinningrender.model_boolean_array[7] = false;
    }

    @Override
    public void initFakeFrame()
    {
        SkinningRender skinningrender = (SkinningRender)this.client_object;
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
    public SkinningEntitiesBytes createBytes()
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

            () -> this.main_server_work_byte_array[this.skinningentitiesbytes.ATTACK()] == 1 && this.moveForward != 0 && this.server_skinningentitiesliveframe_array[0].setTLoop(13),

            () -> this.moveForward != 0 && this.server_skinningentitiesliveframe_array[0].setTLoopInSet(0, 1),
            () -> this.server_skinningentitiesliveframe_array[0].setFLoopInSet(0, 2),
            () -> this.moveForward != 0 && this.server_skinningentitiesliveframe_array[0].setTLoop(0),

            () -> this.server_work_byte_array[this.skinningentitiesbytes.HARD_READY()] == 1 && this.server_skinningentitiesliveframe_array[0].setFLoopFree(9, this.skinningentitiesbytes.HARD_READY()),
            () -> this.server_work_byte_array[this.skinningentitiesbytes.SOFT_READY()] == 1 && this.server_skinningentitiesliveframe_array[0].setFLoopFree(10, this.skinningentitiesbytes.SOFT_READY()),
            () -> this.server_work_byte_array[this.skinningentitiesbytes.ON_PAT()] == 1 && this.server_skinningentitiesliveframe_array[0].setFLoopFree(11, this.skinningentitiesbytes.ON_PAT()),
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
        return new EzoRedFoxRender(this.bothdata, RenderHelper.DATALOADER, this);
    }
}
