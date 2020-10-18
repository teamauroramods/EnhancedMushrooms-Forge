package com.teamaurora.enhanced_mushrooms.core.other;

import com.teamaurora.enhanced_mushrooms.core.compatibility.Quark;
import com.teamaurora.enhanced_mushrooms.core.registry.EnhancedMushroomsBlocks;
import com.teamaurora.enhanced_mushrooms.common.world.biome.EnMushroomsBiomeFeatures;
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

public class EnhancedMushroomsEvents {
    @SubscribeEvent
    public void rightClickBlockEvent (PlayerInteractEvent.RightClickBlock event) {
        BlockState state = event.getWorld().getBlockState(event.getPos());
        if (state.getBlock() instanceof HugeMushroomBlock) {
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
            if (block.getBlock() == Blocks.RED_MUSHROOM || block.getBlock() == Blocks.BROWN_MUSHROOM || block.getBlock().getRegistryName().equals(new ResourceLocation("quark","glowshroom"))) {
                event.setResult(Event.Result.ALLOW);
                if (canUseBonemeal(world, rand, pos, block)) {
                    if (block.getBlock() == Blocks.RED_MUSHROOM) {
                        world.setBlockState(pos, EnhancedMushroomsBlocks.RED_MUSHROOM_STEM.get().getDefaultState());
                    } else if (block.getBlock() == Blocks.BROWN_MUSHROOM) {
                        world.setBlockState(pos, EnhancedMushroomsBlocks.BROWN_MUSHROOM_STEM.get().getDefaultState());
                    } else if (Objects.equals(block.getBlock().getRegistryName(), new ResourceLocation("quark", "glowshroom"))) {
                        world.setBlockState(pos, Blocks.AIR.getDefaultState());
                    }
                    mushroomGrowth(world, pos, block, rand);
                }
            }
        }
    }

    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
        return (double)rand.nextFloat() < 0.4D;
    }

    // Quark copy paste of a vanilla copy paste, touch only if you *really* dare
    public static boolean placeGlowshroom(World worldIn, Random rand, BlockPos pos) {
        if (!Quark.isInstalled() || Quark.GLOWSHROOM_BLOCK == null) {
            return false;
        }
        int i = rand.nextInt(3) + 4;
        if (rand.nextInt(12) == 0) {
            i *= 2;
        }

        int j = pos.getY();
        if (j >= 1 && j + i + 1 < 256) {
            Block block = worldIn.getBlockState(pos.down()).getBlock();
            if (!block.getRegistryName().equals(new ResourceLocation("quark","glowcelium"))) {
                return false;
            } else {
                BlockPos.Mutable blockpos$mutableblockpos = new BlockPos.Mutable();

                for(int k = 0; k <= i; ++k) {
                    int l = 0;
                    if (k < i && k >= i - 3) {
                        l = 2;
                    } else if (k == i) {
                        l = 1;
                    }

                    for(int i1 = -l; i1 <= l; ++i1) {
                        for(int j1 = -l; j1 <= l; ++j1) {
                            BlockState blockstate = worldIn.getBlockState(blockpos$mutableblockpos.setPos(pos).move(i1, k, j1));
                            if (!blockstate.isAir(worldIn, blockpos$mutableblockpos) && blockstate.canBeReplacedByLeaves(worldIn, blockpos$mutableblockpos)) { // isIn
                                return false;
                            }
                        }
                    }
                }

                BlockState blockstate1 = Quark.GLOWSHROOM_BLOCK.getDefaultState().with(HugeMushroomBlock.DOWN, Boolean.valueOf(false));

                for(int l1 = i - 3; l1 <= i; ++l1) {
                    int i2 = l1 < i ? 2 : 1;

                    for(int l2 = -i2; l2 <= i2; ++l2) {
                        for(int k1 = -i2; k1 <= i2; ++k1) {
                            boolean flag = l2 == -i2;
                            boolean flag1 = l2 == i2;
                            boolean flag2 = k1 == -i2;
                            boolean flag3 = k1 == i2;
                            boolean flag4 = flag || flag1;
                            boolean flag5 = flag2 || flag3;
                            if (l1 >= i || flag4 != flag5) {
                                blockpos$mutableblockpos.setPos(pos).move(l2, l1, k1);
                                if (worldIn.getBlockState(blockpos$mutableblockpos).canBeReplacedByLeaves(worldIn, blockpos$mutableblockpos)) {
                                    worldIn.setBlockState(blockpos$mutableblockpos, blockstate1.with(HugeMushroomBlock.UP, Boolean.valueOf(l1 >= i - 1)).with(HugeMushroomBlock.WEST, Boolean.valueOf(l2 < 0)).with(HugeMushroomBlock.EAST, Boolean.valueOf(l2 > 0)).with(HugeMushroomBlock.NORTH, Boolean.valueOf(k1 < 0)).with(HugeMushroomBlock.SOUTH, Boolean.valueOf(k1 > 0)), 2);
                                }
                            }
                        }
                    }
                }

                BlockState blockstate2 = EnhancedMushroomsBlocks.GLOWSHROOM_STEM.get().getDefaultState();

                for(int j2 = 0; j2 < i; ++j2) {
                    blockpos$mutableblockpos.setPos(pos).move(Direction.UP, j2);
                    if (worldIn.getBlockState(blockpos$mutableblockpos).canBeReplacedByLeaves(worldIn, blockpos$mutableblockpos)) {
                        worldIn.setBlockState(blockpos$mutableblockpos, blockstate2, 3);
                    }
                }

                return true;
            }
        } else {
            return false;
        }
    }

    public boolean mushroomGrowth(ServerWorld world, BlockPos pos, BlockState state, Random rand) {
        world.removeBlock(pos, false);
        ConfiguredFeature<BigMushroomFeatureConfig, ?> configuredfeature;
        if (state.getBlock() == Blocks.BROWN_MUSHROOM) {
            configuredfeature = Feature.HUGE_BROWN_MUSHROOM.withConfiguration(EnMushroomsBiomeFeatures.BROWN_MUSHROOM_CONFIG);
        } else if (state.getBlock() == Blocks.RED_MUSHROOM) {
            configuredfeature = Feature.HUGE_RED_MUSHROOM.withConfiguration(EnMushroomsBiomeFeatures.RED_MUSHROOM_CONFIG);
        } else if (Objects.equals(state.getBlock().getRegistryName(), new ResourceLocation("quark", "glowshroom"))) {
            if (placeGlowshroom(world, rand, pos)) {
                return true;
            } else {
                world.setBlockState(pos, state, 3);
                return false;
            }
        } else {
            world.setBlockState(pos, state, 3);
            return false;
        }

        if (configuredfeature.func_236265_a_(world, world.func_241112_a_(), world.getChunkProvider().getChunkGenerator(), rand, pos)) {
            return true;
        } else {
            world.setBlockState(pos, state, 3);
            return false;
        }
    }
}
