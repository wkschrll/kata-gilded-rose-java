package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            StoredItem currentItem = new StoredItem(items[i]);
            if (itemCanLoseQuality(currentItem)) {
                currentItem.decreaseQuality();
            } else {
                if (isLowQuality(currentItem)) {
                    currentItem.increaseQuality();

                    if (currentItem.isNamed("Backstage passes to a TAFKAL80ETC concert")) {
                        if (currentItem.sellIn < 11) {
                            if (isLowQuality(currentItem)) {
                                currentItem.increaseQuality();
                            }
                        }

                        if (currentItem.sellIn < 6) {
                            if (isLowQuality(currentItem)) {
                                currentItem.increaseQuality();
                            }
                        }
                    }
                }
            }

            if (currentItem.isNotNamed("Sulfuras, Hand of Ragnaros")) {
                currentItem.sellIn = currentItem.sellIn - 1;
            }

            if (currentItem.sellIn < 0) {
                if (currentItem.isNamed("Aged Brie") && isLowQuality(currentItem)) {
                    currentItem.increaseQuality();
                } else {
                    if (currentItem.isNamed("Backstage passes to a TAFKAL80ETC concert")) {
                        currentItem.loseAllQuality();
                    } else {
                        if (currentItem.quality > 0 && currentItem.isNotNamed("Sulfuras, Hand of Ragnaros")) {
                            currentItem.decreaseQuality();
                        }
                    }
                }
            }
            items[i] = currentItem.convertBack();
        }
    }

    private boolean itemCanLoseQuality(StoredItem item) {
        return item.quality > 0 && item.isNotNamed("Aged Brie")
                && item.isNotNamed("Backstage passes to a TAFKAL80ETC concert")
                && item.isNotNamed("Sulfuras, Hand of Ragnaros");
    }

    private boolean isLowQuality(StoredItem item) {
        return item.quality < 50;
    }
}