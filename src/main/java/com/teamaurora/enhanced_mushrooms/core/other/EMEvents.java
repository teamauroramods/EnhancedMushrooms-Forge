package com.teamaurora.enhanced_mushrooms.core.other;

import com.teamaurora.enhanced_mushrooms.core.EMConfig;
import com.teamaurora.enhanced_mushrooms.core.registry.EMBlocks;
import com.teamaurora.enhanced_mushrooms.core.registry.EMFeatures;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HugeMushroomBlock;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.BigMushroomFeatureConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.event.entity.player.BonemealEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import java.util.Objects;
import java.util.Random;

public class EMEvents {
    @SubscribeEvent
    public void rightClickBlockEvent (PlayerInteractEvent.RightClickBlock event) {
        BlockState state = event.getWorld().getBlockState(event.getPos());
        if (state.getBlock() instanceof HugeMushroomBlock && EMConfig.COMMON.capsStrippable.get()) {
            BlockState strippedState = state.with(HugeMushroomBlock.DOWN, false)
                    .with(HugeMushroomBlock.UP, false)
                    .with(HugeMushroomBlock.NORTH, false)
                    .with(HugeMushroomBlock.SOUTH, false)
                    .with(HugeMushroomBlock.EAST, false)
                    .with(HugeMushroomBlock.WEST, false);
            if (state != strippedState) {
                if (event.getItemStack().getItem() instanceof AxeItem) {
                    if (!event.getPlayer().abilities.isCreativeMode)
                        event.getItemStack().attemptDamageItem(1, event.getWorld().getRandom(), event.getPlayer() instanceof ServerPlayerEntity ? (ServerPlayerEntity) event.getPlayer() : null);
                    event.getWorld().setBlockState(event.getPos(), strippedState);
                    event.getWorld().playSound(event.getPlayer(), event.getPos(), SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
                    event.getPlayer().swingArm(event.getHand());
                }
            }
        }
    }

    @SubscribeEvent
    public void bonemealEvent (BonemealEvent event) {
        if (event.getWorld() instanceof ServerWorld) {
            ServerWorld world = (ServerWorld) event.getWorld();
            BlockPos pos = event.getPos();
            BlockState block = event.getBlock();
            Random rand = new Random();
            if (block.getBlock() == Blocks.RED_MUSHROOM || block.getBlock() == Blocks.BROWN_MUSHROOM) {
                event.setResult(Event.Result.ALLOW);
                if (canUseBonemeal(world, rand, pos, block)) {
                    if (block.getBlock() == Blocks.RED_MUSHROOM) {
                        world.setBlockState(pos, EMBlocks.RED_MUSHROOM_STEM.get().getDefaultState());
                    } else if (block.getBlock() == Blocks.BROWN_MUSHROOM) {
                        world.setBlockState(pos, EMBlocks.BROWN_MUSHROOM_STEM.get().getDefaultState());
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
            configuredfeature = Feature.HUGE_BROWN_MUSHROOM.withConfiguration(EMFeatures.Configs.BROWN_MUSHROOM_CONFIG);
        } else if (state.getBlock() == Blocks.RED_MUSHROOM) {
            configuredfeature = Feature.HUGE_RED_MUSHROOM.withConfiguration(EMFeatures.Configs.RED_MUSHROOM_CONFIG);
        } else {
            world.setBlockState(pos, state, 3);
            return false;
        }

        if (configuredfeature.generate(world, world.getChunkProvider().getChunkGenerator(), rand, pos)) {
            return true;
        } else {
            world.setBlockState(pos, state, 3);
            return false;
        }
    }
}
