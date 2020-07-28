package com.epic312.enhanced_mushrooms.common.block;

import com.minecraftabnormals.abnormals_core.common.blocks.AbnormalsBeehiveBlock;

import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;

public class AlphaAbnormalsBeehiveBlock extends AbnormalsBeehiveBlock {
    public AlphaAbnormalsBeehiveBlock(Properties properties) {
        super(properties);
    }

    @SuppressWarnings("deprecation")
    @Override
    public boolean isSideInvisible(BlockState bs1, BlockState bs2, Direction side) {
        return super.isSideInvisible(bs1, bs2, side) || bs2.getBlock() == this ;
    }
}
