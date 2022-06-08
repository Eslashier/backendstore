package com.store.backend.collection;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "receipt")
public class Receipt {
    @Id
    private String id;
    private String providerName;
    private LocalDate date;
    private Provider providerid;
}
