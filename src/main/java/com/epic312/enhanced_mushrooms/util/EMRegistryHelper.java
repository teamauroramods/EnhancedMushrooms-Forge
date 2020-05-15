package com.epic312.enhanced_mushrooms.util;

import com.mojang.datafixers.util.Pair;
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
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.RegistryObject;

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

    public Pair<RegistryObject<AbnormalsStandingSignBlock>, RegistryObject<AbnormalsWallSignBlock>> createCompatSignBlock(String modId, String name, MaterialColor color) {
        ItemGroup determinedGroup = !ModList.get().isLoaded(modId) && modId != "indev" ? null : ItemGroup.DECORATIONS;
        ResourceLocation texture = new ResourceLocation(this.getModId(), "textures/entity/signs/" + name + ".png");
        RegistryObject<AbnormalsStandingSignBlock> standing = this.getDeferredBlockRegister().register(name + "_sign", () -> {
            return new AbnormalsStandingSignBlock(net.minecraft.block.Block.Properties.create(Material.WOOD).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD), texture);
        });
        RegistryObject<AbnormalsWallSignBlock> wall = this.getDeferredBlockRegister().register(name + "_wall_sign", () -> {
            return new AbnormalsWallSignBlock(net.minecraft.block.Block.Properties.create(Material.WOOD, color).doesNotBlockMovement().hardnessAndResistance(1.0F).sound(SoundType.WOOD).lootFrom((Block)standing.get()), texture);
        });
        this.createItem(name + "_sign", () -> {
            return new AbnormalsSignItem((Block)standing.get(), (Block)wall.get(), (new Item.Properties()).maxStackSize(16).group(determinedGroup));
        });
        return Pair.of(standing, wall);
    }
}
