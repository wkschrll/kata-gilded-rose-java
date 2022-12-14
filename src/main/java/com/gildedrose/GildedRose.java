package com.gildedrose;

class GildedRose {
    Item[] items;

    private static int MAX_QUALITY = 50;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item currenItem = items[i];
            String currentName = currenItem.name;
            if (currentName.equals("Sulfuras, Hand of Ragnaros")) {
                continue;
            }

            currenItem.sellIn--;

            if (currentName.equals("Aged Brie")) {
                increaseQuality(currenItem, calculateUpdateAmountAgedBrie(currenItem));
            } else if (currentName.equals("Backstage passes to a TAFKAL80ETC concert")) {
                increaseQuality(currenItem, calculateUpdateAmountQualityBackstagePasses(currenItem));
            } else {
                reduceQualityByOne(currenItem);
                if (currenItem.sellIn < 0) {
                    reduceQualityByOne(currenItem);
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