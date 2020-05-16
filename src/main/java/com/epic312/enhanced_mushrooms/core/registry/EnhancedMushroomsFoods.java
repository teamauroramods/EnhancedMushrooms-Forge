package com.epic312.enhanced_mushrooms.core.registry;

import com.epic312.enhanced_mushrooms.core.EnhancedMushrooms;
import net.minecraft.item.Food;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EnhancedMushrooms.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class EnhancedMushroomsFoods {
    public static Food ROASTED_MUSHROOMS = new Food.Builder().hunger(4).saturation((0.2F)).build();
}
