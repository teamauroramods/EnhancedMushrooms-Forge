package com.teamaurora.enhanced_mushrooms.client;

import com.teamaurora.enhanced_mushrooms.core.EnhancedMushrooms;
import com.teamaurora.enhanced_mushrooms.core.registry.EMBlocks;
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
        RenderTypeLookup.setRenderLayer(EMBlocks.RED_MUSHROOM_LADDER.get(), RenderType.getCutoutMipped());

        RenderTypeLookup.setRenderLayer(EMBlocks.BROWN_MUSHROOM_DOOR.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(EMBlocks.BROWN_MUSHROOM_TRAPDOOR.get(), RenderType.getCutoutMipped());
        RenderTypeLookup.setRenderLayer(EMBlocks.BROWN_MUSHROOM_LADDER.get(), RenderType.getCutoutMipped());

        RenderTypeLookup.setRenderLayer(EMBlocks.STRIPPED_GLOWSHROOM_STEM.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(EMBlocks.GLOWSHROOM_STEM.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(EMBlocks.STRIPPED_GLOWSHROOM_HYPHAE.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(EMBlocks.GLOWSHROOM_HYPHAE.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(EMBlocks.GLOWSHROOM_PLANKS.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(EMBlocks.GLOWSHROOM_SLAB.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(EMBlocks.GLOWSHROOM_STAIRS.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(EMBlocks.GLOWSHROOM_PRESSURE_PLATE.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(EMBlocks.GLOWSHROOM_FENCE.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(EMBlocks.GLOWSHROOM_FENCE_GATE.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(EMBlocks.GLOWSHROOM_BUTTON.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(EMBlocks.GLOWSHROOM_TRAPDOOR.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(EMBlocks.GLOWSHROOM_DOOR.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(EMBlocks.GLOWSHROOM_SIGNS.getFirst().get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(EMBlocks.GLOWSHROOM_SIGNS.getSecond().get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(EMBlocks.VERTICAL_GLOWSHROOM_PLANKS.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(EMBlocks.GLOWSHROOM_VERTICAL_SLAB.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(EMBlocks.GLOWSHROOM_BOOKSHELF.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(EMBlocks.GLOWSHROOM_LADDER.get(), RenderType.getTranslucent());
        RenderTypeLookup.setRenderLayer(EMBlocks.GLOWSHROOM_BEEHIVE.get(), RenderType.getTranslucent());
    }
}
