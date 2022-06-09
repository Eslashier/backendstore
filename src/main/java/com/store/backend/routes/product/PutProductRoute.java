package com.store.backend.routes.product;

import com.store.backend.dto.ProductDTO;
import com.store.backend.usecases.product.PostProductUseCase;
import com.store.backend.usecases.product.PutProductUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;


import static org.springframework.web.reactive.function.server.RequestPredicates.PUT;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class PutProductRoute {
    @Bean
    public RouterFunction<ServerResponse> updateProduct(PutProductUseCase putProductUseCase){
        return route(PUT("/v1/storeApi/updateProduct").and(accept(MediaType.APPLICATION_JSON)),
                request -> request.bodyToMono(ProductDTO.class)
                        .flatMap(putProductUseCase::putProduct)
                        .flatMap(productDTO -> ServerResponse.status(HttpStatus.ACCEPTED)
                                .contentType(MediaType.APPLICATION_JSON)
                                .bodyValue(productDTO)));
    }
}
