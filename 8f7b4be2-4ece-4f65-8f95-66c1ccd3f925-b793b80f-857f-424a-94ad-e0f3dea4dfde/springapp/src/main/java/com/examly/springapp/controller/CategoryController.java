package com.examly.springapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.springapp.model.Category;
import com.examly.springapp.service.CategoryServiceImpl;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {  
    @Autowired
    private CategoryServiceImpl categoryService;
    @PostMapping
    public ResponseEntity<Category> createCategory(@RequestBody(required=false)Category category)
    {
        try
        {
            if(category==null||category.getCategoryName()==null||category.getCategoryName().trim().isEmpty())
            {
                return ResponseEntity.badRequest().build();
            }
            Category saved = categoryService.saveCategory(category);
            return ResponseEntity.status(HttpStatus.CREATED).body(saved);
        }
        catch(Exception e)
        {
            return ResponseEntity.badRequest().build();

        }
    }
    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories()
    {
        List<Category> categories= categoryService.getAllCategories();
        if(categories.isEmpty())
        {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(categories);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Category> getCategoryById(@PathVariable Long id)
    {
        Category category=categoryService.getCategoryById(id);
        return ResponseEntity.ok(category);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id,@RequestBody Category category)
    {
        Category updated=categoryService.updateCategory(id,category);
        return ResponseEntity.ok(updated);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id)
    {
        categoryService.deleteCategory(id);
        return ResponseEntity.ok().build();
    }
    
    @GetMapping("/page/{pageNumber}/{pageSize}")
    public ResponseEntity<Page<Category>> getCategoriesWithPagination(@PathVariable int pageNumber, @PathVariable int pageSize)
    {
        Page<Category> categories = categoryService.getCategoriesWithPagination(pageNumber, pageSize);
        return ResponseEntity.ok(categories);
    }
}
