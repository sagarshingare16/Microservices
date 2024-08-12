package com.microservice.circuiteB.routes;

import org.springframework.cloud.gateway.server.mvc.filter.CircuitBreakerFilterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.GatewayRouterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.ServerResponse;

import java.net.URI;

@Configuration
public class Routes {

    @Bean
    public RouterFunction<ServerResponse> greetingService() {
        return GatewayRouterFunctions.route("customer-service")
                .route(RequestPredicates.path("/customer-service/**"),
                        HandlerFunctions.http("http://localhost:8080"))
                .filter(CircuitBreakerFilterFunctions.circuitBreaker("greetServiceCircuitBreaker",
                        URI.create("forward:/fallbackRoute"))).build();
    }

    @Bean
    public RouterFunction<ServerResponse> fallbackRoute() {
        return GatewayRouterFunctions.route("fallbackRoute")
                .GET("/fallbackRoute", request->ServerResponse.status(HttpStatus.SERVICE_UNAVAILABLE)
                        .body("Service unavailable currently, try again later")).build();

    }
}
