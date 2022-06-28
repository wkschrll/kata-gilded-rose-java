package com.gildedrose;

import java.util.Set;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Set<String> names = Set.of("Aged Brie", "Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros");
        for (int i = 0; i < items.length; i++) {
            if (checkQuality(names, i)) {             
                items[i].quality = items[i].quality - 1;
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1;
                    if (!checkNameNotEqual(i, Set.of("Backstage passes to a TAFKAL80ETC concert"))) {
                        if (items[i].sellIn < 11 && items[i].quality < 50) {
                            items[i].quality = items[i].quality + 1;
                        }
                    }
                }
            }

            if (checkNameNotEqual(i, Set.of("Sulfuras, Hand of Ragnaros"))) {
                items[i].sellIn = items[i].sellIn - 1;
            }

            if (items[i].sellIn < 0) {
                if (!items[i].name.equals("Aged Brie")) {
                    if (!items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (items[i].quality > 0) {
                            if (!items[i].name.equals("Sulfuras, Hand of Ragnaros")) {
                                items[i].quality = items[i].quality - 1;
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality;
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1;
                    }
                }
            }
        }
    }

    private boolean checkQuality(Set<String> names, int i) {
        return checkNameNotEqual(i, names) && items[i].quality > 0;
    }

    private boolean checkNameNotEqual(int i, Set<String> names) {
        return !names.contains(items[i].name);
    }
}