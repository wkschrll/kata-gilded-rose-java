package com.gildedrose;

class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE_PASSES = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            updateQualityOfItem(items[i]);
        }
    }

    private void updateQualityOfItem(Item item) {
        if (item.is(AGED_BRIE)) {
            updateQualityOfBrie(item);
        } else if (item.is(BACKSTAGE_PASSES)) {
            updateQualityOfBackstagePasses(item);
        } else if (item.is(SULFURAS)) {
            updateQualityOfSulfuras(item);
        } else {
            updateQualityOfOther(item);
        }
    }

    private void updateQualityOfBrie(Item item) {
        if (item.getQuality() < 50) {
            item.incrementQuality();
        }

        item.decrementDaysUntilExpiration();

        if (item.getDaysUntilExpiration() < 0 && item.getQuality() < 50) {
            item.incrementQuality();
        }
    }

    private void updateQualityOfBackstagePasses(Item item) {
        if (item.getQuality() < 50) {
            item.incrementQuality();

            if (item.getDaysUntilExpiration() < 11 && item.getQuality() < 50) {
                item.incrementQuality();
            }

            if (item.getDaysUntilExpiration() < 6 && item.getQuality() < 50) {
                item.incrementQuality();
            }
        }

        item.decrementDaysUntilExpiration();

        if (item.getDaysUntilExpiration() < 0) {
            item.setQualityToZero();
        }
    }

    private void updateQualityOfSulfuras(Item item) {
        // do nothing
    }

    private void updateQualityOfOther(Item item) {
        item.decrementQuality();
        item.decrementDaysUntilExpiration();

        if (item.getDaysUntilExpiration() < 0) {
            item.decrementQuality();
        }
    }
}