package com.github.deividasp.gildedrose.ws.service;

import com.github.deividasp.gildedrose.item.Item;
import com.github.deividasp.gildedrose.ws.repository.ItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DefaultGildedRoseService implements GildedRoseService {

    @Autowired
    private ItemRepository itemRepository;

    @Override
    public Optional<Item> getItem(String namePrefix) {
        return itemRepository.find(namePrefix);
    }

    @Override
    public List<Item> getItems() {
        return itemRepository.findAll();
    }

}
