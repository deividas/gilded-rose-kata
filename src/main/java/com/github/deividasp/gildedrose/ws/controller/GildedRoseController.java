package com.github.deividasp.gildedrose.ws.controller;

import com.github.deividasp.gildedrose.item.Item;
import com.github.deividasp.gildedrose.ws.service.GildedRoseService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class GildedRoseController {

    @Autowired
    private GildedRoseService service;

    @GetMapping("/item/{namePrefix}")
    public Optional<Item> item(@PathVariable("namePrefix") String namePrefix) {
        return service.getItem(namePrefix);
    }

    @GetMapping("/items")
    public List<Item> items() {
        return service.getItems();
    }

}
