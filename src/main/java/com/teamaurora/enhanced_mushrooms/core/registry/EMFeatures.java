package com.teamaurora.enhanced_mushrooms.core.registry;

import com.teamaurora.enhanced_mushrooms.core.EnhancedMushrooms;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HugeMushroomBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = EnhancedMushrooms.MODID)
public class EMFeatures {

    public static final class BlockStates {
        public static final BlockState RED_MUSHROOM_STEM = EMBlocks.RED_MUSHROOM_STEM.get().getDefaultState();
        public static final BlockState BROWN_MUSHROOM_STEM = EMBlocks.BROWN_MUSHROOM_STEM.get().getDefaultState();
        public static final BlockState RED_MUSHROOM_CAP = Blocks.RED_MUSHROOM_BLOCK.getDefaultState().with(HugeMushroomBlock.DOWN, Boolean.valueOf(false));
        public static final BlockState BROWN_MUSHROOM_CAP = Blocks.BROWN_MUSHROOM_BLOCK.getDefaultState().with(HugeMushroomBlock.UP, Boolean.valueOf(true)).with(HugeMushroomBlock.DOWN, Boolean.valueOf(false));
    }

    public static final class Configs {
        public static final BigMushroomFeatureConfig RED_MUSHROOM_CONFIG = (
                new BigMushroomFeatureConfig(
                        new SimpleBlockStateProvider(BlockStates.RED_MUSHROOM_CAP),
                        new SimpleBlockStateProvider(BlockStates.RED_MUSHROOM_STEM),
                        2));

        public static final BigMushroomFeatureConfig BROWN_MUSHROOM_CONFIG = (
                new BigMushroomFeatureConfig(
                        new SimpleBlockStateProvider(BlockStates.BROWN_MUSHROOM_CAP),
                        new SimpleBlockStateProvider(BlockStates.BROWN_MUSHROOM_STEM),
                        3));
    }

    private static boolean isHugeRedMushroom(ConfiguredFeature<?, ?> configuredFeature) {
        if (configuredFeature.feature == Feature.HUGE_RED_MUSHROOM) {
            if (configuredFeature.config instanceof BigMushroomFeatureConfig) {
                BigMushroomFeatureConfig config = (BigMushroomFeatureConfig) configuredFeature.config;
                return config.capProvider.getBlockState(new Random(), new BlockPos(0, 0, 0)).getBlock() == Blocks.RED_MUSHROOM_BLOCK;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private static boolean isHugeBrownMushroom(ConfiguredFeature<?, ?> configuredFeature) {
        if (configuredFeature.feature == Feature.HUGE_BROWN_MUSHROOM) {
            if (configuredFeature.config instanceof BigMushroomFeatureConfig) {
                BigMushroomFeatureConfig config = (BigMushroomFeatureConfig) configuredFeature.config;
                return config.capProvider.getBlockState(new Random(), new BlockPos(0, 0, 0)).getBlock() == Blocks.BROWN_MUSHROOM_BLOCK;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    // Code originally by bageldotjpg, modified by me to work with what I'm doing (Epic)
    @SubscribeEvent
    public static void onBiomeLoad(BiomeLoadingEvent event) {
        List<Supplier<ConfiguredFeature<?, ?>>> features = event.getGeneration().getFeatures(GenerationStage.Decoration.VEGETAL_DECORATION);
        if (event.getName() != null) {
            List<Supplier<ConfiguredFeature<?, ?>>> toRemove = new ArrayList<>();
            List<ConfiguredFeature<?, ?>> toAdd = new ArrayList<>();
            for (Supplier<ConfiguredFeature<?, ?>> configuredFeatureSupplier : features) {
                IFeatureConfig config = configuredFeatureSupplier.get().config;
                if (config instanceof DecoratedFeatureConfig) {
                    ConfiguredFeature<?, ?> configuredFeature = ((DecoratedFeatureConfig) config).feature.get();
                    if (configuredFeature.config instanceof MultipleRandomFeatureConfig) {
                        MultipleRandomFeatureConfig mrfconfig = (MultipleRandomFeatureConfig) configuredFeature.config;

                        ConfiguredFeature<?, ?> tempDef = mrfconfig.defaultFeature.get();
                        if (isHugeRedMushroom(tempDef)) {
                            tempDef = Feature.HUGE_RED_MUSHROOM.withConfiguration(Configs.RED_MUSHROOM_CONFIG);
                        } else if (isHugeBrownMushroom(tempDef)) {
                            tempDef = Feature.HUGE_BROWN_MUSHROOM.withConfiguration(Configs.BROWN_MUSHROOM_CONFIG);
                        }

                        List<ConfiguredRandomFeatureList> tempFeatures = new ArrayList<>();
                        for (ConfiguredRandomFeatureList crfl : mrfconfig.features) {
                            ConfiguredFeature<?, ?> crflFeature = crfl.feature.get();
                            if (isHugeRedMushroom(crflFeature)) {
                                tempFeatures.add(new ConfiguredRandomFeatureList(Feature.HUGE_RED_MUSHROOM.withConfiguration(Configs.RED_MUSHROOM_CONFIG), crfl.chance));
                            } else if (isHugeBrownMushroom(crflFeature)) {
                                tempFeatures.add(new ConfiguredRandomFeatureList(Feature.HUGE_BROWN_MUSHROOM.withConfiguration(Configs.BROWN_MUSHROOM_CONFIG), crfl.chance));
                            } else {
                                tempFeatures.add(crfl);
                            }
                        }

                        MultipleRandomFeatureConfig tempConfig = new MultipleRandomFeatureConfig(tempFeatures, tempDef);
                        if (tempConfig != mrfconfig) {
                            toRemove.add(configuredFeatureSupplier);
                            Feature<MultipleRandomFeatureConfig> featureMRFC = (Feature<MultipleRandomFeatureConfig>) configuredFeature.feature;
                            toAdd.add(featureMRFC.withConfiguration(tempConfig).withPlacement(((DecoratedFeatureConfig) config).decorator));
                        }
                    } else if (configuredFeature.config instanceof TwoFeatureChoiceConfig) {
                        TwoFeatureChoiceConfig tfcconfig = (TwoFeatureChoiceConfig) configuredFeature.config;

                        // this code is fucking AWFUL but it *should* work
                        ConfiguredFeature<?, ?> leftFeature = tfcconfig.field_227285_a_.get();
                        if (isHugeRedMushroom(leftFeature)) {
                            leftFeature = Feature.HUGE_RED_MUSHROOM.withConfiguration(Configs.RED_MUSHROOM_CONFIG);
                        } else if (isHugeBrownMushroom(leftFeature)) {
                            leftFeature = Feature.HUGE_BROWN_MUSHROOM.withConfiguration(Configs.BROWN_MUSHROOM_CONFIG);
                        }
                        final ConfiguredFeature<?, ?> leftFeatureFinal = leftFeature;

                        ConfiguredFeature<?, ?> rightFeature = tfcconfig.field_227286_b_.get();
                        if (isHugeRedMushroom(rightFeature)) {
                            rightFeature = Feature.HUGE_RED_MUSHROOM.withConfiguration(Configs.RED_MUSHROOM_CONFIG);
                        } else if (isHugeBrownMushroom(rightFeature)) {
                            rightFeature = Feature.HUGE_BROWN_MUSHROOM.withConfiguration(Configs.BROWN_MUSHROOM_CONFIG);
                        }
                        final ConfiguredFeature<?, ?> rightFeatureFinal = rightFeature;

                        TwoFeatureChoiceConfig tempConfig = new TwoFeatureChoiceConfig(() -> leftFeatureFinal, () -> rightFeatureFinal);
                        if (tempConfig != tfcconfig) {
                            toRemove.add(configuredFeatureSupplier);
                            Feature<TwoFeatureChoiceConfig> featureTFCC = (Feature<TwoFeatureChoiceConfig>) configuredFeature.feature;
                            toAdd.add(featureTFCC.withConfiguration(tempConfig).withPlacement(((DecoratedFeatureConfig) config).decorator));
                        }
                    }
                }
            }
            toRemove.forEach(features::remove);
            for (ConfiguredFeature<?, ?> f : toAdd) {
                event.getGeneration().withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, f);
            }
        }
    }
}
