package dev.mme.notessential.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Pseudo
@Mixin(targets = "gg.essential.data.OnboardingData", remap = false)
public class OnboardingDataMixin
{
    @Inject(method = {
        "hasAcceptedTos()Z"
    }, at = @At("HEAD"), cancellable = true, remap = false)
    private static void notessential$hasAcceptedTos(final CallbackInfoReturnable<Boolean> clr)
    {
        clr.setReturnValue(false);
    }
    @Inject(method = {
        "hasDeniedTos()Z"
    }, at = @At("HEAD"), cancellable = true, remap = false)
    private static void notessential$hasDeniedTos(final CallbackInfoReturnable<Boolean> clr)
    {
        clr.setReturnValue(true);
    }
}
