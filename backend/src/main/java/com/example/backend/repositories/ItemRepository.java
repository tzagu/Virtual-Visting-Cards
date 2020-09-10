package com.example.backend.repositories;

import com.example.backend.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {
//    List<Item> findItemsByCategory(Integer categoryId);
}
