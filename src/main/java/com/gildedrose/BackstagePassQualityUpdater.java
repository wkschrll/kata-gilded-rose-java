package com.gildedrose;

public class BackstagePassQualityUpdater extends QualityUpdater {
    @Override
    public boolean handlesItem(Item item) {
        return "Backstage passes to a TAFKAL80ETC concert".equals(item.name);
    }
    @Override
    public void updateQuality(Item item){
        increaseQuality(item);
        if (item.sellIn < 11) {
            increaseQuality(item);
        }

        if (item.sellIn < 6) {
            increaseQuality(item);
        }
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }
}
