package com.epic312.enhanced_mushrooms.block;

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

public class AbnormalsStemBlock extends LogBlock {
    public static final BooleanProperty WEST = BooleanProperty.create("west");
    public static final BooleanProperty EAST = BooleanProperty.create("east");
    public static final BooleanProperty NORTH = BooleanProperty.create("north");
    public static final BooleanProperty SOUTH = BooleanProperty.create("south");
    public static final BooleanProperty UP = BooleanProperty.create("up");
    public static final BooleanProperty DOWN = BooleanProperty.create("down");
    private final Supplier<Block> block;

    public AbnormalsStemBlock(Supplier<Block> strippedBlock, MaterialColor verticalColor, Properties properties) {
        super(verticalColor, properties);
        this.block = strippedBlock;
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

    @Override
    public ActionResultType onBlockActivated(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockRayTraceResult result) {
        if(player.getHeldItem(hand).getItem() instanceof AxeItem) {
            world.playSound(player, pos, SoundEvents.ITEM_AXE_STRIP, SoundCategory.BLOCKS, 1.0F, 1.0F);
            world.setBlockState(pos, this.block.get().getDefaultState().with(AXIS, state.get(AXIS)));
            return ActionResultType.SUCCESS;
        }
        return ActionResultType.PASS;
    }

    @Override
    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
        if(ItemStackUtils.isInGroup(this.asItem(), group)) {
            int targetIndex = ItemStackUtils.findIndexOfItem(Items.DARK_OAK_LOG, items);
            if(targetIndex != -1) {
                items.add(targetIndex + 1, new ItemStack(this));
            } else {
                super.fillItemGroup(group, items);
            }
        }
    }
}
