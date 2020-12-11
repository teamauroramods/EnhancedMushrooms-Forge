package com.teamaurora.enhanced_mushrooms.common.block;

import com.minecraftabnormals.abnormals_core.common.blocks.wood.WoodStairsBlock;

import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;

public class AlphaWoodStairsBlock extends WoodStairsBlock {
    public AlphaWoodStairsBlock (BlockState state, Properties properties) {
        super(state, properties);
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean isSideInvisible(BlockState bs1, BlockState bs2, Direction side) {
        return super.isSideInvisible(bs1, bs2, side) || bs2.getBlock() == this ;
    }
}
