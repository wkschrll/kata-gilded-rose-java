package com.gildedrose;

public class Item {

    private String name;

    private int daysUntilExpiration;

    private int quality;

    public Item(String name, int daysUntilExpiration, int quality) {
        this.name = name;
        this.daysUntilExpiration = daysUntilExpiration;
        this.quality = quality;
    }

    public int getQuality() {
        return quality;
    }

    public void decrementQuality() {
        quality = Math.max(0, quality - 1);
    }

    public void incrementQuality() {
        quality++;
    }

    public void setQualityToZero() {
        quality = 0;
    }

    public boolean is(String type) {
        return name.equals(type);
    }

    public int getDaysUntilExpiration() {
        return daysUntilExpiration;
    }

    public void decrementDaysUntilExpiration() {
        daysUntilExpiration--;
    }

   @Override
   public String toString() {
        return this.name + ", " + this.daysUntilExpiration + ", " + this.quality;
    }
}
