package com.teamaurora.enhanced_mushrooms.common.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.SoupItem;

import java.util.function.Supplier;

public class DynamicItemGroupSoupItem extends SoupItem {

    private final Supplier<ItemGroup> optionalGroup;

    public DynamicItemGroupSoupItem(Properties builder, Supplier<ItemGroup> itemGroupSupplier) {
        super(builder);
        this.optionalGroup = itemGroupSupplier;
    }

    @Override
    public ItemGroup getGroup() {
        return this.optionalGroup.get();
    }
}
