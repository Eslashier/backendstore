package com.store.backend.collection;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "product")
public class Product {

    @Id
    private String id;
    private String name;
    private String description;
    private Integer price;
    private Integer sold;
    private Integer stock;
    private Integer minimumStock;
    private Integer maximumStock;
    private Provider provider;

}
