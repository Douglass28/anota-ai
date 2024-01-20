package com.douglasdev.desafioanotaai.controllers;

import com.douglasdev.desafioanotaai.domain.category.Category;
import com.douglasdev.desafioanotaai.domain.category.CategoryDTO;
import com.douglasdev.desafioanotaai.services.CategoryService;
import jakarta.websocket.server.PathParam;
import jdk.jfr.ContentType;
import org.springframework.data.repository.query.Param;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/category")
public class CategoryController {


    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @PostMapping
    public ResponseEntity<Category> insertCategory (@RequestBody CategoryDTO categoryDTO){
         Category category =  categoryService.insert(categoryDTO);
         return ResponseEntity.ok().body(category);
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategory(){
        List<Category> listCategory =  this.categoryService.getAllCategory();
        return ResponseEntity.ok().body(listCategory);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Category>> getCategoryById(@PathVariable("id") String id){
        Optional<Category> category =  this.categoryService.getCategoryById(id);
        return ResponseEntity.ok().body(category);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Category> updateCategory(@PathVariable("id") String id,
                                                   @RequestBody CategoryDTO categoryDTO){
        Category updateCategory = this.categoryService.updateCategory(id, categoryDTO);
        return ResponseEntity.ok().body(updateCategory);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable("id") String id){
        this.categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();

    }


}
