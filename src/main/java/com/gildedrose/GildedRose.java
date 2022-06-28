package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item: items){
            if (isSulfura(item)) {
                continue;
            }
            if (isBrie(item)){
                doSomethingWithBrie(item);
                continue;
            }
            if (isBackstagePass(item)){
                doSomethingWithBackstagePass(item);
                continue;
            }
            decreaseQuality(item);
            decreaseSellIn(item);
            if (item.sellIn < 0) {
                decreaseQuality(item);
            }
        }
    }

    private void doSomethingWithBackstagePass(Item item) {
        increaseQuality(item);
        if (item.sellIn < 11) {
            increaseQuality(item);
        }
        if (item.sellIn < 6) {
            increaseQuality(item);
        }
        decreaseSellIn(item);
        if (item.sellIn < 0) {
            item.quality = item.quality - item.quality;     
        }
    }

    private void doSomethingWithBrie(Item item) {
        increaseQuality(item);
        decreaseSellIn(item);
        if (item.sellIn < 0) {
            increaseQuality(item);
        }
    }

    private void decreaseSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }

    private boolean isQualityAboveMinimum(Item item) {
        return item.quality > 0;
    }

    private boolean isQualityBelowMaximum(Item item) {
        return item.quality < 50;
    }

    private boolean isBrie(Item item) {
        return item.name.equals("Aged Brie");
    }

    private boolean isBackstagePass(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isSulfura(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private void increaseQuality(Item item) {
        if (isQualityBelowMaximum(item)){
            item.quality = item.quality + 1;
        }
    }

    private void decreaseQuality(Item item) {
        if(isQualityAboveMinimum(item)){
            item.quality = item.quality - 1;
        }
    }
}