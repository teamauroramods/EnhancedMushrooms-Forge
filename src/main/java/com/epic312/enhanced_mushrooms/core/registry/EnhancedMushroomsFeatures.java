package com.epic312.enhanced_mushrooms.core.registry;

import com.epic312.enhanced_mushrooms.common.world.biome.EnMushroomsBiomeFeatures;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.registries.ForgeRegistries;

public class EnhancedMushroomsFeatures {

    public static void generateFeatures() {
        ForgeRegistries.BIOMES.getValues().forEach(EnhancedMushroomsFeatures::generate);
    }

    public static void generate(Biome biome) {
        EnMushroomsBiomeFeatures.removeVanillaMushrooms(biome);
    }
}
