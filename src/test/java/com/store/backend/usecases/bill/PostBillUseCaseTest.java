package com.store.backend.usecases.bill;

import com.store.backend.collection.Bill;
import com.store.backend.collection.Product;
import com.store.backend.collection.Provider;
import com.store.backend.dto.BillDTO;
import com.store.backend.repository.IBillRepository;
import com.store.backend.repository.IProductRepository;
import com.store.backend.usecases.product.PostProductUseCase;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostBillUseCaseTest {

    @MockBean
    private PostBillUseCase postBillUseCase;

    @Mock
    IBillRepository iBillRepository;

    @Test
    public void createBillTest(){

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

        List<Product> products = new ArrayList<>();
        products.add(product);
        products.add(product2);

        BillDTO billDTO = new BillDTO(
                "idbill1",
                "12/06/22",
                "Cosme",
                "Fulanito",
                products,
                100
        );

        StepVerifier.create(Mono.just(Mockito.when(postBillUseCase.postBill(billDTO))
                        .thenReturn(Mono.just(billDTO))))
                        .expectComplete();
    }

}