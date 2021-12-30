import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import contract.Item;

class GildedRoseTest {

    @Test
    void updateQuality_shouldNotThrow_when_noItem() {
        //GIVEN
        Item[] items = new Item[]{};
        GildedRose app = new GildedRose(items);

        //WHEN
        //THEN
        assertDoesNotThrow(app::updateQuality);
    }
}
