package com.store.backend.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document(collection = "provider")
public class Provider {
    @Id
    private String id;
    private String providerName;
    private String phone;
    private String email;
    private String passport;


}
