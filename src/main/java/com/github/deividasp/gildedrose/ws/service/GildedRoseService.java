package com.github.deividasp.gildedrose.ws.service;

import com.github.deividasp.gildedrose.item.Item;

import java.util.List;
import java.util.Optional;

public interface GildedRoseService {

    Optional<Item> getItem(String name);

    List<Item> getItems();

}
