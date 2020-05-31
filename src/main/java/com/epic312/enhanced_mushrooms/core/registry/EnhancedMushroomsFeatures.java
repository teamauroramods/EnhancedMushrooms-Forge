package com.epic312.enhanced_mushrooms.core.registry;

import com.epic312.enhanced_mushrooms.common.world.biome.EnMushroomsBiomeFeatures;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.MooshroomEntity;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.MushroomFieldsBiome;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;

public class EnhancedMushroomsFeatures {

    public static void generateFeatures() {
        ForgeRegistries.BIOMES.getValues().forEach(EnhancedMushroomsFeatures::generate);
    }

    public static void generate(Biome biome) {
        EnMushroomsBiomeFeatures.removeVanillaMushrooms(biome);
        if ((biome == Biomes.SWAMP || biome == Biomes.SWAMP_HILLS) && ModList.get().isLoaded("swampexpansion")) {
            EnMushroomsBiomeFeatures.addSwampMushrooms(biome);
        }
    }
}
