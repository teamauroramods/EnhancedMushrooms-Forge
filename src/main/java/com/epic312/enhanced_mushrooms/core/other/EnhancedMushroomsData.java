package com.epic312.enhanced_mushrooms.core.other;

import com.epic312.enhanced_mushrooms.core.registry.EnhancedMushroomsBlocks;
import com.teamabnormals.abnormals_core.core.utils.DataUtils;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;

public class EnhancedMushroomsData {
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
        // Glowshrooms
        DataUtils.registerFlammable(EnhancedMushroomsBlocks.GLOWSHROOM_STEM.get(), 5, 5);
        DataUtils.registerFlammable(EnhancedMushroomsBlocks.GLOWSHROOM_HYPHAE.get(), 5, 5);
        DataUtils.registerFlammable(EnhancedMushroomsBlocks.STRIPPED_GLOWSHROOM_STEM.get(), 5, 5);
        DataUtils.registerFlammable(EnhancedMushroomsBlocks.STRIPPED_GLOWSHROOM_HYPHAE.get(), 5, 5);
        DataUtils.registerFlammable(EnhancedMushroomsBlocks.GLOWSHROOM_PLANKS.get(), 5, 20);
        DataUtils.registerFlammable(EnhancedMushroomsBlocks.GLOWSHROOM_SLAB.get(), 5, 20);
        DataUtils.registerFlammable(EnhancedMushroomsBlocks.GLOWSHROOM_STAIRS.get(), 5, 20);
        DataUtils.registerFlammable(EnhancedMushroomsBlocks.GLOWSHROOM_FENCE.get(), 5, 20);
        DataUtils.registerFlammable(EnhancedMushroomsBlocks.GLOWSHROOM_FENCE_GATE.get(), 5, 20);
        // Quark Compat
        DataUtils.registerFlammable(EnhancedMushroomsBlocks.RED_MUSHROOM_BOOKSHELF.get(), 5, 5);
        DataUtils.registerFlammable(EnhancedMushroomsBlocks.RED_MUSHROOM_VERTICAL_SLAB.get(), 5, 5);
        DataUtils.registerFlammable(EnhancedMushroomsBlocks.VERTICAL_RED_MUSHROOM_PLANKS.get(), 5, 5);

        DataUtils.registerFlammable(EnhancedMushroomsBlocks.BROWN_MUSHROOM_BOOKSHELF.get(), 5, 5);
        DataUtils.registerFlammable(EnhancedMushroomsBlocks.BROWN_MUSHROOM_VERTICAL_SLAB.get(), 5, 5);
        DataUtils.registerFlammable(EnhancedMushroomsBlocks.VERTICAL_BROWN_MUSHROOM_PLANKS.get(), 5, 5);

        DataUtils.registerFlammable(EnhancedMushroomsBlocks.GLOWSHROOM_BOOKSHELF.get(), 5, 5);
        DataUtils.registerFlammable(EnhancedMushroomsBlocks.GLOWSHROOM_VERTICAL_SLAB.get(), 5, 5);
        DataUtils.registerFlammable(EnhancedMushroomsBlocks.VERTICAL_GLOWSHROOM_PLANKS.get(), 5, 5);

    }

    public static void setupRenderLayer() {
        RenderTypeLookup.setRenderLayer(EnhancedMushroomsBlocks.RED_MUSHROOM_LADDER.get(), RenderType.getCutoutMipped());

        RenderTypeLookup.setRenderLayer(EnhancedMushroomsBlocks.BROWN_MUSHROOM_DOOR.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(EnhancedMushroomsBlocks.BROWN_MUSHROOM_TRAPDOOR.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(EnhancedMushroomsBlocks.BROWN_MUSHROOM_LADDER.get(), RenderType.getCutoutMipped());

        RenderTypeLookup.setRenderLayer(EnhancedMushroomsBlocks.GLOWSHROOM_CAP.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(EnhancedMushroomsBlocks.STRIPPED_GLOWSHROOM_STEM.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(EnhancedMushroomsBlocks.GLOWSHROOM_STEM.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(EnhancedMushroomsBlocks.STRIPPED_GLOWSHROOM_HYPHAE.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(EnhancedMushroomsBlocks.GLOWSHROOM_HYPHAE.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(EnhancedMushroomsBlocks.GLOWSHROOM_PLANKS.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(EnhancedMushroomsBlocks.GLOWSHROOM_SLAB.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(EnhancedMushroomsBlocks.GLOWSHROOM_STAIRS.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(EnhancedMushroomsBlocks.GLOWSHROOM_PRESSURE_PLATE.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(EnhancedMushroomsBlocks.GLOWSHROOM_FENCE.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(EnhancedMushroomsBlocks.GLOWSHROOM_FENCE_GATE.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(EnhancedMushroomsBlocks.GLOWSHROOM_BUTTON.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(EnhancedMushroomsBlocks.GLOWSHROOM_TRAPDOOR.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(EnhancedMushroomsBlocks.GLOWSHROOM_DOOR.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(EnhancedMushroomsBlocks.GLOWSHROOM_SIGNS.getFirst().get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(EnhancedMushroomsBlocks.GLOWSHROOM_SIGNS.getSecond().get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(EnhancedMushroomsBlocks.VERTICAL_GLOWSHROOM_PLANKS.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(EnhancedMushroomsBlocks.GLOWSHROOM_VERTICAL_SLAB.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(EnhancedMushroomsBlocks.GLOWSHROOM_BOOKSHELF.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(EnhancedMushroomsBlocks.GLOWSHROOM_LADDER.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(EnhancedMushroomsBlocks.GLOWSHROOM_BEEHIVE.get(), RenderType.getTranslucent());
    }
}
