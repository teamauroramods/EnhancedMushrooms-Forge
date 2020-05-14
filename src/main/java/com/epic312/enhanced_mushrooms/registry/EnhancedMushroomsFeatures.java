package com.epic312.enhanced_mushrooms.registry;

import com.epic312.enhanced_mushrooms.world.biome.EnMushroomsBiomeFeatures;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;

public class EnhancedMushroomsFeatures {

    public static void generateFeatures() {
        ForgeRegistries.BIOMES.getValues().forEach(EnhancedMushroomsFeatures::generate);
    }

    public static void generate(Biome biome) {
        EnMushroomsBiomeFeatures.removeVanillaMushrooms(biome);
    }
}
