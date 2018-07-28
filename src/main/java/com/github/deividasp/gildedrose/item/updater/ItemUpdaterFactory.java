package com.github.deividasp.gildedrose.item.updater;

import com.github.deividasp.gildedrose.item.Item;
import com.github.deividasp.gildedrose.item.ItemType;

import java.util.Optional;

public class ItemUpdaterFactory {

    public static Optional<ItemUpdater> createFor(Item item) {
        ItemType itemType = ItemType.findBy(item.name);

        switch (itemType) {
            case AGED_BRIE:
                return Optional.of(new AgedBrieItemUpdater(item));

            case BACKSTAGE_PASSES:
                return Optional.of(new BackstagePassesItemUpdater(item));

            case SULFURAS:
                return Optional.of(new SulfurasItemUpdater(item));

            case CONJURED:
                return Optional.of(new ConjuredItemUpdater(item));

            case OTHER:
                return Optional.of(new DefaultItemUpdater(item));
        }

        return Optional.empty();
    }

}
