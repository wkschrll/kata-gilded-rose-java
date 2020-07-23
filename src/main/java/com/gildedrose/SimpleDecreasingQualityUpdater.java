package com.gildedrose;

import java.util.List;

public class SimpleDecreasingQualityUpdater implements Updater {

    @Override
    public List<String> getRelevantItemNames() {
        return List.of();
    }

    @Override
    public Item updateQuality(Item item) {
        if (item.quality > 0) {
            item.quality -= 1;
        }
        return item;
    }

    @Override
    public Item updateSellIn(Item item) {
        item.sellIn -= 1;
        return item;
    }
    
}