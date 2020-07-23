package com.gildedrose;

import java.util.List;

class ConstantQualityUpdater implements Updater {

    @Override
    public List<String> getRelevantItemNames() {
       return List.of("Sulfuras, Hand of Ragnaros");
    }

    @Override
    public Item updateQuality(Item item) {
        return item;
    }

    @Override
    public Item updateSellIn(Item item) {
        return item;
    }

}