package com.github.deividasp.gildedrose.ws.repository;

import com.github.deividasp.gildedrose.item.Item;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class DefaultItemRepository implements ItemRepository {

    private static final List<Item> items = new ArrayList<>();

    static {
        items.add(new Item("Aged Brie", 10, 10));
        items.add(new Item("Sulfuras", 20, 20));
        items.add(new Item("Backstage Passes", 30, 30));
        items.add(new Item("Conjured Mana Cake", 40, 40));
        items.add(new Item("Dexterity Vest", 50, 50));
    }

    public Optional<Item> find(String namePrefix) {
        return items.stream()
                .filter(item -> item.name.toLowerCase().startsWith(namePrefix.toLowerCase()))
                .findFirst();
    }

    public List<Item> findAll() {
        return items;
    }

}
