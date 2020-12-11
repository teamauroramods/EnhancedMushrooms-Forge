package com.teamaurora.enhanced_mushrooms.core;

import com.minecraftabnormals.abnormals_core.core.util.registry.RegistryHelper;
import com.teamaurora.enhanced_mushrooms.core.other.EnhancedMushroomsEvents;
import com.teamaurora.enhanced_mushrooms.core.other.EnhancedMushroomsData;
import com.teamaurora.enhanced_mushrooms.core.registry.util.EnhancedMushroomsBlockSubRegistryHelper;
import com.teamaurora.enhanced_mushrooms.core.registry.util.EnhancedMushroomsItemSubRegistryHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;

import static com.teamaurora.enhanced_mushrooms.core.EnhancedMushrooms.MODID;

@Mod("enhanced_mushrooms")
@SuppressWarnings("deprecation")
public class EnhancedMushrooms
{
    public static final String MODID = "enhanced_mushrooms";
    public static final RegistryHelper REGISTRY_HELPER = RegistryHelper.create(MODID, helper -> {
        helper.putSubHelper(ForgeRegistries.BLOCKS, new EnhancedMushroomsBlockSubRegistryHelper(helper));
        helper.putSubHelper(ForgeRegistries.ITEMS, new EnhancedMushroomsItemSubRegistryHelper(helper));
    });

	public EnhancedMushrooms() {
        final IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        REGISTRY_HELPER.register(eventBus);

        eventBus.addListener(this::commonSetup);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, EnhancedMushroomsConfig.COMMON_SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        MinecraftForge.EVENT_BUS.register(new EnhancedMushroomsEvents());
        DeferredWorkQueue.runLater(() -> {
            EnhancedMushroomsData.registerFlammables();
            //EnhancedMushroomsFeatures.generateFeatures();
        });
    }
}
