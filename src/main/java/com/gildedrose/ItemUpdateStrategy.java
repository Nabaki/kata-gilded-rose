package com.gildedrose;

public interface ItemUpdateStrategy {

    void update(Item item);
}

class AgedBrieUpdateStrategy implements ItemUpdateStrategy {

    @Override
    public void update(Item item) {
        if (item.quality < 50) {
            item.addQuality(1);
        }

        item.addSellIn(-1);

        if (item.sellIn < 0 && item.quality < 50) {
            item.addQuality(1);
        }
    }
}

class BackstagePassUpdateStrategy implements ItemUpdateStrategy {

    @Override
    public void update(Item item) {
        if (item.quality < 50) {
            item.addQuality(1);

            if (item.sellIn < 11 && item.quality < 50) {
                item.addQuality(1);
            }

            if (item.sellIn < 6 && item.quality < 50) {
                item.addQuality(1);
            }
        }

        item.addSellIn(-1);

        if (item.sellIn < 0) {
            item.resetQuality();
        }
    }
}

class SulfurasUpdateStrategy implements ItemUpdateStrategy {

    @Override
    public void update(Item item) {

    }
}

class DefaultItemUpdateStrategy implements ItemUpdateStrategy {

    @Override
    public void update(Item item) {
        if (item.quality > 0) {
            item.addQuality(-1);
        }

        item.addSellIn(-1);

        if (item.sellIn < 0 && item.quality > 0) {
            item.addQuality(-1);
        }
    }
}
