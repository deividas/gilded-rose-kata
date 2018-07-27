package com.github.deividasp.gildedrose;

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
            switch (item.name) {
                case "Aged Brie":
                    if (item.quality < 50)
                        item.quality++;

                    item.sellIn--;

                    if (item.sellIn < 0 && item.quality < 50)
                        item.quality++;
                    break;

                case "Backstage passes to a TAFKAL80ETC concert":
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

                case "Sulfuras, Hand of Ragnaros":
                    break;

                default:
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
