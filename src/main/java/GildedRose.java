import contract.Item;
import model.*;

import java.util.Arrays;
import java.util.List;

import static model.AbstracItem.CONJURED_PREFIX;

class GildedRose {

    List<AbstracItem> myItems;

    public GildedRose(Item[] items) {
        this.myItems = Arrays.stream(items).map(this::mapper).toList();
    }

    public void updateQuality() {
        myItems.forEach(AbstracItem::tick);
    }

    AbstracItem mapper(Item item) {
        boolean isConjured = item.name.startsWith(CONJURED_PREFIX);
        String simpleName = isConjured ? item.name.substring(CONJURED_PREFIX.length()) : item.name;
        ItemType myItemType = ItemType.findByName(simpleName);
        if (myItemType == null) {
            return new DefaultItem(item.name, item.sellIn, item.quality, isConjured);
        }

        return switch (myItemType) {
            case AGED_BRIE -> new AgedBrieItem(item.name, item.sellIn, item.quality, isConjured);
            case SULFURAS_HAND_OF_RAGNAROS -> new SulfurasItem(item.name, item.sellIn, item.quality, isConjured);
            case BACKSTAGE_PASSES -> new BackstagePassItem(item.name, item.sellIn, item.quality, isConjured);
        };
    }
}
