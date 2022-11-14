package com.javierv.itemsreview.controller;

import com.javierv.itemsreview.model.Item;
import com.javierv.itemsreview.model.TitleView;
import com.javierv.itemsreview.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController("/")
public class ItemController {
    @Autowired
    private ItemService service;

    @GetMapping("/title1")
    public List<String> getTitles1() {
        return service.getTitles1();
    }

    @GetMapping("/title2")
    public List<TitleView> getTitles2() {
        return service.getTitles2();
    }

    @GetMapping("/avg1/{rating}")
    public List<Item> findByAverageRating1(@PathVariable("rating") Double rating) {
        return service.findByAverageRating(rating);
    }

    @GetMapping("/avg2/{rating}")
    public List<String> findByAverageRating2(@PathVariable("rating") Double rating) {
        return service.findByAverageRating2(rating);
    }

    @GetMapping("/avg3/{rating}")
    public List<String> findByAverageRating3(@PathVariable("rating") Double rating) {
        return service.findByAverageRating3(rating);
    }
}
