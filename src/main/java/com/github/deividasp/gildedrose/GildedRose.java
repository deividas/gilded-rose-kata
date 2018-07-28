package com.github.deividasp.gildedrose;

import com.github.deividasp.gildedrose.item.Item;
import com.github.deividasp.gildedrose.item.updater.ItemUpdater;
import com.github.deividasp.gildedrose.item.updater.ItemUpdaterFactory;

import java.util.Arrays;
import java.util.List;

public class GildedRose {

    /*
     * Due to exercise requirements, this property cannot be altered
     */
    private final Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            ItemUpdaterFactory.createFor(item).ifPresent(ItemUpdater::execute);
        }
    }

    public List<Item> getItems() {
        return Arrays.asList(items);
    }

}
