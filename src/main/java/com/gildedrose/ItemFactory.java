package com.gildedrose;

public final class ItemFactory {

    public static Item createItem(String name, int sellIn, int quality) {
        return switch (name) {
            case "Aged Brie" -> new AgedBrie(sellIn, quality);
            case "Backstage passes to a TAFKAL80ETC concert" -> new BackstagePass(sellIn, quality);
            case "Sulfuras, Hand of Ragnaros" -> new Sulfuras(sellIn, quality);
            default -> new DefaultItem(name, sellIn, quality);
        };
    }
}
