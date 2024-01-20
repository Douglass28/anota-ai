package com.douglasdev.desafioanotaai.services;

import com.douglasdev.desafioanotaai.domain.category.Category;
import com.douglasdev.desafioanotaai.domain.category.CategoryDTO;
import com.douglasdev.desafioanotaai.domain.category.CategoryException;
import com.douglasdev.desafioanotaai.repositories.CategoryRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Category> getCategoryById(String id){
       Optional<Category> category = categoryRepository.findById(id);
        return category;
    }

    public Category updateCategory(String id, CategoryDTO categoryDTO){

        Category updateCategory = this.categoryRepository.findById(id).orElseThrow(CategoryException::new);

        if (!categoryDTO.ownerID().isEmpty()) updateCategory.setOwnerID(categoryDTO.ownerID());
        if (!categoryDTO.description().isEmpty()) updateCategory.setDescription(categoryDTO.description());
        if (!categoryDTO.title().isEmpty()) updateCategory.setTitle(categoryDTO.title());

        this.categoryRepository.save(updateCategory);

        return updateCategory;

    }

    public Void deleteCategory(String id){
        Category category = this.categoryRepository.findById(id)
                .orElseThrow(CategoryException::new);

        this.categoryRepository.delete(category);

        return null;
    }
}
