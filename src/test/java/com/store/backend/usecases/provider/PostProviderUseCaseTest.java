package com.store.backend.usecases.provider;

import com.store.backend.collection.Provider;
import com.store.backend.dto.ProviderDTO;
import com.store.backend.repository.IProviderRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostProviderUseCaseTest {
    @MockBean
    private PostProviderUseCase postProviderUseCase;

    @Mock
    IProviderRepository providerRepository;

    @Test
    public void createProviderTest(){

        Provider provider = new Provider(
                "id1",
                "Provider test",
                "3336669999",
                "test@test.com",
                "123456789"
        );

        ProviderDTO providerDTO = new ProviderDTO();

        providerDTO.setId(provider.getId());
        providerDTO.setProviderName(provider.getProviderName());
        providerDTO.setPhone(provider.getPhone());
        providerDTO.setEmail(provider.getEmail());
        providerDTO.setPassport(provider.getPassport());


        StepVerifier.create(Mono.just(Mockito.when(postProviderUseCase.postProvider(providerDTO))
                        .thenReturn(Mono.just(providerDTO))))
                        .expectComplete();
    }
}