package com.gildedrose;

import java.util.List;

public interface Updater {

    List<String> getRelevantItemNames();

    Item updateQuality(Item item);

    Item updateSellIn(Item item);
    
}