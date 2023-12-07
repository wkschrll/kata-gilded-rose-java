package com.gildedrose;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class GildedRose {
    Item[] items;
    private final static int MAX_QUALITY = 50;

    List<String> itemsWithIncreasingQuality = new ArrayList<>(Arrays.asList("Aged Brie", "Backstage passes to a TAFKAL80ETC concert")); 
  

    public GildedRose(Item[] items) {
        this.items = items;
    }

    // Backstage-Karten, Sulfuras-Hand, Aged Brie, Elixier, Vest
    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            Item currentItem = items[i];

            if (itemsWithIncreasingQuality.contains(currentItem.name) && currentItem.quality < MAX_QUALITY) {
                    currentItem.quality++;

                    if (currentItem.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (currentItem.sellIn < 11 && currentItem.quality < MAX_QUALITY) {
                                currentItem.quality++;
                        }
                        if (currentItem.sellIn < 6 && currentItem.quality < MAX_QUALITY) {
                                currentItem.quality++;
                        }
                    }
            } else if(currentItem.quality > 0 && !currentItem.name.equals("Sulfuras, Hand of Ragnaros")) {
                currentItem.quality--;
            }

            this.updateSellIn(currentItem);

            if (currentItem.sellIn < 0) {
                if (currentItem.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                    currentItem.quality = 0;
                }
                if (currentItem.name.equals("Aged Brie") && currentItem.quality < MAX_QUALITY) {
                    currentItem.quality++;
                }


                if (!currentItem.name.equals("Aged Brie")) {
                    if (!currentItem.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                        if (currentItem.quality > 0) {
                            if (!currentItem.name.equals("Sulfuras, Hand of Ragnaros")) {
                                currentItem.quality--;
                            }
                        }

                    }
                }
            }
        }
    }

    private void updateSellIn(Item item) {
        if(!item.name.equals("Sulfuras, Hand of Ragnaros")) {
            item.sellIn--;
        }
    }
}