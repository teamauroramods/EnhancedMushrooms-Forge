package com.teamaurora.enhanced_mushrooms.client;

import com.teamaurora.enhanced_mushrooms.core.EnhancedMushrooms;
import com.teamaurora.enhanced_mushrooms.core.registry.EnhancedMushroomsBlocks;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

@Mod.EventBusSubscriber(value = Dist.CLIENT, modid = EnhancedMushrooms.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientRegister {

    @SubscribeEvent
    public static void registerClient(final FMLClientSetupEvent event) {
        setupRenderLayer();
    }

    private static void setupRenderLayer() {
        RenderTypeLookup.setRenderLayer(EnhancedMushroomsBlocks.RED_MUSHROOM_LADDER.get(), RenderType.getCutoutMipped());

        RenderTypeLookup.setRenderLayer(EnhancedMushroomsBlocks.BROWN_MUSHROOM_DOOR.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(EnhancedMushroomsBlocks.BROWN_MUSHROOM_TRAPDOOR.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(EnhancedMushroomsBlocks.BROWN_MUSHROOM_LADDER.get(), RenderType.getCutoutMipped());

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
        //RenderTypeLookup.setRenderLayer(EnhancedMushroomsBlocks.GLOWSHROOM_SIGNS.getFirst().get(), RenderType.getTranslucent());
        //RenderTypeLookup.setRenderLayer(EnhancedMushroomsBlocks.GLOWSHROOM_SIGNS.getSecond().get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(EnhancedMushroomsBlocks.VERTICAL_GLOWSHROOM_PLANKS.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(EnhancedMushroomsBlocks.GLOWSHROOM_VERTICAL_SLAB.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(EnhancedMushroomsBlocks.GLOWSHROOM_BOOKSHELF.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(EnhancedMushroomsBlocks.GLOWSHROOM_LADDER.get(), RenderType.getTranslucent());
        //RenderTypeLookup.setRenderLayer(EnhancedMushroomsBlocks.GLOWSHROOM_BEEHIVE.get(), RenderType.getTranslucent());
        // TODO: uncomment this shit when fixed
    }
}
