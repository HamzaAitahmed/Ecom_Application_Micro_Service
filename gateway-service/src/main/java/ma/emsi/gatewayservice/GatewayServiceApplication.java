package ma.emsi.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceApplication.class, args);
    }

//
//    =====> Methode Dynamique
//
    @Bean
    public DiscoveryClientRouteDefinitionLocator DynamicRoutes(ReactiveDiscoveryClient discoveryClient,
                                                               DiscoveryLocatorProperties properties) {

        return new DiscoveryClientRouteDefinitionLocator(discoveryClient, properties);
    }

//
//    =====> Methode Static
//
//    @Bean
//    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder){
//
//        return builder.routes()
//                .route(r->r.path("/customers/**").uri("lb://customer-service")) //lb : load balancer
//                .route(r->r.path("/products/**").uri("lb://inventory-service"))
//                .build();
//
//    }
//
//    @Bean
//    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder){
//
//        return builder.routes()
//                .route(r->r.path("/customers/**").uri("http://localhost:8081/"))
//                .route(r->r.path("/products/**").uri("http://localhost:8082/"))
//                .build();
//
//    }

}
