package model;

public class AgedBrieItem extends AbstracItem {

    public AgedBrieItem(String name, int sellIn, int quality, boolean conjured) {
        super(name, sellIn, quality, conjured);
    }

    @Override
    protected void updateSellIn() {
        decreaseSellIn();
    }

    @Override
    protected void updateQuality() {
        if (getSellIn() > 0) {
            increaseQuality(1);
        } else {
            increaseQuality(2);
        }
    }
}
