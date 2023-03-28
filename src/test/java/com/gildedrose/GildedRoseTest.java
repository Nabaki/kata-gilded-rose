package com.gildedrose;

import org.approvaltests.combinations.CombinationApprovals;
import org.junit.jupiter.api.Test;

class GildedRoseTest {

    @Test
    void updateAllCombination() {
        CombinationApprovals.verifyAllCombinations(
            this::update,
            new String[]{"foo", "Aged Brie", "Backstage passes to a TAFKAL80ETC concert", "Sulfuras, Hand of Ragnaros"},
            new Integer[]{-1, 0, 5, 6, 10, 11},
            new Integer[]{0, 1, 49, 50}
        );
    }

    private String update(String name, int sellIn, int quality) {
        Item item = new Item(name, sellIn, quality);
        GildedRose app = new GildedRose(new Item[]{item});
        app.updateAll();
        return app.items[0].toString();
    }

}
