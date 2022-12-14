package com.gildedrose;

public class StandardItem extends Item implements UpdatableItem {

    public StandardItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }
    
    public void updateQuality() {
        decreaseQuality();

        decreaseSellIn();

        if (sellIn < 0) {
            decreaseQuality();
        }
    }

    void decreaseQuality() {
        if (quality > 0) {
            quality = quality - 1;
        }
    }

    void increaseQuality() {
        if (quality < 50) {
            quality = quality + 1;
        }
    }

    void decreaseSellIn() {
        sellIn = sellIn - 1;
    }
}
