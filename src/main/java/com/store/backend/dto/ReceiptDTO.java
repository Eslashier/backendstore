package com.store.backend.dto;

import com.store.backend.collection.Provider;
import lombok.Data;

@Data
public class ReceiptDTO {

    private String id;
    private String providerName;
    private Double units;
    private String productId;
    private String date;
    private Provider provider;
}
