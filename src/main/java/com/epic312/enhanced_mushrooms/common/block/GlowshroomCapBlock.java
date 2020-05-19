package com.epic312.enhanced_mushrooms.common.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;

public class GlowshroomCapBlock extends AlphaBlock {
    public static final BooleanProperty WEST = BooleanProperty.create("west");
    public static final BooleanProperty EAST = BooleanProperty.create("east");
    public static final BooleanProperty NORTH = BooleanProperty.create("north");
    public static final BooleanProperty SOUTH = BooleanProperty.create("south");
    public static final BooleanProperty UP = BooleanProperty.create("up");
    public static final BooleanProperty DOWN = BooleanProperty.create("down");

    public GlowshroomCapBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        super.fillStateContainer(builder);
        builder.add(WEST);
        builder.add(EAST);
        builder.add(NORTH);
        builder.add(SOUTH);
        builder.add(UP);
        builder.add(DOWN);
    }
}
