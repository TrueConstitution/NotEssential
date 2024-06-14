package dev.mme.notessential.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Pseudo
@Mixin(targets = "gg.essential.gui.common.MenuButton", remap = false)
public class MenuButtonMixin
{
    @Inject(method = {
            "<init>*" // No descriptor to match all constructors.
    }, at = @At(value = "INVOKE_ASSIGN", target = "Lgg/essential/elementa/UIComponent;<init>()V"), cancellable = true, remap = false)
    private void notessential$guiOptionsInit(final CallbackInfo ci)
    {
        ci.cancel();
    }
}
