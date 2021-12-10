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
        RenderTypeLookup.setRenderLayer(EMBlocks.RED_MUSHROOM_LADDER.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(EMBlocks.RED_MUSHROOM_POST.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(EMBlocks.STRIPPED_RED_MUSHROOM_POST.get(), RenderType.getCutout());

        RenderTypeLookup.setRenderLayer(EMBlocks.BROWN_MUSHROOM_DOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(EMBlocks.BROWN_MUSHROOM_TRAPDOOR.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(EMBlocks.BROWN_MUSHROOM_LADDER.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(EMBlocks.BROWN_MUSHROOM_POST.get(), RenderType.getCutout());
        RenderTypeLookup.setRenderLayer(EMBlocks.STRIPPED_BROWN_MUSHROOM_POST.get(), RenderType.getCutout());
    }
}
