package com.epic312.enhanced_mushrooms.world.biome;

import com.epic312.enhanced_mushrooms.registry.EnhancedMushroomsBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeFeatures;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.FrequencyConfig;
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


    // Code originally created by bageldotjpg for Swamp Expansion, repurposed "slightly" for mushroom purposes
    public static void removeVanillaMushrooms(Biome biome) {
        ConfiguredFeature<BigMushroomFeatureConfig, BigRedMushroomFeature> ConfiguredHugeRedMushroom = new ConfiguredFeature<BigMushroomFeatureConfig, BigRedMushroomFeature>((BigRedMushroomFeature) Feature.HUGE_RED_MUSHROOM, DefaultBiomeFeatures.BIG_RED_MUSHROOM);
        ConfiguredFeature<BigMushroomFeatureConfig, BigBrownMushroomFeature> ConfiguredHugeBrownMushroom = new ConfiguredFeature<BigMushroomFeatureConfig, BigBrownMushroomFeature>((BigBrownMushroomFeature) Feature.HUGE_BROWN_MUSHROOM, DefaultBiomeFeatures.BIG_BROWN_MUSHROOM);
       // ConfiguredFeature<TwoFeatureChoiceConfig, TwoFeatureChoiceFeature> ConfiguredMushrooms = new ConfiguredFeature<TwoFeatureChoiceConfig,TwoFeatureChoiceFeature>(Feature.RANDOM_BOOLEAN_SELECTOR.withConfiguration(new TwoFeatureChoiceConfig(Feature.HUGE_RED_MUSHROOM.withConfiguration(DefaultBiomeFeatures.BIG_RED_MUSHROOM), Feature.HUGE_BROWN_MUSHROOM.withConfiguration(DefaultBiomeFeatures.BIG_BROWN_MUSHROOM))).withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));)
        //for (GenerationStage.Decoration stage : GenerationStage.Decoration.values()) {
            List<ConfiguredFeature<?, ?>> list = biome.getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION);
            for (ConfiguredFeature<?, ?> configuredFeature : list) {
                if (configuredFeature.config instanceof TwoFeatureChoiceConfig) {
                    System.out.print("gamer");
                    TwoFeatureChoiceConfig mushroom = (TwoFeatureChoiceConfig) configuredFeature.config;
                    if (mushroom.equals(new TwoFeatureChoiceConfig(Feature.HUGE_RED_MUSHROOM.withConfiguration(DefaultBiomeFeatures.BIG_RED_MUSHROOM), Feature.HUGE_BROWN_MUSHROOM.withConfiguration(DefaultBiomeFeatures.BIG_BROWN_MUSHROOM)))) {
                        biome.getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION).remove(configuredFeature);
                        biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Feature.RANDOM_BOOLEAN_SELECTOR.withConfiguration(new TwoFeatureChoiceConfig(Feature.HUGE_RED_MUSHROOM.withConfiguration(RED_MUSHROOM_CONFIG), Feature.HUGE_BROWN_MUSHROOM.withConfiguration(BROWN_MUSHROOM_CONFIG))).withPlacement(Placement.COUNT_HEIGHTMAP.configure(new FrequencyConfig(1))));
                    }
                }
            }
        //}
    }
}
