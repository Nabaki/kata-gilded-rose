package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class DefaultItemTest {

    @Test
    void updateSellIn_should_decreaseSellInBy1() {
        //GIVEN
        DefaultItem item = new DefaultItem("foo", 10, 10, false);

        //WHEN
        item.updateSellIn();

        //THEN
        assertEquals(9, item.getSellIn());
    }

    @Test
    void updateQuality_should_decreaseQualityBy1_when_sellInIsAbove0() {
        //GIVEN
        DefaultItem item = new DefaultItem("foo", 10, 10, false);

        //WHEN
        item.updateQuality();

        //THEN
        assertEquals(9, item.getQuality());
    }

    @Test
    void updateQuality_should_decreaseQualityBy2_when_sellInIsUnder0() {
        //GIVEN
        DefaultItem item = new DefaultItem("foo", 0, 10, false);

        //WHEN
        item.updateQuality();

        //THEN
        assertEquals(8, item.getQuality());
    }
}
