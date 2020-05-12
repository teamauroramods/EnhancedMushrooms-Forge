package com.epic312.enhanced_mushrooms.util;

import com.epic312.enhanced_mushrooms.EnhancedMushrooms;
import com.epic312.enhanced_mushrooms.registry.EnhancedMushroomsBlocks;
import com.epic312.enhanced_mushrooms.registry.EnhancedMushroomsItems;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

// code originally made by bageldotjpg, it's really useful for compact registries so I decided to stick it in here
public class RegistryUtils {
    public static <I extends Item> RegistryObject<I> createItem(String name, Supplier<? extends I> supplier) {
        RegistryObject<I> item = EnhancedMushroomsItems.ITEMS.register(name, supplier);
        return item;
    }

    public static BlockItem createSimpleItemBlock(Block block, ItemGroup itemGroup) {
        return (BlockItem) new BlockItem(block, new Item.Properties().group(itemGroup)).setRegistryName(block.getRegistryName());
    }

    public static <B extends Block> RegistryObject<B> createBlock(String name, Supplier<? extends B> supplier, ItemGroup itemGroup) {
        RegistryObject<B> block = EnhancedMushroomsBlocks.BLOCKS.register(name, supplier);
        EnhancedMushroomsItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().group(itemGroup)));
        return block;
    }

    public static <B extends Block> RegistryObject<B> createBlockCompat(String mod, String name, Supplier<? extends B> supplier, ItemGroup itemGroup) {
        ItemGroup determinedGroup = ModList.get().isLoaded(mod) || mod == "indev" ? itemGroup : null;
        RegistryObject<B> block = EnhancedMushroomsBlocks.BLOCKS.register(name, supplier);
        EnhancedMushroomsItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().group(determinedGroup)));
        return block;
    }

    public static <B extends Block> RegistryObject<B> createBlockNoItem(String name, Supplier<? extends B> supplier) {
        RegistryObject<B> block = EnhancedMushroomsBlocks.BLOCKS.register(name, supplier);
        return block;
    }
}
