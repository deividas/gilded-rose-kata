package com.github.deividasp.gildedrose.item.updater;

import com.github.deividasp.gildedrose.item.Item;

public abstract class ItemUpdater {

    private static final int MIN_QUALITY = 0;
    private static final int MAX_QUALITY = 50;

    private final Item item;

    ItemUpdater(Item item) {
        this.item = item;
    }

    public abstract void execute();

    final void decreaseSellIn() {
        item.sellIn--;
    }

    final boolean isSellInLessThan(int value) {
        return item.sellIn < value;
    }

    final boolean isSellInNegative() {
        return item.sellIn < 0;
    }

    final void setQuality(int quality) {
        item.quality = quality;
    }

    final void increaseQuality() {
        increaseQuality(1);
    }

    final void increaseQuality(int increaseBy) {
        item.quality += increaseBy;

        if (item.quality > MAX_QUALITY)
            item.quality = MAX_QUALITY;
    }

    final void decreaseQuality() {
        decreaseQuality(1);
    }

    final void decreaseQuality(int decreaseBy) {
        item.quality -= decreaseBy;

        if (item.quality < MIN_QUALITY)
            item.quality = MIN_QUALITY;
    }

}
