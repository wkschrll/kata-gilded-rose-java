package com.gildedrose;

public enum ItemTypeEnum {
    AGED_BRIE("Aged Brie"), //
    BACKSTAGE_PASSES("Backstage passes to a TAFKAL80ETC concert"), //
    SULFUR("Sulfuras, Hand of Ragnaros"),
    DEXTERITY_VEST("+5 Dexterity Vest"),
    MONGOOSE("Elixir of the Mongoose");

    private String name;

    ItemTypeEnum(String name) {
        this.name = name;
    }

    public String getItemName() {
        return name;
    }

    public static ItemTypeEnum getByName(String name) {
        for (ItemTypeEnum item : values()) {
            if (item.getItemName().equalsIgnoreCase(name)) {
                return item;
            }
        }
        return null;
    }

}
