package com.gildedrose;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

class GildedRoseTest {

    @Test
    void updateQuality() {
        CombinationApprovals.verifyAllCombinations(
            this::doUpdateQuality,
            new String[]{"foo", "Aged Brie", "Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros"},
            new Integer[]{-1, 0, 5, 6, 10, 11},
            new Integer[]{0, 1, 49, 50}
        );
    }

    private String doUpdateQuality(String name, int sellIn, int quality) {
        Item item = new Item(name, sellIn, quality);
        GildedRose app = new GildedRose(new Item[]{item});
        app.updateQuality();
        return app.items[0].toString();
    }

}
