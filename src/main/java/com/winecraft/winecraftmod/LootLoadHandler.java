package com.winecraft.winecraftmod;

import com.winecraft.winecraftmod.common.item.ItemTemplates;
import net.minecraft.world.storage.loot.EmptyLootEntry;
import net.minecraft.world.storage.loot.ItemLootEntry;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.RandomValueRange;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import org.apache.logging.log4j.Logger;

import static net.minecraft.world.biome.Biome.LOGGER;

public class LootLoadHandler {

    private final Logger logger;

    public LootLoadHandler(Logger logger) {
        this.logger = logger;
        logger.info("Winecraft: Loot Handler registered.");
    }

    private static final LootPool GRAPE_SEED_LOOT_POOL = LootPool.builder()
            .rolls(new RandomValueRange(2.0f, 4.0f))
            .addEntry(ItemLootEntry.builder(ItemTemplates.GRAPE_SEEDS).weight(10))
            .addEntry(EmptyLootEntry.func_216167_a().weight(73))
            .build();

    @SubscribeEvent
    public void lootLoad(LootTableLoadEvent event) {
        String eventName = event.getName().toString();
        if ("minecraft:chests/simple_dungeon".equals(eventName) ||
                "minecraft:chests/abandoned_mineshaft".equals(eventName)) {
            event.getTable().addPool(GRAPE_SEED_LOOT_POOL);
        }
    }
}
