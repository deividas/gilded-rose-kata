package com.github.deividasp.gildedrose.ws.repository;

import com.github.deividasp.gildedrose.item.Item;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ItemRepository {

    Optional<Item> find(String namePrefix);

    List<Item> findAll();

}
