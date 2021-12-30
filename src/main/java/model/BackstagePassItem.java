package model;

public class BackstagePassItem extends AbstracItem {

    public BackstagePassItem(String name, int sellIn, int quality, boolean conjured) {
        super(name, sellIn, quality, conjured);
    }

    @Override
    protected void updateSellIn() {
        decreaseSellIn();
    }

    @Override
    protected void updateQuality() {
        int sellIn = getSellIn();
        if (sellIn > 0) {
            if (sellIn <= 5) {
                increaseQuality(3);
            } else if (sellIn <= 10) {
                increaseQuality(2);
            } else {
                increaseQuality(1);
            }
        } else {
            resetQuality();
        }
    }
}
