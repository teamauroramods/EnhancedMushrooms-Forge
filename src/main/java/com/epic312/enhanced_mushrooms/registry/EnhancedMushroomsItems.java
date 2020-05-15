package com.epic312.enhanced_mushrooms.registry;

import com.epic312.enhanced_mushrooms.EnhancedMushrooms;
import com.epic312.enhanced_mushrooms.util.EMRegistryHelper;
import com.teamabnormals.abnormals_core.core.utils.RegistryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = EnhancedMushrooms.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EnhancedMushroomsItems {
    public static final EMRegistryHelper HELPER = EnhancedMushrooms.REGISTRY_HELPER;

    public static final RegistryObject<Item> RED_MUSHROOM_BOAT = HELPER.createBoatItem("red_mushroom", EnhancedMushroomsBlocks.RED_MUSHROOM_PLANKS);
    public static final RegistryObject<Item> BROWN_MUSHROOM_BOAT = HELPER.createBoatItem("brown_mushroom", EnhancedMushroomsBlocks.BROWN_MUSHROOM_PLANKS);
    public static final RegistryObject<Item> GLOWSHROOM_BOAT = HELPER.createCompatBoatItem("quark","glowshroom", EnhancedMushroomsBlocks.GLOWSHROOM_PLANKS);

    public static final RegistryObject<Item> ROASTED_MUSHROOMS = HELPER.createItem("roasted_mushrooms", ()->new Item(new Item.Properties().food(EnhancedMushroomsFoods.ROASTED_MUSHROOMS).group(ItemGroup.FOOD)));
}
