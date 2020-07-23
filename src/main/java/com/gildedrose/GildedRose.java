package com.gildedrose;

import java.util.List;
import java.util.stream.Collectors;

class GildedRose {
    Item[] items;
    List<Updater> updaterList;

    public GildedRose(Item[] items) {
        this.items = items;
        this.updaterList = List.of(new ConstantQualityUpdater(), new IncreasingQualityItemUpdater(), new SimpleDecreasingQualityUpdater(), new BackstageQualityItemUpdater());
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item currentItem = items[i];
            List<Updater> matchingUpdaterList = updaterList
            .stream().filter(updater -> updater.getRelevantItemNames().contains(currentItem.name))
            .collect(Collectors.toList());
            
            if (matchingUpdaterList.isEmpty()) {
                matchingUpdaterList.add(new SimpleDecreasingQualityUpdater());
            }

            for (Updater matchingUpdater : matchingUpdaterList) {
                matchingUpdater.updateSellIn(currentItem);
                matchingUpdater.updateQuality(currentItem);
            }
        }
     }
}