package com.github.deividasp.gildedrose.item;

import java.util.Arrays;

public enum ItemType {

    AGED_BRIE,
    BACKSTAGE_PASSES,
    SULFURAS,
    CONJURED,
    OTHER;

    public String getName() {
        return name().toLowerCase().replace("_", " ");
    }

    public static ItemType findBy(String itemName) {
        return Arrays.stream(values())
                .filter(type -> type != OTHER && itemName.toLowerCase().startsWith(type.getName()))
                .findFirst()
                .orElse(OTHER);
    }

}
