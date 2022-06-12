package com.store.backend.usecases.product;

import com.store.backend.collection.Product;
import com.store.backend.collection.Provider;
import com.store.backend.dto.ProductDTO;
import com.store.backend.mapper.ProductMapper;
import com.store.backend.repository.IProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
class GetAllProductUseCaseTest {

    private GetAllProductUseCase getAllProductUseCase;

    @Autowired
    private ProductMapper productMapper;

    @Mock
    IProductRepository iProductRepository;

    @BeforeEach
    void setUp(){
        getAllProductUseCase = new GetAllProductUseCase(iProductRepository,productMapper);
    }

    @Test
    void getProductsTest(){

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

        Product product2 = new Product(
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

        Mockito.when(iProductRepository.findAll()).thenReturn(Flux.just(product,product2));
        Flux<ProductDTO> flux = getAllProductUseCase.getAllProducts();

        StepVerifier.create(flux)
                .expectNextCount(2)
                .verifyComplete();

        Mockito.verify(iProductRepository).findAll();
    }
}