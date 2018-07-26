package com.github.deividasp.gildedrose;

import java.util.Optional;
import java.util.stream.Stream;

public enum TestItemDefinition {

    AGED_BRIE_10_10("Aged Brie", 10, 9, 10, 11),
    SULFURAS_20_20("Sulfuras, Hand of Ragnaros", 20, 20, 20, 20),
    BACKSTAGE_PASSES_30_30("Backstage passes to a TAFKAL80ETC concert", 30, 29, 30, 31);

    private final String name;
    private final int sellIn;
    private final int expectedSellIn;
    private final int quality;
    private final int expectedQuality;

    TestItemDefinition(String name, int sellIn, int expectedSellIn, int quality, int expectedQuality) {
        this.name = name;
        this.sellIn = sellIn;
        this.expectedSellIn = expectedSellIn;
        this.quality = quality;
        this.expectedQuality = expectedQuality;
    }

    public String getName() {
        return name;
    }

    public int getExpectedSellIn() {
        return expectedSellIn;
    }

    public int getExpectedQuality() {
        return expectedQuality;
    }

    public Item toItem() {
        return new Item(name, sellIn, quality);
    }

    public static Optional<TestItemDefinition> get(String name) {
        return Stream.of(values()).filter(def -> def.name.equals(name)).findFirst();
    }

    public static Item[] toItemArray() {
        return Stream.of(values())
                .map(TestItemDefinition::toItem).toArray(Item[]::new);
    }

}
