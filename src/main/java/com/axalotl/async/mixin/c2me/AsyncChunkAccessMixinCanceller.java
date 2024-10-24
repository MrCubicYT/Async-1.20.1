package com.axalotl.async.mixin.c2me;

import com.bawnorton.mixinsquared.api.MixinCanceller;
import net.fabricmc.loader.api.FabricLoader;

import java.util.List;

public class AsyncChunkAccessMixinCanceller implements MixinCanceller {
    @Override
    public boolean shouldCancel(List<String> targetClassNames, String mixinClassName) {
        if (FabricLoader.getInstance().isModLoaded("c2me")) {
            return mixinClassName.equals("com.ishland.c2me.opts.chunk_access.mixin.async_chunk_request.MixinServerChunkManager");
        } else return false;
    }
}

