package com.gildedrose;

abstract class QualityUpdater {
    abstract boolean handlesItem(Item item);
    abstract void updateQuality(Item item);

    protected void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
    }

    protected void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }
}