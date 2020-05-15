package com.epic312.enhanced_mushrooms.event;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraft.world.storage.loot.TableLootEntry;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class LootTableLoadEventHandler {
    @SubscribeEvent
    public void lootTableLoadEvent (LootTableLoadEvent event) {
        if (event.getName().equals(new ResourceLocation("quark","blocks/glowshroom_block"))) {
            event.setTable(LootTable.builder().addLootPool(LootPool.builder().addEntry(TableLootEntry.builder(new ResourceLocation("enhanced_mushrooms","blocks/glowshroom_block")))).build());
        } else if (event.getName().equals(new ResourceLocation("quark","blocks/glowshroom_stem"))) {
            event.setTable(LootTable.builder().addLootPool(LootPool.builder().addEntry(TableLootEntry.builder(new ResourceLocation("enhanced_mushrooms","blocks/glowshroom_stem")))).build());
        }
    }
}
