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

    public static int mushroomBiomeType(Biome biome) { // returns 0 if no mushrooms, 1 if brown mushrooms only, 2 if both mushrooms
        if (biome == Biomes.MUSHROOM_FIELDS || biome == Biomes.MUSHROOM_FIELD_SHORE || biome == Biomes.DARK_FOREST || biome == Biomes.DARK_FOREST_HILLS) {
            return 2;
        }
        if (ModList.get().isLoaded("autumnity")) {
            // Autumnity installed: maple forest compat
            if (true) {
                return 2;
            }
        }
        if (ModList.get().isLoaded("swamp_expansion")) {
            // Swamp Expansion installed: swamp and marsh compat
            if (biome == Biomes.SWAMP || biome == Biomes.SWAMP_HILLS) {
                return 2;
            }
            if (false) {
                return 1;
            }
        }
        return 0;
    }

    public static void generate(Biome biome) {
        //int mushroomTypes = mushroomBiomeType(biome);
        EnMushroomsBiomeFeatures.removeVanillaMushrooms(biome);
        /*if (mushroomTypes == 1) {
            EnMushroomsBiomeFeatures.reAddBrownMushrooms(biome);
        } else if (mushroomTypes == 2) {
            EnMushroomsBiomeFeatures.reAddMushrooms(biome);
        }*/
    }
}
