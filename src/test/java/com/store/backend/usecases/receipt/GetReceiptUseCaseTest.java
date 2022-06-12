package com.store.backend.usecases.receipt;

import com.store.backend.collection.Product;
import com.store.backend.collection.Provider;
import com.store.backend.collection.Receipt;
import com.store.backend.dto.ReceiptDTO;
import com.store.backend.mapper.ReceiptMapper;
import com.store.backend.repository.IReceiptRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@SpringBootTest
class GetReceiptUseCaseTest {

    private GetReceiptUseCase getReceiptUseCase;

    @Autowired
    private ReceiptMapper receiptMapper;

    @Mock
    IReceiptRepository iReceiptRepository;

    @BeforeEach
    void setUp(){
        getReceiptUseCase = new GetReceiptUseCase(iReceiptRepository,receiptMapper);
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

        Receipt receipt = new Receipt(
                "idReceipt1",
                10,
                product,
                "12/06/22"
        );

        Provider provider2 = new Provider(
                "id2",
                "Provider test2",
                "3336669999",
                "test2@test.com",
                "012345678"
        );

        Product product2 = new Product(
                "idproduct2",
                "Product name2",
                "Description of product2",
                100,
                0,
                0,
                20,
                50,
                provider2
        );

        Receipt receipt2 = new Receipt(
                "idReceipt2",
                10,
                product2,
                "12/06/22"
        );

        Mockito.when(iReceiptRepository.findAll()).thenReturn(Flux.just(receipt,receipt2));
        Flux<ReceiptDTO> flux = getReceiptUseCase.getAllReceipts();

        StepVerifier.create(flux)
                .expectNextCount(2)
                .verifyComplete();

        Mockito.verify(iReceiptRepository).findAll();
    }
}