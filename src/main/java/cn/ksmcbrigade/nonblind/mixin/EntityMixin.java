package cn.ksmcbrigade.nonblind.mixin;

import cn.ksmcbrigade.vmr.uitls.ModuleUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public abstract class EntityMixin {

    @Shadow public abstract EntityType<?> getType();

    @Shadow public abstract void setGlowingTag(boolean p_146916_);

    @Shadow protected abstract void setSharedFlag(int p_20116_, boolean p_20117_);

    @Shadow public abstract int getId();

    @Inject(method = "isCurrentlyGlowing",at = @At("RETURN"), cancellable = true)
    public void esp(CallbackInfoReturnable<Boolean> cir){
        boolean change = false;
        if(Minecraft.getInstance().player==null){
            if(!cir.getReturnValue()){
                setSharedFlag(6,false);
            }
            return;
        }
        if(this.getId() != Minecraft.getInstance().player.getId() && ModuleUtils.enabled("hack.name.esp_ey")){
            change = true;
        }

        if(change)
            cir.setReturnValue(true);
        else if (!cir.getReturnValue()) {
            setSharedFlag(6,false);
        }
    }
}
