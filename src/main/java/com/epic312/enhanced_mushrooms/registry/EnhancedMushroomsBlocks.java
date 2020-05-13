package com.epic312.enhanced_mushrooms.registry;

import com.epic312.enhanced_mushrooms.EnhancedMushrooms;
import com.teamabnormals.abnormals_core.common.blocks.wood.AbnormalsLogBlock;
import com.teamabnormals.abnormals_core.common.blocks.wood.StrippedLogBlock;
import com.teamabnormals.abnormals_core.common.blocks.wood.StrippedWoodBlock;
import com.teamabnormals.abnormals_core.common.blocks.wood.WoodBlock;
import com.teamabnormals.abnormals_core.core.utils.RegistryHelper;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

// Registry code originally written by bageldotjpg for the Atmospheric mod
@Mod.EventBusSubscriber(modid = EnhancedMushrooms.MODID, bus=Mod.EventBusSubscriber.Bus.MOD)
public class EnhancedMushroomsBlocks {
    public static final RegistryHelper HELPER = EnhancedMushrooms.REGISTRY_HELPER;

    // red mushroom blocks
    public static final RegistryObject<Block> STRIPPED_RED_MUSHROOM_STEM = HELPER.createBlock("stripped_red_mushroom_stem", ()->new StrippedLogBlock(Block.Properties.from(Blocks.STRIPPED_OAK_LOG)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> RED_MUSHROOM_STEM = HELPER.createBlock("red_mushroom_stem", ()->new AbnormalsLogBlock(STRIPPED_RED_MUSHROOM_STEM, MaterialColor.BROWN, Block.Properties.from(Blocks.OAK_LOG)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_RED_MUSHROOM_HYPHAE = HELPER.createBlock("stripped_red_mushroom_hyphae", ()->new StrippedWoodBlock(Block.Properties.from(Blocks.STRIPPED_OAK_WOOD)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> RED_MUSHROOM_HYPHAE = HELPER.createBlock("red_mushroom_hyphae", ()->new WoodBlock(STRIPPED_RED_MUSHROOM_HYPHAE, Block.Properties.from(Blocks.OAK_WOOD)), ItemGroup.BUILDING_BLOCKS);

    // brown mushroom blocks
    public static final RegistryObject<Block> STRIPPED_BROWN_MUSHROOM_STEM = HELPER.createBlock("stripped_brown_mushroom_stem", ()->new StrippedLogBlock(Block.Properties.from(Blocks.STRIPPED_OAK_LOG)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> BROWN_MUSHROOM_STEM = HELPER.createBlock("brown_mushroom_stem", ()->new AbnormalsLogBlock(STRIPPED_BROWN_MUSHROOM_STEM, MaterialColor.BROWN, Block.Properties.from(Blocks.OAK_LOG)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_BROWN_MUSHROOM_HYPHAE = HELPER.createBlock("stripped_brown_mushroom_hyphae", ()->new StrippedWoodBlock(Block.Properties.from(Blocks.STRIPPED_OAK_WOOD)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> BROWN_MUSHROOM_HYPHAE = HELPER.createBlock("brown_mushroom_hyphae", ()->new WoodBlock(STRIPPED_BROWN_MUSHROOM_HYPHAE, Block.Properties.from(Blocks.OAK_WOOD)), ItemGroup.BUILDING_BLOCKS);

}
