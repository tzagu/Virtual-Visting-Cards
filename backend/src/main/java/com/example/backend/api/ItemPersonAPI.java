package com.example.backend.api;

import com.example.backend.models.ItemPerson;
import com.example.backend.services.ItemPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class ItemPersonAPI {

    @Autowired
    ItemPersonService itemPersonService;

    @GetMapping("/itempersoncards")
    public ResponseEntity<List<ItemPerson>> findAll() {
        List<ItemPerson> itemPersonList = itemPersonService.findAll();
        return new ResponseEntity<List<ItemPerson>>(itemPersonList, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/itemperson/{id}")
    public ResponseEntity<Optional<ItemPerson>> findById(int id) {
        return ResponseEntity.ok(itemPersonService.findById(id));
    }
}

