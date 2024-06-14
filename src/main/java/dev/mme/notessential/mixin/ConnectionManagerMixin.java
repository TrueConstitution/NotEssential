package dev.mme.notessential.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Pseudo
@SuppressWarnings("UnresolvedMixinReference")
@Mixin(targets = "gg.essential.network.connectionmanager.ConnectionManager", remap = false)
public abstract class ConnectionManagerMixin
{
    @Inject(method = {
            "start",
            "close",
        "respond(Lgg/essential/connectionmanager/common/packet/Packet;Lgg/essential/connectionmanager/common/packet/Packet;)V",
            "send*",
    }, at = @At("HEAD"), cancellable = true, remap = false)
    private void notessential$overrideConnectionManager(final CallbackInfo ci)
    {
        ci.cancel();
    }
    @Inject(method = {
        "isOpen()Z",
        "isAuthenticated()Z",
    }, at = @At("HEAD"), cancellable = true, remap = false)
    private void notessential$overrideConnectionManager(final CallbackInfoReturnable<Boolean> clr)
    {
        clr.setReturnValue(false);
    }
}
