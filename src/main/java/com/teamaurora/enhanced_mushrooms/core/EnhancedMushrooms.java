package com.teamaurora.enhanced_mushrooms.core;

import com.minecraftabnormals.abnormals_core.core.util.registry.RegistryHelper;
import com.teamaurora.enhanced_mushrooms.core.library.api.conditions.EMFoodRecipeCondition;
import com.teamaurora.enhanced_mushrooms.core.other.EMEvents;
import com.teamaurora.enhanced_mushrooms.core.other.EMData;
import com.teamaurora.enhanced_mushrooms.core.registry.util.EMBlockSubRegistryHelper;
import com.teamaurora.enhanced_mushrooms.core.registry.util.EMItemSubRegistryHelper;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.*;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;

@Mod("enhanced_mushrooms")
@SuppressWarnings("deprecation")
public class EnhancedMushrooms
{
    public static final String MODID = "enhanced_mushrooms";
    public static final RegistryHelper REGISTRY_HELPER = RegistryHelper.create(MODID, helper -> {
        helper.putSubHelper(ForgeRegistries.ITEMS, new EMItemSubRegistryHelper(helper));
        helper.putSubHelper(ForgeRegistries.BLOCKS, new EMBlockSubRegistryHelper(helper));
    });

	public EnhancedMushrooms() {
        final IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        CraftingHelper.register(new EMFoodRecipeCondition.Serializer());

        REGISTRY_HELPER.register(eventBus);

        eventBus.addListener(EventPriority.LOWEST, this::commonSetup);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, EMConfig.COMMON_SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        MinecraftForge.EVENT_BUS.register(new EMEvents());
        event.enqueueWork(() -> {
            EMData.registerFlammables();
            //EnMushroomsBiomeFeatures.applyBiomeModifiers();
            //EnhancedMushroomsFeatures.generateFeatures();
        });
    }
}
