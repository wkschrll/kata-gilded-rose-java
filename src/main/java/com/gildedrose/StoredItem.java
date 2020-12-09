package com.gildedrose;

public class StoredItem extends Item implements NamedItem, ItemWithQuality, LegacyItem {

    public StoredItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public StoredItem(Item item) {
        super(item.name, item.sellIn, item.quality);
	}

    @Override
    public void decreaseQuality() {
        this.quality = this.quality - 1;
    }

    @Override
    public void increaseQuality() {
        this.quality = this.quality + 1;
    }

    @Override
    public void loseAllQuality() {
        this.quality = 0;
    }

    @Override
    public boolean isNamed(String name) {
        return this.name.equals(name);
    }

    @Override
    public boolean isNotNamed(String name) {
        return !this.name.equals(name);
    }

    @Override
    public Item convertBack() {
        return new Item(this.name, this.sellIn, this.quality);
    }
    
}

interface NamedItem {
    boolean isNamed(String name);
    boolean isNotNamed(String name);
}

interface ItemWithQuality {
    void decreaseQuality();
    void increaseQuality();
    void loseAllQuality();
}

interface SellableItem {
    int daysLeft();
    void dayPassed();
}

interface LegacyItem {
    Item convertBack();
}