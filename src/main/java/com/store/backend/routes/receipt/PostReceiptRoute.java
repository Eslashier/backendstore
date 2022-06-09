package com.store.backend.routes.receipt;

import com.store.backend.dto.ReceiptDTO;
import com.store.backend.usecases.receipt.PostReceiptUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

public class PostReceiptRoute {

    @Bean
    public RouterFunction<ServerResponse> createReceipt(PostReceiptUseCase postReceiptUseCase){
        return route(POST("/v1/storeApi/createBill").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ReceiptDTO.class)
                        .flatMap(postReceiptUseCase::postReceipt)
                        .flatMap(receiptDTO -> ServerResponse.status(HttpStatus.CREATED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(receiptDTO)));
    }

}
