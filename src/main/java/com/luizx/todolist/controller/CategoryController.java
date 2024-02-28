package com.luizx.todolist.controller;

import com.luizx.todolist.model.Category;
import com.luizx.todolist.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService service;

    public CategoryController(CategoryService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Category> createNewCategory(@RequestBody Category category){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.createNewCategory(category));
    }

    @GetMapping
    public ResponseEntity<List<Category>> listAllCategories(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listAllCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> findCategoryById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.findCategoryById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCategoryById(@PathVariable Long id){
        service.deleteCategoryById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
