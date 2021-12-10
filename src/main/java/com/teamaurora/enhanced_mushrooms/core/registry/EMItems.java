package com.teamaurora.enhanced_mushrooms.core.registry;

import com.teamaurora.enhanced_mushrooms.common.item.DynamicItemGroupItem;
import com.teamaurora.enhanced_mushrooms.common.item.DynamicItemGroupSoupItem;
import com.teamaurora.enhanced_mushrooms.core.EMConfig;
import com.teamaurora.enhanced_mushrooms.core.EnhancedMushrooms;

import com.teamaurora.enhanced_mushrooms.core.registry.util.EMItemSubRegistryHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SoupItem;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = EnhancedMushrooms.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EMItems {
    public static final EMItemSubRegistryHelper HELPER = EnhancedMushrooms.REGISTRY_HELPER.getItemSubHelper();

    public static final RegistryObject<Item> RED_MUSHROOM_BOAT = HELPER.createBoatItem("red_mushroom", EMBlocks.RED_MUSHROOM_PLANKS);
    public static final RegistryObject<Item> BROWN_MUSHROOM_BOAT = HELPER.createBoatItem("brown_mushroom", EMBlocks.BROWN_MUSHROOM_PLANKS);

    public static final RegistryObject<Item> ROASTED_MUSHROOMS = HELPER.createItem("roasted_mushrooms", ()->new DynamicItemGroupItem(new Item.Properties().food(EMFoods.ROASTED_MUSHROOMS), foodGroup()));
    public static final RegistryObject<Item> BEEF_STEW = HELPER.createItem("beef_stew", ()->new DynamicItemGroupSoupItem(new Item.Properties().maxStackSize(1).food(EMFoods.BEEF_STEW), foodGroup()));

    private static Supplier<ItemGroup> foodGroup() {
        return () -> EMConfig.COMMON.foodItems.get() ? ItemGroup.FOOD : null;
    }
}
