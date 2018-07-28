package com.github.deividasp.gildedrose.item.updater;

import com.github.deividasp.gildedrose.item.Item;

public class BackstagePassesItemUpdater extends ItemUpdater {

    public BackstagePassesItemUpdater(Item item) {
        super(item);
    }

    @Override
    public void execute() {
        increaseQuality();

        if (isSellInLessThan(11))
            increaseQuality();

        if (isSellInLessThan(6))
            increaseQuality();

        decreaseSellIn();

        if (isSellInNegative())
            setQuality(0);
    }

}
