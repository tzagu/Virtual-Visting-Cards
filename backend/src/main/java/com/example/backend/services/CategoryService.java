package com.example.backend.services;

import com.example.backend.models.Category;
import com.example.backend.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category save(Category category){
        category = categoryRepository.save(category);
        return category;
    }

    public List<Category> findAll(){
        List<Category> categoryList = categoryRepository.findAll();
        return categoryList;
    }

    public Optional<Category> findById(@PathVariable int id){
        return categoryRepository.findById(id);
    }
}
