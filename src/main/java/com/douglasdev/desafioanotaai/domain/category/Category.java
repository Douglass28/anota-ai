package com.douglasdev.desafioanotaai.domain.category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collation = "categorys")
@Getter
@Setter
@NoArgsConstructor
public class Category {

    @Id
    public String id;
    public String title;
    public String description;
    public String  ownerID;
}
