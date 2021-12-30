package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AbstractItemTest {

    @Test
    void tick_should_callUpdateQuality_ANdUpdateSellIn_onlyOnceEach() {
        //GIVEN
        MockedItem item = new MockedItem("mock", 0, 0, false);

        //WHEN
        item.tick();

        //THEN
        assertEquals(1, item.updateQualityCalled);
        assertEquals(1, item.updateSellInCalled);
    }

    @Test
    void updateQuality_should_neverDecreaseQualityUnder0() {
        //GIVEN
        MockedItem item = new MockedItem("mock", 0, 0, false);

        //WHEN
        item.increaseQuality(-1);

        //THEN
        assertEquals(0, item.getQuality());
    }

    @Test
    void updateQuality_should_neverIncreaseQualityAbove50() {
        //GIVEN
        MockedItem item = new MockedItem("mock", 0, 50, false);

        //WHEN
        item.increaseQuality(1);

        //THEN
        assertEquals(50, item.getQuality());
    }

    @Test
    void increaseQuality_should_beTwiceFaster_when_conjured_and_decreasing() {
        //GIVEN
        MockedItem item = new MockedItem("mock", 0, 50, true);

        //WHEN
        item.increaseQuality(-1);

        //THEN
        assertEquals(48, item.getQuality());
    }
}

class MockedItem extends AbstracItem {

    public int updateQualityCalled = 0;
    public int updateSellInCalled = 0;

    public MockedItem(String name, int sellIn, int quality, boolean conjured) {
        super(name, sellIn, quality, conjured);
    }

    @Override
    protected void updateQuality() {
        updateQualityCalled++;
    }

    @Override
    protected void updateSellIn() {
        updateSellInCalled++;
    }
}
