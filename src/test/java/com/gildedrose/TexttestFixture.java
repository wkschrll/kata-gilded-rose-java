package com.gildedrose;

import java.io.IOException;

public class TexttestFixture {
    public static void main(String[] args) throws IOException {
        String output = executeGoldenMasterTest(args);
        System.out.println(output);
        
        // WRITE TO TEMPLATE FILE ONLY WITH ORIGINAL CODE 
        // Files.writeString(Paths.get("goldenMasterTemplate.txt"), output);
    }

    public static String executeGoldenMasterTest(String[] args) {
        StringBuffer buffer = new StringBuffer();
        
        buffer.append("\r\nOMGHAI!");

        Item[] items = new Item[] {
                new DexterityVestItem(10, 20),
                new AgedBrieItem(2, 0),
                new ElixirItem(5, 7),
                new SulfurasItem(0, 80),
                new SulfurasItem(-1, 80),
                new BackstageItem(15, 20),
                new BackstageItem(10, 49),
                new BackstageItem(5, 49) };
                // this conjured item does not work properly yet
//                new Item("Conjured Mana Cake", 3, 6) };

        GildedRose app = new GildedRose(items);

        int days = 20;
        if (args.length > 0) {
            days = Integer.parseInt(args[0]) + 1;
        }

        for (int i = 0; i < days; i++) {
            buffer.append("\r\n-------- day " + i + " --------");
            buffer.append("\r\nname, sellIn, quality");
            for (Item item : items) {
                buffer.append("\r\n" + item);
            }
            buffer.append("\r\n");
            app.updateQuality();
        }

        return buffer.toString();
    }

}
