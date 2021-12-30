package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class AgedBrieItemTest {

    @Test
    void updateSellIn_should_decreaseSellInBy1() {
        //GIVEN
        AgedBrieItem item = new AgedBrieItem("Aged Brie", 10, 10, false);

        //WHEN
        item.updateSellIn();

        //THEN
        assertEquals(9, item.getSellIn());
    }

    @Test
    void updateQuality_should_riseQualityBy1_when_sellInIsAbove0() {
        //GIVEN
        AgedBrieItem item = new AgedBrieItem("Aged Brie", 10, 1, false);

        //WHEN
        item.updateQuality();

        //THEN
        assertEquals(2, item.getQuality());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2})
    void updateQuality_should_riseQualityBy2_when_sellInIs0OrUnder(int candidate) {
        //GIVEN
        AgedBrieItem item = new AgedBrieItem("Aged Brie", candidate, 1, false);

        //WHEN
        item.updateQuality();

        //THEN
        assertEquals(3, item.getQuality());
    }
}
