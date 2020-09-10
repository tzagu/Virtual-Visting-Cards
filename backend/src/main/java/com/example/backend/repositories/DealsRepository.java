package com.example.backend.repositories;

import com.example.backend.models.Deals;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealsRepository extends JpaRepository<Deals, Integer> {
//    List<Deals> findDealBySeller(Integer sellerId);
//    List<Deals> findDealsByBuyer(Integer buyerId);
}
