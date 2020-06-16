package com.epic312.enhanced_mushrooms.core;

import com.epic312.enhanced_mushrooms.core.data.EnhancedMushroomsBlockData;
import com.epic312.enhanced_mushrooms.common.event.BonemealEventHandler;
import com.epic312.enhanced_mushrooms.core.registry.EnhancedMushroomsFeatures;
import com.epic312.enhanced_mushrooms.core.registry.util.EMRegistryHelper;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DeferredWorkQueue;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static com.epic312.enhanced_mushrooms.core.EnhancedMushrooms.MODID;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(MODID)
@Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EnhancedMushrooms
{
    public static final String MODID = "enhanced_mushrooms";
    public static final EMRegistryHelper REGISTRY_HELPER = new EMRegistryHelper(MODID);

    private static final Logger LOGGER = LogManager.getLogger();

    public EnhancedMushrooms() {
        // Register the setup method for modloading
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        REGISTRY_HELPER.getDeferredItemRegister().register(eventBus);
        REGISTRY_HELPER.getDeferredBlockRegister().register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);

        eventBus.addListener(this::commonSetup);
        DistExecutor.runWhenOn(Dist.CLIENT, () -> () -> {
            eventBus.addListener(this::clientSetup);
        });
    }

    @SuppressWarnings("deprecation")
    private void commonSetup(final FMLCommonSetupEvent event) {
        MinecraftForge.EVENT_BUS.register(new BonemealEventHandler());
        DeferredWorkQueue.runLater(() -> {
            EnhancedMushroomsBlockData.registerFlammables();
            EnhancedMushroomsFeatures.generateFeatures();
        });
    }

    @SuppressWarnings("deprecation")
    private void clientSetup(final FMLClientSetupEvent event) {
        DeferredWorkQueue.runLater(EnhancedMushroomsBlockData::setupRenderLayer);
    }

    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {

        }

        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {

        }
    }
}
