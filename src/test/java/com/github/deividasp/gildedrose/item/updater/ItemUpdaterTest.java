package com.github.deividasp.gildedrose.item.updater;

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

}
