package com.example.backend.api;

import com.example.backend.models.ItemPerson;
import com.example.backend.repositories.ItemPersonRepository;
import com.example.backend.services.ItemPersonService;
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
public class ItemPersonAPI {

    @Autowired
    ItemPersonService itemPersonService;

    @Autowired
    ItemPersonRepository itemPersonRepository;

    @GetMapping("/itempersoncards")
    public ResponseEntity<List<ItemPerson>> findAll() {
        List<ItemPerson> itemPersonList = itemPersonService.findAll();
        return new ResponseEntity<List<ItemPerson>>(itemPersonList, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/itemperson/{id}")
    public ResponseEntity<Optional<ItemPerson>> findById(@PathVariable int id) {
        return ResponseEntity.ok(itemPersonService.findById(id));
    }

    @PostMapping("/itemperson")
    public ResponseEntity<ItemPerson> saveItemPerson(@Validated @RequestBody ItemPerson itemPerson){
        ItemPerson itemPerson1 = itemPersonService.save(itemPerson);
        return new ResponseEntity<ItemPerson>(itemPerson1, new HttpHeaders(), HttpStatus.OK);

    }

    @PutMapping("/rateCard/{id}")
    public ResponseEntity<ItemPerson> addItemPersonRating(@RequestBody ItemPerson itemPerson, @PathVariable int id){
        Optional<ItemPerson> thisItemPerson = itemPersonRepository.findById(id);
        if(thisItemPerson.isPresent()){
            ItemPerson theItemPerson = thisItemPerson.get();
            theItemPerson.setRating(itemPerson.getRating());
            return new ResponseEntity<>(itemPersonRepository.save(theItemPerson), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/adddeal/{id}")
    public ResponseEntity<ItemPerson> addDeal(@RequestBody ItemPerson itemPerson, @PathVariable int id){
        Optional<ItemPerson> thisItemPerson = itemPersonRepository.findById(id);
        if(thisItemPerson.isPresent()){
            ItemPerson theItemPerson = thisItemPerson.get();
            theItemPerson.setDeals(itemPerson.getDeals());
            return new ResponseEntity<>(itemPersonRepository.save(theItemPerson), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/deleteitemperson/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id){
        itemPersonRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

