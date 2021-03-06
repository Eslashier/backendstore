package com.store.backend.mapper;

import com.store.backend.collection.Product;
import com.store.backend.collection.Provider;
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

    public Provider fromProviderDTOToProvider(ProviderDTO providerDTO){
        return modelMapper.map(providerDTO, Provider.class);
    }

}
