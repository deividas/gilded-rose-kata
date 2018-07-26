package com.github.deividasp.gildedrose;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GildedRoseTest {

    private GildedRose gildedRose;

    @Before
    public void setUp() {
        Item[] items = TestItemDefinition.toItemArray();

        gildedRose = new GildedRose(items);
    }

    @Test
    public void testItems() {
        gildedRose.updateQuality();
        gildedRose.getItems().forEach(this::testItem);
    }

    private void testItem(Item item) {
        TestItemDefinition.get(item.name).ifPresent(def -> {
            assertEquals("Incorrect sell in for: " + def.getName(), def.getExpectedSellIn(), item.sellIn);
            assertEquals("Incorrect quality for: " + def.getName(), def.getExpectedQuality(), item.quality);
        });
    }

}
