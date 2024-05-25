package cn.ksmcbrigade.nonblind.mixin;

import cn.ksmcbrigade.vmr.uitls.ModuleUtils;
import net.minecraft.client.Camera;
import net.minecraft.client.renderer.LevelRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LevelRenderer.class)
public abstract class LevelRenderMixin {

    @Inject(method = "doesMobEffectBlockSky",at = @At("RETURN"),cancellable = true)
    public void anti_bl(Camera p_234311_, CallbackInfoReturnable<Boolean> cir){
        if(ModuleUtils.enabled("hack.name.anti_bl")){
            cir.setReturnValue(false);
        }
    }
}
