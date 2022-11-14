package com.javierv.itemsreview.service;

import com.javierv.itemsreview.model.Item;
import com.javierv.itemsreview.model.TitleView;
import com.javierv.itemsreview.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ItemService {
    @Autowired
    private ItemRepository repository;

    public List<String> getTitles1() {
        return repository.getTitles();
    }

    public List<TitleView> getTitles2() {
        return repository.findAllProjectedBy();
    }

    public List<Item> findByAverageRating(Double rating) {
        return repository.findByAverageRating(rating);
    }

    public List<String> findByAverageRating2(Double rating) {
        return repository.findByAverageRating2(rating);
    }

    public List<String> findByAverageRating3(Double rating) {
        List<String> list = new ArrayList<>();

        List<Item> items = repository.findByAverageRating(rating);
        for (Item i : items) {
            list.add(i.getTitle());
        }

        return list;
    }
}
