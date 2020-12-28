package com.teamaurora.enhanced_mushrooms.core.library.api.conditions;

import com.google.gson.JsonObject;
import com.teamaurora.enhanced_mushrooms.core.EMConfig;
import com.teamaurora.enhanced_mushrooms.core.EnhancedMushrooms;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class EMFoodRecipeCondition implements ICondition {
    private final ResourceLocation location;

    public EMFoodRecipeCondition(ResourceLocation location) {
        this.location = location;
    }

    @Override
    public ResourceLocation getID() {
        return this.location;
    }

    @Override
    public boolean test() {
        return EMConfig.COMMON.foodItems.get();
    }

    public static class Serializer implements IConditionSerializer<EMFoodRecipeCondition> {
        private final ResourceLocation location;

        public Serializer() {
            this.location = new ResourceLocation(EnhancedMushrooms.MODID, "foods_enabled");
        }

        @Override
        public void write(JsonObject json, EMFoodRecipeCondition value) {}

        @Override
        public EMFoodRecipeCondition read(JsonObject json) {
            return new EMFoodRecipeCondition(this.location);
        }

        @Override
        public ResourceLocation getID() {
            return this.location;
        }
    }
}
