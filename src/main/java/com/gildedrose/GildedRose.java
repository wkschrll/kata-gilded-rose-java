package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (Item currItem : items) {
            switch (currItem.getItemType()) {
                case AGED_BRIE:
                    currItem.checkQualityAndIncrease(1);
                    currItem.sellInDecrease();
                    if (currItem.sellIn < 0) {
                        currItem.checkQualityAndIncrease(1);
                    }
                    break;

                case BACKSTAGE_PASSES:
                    currItem.checkQualityAndIncrease(1);
                    if (currItem.sellIn < 11) {
                        if (currItem.sellIn >= 6) {
                            currItem.checkQualityAndIncrease(1);
                        } else {
                            currItem.checkQualityAndIncrease(2);
                        }
                    }
                    currItem.sellInDecrease();
                    if (currItem.sellIn < 0) {
                        currItem.resetQuality();
                    }
                    break;

                case SULFUR:
                    break;

                case DEXTERITY_VEST:
                case MONGOOSE:
                    currItem.checkQualityAndDecrease();
                    currItem.sellInDecrease();
                    if (currItem.sellIn < 0) {
                        currItem.checkQualityAndDecrease();
                    }
                    break;
            }
        }
    }
}