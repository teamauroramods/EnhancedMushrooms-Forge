package com.teamaurora.enhanced_mushrooms.core.registry;

import com.google.common.collect.ImmutableList;
import com.minecraftabnormals.abnormals_core.core.util.DataUtil;
import com.teamaurora.enhanced_mushrooms.core.EnhancedMushrooms;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HugeMushroomBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.IPlacementConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.world.WorldEvent;
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

    public static final class Configured {
        public static final ConfiguredFeature<?, ?> HUGE_RED_MUSHROOM = Feature.HUGE_RED_MUSHROOM.withConfiguration(Configs.RED_MUSHROOM_CONFIG);
        public static final ConfiguredFeature<?, ?> HUGE_BROWN_MUSHROOM = Feature.HUGE_BROWN_MUSHROOM.withConfiguration(Configs.BROWN_MUSHROOM_CONFIG);

        public static final ConfiguredFeature<?, ?> DARK_FOREST_VEGETATION_BROWN = Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(HUGE_BROWN_MUSHROOM.withChance(0.025F), HUGE_RED_MUSHROOM.withChance(0.05F), Features.DARK_OAK.withChance(0.6666667F), Features.BIRCH.withChance(0.2F), Features.FANCY_OAK.withChance(0.1F)), Features.OAK)).withPlacement(Placement.DARK_OAK_TREE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG));
        public static final ConfiguredFeature<?, ?> DARK_FOREST_VEGETATION_RED = Feature.RANDOM_SELECTOR.withConfiguration(new MultipleRandomFeatureConfig(ImmutableList.of(HUGE_RED_MUSHROOM.withChance(0.025F), HUGE_BROWN_MUSHROOM.withChance(0.05F), Features.DARK_OAK.withChance(0.6666667F), Features.BIRCH.withChance(0.2F), Features.FANCY_OAK.withChance(0.1F)), Features.OAK)).withPlacement(Placement.DARK_OAK_TREE.configure(IPlacementConfig.NO_PLACEMENT_CONFIG));
        public static final ConfiguredFeature<?, ?> MUSHROOM_FIELD_VEGETATION = Feature.RANDOM_BOOLEAN_SELECTOR.withConfiguration(new TwoFeatureChoiceConfig(() -> {
            return HUGE_RED_MUSHROOM;
        }, () -> {
            return HUGE_BROWN_MUSHROOM;
        })).withPlacement(Features.Placements.HEIGHTMAP_PLACEMENT);

        private static <FC extends IFeatureConfig> void register(String name, ConfiguredFeature<FC, ?> configuredFeature) {
            Registry.register(WorldGenRegistries.CONFIGURED_FEATURE, new ResourceLocation(EnhancedMushrooms.MODID, name), configuredFeature);
        }

        public static void registerConfiguredFeatures() {
            register("huge_red_mushroom", HUGE_RED_MUSHROOM);
            register("huge_brown_mushroom", HUGE_BROWN_MUSHROOM);

            register("dark_forest_decoration_brown", DARK_FOREST_VEGETATION_BROWN);
            register("dark_forest_decoration_red", DARK_FOREST_VEGETATION_RED);
            register("mushroom_field_vegetation", MUSHROOM_FIELD_VEGETATION);
        }
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
    // This part is necessary for vanilla worldgen. I have no idea why but it works so I'll take it
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
                            tempDef = Configured.HUGE_RED_MUSHROOM;
                        } else if (isHugeBrownMushroom(tempDef)) {
                            tempDef = Configured.HUGE_BROWN_MUSHROOM;
                        }

                        List<ConfiguredRandomFeatureList> tempFeatures = new ArrayList<>();
                        for (ConfiguredRandomFeatureList crfl : mrfconfig.features) {
                            ConfiguredFeature<?, ?> crflFeature = crfl.feature.get();
                            if (isHugeRedMushroom(crflFeature)) {
                                tempFeatures.add(new ConfiguredRandomFeatureList(Configured.HUGE_RED_MUSHROOM, crfl.chance));
                            } else if (isHugeBrownMushroom(crflFeature)) {
                                tempFeatures.add(new ConfiguredRandomFeatureList(Configured.HUGE_BROWN_MUSHROOM, crfl.chance));
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
                            leftFeature = Configured.HUGE_RED_MUSHROOM;
                        } else if (isHugeBrownMushroom(leftFeature)) {
                            leftFeature = Configured.HUGE_BROWN_MUSHROOM;
                        }
                        final ConfiguredFeature<?, ?> leftFeatureFinal = leftFeature;

                        ConfiguredFeature<?, ?> rightFeature = tfcconfig.field_227286_b_.get();
                        if (isHugeRedMushroom(rightFeature)) {
                            rightFeature = Configured.HUGE_RED_MUSHROOM;
                        } else if (isHugeBrownMushroom(rightFeature)) {
                            rightFeature = Configured.HUGE_BROWN_MUSHROOM;
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
            /*for (ConfiguredFeature<?, ?> f : toAdd) {
                event.getGeneration().withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, f);
            }*/
            if (DataUtil.matchesKeys(event.getName(), Biomes.DARK_FOREST_HILLS)) {
                event.getGeneration().withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Configured.DARK_FOREST_VEGETATION_RED);
            } else if (DataUtil.matchesKeys(event.getName(), Biomes.DARK_FOREST)) {
                event.getGeneration().withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Configured.DARK_FOREST_VEGETATION_BROWN);
            } else if (DataUtil.matchesKeys(event.getName(), Biomes.MUSHROOM_FIELD_SHORE, Biomes.MUSHROOM_FIELDS)) {
                event.getGeneration().withFeature(GenerationStage.Decoration.VEGETAL_DECORATION, Configured.MUSHROOM_FIELD_VEGETATION);
            }
        }
    }
}
