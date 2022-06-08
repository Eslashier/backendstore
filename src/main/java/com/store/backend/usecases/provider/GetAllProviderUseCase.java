package com.store.backend.usecases.provider;

import com.store.backend.dto.ProviderDTO;
import com.store.backend.mapper.ProviderMapper;
import com.store.backend.repository.IProviderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
@AllArgsConstructor
public class GetAllProviderUseCase {

    private final IProviderRepository iProviderRepository;
    private final ProviderMapper providerMapper;

    public Flux<ProviderDTO> getAllProviders(){
        return iProviderRepository.findAll().map(providerMapper::fromProviderToProviderDTO);
    }

}
