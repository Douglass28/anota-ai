package com.douglasdev.desafioanotaai.services;

import com.douglasdev.desafioanotaai.domain.category.Category;
import com.douglasdev.desafioanotaai.domain.category.CategoryDTO;
import com.douglasdev.desafioanotaai.domain.category.CategoryException;
import com.douglasdev.desafioanotaai.domain.category.product.Product;
import com.douglasdev.desafioanotaai.domain.category.product.ProductDTO;
import com.douglasdev.desafioanotaai.domain.category.product.ProductException;
import com.douglasdev.desafioanotaai.repositories.CategoryRepository;
import com.douglasdev.desafioanotaai.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    public ProductService (ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    public Product insert(ProductDTO productDTO){
        Product product = new Product(productDTO);
        this.productRepository.save(product);

        return product;
    }

    public List<Product> getAllProduct(){
        return this.productRepository.findAll();
    }

    public Product getCategoryByid(String id){
        Product product = productRepository.findById(id).orElseThrow(ProductException::new);
        return product;
    }

    public Product updateCategory(String id, ProductDTO productDTO){
        Product updateProduct = this.productRepository.findById(id).orElseThrow(ProductException::new);
        updateProduct.setTitle(productDTO.title());
        updateProduct.setDescription(productDTO.description());
        updateProduct.setOwnerID(productDTO.ownerID());
        updateProduct.setCategory(productDTO.category());
        updateProduct.setPrice(productDTO.price());

        Product product = productRepository.save(updateProduct);

        return product;
    }

    public Void deleteCategory(String id){
        Product product = this.productRepository.findById(id)
                .orElseThrow(ProductException::new);

        this.productRepository.delete(product);

        return null;
    }
}
