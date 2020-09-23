package com.example.backend.services;

import com.example.backend.models.Item;
import com.example.backend.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    @Autowired
    ItemRepository itemRepository;

    public Item save(Item item){
        item = itemRepository.save(item);
        return item;
    }

    public List<Item> findAll(){
        List<Item> items = itemRepository.findAll();
        return items;
    }

    public Optional<Item> findById(int id){
        return itemRepository.findById(id);
    }
}
