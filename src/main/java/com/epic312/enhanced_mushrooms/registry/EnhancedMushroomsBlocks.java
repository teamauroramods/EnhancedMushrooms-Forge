package com.epic312.enhanced_mushrooms.registry;

import com.epic312.enhanced_mushrooms.EnhancedMushrooms;
import com.epic312.enhanced_mushrooms.util.RegistryUtils;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.LogBlock;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

// Registry code originally written by bageldotjpg for the Atmospheric mod
@Mod.EventBusSubscriber(modid = EnhancedMushrooms.MODID, bus=Mod.EventBusSubscriber.Bus.MOD)
public class EnhancedMushroomsBlocks {
    public static final DeferredRegister<Block> BLOCKS = new DeferredRegister<>(ForgeRegistries.BLOCKS, EnhancedMushrooms.MODID);

    // red mushroom blocks
    public static final RegistryObject<Block> RED_MUSHROOM_STEM = RegistryUtils.createBlock("red_mushroom_stem", ()->new LogBlock(MaterialColor.BROWN, Block.Properties.from(Blocks.OAK_LOG)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_RED_MUSHROOM_STEM = RegistryUtils.createBlock("stripped_red_mushroom_stem", ()->new LogBlock(MaterialColor.BROWN, Block.Properties.from(Blocks.STRIPPED_OAK_LOG)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> RED_MUSHROOM_HYPHAE = RegistryUtils.createBlock("red_mushroom_hyphae", ()->new RotatedPillarBlock(Block.Properties.from(Blocks.OAK_WOOD)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_RED_MUSHROOM_HYPHAE = RegistryUtils.createBlock("stripped_red_mushroom_hyphae", ()->new RotatedPillarBlock(Block.Properties.from(Blocks.STRIPPED_OAK_WOOD)), ItemGroup.BUILDING_BLOCKS);

    // brown mushroom blocks
    public static final RegistryObject<Block> BROWN_MUSHROOM_STEM = RegistryUtils.createBlock("brown_mushroom_stem", ()->new LogBlock(MaterialColor.BROWN, Block.Properties.from(Blocks.OAK_LOG)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_BROWN_MUSHROOM_STEM = RegistryUtils.createBlock("stripped_brown_mushroom_stem", ()->new LogBlock(MaterialColor.BROWN, Block.Properties.from(Blocks.STRIPPED_OAK_LOG)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> BROWN_MUSHROOM_HYPHAE = RegistryUtils.createBlock("brown_mushroom_hyphae", ()->new RotatedPillarBlock(Block.Properties.from(Blocks.OAK_WOOD)), ItemGroup.BUILDING_BLOCKS);
    public static final RegistryObject<Block> STRIPPED_BROWN_MUSHROOM_HYPHAE = RegistryUtils.createBlock("stripped_brown_mushroom_hyphae", ()->new RotatedPillarBlock(Block.Properties.from(Blocks.STRIPPED_OAK_WOOD)), ItemGroup.BUILDING_BLOCKS);

}
