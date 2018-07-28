package com.github.deividasp.gildedrose.item.updater;

import com.github.deividasp.gildedrose.item.TestItemDefinition;
import com.github.deividasp.gildedrose.item.Item;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ItemUpdaterTest {

    @Test
    public void testItemUpdater() {
        Item item = new Item("Test", 0, 5);

        ItemUpdater itemUpdater = new ItemUpdater(item) {

            @Override
            public void execute() { }

        };

        itemUpdater.decreaseSellIn();
        assertEquals(-1, item.sellIn);
        assertTrue(itemUpdater.isSellInLessThan(0));
        assertTrue(itemUpdater.isSellInNegative());

        itemUpdater.increaseQuality();
        assertEquals(6, item.quality);

        itemUpdater.increaseQuality(10);
        assertEquals(16, item.quality);

        itemUpdater.decreaseQuality();
        assertEquals(15, item.quality);

        itemUpdater.decreaseQuality(3);
        assertEquals(12, item.quality);

        itemUpdater.setQuality(15);
        assertEquals(15, item.quality);
    }

    @Test
    public void testAgedBrieItemUpdater() {
        TestItemDefinition def = TestItemDefinition.AGED_BRIE_V1;
        Item item = def.toItem();

        testUpdater(item, def, new AgedBrieItemUpdater(item));
    }

    @Test
    public void testBackstagePassesItemUpdater() {
        TestItemDefinition def = TestItemDefinition.BACKSTAGE_PASSES_V1;
        Item item = def.toItem();

        testUpdater(item, def, new BackstagePassesItemUpdater(item));
    }

    @Test
    public void testSulfurasItemUpdater() {
        TestItemDefinition def = TestItemDefinition.SULFURAS_V1;
        Item item = def.toItem();

        testUpdater(item, def, new SulfurasItemUpdater(item));
    }

    @Test
    public void testConjuredItemUpdater() {
        TestItemDefinition def = TestItemDefinition.CONJURED_MANA_CAKE_V1;
        Item item = def.toItem();

        testUpdater(item, def, new ConjuredItemUpdater(item));
    }

    @Test
    public void testDefaultItemUpdater() {
        TestItemDefinition def = TestItemDefinition.DEXTERITY_VEST_V1;
        Item item = def.toItem();

        testUpdater(item, def, new DefaultItemUpdater(item));
    }

    private void testUpdater(Item item, TestItemDefinition def, ItemUpdater updater) {
        updater.execute();

        assertEquals("Incorrect sell-in for: " + def.toString(),
                def.getExpectedSellIn(), item.sellIn);
        assertEquals("Incorrect quality for: " + def.toString(),
                def.getExpectedQuality(), item.quality);
    }

}
