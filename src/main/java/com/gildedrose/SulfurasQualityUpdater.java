package com.gildedrose;

public class SulfurasQualityUpdater extends QualityUpdater {
    @Override
    public boolean handlesItem(Item item) {
        return "Sulfuras, Hand of Ragnaros".equals(item.name);
    }
    @Override
    public void updateQuality(Item item) {
    }
}
