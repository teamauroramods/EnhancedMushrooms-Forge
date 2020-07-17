package com.epic312.enhanced_mushrooms.core.registry;

import net.minecraft.item.Food;

public class EnhancedMushroomsFoods {
    public static final Food ROASTED_MUSHROOMS = new Food.Builder().hunger(2).saturation((0.2F)).build();
    public static final Food BEEF_STEW = new Food.Builder().hunger(10).saturation(1.0F).build();
}
