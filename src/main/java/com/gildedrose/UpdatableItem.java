package com.gildedrose;

public interface UpdatableItem {
    
    void updateQuality();

    private void increaseQuality() {
        if (item.quality < 50) {
            item.quality = item.quality + 1;
        }
    }
}