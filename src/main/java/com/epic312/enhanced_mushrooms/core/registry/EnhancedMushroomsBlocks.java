package com.epic312.enhanced_mushrooms.core.registry;

import com.epic312.enhanced_mushrooms.common.block.*;
import com.epic312.enhanced_mushrooms.core.EnhancedMushrooms;
import com.epic312.enhanced_mushrooms.core.registry.util.EMRegistryHelper;
import com.mojang.datafixers.util.Pair;
import com.teamabnormals.abnormals_core.common.blocks.AbnormalsBeehiveBlock;
import com.teamabnormals.abnormals_core.common.blocks.AbnormalsLadderBlock;
import com.teamabnormals.abnormals_core.common.blocks.BookshelfBlock;
import com.teamabnormals.abnormals_core.common.blocks.VerticalSlabBlock;
import com.teamabnormals.abnormals_core.common.blocks.chest.AbnormalsChestBlock;
import com.teamabnormals.abnormals_core.common.blocks.chest.AbnormalsTrappedChestBlock;
import com.teamabnormals.abnormals_core.common.blocks.sign.AbnormalsStandingSignBlock;
import com.teamabnormals.abnormals_core.common.blocks.sign.AbnormalsWallSignBlock;
import com.teamabnormals.abnormals_core.common.blocks.wood.*;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.common.property.Properties;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

// Registry code originally written by bageldotjpg for the Atmospheric mod
@Mod.EventBusSubscriber(modid = EnhancedMushrooms.MODID, bus=Mod.EventBusSubscriber.Bus.MOD)
public class EnhancedMushroomsBlocks {
    private static Block.Properties addLight(Block.Properties properties, int lightValue) {
        return properties.func_235838_a_((p_235464_0_) -> {return lightValue;});
    }
    public static final EMRegistryHelper HELPER = EnhancedMushrooms.REGISTRY_HELPER;

    // red mushroom blocks
    public static final RegistryObject<Block> STRIPPED_RED_MUSHROOM_STEM = HELPER.createBlock("stripped_red_mushroom_stem", ()->new StrippedLogBlock(Block.Properties.from(Blocks.STRIPPED_OAK_LOG)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> RED_MUSHROOM_STEM = HELPER.createBlock("red_mushroom_stem", ()->new AbnormalsStemBlock(STRIPPED_RED_MUSHROOM_STEM, Block.Properties.from(Blocks.OAK_LOG)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_RED_MUSHROOM_HYPHAE = HELPER.createBlock("stripped_red_mushroom_hyphae", ()->new StrippedWoodBlock(Block.Properties.from(Blocks.STRIPPED_OAK_WOOD)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> RED_MUSHROOM_HYPHAE = HELPER.createBlock("red_mushroom_hyphae", ()->new WoodBlock(STRIPPED_RED_MUSHROOM_HYPHAE, Block.Properties.from(Blocks.OAK_WOOD)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> RED_MUSHROOM_PLANKS = HELPER.createBlock("red_mushroom_planks", ()->new PlanksBlock(Block.Properties.from(Blocks.OAK_PLANKS)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> RED_MUSHROOM_SLAB = HELPER.createBlock("red_mushroom_slab", ()->new WoodSlabBlock(Block.Properties.from(Blocks.OAK_SLAB)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> RED_MUSHROOM_STAIRS = HELPER.createBlock("red_mushroom_stairs", ()->new WoodStairsBlock(RED_MUSHROOM_PLANKS.get().getDefaultState(), Block.Properties.from(Blocks.OAK_STAIRS)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> RED_MUSHROOM_PRESSURE_PLATE = HELPER.createBlock("red_mushroom_pressure_plate", ()->new WoodPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, Block.Properties.from(Blocks.OAK_PRESSURE_PLATE)), ItemGroup.REDSTONE);
    public static final RegistryObject<Block> RED_MUSHROOM_FENCE = HELPER.createBlock("red_mushroom_fence", ()->new WoodFenceBlock(Block.Properties.from(Blocks.OAK_FENCE)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> RED_MUSHROOM_FENCE_GATE = HELPER.createBlock("red_mushroom_fence_gate", ()->new WoodFenceGateBlock(Block.Properties.from(Blocks.OAK_FENCE_GATE)), ItemGroup.REDSTONE);
    public static final RegistryObject<Block> RED_MUSHROOM_BUTTON = HELPER.createBlock("red_mushroom_button", ()->new AbnormalsWoodButtonBlock(Block.Properties.from(Blocks.OAK_BUTTON)), ItemGroup.REDSTONE);
    public static final RegistryObject<Block> RED_MUSHROOM_TRAPDOOR = HELPER.createBlock("red_mushroom_trapdoor", ()->new WoodTrapDoorBlock(Block.Properties.from(Blocks.OAK_TRAPDOOR)), ItemGroup.REDSTONE);
    public static final RegistryObject<Block> RED_MUSHROOM_DOOR = HELPER.createBlock("red_mushroom_door", ()->new WoodDoorBlock(Block.Properties.from(Blocks.OAK_DOOR)), ItemGroup.REDSTONE);
    public static final Pair<RegistryObject<AbnormalsStandingSignBlock>, RegistryObject<AbnormalsWallSignBlock>> RED_MUSHROOM_SIGNS = HELPER.createSignBlock("red_mushroom", MaterialColor.ADOBE);

    public static final RegistryObject<Block> VERTICAL_RED_MUSHROOM_PLANKS = HELPER.createCompatBlock("quark","vertical_red_mushroom_planks", ()->new Block(Block.Properties.from(Blocks.OAK_PLANKS)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> RED_MUSHROOM_VERTICAL_SLAB = HELPER.createCompatBlock("quark","red_mushroom_vertical_slab", ()->new VerticalSlabBlock(Block.Properties.from(Blocks.OAK_PLANKS)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> RED_MUSHROOM_BOOKSHELF = HELPER.createCompatBlock("quark","red_mushroom_bookshelf", ()->new BookshelfBlock(Block.Properties.from(Blocks.BOOKSHELF)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> RED_MUSHROOM_LADDER = HELPER.createCompatBlock("quark","red_mushroom_ladder", ()->new AbnormalsLadderBlock(Block.Properties.from(Blocks.LADDER).harvestTool(ToolType.AXE)), ItemGroup.DECORATIONS);
    //public static final Pair<RegistryObject<AbnormalsChestBlock>, RegistryObject<AbnormalsTrappedChestBlock>> RED_MUSHROOM_CHESTS = HELPER.createCompatChestBlocks("red_mushroom", MaterialColor.ADOBE);

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
    public static final RegistryObject<Block> BROWN_MUSHROOM_FENCE = HELPER.createBlock("brown_mushroom_fence", ()->new WoodFenceBlock(Block.Properties.from(Blocks.OAK_FENCE)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> BROWN_MUSHROOM_FENCE_GATE = HELPER.createBlock("brown_mushroom_fence_gate", ()->new WoodFenceGateBlock(Block.Properties.from(Blocks.OAK_FENCE_GATE)), ItemGroup.REDSTONE);
    public static final RegistryObject<Block> BROWN_MUSHROOM_BUTTON = HELPER.createBlock("brown_mushroom_button", ()->new AbnormalsWoodButtonBlock(Block.Properties.from(Blocks.OAK_BUTTON)), ItemGroup.REDSTONE);
    public static final RegistryObject<Block> BROWN_MUSHROOM_TRAPDOOR = HELPER.createBlock("brown_mushroom_trapdoor", ()->new WoodTrapDoorBlock(Block.Properties.from(Blocks.OAK_TRAPDOOR)), ItemGroup.REDSTONE);
    public static final RegistryObject<Block> BROWN_MUSHROOM_DOOR = HELPER.createBlock("brown_mushroom_door", ()->new WoodDoorBlock(Block.Properties.from(Blocks.OAK_DOOR)), ItemGroup.REDSTONE);
    public static final Pair<RegistryObject<AbnormalsStandingSignBlock>, RegistryObject<AbnormalsWallSignBlock>> BROWN_MUSHROOM_SIGNS = HELPER.createSignBlock("brown_mushroom", MaterialColor.BROWN);

    public static final RegistryObject<Block> VERTICAL_BROWN_MUSHROOM_PLANKS = HELPER.createCompatBlock("quark","vertical_brown_mushroom_planks", ()->new Block(Block.Properties.from(Blocks.OAK_PLANKS)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> BROWN_MUSHROOM_VERTICAL_SLAB = HELPER.createCompatBlock("quark","brown_mushroom_vertical_slab", ()->new VerticalSlabBlock(Block.Properties.from(Blocks.OAK_PLANKS)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> BROWN_MUSHROOM_BOOKSHELF = HELPER.createCompatBlock("quark","brown_mushroom_bookshelf", ()->new BookshelfBlock(Block.Properties.from(Blocks.BOOKSHELF)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> BROWN_MUSHROOM_LADDER = HELPER.createCompatBlock("quark","brown_mushroom_ladder", ()->new AbnormalsLadderBlock(Block.Properties.from(Blocks.LADDER).harvestTool(ToolType.AXE)), ItemGroup.DECORATIONS);
    public static final Pair<RegistryObject<AbnormalsChestBlock>, RegistryObject<AbnormalsTrappedChestBlock>> BROWN_MUSHROOM_CHESTS = HELPER.createCompatChestBlocks("brown_mushroom", MaterialColor.BROWN);

    public static final RegistryObject<Block> BROWN_MUSHROOM_BEEHIVE = HELPER.createCompatBlock("buzzier_bees","brown_mushroom_beehive", ()->new AbnormalsBeehiveBlock(Block.Properties.from(Blocks.BEEHIVE)), ItemGroup.DECORATIONS);

    // glowshroom blocks (if Quark is installed)
    // NOTE: until mappings are really finished func_235838_a_((p_235464_0_) -> {return x;}) is lightValue(x), so I've made a little function to do that for me for now
    public static final RegistryObject<Block> GLOWSHROOM_CAP = HELPER.createCompatBlock("quark","glowshroom_cap", ()->new GlowshroomCapBlock(addLight(Block.Properties.from(Blocks.RED_MUSHROOM_BLOCK).notSolid().harvestTool(ToolType.HOE), 14)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> STRIPPED_GLOWSHROOM_STEM = HELPER.createCompatBlock("quark","stripped_glowshroom_stem", ()->new AlphaStrippedLogBlock(addLight(Block.Properties.from(Blocks.STRIPPED_OAK_LOG).notSolid(), 14)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> GLOWSHROOM_STEM = HELPER.createCompatBlock("quark","glowshroom_stem", ()->new AlphaAbnormalsStemBlock(STRIPPED_GLOWSHROOM_STEM, addLight(Block.Properties.from(Blocks.OAK_LOG).notSolid(), 14)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_GLOWSHROOM_HYPHAE = HELPER.createCompatBlock("quark","stripped_glowshroom_hyphae", ()->new AlphaStrippedWoodBlock(addLight(Block.Properties.from(Blocks.STRIPPED_OAK_WOOD).notSolid(),14)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> GLOWSHROOM_HYPHAE = HELPER.createCompatBlock("quark","glowshroom_hyphae", ()->new AlphaWoodBlock(STRIPPED_GLOWSHROOM_HYPHAE, addLight(Block.Properties.from(Blocks.OAK_WOOD).notSolid(),14)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> GLOWSHROOM_PLANKS = HELPER.createCompatBlock("quark","glowshroom_planks", ()->new AlphaPlanksBlock(addLight(Block.Properties.from(Blocks.OAK_PLANKS).notSolid(),14)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> GLOWSHROOM_SLAB = HELPER.createCompatBlock("quark","glowshroom_slab", ()->new AlphaWoodSlabBlock(addLight(Block.Properties.from(Blocks.OAK_SLAB).notSolid(), 14)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> GLOWSHROOM_STAIRS = HELPER.createCompatBlock("quark","glowshroom_stairs", ()->new AlphaWoodStairsBlock(BROWN_MUSHROOM_PLANKS.get().getDefaultState(), addLight(Block.Properties.from(Blocks.OAK_STAIRS).notSolid(),14)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> GLOWSHROOM_PRESSURE_PLATE = HELPER.createCompatBlock("quark","glowshroom_pressure_plate", ()->new WoodPressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, addLight(Block.Properties.from(Blocks.OAK_PRESSURE_PLATE).notSolid(),14)), ItemGroup.REDSTONE);
    public static final RegistryObject<Block> GLOWSHROOM_FENCE = HELPER.createCompatBlock("quark","glowshroom_fence", ()->new AlphaWoodFenceBlock(addLight(Block.Properties.from(Blocks.OAK_FENCE).notSolid(),14)), ItemGroup.DECORATIONS);
    public static final RegistryObject<Block> GLOWSHROOM_FENCE_GATE = HELPER.createCompatBlock("quark","glowshroom_fence_gate", ()->new AlphaWoodFenceGateBlock(addLight(Block.Properties.from(Blocks.OAK_FENCE_GATE).notSolid(),14)), ItemGroup.REDSTONE);
    public static final RegistryObject<Block> GLOWSHROOM_BUTTON = HELPER.createCompatBlock("quark","glowshroom_button", ()->new AbnormalsWoodButtonBlock(addLight(Block.Properties.from(Blocks.OAK_BUTTON).notSolid(),14)), ItemGroup.REDSTONE);
    public static final RegistryObject<Block> GLOWSHROOM_TRAPDOOR = HELPER.createCompatBlock("quark","glowshroom_trapdoor", ()->new WoodTrapDoorBlock(addLight(Block.Properties.from(Blocks.OAK_TRAPDOOR).notSolid(),14)), ItemGroup.REDSTONE);
    public static final RegistryObject<Block> GLOWSHROOM_DOOR = HELPER.createCompatBlock("quark","glowshroom_door", ()->new WoodDoorBlock(addLight(Block.Properties.from(Blocks.OAK_DOOR).notSolid(),14)), ItemGroup.REDSTONE);
    public static final Pair<RegistryObject<AbnormalsStandingSignBlock>, RegistryObject<AbnormalsWallSignBlock>> GLOWSHROOM_SIGNS = HELPER.createCompatSignBlock("quark","glowshroom", MaterialColor.BLUE, addLight(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD),14));

    public static final RegistryObject<Block> VERTICAL_GLOWSHROOM_PLANKS = HELPER.createCompatBlock("quark","vertical_glowshroom_planks", ()->new AlphaBlock(addLight(Block.Properties.from(Blocks.OAK_PLANKS).notSolid(),14)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> GLOWSHROOM_VERTICAL_SLAB = HELPER.createCompatBlock("quark","glowshroom_vertical_slab", ()->new AlphaVerticalSlabBlock(addLight(Block.Properties.from(Blocks.OAK_PLANKS).notSolid(),14)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> GLOWSHROOM_BOOKSHELF = HELPER.createCompatBlock("quark","glowshroom_bookshelf", ()->new AlphaBookshelfBlock(addLight(Block.Properties.from(Blocks.BOOKSHELF).notSolid(),14)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> GLOWSHROOM_LADDER = HELPER.createCompatBlock("quark","glowshroom_ladder", ()->new AbnormalsLadderBlock(addLight(Block.Properties.from(Blocks.LADDER).harvestTool(ToolType.AXE).notSolid(),14)), ItemGroup.DECORATIONS);
    public static final Pair<RegistryObject<AbnormalsChestBlock>, RegistryObject<AbnormalsTrappedChestBlock>> GLOWSHROOM_CHESTS = HELPER.createCompatChestsWithProperties("glowshroom", addLight(net.minecraft.block.Block.Properties.create(Material.WOOD, MaterialColor.CYAN).hardnessAndResistance(2.5F).sound(SoundType.WOOD),14));

    public static final RegistryObject<Block> GLOWSHROOM_BEEHIVE = HELPER.createTwoCompatBlock("buzzier_bees","quark","glowshroom_beehive", ()->new AlphaAbnormalsBeehiveBlock(addLight(Block.Properties.from(Blocks.BEEHIVE).notSolid(),14)), ItemGroup.DECORATIONS);

}
