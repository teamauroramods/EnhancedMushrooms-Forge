package com.teamaurora.enhanced_mushrooms.core.registry;

import com.google.common.collect.ImmutableSet;
import com.minecraftabnormals.abnormals_core.common.world.modification.BiomeFeatureModifier;
import com.teamaurora.enhanced_mushrooms.common.world.biome.EnMushroomsBiomeFeatures;

import com.teamaurora.enhanced_mushrooms.core.EnhancedMushrooms;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.BigMushroomFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.Features;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Set;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = EnhancedMushrooms.MODID)
public class EnhancedMushroomsFeatures {

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
