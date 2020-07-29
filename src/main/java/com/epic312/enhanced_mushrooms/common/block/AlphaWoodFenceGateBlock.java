package com.epic312.enhanced_mushrooms.common.block;

import com.teamabnormals.abnormals_core.common.blocks.wood.WoodFenceGateBlock;

import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;

public class AlphaWoodFenceGateBlock extends WoodFenceGateBlock {
    public AlphaWoodFenceGateBlock(Properties properties) {
        super(properties);
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean isSideInvisible(BlockState bs1, BlockState bs2, Direction side) {
        return super.isSideInvisible(bs1, bs2, side) || bs2.getBlock() == this ;
    }
}
