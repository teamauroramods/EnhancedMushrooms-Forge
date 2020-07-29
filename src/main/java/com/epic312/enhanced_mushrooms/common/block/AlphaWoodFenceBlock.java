package com.epic312.enhanced_mushrooms.common.block;

import com.teamabnormals.abnormals_core.common.blocks.wood.WoodFenceBlock;

import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;

public class AlphaWoodFenceBlock extends WoodFenceBlock {
    public AlphaWoodFenceBlock (Properties properties) {
        super(properties);
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean isSideInvisible(BlockState bs1, BlockState bs2, Direction side) {
        return super.isSideInvisible(bs1, bs2, side) || bs2.getBlock() == this ;
    }
}
