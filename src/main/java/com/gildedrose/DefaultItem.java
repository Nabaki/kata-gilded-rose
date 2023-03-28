package com.gildedrose;

public class DefaultItem extends Item {
    public DefaultItem(String name, int sellIn, int quality) {
        super(name, sellIn, quality);
    }

    public void update() {
        if (quality > 0) {
            addQuality(-1);
        }

        addSellIn(-1);

        if (sellIn < 0 && quality > 0) {
            addQuality(-1);
        }
    }
}
