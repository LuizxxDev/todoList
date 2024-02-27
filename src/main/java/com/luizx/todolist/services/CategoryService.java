package com.luizx.todolist.services;

import com.luizx.todolist.model.Category;
import com.luizx.todolist.repositories.CategoriesRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoriesRepository repository;

    public CategoryService(CategoriesRepository repository){
        this.repository = repository;
    }

    public Category createNewCategory(Category category){
        return repository.save(category);
    }

    public List<Category> findAllCategories(){
        return repository.findAll(Sort.by(Sort.Order.asc("name")));
    }

    public Category findCategoryById(Long id){
        return repository.findById(id).orElseThrow(()
                -> new EntityNotFoundException("Categoria não encontrada"));
    }

    public void deleteCategoryById(Long id){
        repository.deleteById(id);
    }

}
