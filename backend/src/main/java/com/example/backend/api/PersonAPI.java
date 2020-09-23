package com.example.backend.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import com.example.backend.models.Person;
import com.example.backend.services.PersonService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping
public class PersonAPI {

    @Autowired
    PersonService personService;


    @PostMapping("/saveperson")
    public ResponseEntity<Person> savePerson(@Validated @RequestBody Person person){
        Person person1 = personService.save(person);
        return new ResponseEntity<Person>(person1, new HttpHeaders(), HttpStatus.OK);
    }
    @GetMapping("/person")
    public ResponseEntity<List<Person>> findAll(){
        List<Person> personList = personService.findAll();

        return new ResponseEntity<List<Person>>(personList, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("all/{id}")
    public ResponseEntity<Optional<Person>> findById(@PathVariable int id){
        return ResponseEntity.ok(personService.findById(id));
    }





}
