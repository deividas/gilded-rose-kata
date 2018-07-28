package com.github.deividasp.gildedrose.ws.controller;

import com.github.deividasp.gildedrose.item.Item;

import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(GildedRoseController.class)
public class GildedRoseControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GildedRoseController gildedRoseController;

    @Test
    public void getItem() throws Exception {
        Item item = new Item("Aged Brie", 10, 10);

        given(gildedRoseController.item(item.name)).willReturn(Optional.of(item));

        mockMvc.perform(get("/item/" + item.name))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.sellIn").value(item.sellIn))
                .andExpect(jsonPath("$.quality").value(item.quality));
    }

    @Test
    public void getItems() throws Exception {
        Item sulfurasItem = new Item("Sulfuras", 20, 80);
        Item conjuredItem = new Item("Conjured Mana Cake", 25, 25);

        given(gildedRoseController.items()).willReturn(Arrays.asList(sulfurasItem, conjuredItem));

        mockMvc.perform(get("/items"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].sellIn").value(sulfurasItem.sellIn))
                .andExpect(jsonPath("$[0].quality").value(sulfurasItem.quality))
                .andExpect(jsonPath("$[1].sellIn").value(conjuredItem.sellIn))
                .andExpect(jsonPath("$[1].quality").value(conjuredItem.quality));
    }

}
