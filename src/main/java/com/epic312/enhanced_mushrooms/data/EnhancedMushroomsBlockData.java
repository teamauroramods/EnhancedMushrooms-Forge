package com.epic312.enhanced_mushrooms.data;

import com.epic312.enhanced_mushrooms.registry.EnhancedMushroomsBlocks;
import com.teamabnormals.abnormals_core.core.utils.DataUtils;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;

public class EnhancedMushroomsBlockData {
    public static void registerFlammables() {
        DataUtils.registerFlammable(EnhancedMushroomsBlocks.RED_MUSHROOM_STEM.get(), 5, 5);
        DataUtils.registerFlammable(EnhancedMushroomsBlocks.RED_MUSHROOM_HYPHAE.get(), 5, 5);
        DataUtils.registerFlammable(EnhancedMushroomsBlocks.STRIPPED_RED_MUSHROOM_STEM.get(), 5, 5);
        DataUtils.registerFlammable(EnhancedMushroomsBlocks.STRIPPED_RED_MUSHROOM_HYPHAE.get(), 5, 5);
        DataUtils.registerFlammable(EnhancedMushroomsBlocks.BROWN_MUSHROOM_STEM.get(), 5, 5);
        DataUtils.registerFlammable(EnhancedMushroomsBlocks.BROWN_MUSHROOM_HYPHAE.get(), 5, 5);
        DataUtils.registerFlammable(EnhancedMushroomsBlocks.STRIPPED_BROWN_MUSHROOM_STEM.get(), 5, 5);
        DataUtils.registerFlammable(EnhancedMushroomsBlocks.STRIPPED_BROWN_MUSHROOM_HYPHAE.get(), 5, 5);
    }

    public static void setupRenderLayer() {
        RenderTypeLookup.setRenderLayer(EnhancedMushroomsBlocks.BROWN_MUSHROOM_DOOR.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(EnhancedMushroomsBlocks.BROWN_MUSHROOM_TRAPDOOR.get(), RenderType.getCutoutMipped());
    }
}
