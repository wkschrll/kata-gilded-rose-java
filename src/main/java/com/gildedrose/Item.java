package com.gildedrose;

public class Item {

    private ItemTypeEnum itemType;

    public int sellIn;

    private int quality;

    public Item(String name, int sellIn, int quality) {
        this.itemType = ItemTypeEnum.getByName(name);
        this.sellIn = sellIn;
        this.quality = quality;
    }

    public ItemTypeEnum getItemType() {
        return this.itemType;
    }

    public int getQuality() {
        return quality;
    }

    public int getSellIn() {
        return sellIn;
    }

    @Override
    public String toString() {
        return this.itemType.getItemName() + ", " + this.sellIn + ", " + this.quality;
    }

    public void checkQualityAndDecrease() {
        if (quality > 0) {
            quality--;
        }
    }

    public void resetQuality() {
        quality = 0;
    }

    public void checkQualityAndIncrease(int amount) {
        if (quality < 50) {
            quality += amount;
        }
    }

    public void sellInDecrease() {
        sellIn--;
    }

}
