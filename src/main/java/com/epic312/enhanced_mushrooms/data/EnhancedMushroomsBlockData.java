package com.epic312.enhanced_mushrooms.data;

import com.epic312.enhanced_mushrooms.registry.EnhancedMushroomsBlocks;
import com.epic312.enhanced_mushrooms.util.DataUtils;

public class EnhancedMushroomsBlockData {
    public static void registerStrippables() {
        DataUtils.makeStrippable(EnhancedMushroomsBlocks.RED_MUSHROOM_STEM.get(), EnhancedMushroomsBlocks.STRIPPED_RED_MUSHROOM_STEM.get());
        DataUtils.makeStrippable(EnhancedMushroomsBlocks.RED_MUSHROOM_HYPHAE.get(), EnhancedMushroomsBlocks.STRIPPED_RED_MUSHROOM_HYPHAE.get());
        DataUtils.makeStrippable(EnhancedMushroomsBlocks.BROWN_MUSHROOM_STEM.get(), EnhancedMushroomsBlocks.STRIPPED_BROWN_MUSHROOM_STEM.get());
        DataUtils.makeStrippable(EnhancedMushroomsBlocks.BROWN_MUSHROOM_HYPHAE.get(), EnhancedMushroomsBlocks.STRIPPED_BROWN_MUSHROOM_HYPHAE.get());
    }
    public static void registerFlammables() {
        DataUtils.makeFlammable(EnhancedMushroomsBlocks.RED_MUSHROOM_STEM.get(), 5, 5);
        DataUtils.makeFlammable(EnhancedMushroomsBlocks.RED_MUSHROOM_HYPHAE.get(), 5, 5);
        DataUtils.makeFlammable(EnhancedMushroomsBlocks.STRIPPED_RED_MUSHROOM_STEM.get(), 5, 5);
        DataUtils.makeFlammable(EnhancedMushroomsBlocks.STRIPPED_RED_MUSHROOM_HYPHAE.get(), 5, 5);
        DataUtils.makeFlammable(EnhancedMushroomsBlocks.BROWN_MUSHROOM_STEM.get(), 5, 5);
        DataUtils.makeFlammable(EnhancedMushroomsBlocks.BROWN_MUSHROOM_HYPHAE.get(), 5, 5);
        DataUtils.makeFlammable(EnhancedMushroomsBlocks.STRIPPED_BROWN_MUSHROOM_STEM.get(), 5, 5);
        DataUtils.makeFlammable(EnhancedMushroomsBlocks.STRIPPED_BROWN_MUSHROOM_HYPHAE.get(), 5, 5);
    }
}
