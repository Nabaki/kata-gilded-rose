package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class SulfurasItemTest {


    @Test
    void updateSellIn_should_notDecreaseSellInBy1() {
        //GIVEN
        SulfurasItem item = new SulfurasItem("Sulfuras", 10, 10, false);

        //WHEN
        item.updateSellIn();

        //THEN
        assertEquals(10, item.getSellIn());
    }

    @Test
    void updateQuality_should_notDecreaseQualityBy1() {
        //GIVEN
        SulfurasItem item = new SulfurasItem("Sulfuras", 10, 10, false);

        //WHEN
        item.updateQuality();

        //THEN
        assertEquals(10, item.getQuality());
    }
}
