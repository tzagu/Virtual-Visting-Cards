package com.example.backend.services;


import com.example.backend.models.Deals;
import com.example.backend.repositories.DealsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DealsService {

    @Autowired
    DealsRepository dealsRepository;

    public Deals save(Deals deals){
        deals = dealsRepository.save(deals);
        return deals;
    }

    public List<Deals> findAll(){
        List<Deals> deals = dealsRepository.findAll();
        return deals;
    }

    public Optional<Deals> findById(int id){
        return dealsRepository.findById(id);
    }
}
