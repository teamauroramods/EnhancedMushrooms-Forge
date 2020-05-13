package com.epic312.enhanced_mushrooms.world.biome;

import com.epic312.enhanced_mushrooms.registry.EnhancedMushroomsBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.world.gen.blockstateprovider.SimpleBlockStateProvider;
import net.minecraft.world.gen.feature.BigMushroomFeatureConfig;
import net.minecraft.world.gen.foliageplacer.BlobFoliagePlacer;

public class EnMushroomsBiomeFeautures {
    public static BlockState RED_MUSHROOM_STEM = EnhancedMushroomsBlocks.RED_MUSHROOM_STEM.get().getDefaultState();
    public static BlockState BROWN_MUSHROOM_STEM = EnhancedMushroomsBlocks.BROWN_MUSHROOM_STEM.get().getDefaultState();
    public static BlockState RED_MUSHROOM_CAP = Blocks.RED_MUSHROOM_BLOCK.getDefaultState();
    public static BlockState BROWN_MUSHROOM_CAP = Blocks.BROWN_MUSHROOM_BLOCK.getDefaultState();

    public static final BigMushroomFeatureConfig RED_MUSHROOM_CONFIG = (
            new BigMushroomFeatureConfig(
                    new SimpleBlockStateProvider(RED_MUSHROOM_STEM),
                    new SimpleBlockStateProvider(RED_MUSHROOM_CAP),
                    2));

    public static final BigMushroomFeatureConfig BROWN_MUSHROOM_CONFIG = (
            new BigMushroomFeatureConfig(
                    new SimpleBlockStateProvider(BROWN_MUSHROOM_STEM),
                    new SimpleBlockStateProvider(BROWN_MUSHROOM_CAP),
                    3));
}
