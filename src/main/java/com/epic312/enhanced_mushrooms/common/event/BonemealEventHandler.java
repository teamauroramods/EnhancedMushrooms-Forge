package com.epic312.enhanced_mushrooms.common.event;

import com.epic312.enhanced_mushrooms.core.registry.EnhancedMushroomsBlocks;
import com.epic312.enhanced_mushrooms.common.world.biome.EnMushroomsBiomeFeatures;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.BigMushroomFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Random;

public class BonemealEventHandler {
    @SubscribeEvent
    public void bonemealEvent (BonemealEvent event) {
        if (event.getWorld() instanceof ServerWorld) {
            ServerWorld world = (ServerWorld) event.getWorld();
            BlockPos pos = event.getPos();
            BlockState block = event.getBlock();
            Random rand = new Random();
            if (block.getBlock() == Blocks.RED_MUSHROOM || block.getBlock() == Blocks.BROWN_MUSHROOM || block.getBlock().getRegistryName().equals(new ResourceLocation("quark","glowshroom"))) {
                event.setResult(Event.Result.ALLOW);
                if (canUseBonemeal(world, rand, pos, block)) {
                    if (block.getBlock() == Blocks.RED_MUSHROOM) {
                        world.setBlockState(pos, EnhancedMushroomsBlocks.RED_MUSHROOM_STEM.get().getDefaultState());
                    } else if (block.getBlock() == Blocks.BROWN_MUSHROOM) {
                        world.setBlockState(pos, EnhancedMushroomsBlocks.BROWN_MUSHROOM_STEM.get().getDefaultState());
                    } else if (block.getBlock().getRegistryName().equals(new ResourceLocation("quark","glowshroom"))) {
                        //System.out.print("gamer\n");
                    }
                    mushroomGrowth(world, pos, block, rand);
                }
            }
        }
    }

    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return (double)rand.nextFloat() < 0.4D;
    }

    public boolean mushroomGrowth(ServerWorld world, BlockPos pos, BlockState state, Random rand) {
        world.removeBlock(pos, false);
        ConfiguredFeature<BigMushroomFeatureConfig, ?> configuredfeature;
        if (state.getBlock() == Blocks.BROWN_MUSHROOM) {
            configuredfeature = Feature.HUGE_BROWN_MUSHROOM.withConfiguration(EnMushroomsBiomeFeatures.BROWN_MUSHROOM_CONFIG);
        } else if (state.getBlock() == Blocks.RED_MUSHROOM) {
            configuredfeature = Feature.HUGE_RED_MUSHROOM.withConfiguration(EnMushroomsBiomeFeatures.RED_MUSHROOM_CONFIG);
        } else if (state.getBlock().getRegistryName().equals(new ResourceLocation("quark","glowshroom"))) {
            if (pos.getY() <= 249) {
                for (int i=0; i<6; i++) {
                    if (world.getBlockState(new BlockPos(pos.getX(), pos.getY()+i, pos.getZ())).getBlock().getRegistryName().equals(new ResourceLocation("quark","glowshroom_stem"))) {
                        world.setBlockState(new BlockPos(pos.getX(), pos.getY()+i, pos.getZ()), EnhancedMushroomsBlocks.GLOWSHROOM_STEM.get().getDefaultState());
                    }
                }
            }
            return true;
        } else {
            world.setBlockState(pos, state, 3);
            return false;
        }

        if (configuredfeature.place(world, world.getChunkProvider().getChunkGenerator(), rand, pos)) {
            return true;
        } else {
            world.setBlockState(pos, state, 3);
            return false;
        }
    }
}
