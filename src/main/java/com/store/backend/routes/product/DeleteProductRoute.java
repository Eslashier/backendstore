package com.store.backend.routes.product;

import com.store.backend.usecases.product.DeleteProductUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class DeleteProductRoute {

    @Bean
    public RouterFunction<ServerResponse> deleteProductById(DeleteProductUseCase deleteProductUseCase){
        return route(DELETE("/v1/storeApi/deleteProduct/{id}").and(accept(MediaType.APPLICATION_JSON)),
            request -> deleteProductUseCase.deleteProductById(request.pathVariable("id"))
                    .flatMap(unused -> ServerResponse.status(HttpStatus.ACCEPTED).build()));
    }
}
