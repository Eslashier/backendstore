package com.store.backend.collection;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "bill")
public class Bill {
    @Id
    private String id;
    private String date;
    private String clientName;
    private String salesmanName;
    private List<Product> productListSale;
    private Integer totalSale;
}
