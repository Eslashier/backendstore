package com.store.backend.dto;

import com.store.backend.collection.Provider;
import lombok.Data;

import java.time.LocalDate;

@Data
public class ReceiptDTO {

    private String id;
    private String providerName;
    private Double units;
    private String productId;
    private LocalDate date;
    private Provider provider;
}
