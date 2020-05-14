package com.epic312.enhanced_mushrooms.world.biome;

import com.epic312.enhanced_mushrooms.registry.EnhancedMushroomsBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;

import java.util.ArrayList;
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

    public static void removeVanillaMushrooms(Biome biome) {
        List<ConfiguredFeature<?, ?>> list = biome.getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION);
        List<ConfiguredFeature<?, ?>> toRemove = new ArrayList<>();
        int listSize = list.size();
        for (int i=0; i<listSize; i++) {
            ConfiguredFeature<?, ?> configuredFeature = list.get(i);
            if (configuredFeature.config instanceof DecoratedFeatureConfig) {
                DecoratedFeatureConfig decorated = (DecoratedFeatureConfig) configuredFeature.config;
                if (decorated.feature.config instanceof TwoFeatureChoiceConfig) {
                    TwoFeatureChoiceConfig mushroom = (TwoFeatureChoiceConfig) decorated.feature.config;
                    if (mushroom.field_227285_a_.config instanceof BigMushroomFeatureConfig && mushroom.field_227286_b_.config instanceof BigMushroomFeatureConfig) {
                        toRemove.add(configuredFeature);
                        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_BOOLEAN_SELECTOR.withConfiguration(new TwoFeatureChoiceConfig(Feature.HUGE_RED_MUSHROOM.withConfiguration(RED_MUSHROOM_CONFIG), Feature.HUGE_BROWN_MUSHROOM.withConfiguration(BROWN_MUSHROOM_CONFIG))).withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));
                    }
                } else if (decorated.feature.config instanceof MultipleRandomFeatureConfig) {
                    MultipleRandomFeatureConfig mushroom = (MultipleRandomFeatureConfig) decorated.feature.config;
                    List<ConfiguredRandomFeatureList<?>> tempFeatures = new ArrayList<>();
                    for (ConfiguredRandomFeatureList crfl : mushroom.features) {
                        if (crfl.feature.feature instanceof BigBrownMushroomFeature) {
                            tempFeatures.add(new ConfiguredRandomFeatureList<BigMushroomFeatureConfig>(Feature.HUGE_BROWN_MUSHROOM.withConfiguration(BROWN_MUSHROOM_CONFIG),crfl.chance));
                        } else if (crfl.feature.feature instanceof BigRedMushroomFeature) {
                            tempFeatures.add(new ConfiguredRandomFeatureList<BigMushroomFeatureConfig>(Feature.HUGE_RED_MUSHROOM.withConfiguration(RED_MUSHROOM_CONFIG),crfl.chance));
                        } else {
                            tempFeatures.add(crfl);
                        }
                    }
                    ConfiguredFeature<DecoratedFeatureConfig, ?> tempFeature = new ConfiguredFeature<DecoratedFeatureConfig, DecoratedFeature>(
                            (DecoratedFeature)configuredFeature.feature, new DecoratedFeatureConfig(
                                    new ConfiguredFeature<MultipleRandomFeatureConfig, Feature<MultipleRandomFeatureConfig>>((Feature<MultipleRandomFeatureConfig>)decorated.feature.feature,
                                            new MultipleRandomFeatureConfig(tempFeatures, mushroom.defaultFeature)
                                    ), decorated.decorator
                    ));
                    toRemove.add(configuredFeature);
                    biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, tempFeature);
                }
            }
        }
        for (int i=0; i<toRemove.size(); i++) {
            list.remove(toRemove.get(i));
        }
    }
}
