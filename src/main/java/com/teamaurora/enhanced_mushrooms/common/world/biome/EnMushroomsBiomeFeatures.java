package com.teamaurora.enhanced_mushrooms.common.world.biome;

import com.google.common.collect.ImmutableSet;
import com.minecraftabnormals.abnormals_core.common.world.modification.BiomeFeatureModifier;
import com.teamaurora.enhanced_mushrooms.core.registry.EnhancedMushroomsBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HugeMushroomBlock;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.placement.Placement;

import java.util.ArrayList;
import java.util.List;

public class EnMushroomsBiomeFeatures {
    public static final BlockState RED_MUSHROOM_STEM = EnhancedMushroomsBlocks.RED_MUSHROOM_STEM.get().getDefaultState();
    public static final BlockState BROWN_MUSHROOM_STEM = EnhancedMushroomsBlocks.BROWN_MUSHROOM_STEM.get().getDefaultState();
    public static final BlockState RED_MUSHROOM_CAP = Blocks.RED_MUSHROOM_BLOCK.getDefaultState().with(HugeMushroomBlock.DOWN, Boolean.valueOf(false));
    public static final BlockState BROWN_MUSHROOM_CAP = Blocks.BROWN_MUSHROOM_BLOCK.getDefaultState().with(HugeMushroomBlock.UP, Boolean.valueOf(true)).with(HugeMushroomBlock.DOWN, Boolean.valueOf(false));

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

    public static final BiomeFeatureModifier HUGE_BROWN_MUSHROOM_MODIFIER = BiomeFeatureModifier.createFeatureReplacer(
            (biomeKey, biome) -> (true),
            ImmutableSet.of(GenerationStage.Decoration.VEGETAL_DECORATION),
            ()->Feature.HUGE_BROWN_MUSHROOM,
            ()->(Feature.HUGE_BROWN_MUSHROOM.withConfiguration(BROWN_MUSHROOM_CONFIG))
    );

    public static final BiomeFeatureModifier HUGE_RED_MUSHROOM_MODIFIER = BiomeFeatureModifier.createFeatureReplacer(
            (biomeKey, biome) -> (true),
            ImmutableSet.of(GenerationStage.Decoration.VEGETAL_DECORATION),
            ()->Feature.HUGE_RED_MUSHROOM,
            ()->(Feature.HUGE_RED_MUSHROOM.withConfiguration(RED_MUSHROOM_CONFIG))
    );
}
