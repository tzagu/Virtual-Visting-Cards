package com.example.backend.api;


import com.example.backend.models.Deals;
import com.example.backend.services.DealsService;
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
public class DealsAPI {

    @Autowired
    DealsService dealsService;

    @PostMapping("/savedeal")
    public ResponseEntity<Deals> save(@Validated @RequestBody Deals deal){
        Deals deal1 = dealsService.save(deal);
        return new ResponseEntity<Deals>(deal1, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/deals")
    public ResponseEntity<List<Deals>> findAll(){
        List<Deals> deals = dealsService.findAll();
        return new ResponseEntity<List<Deals>>(deals, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/deal/{id}")
    public ResponseEntity<Optional<Deals>> findById(@PathVariable int id){
        return ResponseEntity.ok(dealsService.findById(id));
    }
}
