package com.axalotl.async.mixin.utils;

import net.minecraft.util.thread.LockHelper;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;

import java.util.concurrent.Semaphore;

@Mixin(LockHelper.class)
public abstract class LockHelperMixin {

    @Shadow
    @Final
    @Mutable
    private Semaphore semaphore = new Semaphore(255);
}
