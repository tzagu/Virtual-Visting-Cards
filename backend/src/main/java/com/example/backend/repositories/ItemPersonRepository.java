package com.example.backend.repositories;

import com.example.backend.models.ItemPerson;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPersonRepository extends JpaRepository<ItemPerson, Integer> {
//    List<ItemPerson> filterByDeliveryLocation(String locationName);
//    List<ItemPerson> findByItem(Integer itemId);
}
