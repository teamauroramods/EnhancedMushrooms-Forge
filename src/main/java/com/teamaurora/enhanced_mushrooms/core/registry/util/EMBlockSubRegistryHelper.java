package com.teamaurora.enhanced_mushrooms.core.registry.util;

import com.minecraftabnormals.abnormals_core.common.blocks.sign.AbnormalsStandingSignBlock;
import com.minecraftabnormals.abnormals_core.common.blocks.sign.AbnormalsWallSignBlock;
import com.minecraftabnormals.abnormals_core.common.items.AbnormalsSignItem;
import com.minecraftabnormals.abnormals_core.core.util.registry.BlockSubRegistryHelper;
import com.minecraftabnormals.abnormals_core.core.util.registry.RegistryHelper;
import com.mojang.datafixers.util.Pair;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;

public class EMBlockSubRegistryHelper extends BlockSubRegistryHelper {
    public EMBlockSubRegistryHelper(RegistryHelper helper) {
        super(helper);
    }

    public Pair<RegistryObject<AbnormalsStandingSignBlock>, RegistryObject<AbnormalsWallSignBlock>> createCompatSignBlock(String name, MaterialColor color, String modid) {
        ResourceLocation texture = new ResourceLocation(this.parent.getModId(), "textures/entity/signs/" + name + ".png");
        RegistryObject<AbnormalsStandingSignBlock> standing = this.deferredRegister.register(name + "_sign", () -> new AbnormalsStandingSignBlock(net.minecraft.block.AbstractBlock.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), texture));
        RegistryObject<AbnormalsWallSignBlock> wall = this.deferredRegister.register(name + "_wall_sign", () -> new AbnormalsWallSignBlock(net.minecraft.block.AbstractBlock.Properties.create(Material.WOOD, color).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD).lootFrom(standing.get()), texture));
        ItemGroup determinedGroup = !ModList.get().isLoaded(modid) && modid.equals("indev") ? null : ItemGroup.DECORATIONS;

        this.itemRegister.register(name + "_sign", () -> new AbnormalsSignItem(standing.get(), wall.get(), (new Item.Properties()).maxStackSize(16).group(determinedGroup)));
        return Pair.of(standing, wall);
    }
}
