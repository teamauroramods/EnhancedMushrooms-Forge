package com.teamaurora.enhanced_mushrooms.core;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class EnhancedMushroomsConfig {
    public static class Common {
        public final ForgeConfigSpec.ConfigValue<Boolean> capsStrippable;

        Common(ForgeConfigSpec.Builder builder) {
            builder.comment("Common configurations for Enhanced Mushrooms").push("common");

            capsStrippable = builder.define("Whether mushroom blocks should be strippable with an axe", true);

            builder.pop();
        }
    }

    public static final ForgeConfigSpec COMMON_SPEC;
    public static final Common COMMON;
    static {
        final Pair<Common, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(Common::new);
        COMMON_SPEC = specPair.getRight();
        COMMON = specPair.getLeft();
    }
}
