package com.store.backend.dto;

import com.store.backend.collection.Provider;
import lombok.Data;

@Data
public class ProductDTO {
    private String id;
    private String name;
    private String description;
    private Integer price;
    private Integer stock;
    private Integer minimum;
    private Integer maximum;
    private Provider provider;
}
