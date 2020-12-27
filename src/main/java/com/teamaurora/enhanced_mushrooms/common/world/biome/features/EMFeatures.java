package com.teamaurora.enhanced_mushrooms.common.world.biome.features;

import com.teamaurora.enhanced_mushrooms.core.EnhancedMushrooms;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EnhancedMushrooms.MODID)
public class EMFeatures {

    /*public static void generateFeatures() {
        ForgeRegistries.BIOMES.getValues().forEach(EnhancedMushroomsFeatures::generate);
    }

    public static void generate(Biome biome) {
        //EnMushroomsBiomeFeatures.removeVanillaMushrooms(biome);
    }*/

    public static boolean isBiomeName(ResourceLocation biomeName, RegistryKey<Biome>... biomes) {
        for (RegistryKey<Biome> biome : biomes) {
            if (biome.getLocation().equals(biomeName)) return true;
        }
        return false;
    }

    @SubscribeEvent
    public static void addFeatures(BiomeLoadingEvent event) {
        ResourceLocation biomeName = event.getName();
    }
}
