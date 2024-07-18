package com.nali.list.entity;

import com.nali.da.IBothDaNe;
import com.nali.list.render.s.RenderEzoRedFox;
import com.nali.small.entity.EntityLeInv;
import com.nali.small.entity.Inventory;
import com.nali.small.entity.memo.client.box.mix.MixBoxSle;
import com.nali.wild.da.both.BothDaEzoRedFox;
import com.nali.wild.da.client.ClientDaEzoRedFox;
import com.nali.wild.entity.memo.client.ezoredfox.ClientEzoRedFox;
import com.nali.wild.entity.memo.client.ezoredfox.MixRenderEzoRedFox;
import com.nali.wild.entity.memo.server.ezoredfox.MixAIEzoRedFox;
import com.nali.wild.entity.memo.server.ezoredfox.ServerEzoRedFox;
import com.nali.wild.entity.sound.SoundDaEzoRedFox;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import static com.nali.Nali.I;

public class WildEzoRedFox extends EntityLeInv
{
    public static int eggPrimary = 0xffb56d;
    public static int eggSecondary = 0xc9453d;

    public final static DataParameter<Byte>[] BYTE_DATAPARAMETER_ARRAY = new DataParameter[BothDaEzoRedFox.MAX_SYNC];
    public final static DataParameter<Integer>[] INTEGER_DATAPARAMETER_ARRAY = new DataParameter[BothDaEzoRedFox.MAX_FRAME];
    public final static DataParameter<Float>[] FLOAT_DATAPARAMETER_ARRAY = new DataParameter[1];

    static
    {
        for (int i = 0; i < BYTE_DATAPARAMETER_ARRAY.length; ++i)
        {
            BYTE_DATAPARAMETER_ARRAY[i] = EntityDataManager.createKey(WildEzoRedFox.class, DataSerializers.BYTE);
        }

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

//    @Override
//    @SideOnly(Side.CLIENT)
//    public void initFakeFrame()
//    {
//        ClientEntitiesMemory cliententitiesmemory = (ClientEntitiesMemory)this.bothentitiesmemory;
//        EzoRedFoxRender skinningrender = (EzoRedFoxRender)cliententitiesmemory.objectrender;
//        skinningrender.model_byte_array[8 / 8] &= 254;//255 - Math.pow(2, 8 % 8)
////        skinningrender.model_byte_array[5 / 8] &= 223;//255 - Math.pow(2, 5 % 8)
////        skinningrender.model_byte_array[6 / 8] &= 191;//255 - Math.pow(2, 6 % 8)
////        skinningrender.model_byte_array[7 / 8] &= 127;//255 - Math.pow(2, 7 % 8)
//        skinningrender.model_byte_array[0] &= 223 & 191 & 127;
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
        return MixAIEzoRedFox.AI_BYTE_ARRAY;
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

    @SideOnly(Side.CLIENT)
    @Override
    public void newC()
    {
        RenderEzoRedFox r = new RenderEzoRedFox(I.clientloader.stores, ClientDaEzoRedFox.ICLIENTDAS, BothDaEzoRedFox.IBOTHDASN);
        ClientEzoRedFox c = new ClientEzoRedFox(this, r, new Inventory(1));
        c.mb = new MixBoxSle(c);
        c.mr = new MixRenderEzoRedFox(c);
        r.c = c;
        this.ibothleinv = c;
    }

    @Override
    public void newS()
    {
        ServerEzoRedFox s = new ServerEzoRedFox(this, new Inventory(1));
        MixAIEzoRedFox a = new MixAIEzoRedFox(s);
        s.a = a;
        a.init();
        s.initFrame();
        this.ibothleinv = s;
    }

    @Override
    public IBothDaNe getBD()
    {
        return BothDaEzoRedFox.IBOTHDASN;
    }

    @Override
    public Object getSD()
    {
        return SoundDaEzoRedFox.ISOUNDDALE;
    }
}
