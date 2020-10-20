package com.example.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.backend.models.Person;
import com.example.backend.repositories.PersonRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class PersonService {

@Autowired
PersonRepository personRepository;


    public void PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll(){
        List<Person> personList = personRepository.findAll();

        if(personList.size()>0){
            return personList;
        }
        else{
            return new ArrayList<Person>();
        }
    }

    public Person save(Person person){
        person =  personRepository.save(person);
        return person;
    }

    public Optional<Person> findById(int id){
        return personRepository.findById(id);
    }

    public void deleteById(int id){
        personRepository.deleteById(id);
    }

    public Person findByEmail(String email){
        return personRepository.findByEmail(email);
    }


}
