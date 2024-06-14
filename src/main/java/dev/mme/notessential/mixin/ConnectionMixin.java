package dev.mme.notessential.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Pseudo
@Mixin(targets = "gg.essential.network.connectionmanager.Connection", remap = false)
public class ConnectionMixin
{
    @Inject(method = {
            "send",
            "setupAndConnect"
    }, at = @At("HEAD"), cancellable = true, remap = false)
    private void notessential$overrideConnection(final CallbackInfo ci)
    {
        ci.cancel();
    }
}
