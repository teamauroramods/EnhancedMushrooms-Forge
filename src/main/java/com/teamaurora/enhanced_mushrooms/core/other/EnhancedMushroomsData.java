package com.teamaurora.enhanced_mushrooms.core.other;

import com.teamaurora.enhanced_mushrooms.core.registry.EnhancedMushroomsBlocks;
import com.minecraftabnormals.abnormals_core.core.util.DataUtil;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;

public class EnhancedMushroomsData {
    public static void registerFlammables() {
        // Red Mushrooms
        DataUtil.registerFlammable(EnhancedMushroomsBlocks.RED_MUSHROOM_STEM.get(), 5, 5);
        DataUtil.registerFlammable(EnhancedMushroomsBlocks.RED_MUSHROOM_HYPHAE.get(), 5, 5);
        DataUtil.registerFlammable(EnhancedMushroomsBlocks.STRIPPED_RED_MUSHROOM_STEM.get(), 5, 5);
        DataUtil.registerFlammable(EnhancedMushroomsBlocks.STRIPPED_RED_MUSHROOM_HYPHAE.get(), 5, 5);
        DataUtil.registerFlammable(EnhancedMushroomsBlocks.RED_MUSHROOM_PLANKS.get(), 5, 20);
        DataUtil.registerFlammable(EnhancedMushroomsBlocks.RED_MUSHROOM_SLAB.get(), 5, 20);
        DataUtil.registerFlammable(EnhancedMushroomsBlocks.RED_MUSHROOM_STAIRS.get(), 5, 20);
        DataUtil.registerFlammable(EnhancedMushroomsBlocks.RED_MUSHROOM_FENCE.get(), 5, 20);
        DataUtil.registerFlammable(EnhancedMushroomsBlocks.RED_MUSHROOM_FENCE_GATE.get(), 5, 20);
        // Brown Mushrooms
        DataUtil.registerFlammable(EnhancedMushroomsBlocks.BROWN_MUSHROOM_STEM.get(), 5, 5);
        DataUtil.registerFlammable(EnhancedMushroomsBlocks.BROWN_MUSHROOM_HYPHAE.get(), 5, 5);
        DataUtil.registerFlammable(EnhancedMushroomsBlocks.STRIPPED_BROWN_MUSHROOM_STEM.get(), 5, 5);
        DataUtil.registerFlammable(EnhancedMushroomsBlocks.STRIPPED_BROWN_MUSHROOM_HYPHAE.get(), 5, 5);
        DataUtil.registerFlammable(EnhancedMushroomsBlocks.BROWN_MUSHROOM_PLANKS.get(), 5, 20);
        DataUtil.registerFlammable(EnhancedMushroomsBlocks.BROWN_MUSHROOM_SLAB.get(), 5, 20);
        DataUtil.registerFlammable(EnhancedMushroomsBlocks.BROWN_MUSHROOM_STAIRS.get(), 5, 20);
        DataUtil.registerFlammable(EnhancedMushroomsBlocks.BROWN_MUSHROOM_FENCE.get(), 5, 20);
        DataUtil.registerFlammable(EnhancedMushroomsBlocks.BROWN_MUSHROOM_FENCE_GATE.get(), 5, 20);
        // Glowshrooms
        DataUtil.registerFlammable(EnhancedMushroomsBlocks.GLOWSHROOM_STEM.get(), 5, 5);
        DataUtil.registerFlammable(EnhancedMushroomsBlocks.GLOWSHROOM_HYPHAE.get(), 5, 5);
        DataUtil.registerFlammable(EnhancedMushroomsBlocks.STRIPPED_GLOWSHROOM_STEM.get(), 5, 5);
        DataUtil.registerFlammable(EnhancedMushroomsBlocks.STRIPPED_GLOWSHROOM_HYPHAE.get(), 5, 5);
        DataUtil.registerFlammable(EnhancedMushroomsBlocks.GLOWSHROOM_PLANKS.get(), 5, 20);
        DataUtil.registerFlammable(EnhancedMushroomsBlocks.GLOWSHROOM_SLAB.get(), 5, 20);
        DataUtil.registerFlammable(EnhancedMushroomsBlocks.GLOWSHROOM_STAIRS.get(), 5, 20);
        DataUtil.registerFlammable(EnhancedMushroomsBlocks.GLOWSHROOM_FENCE.get(), 5, 20);
        DataUtil.registerFlammable(EnhancedMushroomsBlocks.GLOWSHROOM_FENCE_GATE.get(), 5, 20);
        // Quark Compat
        DataUtil.registerFlammable(EnhancedMushroomsBlocks.RED_MUSHROOM_BOOKSHELF.get(), 5, 5);
        DataUtil.registerFlammable(EnhancedMushroomsBlocks.RED_MUSHROOM_VERTICAL_SLAB.get(), 5, 5);
        DataUtil.registerFlammable(EnhancedMushroomsBlocks.VERTICAL_RED_MUSHROOM_PLANKS.get(), 5, 5);

        DataUtil.registerFlammable(EnhancedMushroomsBlocks.BROWN_MUSHROOM_BOOKSHELF.get(), 5, 5);
        DataUtil.registerFlammable(EnhancedMushroomsBlocks.BROWN_MUSHROOM_VERTICAL_SLAB.get(), 5, 5);
        DataUtil.registerFlammable(EnhancedMushroomsBlocks.VERTICAL_BROWN_MUSHROOM_PLANKS.get(), 5, 5);

        DataUtil.registerFlammable(EnhancedMushroomsBlocks.GLOWSHROOM_BOOKSHELF.get(), 5, 5);
        DataUtil.registerFlammable(EnhancedMushroomsBlocks.GLOWSHROOM_VERTICAL_SLAB.get(), 5, 5);
        DataUtil.registerFlammable(EnhancedMushroomsBlocks.VERTICAL_GLOWSHROOM_PLANKS.get(), 5, 5);

    }
}
