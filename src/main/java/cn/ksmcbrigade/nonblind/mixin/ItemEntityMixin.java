package cn.ksmcbrigade.nonblind.mixin;

import cn.ksmcbrigade.vmr.uitls.ModuleUtils;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(ItemEntity.class)
public abstract class ItemEntityMixin extends Entity {

    public ItemEntityMixin(EntityType<?> p_19870_, Level p_19871_) {
        super(p_19870_, p_19871_);
    }

    @Unique
    public boolean isCurrentlyGlowing() {
        if(ModuleUtils.enabled("hack.name.esp_ip")){
            return true;
        }
        if((this.level().isClientSide() ? this.getSharedFlag(6) : this.hasGlowingTag()) || super.isCurrentlyGlowing()){
            return true;
        } else {
            setSharedFlag(6,false);
            return false;
        }
    }
}
