package com.github.deividasp.gildedrose.item.updater;

import com.github.deividasp.gildedrose.item.Item;

public class DefaultItemUpdater extends ItemUpdater {

    public DefaultItemUpdater(Item item) {
        super(item);
    }

    @Override
    public void execute() {
        decreaseQuality();
        decreaseSellIn();

        if (isSellInNegative())
            decreaseQuality();
    }

}
