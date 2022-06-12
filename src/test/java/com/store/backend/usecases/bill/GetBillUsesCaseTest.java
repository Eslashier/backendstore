package com.store.backend.usecases.bill;

import com.store.backend.collection.Bill;
import com.store.backend.collection.Product;
import com.store.backend.collection.Provider;
import com.store.backend.dto.BillDTO;
import com.store.backend.mapper.BillMapper;
import com.store.backend.repository.IBillRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class GetBillUsesCaseTest {

    private GetBillUsesCase getBillUsesCase;

    @Autowired
    private BillMapper billMapper;

    @Mock
    IBillRepository iBillRepository;

    @BeforeEach
    void setUp(){
        getBillUsesCase = new GetBillUsesCase(iBillRepository,billMapper);
    }

    @Test
    void getBillTest() {
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
                "idproduct2",
                "Product name",
                "Description of product",
                100,
                0,
                0,
                20,
                50,
                provider2
        );

        List<Product> listproducts = new ArrayList<>();
        listproducts.add(product);
        listproducts.add(product2);

        Bill bill = new Bill(
                "idbill1",
                "12/06/22",
                "Cosme",
                "Fulanito",
                listproducts,
                100
        );

        Provider provider3 = new Provider(
                "id3",
                "Provider test3",
                "3336669999",
                "test3@test.com",
                "123456789"
        );

        Provider provider4 = new Provider(
                "id4",
                "Provider test 4",
                "3336669999",
                "test4@test.com",
                "2234567890"
        );

        Product product3 = new Product(
                "idproduct3",
                "Product name",
                "Description of product",
                100,
                0,
                0,
                20,
                50,
                provider3
        );

        Product product4 = new Product(
                "idproduct4",
                "Product name",
                "Description of product",
                100,
                0,
                0,
                20,
                50,
                provider4
        );

        List<Product> listproducts2 = new ArrayList<>();
        listproducts2.add(product3);
        listproducts2.add(product4);

        Bill bill2 = new Bill(
                "idbill2",
                "12/06/22",
                "Cosme",
                "Fulanito",
                listproducts2,
                100
        );

        Mockito.when(iBillRepository.findAll()).thenReturn(Flux.just(bill, bill2));
        Flux<BillDTO> flux = getBillUsesCase.getAllBills();

        StepVerifier.create(flux)
                .expectNextCount(1)
                .verifyComplete();

        Mockito.verify(iBillRepository).findAll();
    }

}