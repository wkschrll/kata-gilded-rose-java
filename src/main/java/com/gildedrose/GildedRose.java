package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {

            if (!item.name.equals("Sulfuras, Hand of Ragnaros")) {
                item.sellIn = item.sellIn - 1;
            }

            switch (item.name) {
                case "Backstage passes to a TAFKAL80ETC concert":
                    if (item.sellIn < 0) {
                        item.quality = 0;
                    } else if (item.sellIn < 5) {
                        increaseQualityBy(item, 3);
                    } else if (item.sellIn < 10) {
                        increaseQualityBy(item, 2);
                    } else {
                        increaseQualityBy(item, 1);
                    }
                    break;
                case "Aged Brie":
                case "Sulfuras, Hand of Ragnaros":
                    increaseQuality(item);
                    break;
                default:
                    decreaseQuality(item);
                    break;
            }

            if (item.sellIn < 0) {
                if (item.name.equals("Aged Brie") || item.name.equals("Sulfuras, Hand of Ragnaros")) {
                    increaseQuality(item);
                } else {
                    decreaseQuality(item);
                }
            }
        }
    }

    private static void decreaseQuality(Item item) {
        if (item.quality > 0)
            item.quality--;
    }

    private static void increaseQuality(Item item) {
        if (item.quality < 50)
            item.quality++;
    }

    private static void increaseQualityBy(Item item, int amount) {
        item.quality = Math.min(50, item.quality + amount);
    }

}