package com.gildedrose;

public class AgedBrieQualityUpdater extends QualityUpdater {
    @Override
    public boolean handlesItem(Item item) {
        return "Aged Brie".equals(item.name);
    }
    @Override
    public void updateQuality(Item item){
        increaseQuality(item);
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0) {
            increaseQuality(item);
        }
    }
}
