package com.gildedrose;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {

        for (int i = 0; i < items.length; i++) {

            switch (items[i].name) {
                case "Aged Brie":
                    updateBrie(items[i]);
                    updateSellin(items[i]);
                    break;

                case "Backstage passes to a TAFKAL80ETC concert":
                    updateBackstagePasses(items[i]);
                    updateSellin(items[i]);
                    break;

                case "Sulfuras, Hand of Ragnaros":
                    break;
            
                default:
                    updateCommonItem(items[i]);
                    updateSellin(items[i]);
                    break;
            }
            
        }
    }

    public void updateSellin(Item Item) {
        Item.sellIn = Item.sellIn - 1;
    }

    public void updateCommonItem(Item commonItem) {

        if (commonItem.quality > 0) {
            commonItem.quality -= 1;
        }

        if (commonItem.sellIn < 0) { 
            if (commonItem.quality > 0) {
                commonItem.quality -= 1;
            }
        }

    }

    public void updateBrie(Item brie) {

        if(brie.quality < 50) {
            brie.quality += 1;
        }

        if (brie.sellIn <= 0 && brie.quality < 50) {
            brie.quality += 1;
        }
    }

    public void updateBackstagePasses(Item backstagePass) {

        if(backstagePass.quality < 50) {
            backstagePass.quality += 1;

            if (backstagePass.sellIn < 11) {
                if (backstagePass.quality < 50) {
                    backstagePass.quality += 1;
                }
            }

            if (backstagePass.sellIn < 6) {
                if (backstagePass.quality < 50) {
                    backstagePass.quality += 1;
                }
            }
        }

        if (backstagePass.sellIn <= 0) {
            backstagePass.quality = backstagePass.quality - backstagePass.quality;
        }
    }   
}