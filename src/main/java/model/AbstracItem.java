package model;

import java.util.Objects;

public abstract class AbstracItem {

    public static final int ITEM_QUALITY_FLOOR = 0;
    public static final int ITEM_QUALITY_CEIL = 50;
    public static final String CONJURED_PREFIX = "Conjured ";

    private final String name;
    private final boolean conjured;
    private int sellIn;
    private int quality;

    public AbstracItem(String name, int sellIn, int quality, boolean conjured) {
        this.name = name;
        this.sellIn = sellIn;
        this.quality = quality;
        this.conjured = conjured;
    }

    public String getName() {
        return name;
    }

    public int getSellIn() {
        return sellIn;
    }

    public int getQuality() {
        return quality;
    }

    public boolean isConjured() {
        return conjured;
    }

    public void decreaseSellIn() {
        sellIn--;
    }

    protected final void increaseQuality(int increase) {
        if (conjured && increase < 0) {
            quality += increase * 2;
        } else {
            quality += increase;
        }

        if (quality > ITEM_QUALITY_CEIL) {
            quality = ITEM_QUALITY_CEIL;
        }

        if (quality < ITEM_QUALITY_FLOOR) {
            quality = ITEM_QUALITY_FLOOR;
        }
    }

    protected final void resetQuality() {
        quality = 0;
    }

    public final void tick() {
        updateSellIn();
        updateQuality();
    }

    protected abstract void updateSellIn();

    protected abstract void updateQuality();

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        AbstracItem that = (AbstracItem) o;
        return sellIn == that.sellIn && quality == that.quality && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sellIn, quality);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" +
            "name='" + name + '\'' +
            ", sellIn=" + sellIn +
            ", quality=" + quality +
            '}';
    }
}
