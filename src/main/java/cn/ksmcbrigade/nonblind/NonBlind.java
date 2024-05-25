package cn.ksmcbrigade.nonblind;

import cn.ksmcbrigade.vmr.module.Module;
import cn.ksmcbrigade.vmr.uitls.ModuleUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod(NonBlind.MODID)
public class NonBlind {

    // Define mod id in a common place for everything to reference
    public static final String MODID = "nbs";

    public NonBlind() {
        MinecraftForge.EVENT_BUS.register(this);

        //Anti

        //AntiBlind
        ModuleUtils.add(new Module("hack.name.anti_bl"));

        //NoPumpkin
        ModuleUtils.add(new Module("hack.name.anti_np"));

        //NoPowderSnow
        ModuleUtils.add(new Module("hack.name.anti_ps"));

        //ESP

        //EntityESP
        ModuleUtils.add(new Module("hack.name.esp_ey"));

        //LivingEntityESP
        ModuleUtils.add(new Module("hack.name.esp_ly"));

        //PlayerESP
        ModuleUtils.add(new Module("hack.name.esp_py"));

        //ItemESP
        ModuleUtils.add(new Module("hack.name.esp_ip"));
    }
}
