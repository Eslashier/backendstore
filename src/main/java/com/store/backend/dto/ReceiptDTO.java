package com.store.backend.dto;

import com.store.backend.collection.Product;
import com.store.backend.collection.Provider;
import lombok.Data;

@Data
public class ReceiptDTO {

    private String id;
    private String units;
    private Product product;
    private String date;
}
