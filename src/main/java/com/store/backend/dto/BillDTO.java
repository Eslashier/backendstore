package com.store.backend.dto;

import com.store.backend.collection.Product;
import lombok.Data;

import java.util.List;

@Data
public class BillDTO {

    private String id;
    private String date;
    private String clientName;
    private String salesmanName;
    private List<Product> productListSale;
    private Integer totalSale;

}
