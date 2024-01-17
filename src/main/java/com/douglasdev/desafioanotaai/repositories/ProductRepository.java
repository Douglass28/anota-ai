package com.douglasdev.desafioanotaai.repositories;

import com.douglasdev.desafioanotaai.domain.category.product.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}
