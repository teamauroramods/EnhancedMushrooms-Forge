package com.teamaurora.enhanced_mushrooms.core.registry;

import com.minecraftabnormals.abnormals_core.core.util.registry.ItemSubRegistryHelper;
import com.minecraftabnormals.abnormals_core.core.util.registry.RegistryHelper;
import com.teamaurora.enhanced_mushrooms.core.EnhancedMushrooms;

import com.teamaurora.enhanced_mushrooms.core.registry.util.EnhancedMushroomsItemSubRegistryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SoupItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EnhancedMushrooms.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EnhancedMushroomsItems {
    public static final EnhancedMushroomsItemSubRegistryHelper HELPER = EnhancedMushrooms.REGISTRY_HELPER.getItemSubHelper();

    public static final RegistryObject<Item> RED_MUSHROOM_BOAT = HELPER.createBoatItem("red_mushroom", EnhancedMushroomsBlocks.RED_MUSHROOM_PLANKS);
    public static final RegistryObject<Item> BROWN_MUSHROOM_BOAT = HELPER.createBoatItem("brown_mushroom", EnhancedMushroomsBlocks.BROWN_MUSHROOM_PLANKS);
    public static final RegistryObject<Item> GLOWSHROOM_BOAT = HELPER.createCompatBoatItem("glowshroom", EnhancedMushroomsBlocks.GLOWSHROOM_PLANKS, "quark");

    public static final RegistryObject<Item> ROASTED_MUSHROOMS = HELPER.createItem("roasted_mushrooms", ()->new Item(new Item.Properties().food(EnhancedMushroomsFoods.ROASTED_MUSHROOMS).group(ItemGroup.FOOD)));
    public static final RegistryObject<Item> BEEF_STEW = HELPER.createItem("beef_stew", ()->new SoupItem(new Item.Properties().maxStackSize(1).food(EnhancedMushroomsFoods.BEEF_STEW).group(ItemGroup.FOOD)));
}
