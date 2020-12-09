package com.gildedrose;

import java.util.List;

class GildedRose {
    Item[] items;
    List<QualityUpdater> qualityUpdaters;
    QualityUpdater defaultQualityUpdater = new DefaultQualityUpdater();

    public GildedRose(Item[] items) {
        this.items = items;
        // TODO: They should come from dependency injection
        qualityUpdaters = List.of(new SulfurasQualityUpdater(), new AgedBrieQualityUpdater(), new BackstagePassQualityUpdater());
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item item = items[i];
            qualityUpdaters.stream()
                .filter(qualityUpdater -> qualityUpdater.handlesItem(item)).findFirst()
                .orElse(defaultQualityUpdater)
                .updateQuality(item);;
        }
    }
}