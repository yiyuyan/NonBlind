package cn.ksmcbrigade.nonblind.mixin;

import cn.ksmcbrigade.vmr.uitls.ModuleUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(Player.class)
public abstract class PlayerMixin extends LivingEntity {
    protected PlayerMixin(EntityType<? extends LivingEntity> p_20966_, Level p_20967_) {
        super(p_20966_, p_20967_);
    }

    @Unique
    public boolean isCurrentlyGlowing() {
        if(Minecraft.getInstance().player==null){
            return super.isCurrentlyGlowing();
        }
        if(this.getId() != Minecraft.getInstance().player.getId() && ModuleUtils.enabled("hack.name.esp_py")){
            return true;
        }
        if((!this.level().isClientSide() && this.hasEffect(MobEffects.GLOWING) || super.isCurrentlyGlowing()) || super.isCurrentlyGlowing()){
            return true;
        } else {
            setSharedFlag(6,false);
            return false;
        }
    }
}
