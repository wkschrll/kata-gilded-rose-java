package com.gildedrose;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

class GildedRose {

    interface UpdaterFactory extends Function<Integer, Consumer<Item>>{}
    
    class UpdateStrategies{
        
        static UpdaterFactory updateSellIn = (step) -> it-> it.sellIn += step;
        static UpdaterFactory updateQuality = (step) -> it-> it.quality += step;
        static UpdaterFactory capQualityAt = (cap) -> it-> it.quality = Math.min(it.quality, cap);
        static Consumer<Item> expireAfterSellIn = it -> it.quality = it.sellIn >= 0 ? it.quality : 0;
        static Consumer<Item> updateAgedBrieQuality = it -> it.quality += it.sellIn >= 0 ? 1 : 2;  
        static Consumer<Item> updateVestQuality = it -> it.quality += it.sellIn >= 0 ? -1 : -2;
        static Consumer<Item> noNegativeQuality = it -> it.quality = Math.max(it.quality, 0);
        static Consumer<Item> noop = it -> {}; 
        static Consumer<Item> backstagePassQualityUpdater = 
            (it) -> {
                     if (it.sellIn >= 10) updateQuality.apply(1).accept(it);
                else if (it.sellIn >= 5)  updateQuality.apply(2).accept(it);
                else if (it.sellIn >= 0)  updateQuality.apply(3).accept(it);
            };

        static Stream<Consumer<Item>> selectByName(Item item){
            return (switch(item.name){
                case "Aged Brie" -> Stream.of(
                    updateSellIn.apply(-1),
                    updateAgedBrieQuality,
                    capQualityAt.apply(50));
                case "Backstage passes to a TAFKAL80ETC concert" -> Stream.of(
                    updateSellIn.apply(-1),
                    backstagePassQualityUpdater,
                    capQualityAt.apply(50),
                    expireAfterSellIn);
                case "Conjured" -> Stream.of(
                    updateSellIn.apply(-1));
                case "+5 Dexterity Vest" -> Stream.of(
                    updateSellIn.apply(-1),
                    updateVestQuality,
                    noNegativeQuality);
                case "Sulfuras, Hand of Ragnaros" -> Stream.empty();
                default -> Stream.of(
                    updateSellIn.apply(-1),
                    updateQuality.apply(-1),
                    expireAfterSellIn);
            });
        }
    }

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        Arrays.stream(items).forEach(item -> 
            UpdateStrategies
                .selectByName(item)
                .forEach(updater -> updater.accept(item)));
    }
}