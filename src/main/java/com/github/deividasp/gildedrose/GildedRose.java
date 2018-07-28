package com.github.deividasp.gildedrose;

import com.github.deividasp.gildedrose.item.Item;
import com.github.deividasp.gildedrose.item.ItemType;

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
            ItemType itemType = ItemType.findBy(item.name);

            switch (itemType) {
                case AGED_BRIE:
                    if (item.quality < 50)
                        item.quality++;

                    item.sellIn--;

                    if (item.sellIn < 0 && item.quality < 50)
                        item.quality++;
                    break;

                case BACKSTAGE_PASSES:
                    if (item.quality < 50)
                        item.quality++;

                    if (item.sellIn <= 10 && item.quality < 50)
                        item.quality++;

                    if (item.sellIn <= 5 && item.quality < 50)
                        item.quality++;

                    item.sellIn--;

                    if (item.sellIn < 0)
                        item.quality = 0;
                    break;

                case SULFURAS:
                    break;

                case CONJURED:
                    if (item.quality > 0)
                        item.quality -= (item.quality - 1 > 0) ? 2 : 1;

                    item.sellIn--;

                    if (item.sellIn < 0 && item.quality > 0)
                        item.quality -= (item.quality - 1 > 0) ? 2 : 1;
                    break;

                case OTHER:
                    if (item.quality > 0)
                        item.quality--;

                    item.sellIn--;

                    if (item.sellIn < 0 && item.quality > 0)
                        item.quality--;
                    break;
            }
        }
    }

    public List<Item> getItems() {
        return Arrays.asList(items);
    }

}
