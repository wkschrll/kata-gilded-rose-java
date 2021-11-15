package com.gildedrose;

import java.lang.reflect.Executable;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateItems() {
        for (Item item : items) {
            updateItem(item);
        }
    }

    private void updateItem(Item item){
        if(item.name.equals("Aged Brie")){
            updateAgedBrie(item);
            return;
        }
        if(item.name.equals("Backstage passes to a TAFKAL80ETC concert")){
            updateBackstage(item);
            return;
        }
        if(item.name.equals("Sulfuras, Hand of Ragnaros")){
            return;
        }
        updateStandardItem(item);
    }

    private void updateStandardItem(Item item){
        item.sellIn -= 1;
        reduceQuality(item, 1);
        if (item.sellIn < 0) {
            reduceQuality(item, 1);
        }
    }

    private void updateAgedBrie(Item item){
        item.sellIn -= 1;

        if (item.quality < 50) {
            item.quality += 1;
        }

        if (item.sellIn < 0) {
            if (item.quality < 50) {
                item.quality += 1;
            }
        }
    }

    private void updateBackstage(Item item){
        if (item.quality < 50) {
            item.quality += 1;

                if (item.sellIn < 11 && item.quality < 50) {
                        item.quality = item.quality + 1;
                }

                if (item.sellIn < 6 && item.quality < 50) {
                        item.quality = item.quality + 1;
                } 
        }
        item.sellIn -= 1;
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    private void reduceQuality(Item item, int difference){
        item.quality = Math.max(item.quality - difference, 0);
    }

}