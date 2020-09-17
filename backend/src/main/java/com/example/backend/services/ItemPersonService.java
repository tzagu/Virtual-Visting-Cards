package com.example.backend.services;

import com.example.backend.models.Item;
import com.example.backend.models.ItemPerson;
import com.example.backend.repositories.ItemPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemPersonService {

    @Autowired
    ItemPersonRepository itemPersonRepository;

    public ItemPersonService(ItemPersonRepository itemPersonRepository) {
        this.itemPersonRepository = itemPersonRepository;
    }

    public List<ItemPerson> findAll(){
        List<ItemPerson> itemPersonList = itemPersonRepository.findAll();

        return itemPersonList;
    }

    public Optional<ItemPerson> findById(int id){
        return itemPersonRepository.findById(id);
    }

    public ItemPerson save(ItemPerson itemPerson){
        itemPerson = itemPersonRepository.save(itemPerson);
        return itemPerson;
    }
}
