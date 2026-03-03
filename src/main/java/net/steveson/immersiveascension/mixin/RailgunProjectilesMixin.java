package net.steveson.immersiveascension.mixin;

import blusunrize.immersiveengineering.api.IETags;
import blusunrize.immersiveengineering.api.tool.RailgunHandler;
import blusunrize.immersiveengineering.common.items.RailgunProjectiles;
import net.minecraftforge.common.Tags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(RailgunProjectiles.class)
public class RailgunProjectilesMixin {

    @Inject(method = "register", at = @At(value = "HEAD"))
    public static void register(CallbackInfo ci){

        // Stick
        RailgunHandler.registerStandardProjectile(Tags.Items.RODS_WOODEN, 16, 1.25).setColorMap(
                new RailgunHandler.RailgunRenderColors(0xd8d8d8, 0xd8d8d8, 0xd8d8d8, 0xa8a8a8, 0x686868, 0x686868)
        );




    }
}
