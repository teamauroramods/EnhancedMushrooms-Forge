package com.epic312.enhanced_mushrooms.core;

import com.epic312.enhanced_mushrooms.core.data.EnhancedMushroomsBlockData;
import com.epic312.enhanced_mushrooms.common.event.BonemealEventHandler;
import com.epic312.enhanced_mushrooms.core.registry.EnhancedMushroomsFeatures;
import com.epic312.enhanced_mushrooms.core.registry.util.EMRegistryHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import static com.epic312.enhanced_mushrooms.core.EnhancedMushrooms.MODID;

@Mod(MODID)
@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
@SuppressWarnings("deprecation")
public class EnhancedMushrooms
{
    public static final String MODID = "enhanced_mushrooms";
    public static final EMRegistryHelper REGISTRY_HELPER = new EMRegistryHelper(MODID);

	public EnhancedMushrooms() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        
        REGISTRY_HELPER.getDeferredItemRegister().register(eventBus);
        REGISTRY_HELPER.getDeferredBlockRegister().register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);

        eventBus.addListener(this::commonSetup);
        DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> {
            eventBus.addListener(this::clientSetup);
        });
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        MinecraftForge.EVENT_BUS.register(new BonemealEventHandler());
        DeferredWorkQueue.runLater(() -> {
            EnhancedMushroomsBlockData.registerFlammables();
            EnhancedMushroomsFeatures.generateFeatures();
        });
    }

    private void clientSetup(final FMLClientSetupEvent event) {
        DeferredWorkQueue.runLater(EnhancedMushroomsBlockData::setupRenderLayer);
    }
}
