package com.gildedrose;
class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item: items) {
            if (isNotAgedBrie(item) && isNotBackstagePass(item)) {
                decrementDownToZeroNotSulfurasItemQuality(item);
            } else {
                if (item.quality < 50) {
                    item.quality++;

                    if (isBackstagePass(item) && item.quality < 50) {
                        incrementQuality(item, 11);
                        incrementQuality(item, 6);
                    }
                }
            }

            if (isNotSulfuras(item)) {
                item.sellIn--;
            }

            if (item.sellIn < 0) {
                if (isNotAgedBrie(item)) {
                    if (isNotBackstagePass(item)) {
                        decrementDownToZeroNotSulfurasItemQuality(item);
                    } else {
                        // potential bug?
                        item.quality = 0;
                    }
                } else {
                    if (item.quality < 50) {
                        item.quality++;
                    }
                }
            }
        }
    }

    private void incrementQuality(Item item, int maxSellIn) {
        if (item.sellIn < maxSellIn) {
            item.quality++;
        }
    }

    private void decrementDownToZeroNotSulfurasItemQuality(Item item) {
        if (item.quality > 0 && isNotSulfuras(item)) {
            item.quality--;
        }
    }

    private boolean isNotAgedBrie(Item item) {
        return !item.name.equals("Aged Brie");
    }

    private boolean isNotBackstagePass(Item item) {
        return !isBackstagePass(item);
    }

    private boolean isBackstagePass(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean isNotSulfuras(Item item) {
        return !item.name.equals("Sulfuras, Hand of Ragnaros");
    }

}