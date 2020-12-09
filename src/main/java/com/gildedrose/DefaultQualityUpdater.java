package com.gildedrose;

public class DefaultQualityUpdater extends QualityUpdater {
    @Override
    public boolean handlesItem(Item item) {
        return true;
    }
    @Override
    public void updateQuality(Item item){
        decreaseQuality(item);
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0) {
            decreaseQuality(item);
        }
    }
}
