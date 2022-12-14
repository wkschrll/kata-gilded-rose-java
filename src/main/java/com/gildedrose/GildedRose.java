package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {

            if (items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                updateQualityForBackstagePass(items[i]);
            } else if (items[i].name.equals("Aged Brie")) {
                updateQualityForAgedBrie(items[i]);
            } else if (items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
               continue;
            } else {
                decreaseQuality(items[i]);

                decreaseSellIn(items[i]);

                if (items[i].sellIn < 0) {
                    decreaseQuality(items[i]);
                }
            }
        }
    }

    private void updateQualityForAgedBrie(Item item) {

        if (item.quality < 50) {
            increaseQuality(item);
        }

        decreaseSellIn(item);

        if (item.sellIn < 0) {
            increaseQuality(item);
        }
    }

    private void updateQualityForBackstagePass(Item item) {

        if (item.quality < 50) {
            increaseQuality(item);

            if (item.sellIn < 11) {
                increaseQuality(item);
            }

            if (item.sellIn < 6) {
                increaseQuality(item);
            }
        }

        decreaseSellIn(item);

        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }

    private void decreaseSellIn(Item item) {
        item.sellIn = item.sellIn - 1;
    }
}