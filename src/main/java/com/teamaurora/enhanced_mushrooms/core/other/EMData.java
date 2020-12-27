package com.teamaurora.enhanced_mushrooms.core.other;

import com.teamaurora.enhanced_mushrooms.core.registry.EMBlocks;
import com.minecraftabnormals.abnormals_core.core.util.DataUtil;

public class EMData {
    public static void registerFlammables() {
        // Red Mushrooms
        DataUtil.registerFlammable(EMBlocks.RED_MUSHROOM_STEM.get(), 5, 5);
        DataUtil.registerFlammable(EMBlocks.RED_MUSHROOM_HYPHAE.get(), 5, 5);
        DataUtil.registerFlammable(EMBlocks.STRIPPED_RED_MUSHROOM_STEM.get(), 5, 5);
        DataUtil.registerFlammable(EMBlocks.STRIPPED_RED_MUSHROOM_HYPHAE.get(), 5, 5);
        DataUtil.registerFlammable(EMBlocks.RED_MUSHROOM_PLANKS.get(), 5, 20);
        DataUtil.registerFlammable(EMBlocks.RED_MUSHROOM_SLAB.get(), 5, 20);
        DataUtil.registerFlammable(EMBlocks.RED_MUSHROOM_STAIRS.get(), 5, 20);
        DataUtil.registerFlammable(EMBlocks.RED_MUSHROOM_FENCE.get(), 5, 20);
        DataUtil.registerFlammable(EMBlocks.RED_MUSHROOM_FENCE_GATE.get(), 5, 20);
        // Brown Mushrooms
        DataUtil.registerFlammable(EMBlocks.BROWN_MUSHROOM_STEM.get(), 5, 5);
        DataUtil.registerFlammable(EMBlocks.BROWN_MUSHROOM_HYPHAE.get(), 5, 5);
        DataUtil.registerFlammable(EMBlocks.STRIPPED_BROWN_MUSHROOM_STEM.get(), 5, 5);
        DataUtil.registerFlammable(EMBlocks.STRIPPED_BROWN_MUSHROOM_HYPHAE.get(), 5, 5);
        DataUtil.registerFlammable(EMBlocks.BROWN_MUSHROOM_PLANKS.get(), 5, 20);
        DataUtil.registerFlammable(EMBlocks.BROWN_MUSHROOM_SLAB.get(), 5, 20);
        DataUtil.registerFlammable(EMBlocks.BROWN_MUSHROOM_STAIRS.get(), 5, 20);
        DataUtil.registerFlammable(EMBlocks.BROWN_MUSHROOM_FENCE.get(), 5, 20);
        DataUtil.registerFlammable(EMBlocks.BROWN_MUSHROOM_FENCE_GATE.get(), 5, 20);
        // Glowshrooms
        DataUtil.registerFlammable(EMBlocks.GLOWSHROOM_STEM.get(), 5, 5);
        DataUtil.registerFlammable(EMBlocks.GLOWSHROOM_HYPHAE.get(), 5, 5);
        DataUtil.registerFlammable(EMBlocks.STRIPPED_GLOWSHROOM_STEM.get(), 5, 5);
        DataUtil.registerFlammable(EMBlocks.STRIPPED_GLOWSHROOM_HYPHAE.get(), 5, 5);
        DataUtil.registerFlammable(EMBlocks.GLOWSHROOM_PLANKS.get(), 5, 20);
        DataUtil.registerFlammable(EMBlocks.GLOWSHROOM_SLAB.get(), 5, 20);
        DataUtil.registerFlammable(EMBlocks.GLOWSHROOM_STAIRS.get(), 5, 20);
        DataUtil.registerFlammable(EMBlocks.GLOWSHROOM_FENCE.get(), 5, 20);
        DataUtil.registerFlammable(EMBlocks.GLOWSHROOM_FENCE_GATE.get(), 5, 20);
        // Quark Compat
        DataUtil.registerFlammable(EMBlocks.RED_MUSHROOM_BOOKSHELF.get(), 5, 5);
        DataUtil.registerFlammable(EMBlocks.RED_MUSHROOM_VERTICAL_SLAB.get(), 5, 5);
        DataUtil.registerFlammable(EMBlocks.VERTICAL_RED_MUSHROOM_PLANKS.get(), 5, 5);

        DataUtil.registerFlammable(EMBlocks.BROWN_MUSHROOM_BOOKSHELF.get(), 5, 5);
        DataUtil.registerFlammable(EMBlocks.BROWN_MUSHROOM_VERTICAL_SLAB.get(), 5, 5);
        DataUtil.registerFlammable(EMBlocks.VERTICAL_BROWN_MUSHROOM_PLANKS.get(), 5, 5);

        DataUtil.registerFlammable(EMBlocks.GLOWSHROOM_BOOKSHELF.get(), 5, 5);
        DataUtil.registerFlammable(EMBlocks.GLOWSHROOM_VERTICAL_SLAB.get(), 5, 5);
        DataUtil.registerFlammable(EMBlocks.VERTICAL_GLOWSHROOM_PLANKS.get(), 5, 5);

    }
}
