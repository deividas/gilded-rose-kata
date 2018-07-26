package com.github.deividasp.gildedrose;

import java.util.Optional;
import java.util.stream.Stream;

public enum TestItemDefinition {

    // Increases in quality the older it gets
    AGED_BRIE_V1(1, "Aged Brie", 10, 9, 10, 11),

    // The quality of an item is never more than 50
    AGED_BRIE_V2(2, "Aged Brie", 10, 9, 50, 50),

    // Never has to be sold or decreases in quality
    SULFURAS_V1(1, "Sulfuras, Hand of Ragnaros", 20, 20, 20, 20),

    // Increases in quality the older it gets
    BACKSTAGE_PASSES_V1(1, "Backstage passes to a TAFKAL80ETC concert", 30, 29, 30, 31),

    // Quality increases by 2 when there are 10 days or less, but more than 5 days
    BACKSTAGE_PASSES_V2(2, "Backstage passes to a TAFKAL80ETC concert", 10, 9, 30, 32),

    // Quality increases by 3 when there are 5 days or less
    BACKSTAGE_PASSES_V3(3, "Backstage passes to a TAFKAL80ETC concert", 5, 4, 30, 33),

    // Quality drops to 0 after concert
    BACKSTAGE_PASSES_V4(4, "Backstage passes to a TAFKAL80ETC concert", 0, -1, 30, 0);

    private final int version;
    private final String name;
    private final int sellIn;
    private final int expectedSellIn;
    private final int quality;
    private final int expectedQuality;

    TestItemDefinition(int version, String name, int sellIn, int expectedSellIn, int quality, int expectedQuality) {
        this.version = version;
        this.name = name;
        this.sellIn = sellIn;
        this.expectedSellIn = expectedSellIn;
        this.quality = quality;
        this.expectedQuality = expectedQuality;
    }

    public int getVersion() {
        return version;
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

    public static Optional<TestItemDefinition> get(String name, int version) {
        return Stream.of(values())
                .filter(def -> def.name.equals(name) && def.version == version)
                .findFirst();
    }

}
