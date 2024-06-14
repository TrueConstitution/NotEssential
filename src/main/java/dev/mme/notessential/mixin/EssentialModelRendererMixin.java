package dev.mme.notessential.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Pseudo
@Mixin(targets = "gg.essential.cosmetics.EssentialModelRenderer", remap = false)
public class EssentialModelRendererMixin
{
    @Inject(method = "cosmeticsShouldRender", at = @At("TAIL"), cancellable = true, remap = false)
    private static void notessential$cosmeticsShouldRender(final CallbackInfoReturnable<Boolean> clr)
    {
        clr.setReturnValue(false);
    }
}
