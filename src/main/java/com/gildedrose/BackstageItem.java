package com.gildedrose;

public class BackstageItem extends Item {
    
    public BackstageItem(int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    @Override
    public void updateQuality() {
        if (quality < MAX_QUALITY) {
            quality++;
            if (quality < MAX_QUALITY) {
                if (sellIn < 11) {
                    quality++;
                    if (sellIn < 6) {
                        quality++;
                    }
                }
                
            }
        }

        sellIn--;

        if (sellIn < 0) {
            quality = 0;
        }
    }

}