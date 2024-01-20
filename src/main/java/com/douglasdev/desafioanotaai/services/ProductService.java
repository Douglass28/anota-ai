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
import java.util.Optional;

@Service
public class ProductService {

    private ProductRepository productRepository;
    private CategoryService categoryService;

    public ProductService (CategoryService categoryService, ProductRepository productRepository){
        this.categoryService = categoryService;
        this.productRepository = productRepository;
    }

    public Product insert(ProductDTO productDTO){
        Category category = categoryService.getCategoryById(productDTO.categoryId())
                .orElseThrow(CategoryException::new);
        Product product = new Product(productDTO);
        product.setCategory(category);
        this.productRepository.save(product);

        return product;
    }

    public List<Product> getAllProduct(){
        return this.productRepository.findAll();
    }

    public Optional<Product> getProductByid(String id){
        Optional <Product> product = productRepository.findById(id);
        return product;
    }

    public Product updateProduct(String id, ProductDTO productDTO){
        Product updateProduct = this.productRepository.findById(id)
                .orElseThrow(ProductException::new);

        if (productDTO.categoryId() != null) {
            this.categoryService.getCategoryById(productDTO.categoryId())
                    .ifPresent(updateProduct::setCategory);
        }

        if (!productDTO.title().isEmpty()) updateProduct.setTitle(productDTO.title());
        if (!productDTO.description().isEmpty()) updateProduct.setDescription(productDTO.title());
        if (!(productDTO.price() == null)) updateProduct.setPrice(productDTO.price());

        this.productRepository.save(updateProduct);

        return updateProduct;
    }

    public Void deleteProduct(String id){
        Product product = this.productRepository.findById(id)
                .orElseThrow(ProductException::new);

        this.productRepository.delete(product);

        return null;
    }
}
