package com.store.backend.usecases.product;

import com.store.backend.collection.Product;
import com.store.backend.collection.Provider;
import com.store.backend.dto.ProductDTO;
import com.store.backend.repository.IProductRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PutProductUseCaseTest {
    @MockBean
    private PutProductUseCase putProductUseCase;

    @Mock
    IProductRepository productRepository;

    @Test
    public void putProviderTest(){

        Provider provider = new Provider(
                "id1",
                "Provider test",
                "3336669999",
                "test@test.com",
                "123456789"
        );

        Product product = new Product(
                "idproduct1",
                "Product name",
                "Description of product",
                100,
                0,
                0,
                20,
                50,
                provider
        );

        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        productDTO.setStock(product.getStock());
        productDTO.setMinimumStock(product.getMinimumStock());
        productDTO.setMaximumStock(product.getMaximumStock());
        productDTO.setProvider(product.getProvider());


        StepVerifier.create(Mono.just(Mockito.when(putProductUseCase.putProduct(productDTO))
                        .thenReturn(Mono.just(productDTO))))
                .expectComplete();
    }
}