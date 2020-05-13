package com.epic312.enhanced_mushrooms.data;

import com.epic312.enhanced_mushrooms.EnhancedMushrooms;
import com.epic312.enhanced_mushrooms.registry.EnhancedMushroomsBlocks;
import com.teamabnormals.abnormals_core.core.utils.DataUtils;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;

public class EnhancedMushroomsBlockData {
    public static void registerFlammables() {
        // Red Mushrooms
        DataUtils.registerFlammable(EnhancedMushroomsBlocks.RED_MUSHROOM_STEM.get(), 5, 5);
        DataUtils.registerFlammable(EnhancedMushroomsBlocks.RED_MUSHROOM_HYPHAE.get(), 5, 5);
        DataUtils.registerFlammable(EnhancedMushroomsBlocks.STRIPPED_RED_MUSHROOM_STEM.get(), 5, 5);
        DataUtils.registerFlammable(EnhancedMushroomsBlocks.STRIPPED_RED_MUSHROOM_HYPHAE.get(), 5, 5);
        DataUtils.registerFlammable(EnhancedMushroomsBlocks.RED_MUSHROOM_PLANKS.get(), 5, 20);
        DataUtils.registerFlammable(EnhancedMushroomsBlocks.RED_MUSHROOM_SLAB.get(), 5, 20);
        DataUtils.registerFlammable(EnhancedMushroomsBlocks.RED_MUSHROOM_STAIRS.get(), 5, 20);
        DataUtils.registerFlammable(EnhancedMushroomsBlocks.RED_MUSHROOM_FENCE.get(), 5, 20);
        DataUtils.registerFlammable(EnhancedMushroomsBlocks.RED_MUSHROOM_FENCE_GATE.get(), 5, 20);
        // Brown Mushrooms
        DataUtils.registerFlammable(EnhancedMushroomsBlocks.BROWN_MUSHROOM_STEM.get(), 5, 5);
        DataUtils.registerFlammable(EnhancedMushroomsBlocks.BROWN_MUSHROOM_HYPHAE.get(), 5, 5);
        DataUtils.registerFlammable(EnhancedMushroomsBlocks.STRIPPED_BROWN_MUSHROOM_STEM.get(), 5, 5);
        DataUtils.registerFlammable(EnhancedMushroomsBlocks.STRIPPED_BROWN_MUSHROOM_HYPHAE.get(), 5, 5);
        DataUtils.registerFlammable(EnhancedMushroomsBlocks.BROWN_MUSHROOM_PLANKS.get(), 5, 20);
        DataUtils.registerFlammable(EnhancedMushroomsBlocks.BROWN_MUSHROOM_SLAB.get(), 5, 20);
        DataUtils.registerFlammable(EnhancedMushroomsBlocks.BROWN_MUSHROOM_STAIRS.get(), 5, 20);
        DataUtils.registerFlammable(EnhancedMushroomsBlocks.BROWN_MUSHROOM_FENCE.get(), 5, 20);
        DataUtils.registerFlammable(EnhancedMushroomsBlocks.BROWN_MUSHROOM_FENCE_GATE.get(), 5, 20);
    }

    public static void setupRenderLayer() {
        RenderTypeLookup.setRenderLayer(EnhancedMushroomsBlocks.BROWN_MUSHROOM_DOOR.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(EnhancedMushroomsBlocks.BROWN_MUSHROOM_TRAPDOOR.get(), RenderType.getCutoutMipped());
    }
}
