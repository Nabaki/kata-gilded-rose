package com.gildedrose;

public class BackstagePass extends Item {
    public BackstagePass(int sellIn, int quality) {
        super("Backstage passes to a TAFKAL80ETC concert", sellIn, quality);
    }

    public void update() {
        if (quality < 50) {
            addQuality(1);

            if (sellIn < 11 && quality < 50) {
                addQuality(1);
            }

            if (sellIn < 6 && quality < 50) {
                addQuality(1);
            }
        }

        addSellIn(-1);

        if (sellIn < 0) {
            resetQuality();
        }
    }
}
