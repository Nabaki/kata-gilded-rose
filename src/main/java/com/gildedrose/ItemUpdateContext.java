package com.gildedrose;

public class ItemUpdateContext {

    private final ItemUpdateStrategy strategy;

    public ItemUpdateContext(String itemName) {
        this.strategy = switch (itemName) {
            case "Aged Brie" -> new AgedBrieUpdateStrategy();
            case "Backstage passes to a TAFKAL80ETC concert" -> new BackstagePassUpdateStrategy();
            case "Sulfuras, Hand of Ragnaros" -> new SulfurasUpdateStrategy();
            default -> new DefaultItemUpdateStrategy();
        };
    }

    public void update(Item item) {
        strategy.update(item);
    }
}
