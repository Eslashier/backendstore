package com.store.backend.routes.receipt;

import com.store.backend.dto.ReceiptDTO;
import com.store.backend.usecases.receipt.GetReceiptUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetReceiptRoute {

    @Bean
    public RouterFunction<ServerResponse> getAllReceipts(GetReceiptUseCase getReceiptUseCase){
        return route(GET("/v1/storeApi/getAllBills"), request -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(getReceiptUseCase.getAllReceipts(), ReceiptDTO.class)));
    }

}
