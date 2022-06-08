package com.store.backend.routes.product;

import com.store.backend.dto.ProductDTO;
import com.store.backend.dto.ProviderDTO;
import com.store.backend.usecases.product.GetAllProductUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetProductRoute {

    @Bean
    public RouterFunction<ServerResponse> getAllProducts(GetAllProductUseCase getAllProductUseCase){
        return route(GET("/v1/storeApi/getAllProducts"), request -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(getAllProductUseCase.getAllProducts(), ProductDTO.class)));
    }

}
