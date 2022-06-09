package com.store.backend.routes.bill;

import com.store.backend.dto.BillDTO;
import com.store.backend.usecases.bill.GetBillUsesCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class GetBillRoute {

    @Bean
    public RouterFunction<ServerResponse> getAllBills(GetBillUsesCase getBillUsesCase){
        return route(GET("/v1/storeApi/getAllBills"), request -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(getBillUsesCase.getAllBills(), BillDTO.class)));
    }

}
