package com.github.deividasp.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    @Test
    public void testItems() {
        GildedRose gildedRose;

        for (TestItemDefinition def : TestItemDefinition.values()) {
            gildedRose = new GildedRose(new Item[] { def.toItem() });
            gildedRose.updateQuality();
            gildedRose.getItems().forEach(item -> testItem(item, def.getVersion()));
        }
    }

    private void testItem(Item item, int version) {
        TestItemDefinition.get(item.name, version).ifPresent(def -> {
            assertEquals("Incorrect sell-in for: " + def.toString(),
                    def.getExpectedSellIn(), item.sellIn);
            assertEquals("Incorrect quality for: " + def.toString(),
                    def.getExpectedQuality(), item.quality);
        });
    }

}
