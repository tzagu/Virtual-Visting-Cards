package com.example.backend.api;


import com.example.backend.models.Category;
import com.example.backend.repositories.CategoryRepository;
import com.example.backend.services.CategoryService;
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
public class CategoryAPI {

    @Autowired
    CategoryService categoryService;

    @Autowired
    CategoryRepository categoryRepository;

    @PostMapping("/savecategory")
    public ResponseEntity<Category> save(@Validated @RequestBody Category category){
        Category category1 = categoryService.save(category);
        return new ResponseEntity<Category>(category, new HttpHeaders(), HttpStatus.OK);
    }

    @PutMapping("/savecategory/{id}")
    public ResponseEntity<Category> updateCategory(@RequestBody Category category, @PathVariable int id){
        Optional<Category> thisCategory = categoryRepository.findById(id);
        if(thisCategory.isPresent()){
            Category theCategory = thisCategory.get();
            theCategory.setName(category.getName());
            theCategory.setItems(category.getItems());
            return new ResponseEntity<>(categoryRepository.save(theCategory), HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> findAll(){
        List<Category> categoryList = categoryService.findAll();
        return new ResponseEntity<List<Category>>(categoryList, new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<Optional<Category>> findById(@PathVariable int id){
        return ResponseEntity.ok(categoryService.findById(id));
    }
}
