package com.store.backend.usecases.provider;

import com.store.backend.dto.ProviderDTO;
import com.store.backend.mapper.ProviderMapper;
import com.store.backend.repository.IProviderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class PostProviderUseCase {
    private final IProviderRepository iProviderRepository;
    private final ProviderMapper providerMapper;
    public Mono<ProviderDTO> postProvider(ProviderDTO providerDTO){
        return iProviderRepository.save(providerMapper.fromProviderDTOToProvider(providerDTO)).map(providerMapper::fromProviderToProviderDTO);
    }

}
