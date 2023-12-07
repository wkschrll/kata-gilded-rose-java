package com.gildedrose;

import java.util.Arrays;
import java.util.List;

class GildedRose {
    Item[] items;

    private final String SULFURAS = "Sulfuras, Hand of Ragnaros";
    private final String AGED_BRIE = "Aged Brie";
    private final String BACKSTAGE_PASS = "Backstage passes to a TAFKAL80ETC concert";

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            var currentItem = items[i];

            if (isNotIn(currentItem.name, Arrays.asList(SULFURAS, AGED_BRIE, BACKSTAGE_PASS))) {
                if (isQualityHigher(currentItem.quality, 0)) {
                        currentItem.quality--;
                }
            } else if (isQualityLower(currentItem.quality, 50)) {
                currentItem.quality++;

                if (currentItem.name.equals(BACKSTAGE_PASS)) {
                    if (isSellValueLower(currentItem.sellIn, 11) && isQualityLower(currentItem.quality, 50)) {
                        currentItem.quality++;
                    }

                    if (isSellValueLower(currentItem.sellIn, 6) && isQualityLower(currentItem.quality, 50)) {
                        currentItem.quality++;
                    }
                }
            }

            if (!currentItem.name.equals(SULFURAS)) {
                currentItem.sellIn--;
            }

            if (isSellValueLower(currentItem.sellIn, 0)) {
                if (!currentItem.name.equals(AGED_BRIE)) {
                    if (!currentItem.name.equals(BACKSTAGE_PASS)) {
                        if (isQualityHigher(currentItem.quality, 0) && !currentItem.name.equals(SULFURAS)) {
                            currentItem.quality--;
                        }
                    } else {
                        currentItem.quality -= currentItem.quality;
                    }
                } else if (isQualityLower(currentItem.quality, 50)) {
                    currentItem.quality++;
                }
            }
        }
    }

    private Boolean isQualityLower(Integer qualityOfItem, Integer expectedQuality){
        return qualityOfItem < expectedQuality;
    }

    private Boolean isQualityHigher(Integer qualityOfItem, Integer expectedQuality){
        return qualityOfItem > expectedQuality;
    }

    private Boolean isNotIn(String nameOfItem, List<String> names){
        return !names.contains(nameOfItem);
    }

    private Boolean isSellValueLower(Integer sellValue, Integer expectedValue){
        return sellValue < expectedValue;
    }

}