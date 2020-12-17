package com.example.backend.api;

import com.example.backend.repositories.PersonRepository;
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

    @Autowired
    PersonRepository personRepository;


    @PostMapping("/saveperson")
    public ResponseEntity<Person> savePerson(@Validated @RequestBody Person person){
        Person person1 = personService.save(person);
        return new ResponseEntity<Person>(person1, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping("/person/{id}")
    public ResponseEntity<Person> updatePerson(@RequestBody Person person, @PathVariable int id){
        Optional<Person> thisPerson = personRepository.findById(id);
        if(thisPerson.isPresent()){
            Person thePerson = thisPerson.get();
            thePerson.setType(person.getType());
            thePerson.setAddress(person.getAddress());
            thePerson.setMobile1(person.getMobile1());
            thePerson.setMobile2(person.getMobile2());
            thePerson.setLandline(person.getLandline());
            return new ResponseEntity<>(personRepository.save(thePerson), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/resetpw/{id}")
    public ResponseEntity<Person> resetPassword(@RequestBody Person person, @PathVariable int id){
        Optional<Person> thisPerson = personRepository.findById(id);
        if(thisPerson.isPresent()){
            Person thePerson = thisPerson.get();
            thePerson.setPassword(person.getPassword());
            return new ResponseEntity<>(personRepository.save(thePerson), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/addpartner/{id}")
    public ResponseEntity<Person> addPartner(@RequestBody Person person, @PathVariable int id){
        Optional<Person> thisPerson = personRepository.findById(id);
        if(thisPerson.isPresent()){
            Person thePerson = thisPerson.get();
            thePerson.setDeals(person.getDeals());
            return new ResponseEntity<>(personRepository.save(thePerson), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/person")
    public ResponseEntity<List<Person>> findAll(){
        List<Person> personList = personService.findAll();

        return new ResponseEntity<List<Person>>(personList, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/all/{id}")
    public ResponseEntity<Optional<Person>> findById(@PathVariable int id){
        return ResponseEntity.ok(personService.findById(id));
    }

    @GetMapping("/partner/{email:.+}")
    public ResponseEntity findByEmail(@PathVariable String email){
        Person person = personService.findByEmail(email);
        return ResponseEntity.ok(person);
    }

    @DeleteMapping("/deleteperson/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable int id){
        personRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
