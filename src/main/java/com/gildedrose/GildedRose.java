package com.gildedrose;

import java.util.Arrays;

class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateAll() {
        Arrays.stream(items)
            .forEach(item -> new ItemUpdateContext(item.name).update(item));
    }

}
