package com.store.backend.collection;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.UUID;

@Data
@Document(collection = "bill")
public class Bill {
    @Id
    private String uid;
    private String clientName;
    private String salesmanName;
    private List<Product> productListSale;
    private Integer totalSale;
}
