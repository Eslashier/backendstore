package com.store.backend.dto;

import com.store.backend.collection.Product;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReceiptDTO {

    private String id;
    private Integer units;
    private Product product;
    private String date;

    public ReceiptDTO() {

    }
}
