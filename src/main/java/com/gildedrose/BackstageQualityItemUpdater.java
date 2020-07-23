package com.gildedrose;

import java.util.List;

public class BackstageQualityItemUpdater implements Updater {

    @Override
    public List<String> getRelevantItemNames() {
        return List.of("Backstage passes to a TAFKAL80ETC concert");
    }

    @Override
    public Item updateQuality(Item item) {
        if (item.sellIn < 0) {
            item.quality = 0;
        } else if (item.quality <= 49 && item.sellIn > 10) {
            item.quality += 1;
        } else if (item.quality <= 48 && item.sellIn > 5) {
            item.quality += 2;
        } else if (item.quality <= 47 && item.sellIn >= 0) {
            item.quality += 3;
        }
        return item;
    }

    @Override
    public Item updateSellIn(Item item) {
        item.sellIn -= 1;
        return item;
    }
    
}