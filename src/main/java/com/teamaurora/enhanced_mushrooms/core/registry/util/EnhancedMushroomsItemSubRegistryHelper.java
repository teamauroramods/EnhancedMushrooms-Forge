package com.teamaurora.enhanced_mushrooms.core.registry.util;

import com.minecraftabnormals.abnormals_core.common.items.AbnormalsBoatItem;
import com.minecraftabnormals.abnormals_core.core.registry.BoatRegistry;
import com.minecraftabnormals.abnormals_core.core.util.registry.ItemSubRegistryHelper;
import com.minecraftabnormals.abnormals_core.core.util.registry.RegistryHelper;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;

public class EnhancedMushroomsItemSubRegistryHelper extends ItemSubRegistryHelper {
    public EnhancedMushroomsItemSubRegistryHelper(RegistryHelper helper) {
        super(helper);
    }

    public RegistryObject<Item> createCompatBoatItem(String wood, RegistryObject<Block> block, String modid) {
        String type = this.parent.getModId() + ":" + wood;
        ItemGroup determinedGroup = !ModList.get().isLoaded(modid) && modid != "indev" ? null : ItemGroup.TRANSPORTATION;
        RegistryObject<Item> boat = this.deferredRegister.register(wood + "_boat", () -> {
            return new AbnormalsBoatItem(type, createSimpleItemProperty(1, determinedGroup));
        });
        BoatRegistry.registerBoat(type, boat, block);
        return boat;
    }
}
