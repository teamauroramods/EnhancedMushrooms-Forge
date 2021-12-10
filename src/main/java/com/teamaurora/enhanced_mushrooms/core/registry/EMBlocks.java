package com.teamaurora.enhanced_mushrooms.core.registry;

import com.minecraftabnormals.abnormals_core.common.blocks.wood.*;
import com.teamaurora.enhanced_mushrooms.common.block.AbnormalsStemBlock;
import com.teamaurora.enhanced_mushrooms.core.EnhancedMushrooms;
import com.mojang.datafixers.util.Pair;
import com.minecraftabnormals.abnormals_core.common.blocks.AbnormalsBeehiveBlock;
import com.minecraftabnormals.abnormals_core.common.blocks.AbnormalsLadderBlock;
import com.minecraftabnormals.abnormals_core.common.blocks.BookshelfBlock;
import com.minecraftabnormals.abnormals_core.common.blocks.VerticalSlabBlock;
import com.minecraftabnormals.abnormals_core.common.blocks.chest.AbnormalsChestBlock;
import com.minecraftabnormals.abnormals_core.common.blocks.chest.AbnormalsTrappedChestBlock;
import com.minecraftabnormals.abnormals_core.common.blocks.sign.AbnormalsStandingSignBlock;
import com.minecraftabnormals.abnormals_core.common.blocks.sign.AbnormalsWallSignBlock;

import com.teamaurora.enhanced_mushrooms.core.registry.util.EMBlockSubRegistryHelper;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EnhancedMushrooms.MODID, bus=Mod.EventBusSubscriber.Bus.MOD)
public class EMBlocks {
    public static final EMBlockSubRegistryHelper HELPER = EnhancedMushrooms.REGISTRY_HELPER.getBlockSubHelper();

    // red mushroom blocks
    public static final RegistryObject<Block> STRIPPED_RED_MUSHROOM_STEM = HELPER.createBlock("stripped_red_mushroom_stem", ()->new StrippedLogBlock(Block.Properties.from(Blocks.STRIPPED_OAK_LOG)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> RED_MUSHROOM_STEM = HELPER.createBlock("red_mushroom_stem", ()->new AbnormalsStemBlock(STRIPPED_RED_MUSHROOM_STEM, Block.Properties.from(Blocks.OAK_LOG)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_RED_MUSHROOM_HYPHAE = HELPER.createBlock("stripped_red_mushroom_hyphae", ()->new StrippedWoodBlock(Block.Properties.from(Blocks.STRIPPED_OAK_WOOD)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> RED_MUSHROOM_HYPHAE = HELPER.createBlock("red_mushroom_hyphae", ()->new WoodBlock(STRIPPED_RED_MUSHROOM_HYPHAE, Block.Properties.from(Blocks.OAK_WOOD)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> RED_MUSHROOM_PLANKS = HELPER.createBlock("red_mushroom_planks", ()->new PlanksBlock(Block.Properties.from(Blocks.OAK_PLANKS)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> RED_MUSHROOM_SLAB = HELPER.createBlock("red_mushroom_slab", ()->new WoodSlabBlock(Block.Properties.from(Blocks.OAK_SLAB)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> RED_MUSHROOM_STAIRS = HELPER.createBlock("red_mushroom_stairs", ()->new WoodStairsBlock(RED_MUSHROOM_PLANKS.get().getDefaultState(), Block.Properties.from(Blocks.OAK_STAIRS)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> RED_MUSHROOM_PRESSURE_PLATE = HELPER.createBlock("red_mushroom_pressure_plate", ()->new WoodPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.from(Blocks.OAK_PRESSURE_PLATE)), ItemGroup.REDSTONE);
    public static final RegistryObject<Block> RED_MUSHROOM_FENCE = HELPER.createFuelBlock("red_mushroom_fence", ()->new WoodFenceBlock(Block.Properties.from(Blocks.OAK_FENCE)), 300, ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> RED_MUSHROOM_FENCE_GATE = HELPER.createFuelBlock("red_mushroom_fence_gate", ()->new WoodFenceGateBlock(Block.Properties.from(Blocks.OAK_FENCE_GATE)), 300, ItemGroup.REDSTONE);
    public static final RegistryObject<Block> RED_MUSHROOM_BUTTON = HELPER.createBlock("red_mushroom_button", ()->new AbnormalsWoodButtonBlock(Block.Properties.from(Blocks.OAK_BUTTON)), ItemGroup.REDSTONE);
    public static final RegistryObject<Block> RED_MUSHROOM_TRAPDOOR = HELPER.createBlock("red_mushroom_trapdoor", ()->new WoodTrapDoorBlock(Block.Properties.from(Blocks.OAK_TRAPDOOR)), ItemGroup.REDSTONE);
    public static final RegistryObject<Block> RED_MUSHROOM_DOOR = HELPER.createBlock("red_mushroom_door", ()->new WoodDoorBlock(Block.Properties.from(Blocks.OAK_DOOR)), ItemGroup.REDSTONE);
    public static final Pair<RegistryObject<AbnormalsStandingSignBlock>, RegistryObject<AbnormalsWallSignBlock>> RED_MUSHROOM_SIGNS = HELPER.createSignBlock("red_mushroom", MaterialColor.ADOBE);

    public static final RegistryObject<Block> RED_MUSHROOM_VERTICAL_SLAB = HELPER.createCompatFuelBlock("quark","red_mushroom_vertical_slab", ()->new VerticalSlabBlock(Block.Properties.from(Blocks.OAK_PLANKS)), 150, ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> RED_MUSHROOM_BOOKSHELF = HELPER.createCompatFuelBlock("quark","red_mushroom_bookshelf", ()->new BookshelfBlock(Block.Properties.from(Blocks.BOOKSHELF)), 300, ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> RED_MUSHROOM_LADDER = HELPER.createCompatFuelBlock("quark","red_mushroom_ladder", ()->new AbnormalsLadderBlock(Block.Properties.from(Blocks.LADDER).harvestTool(ToolType.AXE)), 300, ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> STRIPPED_RED_MUSHROOM_POST = HELPER.createCompatFuelBlock("quark", "stripped_red_mushroom_post", () -> new WoodPostBlock(AbstractBlock.Properties.from(Blocks.OAK_FENCE)), 300, ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> RED_MUSHROOM_POST = HELPER.createCompatFuelBlock("quark", "red_mushroom_post", () -> new WoodPostBlock(STRIPPED_RED_MUSHROOM_POST, AbstractBlock.Properties.from(Blocks.OAK_FENCE)), 300, ItemGroup.BUILDING_BLOCKS);

    public static final RegistryObject<Block> RED_MUSHROOM_BEEHIVE = HELPER.createCompatBlock("buzzier_bees","red_mushroom_beehive", ()->new AbnormalsBeehiveBlock(Block.Properties.from(Blocks.BEEHIVE)), ItemGroup.DECORATIONS);

    // brown mushroom blocks
    public static final RegistryObject<Block> STRIPPED_BROWN_MUSHROOM_STEM = HELPER.createBlock("stripped_brown_mushroom_stem", ()->new StrippedLogBlock(Block.Properties.from(Blocks.STRIPPED_OAK_LOG)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> BROWN_MUSHROOM_STEM = HELPER.createBlock("brown_mushroom_stem", ()->new AbnormalsStemBlock(STRIPPED_BROWN_MUSHROOM_STEM, Block.Properties.from(Blocks.OAK_LOG)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_BROWN_MUSHROOM_HYPHAE = HELPER.createBlock("stripped_brown_mushroom_hyphae", ()->new StrippedWoodBlock(Block.Properties.from(Blocks.STRIPPED_OAK_WOOD)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> BROWN_MUSHROOM_HYPHAE = HELPER.createBlock("brown_mushroom_hyphae", ()->new WoodBlock(STRIPPED_BROWN_MUSHROOM_HYPHAE, Block.Properties.from(Blocks.OAK_WOOD)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> BROWN_MUSHROOM_PLANKS = HELPER.createBlock("brown_mushroom_planks", ()->new PlanksBlock(Block.Properties.from(Blocks.OAK_PLANKS)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> BROWN_MUSHROOM_SLAB = HELPER.createBlock("brown_mushroom_slab", ()->new WoodSlabBlock(Block.Properties.from(Blocks.OAK_SLAB)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> BROWN_MUSHROOM_STAIRS = HELPER.createBlock("brown_mushroom_stairs", ()->new WoodStairsBlock(BROWN_MUSHROOM_PLANKS.get().getDefaultState(), Block.Properties.from(Blocks.OAK_STAIRS)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> BROWN_MUSHROOM_PRESSURE_PLATE = HELPER.createBlock("brown_mushroom_pressure_plate", ()->new WoodPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.from(Blocks.OAK_PRESSURE_PLATE)), ItemGroup.REDSTONE);
    public static final RegistryObject<Block> BROWN_MUSHROOM_FENCE = HELPER.createFuelBlock("brown_mushroom_fence", ()->new WoodFenceBlock(Block.Properties.from(Blocks.OAK_FENCE)), 300, ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> BROWN_MUSHROOM_FENCE_GATE = HELPER.createFuelBlock("brown_mushroom_fence_gate", ()->new WoodFenceGateBlock(Block.Properties.from(Blocks.OAK_FENCE_GATE)), 300, ItemGroup.REDSTONE);
    public static final RegistryObject<Block> BROWN_MUSHROOM_BUTTON = HELPER.createBlock("brown_mushroom_button", ()->new AbnormalsWoodButtonBlock(Block.Properties.from(Blocks.OAK_BUTTON)), ItemGroup.REDSTONE);
    public static final RegistryObject<Block> BROWN_MUSHROOM_TRAPDOOR = HELPER.createBlock("brown_mushroom_trapdoor", ()->new WoodTrapDoorBlock(Block.Properties.from(Blocks.OAK_TRAPDOOR)), ItemGroup.REDSTONE);
    public static final RegistryObject<Block> BROWN_MUSHROOM_DOOR = HELPER.createBlock("brown_mushroom_door", ()->new WoodDoorBlock(Block.Properties.from(Blocks.OAK_DOOR)), ItemGroup.REDSTONE);
    public static final Pair<RegistryObject<AbnormalsStandingSignBlock>, RegistryObject<AbnormalsWallSignBlock>> BROWN_MUSHROOM_SIGNS = HELPER.createSignBlock("brown_mushroom", MaterialColor.BROWN);

    public static final RegistryObject<Block> BROWN_MUSHROOM_VERTICAL_SLAB = HELPER.createCompatFuelBlock("quark","brown_mushroom_vertical_slab", ()->new VerticalSlabBlock(Block.Properties.from(Blocks.OAK_PLANKS)), 150, ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> BROWN_MUSHROOM_BOOKSHELF = HELPER.createCompatFuelBlock("quark","brown_mushroom_bookshelf", ()->new BookshelfBlock(Block.Properties.from(Blocks.BOOKSHELF)), 300, ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> BROWN_MUSHROOM_LADDER = HELPER.createCompatFuelBlock("quark","brown_mushroom_ladder", ()->new AbnormalsLadderBlock(Block.Properties.from(Blocks.LADDER).harvestTool(ToolType.AXE)), 300, ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> STRIPPED_BROWN_MUSHROOM_POST = HELPER.createCompatFuelBlock("quark", "stripped_brown_mushroom_post", () -> new WoodPostBlock(AbstractBlock.Properties.from(Blocks.OAK_FENCE)), 300, ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> BROWN_MUSHROOM_POST = HELPER.createCompatFuelBlock("quark", "brown_mushroom_post", () -> new WoodPostBlock(STRIPPED_BROWN_MUSHROOM_POST, AbstractBlock.Properties.from(Blocks.OAK_FENCE)), 300, ItemGroup.BUILDING_BLOCKS);
    public static final Pair<RegistryObject<AbnormalsChestBlock>, RegistryObject<AbnormalsTrappedChestBlock>> BROWN_MUSHROOM_CHESTS = HELPER.createCompatChestBlocks("quark", "brown_mushroom", MaterialColor.BROWN);

    public static final RegistryObject<Block> BROWN_MUSHROOM_BEEHIVE = HELPER.createCompatBlock("buzzier_bees","brown_mushroom_beehive", ()->new AbnormalsBeehiveBlock(Block.Properties.from(Blocks.BEEHIVE)), ItemGroup.DECORATIONS);

}
