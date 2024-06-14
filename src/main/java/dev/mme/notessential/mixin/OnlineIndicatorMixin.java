package dev.mme.notessential.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Pseudo
@Mixin(targets = "gg.essential.handlers.OnlineIndicator", remap = false)
public class OnlineIndicatorMixin
{
    @Inject(method = {
        "drawNametagIndicator",
            "drawTabIndicator"
    }, at = @At("HEAD"), cancellable = true, remap = false)
    private static void notessential$overrideOnlineIndicator(final CallbackInfo ci)
    {
        ci.cancel();
    }
}
