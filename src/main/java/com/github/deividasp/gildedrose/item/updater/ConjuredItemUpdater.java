package com.github.deividasp.gildedrose.item.updater;

import com.github.deividasp.gildedrose.item.Item;

public class ConjuredItemUpdater extends ItemUpdater {

    public ConjuredItemUpdater(Item item) {
        super(item);
    }

    @Override
    public void execute() {
        decreaseQuality(2);
        decreaseSellIn();

        if (isSellInNegative())
            decreaseQuality(2);
    }

}
