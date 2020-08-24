package webapp.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import webapp.models.Person;
import webapp.services.PersonService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/person")
public class PersonAPI {

    @Autowired
    PersonService personService;

    @GetMapping("/all")
    public ResponseEntity<List<Person>> findAll(){
        return ResponseEntity.ok(personService.findAll());
    }

    @GetMapping("all/{id}")
    public ResponseEntity<Optional<Person>> findById(int id){
        return ResponseEntity.ok(personService.findById(id));
    }

    @PostMapping("/all")
    public ResponseEntity<?> save(@Validated @RequestBody Person person){
        return ResponseEntity.ok(personService.save(person));
    }



}
