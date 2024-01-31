package com.douglasdev.desafioanotaai.services;

import com.amazonaws.util.IOUtils;
import com.douglasdev.desafioanotaai.controllers.CategoryController;
import com.douglasdev.desafioanotaai.domain.category.Category;
import com.douglasdev.desafioanotaai.domain.category.CategoryDTO;
import com.douglasdev.desafioanotaai.repositories.CategoryRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.internal.matchers.Any;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.reactive.server.EntityExchangeResult;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @Mock
    private CategoryService categoryService;


    @Test
    void insert() throws IOException {

        CategoryDTO categoryDTO = new CategoryDTO("Electronics", "Electronics category", "1");

        // Chamada ao método de serviço
        Category category = categoryService.insert(categoryDTO);

        // Verificação se a categoria foi salva no banco
        Optional<Category> savedCategory = categoryRepository.findById(category.getId()); // Supondo que a chave primária é um Long

        assertTrue(savedCategory.isPresent());
        assertEquals("Electronics", savedCategory.get().getTitle());
        assertEquals("Electronics category", savedCategory.get().getDescription());
        assertEquals("1", savedCategory.get().getOwnerID());
    }

    @Test
    void getAllCategory() {

        // Dados de teste
        CategoryDTO categoryDTO1 = new CategoryDTO("Electronics", "Electronics category", "1");
        CategoryDTO categoryDTO2 = new CategoryDTO("Acessorios", "Acessorios category", "1");
        CategoryDTO categoryDTO3 = new CategoryDTO("Alimentos", "Alimentos category", "1");

        // Salvando as categorias no banco de dados
        categoryService.insert(categoryDTO1);
        categoryService.insert(categoryDTO2);
        categoryService.insert(categoryDTO3);

        // Obtendo a lista de categorias
        List<Category> categoryResult = categoryService.getAllCategory();

        // Verificando se a lista não está vazia
        Assertions.assertNotNull(categoryResult);

    }

    @Test
    void getCategoryById() {
    }

    @Test
    void updateCategory() {
    }

    @Test
    void deleteCategory() {
    }
}