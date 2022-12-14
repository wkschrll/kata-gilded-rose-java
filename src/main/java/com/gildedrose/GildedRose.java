package com.gildedrose;

class GildedRose {
    Item[] items;

    private static int MAX_QUALITY = 50;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item currentItem : items) {
            String currentName = currentItem.name;
            if (currentName.equals("Sulfuras, Hand of Ragnaros")) {
                continue;
            }

            currentItem.sellIn--;

            if (currentName.equals("Aged Brie")) {
                increaseQuality(currentItem, calculateUpdateAmountAgedBrie(currentItem));
            } else if (currentName.equals("Backstage passes to a TAFKAL80ETC concert")) {
                increaseQuality(currentItem, calculateUpdateAmountQualityBackstagePasses(currentItem));
            } else {
                reduceQualityByOne(currentItem);
                if (currentItem.sellIn < 0) {
                    reduceQualityByOne(currentItem);
                }
            }
        }
    }

    private int calculateUpdateAmountAgedBrie(Item item) {
        int amount = 1;
        if (item.sellIn < 0) {
            amount++;
        }
        return amount;
    }

    private int calculateUpdateAmountQualityBackstagePasses(Item item) {
        if (item.sellIn < 0) {
            return -item.quality;
        }

        int amount = 1;
        if (item.sellIn < 10) {
            amount++;
        }
        if (item.sellIn < 5) {
            amount++;
        }
        return amount;
    }

    private void reduceQualityByOne(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }

    private void increaseQuality(Item item, int amount) {
        int increasedQuality = item.quality + amount;
        if (increasedQuality >= MAX_QUALITY) {
            item.quality = MAX_QUALITY;
        } else {
            item.quality = increasedQuality;
        }
    }
}