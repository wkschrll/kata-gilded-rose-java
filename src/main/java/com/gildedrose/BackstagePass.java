package com.gildedrose;

public class BackstagePass extends StandardItem {

    public BackstagePass(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (quality < 50) {
            increaseQuality();

            if (sellIn < 11) {
                increaseQuality();
            }

            if (sellIn < 6) {
                increaseQuality();
            }
        }

        decreaseSellIn();

        if (sellIn < 0) {
            quality = 0;
        }
    }
}
