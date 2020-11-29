package com.teamaurora.enhanced_mushrooms.core.compatibility;

import net.minecraft.block.Block;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ObjectHolder;

public class Quark {
    @ObjectHolder("quark:glowshroom_block")
    public static final Block GLOWSHROOM_BLOCK = null;

    public static boolean isInstalled()
    {
        return ModList.get() != null && ModList.get().getModContainerById("quark").isPresent();
    }
}
