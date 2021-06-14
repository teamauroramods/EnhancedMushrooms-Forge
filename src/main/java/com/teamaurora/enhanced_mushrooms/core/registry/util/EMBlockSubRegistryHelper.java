package com.teamaurora.enhanced_mushrooms.core.registry.util;

import com.minecraftabnormals.abnormals_core.common.blocks.sign.AbnormalsStandingSignBlock;
import com.minecraftabnormals.abnormals_core.common.blocks.sign.AbnormalsWallSignBlock;
import com.minecraftabnormals.abnormals_core.core.api.SignManager;
import com.minecraftabnormals.abnormals_core.core.util.registry.BlockSubRegistryHelper;
import com.minecraftabnormals.abnormals_core.core.util.registry.RegistryHelper;
import com.mojang.datafixers.util.Pair;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.WoodType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SignItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;

public class EMBlockSubRegistryHelper extends BlockSubRegistryHelper {
    public EMBlockSubRegistryHelper(RegistryHelper helper) {
        super(helper);
    }

    public Pair<RegistryObject<AbnormalsStandingSignBlock>, RegistryObject<AbnormalsWallSignBlock>> createCompatSignBlock(String name, MaterialColor color, String modid) {
        WoodType type = SignManager.registerWoodType(WoodType.create(this.parent.getModId() + ":" + name));
        RegistryObject<AbnormalsStandingSignBlock> standing = this.deferredRegister.register(name + "_sign", () -> new AbnormalsStandingSignBlock(Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), type));
        RegistryObject<AbnormalsWallSignBlock> wall = this.deferredRegister.register(name + "_wall_sign", () -> new AbnormalsWallSignBlock(Block.Properties.create(Material.WOOD, color).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD).lootFrom(standing.get()), type));
        ItemGroup determinedGroup = !ModList.get().isLoaded(modid) && modid.equals("indev") ? null : ItemGroup.DECORATIONS;

        this.itemRegister.register(name + "_sign", () -> new SignItem(new Item.Properties().maxStackSize(16).group(determinedGroup), standing.get(), wall.get()));
        return Pair.of(standing, wall);
    }
}
