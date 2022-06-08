package com.store.backend.usecases.provider;

import com.store.backend.dto.ProviderDTO;
import com.store.backend.mapper.ProviderMapper;
import com.store.backend.repository.IProviderRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class GetAllProviderUseCase {

    private final IProviderRepository iProviderRepository;
    private final ProviderMapper providerMapper;

    public GetAllProviderUseCase(IProviderRepository iProviderRepository, ProviderMapper providerMapper) {
        this.iProviderRepository = iProviderRepository;
        this.providerMapper = providerMapper;
    }

    public Flux<ProviderDTO> getAllProviders(){
        return iProviderRepository.findAll().map(providerMapper::fromProviderToProviderDTO);
    }

}
