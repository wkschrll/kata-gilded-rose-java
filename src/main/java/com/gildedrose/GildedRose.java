package com.gildedrose;

class GildedRose {
    public enum ItemName {

        AGED_BRIE("Aged Brie"), BACKSTAGE("Backstage passes to a TAFKAL80ETC concert"),
        SULFURAS("Sulfuras, Hand of Ragnaros");

        private final String name;

        ItemName(final String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    };

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            updateSingleItem(items[i]);
        }
    }

    private void updateSingleItem(Item item) {
        if (item.name.equals(ItemName.AGED_BRIE.toString())) {
            handleAgedBrie(item);
        } else if (item.name.equals(ItemName.BACKSTAGE.toString())) {
            handleBackstage(item);
        } else if (item.name.equals(ItemName.SULFURAS.toString())) {
            handleSulfurus(item);
        } else {
            handleDefault(item);
        }
    }

    private void handleDefault(Item item) {
        if (item.quality > 0) {
            item.quality = item.quality - 1;
        }
        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            if (item.quality > 0) {
                item.quality = item.quality - 1;
            }
        }
    }

    private void handleSulfurus(Item item) {
        return;
    }

    private void handleAgedBrie(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            if (item.quality < 50) {
                item.quality = item.quality + 1;
            }
        }
    }

    private void handleBackstage(Item item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1;

            if (item.sellIn < 11) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }

            if (item.sellIn < 6) {
                if (item.quality < 50) {
                    item.quality = item.quality + 1;
                }
            }
        }

        item.sellIn = item.sellIn - 1;

        if (item.sellIn < 0) {
            item.quality = item.quality - item.quality;
        }
    }
}