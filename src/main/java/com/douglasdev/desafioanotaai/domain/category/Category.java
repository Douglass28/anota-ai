package com.douglasdev.desafioanotaai.domain.category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.json.JSONObject;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "categories")
@Getter
@Setter
@NoArgsConstructor
public class Category {

    @Id
    private String id;
    private String title;
    private String description;
    private String  ownerID;

    public Category(CategoryDTO categoryDTO){
        this.title = categoryDTO.title();
        this.description = categoryDTO.description();
        this.ownerID = categoryDTO.ownerID();
    }

    @Override
    public String toString(){
        JSONObject jsonObject = new JSONObject();

        jsonObject.put("title", this.title);
        jsonObject.put("description", this.description);
        jsonObject.put("ownerID", this.ownerID);
        jsonObject.put("type", "category");

        return jsonObject.toString();

    }
}
