package com.gildedrose;

class GildedRose {
    

    private static final int UPPER_QUALITY_VALUE_BOUNDARY = 50;
    private static final int LOWER_QUALITY_VALUE_BOUNDARY = 0;

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {  // Iteration over elements
            if (
                !checkItemType(items[i], Item.AGED_BRIE)
                    && !checkItemType(items[i], Item.BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT)) { // Item "type" check
                    if (!checkItemType(items[i], Item.SULFURAS_HAND_OF_RAGNAROS)) {
                        items[i].quality = decreaseQuality(items[i], LOWER_QUALITY_VALUE_BOUNDARY);
                    }
            } else {
                if (items[i].quality < UPPER_QUALITY_VALUE_BOUNDARY) {
                    items[i].quality = items[i].quality + 1;

                    if (checkItemType(items[i], Item.BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT)) {
                        if (items[i].sellIn < 11) {
                                items[i].quality = increaseQuality(items[i], UPPER_QUALITY_VALUE_BOUNDARY);
                        }
                    }
                }
            }

            if (!checkItemType(items[i], Item.SULFURAS_HAND_OF_RAGNAROS)) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) { // Item type checks after this line are all irrelevant, since only "SULFASRAS_HAND_OF_RAGNAROS" items are subject to "sellIn" value depreciation                if (!checkItemType(items[i], Item.AGED_BRIE)) {
                    if (!checkItemType(items[i], Item.BACKSTAGE_PASSES_TO_A_TAFKAL80ETC_CONCERT)) {
                        // if (items[i].quality > 0) {
                            if (!checkItemType(items[i], Item.SULFURAS_HAND_OF_RAGNAROS)) {
                                items[i].quality = decreaseQuality(items[i], LOWER_QUALITY_VALUE_BOUNDARY);
                            }
                        // }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < UPPER_QUALITY_VALUE_BOUNDARY) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }

    private int decreaseQuality(Item item, int qualityLowerBoundary) {
        if (item.quality > qualityLowerBoundary) {
            return item.quality--;
        }
        return item.quality;
    }

    private int increaseQuality(Item item, int qualityUpperboundary) {
        if (item.quality < qualityUpperboundary) {
            return item.quality++;
        }
        return item.quality;
    }

    private boolean checkItemType(Item item, String typeName) {
        return item.name.equals(typeName);
    }
}