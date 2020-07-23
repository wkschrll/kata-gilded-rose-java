package com.gildedrose;

import javax.lang.model.util.ElementScanner6;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int days = 0; days < items.length; days++) 
        {
            if(items[days].name.equals("Sulfuras, Hand of Ragnaros")) {
                updateHandOfRagnaros(items[days]);
            } else
            if(items[days].name.equals("Aged Brie")) {
                updateAgedBrie(items[days]);    
            } else
            if(items[days].name.equals("Backstage passes to a TAFKAL80ETC concert")) {
                updateBackstagepasses(items[days]);    
            } else {
                updateEverythingElse(items[days]);
            }
        }
    }

    private void updateHandOfRagnaros(Item item){
    
    }

    private void updateAgedBrie(Item item){
        if (item.quality > 50)
            return;
        
        item.sellIn = item.sellIn - 1;
        item.quality = item.quality + 1;
        if (item.sellIn < 0){
            item.quality = item.quality + 1;    
        }   
    }

    private void updateBackstagepasses(Item item){
        if (item.quality < 50) {
            item.quality = item.quality + 1;
            if (item.sellIn < 11 && item.quality < 50){
                item.quality = item.quality + 1;
            }

            if (item.sellIn < 6 && item.quality < 50) {
                item.quality = item.quality + 1;  
            }   
        }
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0) {
            item.quality = 0;
        }
    }

    private void updateEverythingElse(Item item){
        if (item.quality > 0) {
            item.quality = item.quality - 1;    
        } 
        item.sellIn = item.sellIn - 1;
        if (item.sellIn < 0) {
            if (item.quality > 0) {
                item.quality = item.quality - 1;
            } 
        }
    }
}