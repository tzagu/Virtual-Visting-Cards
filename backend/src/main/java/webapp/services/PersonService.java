package webapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webapp.models.Person;
import webapp.repositories.PersonRepository;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

@Autowired
PersonRepository personRepository;


    public void ProductService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public List<Person> findAll(){
        return personRepository.findAll();
    }

    public Optional<Person> findById(int id){
        return personRepository.findById(id);
    }

    public Person save(Person person){
        return personRepository.save(person);
    }

    public void deleteById(int id){
        personRepository.deleteById(id);
    }
}
