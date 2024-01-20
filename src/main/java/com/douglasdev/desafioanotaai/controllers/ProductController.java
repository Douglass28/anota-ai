package com.douglasdev.desafioanotaai.controllers;

import com.douglasdev.desafioanotaai.domain.category.Category;
import com.douglasdev.desafioanotaai.domain.category.CategoryDTO;
import com.douglasdev.desafioanotaai.domain.category.product.Product;
import com.douglasdev.desafioanotaai.domain.category.product.ProductDTO;
import com.douglasdev.desafioanotaai.services.ProductService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("api/product")
public class ProductController {

    private ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> insertCategory (@RequestBody ProductDTO productDTO){
        Product product =  productService.insert(productDTO);
        return ResponseEntity.ok().body(product);
    }

    @GetMapping
    public ResponseEntity<List<Product>> getAllCategory(){
        List<Product> listProduct =  this.productService.getAllProduct();
        return ResponseEntity.ok().body(listProduct);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> getCategoryById(@PathVariable("id") String id){
        Product product =  this.productService.getCategoryByid(id);
        return ResponseEntity.ok().body(product);
    }

    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Product> updateCategory(@PathVariable("id") String id,
                                                   @RequestBody ProductDTO productDTO){
        Product updateProduct = this.productService.updateCategory(id, productDTO);
        return ResponseEntity.ok().body(updateProduct);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable("id") String id){
        this.productService.deleteCategory(id);
        return ResponseEntity.noContent().build();

    }
}
