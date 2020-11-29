package com.epic312.enhanced_mushrooms.core.registry;

import com.epic312.enhanced_mushrooms.core.EnhancedMushrooms;

import net.minecraft.block.Block;
import net.minecraft.block.HugeMushroomBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

@Mod.EventBusSubscriber(modid = EnhancedMushrooms.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EnhancedMushroomsOverrides {
	@ObjectHolder("minecraft:red_mushroom_block")
	public static final Block RED_MUSHROOM_BLOCK = null;
	
	@ObjectHolder("minecraft:brown_mushroom_block")
	public static final Block BROWN_MUSHROOM_BLOCK = null;
	
	@SubscribeEvent
	public static void registerBlocks(RegistryEvent.Register<Block> event) {
		event.getRegistry().registerAll(
				new HugeMushroomBlock(Block.Properties.create(Material.ORGANIC, MaterialColor.RED).hardnessAndResistance(0.1F).sound(SoundType.field_235588_J_).harvestTool(ToolType.HOE)).setRegistryName("minecraft:red_mushroom_block"),
				new HugeMushroomBlock(Block.Properties.create(Material.ORGANIC, MaterialColor.DIRT).hardnessAndResistance(0.1F).sound(SoundType.field_235588_J_).harvestTool(ToolType.HOE)).setRegistryName("minecraft:brown_mushroom_block")
				);
	}
}
