package com.epic312.enhanced_mushrooms.block;

import com.teamabnormals.abnormals_core.common.blocks.wood.AbnormalsLogBlock;
import com.teamabnormals.abnormals_core.core.utils.ItemStackUtils;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.LogBlock;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.*;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;

import java.util.function.Supplier;

/**
 * Code by SmellyModder (Luke Tonon) except the BooleanProperty jank.
 * This is a reimplementation of com.teamabnormals.abnormals_core.common.blocks.wood.AbnormalsLogBlock with compatibility for mushroom generation
 */

public class AbnormalsStemBlock extends AbnormalsLogBlock {
    public static final BooleanProperty WEST = BooleanProperty.create("west");
    public static final BooleanProperty EAST = BooleanProperty.create("east");
    public static final BooleanProperty NORTH = BooleanProperty.create("north");
    public static final BooleanProperty SOUTH = BooleanProperty.create("south");
    public static final BooleanProperty UP = BooleanProperty.create("up");
    public static final BooleanProperty DOWN = BooleanProperty.create("down");

    public AbnormalsStemBlock(Supplier<Block> strippedBlock, MaterialColor verticalColor, Properties properties) {
        super(strippedBlock, verticalColor, properties);
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
