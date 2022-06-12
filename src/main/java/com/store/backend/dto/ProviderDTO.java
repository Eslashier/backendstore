package com.store.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProviderDTO {

    private String id;
    private String providerName;
    private String phone;
    private String email;
    private String passport;

    public ProviderDTO() {

    }
}
