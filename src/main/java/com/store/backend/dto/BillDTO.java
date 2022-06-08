package com.store.backend.dto;

import com.store.backend.collection.Product;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.List;
import java.util.UUID;

@Data
public class BillDTO {

    private String id;
    private String clientName;
    private String salesmanName;
    private List<Product> productListSale;
    private Integer totalSale;

}
