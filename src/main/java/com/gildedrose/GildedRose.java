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
            // To do: Behandeln von SellIn und Behandeln von normalen Produkten danach Ausbau von altem Code (ab Zeile 24)
            if (qualityDecreasesWithTime(item) && isQualityAboveMinimum(item)) {
                    decreaseQuality(item);
            } else {
                if (isQualityBelowMaximum(item)) {
                    increaseQuality(item);
                    if (isBackstagePass(item)) {
                        if (item.sellIn < 11 && isQualityBelowMaximum(item)) {
                            increaseQuality(item);
                        }
                        if (item.sellIn < 6 && isQualityBelowMaximum(item)) {
                            increaseQuality(item);
                        }
                    }
                }
            }


            decreaseSellIn(item);

            if (item.sellIn < 0) {
                if (!isBrie(item)) {
                    if (!isBackstagePass(item)) {
                        if (isQualityAboveMinimum(item)) {
                            decreaseQuality(item);
                        }
                    } else {
                        item.quality = item.quality - item.quality;
                    }
                } else {
                    if (isQualityBelowMaximum(item)) {
                        increaseQuality(item);
                    }
                }
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
    }

    private void doSomethingWithBrie(Item item) {
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
        item.quality = item.quality - 1;
    }

    private boolean qualityDecreasesWithTime(Item item) {
        return !isBrie(item) && !isBackstagePass(item);
    }
}