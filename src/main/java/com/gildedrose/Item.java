package com.gildedrose;

public class Item {

    public final String name;
    public int sellIn;
    public int quality;

    protected Item(String name, int sellIn, int quality) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
    }

    @Override
    public String toString() {
        return this.name + ", " + this.sellIn + ", " + this.quality;
    }

    public void addQuality(int bonusQuality) {
        quality += bonusQuality;
    }

    public void addSellIn(int bonusSellIn) {
        sellIn += bonusSellIn;
    }

    public void resetQuality() {
        quality = 0;
    }
}
