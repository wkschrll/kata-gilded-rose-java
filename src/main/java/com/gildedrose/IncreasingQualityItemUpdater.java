package com.gildedrose;

import java.util.List;

class IncreasingQualityItemUpdater implements Updater {

    @Override
    public List<String> getRelevantItemNames() {
        return List.of("Aged Brie");
    }

    @Override
    public Item updateQuality(Item item) {
        if (item.quality < 50) {
            item.quality += 1;
        }
        return item;
    }

    @Override
    public Item updateSellIn(Item item) {
        item.sellIn -= 1;
        return item;
    }

}