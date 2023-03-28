package com.gildedrose;

public class AgedBrie extends Item {
    public AgedBrie(int sellIn, int quality) {
        super("Aged Brie", sellIn, quality);
    }

    public void update() {
        if (quality < 50) {
            addQuality(1);
        }

        addSellIn(-1);

        if (sellIn < 0 && quality < 50) {
            addQuality(1);
        }
    }
}
