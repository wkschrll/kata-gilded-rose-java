package com.gildedrose;
class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item: items) {
            if (isNotAgedBrie(item) && isNotBackstagePass(item)) {
                if (item.quality > 0) {
                    if (isNotSulfuras(item)) {
                        item.quality--;
                    }
                }
            } else {
                if (item.quality < 50) {
                    item.quality++;

                    if (isBackstagePass(item)) {
                        if (item.sellIn < 11) {
                            if (item.quality < 50) {
                                item.quality++;
                            }
                        }

                        if (item.sellIn < 6) {
                            if (item.quality < 50) {
                                item.quality++;
                            }
                        }
                    }
                }
            }

            if (isNotSulfuras(item)) {
                item.sellIn--;
            }

            if (item.sellIn < 0) {
                if (isNotAgedBrie(item)) {
                    if (isNotBackstagePass(item)) {
                        if (item.quality > 0) {
                            if (isNotSulfuras(item)) {
                                item.quality--;
                            }
                        }
                    } else {
                        // item.quality = item.quality - item.quality;
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