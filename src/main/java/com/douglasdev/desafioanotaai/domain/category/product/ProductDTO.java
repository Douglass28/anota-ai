package com.douglasdev.desafioanotaai.domain.category.product;

import com.douglasdev.desafioanotaai.domain.category.Category;

public record ProductDTO(String title, String description, String ownerID, Integer price, String categoryId) {
}
