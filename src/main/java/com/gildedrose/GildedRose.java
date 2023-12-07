package com.gildedrose;

import java.util.Objects;

class GildedRose {
    private static final String AGED_BRIE = "Aged Brie";
    private static final String BACKSTAGE = "Backstage passes to a TAFKAL80ETC concert";
    private static final String SULFURAS = "Sulfuras, Hand of Ragnaros";

    private static final int QUALITY_THRESHOLD = 50;

    private Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            final Item item = items[i];
            final String name = item.name;
            int quality = prepareQuality(item);
            final int sellIn = prepareSellIn(name, item.sellIn);
            quality = finishCalculatingQuality(name, sellIn, quality);
            item.quality = quality;
            item.sellIn = sellIn;
        }
    }

    private int prepareQuality(final Item item) {
        final String name = item.name;
        int quality = item.quality;
        final int sellIn = item.sellIn;
        if (name.equals(AGED_BRIE) || name.equals(BACKSTAGE)) {
            if (checkQualityThreshold(quality)) {
                quality++;

                if (name.equals(BACKSTAGE) && checkThresholds(quality, sellIn, 11)) {
                    quality++;
                    if (checkThresholds(quality, sellIn, 6)) {
                        quality++;
                    }
                }
            }
        } else if (shouldDecreaseQuality(quality, name)) {
            quality--;
        } 
        return quality;
    }

    private int prepareSellIn(final String name, final int initialSellInArg) {
        int sellIn = initialSellInArg;
        if (isNotEquals(name, SULFURAS)) {
            sellIn--;
        }
        return sellIn;
    }

    private int finishCalculatingQuality(final String name, final int sellIn, final int qualityArg) {
        int quality = qualityArg;
        if (sellIn < 0) {
            if (name.equals(AGED_BRIE)) {
                if (checkQualityThreshold(quality)) {
                    quality++;
                }
            } else {
                if (name.equals(BACKSTAGE)) {
                    quality = 0;
                } else if (shouldDecreaseQuality(quality, name)) {
                    quality--;
                }
            }
        }
        return quality;
    }

    private boolean checkQualityThreshold(final int quality) {
        return checkThresholds(quality, null, null);
    }

    private boolean checkThresholds(final int quality, final Integer sellIn, final Integer sellInThreshold) {
        if (sellInThreshold != null) {
            return quality < QUALITY_THRESHOLD && sellIn < sellInThreshold;
        }
        return quality < QUALITY_THRESHOLD;
    }

    private boolean shouldDecreaseQuality(final int quality, final String name) {
        return quality > 0 && isNotEquals(name, SULFURAS);
    }

    private static boolean isNotEquals(Object a, Object b) {
        return !Objects.equals(a, b);
    }
}