package com.example.backend.repositories;

import com.example.backend.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer>{

//    List<Person> findByMobile(String mobile); // should fetch from mobile1 and mobile2
//    List<Person> filterByDealCount(Integer dealCount);
//    List<Person> filterByStatus(String status);

    //implement the controller methods in the com.example.backend.api class
}
