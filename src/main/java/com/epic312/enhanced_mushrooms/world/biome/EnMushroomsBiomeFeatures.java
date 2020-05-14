package com.epic312.enhanced_mushrooms.world.biome;

import com.epic312.enhanced_mushrooms.registry.EnhancedMushroomsBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;
import net.minecraft.world.gen.placement.AtSurfaceWithExtraConfig;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.HeightWithChanceConfig;
import net.minecraft.world.gen.placement.Placement;

import java.util.List;

public class EnMushroomsBiomeFeatures {
    public static BlockState RED_MUSHROOM_STEM = EnhancedMushroomsBlocks.RED_MUSHROOM_STEM.get().getDefaultState();
    public static BlockState BROWN_MUSHROOM_STEM = EnhancedMushroomsBlocks.BROWN_MUSHROOM_STEM.get().getDefaultState();
    public static BlockState RED_MUSHROOM_CAP = Blocks.RED_MUSHROOM_BLOCK.getDefaultState();
    public static BlockState BROWN_MUSHROOM_CAP = Blocks.BROWN_MUSHROOM_BLOCK.getDefaultState();

    public static final BigMushroomFeatureConfig RED_MUSHROOM_CONFIG = (
            new BigMushroomFeatureConfig(
                    new SimpleBlockStateProvider(RED_MUSHROOM_CAP),
                    new SimpleBlockStateProvider(RED_MUSHROOM_STEM),
                    2));

    public static final BigMushroomFeatureConfig BROWN_MUSHROOM_CONFIG = (
            new BigMushroomFeatureConfig(
                    new SimpleBlockStateProvider(BROWN_MUSHROOM_CAP),
                    new SimpleBlockStateProvider(BROWN_MUSHROOM_STEM),
                    3));

    public static void reAddMushrooms(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_BOOLEAN_SELECTOR.withConfiguration(new TwoFeatureChoiceConfig(Feature.HUGE_RED_MUSHROOM.withConfiguration(RED_MUSHROOM_CONFIG), Feature.HUGE_BROWN_MUSHROOM.withConfiguration(BROWN_MUSHROOM_CONFIG))).withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));
    }

    public static void reAddBrownMushrooms(Biome biome) {
        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.HUGE_BROWN_MUSHROOM.withConfiguration(BROWN_MUSHROOM_CONFIG).withPlacement(Placement.COUNT_EXTRA_HEIGHTMAP.configure(new AtSurfaceWithExtraConfig(0, 0.32F, 1))));
    }

    // Code originally created by bageldotjpg for Swamp Expansion, repurposed slightly for mushroom purposes
    public static void removeVanillaMushrooms(Biome biome) {
        for (GenerationStage.Decoration stage : GenerationStage.Decoration.values()) {
            List<ConfiguredFeature<?, ?>> list = biome.getFeatures(stage);
            for (int j = 0; j < list.size(); j++) {
                ConfiguredFeature<?, ?> configuredFeature = list.get(j);
                if (configuredFeature.config instanceof DecoratedFeatureConfig) {
                    DecoratedFeatureConfig decorated = (DecoratedFeatureConfig) configuredFeature.config;

                    if (decorated.feature.config instanceof BigMushroomFeatureConfig) {
                        BigMushroomFeatureConfig mushroom = (BigMushroomFeatureConfig) decorated.feature.config;
                        biome.getFeatures(stage).remove(configuredFeature);
                        if (mushroom == DefaultBiomeFeatures.BIG_BROWN_MUSHROOM) {
                            biome.addFeature(stage, new ConfiguredFeature<BigMushroomFeatureConfig, BigBrownMushroomFeature>((BigBrownMushroomFeature) Feature.HUGE_BROWN_MUSHROOM, BROWN_MUSHROOM_CONFIG));
                        } else if (mushroom == DefaultBiomeFeatures.BIG_RED_MUSHROOM) {
                            biome.addFeature(stage, new ConfiguredFeature<BigMushroomFeatureConfig, BigRedMushroomFeature>((BigRedMushroomFeature) Feature.HUGE_RED_MUSHROOM, RED_MUSHROOM_CONFIG));
                        }
                    }
                }
            }
        }
    }
}
