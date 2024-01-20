package com.douglasdev.desafioanotaai.services;

import com.douglasdev.desafioanotaai.domain.category.Category;
import com.douglasdev.desafioanotaai.domain.category.CategoryDTO;
import com.douglasdev.desafioanotaai.domain.category.CategoryException;
import com.douglasdev.desafioanotaai.repositories.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService (CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    public Category insert(CategoryDTO categoryDTO){
        Category category = new Category(categoryDTO);
        this.categoryRepository.save(category);

        return category;
    }

    public List<Category> getAllCategory(){
       return this.categoryRepository.findAll();
    }

    public Category getCategoryByid(String id){
        Category category = categoryRepository.findById(id).orElseThrow(CategoryException::new);
        return category;
    }

    public Category updateCategory(String id, CategoryDTO categoryDTO){
        Category updateCategory = this.categoryRepository.findById(id).orElseThrow(CategoryException::new);
        updateCategory.setTitle(categoryDTO.title());
        updateCategory.setDescription(categoryDTO.description());
        updateCategory.setOwnerID(categoryDTO.ownerID());

        Category category = categoryRepository.save(updateCategory);

        return category;
    }

    public Void deleteCategory(String id){
        Category category = this.categoryRepository.findById(id)
                .orElseThrow(CategoryException::new);

        this.categoryRepository.delete(category);

        return null;
    }
}
