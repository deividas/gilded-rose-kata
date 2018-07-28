package com.github.deividasp.gildedrose.item.updater;

import com.github.deividasp.gildedrose.item.Item;

public class AgedBrieItemUpdater extends ItemUpdater {

    public AgedBrieItemUpdater(Item item) {
        super(item);
    }

    @Override
    public void execute() {
        increaseQuality();
        decreaseSellIn();

        if (isSellInNegative())
            increaseQuality();
    }

}
