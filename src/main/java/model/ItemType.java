package model;

import java.util.Arrays;

public enum ItemType {

    AGED_BRIE("Aged Brie"),
    SULFURAS_HAND_OF_RAGNAROS("Sulfuras"),
    BACKSTAGE_PASSES("Backstage passes");

    public final String prefix;

    ItemType(String prefix) {
        this.prefix = prefix;
    }

    public static ItemType findByName(String name) {
        return Arrays.stream(values())
            .dropWhile(v -> !name.startsWith(v.prefix))
            .findFirst()
            .orElse(null);
    }
}
