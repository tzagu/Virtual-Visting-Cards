package com.example.backend.api;

import com.example.backend.models.Item;
import com.example.backend.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class ItemAPI {

    @Autowired
    ItemService itemService;

    @PostMapping("/saveitem")
    public ResponseEntity<Item> save(@Validated @RequestBody Item item){
        Item item1 = itemService.save(item);
        return new ResponseEntity<Item>(item1, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/items")
    public ResponseEntity<List<Item>> findAll(){
        List<Item> itemList = itemService.findAll();
        return new ResponseEntity<List<Item>>(itemList, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/item/{id}")
    public ResponseEntity<Optional<Item>> findById(@PathVariable int id){
        return ResponseEntity.ok(itemService.findById(id));
    }
}
