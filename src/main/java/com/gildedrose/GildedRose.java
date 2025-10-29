package com.gildedrose;

import java.util.List;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }
    
    public void updateQuality() {
        for (Item item : items) {
            if (isNameNotContained(item.name, List.of("Aged Brie", "Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros"))
                    && isQualityOverLimit(item, 0) ) {
                        item.quality = item.quality - 1;
            } else {
                increaseQualityDependingOnThings(item);
            }
            
            if (isNameNotContained(item.name, List.of("Sulfuras, Hand of Ragnaros"))) {
                item.sellIn = item.sellIn - 1;
            }
            
            if (isSellInBelowLimit(item, 0)) {
                handleExpiredItem(item);
            }
        }
    }
    
    private void increaseQualityDependingOnThings(Item item) {
        if (isQualityBelowLimit(item, 50)) {
            item.quality = item.quality + 1;
        }
        if (isNameContained(item.name, List.of("Backstage passes to a TAFKAL80ETC concert"))) {
            if (isSellInBelowLimit(item, 11) && isQualityBelowLimit(item, 50)) {
                item.quality = item.quality + 1;
            }

            if (isSellInBelowLimit(item, 6) && isQualityBelowLimit(item, 50)) {
                    item.quality = item.quality + 1;
                }
            }
        }

    private void handleExpiredItem(Item item) {
        if (isNameContained(item.name, List.of("Aged Brie")) && isQualityBelowLimit(item, 50)) {
            item.quality = item.quality + 1;
        } else {
            if (isNameContained(item.name, List.of("Backstage passes to a TAFKAL80ETC concert"))) {
                item.quality = 0;
            } else if (isQualityOverLimit(item, 0) && isNameNotContained(item.name, List.of("Sulfuras, Hand of Ragnaros"))) {
                item.quality = item.quality - 1;

            }
        }
    }

    private boolean isQualityBelowLimit(Item item, int limit) {
        return item.quality < limit;
    }
    
    private boolean isNameNotContained(String itemName, List<String> names) {
       return !names.contains(itemName);
    }
    
    private boolean isNameContained(String itemName, List<String> names) {
       return names.contains(itemName);
    }
    
    private boolean isQualityOverLimit(Item item, int limit){
        return item.quality > limit;
    }
    
       private boolean isSellInBelowLimit(Item item, int limit){
        return item.sellIn < limit;
    }
}