package cn.ksmcbrigade.nonblind.mixin;

import cn.ksmcbrigade.vmr.uitls.ModuleUtils;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(Gui.class)
public class GuiMixin {
    @Inject(method = "renderTextureOverlay",at = @At("HEAD"), cancellable = true)
    public void render(GuiGraphics p_282304_, ResourceLocation p_281622_, float p_281504_, CallbackInfo ci){
        if(p_281622_.getPath().equalsIgnoreCase("textures/misc/pumpkinblur.png") && ModuleUtils.enabled("hack.name.anti_np")){
            ci.cancel();
        }

        if(p_281622_.getPath().equalsIgnoreCase("textures/misc/powder_snow_outline.png") && ModuleUtils.enabled("hack.name.anti_ps")){
            ci.cancel();
        }
    }
}
