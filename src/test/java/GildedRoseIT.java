import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import contract.Item;
import model.AbstracItem;
import model.AgedBrieItem;
import model.BackstagePassItem;
import model.DefaultItem;
import model.SulfurasItem;

class GildedRoseIT {

    GildedRose app;

    @BeforeEach
    void beforeEach() {
        Item[] items = new Item[]{
            new Item("+5 Dexterity Vest", 10, 20),
            new Item("Aged Brie", 2, 0),
            new Item("Elixir of the Mongoose", 5, 7),
            new Item("Sulfuras, Hand of Ragnaros", 0, 80),
            new Item("Sulfuras, Hand of Ragnaros", -1, 80),
            new Item("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            new Item("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            new Item("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            new Item("Conjured Mana Cake", 3, 6)
        };

        app = new GildedRose(items);
    }

    @Test
    void gildedRose_after_1_days() {
        //GIVEN
        List<AbstracItem> expectedItems = List.of(
            new DefaultItem("+5 Dexterity Vest", 9, 19, false),
            new AgedBrieItem("Aged Brie", 1, 1, false),
            new DefaultItem("Elixir of the Mongoose", 4, 6, false),
            new SulfurasItem("Sulfuras, Hand of Ragnaros", 0, 80, false),
            new SulfurasItem("Sulfuras, Hand of Ragnaros", -1, 80, false),
            new BackstagePassItem("Backstage passes to a TAFKAL80ETC concert", 14, 21, false),
            new BackstagePassItem("Backstage passes to a TAFKAL80ETC concert", 9, 50, false),
            new BackstagePassItem("Backstage passes to a TAFKAL80ETC concert", 4, 50, false),
            new DefaultItem("Conjured Mana Cake", 2, 4, true)
        );

        //WHEN
        updateGildedRose(1);

        //THEN
        assertEquals(expectedItems, app.myItems);
    }

    @Test
    void gildedRose_after_2_days() {
        //GIVEN
        List<AbstracItem> expectedItems = List.of(
            new DefaultItem("+5 Dexterity Vest", 8, 18, false),
            new AgedBrieItem("Aged Brie", 0, 3, false),
            new DefaultItem("Elixir of the Mongoose", 3, 5, false),
            new SulfurasItem("Sulfuras, Hand of Ragnaros", 0, 80, false),
            new SulfurasItem("Sulfuras, Hand of Ragnaros", -1, 80, false),
            new BackstagePassItem("Backstage passes to a TAFKAL80ETC concert", 13, 22, false),
            new BackstagePassItem("Backstage passes to a TAFKAL80ETC concert", 8, 50, false),
            new BackstagePassItem("Backstage passes to a TAFKAL80ETC concert", 3, 50, false),
            new DefaultItem("Conjured Mana Cake", 1, 2, true)
        );

        //WHEN
        updateGildedRose(2);

        //THEN
        IntStream.range(0, app.myItems.size()).forEach(idx ->
            assertEquals(expectedItems.get(idx), app.myItems.get(idx))
        );
    }

    void updateGildedRose(int days) {
        IntStream.range(0, days)
            .forEach(i -> app.updateQuality());
    }
}
