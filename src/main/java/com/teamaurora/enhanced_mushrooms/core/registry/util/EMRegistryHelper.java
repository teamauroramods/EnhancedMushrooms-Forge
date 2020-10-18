package com.teamaurora.enhanced_mushrooms.core.registry.util;

import java.util.concurrent.Callable;
import java.util.function.Supplier;

import javax.annotation.Nullable;

import com.mojang.datafixers.util.Pair;
import com.teamabnormals.abnormals_core.client.renderer.ChestItemRenderer;
import com.teamabnormals.abnormals_core.common.blocks.chest.AbnormalsChestBlock;
import com.teamabnormals.abnormals_core.common.blocks.chest.AbnormalsTrappedChestBlock;
import com.teamabnormals.abnormals_core.common.blocks.sign.AbnormalsStandingSignBlock;
import com.teamabnormals.abnormals_core.common.blocks.sign.AbnormalsWallSignBlock;
import com.teamabnormals.abnormals_core.common.items.AbnormalsBoatItem;
import com.teamabnormals.abnormals_core.common.items.AbnormalsSignItem;
import com.teamabnormals.abnormals_core.common.tileentity.AbnormalsChestTileEntity;
import com.teamabnormals.abnormals_core.common.tileentity.AbnormalsTrappedChestTileEntity;
import com.teamabnormals.abnormals_core.core.registry.BoatRegistry;
import com.teamabnormals.abnormals_core.core.utils.RegistryHelper;

import net.minecraft.block.Block;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.SoupItem;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
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

    public RegistryObject<Item> createConditionalItem(boolean bool, String name, Item.Properties properties, ItemGroup group) {
        ItemGroup determinedGroup = bool ? group : null;
        RegistryObject<Item> item = this.getDeferredItemRegister().register(name, () -> new Item(properties.group(determinedGroup)));
        return item;
    }

    public RegistryObject<Item> createConditionalSoupItem(boolean bool, String name, Item.Properties properties, ItemGroup group) {
        ItemGroup determinedGroup = bool ? group : null;
        RegistryObject<Item> item = this.getDeferredItemRegister().register(name, () -> new SoupItem(properties.group(determinedGroup)));
        return item;
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

    public Pair<RegistryObject<AbnormalsChestBlock>, RegistryObject<AbnormalsTrappedChestBlock>> createCompatChestsWithProperties(String name, Block.Properties properties) {
        ItemGroup chestGroup = !ModList.get().isLoaded("quark") && this.getModId() != "indev" ? null : ItemGroup.DECORATIONS;
        ItemGroup trappedChestGroup = !ModList.get().isLoaded("quark") && this.getModId() != "indev" ? null : ItemGroup.REDSTONE;
        RegistryObject<AbnormalsChestBlock> chest = this.getDeferredBlockRegister().register(name + "_chest", () -> {
            return new AbnormalsChestBlock(this.getModId(), name, properties);
        });
        RegistryObject<AbnormalsTrappedChestBlock> trappedChest = this.getDeferredBlockRegister().register(name + "_trapped_chest", () -> {
            return new AbnormalsTrappedChestBlock(this.getModId(), name, properties);
        });
        this.getDeferredItemRegister().register(name + "_chest", () -> {
            return new BlockItem((Block)chest.get(), (new Item.Properties()).group(chestGroup).setISTER(() -> {
                return chestISTER();
            }));
        });
        this.getDeferredItemRegister().register(name + "_trapped_chest", () -> {
            return new BlockItem((Block)trappedChest.get(), (new Item.Properties()).group(trappedChestGroup).setISTER(() -> {
                return trappedChestISTER();
            }));
        });
        return Pair.of(chest, trappedChest);
    }

    @OnlyIn(Dist.CLIENT)
	private static Callable<ItemStackTileEntityRenderer> chestISTER() {
		return () -> new ChestItemRenderer<TileEntity>(AbnormalsChestTileEntity::new);
	}
	
	@OnlyIn(Dist.CLIENT)
	private static Callable<ItemStackTileEntityRenderer> trappedChestISTER() {
		return () -> new ChestItemRenderer<TileEntity>(AbnormalsTrappedChestTileEntity::new);
	}
}
