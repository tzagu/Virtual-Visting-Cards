package com.example.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.backend.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer> { }
