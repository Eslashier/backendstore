package com.store.backend.usecases.provider;

import com.store.backend.collection.Provider;
import com.store.backend.dto.ProviderDTO;
import com.store.backend.mapper.ProviderMapper;
import com.store.backend.repository.IProviderRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class GetAllProviderUseCaseTest {

    private GetAllProviderUseCase getAllProviderUseCase;

    @Autowired
    private ProviderMapper providerMapper;

    @Mock
    IProviderRepository iproviderRepository;

    @BeforeEach
    void setUp(){
        getAllProviderUseCase = new GetAllProviderUseCase(iproviderRepository,providerMapper);
    }

    @Test
    void getProviderUseCase(){

        Provider provider = new Provider(
                "id1",
                "Provider test",
                "3336669999",
                "test@test.com",
                "123456789"
        );

        Provider provider2 = new Provider(
                "id2",
                "Provider test 2",
                "3336669999",
                "test2@test.com",
                "2234567890"
        );

        Mockito.when(iproviderRepository.findAll()).thenReturn(Flux.just(provider,provider2));
        Flux<ProviderDTO> flux = getAllProviderUseCase.getAllProviders();

        StepVerifier.create(flux)
                .expectNextCount(2)
                .verifyComplete();

        Mockito.verify(iproviderRepository).findAll();
    }

}