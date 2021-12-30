package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BackstagePassItemTest {

    @Test
    void updateSellIn_should_decreaseSellInBy1() {
        //GIVEN
        BackstagePassItem item = new BackstagePassItem("Backstage passes", 10, 10, false);

        //WHEN
        item.updateSellIn();

        //THEN
        assertEquals(9, item.getSellIn());
    }

    @Test
    void updateQuality_should_riseQualityBy1_when_sellInIsAbove10() {
        //GIVEN
        BackstagePassItem item = new BackstagePassItem("Backstage passes to a TAFKAL80ETC concert", 11, 10, false);

        //WHEN
        item.updateQuality();

        //THEN
        assertEquals(11, item.getQuality());
    }

    @ParameterizedTest
    @ValueSource(ints = {6, 7, 8, 9, 10})
    void updateQuality_should_riseQualityBy2_when_sellInBetween6And10(int candidate) {
        //GIVEN
        BackstagePassItem item = new BackstagePassItem("Backstage passes to a TAFKAL80ETC concert", candidate, 10, false);

        //WHEN
        item.updateQuality();

        //THEN
        assertEquals(12, item.getQuality());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void updateQuality_should_riseQualityBy3_when_sellBetween1And5(int candidate) {
        //GIVEN
        BackstagePassItem item = new BackstagePassItem("Backstage passes to a TAFKAL80ETC concert", candidate, 10, false);

        //WHEN
        item.updateQuality();

        //THEN
        assertEquals(13, item.getQuality());
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -2})
    void updateQuality_should_setQualityto0_when_and_sellIn0OrLess(int candidate) {
        //GIVEN
        BackstagePassItem item = new BackstagePassItem("Backstage passes to a TAFKAL80ETC concert", candidate, 10, false);

        //WHEN
        item.updateQuality();

        //THEN
        assertEquals(0, item.getQuality());
    }
}
