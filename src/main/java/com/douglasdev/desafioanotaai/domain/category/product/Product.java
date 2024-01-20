package com.douglasdev.desafioanotaai.domain.category.product;

import com.douglasdev.desafioanotaai.domain.category.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
@Getter
@Setter
@NoArgsConstructor
public class Product {

    @Id
    public String id;
    public String title;
    public String description;
    public String ownerID;
    public Integer price;
    public Category category;

    public Product (ProductDTO productDTO){
        this.title = productDTO.title();
        this.description = productDTO.description();
        this.ownerID = productDTO.ownerID();
        this.price = productDTO.price();
        this.category = productDTO.category();
    }
}
