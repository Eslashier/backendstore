package com.store.backend.usecases.provider;

import com.store.backend.dto.ProviderDTO;
import com.store.backend.mapper.ProviderMapper;
import com.store.backend.repository.IProviderRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class PostProviderUseCase {
    private final IProviderRepository iProviderRepository;
    private final ProviderMapper providerMapper;

    public PostProviderUseCase(IProviderRepository iProviderRepository, ProviderMapper providerMapper) {
        this.iProviderRepository = iProviderRepository;
        this.providerMapper = providerMapper;
    }

    public Mono<ProviderDTO> postProvider(ProviderDTO providerDTO){
        return iProviderRepository.save(providerMapper.fromProviderDTOToProvider(providerDTO)).map(providerMapper::fromProviderToProviderDTO);
    }

}
