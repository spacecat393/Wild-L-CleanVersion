package com.nali.list.render.s;

import com.nali.da.IBothDaNe;
import com.nali.da.IBothDaSn;
import com.nali.da.client.IClientDaS;
import com.nali.small.entity.IMixLe;
import com.nali.small.entity.memo.client.ClientSle;
import com.nali.small.entity.memo.client.box.mix.MixBoxSle;
import com.nali.small.entity.memo.client.render.mix.MixRenderE;
import com.nali.sound.ISoundDaLe;
import com.nali.system.opengl.memo.client.MemoGs;
import com.nali.system.opengl.memo.client.MemoSs;
import com.nali.system.opengl.memo.client.store.StoreS;
import com.nali.wild.da.both.BothDaEzoRedFox;
import com.nali.wild.da.client.ClientDaEzoRedFox;
import com.nali.wild.render.WildRenderSe;
import net.minecraft.entity.EntityLivingBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;

import static com.nali.Nali.I;

@SideOnly(Side.CLIENT)
public class RenderEzoRedFox<E extends EntityLivingBase, I extends IMixLe<SD, BD, E>, MB extends MixBoxSle<RG, RS, RC, RST, ?, SD, BD, E, I, MR, C>, MR extends MixRenderE<RG, RS, RC, RST, ?, SD, BD, E, I, MB, C>, C extends ClientSle<RG, RS, RC, RST, ?, SD, BD, E, I, MB, MR>, SD extends ISoundDaLe, BD extends IBothDaNe & IBothDaSn, RG extends MemoGs, RS extends MemoSs, RST extends StoreS<RG, RS>, RC extends IClientDaS> extends WildRenderSe<E, I, MB, MR, C, SD, BD, RG, RS, RST, RC>
{
//    public static int ID;
//    public static DataLoader DATALOADER = RenderHelper.DATALOADER;
//    public static BothData BOTHDATA = WildEzoRedFox.BOTHDATA;
    public byte[] model_byte_array;

    public RenderEzoRedFox()
    {
        this((RST)I.clientloader.stores, (RC)ClientDaEzoRedFox.ICLIENTDAS, (BD)BothDaEzoRedFox.IBOTHDASN);
    }

    public RenderEzoRedFox(RST rst, RC rc, BD bd)
    {
        super(rst, rc, bd);
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
