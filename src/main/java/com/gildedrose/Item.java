package com.gildedrose;

public abstract class Item {

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

    public abstract void update();

    protected void addQuality(int bonusQuality) {
        quality += bonusQuality;
    }

    protected void addSellIn(int bonusSellIn) {
        sellIn += bonusSellIn;
    }

    protected void resetQuality() {
        quality = 0;
    }
}
