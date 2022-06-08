package com.store.backend.mapper;

import com.store.backend.collection.Product;
import com.store.backend.collection.Provider;
import com.store.backend.dto.ProductDTO;
import com.store.backend.dto.ProviderDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.config.EnableWebFlux;

@Component
@EnableWebFlux
public class ProviderMapper {

    private final ModelMapper modelMapper;

    public ProviderMapper(ModelMapper modelMapper){
        this.modelMapper = modelMapper;
    }

    public ProviderDTO fromProviderToProviderDTO(Provider provider){
        return modelMapper.map(provider, ProviderDTO.class);
    }

    public Product fromProviderDTOToProvider(ProviderDTO providerDTO){
        return modelMapper.map(providerDTO, Product.class);
    }

}
