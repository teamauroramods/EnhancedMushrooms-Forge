package com.epic312.enhanced_mushrooms.core.registry.util;

import com.mojang.datafixers.util.Pair;
import com.teamabnormals.abnormals_core.common.blocks.chest.AbnormalsChestBlock;
import com.teamabnormals.abnormals_core.common.blocks.chest.AbnormalsTrappedChestBlock;
import com.teamabnormals.abnormals_core.common.blocks.sign.AbnormalsStandingSignBlock;
import com.teamabnormals.abnormals_core.common.blocks.sign.AbnormalsWallSignBlock;
import com.teamabnormals.abnormals_core.common.items.AbnormalsBoatItem;
import com.teamabnormals.abnormals_core.common.items.AbnormalsSignItem;
import com.teamabnormals.abnormals_core.core.registry.BoatRegistry;
import com.teamabnormals.abnormals_core.core.utils.RegistryHelper;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.property.Properties;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;

import javax.annotation.Nullable;
import java.util.function.Supplier;

public class EMRegistryHelper extends RegistryHelper {

    public EMRegistryHelper (String modID) {
        super(modID);
    }

    public RegistryObject<Item> createCompatBoatItem(String modId, String wood, RegistryObject<Block> block) {
        ItemGroup determinedGroup = !ModList.get().isLoaded(modId) && modId != "indev" ? null : ItemGroup.TRANSPORTATION;
        String type = this.getModId() + ":" + wood;
        RegistryObject<Item> boat = this.getDeferredItemRegister().register(wood + "_boat", () -> {
            return new AbnormalsBoatItem(type, createSimpleItemProperty(1, determinedGroup));
        });
        BoatRegistry.registerBoat(type, boat, block);
        return boat;
    }

    public Pair<RegistryObject<AbnormalsStandingSignBlock>, RegistryObject<AbnormalsWallSignBlock>> createCompatSignBlock(String modId, String name, MaterialColor color, Block.Properties properties) {
        ItemGroup determinedGroup = !ModList.get().isLoaded(modId) && modId != "indev" ? null : ItemGroup.DECORATIONS;
        ResourceLocation texture = new ResourceLocation(this.getModId(), "textures/entity/signs/" + name + ".png");
        RegistryObject<AbnormalsStandingSignBlock> standing = this.getDeferredBlockRegister().register(name + "_sign", () -> {
            return new AbnormalsStandingSignBlock(properties, texture);
        });
        RegistryObject<AbnormalsWallSignBlock> wall = this.getDeferredBlockRegister().register(name + "_wall_sign", () -> {
            return new AbnormalsWallSignBlock(properties.lootFrom((Block)standing.get()), texture);
        });
        this.createItem(name + "_sign", () -> {
            return new AbnormalsSignItem((Block)standing.get(), (Block)wall.get(), (new Item.Properties()).maxStackSize(16).group(determinedGroup));
        });
        return Pair.of(standing, wall);
    }

    public <B extends Block> RegistryObject<B> createTwoCompatBlock(String modId, String modId2, String name, Supplier<? extends B> supplier, @Nullable ItemGroup group) {
        ItemGroup determinedGroup = (!ModList.get().isLoaded(modId) || !ModList.get().isLoaded(modId2)) && modId != "indev" ? null : group;
        return createBlock(name, supplier, determinedGroup);
    }
}
