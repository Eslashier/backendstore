package com.store.backend.usecases.receipt;

import com.store.backend.collection.Product;
import com.store.backend.collection.Provider;
import com.store.backend.collection.Receipt;
import com.store.backend.dto.ReceiptDTO;
import com.store.backend.repository.IReceiptRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@SpringBootTest
class PostReceiptUseCaseTest {

    @MockBean
    private PostReceiptUseCase postReceiptUseCase;

    @Mock
    IReceiptRepository receiptRepository;

    @Test
    public void createReceiptTest(){

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

        ReceiptDTO receiptDTO = new ReceiptDTO();
        receiptDTO.setId(receipt.getId());
        receiptDTO.setUnits(receipt.getUnits());
        receiptDTO.setProduct(receipt.getProduct());
        receiptDTO.setDate(receipt.getDate());

        StepVerifier.create(Mono.just(Mockito.when(postReceiptUseCase.postReceipt(receiptDTO))
                .thenReturn(Mono.just(receiptDTO))))
                .expectComplete();

    }

}