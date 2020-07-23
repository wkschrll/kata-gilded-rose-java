package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item currentItem = items[i];

            if (notBrie(currentItem) && notBackstage(currentItem) && notSulfuras(currentItem) && currentItem.hasQuality()) {
                currentItem.decrementQuality();
            } else {
                if (currentItem.qualityLessThanFifty()) {
                    currentItem.incrementQuality();

                    incrementBackstageQualityDependingOnSell(currentItem);
                }
            }

            if (notSulfuras(currentItem)) {
                currentItem.decrementSellIn();
            }

            if (!currentItem.hasSellIn()) {
                if (notBrie(currentItem)) {
                    if (notBackstage(currentItem)) {
                        if (currentItem.hasQuality() && notSulfuras(currentItem)) {
                            currentItem.decrementQuality();
                        }
                    } else {
                        currentItem.resetQuality();
                    }
                }

                if (isBrie(currentItem) && currentItem.qualityLessThanFifty()) {
                    currentItem.incrementQuality();
                }
            }
        }
    }

    private void incrementBackstageQualityDependingOnSell(Item currentItem) {
        if (currentItem.name.equals("Backstage passes to a TAFKAL80ETC concert") && currentItem.qualityLessThanFifty()) {
            if (currentItem.sellIn < 11) {
                currentItem.incrementQuality();
            }

            if (currentItem.sellIn < 6) {
                currentItem.incrementQuality();
            }
        }
    }

    private boolean notBrie(Item item) {
        return !item.name.equals("Aged Brie");
    }

    private boolean isBrie(Item item) {
        return item.name.equals("Aged Brie");
    }

    private boolean notBackstage(Item item) {
        return !item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private boolean notSulfuras(Item item) {
        return !item.name.equals("Sulfuras, Hand of Ragnaros");
    }

}