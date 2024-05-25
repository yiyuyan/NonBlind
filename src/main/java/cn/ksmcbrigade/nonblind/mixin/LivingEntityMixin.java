package cn.ksmcbrigade.nonblind.mixin;

import cn.ksmcbrigade.vmr.uitls.ModuleUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Attackable;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.vehicle.Minecart;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin extends Entity implements Attackable, net.minecraftforge.common.extensions.IForgeLivingEntity {
    public LivingEntityMixin(EntityType<?> p_19870_, Level p_19871_) {
        super(p_19870_, p_19871_);
    }

    @Inject(method = "hasEffect",at = @At("RETURN"), cancellable = true)
    public void has(MobEffect p_21024_, CallbackInfoReturnable<Boolean> cir){
        if(p_21024_.equals(MobEffects.BLINDNESS) && ModuleUtils.enabled("hack.name.anti_bl")){
            cir.setReturnValue(false);
        }
    }

    @Inject(method = "isCurrentlyGlowing",at = @At("RETURN"), cancellable = true)
    public void esp(CallbackInfoReturnable<Boolean> cir){
        boolean change = false;
        if(Minecraft.getInstance().player==null){
            if(!cir.getReturnValue()){
                setSharedFlag(6,false);
            }
            return;
        }
        if (this.getId() != Minecraft.getInstance().player.getId() && ModuleUtils.enabled("hack.name.esp_ly")) {
            change = true;
        }

        if(change)
            cir.setReturnValue(true);
        else if (!cir.getReturnValue()) {
            setSharedFlag(6,false);
        }
    }
}
