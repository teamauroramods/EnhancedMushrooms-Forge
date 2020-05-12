package com.epic312.enhanced_mushrooms;

import com.epic312.enhanced_mushrooms.data.EnhancedMushroomsBlockData;
import com.epic312.enhanced_mushrooms.registry.EnhancedMushroomsBlocks;
import com.epic312.enhanced_mushrooms.registry.EnhancedMushroomsItems;
import com.epic312.enhanced_mushrooms.setup.ClientProxy;
import com.epic312.enhanced_mushrooms.setup.IProxy;
import com.epic312.enhanced_mushrooms.setup.ModSetup;
import com.epic312.enhanced_mushrooms.setup.ServerProxy;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("enhanced_mushrooms")
@Mod.EventBusSubscriber(modid = "enhanced_mushrooms", bus = Mod.EventBusSubscriber.Bus.MOD)
public class EnhancedMushrooms
{
    public static final String MODID = "enhanced_mushrooms";

    public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());

    public static ModSetup setup = new ModSetup();

    private static final Logger LOGGER = LogManager.getLogger();

    public EnhancedMushrooms() {
        // Register the setup method for modloading
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        EnhancedMushroomsBlocks.BLOCKS.register(eventBus);
        EnhancedMushroomsItems.ITEMS.register(eventBus);

        MinecraftForge.EVENT_BUS.register(this);

        eventBus.addListener(this::setup);
    }

    private void setup(final FMLCommonSetupEvent event) {
        setup.init();
        proxy.init();
        EnhancedMushroomsBlockData.registerStrippables();
        EnhancedMushroomsBlockData.registerFlammables();
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
