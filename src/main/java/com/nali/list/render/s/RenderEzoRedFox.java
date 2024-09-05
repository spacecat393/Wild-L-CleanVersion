package com.nali.list.render.s;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;
import com.nali.da.client.IClientDaS;
import com.nali.small.entity.IMixLe;
import com.nali.small.entity.memo.client.ClientSle;
import com.nali.small.entity.memo.client.box.mix.MixBoxSle;
import com.nali.small.entity.memo.client.render.mix.MixRenderSe;
import com.nali.sound.ISoundDaLe;
import com.nali.wild.da.both.BothDaEzoRedFox;
import com.nali.wild.da.client.ClientDaEzoRedFox;
import com.nali.wild.render.WildRenderSe;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;

@SideOnly(Side.CLIENT)
public class RenderEzoRedFox<E extends EntityLivingBase, I extends IMixLe<SD, BD, E>, MB extends MixBoxSle<RC, ?, SD, BD, E, I, MR, C>, MR extends MixRenderSe<RC, ?, SD, BD, E, I, MB, C>, C extends ClientSle<RC, ?, SD, BD, E, I, MB, MR>, SD extends ISoundDaLe, BD extends IBothDaNe & IBothDaSn, RC extends IClientDaS> extends WildRenderSe<E, I, MB, MR, C, SD, BD, RC>
{
//    public static int ID;
//    public static DataLoader DATALOADER = RenderHelper.DATALOADER;
    public static IClientDaS ICLIENTDAS = new ClientDaEzoRedFox();
    public static IBothDaSn IBOTHDASN = BothDaEzoRedFox.IBOTHDASN;
    public byte[] model_byte_array;

    public RenderEzoRedFox(RC rc, BD bd)
    {
        super(rc, bd);
        this.model_byte_array = new byte[(int)Math.ceil((rc.EndPart() - rc.StartPart()) / 8.0D)];
//        this.texture_index_int_array[0] = 0;
//        this.texture_index_int_array[1] = 0;
//        this.texture_index_int_array[2] = 1;
//        this.texture_index_int_array[3] = 2;
//        this.texture_index_int_array[4] = 4;
//        this.texture_index_int_array[5] = 2;
//        this.texture_index_int_array[6] = 4;
//        this.texture_index_int_array[7] = 4;
//        this.texture_index_int_array[8] = 2;
//        this.texture_index_int_array[9] = 2;
//        this.texture_index_int_array[10] = 2;
//        this.texture_index_int_array[11] = 2;
//        this.texture_index_int_array[12] = 3;
        Arrays.fill(this.model_byte_array, (byte)255);
    }

    @Override
    public void draw(int index)
    {
        int i = index - this.rc.StartPart();
        if ((this.model_byte_array[i / 8] >> i % 8 & 1) == 1)
        {
            super.draw(index);
        }
    }

    @Override
    public void drawLater(int index)
    {
        int i = index - this.rc.StartPart();
        if ((this.model_byte_array[i / 8] >> i % 8 & 1) == 1)
        {
            super.drawLater(index);
        }
    }

//    @Override
//    public void setGlow()
//    {
//        this.glow_byte_array[6 / 8] = true;
//        this.glow_byte_array[7 / 8] = true;
//        super.setGlow();
//    }
}
