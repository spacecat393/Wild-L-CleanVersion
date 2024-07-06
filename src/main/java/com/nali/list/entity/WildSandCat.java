package com.nali.list.entity;

import com.nali.data.IBothDaNe;
import com.nali.small.entity.EntityLeInv;
import com.nali.wild.da.both.BothDaSandCat;
import com.nali.wild.entity.memo.server.sandcat.MixAISandCat;
import com.nali.wild.entity.sound.SoundSandCat;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;

public class WildSandCat extends EntityLeInv
{
    public static int eggPrimary = 0xffebc7;
    public static int eggSecondary = 0x614c41;

    public final static DataParameter<Byte>[] BYTE_DATAPARAMETER_ARRAY = new DataParameter[BothDaSandCat.MAX_SYNC];
    public final static DataParameter<Integer>[] INTEGER_DATAPARAMETER_ARRAY = new DataParameter[BothDaSandCat.MAX_FRAME];
    public final static DataParameter<Float>[] FLOAT_DATAPARAMETER_ARRAY = new DataParameter[1];

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

//    @Override
//    @SideOnly(Side.CLIENT)
//    public void initFakeFrame()
//    {
//        ClientEntitiesMemory cliententitiesmemory = (ClientEntitiesMemory)this.bothentitiesmemory;
//        SandCatRender skinningrender = (SandCatRender)cliententitiesmemory.objectrender;
////        skinningrender.model_byte_array[4 / 8] &= 239;//255 - Math.pow(2, 4 % 8)
////        skinningrender.model_byte_array[7 / 8] &= 127;//255 - Math.pow(2, 7 % 8)
//        skinningrender.model_byte_array[0] &= 239 & 127;
////        skinningrender.model_byte_array[10 / 8] &= 251;//255 - Math.pow(2, 10 % 8)
////        skinningrender.model_byte_array[11 / 8] &= 247;//255 - Math.pow(2, 11 % 8)
//        skinningrender.model_byte_array[1] &= 251 & 247;
//    }

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
    public void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(200.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.05D);
        this.getAttributeMap().registerAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(20.0D);
    }

    @Override
    public byte[] getAI()
    {
        return MixAISandCat.AI_BYTE_ARRAY;
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
    public void newC()
    {

    }

    @Override
    public void newS()
    {

    }

    @Override
    public IBothDaNe getBD()
    {
        return BothDaSandCat.IBOTHDASN;
    }

    @Override
    public Object getSD()
    {
        return SoundSandCat.ISOUNDLE;
    }

//    @Override
//    @SideOnly(Side.CLIENT)
//    public Object createObjectRender()
//    {
//        return new SandCatRender(new EntitiesRenderMemory(), this);
//    }

//    @Override
//    @SideOnly(Side.CLIENT)
//    public Object createSoundRender()
//    {
////        return SoundRender.getSoundRender(DATALOADER);
//        return new NoSoundRender();
//    }
//
//    @Override
//    @SideOnly(Side.CLIENT)
//    public int[] getIVIntArray()
//    {
//        return ClientSandCatMemory.IV_INT_ARRAY;
//    }
}
