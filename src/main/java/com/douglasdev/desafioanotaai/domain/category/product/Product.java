package com.douglasdev.desafioanotaai.domain.category.product;

import com.douglasdev.desafioanotaai.domain.category.Category;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.json.JsonObject;
import org.json.JSONObject;
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
    public String categoryId;

    public Product (ProductDTO productDTO){
        this.title = productDTO.title();
        this.description = productDTO.description();
        this.ownerID = productDTO.ownerID();
        this.price = productDTO.price();
        this.categoryId = productDTO.categoryId();
    }

    @Override
    public String toString(){
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("title", this.title);
        jsonObject.put("description", this.description);
        jsonObject.put("ownerID", this.ownerID);
        jsonObject.put("price", this.price);
        jsonObject.put("categoryId", this.categoryId);
        jsonObject.put("type", "product");


        return jsonObject.toString();

    }
}
