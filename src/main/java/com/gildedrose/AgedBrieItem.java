package com.gildedrose;

public class AgedBrieItem extends Item {

    public AgedBrieItem(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    @Override
    public void updateQuality() {
        sellIn--;
        if (quality < MAX_QUALITY) {
            quality++;

            if (sellIn < 0) {
                quality++;
            }
        }
    }

}